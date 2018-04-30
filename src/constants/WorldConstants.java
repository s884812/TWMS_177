package constants;

public class WorldConstants {

    public static final int gmserver = -1; // -1 = no gm server

    /**
     *
     * @Warning: World will be duplicated if it's the same as the gm server
     */
    public static enum WorldOption {

        레드(43, 10, 2, 2, (byte) 0, false, false, 19),
        판테온(40, 10, 2, 2, (byte) 0, false, false, 19),
        템페스트(39, 1, 1, 1, (byte) 0, false, false, 19),
        레이븐(38, 1, 1, 1, (byte) 0, false, false, 19),
        저스터스(37, 1, 1, 1, (byte) 0, false, false, 19),
        엘프(36, 1, 1, 1, (byte) 0, false, false, 19), //Translation: Raven
        레전드(35, 1, 1, 1, (byte) 0, false, false, 19), //Translation: Justice
        터탄(34, 1, 1, 1, (byte) 0, false, false, 19),
        카오스(33, 1, 1, 1, (byte) 0, false, false, 19),
        안드로아(32, 1, 1, 1, (byte) 0, false, false, 19), //Translation: Titan
        코스모(31, 1, 1, 1, (byte) 0, false, false, 19), //Translation: Chaos
        노바(30, 1, 1, 1, (byte) 0, false, false, 19),
        時間女神(22, 1, 1, 1, (byte) 0, false, false, 19),
        西格諾斯(21, 1, 1, 1, (byte) 0, false, false, 19),
        喵怪仙人(20, 1, 1, 1, (byte) 0, false, false, 19),
        葛雷金剛(19, 1, 1, 1, (byte) 0, false, false, 19),
        九尾妖狐(18, 1, 1, 1, (byte) 0, false, false, 19),
        寒霜冰龍(17, 1, 1, 1, (byte) 0, false, false, 19),
        泰勒熊(16, 1, 1, 1, (byte) 2, false, false, 20),
        神獸(15, 1, 1, 1, (byte) 3, false, false, 20),
        皮卡啾(14, 1, 1, 1, (byte) 0, false, false, 20),
        鯨魚號(13, 1, 1, 1, (byte) 1, false, false, 20),
        電擊象(12, 1, 1, 1, (byte) 1, false, false, 20),
        海努斯(11, 1, 1, 1, (byte) 1, false, false, 20),
        巴洛古(10, 1, 1, 1, (byte) 1, false, false, 20),
        蝴蝶精(9, 1, 1, 1, (byte) 1, false, false, 20),
        火獨眼獸(8, 1, 1, 1, (byte) 0, false, false, 20),
        木妖(7, 1, 1, 1, (byte) 0, false, false, 20),
        三眼章魚(6, 1, 1, 1, (byte) 0, false, false, 20),
        綠水靈(5, 1, 1, 1, (byte) 3, false, false, 20),
        藍寶(4, 1, 1, 1, (byte) 0, false, false, 20),
        緞帶肥肥(3, 1, 1, 1, (byte) 0, false, false, 20),
        星光精靈(2, 1, 1, 1, (byte) 0, false, false, 20),
        菇菇寶貝(1, 1, 1, 1, (byte) 0, false, false, 20),
        雪吉拉(0, 1000, 100, 1, (byte) 0, true, true, 20);
        private int world, exp, meso, drop, channels;
        private byte flag;
        private boolean show, available;
        private String worldtip = null;
        public static final byte recommended = (byte) -1; //-1 = no recommended
        public static final String recommendedmsg = recommended < 0 ? "" : "        Join " + getById(recommended).name() + ",       the newest world! (If youhave friends who play, consider joining their worldinstead. Characters can`t move between worlds.)";

        WorldOption(int world, byte flag, boolean show, int channels) {
            this.world = world;
            this.exp = 1;
            this.meso = 1;
            this.drop = 1;
            this.flag = flag;
            this.show = show;
            this.available = show;
            this.channels = channels;
        }

        WorldOption(int world, int exp, int meso, int drop, byte flag, boolean show, boolean available, int channels) {
            this.world = world;
            this.exp = exp;
            this.meso = meso;
            this.drop = drop;
            this.flag = flag;
            this.show = show;
            this.available = available;
            this.channels = channels;
        }

        WorldOption(int world, int exp, int meso, int drop, byte flag, boolean show, boolean available, int channels, String worldtip) {
            this.world = world;
            this.exp = exp;
            this.meso = meso;
            this.drop = drop;
            this.flag = flag;
            this.show = show;
            this.available = available;
            this.channels = channels;
            this.worldtip = worldtip;
        }

