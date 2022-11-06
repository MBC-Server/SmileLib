package utils;

import org.bukkit.Bukkit;
import plugins.SmilePlugin;

public class LoggerUtil {
    public static void info(SmilePlugin plugin, String message) {
        Bukkit.getLogger().info(plugin.getPrefix()+message);
    }
    public static void warning(SmilePlugin plugin, String message) {
        Bukkit.getLogger().warning(plugin.getPrefix()+message);
    }
    public static void severe(SmilePlugin plugin, String message) {
        Bukkit.getLogger().severe(plugin.getPrefix()+message);
    }



}

