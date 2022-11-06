import org.bukkit.plugin.java.JavaPlugin;

public class SmileLib {
    private static JavaPlugin plugin;

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(final JavaPlugin plugin) {
        SmileLib.plugin = plugin;
    }

}
