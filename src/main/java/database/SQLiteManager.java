package database;

import org.bukkit.plugin.java.JavaPlugin;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.*;

public class SQLiteManager {
    private static SQLiteManager instance;
    private JavaPlugin plugin;

    public SQLiteManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public Connection connect() throws SQLException {
        SQLiteConfig config = new SQLiteConfig();
        config.setSharedCache(true);
        SQLiteDataSource ds = new SQLiteDataSource(config);
        String url = plugin.getDataFolder().getAbsolutePath(); // 获取工作目录
        ds.setUrl("jdbc:sqlite:"+url+"data.db");
        return ds.getConnection();
    }

    public void disconnect (Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SQLiteManager getInstance() {
        return instance;
    }

    public static void createTable(Connection con, String name, Map<String,String> map)throws SQLException {

        String table = "create table " + name + " (";

        Set set = map.keySet();

        for (Object key : set) {
            table += key + " " + map.get(key) + ",";
        }
        table+= "ID String,";
        table = table.substring(0, table.length() - 1);
        table += ");";
        Statement stat = null;
        stat = con.createStatement();
        stat.executeUpdate(table);

    }

    public static void dropTable(Connection con,String name)throws SQLException {
        String sql = "drop table " + name + ";";
        Statement stat = null;
        stat = con.createStatement();
        stat.executeUpdate(sql);
    }

    public static void insert(Connection con,String name,Map<String,String> map)throws SQLException {
        String sql = "insert into " + name + " values(";
        Set set = map.keySet();
        for (Object key : set) {
            sql += "'" + map.get(key) + "',";
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += ");";
        Statement stat = null;
        stat = con.createStatement();
        stat.executeUpdate(sql);
    }

    public static void update(Connection con,String name,Map<String,String> map,String id)throws SQLException {
        String sql = "update " + name + " set ";
        Set set = map.keySet();
        for (Object key : set) {
            sql += key + "='" + map.get(key) + "',";
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += " where ID='" + id + "';";
        Statement stat = null;
        stat = con.createStatement();
        stat.executeUpdate(sql);
    }

    public static void delete(Connection con,String name,String id)throws SQLException {
        String sql = "delete from " + name + " where ID='" + id + "';";
        Statement stat = null;
        stat = con.createStatement();
        stat.executeUpdate(sql);
    }

    public static void select (Connection con,String name,String id)throws SQLException {
        String sql = "select * from " + name + " where ID='" + id + "';";
        Statement stat = null;
        stat = con.createStatement();
        ResultSet result = stat.executeQuery(sql);

        while (result.next()) {
            Map<String, Object> resMap = new HashMap<>();
            for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                resMap.put(result.getMetaData().getColumnName(i), result.getObject(i));
            }
        }
    }

}
