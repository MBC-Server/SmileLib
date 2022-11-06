package plugins;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SmilePlugin {
    public SmilePlugin(JavaPlugin plugin, String name, String version) {
        this.plugin = plugin;
        this.name = name;
        this.version = version;
        this.prefix = "[" + name + "] ";
    }

    Plugin plugin;
    String name;
    String prefix;
    String version;
}
