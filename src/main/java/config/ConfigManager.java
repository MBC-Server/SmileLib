package config;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ConfigManager {
    JavaPlugin plugin;
    Configuration config;
    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();
    }
    public void saveDefaultConfig() {
        plugin.saveDefaultConfig();
    }

    public void reloadConfig() {
        plugin.reloadConfig();
    }

    public void saveConfig() {
        plugin.saveConfig();
    }

    public Configuration getConfig() {
        return config;
    }
    public void set(String path, Object value) {
        config.set(path, value);
    }
    public Object get(String path) {
        return config.get(path);
    }

    public String getString(String path) {
        return config.getString(path);
    }

    public int getInt(String path) {
        return config.getInt(path);
    }

    public boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    public double getDouble(String path) {
        return config.getDouble(path);
    }

    public float getFloat(String path) {
        return (float) config.getDouble(path);
    }

    public long getLong(String path) {
        return config.getLong(path);
    }

    public short getShort(String path) {
        return (short) config.getInt(path);
    }

    public byte getByte(String path) {
        return (byte) config.getInt(path);
    }

    public List getList(String path) {
        return config.getList(path);
    }



}
