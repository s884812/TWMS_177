package server;

import constants.GameConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author Emilyx3
 */
public class ServerProperties {

    private static final Properties props = new Properties();

    private ServerProperties() {
    }

    static {
        loadProperties();
        /*
        try {
            try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM auth_server_channel_ip"); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    //if (rs.getString("name").equalsIgnoreCase("gms")) {
                    //    GameConstants.GMS = Boolean.parseBoolean(rs.getString("value"));
                    //} else {
                    props.put(rs.getString("name") + rs.getInt("channelid"), rs.getString("value"));
                    //}
                }
            }
        } catch (SQLException ex) {
            System.exit(0); //Big ass error.
        }
        toLoad = "world.properties";
        loadProperties(toLoad);*/

    }

    public static void loadProperties() {
        String path = System.getProperty("path", "") + "setting.ini";
        try {
            InputStream in = new FileInputStream(path);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in, "utf-8"));
            props.load(bf);
            bf.close();
        } catch (IOException ex) {
            System.out.println("讀取\"setting.ini\"檔案失敗 " + ex);
        }
    }

    public static String getProperty(String s) {
        return props.getProperty(s);
    }

    public static void setProperty(String prop, String newInf) {
        props.setProperty(prop, newInf);
    }

    public static String getProperty(String s, String def) {
        return props.getProperty(s, def);
    }
}
