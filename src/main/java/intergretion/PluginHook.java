package intergretion;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import utils.Logger;

public class PluginHook {

    private final String name;
    private boolean enabled;
    private JavaPlugin plugin;

    public PluginHook(String name) {
        this.name = name;
    }

    public boolean enable() {
        if (Bukkit.getPluginManager().getPlugin(name) != null) {
            enabled = true;
            plugin = (JavaPlugin) Bukkit.getPluginManager().getPlugin(name);
            return true;
        } else {
            return false;
        }
    }

    public boolean isEnabled() {
        return enabled;
    }
    public JavaPlugin getPlugin() {
        return plugin;
    }


}
