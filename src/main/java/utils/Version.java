package utils;

public class Version {
    public static boolean isVersionHigherThan(String version, String target) {
        String[] versionArray = version.split("\\.");
        String[] targetArray = target.split("\\.");
        int length = Math.max(versionArray.length, targetArray.length);
        for (int i = 0; i < length; i++) {
            int versionPart = i < versionArray.length ? Integer.parseInt(versionArray[i]) : 0;
            int targetPart = i < targetArray.length ? Integer.parseInt(targetArray[i]) : 0;
            if (versionPart < targetPart) {
                return false;
            }
            if (versionPart > targetPart) {
                return true;
            }
        }
        return true;
    }

}
