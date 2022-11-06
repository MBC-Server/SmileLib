package plugins;

import org.bukkit.Bukkit;
import utils.LoggerUtil;

import java.util.List;

public class PluginHook {
    Boolean papiEnabled = false;
    Boolean vaultEnabled = false;
    Boolean sparkEnabled = false;
    Boolean griefPreventionEnabled = false;


    public Boolean getPapiEnabled() {
        return papiEnabled;
    }
    public Boolean getVaultEnabled() {
        return vaultEnabled;
    }
    public Boolean getSparkEnabled() {
        return sparkEnabled;
    }
    public Boolean getGriefPreventionEnabled() {
        return griefPreventionEnabled;
    }

    public void check(List<String> string) {
        for(String s : string) {
            if(s.equalsIgnoreCase("PlaceholderAPI")) {
                if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                    LoggerUtil.info(SmileLib.getPlugin(), "已加載PlaceholderAPI");
                    papiEnabled = true;
                }else {
                    LoggerUtil.warning(SmileLib.getPlugin(), "未加載PlaceholderAPI，請檢察PlaceholderAPI是否已安裝");
                    papiEnabled = false;
                }
            }
            if(s.equalsIgnoreCase("Vault")) {
                if(Bukkit.getPluginManager().isPluginEnabled("Vault")) {
                    LoggerUtil.info(SmileLib.getPlugin(), "已加載Vault");
                    vaultEnabled = true;
                }else {
                    LoggerUtil.warning(SmileLib.getPlugin(), "未加載Vault，請檢察Vault是否已安裝");
                    vaultEnabled = false;
                }
            }
            if(s.equalsIgnoreCase("Spark")) {
                if(Bukkit.getPluginManager().isPluginEnabled("Spark")) {
                    LoggerUtil.info(SmileLib.getPlugin(), "已加載Spark");
                    sparkEnabled = true;
                }else {
                    LoggerUtil.warning(SmileLib.getPlugin(), "未加載Spark，請檢察Spark是否已安裝");
                    sparkEnabled = false;
                }
            }
            if(s.equalsIgnoreCase("GriefPrevention")) {
                if(Bukkit.getPluginManager().isPluginEnabled("GriefPrevention")) {
                    LoggerUtil.info(SmileLib.getPlugin(), "已加載GriefPrevention");
                    griefPreventionEnabled = true;
                }else {
                    LoggerUtil.warning(SmileLib.getPlugin(), "未加載GriefPrevention，請檢察GriefPrevention是否已安裝");
                    griefPreventionEnabled = false;
                }
            }
        }
    }
}
