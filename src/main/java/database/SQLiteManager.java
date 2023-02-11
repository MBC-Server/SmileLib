package database;

import org.bukkit.plugin.java.JavaPlugin;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;

public class SQLiteManager {
    private static SQLiteManager instance;
    private JavaPlugin plugin;

    public SQLiteManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public Connection connect() throws SQLException {
        SQLiteConfig config = new SQLiteConfig();
        config.setSharedCache(true);
        config.enableRecursiveTriggers(true);
        SQLiteDataSource ds = new SQLiteDataSource(config);
        //⭐你可以命名"jdbc:sqlite:"后面的数据库文件名称，程序运行时若无此文件，会自动创建
        String url = plugin.getDataFolder().getAbsolutePath(); // 获取工作目录
        ds.setUrl("jdbc:sqlite:"+url+"data.db");
        return ds.getConnection();
    }

    public static SQLiteManager getInstance() {
        return instance;
    }

    public static void createTable(Connection con, String name, Map<String,String> map)throws SQLException {

        String table = "create table NUMBERS (";

        Set set = map.keySet();

        for (Object key : set) {
            table += key + " " + map.get(key) + ",";
        }

        String sql = "DROP TABLE IF EXISTS "+ name +" ;create table NUMBERS (key String, value String); ";
        Statement stat = null;
        stat = con.createStatement();
        stat.executeUpdate(sql);

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

    public static void update(Connection con,String name,Map<String,String> map)throws SQLException {
        String sql = "update " + name + " set ";
        Set set = map.keySet();
        for (Object key : set) {
            sql += key + "='" + map.get(key) + "',";
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += ";";
        Statement stat = null;
        stat = con.createStatement();
        stat.executeUpdate(sql);
    }

}