        public int getWorld() {
            return world;
        }

        public int getExp() {
            return exp;
        }

        public int getMeso() {
            return meso;
        }

        public int getDrop() {
            return drop;
        }

        public byte getFlag() {
            return flag;
        }

        public boolean show() {
            return show;
        }

        public boolean isAvailable() {
            return available;
        }

        public int getChannelCount() {
            return channels;
        }

        public String getWorldTip() {
            return worldtip;
        }

        public void setExp(int info) {
            exp = info;
        }

        public void setMeso(int info) {
            meso = info;
        }

        public void setDrop(int info) {
            drop = info;
        }

        public void setFlag(byte info) {
            flag = info;
        }

        public void setShow(boolean info) {
            show = info;
        }

        public void setAvailable(boolean info) {
            available = info;
        }

        public void setChannelCount(int info) {
            channels = info;
        }

        public void setWorldTip(String info) {
            worldtip = info;
        }

        public static WorldOption getById(int g) {
            for (WorldOption e : WorldOption.values()) {
                if (e.world == g) {
                    return e;
                }
            }
            return null;
        }

        public static WorldOption getByName(String g) {
            for (WorldOption e : WorldOption.values()) {
                if (e.toString().equals(g)) {
                    return e;
                }
            }
            return null;
        }

        public static boolean isExists(int id) {
            return getById(id) != null;
        }

        public static String getMainWorld() {
            String mWorld = "";
            for (WorldOption e : WorldOption.values()) {
                if (e.show == true) {
                    mWorld = e.name();
                }
            }
            return mWorld;
        }
    }

    public static String getNameById(int serverid) {
        if (!WorldOption.isExists(serverid)) {
            System.err.println("World doesn't exists exception. ID: " + serverid);
            return "";
        }
        return WorldOption.getById(serverid).name();
    }

    public static enum TespiaWorldOption {

        레드("t43", 1, 1, 1, (byte) 0, true, true, 19),
        판테온("t40", 1, 1, 1, (byte) 0, true, false, 19),
        템페스트("t39", 1, 1, 1, (byte) 0, true, false, 19),
        브로아("t3", 1, 1, 1, (byte) 0, false, false, 19), //Translation: Broa
        測試機("t0", 1, 1, 1, (byte) 0, true, false, 19);
        private final int exp, meso, drop, channels;
        private final byte flag;
        private final String world;
        private final boolean show, available;
        public static final String recommended = null;
        public static final String recommendedmsg = recommended == null ? "" : "        Join " + getById(recommended).name() + ",       the newest world! (If youhave friends who play, consider joining their worldinstead. Characters can`t move between worlds.)";

        TespiaWorldOption(String world, int exp, int meso, int drop, byte flag, boolean show, boolean available, int channels) {
            this.world = world;
            this.exp = exp;
            this.meso = meso;
            this.drop = drop;
            this.flag = flag;
            this.show = show;
            this.available = available;
            this.channels = channels;
        }

        public String getWorld() {
            return world;
        }

        public int getExp() {
            return exp;
        }

        public int getMeso() {
            return meso;
        }

        public int getDrop() {
            return drop;
        }

        public byte getFlag() {
            return flag;
        }

        public boolean show() {
            return show;
        }

        public boolean isAvailable() {
            return available;
        }

        public int getChannelCount() {
            return channels;
        }

        public static TespiaWorldOption getById(String g) {
            for (TespiaWorldOption e : TespiaWorldOption.values()) {
                if (e.world.equals(g)) {
                    return e;
                }
            }
            return null;
        }

        public static TespiaWorldOption getByName(String g) {
            for (TespiaWorldOption e : TespiaWorldOption.values()) {
                if (e.name().equals(g)) {
                    return e;
                }
            }
            return null;
        }

        public static boolean isExists(String id) {
            return getById(id) != null;
        }

        public static String getMainWorld() {
            String mWorld = "";
            for (TespiaWorldOption e : TespiaWorldOption.values()) {
                if (e.show == true) {
                    mWorld = e.name();
                }
            }
            return mWorld;
        }
    }

    public static String getTespiaNameById(String serverid) {
        if (!TespiaWorldOption.isExists(serverid)) {
            System.err.println("Tespia World doesn't exists exception. ID: " + serverid);
            return "";
        }
        return TespiaWorldOption.getById(serverid).name();
    }
}
