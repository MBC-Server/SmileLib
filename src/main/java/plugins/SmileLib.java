package plugins;

public class SmileLib {
    private static SmilePlugin plugin;

    public static SmilePlugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(final SmilePlugin plugin) {
        SmileLib.plugin = plugin;
    }

}
