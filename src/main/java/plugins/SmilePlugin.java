package plugins;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SmilePlugin {
    public Plugin getPlugin() {
        return plugin;
    }

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    Plugin plugin;
    String name;
    String prefix;
    String version;

    public SmilePlugin(JavaPlugin plugin, String name, String version) {
        this.plugin = plugin;
        this.name = name;
        this.version = version;
        this.prefix = "[" + name + "] ";
    }




}
