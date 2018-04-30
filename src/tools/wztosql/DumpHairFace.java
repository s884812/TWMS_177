/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.wztosql;

import database.DatabaseConnection;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.ServerProperties;
import tools.StringUtil;

/**
 *
 * @author Itzik
 */
public class DumpHairFace {

    private final Connection con = DatabaseConnection.getConnection();
    private static final Map<Integer, String> chrNames = new HashMap<>();

    public static void main(String[] args) {
        try {
            System.setProperty ("wzpath", (System.getProperty("path") != null ? System.getProperty("path") : "") + ServerProperties.getProperty("wzpath"));
            DumpHairFace dump = new DumpHairFace();
            System.out.println("正在轉存髮型數據到MySQL......");
            dump.dumpHairFaceData("Hair");
            System.out.println("正在轉存臉型數據到MySQL......");
            dump.dumpHairFaceData("Face");
            System.out.println("轉存結束。");
        } catch (SQLException ex) {
            Logger.getLogger(DumpHairFace.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dumpHairFaceData(String type) throws SQLException {
        File dataFile = new File(System.getProperty("wzpath") + "/Character.wz/" + type);
        File strDataFile = new File(System.getProperty("wzpath") + "/String.wz");
        MapleDataProvider chrData = MapleDataProviderFactory.getDataProvider(dataFile);
        MapleDataProvider stringDataWZ = MapleDataProviderFactory.getDataProvider(strDataFile);
        MapleData chrStringData = stringDataWZ.getData("Eqp.img").getChildByPath("Eqp/" + type);
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM `wz_" + type.toLowerCase() + "data`")) {
            ps.execute();
        }
        for (MapleData c : chrStringData) {
            int chrid = Integer.parseInt(c.getName());
            String n = StringUtil.getLeftPaddedStr(chrid + ".img", '0', 12);
            try {
                if (chrData.getData(n) != null) {
                    String name = MapleDataTool.getString("name", c, "无");
                    chrNames.put(chrid, name);
                }
            } catch (NullPointerException e) {
            } catch (RuntimeException e) {
            }
        }
        for (int key : chrNames.keySet()) {
            try {
                try (PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO `wz_" + type.toLowerCase() + "data` (`" + type.toLowerCase() + "id`, `name`) VALUES (?, ?)")) {
                    ps.setInt(1, key);
                    ps.setString(2, chrNames.get(key));
                    ps.execute();
                }
                System.out.println("鍵值: " + key + " 名稱: " + chrNames.get(key));
            } catch (SQLException ex) {
                System.out.println("保存鍵值錯誤：" + key);
            }
        }
        chrNames.clear();
    }
}
