package constants;

import java.net.InetAddress;
import java.util.Calendar;
import server.ServerProperties;
import tools.Triple;

public class ServerConstants {

    public static String SQL_IP = ServerProperties.getProperty("sql_ip", "127.0.0.1"),
            SQL_PORT = ServerProperties.getProperty("sql_port", "3306"),
            SQL_DATABASE = ServerProperties.getProperty("sql_db", "FunTMS"),
            SQL_USER = ServerProperties.getProperty("sql_user", "root"),
            SQL_PASSWORD = ServerProperties.getProperty("sql_password", "root"); //8df97d5582af803

    public static byte Class_Bonus_EXP(final int job) {
        switch (job) {
            case 501:
            case 530:
            case 531:
            case 532:
            case 2300:
            case 2310:
            case 2311:
            case 2312:
            case 3100:
            case 3110:
            case 3111:
            case 3112:
            case 11212:
            case 800:
            case 900:
            case 910:
                return 10;
        }
        return 0;
    }

    public static boolean getEventTime() {
        int time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        switch (Calendar.DAY_OF_WEEK) {
            case 1:
                return time >= 1 && time <= 5;
            case 2:
                return time >= 4 && time <= 9;
            case 3:
                return time >= 7 && time <= 12;
            case 4:
                return time >= 10 && time <= 15;
            case 5:
                return time >= 13 && time <= 18;
            case 6:
                return time >= 16 && time <= 21;
        }
        return time >= 19 && time <= 24;
    }

    // GMS stuff
    public static final boolean TESPIA = false;
    public static final short MAPLE_VERSION = (short) 177;
    public static final String MAPLE_PATCH = "2";
    public static final MapleType MAPLE_TYPE = MapleType.台港澳;//如果是測試機這裡不需要改,只要改TESPIA就可以了
    public static final String MAIN_WORLD = TESPIA ? WorldConstants.TespiaWorldOption.getMainWorld() : WorldConstants.WorldOption.getMainWorld();
    public static final byte[] Gateway_IP = new byte[]{(byte) 127, (byte) 0, (byte) 0, (byte) 1};

    // Server stuff
    public static final boolean BLOCK_CS = false;
    public static final boolean Old_Maps = false;
    public static final boolean Use_Localhost = false;
    public static final boolean Redirector = true;
    public static boolean LOG_SHARK = Boolean.parseBoolean(ServerProperties.getProperty("logShark", "false"));
    public static final int SHARK_VERSION = 0x2021;
    public static boolean MultiLevel = false;
    public static final boolean AntiKS = false;
    public static final int miracleRate = 1;
    public static final byte SHOP_DISCOUNT = 0;
    public static boolean isBetaForAdmins = false;//是否Beta版,若是創建的角色都是伺服器管理員
    public static boolean feverTime = false; // Forever Time!! 咒語的痕跡用的
    public static Triple<String, Integer, Boolean>[] backgrounds = new Triple[]{ //boolean for randomize
        new Triple<>("20140430/0", 1, false),
        new Triple<>("20140326/0", 0, false),
        new Triple<>("20140326/1", 0, false)
    };

    public static final byte[] getGateway_IP() {
        try {
            final InetAddress inetAddr = InetAddress.getByName(ServerConfig.interface_);
            byte[] addr = inetAddr.getAddress();
            return addr;
        } catch (Exception e) {
            return Gateway_IP;
        }
    }

    public static enum MapleType {

        UNKNOWN(-1, "UTF-8"),
        한국(1, "EUC_KR"),
        한국_TEST(2, "EUC_KR"),
        日本(3, "Shift_JIS"),
        中国(4, "GB18030"),
        TEST(5),
        台港澳(6, "BIG5-HKSCS"),
        SEA(7, "UTF-8"),
        GLOBAL(8, "UTF-8"),
        BRAZIL(9, "UTF-8");
        byte type;
        final String ascii;

        private MapleType(int type, String ascii) {
            this.type = (byte) type;
            this.ascii = ascii;
        }

        private MapleType(int type) {
            this.type = (byte) type;
            this.ascii = null;
        }

        public byte getType() {
            return type;
        }

        public String getAscii() {
            return ascii;
        }

        public void setType(int type) {
            this.type = (byte) type;
        }

        public static MapleType getByType(byte type) {
            for (MapleType l : MapleType.values()) {
                if (l.getType() == type) {
                    return l;
                }
            }
            return UNKNOWN;
        }

    }

    public static enum PlayerGMRank {

        NORMAL(new char[]{'/', '@'}, 0),
        INTERN(new char[]{'/', '!', '！'}, 1),
        GM(new char[]{'/', '!', '！'}, 2),
        SUPERGM(new char[]{'/', '!', '！'}, 3),
        ADMIN(new char[]{'/', '!', '！'}, 4);

        private final char[] commandPrefix;
        private final int level;

        private PlayerGMRank(char[] chs, int level) {
            commandPrefix = chs;
            this.level = level;
        }

        public char[] getCommandPrefix() {
            return commandPrefix;
        }

        public int getLevel() {
            return level;
        }

        public static PlayerGMRank getByLevel(int level) {
            for (PlayerGMRank i : PlayerGMRank.values()) {
                if (i.getLevel() == level) {
                    return i;
                }
            }
            return PlayerGMRank.NORMAL;
        }
    }

    public static enum CommandType {

        NORMAL(0),
        TRADE(1);
        private final int level;

        CommandType(int level) {
            this.level = level;
        }

        public int getType() {
            return level;
        }
    }

    static {
        if (TESPIA) {
            MAPLE_TYPE.setType(5);
        }
    }
}
