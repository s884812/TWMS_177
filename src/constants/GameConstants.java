package constants;

import client.MapleBuffStat;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleJob;
import client.MonsterStatus;
import client.PlayerStats;
import client.Skill;
import client.SkillFactory;
import client.inventory.Equip;
import client.inventory.MapleInventoryType;
import client.inventory.MapleWeaponType;
import database.DatabaseConnection;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.MapleItemInformationProvider;
import server.MapleStatEffect;
import server.Randomizer;
import server.StructItemOption;
import server.maps.MapleMapObjectType;
import tools.FileoutputUtil;
import tools.Pair;
import tools.packet.CField;

public class GameConstants {

    public static final Map<Integer, String> faceList = new HashMap<>();
    public static final Map<Integer, String> hairList = new HashMap<>();
    public static final List<MapleMapObjectType> rangedMapobjectTypes = Collections.unmodifiableList(Arrays.asList(
            MapleMapObjectType.ITEM,
            MapleMapObjectType.MONSTER,
            MapleMapObjectType.DOOR,
            MapleMapObjectType.REACTOR,
            MapleMapObjectType.SUMMON,
            MapleMapObjectType.NPC,
            MapleMapObjectType.MIST,
            MapleMapObjectType.FAMILIAR,
            MapleMapObjectType.EXTRACTOR));
    private static final long[] exp = new long[251];
    private static final int[] closeness = {0, 1, 3, 6, 14, 31, 60, 108, 181, 287, 434, 632, 891, 1224, 1642, 2161, 2793,
        3557, 4467, 5542, 6801, 8263, 9950, 11882, 14084, 16578, 19391, 22547, 26074,
        30000};
    private static final int[] setScore = {0, 10, 100, 300, 600, 1000, 2000, 4000, 7000, 10000};
    private static final int[] cumulativeTraitExp = {0, 20, 46, 80, 124, 181, 255, 351, 476, 639, 851, 1084,
        1340, 1622, 1932, 2273, 2648, 3061, 3515, 4014, 4563, 5128,
        5710, 6309, 6926, 7562, 8217, 8892, 9587, 10303, 11040, 11788,
        12547, 13307, 14089, 14883, 15689, 16507, 17337, 18179, 19034, 19902,
        20783, 21677, 22584, 23505, 24440, 25399, 26362, 27339, 28331, 29338,
        30360, 31397, 32450, 33519, 34604, 35705, 36823, 37958, 39110, 40279,
        41466, 32671, 43894, 45135, 46395, 47674, 48972, 50289, 51626, 52967,
        54312, 55661, 57014, 58371, 59732, 61097, 62466, 63839, 65216, 66597,
        67982, 69371, 70764, 72161, 73562, 74967, 76376, 77789, 79206, 80627,
        82052, 83481, 84914, 86351, 87792, 89237, 90686, 92139, 93596, 96000};
    private static final int[] mobHpVal = {0, 15, 20, 25, 35, 50, 65, 80, 95, 110, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350,
        375, 405, 435, 465, 495, 525, 580, 650, 720, 790, 900, 990, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800,
        1900, 2000, 2100, 2200, 2300, 2400, 2520, 2640, 2760, 2880, 3000, 3200, 3400, 3600, 3800, 4000, 4300, 4600, 4900, 5200,
        5500, 5900, 6300, 6700, 7100, 7500, 8000, 8500, 9000, 9500, 10000, 11000, 12000, 13000, 14000, 15000, 17000, 19000, 21000, 23000,
        25000, 27000, 29000, 31000, 33000, 35000, 37000, 39000, 41000, 43000, 45000, 47000, 49000, 51000, 53000, 55000, 57000, 59000, 61000, 63000,
        65000, 67000, 69000, 71000, 73000, 75000, 77000, 79000, 81000, 83000, 85000, 89000, 91000, 93000, 95000, 97000, 99000, 101000, 103000,
        105000, 107000, 109000, 111000, 113000, 115000, 118000, 120000, 125000, 130000, 135000, 140000, 145000, 150000, 155000, 160000, 165000, 170000, 175000, 180000,
        185000, 190000, 195000, 200000, 205000, 210000, 215000, 220000, 225000, 230000, 235000, 240000, 250000, 260000, 270000, 280000, 290000, 300000, 310000, 320000,
        330000, 340000, 350000, 360000, 370000, 380000, 390000, 400000, 410000, 420000, 430000, 440000, 450000, 460000, 470000, 480000, 490000, 500000, 510000, 520000,
        530000, 550000, 570000, 590000, 610000, 630000, 650000, 670000, 690000, 710000, 730000, 750000, 770000, 790000, 810000, 830000, 850000, 870000, 890000, 910000};
    private static final int[] pvpExp = {0, 3000, 6000, 12000, 24000, 48000, 960000, 192000, 384000, 768000};
    private static final int[] guildexp = {0, 20000, 160000, 540000, 1280000, 2500000, 4320000, 6860000, 10240000, 14580000};
    private static final int[] mountexp = {0, 6, 25, 50, 105, 134, 196, 254, 263, 315, 367, 430, 543, 587, 679, 725, 897, 1146, 1394, 1701, 2247,
        2543, 2898, 3156, 3313, 3584, 3923, 4150, 4305, 4550};
    public static final int[] itemBlock = {4001168, 5220013, 3993003, 2340000, 2049100, 4001129, 2040037, 2040006, 2040007, 2040303, 2040403, 2040506, 2040507, 2040603, 2040709, 2040710, 2040711, 2040806, 2040903, 2041024, 2041025, 2043003, 2043103, 2043203, 2043303, 2043703, 2043803, 2044003, 2044103, 2044203, 2044303, 2044403, 2044503, 2044603, 2044908, 2044815, 2044019, 2044703};
    public static final int[] cashBlock = {5062000, 5062001, 5062002, 5062003, 5062005, 5062500, 5610000, 5610001, 5640000, 2531000, 2530000,
        5534000, 5050000, 5510000, 5521000, 5062200, 5062201, 5133000, 5520001, 5030000, 5030001, 5030006,
        5470000, 1122121, 5155000, 5062400, 5700000, 1112909, 5450005, 5040004, 5220000, 5050000, 5062000,
        5062001, 5062002, 5062003, 5211046, 5360000, 5051001, 5590000};
    public static final int[] rankC = {70000000, 70000001, 70000002, 70000003, 70000004, 70000005, 70000006, 70000007, 70000008, 70000009, 70000010, 70000011, 70000012, 70000013};
    public static final int[] rankB = {70000014, 70000015, 70000016, 70000017, 70000018, 70000021, 70000022, 70000023, 70000024, 70000025, 70000026};
    public static final int[] rankA = {70000027, 70000028, 70000029, 70000030, 70000031, 70000032, 70000033, 70000034, 70000035, 70000036, 70000039, 70000040, 70000041, 70000042};
    public static final int[] rankS = {70000043, 70000044, 70000045, 70000047, 70000048, 70000049, 70000050, 70000051, 70000052, 70000053, 70000054, 70000055, 70000056, 70000057, 70000058, 70000059, 70000060, 70000061, 70000062};
    public static final int[] circulators = {2700000, 2700100, 2700200, 2700300, 2700400, 2700500, 2700600, 2700700, 2700800, 2700900, 2701000};
    public static final int JAIL = 180000004, MAX_BUFFSTAT = 15, MAX_MOBSTAT = 3;
    public static final int[] blockedSkills = {4341003};
    public static final String[] RESERVED = {"Apocryphal", "MechAviv"};
    public static final String[] stats = {"tuc", "reqLevel", "reqJob", "reqSTR", "reqDEX", "reqINT", "reqLUK", "reqPOP", "cash", "cursed", "success", "setItemID", "equipTradeBlock", "durability", "randOption", "randStat", "masterLevel", "reqSkillLevel", "elemDefault", "incRMAS", "incRMAF", "incRMAI", "incRMAL", "canLevel", "skill", "charmEXP", "limitedLv", "imdR", "bdR", "superiorEqp", "maxSuperiorEqp", "recover"};
    public static final int[] hyperTele = {10000, 20000, 30000, 40000, 50000, 1000000, 1010000, 1020000, 2000000, //Maple Island
        104000000, 104010000, 104010100, 104010200, 104020000, 103010100, 103010000, 103000000, 103050000, 103020000, 103020020, 103020100, 103020200, 103020300, 103020310, 103020320, 103020400, 103020410, 103020420, 103030000, 103030100, 103030200, 103030300, 103030400, 102000000, 102010000, 102010100, 102020000, 102020100, 102020200, 102020300, 102020400, 102020500, 102040000, 102040100, 102040200, 102040300, 102040400, 102040500, 102040600, 102030000, 102030100, 102030200, 102030300, 102030400, 101000000, 101010000, 101010100, 101020000, 101020100, 101020200, 101020300, 101030000, 101030100, 101030200, 101030300, 101030400, 101030500, 101030101, 101030201, 101040000, 101040100, 101040200, 101040300, 101040310, 101040320, 101050000, 101050400, 100000000, 100010000, 100010100, 100020000, 100020100, 100020200, 100020300, 100020400, 100020500, 100020401, 100020301, 100040000, 100040100, 100040200, 100040300, 100040400, 100020101, 106020000, 120010100, 120010000, 120000000, 120020000, 120020100, 120020200, 120020300, 120020400, 120020500, 120020600, 120020700, 120030000, 120030100, 120030200, 120030300, 120030400, 120030500, //Victoria Island
        105000000, 105010000, 105010100, 105020000, 105020100, 105020200, 105020300, 105020400, 105020500, 105030000, 105030100, 105030200, 105030300, 105030400, 105030500, 105100000, 105100100, //Sleepy Wood
        120000100, 120000101, 120000102, 120000103, 120000104, 120000201, 120000202, 120000301, //Nautilus
        103040000, 103040100, 103040101, 103040102, 103040103, 103040200, 103040201, 103040202, 103040203, 103040300, 103040301, 103040302, 103040303, 103040400, //Kerning Square
        200000000, 200010000, 200010100, 200010110, 200010120, 200010130, 200010111, 200010121, 200010131, 200010200, 200010300, 200010301, 200010302, 200020000, 200030000, 200040000, 200050000, 200060000, 200070000, 200080000, 200000100, 200000200, 200000300, 200100000, 200080100, 200080200, 200081500, 200082200, 200082300, 211000000, 211000100, 211000200, 211010000, 211020000, 211030000, 211040000, 211050000, 211040100, 211040200, 921120000, //Orbis
        211040300, 211040400, 211040500, 211040600, 211040700, 211040800, 211040900, 211041000, 211041100, 211041200, 211041300, 211041400, 211041500, 211041600, 211041700, 211041800, 211041900, 211042000, 211042100, 211042200, 211042300, 211042400, 280030000, 211060000, //Dead Mine
        211060010, 211060100, 211060200, 211060201, 211060300, 211060400, 211060401, 211060410, 211060500, 211060600, 211060601, 211060610, 211060620, 211060700, 211060800, 211060801, 211060810, 211060820, 211060830, 211060900, 211061000, 211061001, 211070000, //Lion King's Castle
        220000000, 220000100, 220000300, 220000400, 220000500, 220010000, 220010100, 220010200, 220010300, 220010400, 220010500, 220010600, 220010700, 220010800, 220010900, 220011000, 220020000, 220020100, 220020200, 220020300, 220020400, 220020500, 220020600, 220030100, 220030200, 220030300, 220030400, 220030000, 220040000, 220040100, 220040200, 220040300, 220040400, 220050000, 220050100, 220050200, 221023200, 221022300, 221022200, 221021700, 221021600, 221021100, 221020000, 221000000, 221030000, 221030100, 221030200, 221030300, 221030400, 221030500, 221030600, 221040000, 221040100, 221040200, 221040300, 221040400, 222000000, 222010000, 222010001, 222010002, 222010100, 222010101, 222010102, 222010200, 222010201, 222010300, 222010400, 222020300, 222020200, 222020100, 222020000, //Ludas Lake
        220050300, 220060000, 220060100, 220060200, 220060300, 220060400, 220070000, 220070100, 220070200, 220070300, 220070400, 220080000, 220080001, //Clock Tower Lower Floor
        300000100, 300000000, 300010000, 300010100, 300010200, 300010400, 300020000, 300020100, 300020200, 300030000, 300030100, 300010410, 300020210, 300030200, 300030300, 300030310, //Ellin Forest
        230010000, 230010100, 230010200, 230010201, 230010300, 230010400, 230020000, 230020100, 230020200, 230020201, 230020300, 230030000, 230030100, 230030101, 230030200, 230040000, 230040100, 230040200, 230040300, 230040400, 230040410, 230040420, 230000000, //Aqua Road
        250000000, 250000100, 250010000, 250010100, 250010200, 250010300, 250010301, 250010302, 250010303, 250010304, 250010400, 250010500, 250010501, 250010502, 250010503, 250010600, 250010700, 250020000, 250020100, 250020200, 250020300, 251000000, 251000100, 251010000, 251010200, 251010300, 251010400, 251010401, 251010402, 251010403, 251010500, //Mu Lung Garden
        240010100, 240010200, 240010300, 240010400, 240010500, 240010600, 240010700, 240010800, 240010900, 240011000, 240020000, 240020100, 240020101, 240020200, 240020300, 240020400, 240020401, 240020500, 240030000, 240030100, 240030101, 240030102, 240030200, 240030300, 240040000, 240040100, 240040200, 240040300, 240040400, 240040500, 240040510, 240040511, 240040520, 240040521, 240040600, 240040700, 240050000, 240010000, 240000000, //Minar Forest
        240070000, 240070010, 240070100, 240070200, 240070300, 240070400, 240070500, 240070600, //Neo City
        260010000, 260010100, 260010200, 260010300, 260010400, 260010500, 260010600, 260010700, 260020000, 260020100, 260020200, 260020300, 260020400, 260020500, 260020600, 260020610, 260020620, 260020700, 261000000, 260000000, 926010000, 261010000, 261010001, 261010002, 261010003, 261010100, 261010101, 261010102, 261010103, 261020000, 261020100, 261020200, 261020300, 261020400, 261020500, 261020600, 261020700, 260000300, 260000200, //Nihal Desert
        270000000, 270000100, 270010000, 270010100, 270010110, 270010111, 270010200, 270010210, 270010300, 270010310, 270010400, 270010500, 270020000, 270020100, 270020200, 270020210, 270020211, 270020300, 270020310, 270020400, 270020410, 270020500, 270030000, 270030100, 270030110, 270030200, 270030210, 270030300, 270030310, 270030400, 270030410, 270030411, 270030500, 270040000, 270050000, //Temple of Time
        271000000, 271000100, 271000200, 271000210, 271000300, 271020000, 271020100, 271010000, 271010100, 271010200, 271010300, 271010301, 271010400, 271010500, 271030000, 271030100, 271030101, 271030102, 271030200, 271030201, 271030300, 271030310, 271030320, 271030400, 271030410, 271030500, 271030510, 271030520, 271030530, 271030540, 271030600, 271040000, 271040100, //Gate of Future
        130000000, 130000100, 130000110, 130000120, 130000200, 130000210, 130010000, 130010010, 130010020, 130010100, 130010110, 130010120, 130010200, 130010210, 130010220, 130020000, 130030005, 130030006, 130030000, //Ereve
        140000000, 140010000, 140010100, 140010200, 140020000, 140020100, 140020200, 140030000, 140090000, 140020300, //Rien
        310000000, 310000010, 310020000, 310020100, 310020200, 310030000, 310030100, 310030110, 310030200, 310030300, 310030310, 310040000, 310040100, 310040110, 310040200, 310040300, 310040400, 310050000, 310050100, 310050200, 310050300, 310050400, 310050500, 310050510, 310050520, 310050600, 310050700, 310050800, 310060000, 310060100, 310060110, 310060120, 310060200, 310060210, 310060220, 310060300, 310010000, //Edelstein
        600000000, 600010100, 600010200, 600010300, 600010400, 600010500, 600010600, 600010700, 600020000, 600020100, 600020200, 600020300, 600020400, 600020500, 600020600, 682000000, 610010000, 610010001, 610010002, 610010004, 610020000, 610020001, 610020006, 610040000, 610040100, 610040200, 610040210, 610040220, 610040230, 610040400//Masteria
    };
    public static final int[] unusedNpcs = {
        9330354,//艾尼碼(倒下)
        9000290,//飄風(10週年防具店)
        9000314,//閃光擊(10週年武器店)
        9010040,//戴彼得(正義商店)
        9000250,//甘迪(迷你遊戲站)
        9000251,//甘迪(迷你遊戲站)
        9000252,//甘迪(迷你遊戲站)
        9000069,//必魯(紫金裝商店)
        9000133,//運動會溫莉
        9000083,//星星
        9130032,//藍多普(戰國商店)
        9130033,//露西亞(戰國商店)
        9330120,//風暴(戰國商店)
        9330434,//橘子運營者(橘子節活動)
        9330453,//番茄(橘子節活動)
        9001120,//卡斯帕
        9330452,//美麗的萬聖節魔女
        9020000,//拉克里斯(第一次同行)
        9001105,//老爺爺月妙
        9000266,//冰兒(冰棒硬幣商城)
        9330455,//搖搖聖誕老人
        9330456,//聖誕樹人型立牌
    };
    //Unused npcs will be removed from map once you enter it.

    /*public static void LoadEXP() {
     exp[2] = 34;
     exp[3] = 57;
     exp[4] = 92;
     exp[5] = 135;
     int v0 = 15;
     exp[1] = 15;
     exp[6] = 372;
     exp[7] = 560;
     exp[8] = 840;
     exp[9] = 1242;
     long v1 = exp[9];
     exp[10] = v1;
     exp[11] = v1;
     exp[12] = v1;
     exp[13] = v1;
     exp[14] = v1;
     do {
     exp[v0] = (long) (exp[v0 - 1] * 1.2);
     ++v0;
     } while (v0 <= 29);
     long v2 = exp[29];
     exp[30] = v2;
     exp[31] = v2;
     exp[32] = v2;
     exp[33] = v2;
     exp[34] = v2;
     int v3 = 35;
     do {
     exp[v3] = (long) (exp[v3 - 1] * 1.2);
     ++v3;
     } while (v3 <= 39);
     int v4 = 40;
     do {
     exp[v4] = (long) (exp[v4 - 1] * 1.08);
     ++v4;
     } while (v4 <= 59);
     long v5 = exp[59];
     exp[60] = v5;
     exp[61] = v5;
     exp[62] = v5;
     exp[63] = v5;
     exp[64] = v5;
     int v6 = 65;
     do {
     exp[v6] = (long) (exp[v6 - 1] * 1.08);
     ++v6;
     } while (v6 <= 74);
     int v7 = 75;
     do {
     exp[v7] = (long) (exp[v7 - 1] * 1.07);
     ++v7;
     } while (v7 <= 99);
     long v8 = exp[99];
     exp[100] = v8;
     exp[101] = v8;
     exp[102] = v8;
     exp[103] = v8;
     exp[104] = v8;
     int v9 = 105;
     do {
     exp[v9] = (long) (exp[v9 - 1] * 1.07);
     ++v9;
     } while (v9 <= 159);
     int v10 = 160;
     do {
     exp[v10] = (long) (exp[v10 - 1] * 1.06);
     ++v10;
     } while (v10 <= 199);
     exp[200] = exp[199] * 2;
     int v11 = 201;
     do {
     exp[v11] = (long) (exp[v11 - 1] * 1.2);
     ++v11;
     } while (v11 <= 249);
     exp[250] = 0;
     }*/
    public static void LoadEXP() {
        exp[1] = 15;
        exp[2] = 34;
        exp[3] = 57;
        exp[4] = 92;
        exp[5] = 135;
        exp[6] = 372;
        exp[7] = 560;
        exp[8] = 840;
        exp[9] = 1242;
        for (int i = 10; i < 200; i++) {
            if (i >= 10 && i < 15
                    || i >= 30 && i < 35
                    || i >= 60 && i < 65
                    || i >= 100 && i < 105) {
                exp[i] = exp[i - 1];
                continue;
            }
            exp[i] = (long) ((double) exp[i - 1] * (i < 40 ? 1.2 : i < 75 ? 1.08 : i < 160 ? 1.07 : i < 200 ? 1.06 : 1));
        } //ExtremeDevilz SUCKS
        for (int i = 200; i < 250; i++) {
            if (i % 10 == 0) {
                exp[i] = exp[i - 1] * 2;
                if (i != 200) {
                    exp[i] = (long) ((double) exp[i] * (i == 210 ? 1.06 : i == 220 ? 1.04 : i == 230 ? 1.02 : i == 240 ? 1.01 : 1));
                }
                continue;
            }
            exp[i] = (long) ((double) exp[i - 1] * (i < 210 ? 1.2 : i < 220 ? 1.06 : i < 230 ? 1.04 : i < 240 ? 1.02 : i < 250 ? 1.01 : 1));
        }
        exp[250] = 0;
    }

    public static void loadFaceHair() {
        Connection con = DatabaseConnection.getConnection();
        try {
            try (PreparedStatement ps = con.prepareStatement("SELECT * FROM wz_hairdata ORDER BY `hairid`"); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    hairList.put(rs.getInt("hairid"), rs.getString("name"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("讀取髮型數據失敗：" + ex);
        }
        try {
            try (PreparedStatement ps = con.prepareStatement("SELECT * FROM wz_facedata ORDER BY `faceid`"); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    faceList.put(rs.getInt("faceid"), rs.getString("name"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("讀取臉型數據失敗：" + ex);
        }
    }

    public static long getExpNeededForLevel(final int level) {
        if (level < 1 || level >= exp.length) {
            return Long.MAX_VALUE;
        }
        return exp[level];
    }

    public static int getGuildExpNeededForLevel(final int level) {
        if (level < 0 || level >= guildexp.length) {
            return Integer.MAX_VALUE;
        }
        return guildexp[level];
    }

    public static int getPVPExpNeededForLevel(final int level) {
        if (level < 0 || level >= pvpExp.length) {
            return Integer.MAX_VALUE;
        }
        return pvpExp[level];
    }

    public static int getClosenessNeededForLevel(final int level) {
        return closeness[level - 1];
    }

    public static int getMountExpNeededForLevel(final int level) {
        return mountexp[level - 1];
    }

    public static int getTraitExpNeededForLevel(final int level) {
        if (level < 0 || level >= cumulativeTraitExp.length) {
            return Integer.MAX_VALUE;
        }
        return cumulativeTraitExp[level];
    }

    public static int getSetExpNeededForLevel(final int level) {
        if (level < 0 || level >= setScore.length) {
            return Integer.MAX_VALUE;
        }
        return setScore[level];
    }

    public static int getMonsterHP(final int level) {
        if (level < 0 || level >= mobHpVal.length) {
            return Integer.MAX_VALUE;
        }
        return mobHpVal[level];
    }

    public static int getBookLevel(final int level) {
        return (5 * level) * (level + 1);
    }

    public static int getTimelessRequiredEXP(final int level) {
        return 70 + (level * 10);
    }

    public static int getReverseRequiredEXP(final int level) {
        return 60 + (level * 5);
    }

    public static int getProfessionEXP(final int level) {
        return ((100 * level * level) + (level * 400)) / 2;
    }

    public static boolean isHarvesting(final int itemId) {
        return itemId >= 1500000 && itemId < 1520000;
    }

    public static int maxViewRangeSq() {
        return Integer.MAX_VALUE;//1000000; // 1024 * 768
    }

    public static int maxViewRangeSq_Half() {
        return Integer.MAX_VALUE;//500000; // 800 * 800
    }

    public static boolean isExceedAttack(int id) {
        switch (id) {
            case 31011000:
            case 31011004:
            case 31011005:
            case 31011006:
            case 31011007:
            case 31201000:
            case 31201007:
            case 31201008:
            case 31201009:
            case 31201010:
            case 31211000:
            case 31211007:
            case 31211008:
            case 31211009:
            case 31211010:
            case 31221000:
            case 31221009:
            case 31221010:
            case 31221011:
            case 31221012:
                return true;
        }
        return false;
    }

    public static int getLuminousSkillMode(int id) {
        switch (id) {
            case 27001100:
            case 27101100:
            case 27111100:
            case 27111101:
            case 27121100:
                return 20040216;//light
            case 27001201:
            case 27101202:
            case 27111202:
            case 27121201:
            case 27121202:
            case 27120211:
                return 20040217;//dark
            case 27111303:
            case 27121303:
                return 20040220;
        }
        return 0;
    }

    public static int getLinkSkillByJob(final int job) {
        if (MapleJob.is重砲指揮官(job)) { //Pirate Blessing
            return 80000000;
        } else if (MapleJob.is皇家騎士團(job)) { //Cygnus Blessing
            return 80000070;
        } else if (MapleJob.is精靈遊俠(job)) { //Elven Blessing
            return 80001040;
        } else if (MapleJob.is惡魔殺手(job)) { //Fury Unleashed
            return 80000001;
        } else if (MapleJob.is惡魔復仇者(job)) { //Wild Rage
            return 80000050;
        } else if (MapleJob.is蒼龍俠客(job)) { //Core Aura
            return 80001151;
        } else if (MapleJob.is幻影俠盜(job)) { //Phantom Instinct
            return 80000002;
        } else if (MapleJob.is米哈逸(job)) { //Knight's Watch
            return 80001140;
        } else if (MapleJob.is夜光(job)) { //Light Wash
            return 80000005;
        } else if (MapleJob.is天使破壞者(job)) { //Terms and Conditions   
            return 80001155;
        } else if (MapleJob.is劍豪(job)) { //Keen Edge  
            return 80000003;
        } else if (MapleJob.is陰陽師(job)) { //Elementalism    
            return 40020002;
        } else if (MapleJob.is凱撒(job)) { //Iron Will
            return 80000006;
        } else if (MapleJob.is傑諾(job)) { //Hybrid Logic    
            return 80000047;
        } else if (MapleJob.is幻獸師(job)) { //Focus Spirit    
            return 80010006;
        }
        return 0;
    }

    public static boolean isRecoveryIncSkill(final int id) {
        switch (id) {
            case 1110000:
            case 2000000:
            case 1210000:
            case 11110000:
            case 4100002:
            case 4200001:
                return true;
        }
        return false;
    }

    public static boolean isLinkedAttackSkill(final int id) {
        return getLinkedAttackSkill(id) != id;
    }

    public static int getLinkedAttackSkill(final int id) {
        switch (id) {
            case 21110007:
            case 21110008:
                return 21110002;
            case 21120009:
            case 21120010:
                return 21120002;
            case 4321001:
                return 4321000;
            case 32120055: // 鬥王杖擊(2擊)
                return 32120052; // 鬥王杖擊
            case 33101006:
            case 33101007:
                return 33101005;
            case 33101008:
                return 33101004;
            case 35101009:
            case 35101010:
                return 35100008;
            case 35111009:
            case 35111010:
                return 35111001;
            case 35121013:
                return 35111004;
            case 35121011:
                return 35121009;
            case 32001007:
            case 32001008:
            case 32001009:
            case 32001010:
            case 32001011:
                return 32001001;
            case 5300007:
                return 5301001;
            case 5320011:
                return 5321004;
            case 23101007:
                return 23101001;
            case 23111010:
            case 23111009:
                return 23111008;
            case 31001006:
            case 31001007:
            case 31001008:
                return 31000004;
            case 30010183:
            case 30010184:
            case 30010186:
                return 30010110;
            case 31010004:
            case 31010005:
            case 31010006:
            case 31010007:
                return 31011000; //超越 : 十文字斬
            case 31201007:
            case 31201008:
            case 31201009:
            case 31201010:
                return 31201000; //超越：惡魔風暴
            case 31211007:
            case 31211008:
            case 31211009:
            case 31211010:
                return 31211000; //超越：月光斬
            case 31221009:
            case 31221010:
            case 31221011:
            case 31221012:
                return 31221000; //超越 : 逆十文字斬
            case 5710012:
                return 5711002;
            case 5701012:
            case 5710020:
                return 5701011;
            case 31121010:
                return 31121000;
            case 5211015:
            case 5211016:
                return 5211011;
            case 24111008:
                return 24111006;
            case 24121010:
                return 24121003;
            case 5001008:
                return 5200010;
            case 5001009:
                return 5101004;
            case 41001005:
            case 41001004:
                return 41001000;
            case 41001006:
            case 41001007:
            case 41001008:
                return 41001002;
            case 41101009:
            case 41101008:
                return 41101000;
            case 41111012:
            case 41111011:
                return 41111000;
            case 41120013:
            case 41120012:
            case 41120011:
                return 41121000;
            case 42001006:
            case 42001005:
                return 42001000;
            case 42001007:
                return 42001002;
            case 42100010:
                return 42101001;
            //Zero:
            case 101000102:
                return 101000101;
            case 101000202:
                return 101000201;
            case 101100202:
                return 101100201;
            case 101110201:
                return 101110200;
            case 101110204:
                return 101110203;
            case 101120101:
                return 101120100;
            case 101120103:
                return 101120102;
            case 101120105:
            case 101120106:
                return 101120104;
            case 101120203:
                return 101120202;
            case 101120205:
            case 101120206:
                return 101120204;
            case 101120200:
                return 101121200;
            case 112000001:
            case 112000002:
                return 112000000;
            case 112120001:
            case 112120002:
            case 112120003:
                return 112120000;
        }
        return id;
    }

    public static final int getLinkedBuffSkill(final int id) {
        switch (id) {
            case 61120008:
                return 61111008;
            case 11121011:
            case 11121012:
                return 11121005;
        }
        return id;
    }

    public static final int getLinkedAranSkill(final int id) {
        switch (id) {
            case 21110007:
            case 21110008:
                return 21110002;
            case 21120009:
            case 21120010:
                return 21120002;
            case 4321001:
                return 4321000;
            case 33101006:
            case 33101007:
                return 33101005;
            case 33101008:
                return 33101004;
            case 35101009:
            case 35101010:
                return 35100008;
            case 35111009:
            case 35111010:
                return 35111001;
            case 35121013:
                return 35111004;
            case 35121011:
                return 35121009;
            case 32001007:
            case 32001008:
            case 32001009:
            case 32001010:
            case 32001011:
                return 32001001;
            case 5300007:
                return 5301001;
            case 5320011:
                return 5321004;
            case 23101007:
                return 23101001;
            case 23111010:
            case 23111009:
                return 23111008;
            case 31001006:
            case 31001007:
            case 31001008:
                return 31000004;
            case 30010183:
            case 30010184:
            case 30010186:
                return 30010110;
            case 5710012:
                return 5711002;
            case 31121010:
                return 31121000;
            case 5211015:
            case 5211016:
                return 5211011;
            case 24111008:
                return 24111006;
            case 24121010:
                return 24121003;
            case 5001008:
                return 5200010;
            case 5001009:
                return 5101004;
            case 41001005:
            case 41001004:
                return 41001000;
            case 41101009:
            case 41101008:
                return 41101000;
            case 41111012:
            case 41111011:
                return 41111000;
            case 41120013:
            case 41120012:
            case 41120011:
                return 41121000;
            case 42001006:
            case 42001005:
                return 42001000;
            case 42001007:
                return 42001002;
            case 42100010:
                return 42101001;
            //Zero:
            case 101000102:
                return 101000101;
            case 101000202:
                return 101000201;
            case 101100202:
                return 101100201;
            case 101110201:
                return 101110200;
            case 101110204:
                return 101110203;
            case 101120101:
                return 101120100;
            case 101120103:
                return 101120102;
            case 101120105:
            case 101120106:
                return 101120104;
            case 101120203:
                return 101120202;
            case 101120205:
            case 101120206:
                return 101120204;
            case 101120200:
                return 101121200;
            case 25000003:
                return 25001002;
            case 25000001:
                return 25001000;
            case 25100001:
                return 25101000;
            case 25110001:
            case 25110002:
            case 25110003:
                return 25111000;
            case 25120001:
            case 25120002:
            case 25120003:
                return 25121000;
        }
        return id;
    }

    public static boolean isSaintSaverSkill(int skill) {
        switch (skill) {
            case 80001034:
            case 80001035:
            case 80001036:
                return true;
        }
        return false;
    }

    public final static boolean isForceIncrease(int skillid) {
        switch (skillid) {
            case 24100003:
            case 24120002:
            case 31000004:
            case 31001006:
            case 31001007:
            case 31001008:

            case 30010166:
            case 30011167:
            case 30011168:
            case 30011169:
            case 30011170:
                return true;
        }
        return false;
    }

    public static int findSkillByName(String name, int job, int def) {
        int skillid = 0;
        for (Skill skill : SkillFactory.getAllSkills()) {
            if (skill.getName() != null && skill.getName().toLowerCase().contains(name.toLowerCase())) {
                if (skill.getId() / 10000 == job) {
                    skillid = skill.getId();
                }
            }
        }
        if (skillid != 0) {
            return skillid;
        } else {
            return def;
        }
    }

    public static int getBOF_ForJob(final int job) {
        return PlayerStats.getSkillByJob(12, job);
    }

    public static int getEmpress_ForJob(final int job) {
        return PlayerStats.getSkillByJob(73, job);
    }

    public static boolean isElementAmp_Skill(final int skill) {
        switch (skill) {
            case 2110001:
            case 2210001:
            case 12110001:
            case 22150000:
                return true;
        }
        return false;
    }

    public static int getMPEaterForJob(final int job) {
        switch (job) {
            case 210:
            case 211:
            case 212:
                return 2100000;
            case 220:
            case 221:
            case 222:
                return 2200000;
            case 230:
            case 231:
            case 232:
                return 2300000;
        }
        return 2100000; // Default, in case GM
    }

    public static boolean isPyramidSkill(final int skill) {
        return MapleJob.isBeginner(skill / 10000) && skill % 10000 == 1020;
    }

    public static boolean isInflationSkill(final int skill) {
        return MapleJob.isBeginner(skill / 10000) && skill % 10000 == 1092;
    }

    public static boolean isMulungSkill(final int skill) {
        return MapleJob.isBeginner(skill / 10000) && (skill % 10000 == 1009 || skill % 10000 == 1010 || skill % 10000 == 1011);
    }

    public static boolean isIceKnightSkill(final int skill) {
        return MapleJob.isBeginner(skill / 10000) && (skill % 10000 == 1098 || skill % 10000 == 99 || skill % 10000 == 100 || skill % 10000 == 103 || skill % 10000 == 104 || skill % 10000 == 1105);
    }

    public static boolean isTownSkill(final int skill) {
        switch (skill) {
            case 1281: //maple island
            case 10001245: //ereve
            case 20021110: //elluel
            case 20031203: //lumiere
            case 30021235: //veritas
            case 60011220: //pantheon
            case 100001262: //zero temple
            case 110001514: //arboren ferry
                return true;
        }
        return false;
    }

    public static boolean isThrowingStar(final int itemId) {
        return itemId / 10000 == 207;
    }

    public static boolean isBullet(final int itemId) {
        return itemId / 10000 == 233;
    }

    public static boolean isRechargable(final int itemId) {
        return isThrowingStar(itemId) || isBullet(itemId);
    }

    public static boolean isOverall(final int itemId) {
        return itemId / 10000 == 105;
    }

    public static boolean isPet(final int itemId) {
        return itemId / 10000 == 500;
    }

    public static boolean isArrowForCrossBow(final int itemId) {
        return itemId >= 2061000 && itemId < 2062000;
    }

    public static boolean isArrowForBow(final int itemId) {
        return itemId >= 2060000 && itemId < 2061000;
    }

    public static boolean isMagicWeapon(final int itemId) {
        final int s = itemId / 10000;
        return s == 137 || s == 138; // wand, staff
    }

    public static boolean isWeapon(final int itemId) {
        if (isSpecialShield(itemId)) {
            return false;
        }
        return itemId >= 1210000 && itemId < 1600000;
    }

    public static boolean isMacHeart(int itemId) {
        return (itemId / 1000 == 1672) && (itemId != 1672030) && (itemId != 1672031) && (itemId != 1672032);
    }

    public static boolean isSecondaryWeapon(final int itemId) {
        return itemId / 10000 == 135;
    }

    public static boolean isBowgun(final int itemId) {
        return itemId >= 1522000 && itemId < 1523000;
    }

    public static boolean isCane(final int itemId) {
        return itemId >= 1362000 && itemId < 1363000;
    }

    public static boolean isMagicArrow(final int itemId) {
        return itemId >= 1352000 && itemId < 1352100;
    }

    public static boolean isCard(final int itemId) {
        return itemId >= 1352100 && itemId < 1352200;
    }

    public static boolean isCore(final int itemId) {
        return itemId >= 1352300 && itemId < 1352400;
    }

    public static boolean isGMEquip(final int itemId) {
        switch (itemId) {
            case 1002140://維澤特帽
            case 1003142://維澤特帽
            case 1003274://維澤特帽
            case 1042003://維澤特西裝
            case 1042223://維澤特西裝
            case 1062007://維澤特西褲
            case 1062140://維澤特西褲
            case 1322013://維澤特手提包
            case 1322106://維澤特手提包
            case 1002959:
                return true;
        }
        return false;
    }

    public static boolean isOverPoweredEquip(final MapleClient c, final int itemId, short slot) {
        Equip source = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(slot);
        return source.getAcc() > 1000
                || source.getAvoid() > 1000
                || source.getStr() > 500
                || source.getDex() > 500
                || source.getInt() > 500
                || source.getLuk() > 500
                || source.getEnhance() > 25
                || source.getHands() > 100
                || source.getHp() > 5000
                || source.getMp() > 5000
                || source.getJump() > 100
                || source.getSpeed() > 100
                || source.getMatk() > 700
                || source.getMdef() > 1500
                || source.getUpgradeSlots() > 32
                || source.getViciousHammer() > 1
                || source.getWatk() > 700
                || source.getWdef() > 1500 /*|| source.getLevel() > 32*/;
    }

    public static boolean isMadeByGM(final MapleClient c, final int itemId, short slot) {
        Equip source = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(slot);
        MapleCharacter gm = c.getChannelServer().getPlayerStorage().getCharacterByName(source.getOwner());
        if (source.getOwner() == null || source.getOwner().isEmpty() || gm == null) {
            return false;
        }
        return gm.isStaff();
    }

    public static boolean isIllegalItem(int id) {
        switch (id) {
            case 1042003:
            case 1062007:
            case 1002140:
            case 1003142:
            case 1322013:
            case 1002959:
                return true;
        }
        return false;
    }

    public static MapleInventoryType getInventoryType(final int itemId) {
        final byte type = (byte) (itemId / 1000000);
        if (type < 1 || type > 5) {
            return MapleInventoryType.UNDEFINED;
        }
        return MapleInventoryType.getByType(type);
    }

    public static boolean isInBag(final int slot, final byte type) {
        return ((slot >= 101 && slot <= 512) && type == MapleInventoryType.ETC.getType());
    }

    public static MapleWeaponType getWeaponType(final int itemId) {
        int cat = itemId / 10000;
        cat = cat % 100;
        switch (cat) { // 39, 50, 51 ??
            case 21:
                return MapleWeaponType.閃亮克魯;
            case 22:
                return MapleWeaponType.靈魂射手;
            case 23:
                return MapleWeaponType.短劍;
            case 24:
                return MapleWeaponType.能量劍;
            case 25:
                return MapleWeaponType.幻獸棍棒;
            case 30:
                return MapleWeaponType.單手劍;
            case 31:
                return MapleWeaponType.單手斧;
            case 32:
                return MapleWeaponType.單手棍;
            case 33:
                return MapleWeaponType.短劍;
            case 34:
                return MapleWeaponType.雙刀;
            case 35:
                return MapleWeaponType.特殊副手; // can be magic arrow or cards
            case 36:
                return MapleWeaponType.手杖;
            case 37:
                return MapleWeaponType.短杖;
            case 38:
                return MapleWeaponType.長杖;
            case 40:
                return MapleWeaponType.雙手劍;
            case 41:
                return MapleWeaponType.雙手斧;
            case 42:
                return MapleWeaponType.雙手棍;
            case 43:
                return MapleWeaponType.槍;
            case 44:
                return MapleWeaponType.矛;
            case 45:
                return MapleWeaponType.弓;
            case 46:
                return MapleWeaponType.弩;
            case 47:
                return MapleWeaponType.拳套;
            case 48:
                return MapleWeaponType.指虎;
            case 49:
                return MapleWeaponType.火槍;
            case 52:
                return MapleWeaponType.雙弩槍;
            case 53:
                return MapleWeaponType.加農炮;
            case 54:
                return MapleWeaponType.太刀;
            case 55:
                return MapleWeaponType.扇子;
            case 56:
                return MapleWeaponType.璃;
            case 57:
                return MapleWeaponType.琉;
        }
        //System.out.println("Found new Weapon: " + cat + ", ItemId: " + itemId);
        return MapleWeaponType.沒有武器;
    }

    public static int getEquipForJob(final int job) {
        if (!MapleJob.isExist(job)) {
            return -1;
        }
        switch (job / 10) {
            case 10:
            case 11:
            case 12:
                return 130;
            case 13:
                return 143;
            case 20:
            case 21:
            case 22:
            case 23:
                return 138;
            case 30:
            case 31:
                return 145;
            case 32:
                return 146;
            case 40:
            case 41:
                return 147;
            case 42:
            case 43:
                return 133;
            case 50:
            case 51:
                return 148;
            case 52:
            case 57:
                return 149;
            case 53:
                return 153;
        }
        switch (job / 100) {
            case 11:
                return 130;
            case 12:
                return 138;
            case 13:
                return 145;
            case 14:
                return 147;
            case 15:
                return 148;
            case 21:
                return 144;
            case 22:
                return 137;
            case 23:
                return 152;
            case 24:
                return 136;
            case 27:
                return 121;
            case 31:
                return 132;
            case 32:
                return 138;
            case 33:
                return 146;
            //case 34:
            //    return ;
            case 35:
                return 149;
            case 41:
                return 154;
            case 42:
                return 155;
            //case 43:
            //    return ;
            //case 44:
            //    return ;
            //case 45:
            //    return ;
            case 51:
                return 130;
            //case 52:
            //    return ;
            //case 53:
            //    return ;
            //case 54:
            //    return ;
            //case 55:
            //    return ;
            case 61:
                return 140;
            //case 62:
            //    return ;
            //case 63:
            //    return ;
            //case 64:
            //    return ;
            case 65:
                return 122;
        }
        return -1;
    }

    public static boolean isShield(final int itemId) {
        int cat = itemId / 10000;
        cat = cat % 100;
        return cat == 9;
    }

    public static boolean isEquip(final int itemId) {
        return itemId / 1000000 == 1;
    }

    public static boolean isCleanSlate(int itemId) {
        return itemId / 100 == 20490;
    }

    public static boolean isAccessoryScroll(int itemId) {
        return itemId / 100 == 20492;
    }

    public static boolean isChaosScroll(int itemId) {
        if (itemId >= 2049105 && itemId <= 2049110) {
            return false;
        }
        return itemId / 100 == 20491 || itemId == 2040126;
    }

    public static int getChaosNumber(int itemId) {
        switch (itemId) {
            case 2049116://驚訝的混沌卷軸 60%
            case 2049132://驚訝的混沌卷軸 30%
            case 2049133://驚訝的混沌卷軸 50%
            case 2049134://驚訝的混沌卷軸 70%
            case 2049135://驚訝樂觀的混沌卷軸 20%
            case 2049136://驚訝樂觀的混沌卷軸 20%
            case 2049137://驚訝樂觀的混沌卷軸 40%
            case 2049140://珠寶戒指的驚訝的混沌卷軸 40%
            case 2049142://驚訝的混沌卷軸 40%
            case 2049145://珠寶工藝驚訝的混沌卷軸 40%
            case 2049152://驚訝的混沌卷軸 60%
            case 2049153://驚訝樂觀的混沌卷軸
            case 2049156://驚訝的混沌卷軸 20%
            case 2049159://驚訝的混沌卷軸 50%
            case 2049165://驚訝的混沌卷軸 50%
                return 10;
        }
        return 5;
    }

    public static boolean isChaosForGoodness(int itemId) {
        if (!isChaosScroll(itemId)) {
            return false;
        }
        switch (itemId) {
            case 2049122://樂觀的混卷軸50%
            case 2049129://樂觀的混卷軸 50%
            case 2049130://樂觀的混卷軸 30%
            case 2049131://樂觀的混卷軸 20%
            case 2049135://驚訝樂觀的混卷軸 20%
            case 2049136://驚訝樂觀的混卷軸 20%
            case 2049137://驚訝樂觀的混卷軸 40%
            case 2049141://珠寶戒指的樂觀的混卷軸 30%
            case 2049155://珠寶工藝樂觀的混卷軸 30%
            case 2049153://驚訝樂觀的混卷軸
                return true;
        }
        return false;
    }

    public static boolean isEquipScroll(int scrollId) {
        return scrollId / 100 == 20493;
    }

    public static boolean isPotentialScroll(int scrollId) {
        return scrollId / 100 == 20494 || scrollId / 100 == 20497 || scrollId == 5534000;
    }

    public static boolean isBonusPotentialScroll(int scrollId) {
        return scrollId / 100 == 20483 && !(scrollId >= 2048200 && scrollId <= 2048304);
    }

    public static int getBonusPotentialScrollSucc(int scrollId) {
        switch (scrollId) {
            case 2048306://成功100,3行
            case 2048307://成功100
            case 2048315://成功100
            case 2048316://成功100
                return 100;
            case 2048313://心之項鍊專用,成功80
                return 80;
            case 2048305://成功70,失敗損壞100
                return 70;
            case 2048309://成功60,無損
            case 2048310://成功60,失敗損壞100
            case 2048314://成功60
                return 60;
            case 2048308://成功50,失敗損壞50
            case 2048311://成功50,失敗損壞50
                return 50;
            case 2048312://成功1
                return 1;
            default:
                return 0;
        }
    }

    public static int getBonusPotentialScrollCurse(int scrollId) {
        switch (scrollId) {
            case 2048305://成功70,失敗損壞100
            case 2048310://成功60,失敗損壞100
                return 100;
            case 2048308://成功50,失敗損壞50
            case 2048311://成功50,失敗損壞50
                return 50;
            default:
                return 0;
        }
    }

    public static boolean isAzwanScroll(int scrollId) {
        //return MapleItemInformationProvider.getInstance().getEquipStats(scroll.getItemId()).containsKey("tuc");
        //should add this ^ too.
        return scrollId >= 2046060 && scrollId <= 2046069 || scrollId >= 2046141 && scrollId <= 2046145 || scrollId >= 2046519 && scrollId <= 2046530 || scrollId >= 2046701 && scrollId <= 2046712;
    }

    public static boolean isSpecialSlotScroll(int scrollId) {
        return MapleItemInformationProvider.getInstance().getEquipStats(scrollId).containsKey("tuc");
    }

    public static boolean isResetScroll(int scrollId) {
        switch (scrollId) {
            case 5064200://完美回真卡
            case 5064201://星光回真卷軸
                return true;
            default:
                return scrollId / 100 == 20496;
        }
    }

    public static boolean isSpecialScroll(final int scrollId) {
        return isLuckydayScroll(scrollId) || isProtectionScroll(scrollId) || isSafeScroll(scrollId) || isScrollSafeScroll(scrollId) || isSpecialScrollWithPer(scrollId);
    }

    public static boolean isSpecialScrollWithPer(int scrollId) {
        switch (scrollId) {
            case 2040727://鞋子防滑卷軸10%
            case 2041058://披風防寒卷軸10%
                return true;
            default:
                return false;
        }
    }

    public static boolean isLuckydayScroll(int scrollId) {
        switch (scrollId) {
            case 5063100://幸運保護券(防爆+幸運)
            case 5068000://寵物專用幸運日卷軸
                return true;
            default:
                return scrollId / 1000 == 2530;
        }
    }

    public static boolean isProtectionScroll(int scrollId) {
        switch (scrollId) {
            case 5063100://幸運保護券(防爆+幸運)
            case 5064000://裝備保護卷軸(無法用於尊貴或12星以上)
            case 5064002://星光裝備保護卷軸(105以下的裝備且無法用於尊貴或12星以上)
            case 5064003://尊貴裝備保護卷軸(無法用於非尊貴以及尊貴7星以上)
            case 5064004://[MS特價] 裝備保護卷軸(無法用於尊貴或12星以上)
                return true;
            default:
                return scrollId / 1000 == 2531;
        }
    }

    public static boolean isSafeScroll(int scrollId) {
        switch (scrollId) {
            case 5064100://安全盾牌卷軸
            case 5064101://星光安全盾牌卷軸(105以下的裝備)
            case 5068100://寵物安全盾牌卷軸
                return true;
            default:
                return scrollId / 1000 == 2532;
        }
    }

    public static boolean isScrollSafeScroll(int scrollId) {
        switch (scrollId) {
            case 5064300://卷軸保護卡
            case 5064301://星光卷軸保護卡(105以下的裝備)
            case 5068200://寵物卷軸保護卡
                return true;
        }
        return false;
    }

    public static boolean isTwoHanded(final int itemId) {
        switch (getWeaponType(itemId)) {
            case 雙手劍:
            case 雙手斧:
            case 雙手棍:
            case 槍:
            case 矛:
            case 弓:
            case 弩:
            case 拳套:
            case 指虎:
            case 火槍:
            case 雙弩槍:
            case 加農炮:
            case 太刀:
            case 扇子:
            case 璃:
            case 琉:
                return true;
            default:
                return false;
        }
    }

    public static boolean isSpecialShield(final int itemid) {
        return itemid / 1000 == 1098 || itemid / 1000 == 1099 || itemid / 10000 == 135;
    }

    public static boolean isPetEquip(final int itemid) {
        return itemid / 10000 == 180;
    }

    public static boolean isEnergy(final int itemid) {
        return itemid / 10000 == 119;
    }

    public static boolean isSpecialPotentialItem(final int itemId) {
        if (itemId / 100 == 10121 && itemId % 100 >= 64 && itemId % 100 <= 74 && itemId % 100 != 65 && itemId % 100 != 66) {//恰吉
            return true;
        } else if (itemId / 10 == 112212 && (itemId % 10 >= 2 && itemId % 10 <= 6)) {//真. 楓葉之心
            return true;
        } else if (itemId >= 1122224 && itemId <= 1122245) {//心之項鍊
            return true;
        } else if (itemId / 10 == 101244) {//卡爾頓的鬍子
            return true;
        }
        return false;
    }

    public static boolean isSpecialCantPotentialItem(final int itemid) {
        return false;
    }

    public static boolean isTownScroll(final int id) {
        return id >= 2030000 && id < 2040000;
    }

    public static boolean isUpgradeScroll(final int id) {
        return id >= 2040000 && id < 2050000;
    }

    public static boolean isGun(final int id) {
        return id >= 1492000 && id < 1500000;
    }

    public static boolean isUse(final int id) {
        return id >= 2000000 && id < 3000000;
    }

    public static boolean isSummonSack(final int id) {
        return id / 10000 == 210;
    }

    public static boolean isMonsterCard(final int id) {
        return id / 10000 == 238;
    }

    public static boolean isSpecialCard(final int id) {
        return id / 1000 >= 2388;
    }

    public static int getCardShortId(final int id) {
        return id % 10000;
    }

    public static boolean isGem(final int id) {
        return id >= 4250000 && id <= 4251402;
    }

    public static boolean isOtherGem(final int id) {
        switch (id) {
            case 4001174:
            case 4001175:
            case 4001176:
            case 4001177:
            case 4001178:
            case 4001179:
            case 4001180:
            case 4001181:
            case 4001182:
            case 4001183:
            case 4001184:
            case 4001185:
            case 4001186:
            case 4031980:
            case 2041058:
            case 2040727:
            case 1032062:
            case 4032334:
            case 4032312:
            case 1142156:
            case 1142157:
                return true; //mostly quest items
        }
        return false;
    }

    public static boolean isCustomQuest(final int id) {
        return id > 99999;
    }

    public static int getTaxAmount(final int meso) {
        if (meso >= 100000000) {
            return (int) Math.round(0.06 * meso);
        } else if (meso >= 25000000) {
            return (int) Math.round(0.05 * meso);
        } else if (meso >= 10000000) {
            return (int) Math.round(0.04 * meso);
        } else if (meso >= 5000000) {
            return (int) Math.round(0.03 * meso);
        } else if (meso >= 1000000) {
            return (int) Math.round(0.018 * meso);
        } else if (meso >= 100000) {
            return (int) Math.round(0.008 * meso);
        }
        return 0;
    }

    public static int EntrustedStoreTax(final int meso) {
        if (meso >= 100000000) {
            return (int) Math.round(0.03 * meso);
        } else if (meso >= 25000000) {
            return (int) Math.round(0.025 * meso);
        } else if (meso >= 10000000) {
            return (int) Math.round(0.02 * meso);
        } else if (meso >= 5000000) {
            return (int) Math.round(0.015 * meso);
        } else if (meso >= 1000000) {
            return (int) Math.round(0.009 * meso);
        } else if (meso >= 100000) {
            return (int) Math.round(0.004 * meso);
        }
        return 0;
    }

    public static int getAttackDelay(final int id, final Skill skill) {
        switch (id) { // Assume it's faster(2)
            case 3121004: // Storm of Arrow
            case 24121000:
            case 24121005:
            case 23121000:
            case 33121009:
            case 13111002: // Storm of Arrow
            case 5221004: // Rapidfire
            case 5721001: // Rapidfire
            case 5201006: // Recoil shot/ Back stab shot
            case 35121005:
            case 35111004:
            case 35121013:
            case 31121005:
            case 24120002:
            case 24100003:
                System.out.println("Get Attack Delay with skill " + id);
                return 40; //reason being you can spam with final assaulter
            case 14111005:
            case 4121013:
            case 4121007:
            case 5221007:
            case 112100000: // Leopard's Paw
            case 112100002: // Leopard's Pounce
            case 112100003: // Leopard's Roar   
            case 112001004: // Deep Breath
            case 112001005: // Really Deep Breath
            case 112001006: // Majestic Trumpet
            case 112121004: // Fire Kitty
            case 112121057: // Cat's Cradle Blitzkrieg
            case 112121005: // Purr Zone
            case 112121013: // Meow Heal  
            case 112001008: // Fishy Slap
                System.out.println("Get Attack Delay with skill " + id);
                return 99; //skip duh chek
            case 0: // Normal Attack, TODO delay for each weapon type
                return 570;
        }
        if (skill != null && skill.getSkillType() == 3) {
            return 0; //final attack
        }
        if (skill != null && skill.getDelay() > 0 && !isNoDelaySkill(id)) {
            return skill.getDelay();
        }
        // TODO delay for final attack, weapon type, swing,stab etc
        return 330; // Default usually
    }

    public static byte gachaponRareItem(final int id) {
        switch (id) {
            case 2340000: // White Scroll
            case 2049100: // Chaos Scroll
            case 3010014: // Moon Star Chair
            case 3010043: // Halloween Brromstick
            case 3010073: // Giant Pink bean Cushion
            case 3010072: // Miwok Chief's Chair
            case 3010068: // Lotus Leaf Chair
            case 3010085: // Olivia's Chair
            case 3010118: // Musical Note Chair
            case 3010124: // Dunas Jet Char
            case 3010125: // Nibelung Battleship
            case 3010131: //chewing panda chair
            case 3010137: // Dragon lord Chair
            case 3010156: // Visitor Representative
            case 3010615: // Nao Resting
            case 3010592: //Black Bean Chair
            case 3010602: // Heart Cloud Chair
            case 3010670: // absolute Ring chair
            case 3010728: // ilove Maplestory
            case 1342033: // VIP Katara
            case 1372078: // VIP wand
            case 1382099: // Staff
            case 1402090: // Two handed Sword
            case 1412062: // Two Handed Axe
            case 1422063: // Two handed Blunt Weapon
            case 1432081: // Spear
            case 1442111: // Polearm
            case 1452106: // Bow
            case 1462091: // Crossbow
            case 1472117: // Claw
            case 1482079: // Knuckle
            case 1492079: // Gun
            case 1302147: // one sword
            case 1312062: // One handed Axe
            case 1322090: // One Handed Blunt Weapon
            case 1332120: // Dagger(LUK)
            case 1332125: // Dagger (STR)< end of VIP
            case 1102041: // Pink Adventure Cape
            case 1022082: // Spectrum Goog
            case 1072238: // Violet snow shoes
            case 5062002: // Super Miracle
            case 5062003: // Miracle
            case 5062005: // Miracle
            case 2040834: // Scroll for gloves for att 50%^
            case 1102042: // Purple adventure cape
                return 2;
            //1 = wedding msg o.o
        }
        return 0;
    }
    public final static int[] goldrewards = {
        2049400, 1,
        2049401, 2,
        2049301, 2,
        2340000, 1, // white scroll
        2070007, 2,
        2070016, 1,
        2330007, 1,
        2070018, 1, // balance fury
        1402037, 1, // Rigbol Sword
        2290096, 1, // Maple Warrior 20
        2290049, 1, // Genesis 30
        2290041, 1, // Meteo 30
        2290047, 1, // Blizzard 30
        2290095, 1, // Smoke 30
        2290017, 1, // Enrage 30
        2290075, 1, // Snipe 30
        2290085, 1, // Triple Throw 30
        2290116, 1, // Areal Strike
        1302059, 3, // Dragon Carabella
        2049100, 1, // Chaos Scroll
        1092049, 1, // Dragon Kanjar
        1102041, 1, // Pink Cape
        1432018, 3, // Sky Ski
        1022047, 3, // Owl Mask
        3010051, 1, // Chair
        3010020, 1, // Portable meal table
        2040914, 1, // Shield for Weapon Atk

        1432011, 3, // Fair Frozen
        1442020, 3, // HellSlayer
        1382035, 3, // Blue Marine
        1372010, 3, // Dimon Wand
        1332027, 3, // Varkit
        1302056, 3, // Sparta
        1402005, 3, // Bezerker
        1472053, 3, // Red Craven
        1462018, 3, // Casa Crow
        1452017, 3, // Metus
        1422013, 3, // Lemonite
        1322029, 3, // Ruin Hammer
        1412010, 3, // Colonian Axe

        1472051, 1, // Green Dragon Sleeve
        1482013, 1, // Emperor's Claw
        1492013, 1, // Dragon fire Revlover

        1382049, 1,
        1382050, 1, // Blue Dragon Staff
        1382051, 1,
        1382052, 1,
        1382045, 1, // Fire Staff, Level 105
        1382047, 1, // Ice Staff, Level 105
        1382048, 1, // Thunder Staff
        1382046, 1, // Poison Staff

        1372035, 1,
        1372036, 1,
        1372037, 1,
        1372038, 1,
        1372039, 1,
        1372040, 1,
        1372041, 1,
        1372042, 1,
        1332032, 8, // Christmas Tree
        1482025, 7, // Flowery Tube

        4001011, 8, // Lupin Eraser
        4001010, 8, // Mushmom Eraser
        4001009, 8, // Stump Eraser

        2047000, 1,
        2047001, 1,
        2047002, 1,
        2047100, 1,
        2047101, 1,
        2047102, 1,
        2047200, 1,
        2047201, 1,
        2047202, 1,
        2047203, 1,
        2047204, 1,
        2047205, 1,
        2047206, 1,
        2047207, 1,
        2047208, 1,
        2047300, 1,
        2047301, 1,
        2047302, 1,
        2047303, 1,
        2047304, 1,
        2047305, 1,
        2047306, 1,
        2047307, 1,
        2047308, 1,
        2047309, 1,
        2046004, 1,
        2046005, 1,
        2046104, 1,
        2046105, 1,
        2046208, 1,
        2046209, 1,
        2046210, 1,
        2046211, 1,
        2046212, 1,
        //list
        1132014, 3,
        1132015, 2,
        1132016, 1,
        1002801, 2,
        1102205, 2,
        1332079, 2,
        1332080, 2,
        1402048, 2,
        1402049, 2,
        1402050, 2,
        1402051, 2,
        1462052, 2,
        1462054, 2,
        1462055, 2,
        1472074, 2,
        1472075, 2,
        //pro raven
        1332077, 1,
        1382082, 1,
        1432063, 1,
        1452087, 1,
        1462053, 1,
        1472072, 1,
        1482048, 1,
        1492047, 1,
        2030008, 5, // Bottle, return scroll
        1442018, 3, // Frozen Tuna
        2040900, 4, // Shield for DEF
        2049100, 10,
        2000005, 10, // Power Elixir
        2000004, 10, // Elixir
        4280000, 8,
        2430144, 10,
        2290285, 10,
        2028061, 10,
        2028062, 10,
        2530000, 5,
        2531000, 5}; // Gold Box
    public final static int[] silverrewards = {
        2049401, 2,
        2049301, 2,
        3010041, 1, // skull throne
        1002452, 6, // Starry Bandana
        1002455, 6, // Starry Bandana
        2290084, 1, // Triple Throw 20
        2290048, 1, // Genesis 20
        2290040, 1, // Meteo 20
        2290046, 1, // Blizzard 20
        2290074, 1, // Sniping 20
        2290064, 1, // Concentration 20
        2290094, 1, // Smoke 20
        2290022, 1, // Berserk 20
        2290056, 1, // Bow Expert 30
        2290066, 1, // xBow Expert 30
        2290020, 1, // Sanc 20
        1102082, 1, // Black Raggdey Cape
        1302049, 1, // Glowing Whip
        2340000, 1, // White Scroll
        1102041, 1, // Pink Cape
        1452019, 2, // White Nisrock
        4001116, 3, // Hexagon Pend
        4001012, 3, // Wraith Eraser
        1022060, 2, // Foxy Racoon Eye
        2430144, 5,
        2290285, 5,
        2028062, 5,
        2028061, 5,
        2530000, 1,
        2531000, 1,
        2041100, 1,
        2041101, 1,
        2041102, 1,
        2041103, 1,
        2041104, 1,
        2041105, 1,
        2041106, 1,
        2041107, 1,
        2041108, 1,
        2041109, 1,
        2041110, 1,
        2041111, 1,
        2041112, 1,
        2041113, 1,
        2041114, 1,
        2041115, 1,
        2041116, 1,
        2041117, 1,
        2041118, 1,
        2041119, 1,
        2041300, 1,
        2041301, 1,
        2041302, 1,
        2041303, 1,
        2041304, 1,
        2041305, 1,
        2041306, 1,
        2041307, 1,
        2041308, 1,
        2041309, 1,
        2041310, 1,
        2041311, 1,
        2041312, 1,
        2041313, 1,
        2041314, 1,
        2041315, 1,
        2041316, 1,
        2041317, 1,
        2041318, 1,
        2041319, 1,
        2049200, 1,
        2049201, 1,
        2049202, 1,
        2049203, 1,
        2049204, 1,
        2049205, 1,
        2049206, 1,
        2049207, 1,
        2049208, 1,
        2049209, 1,
        2049210, 1,
        2049211, 1,
        1432011, 3, // Fair Frozen
        1442020, 3, // HellSlayer
        1382035, 3, // Blue Marine
        1372010, 3, // Dimon Wand
        1332027, 3, // Varkit
        1302056, 3, // Sparta
        1402005, 3, // Bezerker
        1472053, 3, // Red Craven
        1462018, 3, // Casa Crow
        1452017, 3, // Metus
        1422013, 3, // Lemonite
        1322029, 3, // Ruin Hammer
        1412010, 3, // Colonian Axe

        1002587, 3, // Black Wisconsin
        1402044, 1, // Pumpkin lantern
        2101013, 4, // Summoning Showa boss
        1442046, 1, // Super Snowboard
        1422031, 1, // Blue Seal Cushion
        1332054, 3, // Lonzege Dagger
        1012056, 3, // Dog Nose
        1022047, 3, // Owl Mask
        3012002, 1, // Bathtub
        1442012, 3, // Sky snowboard
        1442018, 3, // Frozen Tuna
        1432010, 3, // Omega Spear
        1432036, 1, // Fishing Pole
        2000005, 10, // Power Elixir
        2049100, 10,
        2000004, 10, // Elixir
        4280001, 8}; // Silver Box
    public final static int[] peanuts = {2430091, 200, 2430092, 200, 2430093, 200, 2430101, 200, 2430102, 200, 2430136, 200, 2430149, 200,//mounts 
        2340000, 1, //rares
        1152000, 5, 1152001, 5, 1152004, 5, 1152005, 5, 1152006, 5, 1152007, 5, 1152008, 5, //toenail only comes when db is out.
        1152064, 5, 1152065, 5, 1152066, 5, 1152067, 5, 1152070, 5, 1152071, 5, 1152072, 5, 1152073, 5,
        3010019, 2, //chairs
        1001060, 10, 1002391, 10, 1102004, 10, 1050039, 10, 1102040, 10, 1102041, 10, 1102042, 10, 1102043, 10, //equips
        1082145, 5, 1082146, 5, 1082147, 5, 1082148, 5, 1082149, 5, 1082150, 5, //wg
        2043704, 10, 2040904, 10, 2040409, 10, 2040307, 10, 2041030, 10, 2040015, 10, 2040109, 10, 2041035, 10, 2041036, 10, 2040009, 10, 2040511, 10, 2040408, 10, 2043804, 10, 2044105, 10, 2044903, 10, 2044804, 10, 2043009, 10, 2043305, 10, 2040610, 10, 2040716, 10, 2041037, 10, 2043005, 10, 2041032, 10, 2040305, 10, //scrolls
        2040211, 5, 2040212, 5, 1022097, 10, //dragon glasses
        2049000, 10, 2049001, 10, 2049002, 10, 2049003, 10, //clean slate
        1012058, 5, 1012059, 5, 1012060, 5, 1012061, 5,//pinocchio nose msea only.
        1332100, 10, 1382058, 10, 1402073, 10, 1432066, 10, 1442090, 10, 1452058, 10, 1462076, 10, 1472069, 10, 1482051, 10, 1492024, 10, 1342009, 10, //durability weapons level 105
        2049400, 1, 2049401, 2, 2049301, 2,
        2049100, 10,
        2430144, 10,
        2290285, 10,
        2028062, 10,
        2028061, 10,
        2530000, 5,
        2531000, 5,
        1032080, 5,
        1032081, 4,
        1032082, 3,
        1032083, 2,
        1032084, 1,
        1112435, 5,
        1112436, 4,
        1112437, 3,
        1112438, 2,
        1112439, 1,
        1122081, 5,
        1122082, 4,
        1122083, 3,
        1122084, 2,
        1122085, 1,
        1132036, 5,
        1132037, 4,
        1132038, 3,
        1132039, 2,
        1132040, 1,
        //source
        1092070, 5,
        1092071, 4,
        1092072, 3,
        1092073, 2,
        1092074, 1,
        1092075, 5,
        1092076, 4,
        1092077, 3,
        1092078, 2,
        1092079, 1,
        1092080, 5,
        1092081, 4,
        1092082, 3,
        1092083, 2,
        1092084, 1,
        1092087, 1,
        1092088, 1,
        1092089, 1,
        1302143, 5,
        1302144, 4,
        1302145, 3,
        1302146, 2,
        1302147, 1,
        1312058, 5,
        1312059, 4,
        1312060, 3,
        1312061, 2,
        1312062, 1,
        1322086, 5,
        1322087, 4,
        1322088, 3,
        1322089, 2,
        1322090, 1,
        1332116, 5,
        1332117, 4,
        1332118, 3,
        1332119, 2,
        1332120, 1,
        1332121, 5,
        1332122, 4,
        1332123, 3,
        1332124, 2,
        1332125, 1,
        1342029, 5,
        1342030, 4,
        1342031, 3,
        1342032, 2,
        1342033, 1,
        1372074, 5,
        1372075, 4,
        1372076, 3,
        1372077, 2,
        1372078, 1,
        1382095, 5,
        1382096, 4,
        1382097, 3,
        1382098, 2,
        1392099, 1,
        1402086, 5,
        1402087, 4,
        1402088, 3,
        1402089, 2,
        1402090, 1,
        1412058, 5,
        1412059, 4,
        1412060, 3,
        1412061, 2,
        1412062, 1,
        1422059, 5,
        1422060, 4,
        1422061, 3,
        1422062, 2,
        1422063, 1,
        1432077, 5,
        1432078, 4,
        1432079, 3,
        1432080, 2,
        1432081, 1,
        1442107, 5,
        1442108, 4,
        1442109, 3,
        1442110, 2,
        1442111, 1,
        1452102, 5,
        1452103, 4,
        1452104, 3,
        1452105, 2,
        1452106, 1,
        1462087, 5,
        1462088, 4,
        1462089, 3,
        1462090, 2,
        1462091, 1,
        1472113, 5,
        1472114, 4,
        1472115, 3,
        1472116, 2,
        1472117, 1,
        1482075, 5,
        1482076, 4,
        1482077, 3,
        1482078, 2,
        1482079, 1,
        1492075, 5,
        1492076, 4,
        1492077, 3,
        1492078, 2,
        1492079, 1,
        1132012, 2,
        1132013, 1,
        1942002, 2,
        1952002, 2,
        1962002, 2,
        1972002, 2,
        1612004, 2,
        1622004, 2,
        1632004, 2,
        1642004, 2,
        1652004, 2,
        2047000, 1,
        2047001, 1,
        2047002, 1,
        2047100, 1,
        2047101, 1,
        2047102, 1,
        2047200, 1,
        2047201, 1,
        2047202, 1,
        2047203, 1,
        2047204, 1,
        2047205, 1,
        2047206, 1,
        2047207, 1,
        2047208, 1,
        2047300, 1,
        2047301, 1,
        2047302, 1,
        2047303, 1,
        2047304, 1,
        2047305, 1,
        2047306, 1,
        2047307, 1,
        2047308, 1,
        2047309, 1,
        2046004, 1,
        2046005, 1,
        2046104, 1,
        2046105, 1,
        2046208, 1,
        2046209, 1,
        2046210, 1,
        2046211, 1,
        2046212, 1,
        2049200, 1,
        2049201, 1,
        2049202, 1,
        2049203, 1,
        2049204, 1,
        2049205, 1,
        2049206, 1,
        2049207, 1,
        2049208, 1,
        2049209, 1,
        2049210, 1,
        2049211, 1,
        //ele wand
        1372035, 1,
        1372036, 1,
        1372037, 1,
        1372038, 1,
        //ele staff
        1382045, 1,
        1382046, 1,
        1382047, 1,
        1382048, 1,
        1382049, 1,
        1382050, 1, // Blue Dragon Staff
        1382051, 1,
        1382052, 1,
        1372039, 1,
        1372040, 1,
        1372041, 1,
        1372042, 1,
        2070016, 1,
        2070007, 2,
        2330007, 1,
        2070018, 1,
        2330008, 1,
        2070023, 1,
        2070024, 1,
        2028062, 5,
        2028061, 5};
    public static int[] eventCommonReward = {
        0, 10,
        1, 10,
        4, 5,
        5060004, 25,
        4170024, 25,
        4280000, 5,
        4280001, 6,
        5490000, 5,
        5490001, 6
    };
    public static int[] eventUncommonReward = {
        1, 4,
        2, 8,
        3, 8,
        2022179, 5,
        5062000, 20,
        2430082, 20,
        2430092, 20,
        2022459, 2,
        2022460, 1,
        2022462, 1,
        2430103, 2,
        2430117, 2,
        2430118, 2,
        2430201, 4,
        2430228, 4,
        2430229, 4,
        2430283, 4,
        2430136, 4,
        2430476, 4,
        2430511, 4,
        2430206, 4,
        2430199, 1,
        1032062, 5,
        5220000, 28,
        2022459, 5,
        2022460, 5,
        2022461, 5,
        2022462, 5,
        2022463, 5,
        5050000, 2,
        4080100, 10,
        4080000, 10,
        2049100, 10,
        2430144, 10,
        2290285, 10,
        2028062, 10,
        2028061, 10,
        2530000, 5,
        2531000, 5,
        2041100, 1,
        2041101, 1,
        2041102, 1,
        2041103, 1,
        2041104, 1,
        2041105, 1,
        2041106, 1,
        2041107, 1,
        2041108, 1,
        2041109, 1,
        2041110, 1,
        2041111, 1,
        2041112, 1,
        2041113, 1,
        2041114, 1,
        2041115, 1,
        2041116, 1,
        2041117, 1,
        2041118, 1,
        2041119, 1,
        2041300, 1,
        2041301, 1,
        2041302, 1,
        2041303, 1,
        2041304, 1,
        2041305, 1,
        2041306, 1,
        2041307, 1,
        2041308, 1,
        2041309, 1,
        2041310, 1,
        2041311, 1,
        2041312, 1,
        2041313, 1,
        2041314, 1,
        2041315, 1,
        2041316, 1,
        2041317, 1,
        2041318, 1,
        2041319, 1,
        2049200, 1,
        2049201, 1,
        2049202, 1,
        2049203, 1,
        2049204, 1,
        2049205, 1,
        2049206, 1,
        2049207, 1,
        2049208, 1,
        2049209, 1,
        2049210, 1,
        2049211, 1
    };
    public static int[] eventRareReward = {
        2049100, 5,
        2430144, 5,
        2290285, 5,
        2028062, 5,
        2028061, 5,
        2530000, 2,
        2531000, 2,
        2049116, 1,
        2049401, 10,
        2049301, 20,
        2049400, 3,
        2340000, 1,
        3010130, 5,
        3010131, 5,
        3010132, 5,
        3010133, 5,
        3010136, 5,
        3010116, 5,
        3010117, 5,
        3010118, 5,
        1112405, 1,
        1112445, 1,
        1022097, 1,
        2040211, 1,
        2040212, 1,
        2049000, 2,
        2049001, 2,
        2049002, 2,
        2049003, 2,
        1012058, 2,
        1012059, 2,
        1012060, 2,
        1012061, 2,
        2022460, 4,
        2022461, 3,
        2022462, 4,
        2022463, 3,
        2040041, 1,
        2040042, 1,
        2040334, 1,
        2040430, 1,
        2040538, 1,
        2040539, 1,
        2040630, 1,
        2040740, 1,
        2040741, 1,
        2040742, 1,
        2040829, 1,
        2040830, 1,
        2040936, 1,
        2041066, 1,
        2041067, 1,
        2043023, 1,
        2043117, 1,
        2043217, 1,
        2043312, 1,
        2043712, 1,
        2043812, 1,
        2044025, 1,
        2044117, 1,
        2044217, 1,
        2044317, 1,
        2044417, 1,
        2044512, 1,
        2044612, 1,
        2044712, 1,
        2046000, 1,
        2046001, 1,
        2046004, 1,
        2046005, 1,
        2046100, 1,
        2046101, 1,
        2046104, 1,
        2046105, 1,
        2046200, 1,
        2046201, 1,
        2046202, 1,
        2046203, 1,
        2046208, 1,
        2046209, 1,
        2046210, 1,
        2046211, 1,
        2046212, 1,
        2046300, 1,
        2046301, 1,
        2046302, 1,
        2046303, 1,
        2047000, 1,
        2047001, 1,
        2047002, 1,
        2047100, 1,
        2047101, 1,
        2047102, 1,
        2047200, 1,
        2047201, 1,
        2047202, 1,
        2047203, 1,
        2047204, 1,
        2047205, 1,
        2047206, 1,
        2047207, 1,
        2047208, 1,
        2047300, 1,
        2047301, 1,
        2047302, 1,
        2047303, 1,
        2047304, 1,
        2047305, 1,
        2047306, 1,
        2047307, 1,
        2047308, 1,
        2047309, 1,
        1112427, 5,
        1112428, 5,
        1112429, 5,
        1012240, 10,
        1022117, 10,
        1032095, 10,
        1112659, 10,
        2070007, 10,
        2330007, 5,
        2070016, 5,
        2070018, 5,
        1152038, 1,
        1152039, 1,
        1152040, 1,
        1152041, 1,
        1122090, 1,
        1122094, 1,
        1122098, 1,
        1122102, 1,
        1012213, 1,
        1012219, 1,
        1012225, 1,
        1012231, 1,
        1012237, 1,
        2070023, 5,
        2070024, 5,
        2330008, 5,
        2003516, 5,
        2003517, 1,
        1132052, 1,
        1132062, 1,
        1132072, 1,
        1132082, 1,
        1112585, 1,
        //walker
        1072502, 1,
        1072503, 1,
        1072504, 1,
        1072505, 1,
        1072506, 1,
        1052333, 1,
        1052334, 1,
        1052335, 1,
        1052336, 1,
        1052337, 1,
        1082305, 1,
        1082306, 1,
        1082307, 1,
        1082308, 1,
        1082309, 1,
        1003197, 1,
        1003198, 1,
        1003199, 1,
        1003200, 1,
        1003201, 1,
        1662000, 1,
        1662001, 1,
        1672000, 1,
        1672001, 1,
        1672002, 1,
        //crescent moon
        1112583, 1,
        1032092, 1,
        1132084, 1,
        //mounts, 90 day
        2430290, 1,
        2430292, 1,
        2430294, 1,
        2430296, 1,
        2430298, 1,
        2430300, 1,
        2430302, 1,
        2430304, 1,
        2430306, 1,
        2430308, 1,
        2430310, 1,
        2430312, 1,
        2430314, 1,
        2430316, 1,
        2430318, 1,
        2430320, 1,
        2430322, 1,
        2430324, 1,
        2430326, 1,
        2430328, 1,
        2430330, 1,
        2430332, 1,
        2430334, 1,
        2430336, 1,
        2430338, 1,
        2430340, 1,
        2430342, 1,
        2430344, 1,
        2430347, 1,
        2430349, 1,
        2430351, 1,
        2430353, 1,
        2430355, 1,
        2430357, 1,
        2430359, 1,
        2430361, 1,
        2430392, 1,
        2430512, 1,
        2430536, 1,
        2430477, 1,
        2430146, 1,
        2430148, 1,
        2430137, 1,};
    public static int[] eventSuperReward = {
        2022121, 10,
        4031307, 50,
        3010127, 10,
        3010128, 10,
        3010137, 10,
        3010157, 10,
        2049300, 10,
        2040758, 10,
        1442057, 10,
        2049402, 10,
        2049304, 1,
        2049305, 1,
        2040759, 7,
        2040760, 5,
        2040125, 10,
        2040126, 10,
        1012191, 5,
        1112514, 1, //untradable/tradable
        1112531, 1,
        1112629, 1,
        1112646, 1,
        1112515, 1, //untradable/tradable
        1112532, 1,
        1112630, 1,
        1112647, 1,
        1112516, 1, //untradable/tradable
        1112533, 1,
        1112631, 1,
        1112648, 1,
        2040045, 10,
        2040046, 10,
        2040333, 10,
        2040429, 10,
        2040542, 10,
        2040543, 10,
        2040629, 10,
        2040755, 10,
        2040756, 10,
        2040757, 10,
        2040833, 10,
        2040834, 10,
        2041068, 10,
        2041069, 10,
        2043022, 12,
        2043120, 12,
        2043220, 12,
        2043313, 12,
        2043713, 12,
        2043813, 12,
        2044028, 12,
        2044120, 12,
        2044220, 12,
        2044320, 12,
        2044520, 12,
        2044513, 12,
        2044613, 12,
        2044713, 12,
        2044817, 12,
        2044910, 12,
        2046002, 5,
        2046003, 5,
        2046102, 5,
        2046103, 5,
        2046204, 10,
        2046205, 10,
        2046206, 10,
        2046207, 10,
        2046304, 10,
        2046305, 10,
        2046306, 10,
        2046307, 10,
        2040006, 2,
        2040007, 2,
        2040303, 2,
        2040403, 2,
        2040506, 2,
        2040507, 2,
        2040603, 2,
        2040709, 2,
        2040710, 2,
        2040711, 2,
        2040806, 2,
        2040903, 2,
        2040913, 2,
        2041024, 2,
        2041025, 2,
        2044815, 2,
        2044908, 2,
        1152046, 1,
        1152047, 1,
        1152048, 1,
        1152049, 1,
        1122091, 1,
        1122095, 1,
        1122099, 1,
        1122103, 1,
        1012214, 1,
        1012220, 1,
        1012226, 1,
        1012232, 1,
        1012238, 1,
        1032088, 1,
        1032089, 1,
        1032090, 1,
        1032091, 1,
        1132053, 1,
        1132063, 1,
        1132073, 1,
        1132083, 1,
        1112586, 1,
        1112593, 1,
        1112597, 1,
        1662002, 1,
        1662003, 1,
        1672003, 1,
        1672004, 1,
        1672005, 1,
        //130, 140 weapons
        1092088, 1,
        1092089, 1,
        1092087, 1,
        1102275, 1,
        1102276, 1,
        1102277, 1,
        1102278, 1,
        1102279, 1,
        1102280, 1,
        1102281, 1,
        1102282, 1,
        1102283, 1,
        1102284, 1,
        1082295, 1,
        1082296, 1,
        1082297, 1,
        1082298, 1,
        1082299, 1,
        1082300, 1,
        1082301, 1,
        1082302, 1,
        1082303, 1,
        1082304, 1,
        1072485, 1,
        1072486, 1,
        1072487, 1,
        1072488, 1,
        1072489, 1,
        1072490, 1,
        1072491, 1,
        1072492, 1,
        1072493, 1,
        1072494, 1,
        1052314, 1,
        1052315, 1,
        1052316, 1,
        1052317, 1,
        1052318, 1,
        1052319, 1,
        1052329, 1,
        1052321, 1,
        1052322, 1,
        1052323, 1,
        1003172, 1,
        1003173, 1,
        1003174, 1,
        1003175, 1,
        1003176, 1,
        1003177, 1,
        1003178, 1,
        1003179, 1,
        1003180, 1,
        1003181, 1,
        1302152, 1,
        1302153, 1,
        1312065, 1,
        1312066, 1,
        1322096, 1,
        1322097, 1,
        1332130, 1,
        1332131, 1,
        1342035, 1,
        1342036, 1,
        1372084, 1,
        1372085, 1,
        1382104, 1,
        1382105, 1,
        1402095, 1,
        1402096, 1,
        1412065, 1,
        1412066, 1,
        1422066, 1,
        1422067, 1,
        1432086, 1,
        1432087, 1,
        1442116, 1,
        1442117, 1,
        1452111, 1,
        1452112, 1,
        1462099, 1,
        1462100, 1,
        1472122, 1,
        1472123, 1,
        1482084, 1,
        1482085, 1,
        1492085, 1,
        1492086, 1,
        1532017, 1,
        1532018, 1,
        //mounts
        2430291, 1,
        2430293, 1,
        2430295, 1,
        2430297, 1,
        2430299, 1,
        2430301, 1,
        2430303, 1,
        2430305, 1,
        2430307, 1,
        2430309, 1,
        2430311, 1,
        2430313, 1,
        2430315, 1,
        2430317, 1,
        2430319, 1,
        2430321, 1,
        2430323, 1,
        2430325, 1,
        2430327, 1,
        2430329, 1,
        2430331, 1,
        2430333, 1,
        2430335, 1,
        2430337, 1,
        2430339, 1,
        2430341, 1,
        2430343, 1,
        2430345, 1,
        2430348, 1,
        2430350, 1,
        2430352, 1,
        2430354, 1,
        2430356, 1,
        2430358, 1,
        2430360, 1,
        2430362, 1,
        //rising sun
        1012239, 1,
        1122104, 1,
        1112584, 1,
        1032093, 1,
        1132085, 1
    };
    public static int[] tenPercent = {
        //10% scrolls
        2040002,
        2040005,
        2040026,
        2040031,
        2040100,
        2040105,
        2040200,
        2040205,
        2040302,
        2040310,
        2040318,
        2040323,
        2040328,
        2040329,
        2040330,
        2040331,
        2040402,
        2040412,
        2040419,
        2040422,
        2040427,
        2040502,
        2040505,
        2040514,
        2040517,
        2040534,
        2040602,
        2040612,
        2040619,
        2040622,
        2040627,
        2040702,
        2040705,
        2040708,
        2040727,
        2040802,
        2040805,
        2040816,
        2040825,
        2040902,
        2040915,
        2040920,
        2040925,
        2040928,
        2040933,
        2041002,
        2041005,
        2041008,
        2041011,
        2041014,
        2041017,
        2041020,
        2041023,
        2041058,
        2041102,
        2041105,
        2041108,
        2041111,
        2041302,
        2041305,
        2041308,
        2041311,
        2043002,
        2043008,
        2043019,
        2043102,
        2043114,
        2043202,
        2043214,
        2043302,
        2043402,
        2043702,
        2043802,
        2044002,
        2044014,
        2044015,
        2044102,
        2044114,
        2044202,
        2044214,
        2044302,
        2044314,
        2044402,
        2044414,
        2044502,
        2044602,
        2044702,
        2044802,
        2044809,
        2044902,
        2045302,
        2048002,
        2048005
    };
    public static int[] fishingReward = {
        0, 100, // Meso
        1, 100, // EXP
        2022179, 1, // Onyx Apple
        1302021, 5, // Pico Pico Hammer
        1072238, 1, // Voilet Snowshoe
        1072239, 1, // Yellow Snowshoe
        2049100, 2, // Chaos Scroll
        2430144, 1,
        2290285, 1,
        2028062, 1,
        2028061, 1,
        2049301, 1, // Equip Enhancer Scroll
        2049401, 1, // Potential Scroll
        1302000, 3, // Sword
        1442011, 1, // Surfboard
        4000517, 8, // Golden Fish
        4000518, 10, // Golden Fish Egg
        4031627, 2, // White Bait (3cm)
        4031628, 1, // Sailfish (120cm)
        4031630, 1, // Carp (30cm)
        4031631, 1, // Salmon(150cm)
        4031632, 1, // Shovel
        4031633, 2, // Whitebait (3.6cm)
        4031634, 1, // Whitebait (5cm)
        4031635, 1, // Whitebait (6.5cm)
        4031636, 1, // Whitebait (10cm)
        4031637, 2, // Carp (53cm)
        4031638, 2, // Carp (60cm)
        4031639, 1, // Carp (100cm)
        4031640, 1, // Carp (113cm)
        4031641, 2, // Sailfish (128cm)
        4031642, 2, // Sailfish (131cm)
        4031643, 1, // Sailfish (140cm)
        4031644, 1, // Sailfish (148cm)
        4031645, 2, // Salmon (166cm)
        4031646, 2, // Salmon (183cm)
        4031647, 1, // Salmon (227cm)
        4031648, 1, // Salmon (288cm)
        4001187, 20,
        4001188, 20,
        4001189, 20,
        4031629, 1 // Pot
    };

    public static boolean isReverseItem(int itemId) {
        switch (itemId) {
            case 1002790:
            case 1002791:
            case 1002792:
            case 1002793:
            case 1002794:
            case 1082239:
            case 1082240:
            case 1082241:
            case 1082242:
            case 1082243:
            case 1052160:
            case 1052161:
            case 1052162:
            case 1052163:
            case 1052164:
            case 1072361:
            case 1072362:
            case 1072363:
            case 1072364:
            case 1072365:

            case 1302086:
            case 1312038:
            case 1322061:
            case 1332075:
            case 1332076:
            case 1372045:
            case 1382059:
            case 1402047:
            case 1412034:
            case 1422038:
            case 1432049:
            case 1442067:
            case 1452059:
            case 1462051:
            case 1472071:
            case 1482024:
            case 1492025:

            case 1342012:
            case 1942002:
            case 1952002:
            case 1962002:
            case 1972002:
            case 1532016:
            case 1522017:
                return true;
            default:
                return false;
        }
    }

    public static boolean isTimelessItem(int itemId) {
        switch (itemId) {
            case 1032031: //shield earring, but technically
            case 1102172:
            case 1002776:
            case 1002777:
            case 1002778:
            case 1002779:
            case 1002780:
            case 1082234:
            case 1082235:
            case 1082236:
            case 1082237:
            case 1082238:
            case 1052155:
            case 1052156:
            case 1052157:
            case 1052158:
            case 1052159:
            case 1072355:
            case 1072356:
            case 1072357:
            case 1072358:
            case 1072359:
            case 1092057:
            case 1092058:
            case 1092059:

            case 1122011:
            case 1122012:

            case 1302081:
            case 1312037:
            case 1322060:
            case 1332073:
            case 1332074:
            case 1372044:
            case 1382057:
            case 1402046:
            case 1412033:
            case 1422037:
            case 1432047:
            case 1442063:
            case 1452057:
            case 1462050:
            case 1472068:
            case 1482023:
            case 1492023:
            case 1342011:
            case 1532015:
            case 1522016:
                //raven.
                return true;
            default:
                return false;
        }
    }

    public static boolean isRing(int itemId) {
        return itemId >= 1112000 && itemId < 1113000;
    }// 112xxxx - pendants, 113xxxx - belts

    //if only there was a way to find in wz files -.-
    public static boolean isEffectRing(int itemid) {
        return isFriendshipRing(itemid) || isCrushRing(itemid) || isMarriageRing(itemid);
    }

    public static boolean isMarriageRing(int itemId) {
        switch (itemId) {
            case 1112803:
            case 1112806:
            case 1112807:
            case 1112809:
                return true;
        }
        return false;
    }

    public static boolean isFriendshipRing(int itemId) {
        switch (itemId) {
            case 1112800:
            case 1112801:
            case 1112802:
            case 1112810: //new
            case 1112811: //new, doesnt work in friendship?
            case 1112812: //new, im ASSUMING it's friendship cuz of itemID, not sure.
            case 1112816: //new, i'm also assuming
            case 1112817:

            case 1049000:
                return true;
        }
        return false;
    }

    public static boolean isCrushRing(int itemId) {
        switch (itemId) {
            case 1112001:
            case 1112002:
            case 1112003:
            case 1112005: //new
            case 1112006: //new
            case 1112007:
            case 1112012:
            case 1112015: //new

            case 1048000:
            case 1048001:
            case 1048002:
                return true;
        }
        return false;
    }
    public static int[] Equipments_Bonus = {1122017};

    public static int Equipment_Bonus_EXP(final int itemid) {
        switch (itemid) {
            case 1122017:
                return 10;
        }
        return 0;
    }
    public static int[] blockedMaps = {109050000, 280030000, 240060200, 280090000, 280030001, 240060201, 950101100, 950101010};
    public static final int[] normalDrops = {4001009, 4001010, 4001011, 4001012, 4001013, 4001014, 4001021, 4001038, 4001039, 4001040, 4001041, 4001042, 4001043, 4001038, 4001039, 4001040, 4001041, 4001042, 4001043, 4001038, 4001039, 4001040, 4001041, 4001042, 4001043, 4000164, 2000000, 2000003, 2000004, 2000005, 4000019, 4000000, 4000016, 4000006, 2100121, 4000029, 4000064, 5110000, 4000306, 4032181, 4006001, 4006000, 2050004, 3994102, 3994103, 3994104, 3994105, 2430007, 4000164, 2000000, 2000003, 2000004, 2000005, 4000019, 4000000, 4000016, 4000006, 2100121, 4000029, 4000064, 5110000, 4000306, 4032181, 4006001, 4006000, 2050004, 3994102, 3994103, 3994104, 3994105, 2430007, 4000164, 2000000, 2000003, 2000004, 2000005, 4000019, 4000000, 4000016, 4000006, 2100121, 4000029, 4000064, 5110000, 4000306, 4032181, 4006001, 4006000, 2050004, 3994102, 3994103, 3994104, 3994105, 2430007};
    public static final int[] rareDrops = {2022179, 2049100, 2049100, 2430144, 2028062, 2028061, 2290285, 2049301, 2049401, 2022326, 2022193, 2049000, 2049001, 2049002};
    public static final int[] superDrops = {2040804, 2049400, 2028062, 2028061, 2430144, 2430144, 2430144, 2430144, 2290285, 2049100, 2049100, 2049100, 2049100};
    public static int[] owlItems = {1082002, 2070005, 2070006, 1022047, 1102041, 2044705, 2340000, 2040017, 1092030, 2040804};

    public static int getExpForLevel(int i, int itemId) {
        if (isReverseItem(itemId)) {
            return getReverseRequiredEXP(i);
        } else if (getMaxLevel(itemId) > 0) {
            return getTimelessRequiredEXP(i);
        }
        return 0;
    }

    public static int getMaxLevel(final int itemId) {
        Map<Integer, Map<String, Integer>> inc = MapleItemInformationProvider.getInstance().getEquipIncrements(itemId);
        return inc != null ? (inc.size()) : 0;
    }

    public static int getStatChance() {
        return 25;
    }

    public static MonsterStatus getStatFromWeapon(final int itemid) {
        switch (itemid) {
            case 1302109:
            case 1312041:
            case 1322067:
            case 1332083:
            case 1372048:
            case 1382064:
            case 1402055:
            case 1412037:
            case 1422041:
            case 1432052:
            case 1442073:
            case 1452064:
            case 1462058:
            case 1472079:
            case 1482035:
                return MonsterStatus.DARKNESS;
            case 1302108:
            case 1312040:
            case 1322066:
            case 1332082:
            case 1372047:
            case 1382063:
            case 1402054:
            case 1412036:
            case 1422040:
            case 1432051:
            case 1442072:
            case 1452063:
            case 1462057:
            case 1472078:
            case 1482036:
                return MonsterStatus.SPEED;
        }
        return null;
    }

    public static int getXForStat(MonsterStatus stat) {
        switch (stat) {
            case DARKNESS:
                return -70;
            case SPEED:
                return -50;
        }
        return 0;
    }

    public static int getSkillForStat(MonsterStatus stat) {
        switch (stat) {
            case DARKNESS:
                return 1111003;
            case SPEED:
                return 3121007;
        }
        return 0;
    }

    public static int fixDemonForce(final MapleCharacter chr) {
        return (MapleJob.is惡魔殺手(chr.getJob()) && (chr.getJob() % 10) == 0 ? ((chr.getJob() % 100) == 0 ? -85 : 10) : chr.getStat().maxmp);
    }

    public static int getSkillBookBySkill(final int skillId) {
        return getSkillBookByJob(skillId / 10000, skillId);
    }

    public static int getSkillBookByJob(int job) {
        return getSkillBookByJob(job, 0);
    }

    public static int getSkillBookByJob(final int job, final int skillId) {
        if (MapleJob.isBeginner(job)) {
            return 0;
        }

        if (MapleJob.is神之子(job)) {
            if (skillId > 0) {
                int type = (skillId % 1000) / 100; //1 beta 2 alpha
                return type == 1 ? 1 : 0;
            } else {
                return 0;
            }
        }

        if (isSeparatedSp(job)) {
            return MapleJob.getNumber(job) - 1;
        }

        return 0;
    }

    public static int getSkillBook(final int job, final int level) {
        return getSkillBook(job, level, 0);
    }

    public static int getSkillBook(final int job, final int level, final int skillId) {
        if (MapleJob.is龍魔導士(job)) {
            return level > 160 ? 9 : level > 120 ? 8 : level > 100 ? 7 : level > 80 ? 6 : level > 60 ? 5 : level > 50 ? 4 : level > 40 ? 3 : level > 30 ? 2 : level > 20 ? 1 : 0;
        }

        if (MapleJob.is影武者(job)) {
            return level > 100 ? 5 : level > 60 ? 4 : level > 45 ? 3 : level > 30 ? 2 : level > 20 ? 1 : 0;
        }

        if (MapleJob.is神之子(job)) {
            if (skillId > 0) {
                int type = (skillId % 1000) / 100; //1 beta 2 alpha
                return type == 1 ? 1 : 0;
            } else {
                return 0;
            }
        }

        if (isSeparatedSp(job)) {
            return level > 100 ? 3 : level > 60 ? 2 : level > 30 ? 1 : 0;
        }

        return 0;
    }

    public static boolean isSeparatedSp(int job) {
        return !MapleJob.is管理員(job) && !MapleJob.is幻獸師(job);
    }

    public static int getLinkedMountItem(final int sourceid) {
        switch (sourceid % 1000) {
            case 1:
            case 24:
            case 25:
                return 1018;
            case 2:
            case 26:
                return 1019;
            case 3:
                return 1025;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return (sourceid % 1000) + 1023;
            case 9:
            case 10:
            case 11:
                return (sourceid % 1000) + 1024;
            case 12:
                return 1042;
            case 13:
                return 1044;
            case 14:
                return 1049;
            case 15:
            case 16:
            case 17:
                return (sourceid % 1000) + 1036;
            case 18:
            case 19:
                return (sourceid % 1000) + 1045;
            case 20:
                return 1072;
            case 21:
                return 1084;
            case 22:
                return 1089;
            case 23:
                return 1106;
            case 29:
                return 1151;
            case 30:
            case 50:
                return 1054;
            case 31:
            case 51:
                return 1069;
            case 32:
                return 1138;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return (sourceid % 1000) + 1009;
            case 52:
                return 1070;
            case 53:
                return 1071;
            case 54:
                return 1096;
            case 55:
                return 1101;
            case 56:
                return 1102;
            case 58:
                return 1118;
            case 59:
                return 1121;
            case 60:
                return 1122;
            case 61:
                return 1129;
            case 62:
                return 1139;
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
                return (sourceid % 1000) + 1080;
            case 85:
            case 86:
            case 87:
                return (sourceid % 1000) + 928;
            case 88:
                return 1065;

            case 27:
                return 1932049; //airplane
            case 28:
                return 1932050; //airplane
            case 114:
                return 1932099; //bunny buddy
            //33 = hot air
            //37 = bjorn
            //38 = speedy chariot
            //57 = law officer
            //they all have in wz so its ok
        }
        return 0;
    }

    public static int getMountItem(final int sourceid, final MapleCharacter chr) {
        switch (sourceid) {
            case 5221006:
                return 1932000;
            case 33001001: //temp.
                if (chr == null) {
                    return 1932015;
                }
                switch (chr.getIntNoRecord(JAGUAR)) {
                    case 20:
                        return 1932030;
                    case 30:
                        return 1932031;
                    case 40:
                        return 1932032;
                    case 50:
                        return 1932033;
                    case 60:
                        return 1932036;
                    case 70:
                        return 1932100;
                }
                return 1932015;
            case 35001002:
            case 35120000:
                return 1932016;
            //case 30011109:
            //	return 1932085;
        }
        if (!MapleJob.isBeginner(sourceid / 10000)) {
            if (sourceid / 10000 == 8000 && sourceid != 80001000) { //todoo clean up
                final Skill skil = SkillFactory.getSkill(sourceid);
                if (skil != null && skil.getTamingMob() > 0) {
                    return skil.getTamingMob();
                    //} else if (skil != null && skil.getSkillTamingMob() > 0) {
                    //    return skil.getSkillTamingMob();
                } else {
                    final int link = getLinkedMountItem(sourceid);
                    if (link > 0) {
                        if (link < 10000) {
                            return getMountItem(link, chr);
                        } else {
                            return link;
                        }
                    }
                }
            }
            return 0;
        }
        if (MapleJob.isBeginner(sourceid / 10000)) {
            if (sourceid != 80001000) { //todoo clean up
                final Skill skil = SkillFactory.getSkill(sourceid);
                if (skil != null && skil.getSkillTamingMob() > 0) {
                    return skil.getSkillTamingMob();
                }
            }
        }
        switch (sourceid) {
            case 20021160: //Sylvidia
                return 1932086;
            case 20021161: //Sylvidia
                return 1932087;
            case 20031160: //Rolls
                return 1932106;
            case 20031161: //Royce
                return 1932107;
            case 30011109: //Demon Wings
                return 1932051;
            case 30011159: //Demon Wings
                return 1932051;
        }
        switch (sourceid % 10000) {
            case 1013:
            case 1046:
                return 1932001;
            case 1015:
            case 1048:
                return 1932002;
            case 1016:
            case 1017:
            case 1027:
                return 1932007;
            case 1018:
                return 1932003;
            case 1019:
                return 1932005;
            case 1025:
                return 1932006;
            case 1028:
                return 1932008;
            case 1029:
                return 1932009;
            case 1030:
                return 1932011;
            case 1031:
                return 1932010;
            case 1033:
                return 1932013;
            case 1034:
                return 1932014;
            case 1035:
                return 1932012;
            case 1036:
                return 1932017;
            case 1037:
                return 1932018;
            case 1038:
                return 1932019;
            case 1039:
                return 1932020;
            case 1040:
                return 1932021;
            case 1042:
                return 1932022;
            case 1044:
                return 1932023;
            //case 1045:
            //return 1932030; //wth? helicopter? i didnt see one, so we use hog
            case 1049:
                return 1932025;
            case 1050:
                return 1932004;
            case 1051:
                return 1932026;
            case 1052:
                return 1932027;
            case 1053:
                return 1932028;
            case 1054:
                return 1932029;
            case 1063:
                return 1932034;
            case 1064:
                return 1932035;
            case 1065:
                return 1932037;
            case 1069:
                return 1932038;
            case 1070:
                return 1932039;
            case 1071:
                return 1932040;
            case 1072:
                return 1932041;
            case 1084:
                return 1932043;
            case 1089:
                return 1932044;
            case 1096:
                return 1932045;
            case 1101:
                return 1932046;
            case 1102:
                return 1932061;
            case 1106:
                return 1932048;
            case 1118:
                return 1932060;
            case 1115:
                return 1932052;
            case 1121:
                return 1932063;
            case 1122:
                return 1932064;
            case 1123:
                return 1932065;
            case 1128:
                return 1932066;
            case 1130:
                return 1932072;
            case 1136:
                return 1932078;
            case 1138:
                return 1932080;
            case 1139:
                return 1932081;
            //FLYING
            case 1143:
            case 1144:
            case 1145:
            case 1146:
            case 1147:
            case 1148:
            case 1149:
            case 1150:
            case 1151:
            case 1152:
            case 1153:
            case 1154:
            case 1155:
            case 1156:
            case 1157:
                return 1992000 + (sourceid % 10000) - 1143;
            default:
                return 0;
        }
    }

    public static boolean isKatara(int itemId) {
        return itemId / 10000 == 134;
    }

    public static boolean isDagger(int itemId) {
        return itemId / 10000 == 133;
    }

    public static boolean isApplicableSkill(int skil) {
        return ((skil < 80000000 || skil >= 100000000) && (skil % 10000 < 8000 || skil % 10000 > 8006) && !isAngel(skil)) || skil >= 92000000 || (skil >= 80000000 && skil < 80010000); //no additional/decent skills
    }

    public static boolean isApplicableSkill_(int skil) { //not applicable to saving but is more of temporary
        for (int i : PlayerStats.pvpSkills) {
            if (skil == i) {
                return true;
            }
        }
        return (skil >= 90000000 && skil < 92000000) || (skil % 10000 >= 8000 && skil % 10000 <= 8003) || isAngel(skil);
    }

    public static boolean isRidingSKill(int skil) {
        return (skil >= 80001000 && skil < 80010000);
    }

    public static boolean isTablet(int itemId) {
        return itemId / 1000 == 2047;
    }

    public static boolean isGeneralScroll(int itemId) {
        return itemId / 1000 == 2046;
    }

    public static boolean isTMSSpecialScroll(int itemId) {
        return itemId / 10000 == 261;
    }

    public static int getSuccessTablet(final int scrollId, final int level) {
        if (scrollId % 1000 / 100 == 2) { //2047_2_00 = armor, 2047_3_00 = accessory
            switch (level) {
                case 0:
                    return 70;
                case 1:
                    return 55;
                case 2:
                    return 43;
                case 3:
                    return 33;
                case 4:
                    return 26;
                case 5:
                    return 20;
                case 6:
                    return 16;
                case 7:
                    return 12;
                case 8:
                    return 10;
                default:
                    return 7;
            }
        } else if (scrollId % 1000 / 100 == 3) {
            switch (level) {
                case 0:
                    return 70;
                case 1:
                    return 35;
                case 2:
                    return 18;
                case 3:
                    return 12;
                default:
                    return 7;
            }
        } else {
            switch (level) {
                case 0:
                    return 70;
                case 1:
                    return 50; //-20
                case 2:
                    return 36; //-14
                case 3:
                    return 26; //-10
                case 4:
                    return 19; //-7
                case 5:
                    return 14; //-5
                case 6:
                    return 10; //-4
                default:
                    return 7;  //-3
            }
        }
    }

    public static int getCurseTablet(final int scrollId, final int level) {
        if (scrollId % 1000 / 100 == 2) { //2047_2_00 = armor, 2047_3_00 = accessory
            switch (level) {
                case 0:
                    return 10;
                case 1:
                    return 12;
                case 2:
                    return 16;
                case 3:
                    return 20;
                case 4:
                    return 26;
                case 5:
                    return 33;
                case 6:
                    return 43;
                case 7:
                    return 55;
                case 8:
                    return 70;
                default:
                    return 100;
            }
        } else if (scrollId % 1000 / 100 == 3) {
            switch (level) {
                case 0:
                    return 12;
                case 1:
                    return 18;
                case 2:
                    return 35;
                case 3:
                    return 70;
                default:
                    return 100;
            }
        } else {
            switch (level) {
                case 0:
                    return 10;
                case 1:
                    return 14; //+4
                case 2:
                    return 19; //+5
                case 3:
                    return 26; //+7
                case 4:
                    return 36; //+10
                case 5:
                    return 50; //+14
                case 6:
                    return 70; //+20
                default:
                    return 100;  //+30
            }
        }
    }

    public static boolean isAccessory(final int itemId) {
        return (itemId >= 1010000 && itemId < 1040000) || (itemId >= 1122000 && itemId < 1153000) || (itemId >= 1112000 && itemId < 1115000) || (itemId >= 1670000 && itemId < 1680000);
    }

    public static boolean isMedal(final int itemId) {
        return itemId / 10000 == 114;
    }

    public static boolean potentialIDFits(final int potentialID, final int newstate, final int i) {
        //first line is always the best
        //but, sometimes it is possible to get second/third line as well
        //may seem like big chance, but it's not as it grabs random potential ID anyway
        if (newstate == 20) {
            return (i == 0 || Randomizer.nextInt(20) == 0 ? potentialID >= 40000 : potentialID >= 30000 && potentialID < 60004); // xml say so
        } else if (newstate == 19) {
            return (i == 0 || Randomizer.nextInt(20) == 0 ? potentialID >= 30000 && potentialID < 40000 : potentialID >= 20000 && potentialID < 30000);
        } else if (newstate == 18) {
            return (i == 0 || Randomizer.nextInt(20) == 0 ? potentialID >= 20000 && potentialID < 30000 : potentialID >= 10000 && potentialID < 20000);
        } else if (newstate == 17) {
            return (i == 0 || Randomizer.nextInt(20) == 0 ? potentialID >= 10000 && potentialID < 20000 : potentialID < 10000);
        } else {
            return false;
        }
    }

    public static boolean optionTypeFits(final int optionType, final int itemId) {
        switch (optionType) {
            case 10: // 武器、盾牌、副手和能源
                return isWeapon(itemId) || isShield(itemId) || isSpecialShield(itemId) || isEnergy(itemId);
            case 11: // 除了武器的全部裝備
                return !isWeapon(itemId);
            case 20: // 除了配飾和武器的全部裝備
                return !isAccessory(itemId) && !isWeapon(itemId);
            case 40: // 配飾
                return isAccessory(itemId);
            case 51: // 帽子
                return itemId / 10000 == 100;
            case 52: // 披風
                return itemId / 10000 == 110;
            case 53: // 上衣、褲子與套服
                return itemId / 10000 == 104 || itemId / 10000 == 105 || itemId / 10000 == 106;
            case 54: // 手套
                return itemId / 10000 == 108;
            case 55: // 鞋子
                return itemId / 10000 == 107;
            default:
                return true;
        }
    }

    public static boolean isAllowedPotentialStat(Equip eqp, int opID, boolean bonus) { //For now
        MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
        boolean superPot = ZZMSConfig.superiorPotential && ii.isSuperiorEquip(eqp.getItemId());
        //判斷潛能是主潛還是附潛
        int type = opID / 1000 % 10;
        if ((bonus && ((!superPot && type != 2) || (superPot && type >= 1))) || (!bonus && type == 2)) {
            return false;
        }
        //清除罕見以上潛能的非常的垃圾潛能
        int state = opID / 10000;
        if (opID % 1000 <= 14 && state > 2 && state < 5 && opID < 60000 && Randomizer.nextInt(10) <= 9) {
            return false;
        }

        state = opID % 1000;
        return superPot && !bonus ? (state != 4 && state != 9  && state != 24 && (state < 13 || state > 18)) : opID < 60000;
    }

    public static int getNebuliteGrade(final int id) {
        if (id / 10000 != 306) {
            return -1;
        }
        if (id >= 3060000 && id < 3061000) {
            return 0;
        } else if (id >= 3061000 && id < 3062000) {
            return 1;
        } else if (id >= 3062000 && id < 3063000) {
            return 2;
        } else if (id >= 3063000 && id < 3064000) {
            return 3;
        }
        return 4;
    }

    public static final boolean isMountItemAvailable(int mountid, int jobid) {
        if ((jobid != 900) && (mountid / 10000 == 190)) {
            switch (mountid) {
                case 1902000:
                case 1902001:
                case 1902002:
                    return MapleJob.is冒險家(jobid);
                case 1902005:
                case 1902006:
                case 1902007:
                    return MapleJob.is皇家騎士團(jobid);
                case 1902015:
                case 1902016:
                case 1902017:
                case 1902018:
                    return MapleJob.is狂狼勇士(jobid);
                case 1902040:
                case 1902041:
                case 1902042:
                    return MapleJob.is龍魔導士(jobid);
                case 1902003:
                case 1902004:
                case 1902008:
                case 1902009:
                case 1902010:
                case 1902011:
                case 1902012:
                case 1902013:
                case 1902014:
                case 1902019:
                case 1902020:
                case 1902021:
                case 1902022:
                case 1902023:
                case 1902024:
                case 1902025:
                case 1902026:
                case 1902027:
                case 1902028:
                case 1902029:
                case 1902030:
                case 1902031:
                case 1902032:
                case 1902033:
                case 1902034:
                case 1902035:
                case 1902036:
                case 1902037:
                case 1902038:
                case 1902039:
            }
            if (MapleJob.is末日反抗軍(jobid)) {
                return false;
            }
        }
        if (mountid / 10000 != 190) {
            return false;
        }
        return true;
    }

    public static boolean isMechanicItem(final int itemId) {
        return itemId >= 1610000 && itemId < 1660000;
    }

    public static boolean isEvanDragonItem(final int itemId) {
        return itemId >= 1940000 && itemId < 1980000; //194 = mask, 195 = pendant, 196 = wings, 197 = tail
    }

    public static boolean canScroll(final int itemId) {
        return (itemId / 100000 != 19 && itemId / 100000 != 16) || isMacHeart(itemId); //no mech/taming/dragon/心臟
    }

    public static boolean canHammer(final int itemId) {
        switch (itemId) {
            case 1122000:
            case 1122076: //ht, chaos ht
                return false;
        }
        return canScroll(itemId);
    }

    public static int getMasterySkill(final int job) {
        if (job >= 1410 && job <= 1412) {
            return 14100000;
        } else if (job >= 410 && job <= 412) {
            return 4100000;
        } else if (job >= 520 && job <= 522) {
            return 5200000;
        }
        return 0;
    }

    public static int getExpRate_Below10(final int job) {
        //if (GameConstants.isEvan(job)) {
        //    return 1;
        //} else if (GameConstants.isAran(job) || GameConstants.isKOC(job) || GameConstants.isResistance(job)) {
        //    return 5;
        //}
        //return 10;
        return 1;
    }

    public static int getExpRate_Quest(final int level) {
        return (level >= 30 ? (level >= 70 ? (level >= 120 ? 1 : 1) : 1) : 1);
    }

    public static String getCommandBlockedMsg() {
        return "You may not use this command here.";
    }

    public static int getCustomReactItem(final int rid, final int original) {
        if (rid == 2008006) { //orbis pq LOL
            return (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) + 4001055);
            //4001056 = sunday. 4001062 = saturday
        } else {
            return original;
        }
    }

    public static boolean isAzwanMap(int mapId) {
        return mapId >= 262020000 && mapId < 262023000;
    }

    public static boolean isForceRespawn(int mapid) {
        switch (mapid) {
            case 103000800: //kerning PQ crocs
            case 925100100: //crocs and stuff
            case 100010000:
                return true;
            default:
                return mapid / 100000 == 9800 && (mapid % 10 == 1 || mapid % 1000 == 100);
        }
    }

    public static int getFishingTime(boolean vip, boolean gm) {
        return gm ? 1000 : (vip ? 30000 : 60000);
    }

    public static int getCustomSpawnID(int summoner, int def) {
        switch (summoner) {
            case 9400589:
            case 9400748: //MV
                return 9400706; //jr
            default:
                return def;
        }
    }

    public static boolean canForfeit(int questid) {
        switch (questid) {
            case 20000:
            case 20010:
            case 20015: //cygnus quests
            case 20020:
                return false;
            default:
                return true;
        }
    }

    public static double getAttackRange(MapleStatEffect def, int rangeInc) {
        double defRange = ((400.0 + rangeInc) * (400.0 + rangeInc));
        if (def != null) {
            defRange += def.getMaxDistanceSq() + (def.getRange() * def.getRange());
        }
        //rangeInc adds to X
        //400 is approximate, screen is 600.. may be too much
        //200 for y is also too much
        //default 200000
        return defRange + 120000.0;
    }

    public static double getAttackRange(Point lt, Point rb) {
        double defRange = (400.0 * 400.0);
        final int maxX = Math.max(Math.abs(lt == null ? 0 : lt.x), Math.abs(rb == null ? 0 : rb.x));
        final int maxY = Math.max(Math.abs(lt == null ? 0 : lt.y), Math.abs(rb == null ? 0 : rb.y));
        defRange += (maxX * maxX) + (maxY * maxY);
        //rangeInc adds to X
        //400 is approximate, screen is 600.. may be too much
        //200 for y is also too much
        //default 200000
        return defRange + 120000.0;
    }

    public static long getMagnifyPrice(Equip eq) {
        MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
        if (!ii.getEquipStats(eq.getItemId()).containsKey("reqLevel")) {
            return -1;
        }
        int level = ii.getEquipStats(eq.getItemId()).get("reqLevel");
        long price;
        int v1; // esi@1
        double v2; // st7@7
        int v3; // eax@7
        double v4; // st6@7
        int v5; // eax@12

        v1 = 0;
        if (level > 120) {
            v1 = 20;
        } else if (level > 70) {
            v1 = 5;
        } else if (level > 30) {
            v1 = 1;
        }
        v2 = level;
        v3 = 2;
        v4 = 1.0;
        while (1 != 0) {
            if ((v3 & 1) != 0) {
                v4 = v4 * v2;
            }
            v3 >>= 1;
            if (!(v3 != 0)) {
                break;
            }
            v2 = v2 * v2;
        }
        v5 = (int) Math.ceil(v4);
        price = ((v1 * v5 <= 0 ? 1 : 0) - 1) & v1 * v5;

        return price;
    }

    public static int getLowestPrice(int itemId) {
        switch (itemId) {
            case 2340000: //ws
            case 2531000:
            case 2530000:
                return 50000000;
        }
        return -1;
    }

    public static boolean isNoDelaySkill(int skillId) {
        return skillId == 5110001 || skillId == 21101003 || skillId == 15100004 || skillId == 33101004 || skillId == 32111010 || skillId == 2111007 || skillId == 2211007 || skillId == 2311007 || skillId == 32121003 || skillId == 35121005 || skillId == 35111004 || skillId == 35121013 || skillId == 35121003 || skillId == 22150004 || skillId == 22181004 || skillId == 11101002 || skillId == 51100002 || skillId == 13101002 || skillId == 24121000 || skillId == 112001008 || skillId == 22161005 || skillId == 22161005;
    }

    public static boolean isNoSpawn(int mapID) {
        return mapID == 809040100 || mapID == 925020010 || mapID == 925020011 || mapID == 925020012 || mapID == 925020013 || mapID == 925020014 || mapID == 682020000 || mapID == 980010000 || mapID == 980010100 || mapID == 980010200 || mapID == 980010300 || mapID == 980010020;
    }

    public static int getExpRate(int job, int def) {
        return def;
    }

    public static int getModifier(int itemId, int up) {
        if (up <= 0) {
            return 0;
        }
        switch (itemId) {
            case 2022459:
            case 2860179:
            case 2860193:
            case 2860207:
                return 130;
            case 2022460:
            case 2022462:
            case 2022730:
                return 150;
            case 2860181:
            case 2860195:
            case 2860209:
                return 200;
        }
        if (itemId / 10000 == 286) { //familiars
            return 150;
        }
        return 200;
    }

    public static short getSlotMax(int itemId) {
        switch (itemId) {
            case 4030003:
            case 4030004:
            case 4030005:
                return 1;
            case 4001168:
            case 4031306:
            case 4031307:
            case 3993000:
            case 3993002:
            case 3993003:
                return 100;
            case 5220010:
            case 5220013:
                return 1000;
            case 5220020:
                return 2000;
        }
        return 0;
    }

    public static boolean isDropRestricted(int itemId) {
        return itemId == 3012000 || itemId == 4030004 || itemId == 1052098 || itemId == 1052202;
    }

    public static boolean isPickupRestricted(int itemId) {
        return itemId == 4030003 || itemId == 4030004;
    }

    public static short getStat(int itemId, int def) {
        switch (itemId) {
            //case 1002419:
            //    return 5;
            case 1002959:
                return 25;
            case 1142002:
                return 10;
            case 1122121:
                return 7;
        }
        return (short) def;
    }

    public static short getHpMp(int itemId, int def) {
        switch (itemId) {
            case 1122121:
                return 500;
            case 1142002:
            case 1002959:
                return 1000;
        }
        return (short) def;
    }

    public static short getATK(int itemId, int def) {
        switch (itemId) {
            case 1122121:
                return 3;
            case 1002959:
                return 4;
            case 1142002:
                return 9;
        }
        return (short) def;
    }

    public static short getDEF(int itemId, int def) {
        switch (itemId) {
            case 1122121:
                return 250;
            case 1002959:
                return 500;
        }
        return (short) def;
    }

    public static boolean isDojo(int mapId) {
        return mapId >= 925020100 && mapId <= 925023814;
    }

    public static int getPartyPlayHP(int mobID) {
        switch (mobID) {
            case 4250000:
                return 836000;
            case 4250001:
                return 924000;
            case 5250000:
                return 1100000;
            case 5250001:
                return 1276000;
            case 5250002:
                return 1452000;

            case 9400661:
                return 15000000;
            case 9400660:
                return 30000000;
            case 9400659:
                return 45000000;
            case 9400658:
                return 20000000;
        }
        return 0;
    }

    public static int getPartyPlayEXP(int mobID) {
        switch (mobID) {
            case 4250000:
                return 5770;
            case 4250001:
                return 6160;
            case 5250000:
                return 7100;
            case 5250001:
                return 7975;
            case 5250002:
                return 8800;

            case 9400661:
                return 40000;
            case 9400660:
                return 70000;
            case 9400659:
                return 90000;
            case 9400658:
                return 50000;
        }
        return 0;
    }

    public static int getPartyPlay(int mapId) {
        switch (mapId) {
            case 300010000:
            case 300010100:
            case 300010200:
            case 300010300:
            case 300010400:
            case 300020000:
            case 300020100:
            case 300020200:
            case 300030000:

            case 683070400:
            case 683070401:
            case 683070402:
                return 25;
        }
        return 0;
    }

    public static int getPartyPlay(int mapId, int def) {
        int dd = getPartyPlay(mapId);
        if (dd > 0) {
            return dd;
        }
        return def / 2;
    }

    public static boolean isHyperTeleMap(int mapId) {
        for (int i : hyperTele) {
            if (i == mapId) {
                return true;
            }
        }
        return false;
    }

    public static int getCurrentDate() {
        final String time = FileoutputUtil.CurrentReadable_Time();
        return Integer.parseInt(new StringBuilder(time.substring(0, 4)).append(time.substring(5, 7)).append(time.substring(8, 10)).append(time.substring(11, 13)).toString());
    }

    public static int getCurrentDate_NoTime() {
        final String time = FileoutputUtil.CurrentReadable_Time();
        return Integer.parseInt(new StringBuilder(time.substring(0, 4)).append(time.substring(5, 7)).append(time.substring(8, 10)).toString());
    }

    public static void achievementRatio(MapleClient c) {
        //PQs not affected: Amoria, MV, CWK, English, Zakum, Horntail(?), Carnival, Ghost, Guild, LudiMaze, Elnath(?) 
        switch (c.getPlayer().getMapId()) {
            case 240080600:
            case 920010000:
            case 930000000:
            case 930000100:
            case 910010000:
            case 922010100:
            case 910340100:
            case 925100000:
            case 926100000:
            case 926110000:
            case 921120005:
            case 932000100:
            case 923040100:
            case 921160100:
                c.getSession().write(CField.achievementRatio(0));
                break;
            case 930000200:
            case 922010200:
            case 922010300:
            case 922010400:
            case 922010401:
            case 922010402:
            case 922010403:
            case 922010404:
            case 922010405:
            case 925100100:
            case 926100001:
            case 926110001:
            case 921160200:
                c.getSession().write(CField.achievementRatio(10));
                break;
            case 930000300:
            case 910340200:
            case 922010500:
            case 922010600:
            case 925100200:
            case 925100201:
            case 925100202:
            case 926100100:
            case 926110100:
            case 921120100:
            case 932000200:
            case 923040200:
            case 921160300:
            case 921160310:
            case 921160320:
            case 921160330:
            case 921160340:
            case 921160350:
                c.getSession().write(CField.achievementRatio(25));
                break;
            case 930000400:
            case 926100200:
            case 926110200:
            case 926100201:
            case 926110201:
            case 926100202:
            case 926110202:
            case 921160400:
                c.getSession().write(CField.achievementRatio(35));
                break;
            case 910340300:
            case 922010700:
            case 930000500:
            case 925100300:
            case 925100301:
            case 925100302:
            case 926100203:
            case 926110203:
            case 921120200:
            case 932000300:
            case 240080700:
            case 240080800:
            case 923040300:
            case 921160500:
                c.getSession().write(CField.achievementRatio(50));
                break;
            case 910340400:
            case 922010800:
            case 930000600:
            case 925100400:
            case 926100300:
            case 926110300:
            case 926100301:
            case 926110301:
            case 926100302:
            case 926110302:
            case 926100303:
            case 926110303:
            case 926100304:
            case 926110304:
            case 921120300:
            case 932000400:
            case 923040400:
            case 921160600:
                c.getSession().write(CField.achievementRatio(70));
                break;
            case 910340500:
            case 922010900:
            case 930000700:
            case 920010800:
            case 925100500:
            case 926100400:
            case 926110400:
            case 926100401:
            case 926110401:
            case 921120400:
            case 921160700:
                c.getSession().write(CField.achievementRatio(85));
                break;
            case 922011000:
            case 922011100:
            case 930000800:
            case 920011000:
            case 920011100:
            case 920011200:
            case 920011300:
            case 925100600:
            case 926100500:
            case 926110500:
            case 926100600:
            case 926110600:
            case 921120500:
            case 921120600:
                c.getSession().write(CField.achievementRatio(100));
                break;
        }
    }

    public static boolean isAngel(int sourceid) {
        return MapleJob.isBeginner(sourceid / 10000) && (sourceid % 10000 == 1085 || sourceid % 10000 == 1087 || sourceid % 10000 == 1090 || sourceid % 10000 == 1179 || sourceid % 10000 == 1154);
    }

    public static boolean isFishingMap(int mapid) {
        return mapid == 749050500 || mapid == 749050501 || mapid == 749050502 || mapid == 970020000 || mapid == 970020005;
    }

    public static int getRewardPot(int itemid, int closeness) {
        switch (itemid) {
            case 2440000:
                switch (closeness / 10) {
                    case 0:
                    case 1:
                    case 2:
                        return 2028041 + (closeness / 10);
                    case 3:
                    case 4:
                    case 5:
                        return 2028046 + (closeness / 10);
                    case 6:
                    case 7:
                    case 8:
                        return 2028049 + (closeness / 10);
                }
                return 2028057;
            case 2440001:
                switch (closeness / 10) {
                    case 0:
                    case 1:
                    case 2:
                        return 2028044 + (closeness / 10);
                    case 3:
                    case 4:
                    case 5:
                        return 2028049 + (closeness / 10);
                    case 6:
                    case 7:
                    case 8:
                        return 2028052 + (closeness / 10);
                }
                return 2028060;
            case 2440002:
                return 2028069;
            case 2440003:
                return 2430278;
            case 2440004:
                return 2430381;
            case 2440005:
                return 2430393;
        }
        return 0;
    }

    public static boolean isStartingEventMap(final int mapid) {
        switch (mapid) {
            case 109010000:
            case 109020001:
            case 109030001:
            case 109030101:
            case 109030201:
            case 109030301:
            case 109030401:
            case 109040000:
            case 109060001:
            case 109060002:
            case 109060003:
            case 109060004:
            case 109060005:
            case 109060006:
            case 109080000:
            case 109080001:
            case 109080002:
            case 109080003:
                return true;
        }
        return false;
    }

    public static boolean isEventMap(final int mapid) {
        return (mapid >= 109010000 && mapid < 109050000) || (mapid > 109050001 && mapid < 109090000) || (mapid >= 809040000 && mapid <= 809040100);
    }

    public static boolean isCoconutMap(final int mapid) {
        return mapid == 109080000 || mapid == 109080001 || mapid == 109080002 || mapid == 109080003 || mapid == 109080010 || mapid == 109080011 || mapid == 109080012 || mapid == 109090300 || mapid == 109090301 || mapid == 109090302 || mapid == 109090303 || mapid == 109090304 || mapid == 910040100;
    }

    public static boolean isMagicChargeSkill(final int skillid) {
        switch (skillid) {
            case 2121001: // Big Bang
            case 2221001:
            case 2321001:
            case 42121000:
                //case 22121000: //breath
                //case 22151001:
                return true;
        }
        return false;
    }

    public static boolean isTeamMap(final int mapid) {
        return mapid == 109080000 || mapid == 109080001 || mapid == 109080002 || mapid == 109080003 || mapid == 109080010 || mapid == 109080011 || mapid == 109080012 || mapid == 109090300 || mapid == 109090301 || mapid == 109090302 || mapid == 109090303 || mapid == 109090304 || mapid == 910040100 || mapid == 960020100 || mapid == 960020101 || mapid == 960020102 || mapid == 960020103 || mapid == 960030100 || mapid == 689000000 || mapid == 689000010;
    }

    public static boolean isSpecialForce(int type) {
        switch (type) {
            case 2:
            case 3:
            case 6:
            case 7:
            case 11:
            case 12:
            case 13:
            case 17:
            case 19:
                return true;
            default:
                return false;
        }
    }

    public static int getStatDice(int stat) {
        switch (stat) {
            case 2:
                return 30;
            case 3:
                return 20;
            case 4:
                return 15;
            case 5:
                return 20;
            case 6:
                return 30;
        }
        return 0;
    }

    public static boolean isSpecialBuff(MapleBuffStat stat) {
        switch (stat) {
//            case CRITICAL_RATE:
            case KAISER_COMBO:
            case DAMAGE_ABSORBED:
            case CRIT_DAMAGE:
            case SHADOWPARTNER:
            case DAMAGE_R:
                return true;
        }
        return false;
    }

    public static boolean isIDA_SpecialBuff(MapleBuffStat stat) {
        switch (stat) {
            case MONSTER_RIDING:
            case IDA_SPECIAL_BUFF_1:
            case DAMAGE_R:
            case DAMAGE_UP:
            case CRIT_DAMAGE:
            case IDA_SPECIAL_BUFF_12:
            case IDA_SPECIAL_BUFF_2:
            case SHADOWPARTNER:
            case IDA_SPECIAL_BUFF_3:
            case IDA_SPECIAL_BUFF_11:
            case IDA_SPECIAL_BUFF_4:
            case IDA_SPECIAL_BUFF_5:
            case IDA_SPECIAL_BUFF_6:
            case IDA_SPECIAL_BUFF_7:
            case IDA_SPECIAL_BUFF_8:
            case RAINING_MINES:
            case IDA_SPECIAL_BUFF_9:
            case IDA_SPECIAL_BUFF_10:
                return true;
        }
        return false;
    }

    public static boolean isMovementAffectingStat(MapleBuffStat stat) {
        switch (stat) {
            case SPEED:
            case JUMP:
            case STUN:
            case WEAKEN:
            case SLOW:
            case MORPH:
            case GHOST_MORPH:
            case MAPLE_WARRIOR:
            case SEDUCE:
            case MONSTER_RIDING:
            case DASH_SPEED:
            case DASH_JUMP:
            case SOARING:
            case FREEZE:
            case YELLOW_AURA:
            case FROZEN:
            case IDA_MOVE_BUFF1:
            case INDIE_SPEED:
            case ANGEL_JUMP:
            case KILL_COUNT:
            case ENERGY_CHARGE:
            case MECH_CHANGE:
            case IDA_MOVE_BUFF2:
            case IDA_MOVE_BUFF3:
            case DEFAULTBUFF2:
            case IDA_SPECIAL_BUFF_4:
            case IDA_MOVE_BUFF4:
            case IDA_MOVE_BUFF5:
            case IDA_MOVE_BUFF6:
            case IDA_MOVE_BUFF7:
            case XENON_FLY:
            case IDA_SPECIAL_BUFF_8:
            case IDA_MOVE_BUFF8:
            case RAINING_MINES:
            case IDA_MOVE_BUFF9:
                return true;
        }
        return false;
    }

    public static boolean isSpecialStackBuff(MapleBuffStat stat) {
        switch (stat) {
            case MONSTER_RIDING:
            case ENERGY_CHARGE:
            case SPEED_INFUSION:
                return true;
        }
        return false;
    }

    public static boolean isCustomReturnMap(int mapid) {
        switch (mapid) {
            case 689013000:
                return true;
        }
        return false;
    }

    public static int getCustomReturnMap(int mapid) {
        switch (mapid) {
            case 689013000:
                return 689012001;
        }
        return mapid;
    }

    public static boolean isAnyDropMap(int mapId) {
        switch (mapId) {
            case 180000000:
            case 180000001:
                return true;
        }
        return false;
    }

    public static boolean isNoExpireMap(int mapId) {
        switch (mapId) {
            case 180000000:
            case 180000001:
                return true;
        }
        return false;
    }

    public static String getCashBlockedMsg(final int id) {
        switch (id) {
            case 5211014:
            case 5211015:
            case 5211016:
            case 5211017:
            case 5211018:
            case 5211019:
            case 5211039:
            case 5211042:
            case 5211045:
                //cube
                return "This item is blocked.";
        }
        return "This item is blocked from the Cash Shop.";
    }

    public static final boolean isRedLeaf(int mapid) {
        return mapid / 1000000 == 744;
    }

    public static int getDiceStat(int buffid, int stat) {
        if (buffid == stat || buffid % 10 == stat || buffid / 10 == stat) {
            return getStatDice(stat);
        } else if (buffid == (stat * 100)) {
            return getStatDice(stat) + 10;
        }
        return 0;
    }

    public static boolean isEnergyBuff(int skill) { //body pressure, tele mastery, twister spin. etc
        switch (skill) {
            case 32121003:
            case 21101003:
            case 2311007:
            case 22161005:
            case 2211007:
            case 2111007:
            case 32111010:
            case 12111007:
                return true;
        }
        return false;
    }

    public static int getMPByJob(int job) {
        switch (job) {
            case 3100: // 惡魔殺手(1轉)
                return 30;
            case 3110: // 惡魔殺手(2轉)
                return 60;
            case 3111: // 惡魔殺手(3轉)
                return 100;
            case 3112: // 惡魔殺手(4轉)
                return 120;
        }
        return 30; // 惡魔殺手(0轉)
    }

    public static int getHpApByJob(short job) {
        if ((job % 1000) / 100 > 5) {
            job -= 500;
        }
        if ((job % 1000) / 100 == 5) {
            switch (job / 10) {
                case 51:
                    return 68;
                case 53:
                    return 28;
            }
        }
        switch (job / 100) {
            case 21:
                return 30;
            case 22:
                return 12;
            case 31:
                return 38;
            case 32:
                return 20;
        }
        switch ((job % 1000) / 100) {
            case 0:
                return 8;
            case 1:
                return 50;
            case 2:
                return 6;
            case 3:
            case 4:
                return 16;
            case 5:
                return 18;
            default:
                return 8;
        }
    }

    public static int getMpApByJob(short job) {
        if (job / 100 == 31 || job / 100 == 65) {
            return 0;
        }
        if ((job % 1000) / 100 > 5) {
            job -= 500;
        }
        switch (job / 100) {
            case 22:
                return 72;
            case 32:
                return 69;
        }
        switch ((job % 1000) / 100) {
            case 0:
                return 57;
            case 1:
                return 53;
            case 2:
                return 79;
            case 3:
            case 4:
                return 61;
            case 5:
                return 65;
            default:
                return 57;
        }
    }

    public static int getSkillLevel(final int level) {
        if (level >= 70 && level < 120) {
            return 2;
        } else if (level >= 120 && level < 200) {
            return 3;
        } else if (level == 200) {
            return 4;
        }
        return 1;
    }

    public static int[] getInnerSkillbyRank(int rank) {
        if (rank == 0) {
            return rankC;
        } else if (rank == 1) {
            return rankB;
        } else if (rank == 2) {
            return rankA;
        } else if (rank == 3) {
            return rankS;
        } else {
            return null;
        }
    }
    private static final int[] azwanRecipes = {2510483, 2510484, 2510485, 2510486, 2510487, 2510488, 2510489, 2510490, 2510491, 2510492, 2510493, 2510494, 2510495, 2510496, 2510497, 2510498, 2510499, 2510500, 2510501, 2510502, 2510503, 2510504, 2510505, 2510506, 2510507, 2510508, 2510509, 2510510, 2510511, 2510512, 2510513, 2510514, 2510515, 2510516, 2510517, 2510518, 2510519, 2510520, 2510521, 2510522, 2510523, 2510524, 2510525, 2510526, 2510527, 2511153, 2511154, 2511155};
    private static final int[] azwanScrolls = {2046060, 2046061, 2046062, 2046063, 2046064, 2046065, 2046066, 2046067, 2046068, 2046069, 2046141, 2046142, 2046143, 2046144, 2046145, 2046519, 2046520, 2046521, 2046522, 2046523, 2046524, 2046525, 2046526, 2046527, 2046528, 2046529, 2046530, 2046701, 2046702, 2046703, 2046704, 2046705, 2046706, 2046707, 2046708, 2046709, 2046710, 2046711, 2046712};
    private static final Pair[] useItems = {new Pair<>(2002010, 500), new Pair<>(2002006, 600), new Pair<>(2002007, 600), new Pair<>(2002008, 600), new Pair<>(2002009, 600), new Pair<>(2022003, 770), new Pair<>(2022000, 1155), new Pair<>(2001001, 2300), new Pair<>(2001002, 4000), new Pair<>(2020012, 4680), new Pair<>(2020013, 5824), new Pair<>(2020014, 8100), new Pair<>(2020015, 10200), new Pair<>(2000007, 5), new Pair<>(2000000, 5), new Pair<>(2000008, 48), new Pair<>(2000001, 48), new Pair<>(2000009, 96), new Pair<>(2000002, 96), new Pair<>(2000010, 20), new Pair<>(2000003, 20), new Pair<>(2000011, 186), new Pair<>(2000006, 186), new Pair<>(2050000, 200), new Pair<>(2050001, 200), new Pair<>(2050002, 300), new Pair<>(2050003, 500)};

    public static int[] getAzwanRecipes() {
        return azwanRecipes;
    }

    public static int[] getAzwanScrolls() {
        return azwanScrolls;
    }

    public static Pair[] getUseItems() {
        return useItems;
    }

    public static int[] getCirculators() {
        return circulators;
    }
    private static final int[] wheelRewardsA = {2512139, 2512159, 2512179, 2512199, 2512219, 2512239, 2512249, 2000000, 2000001, 2000002, 2000003, 2000007, 2000008, 2000009, 2000010, 2002000, 2002001, 2002002, 2000018, 2000019, 2020012, 2020014, 2001003, 2001515, 2001516, 2001517, 2001518, 2001519, 2001520, 2001521, 2001522, 2001523, 2001524, 2001525, 2003503, 2003504, 2003505, 2003506, 2003507, 2003508, 2004003, 2004023, 2004043, 2004063, 2030000, 2030001, 2030002, 2030003, 2030004, 2030005, 2030006, 4000014, 4000030, 4000073, 4000082, 4000085, 4000103, 4000118, 4000235, 4000296, 4000327, 4000352, 4000445, 4000446, 4000600};
    //recipes, alchemy potions, potions, town scrolls, etc items
    private static final int[] wheelRewardsB = {};
    //10%, 60%, 100% scrolls, pvp level 70 equips, blitz helm, power mane, arcana crown, elemental wands, mastery books, other rare equipments
    private static final int[] wheelRewardsC = {};
    //10%, 60% scrolls, pvp level 130 equips, mastery books

    public static void loadWheelRewards(List<Integer> items, int token) {
        int rank = token % 10;
        int[] rewards = rank == 2 ? wheelRewardsC : rank == 1 ? wheelRewardsB : wheelRewardsA;
        for (int i = 0; i < 10; i++) {
            if (Randomizer.nextInt(100) < 15 && rank == 0 && !items.contains(4031349)) {
                items.add(4031349);
            } else {
                int item = rewards[Randomizer.nextInt(rewards.length)];
                while (items.contains(item)) {
                    item = rewards[Randomizer.nextInt(rewards.length)];
                }
                items.add(item);
            }
        }
    }

    public static List<Integer> getSealedBoxItems(int itemId) {
        List<Integer> list = new LinkedList();
        int[] items = {};
        switch (itemId) {
            case 2028155:
                items = new int[]{2510028, 1050104, 1052131, 1050106, 1050099,
                    1050107, 1052072, 1050098, 1050096, 1052076, 1051101,
                    1041122, 1052071, 2510035, 1061123, 1051106, 1050103,
                    1040122, 2510023, 1052075, 2510022};
                break;
            case 2028156:
                items = new int[]{1082151, 1082153, 1082213, 1072223, 1072272,
                    1072269, 1072226, 1082168, 1082167, 1072222, 2510050,
                    1082159, 2510072, 1082139, 1082154, 1082140, 1072321,
                    1072273, 2510066, 1072215, 2510068};
                break;
        }
        for (int i : items) {
            list.add(i);
        }
        return list;
    }

    public static boolean isStealSkill(int skillId) {
        switch (skillId) {
            case 24001001:
            case 24101001:
            case 24111001:
            case 24121001:
                return true;
        }
        return false;
    }

    public static int getStealSkill(int job) {
        switch (job) {
            case 1:
                return 24001001;
            case 2:
                return 24101001;
            case 3:
                return 24111001;
            case 4:
                return 24121001;
        }
        return 0;
    }

    public static int getNumSteal(int jobNum) {
        switch (jobNum) {
            case 1:
                return 4;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 2;
        }
        return 0;
    }

    public static int Attacktype(int skillId) { //TODO 有些特殊攻击不应在其他玩家那边显示攻击
        switch (skillId) {
            case 2121054:
            case 65121052:
                return 4;
            default:
                return 0;
        }
    }

    public static boolean canSteal(Skill skil) {
        return skil != null && !skil.isMovement() && !isLinkedAttackSkill(skil.getId()) && skil.getId() % 10000 >= 1000 && MapleJob.getNumber(skil.getId() / 10000) > 0 && !MapleJob.is影武者(skil.getId() / 10000) && !MapleJob.is重砲指揮官(skil.getId() / 10000) && !MapleJob.is蒼龍俠客(skil.getId() / 10000) && skil.getId() < 8000000 && skil.getEffect(1) != null && skil.getEffect(1).getSummonMovementType() == null && !skil.getEffect(1).isUnstealable();
    }

    public static boolean isHyperSkill(Skill skill) {
        if (skill.isHyper() || skill.getHyper() > 0) {
            return true;
        }
        if (skill.isBeginnerSkill()) {
            return false;
        }
        return skill.getId() % 1000 >= 30;
    }

    public static boolean isTutorialMap(int mapid) {
        if (mapid < 100000000) { //冒險家 & 重砲指揮官Explorer & Cannoneer
            return true;
        } else if (mapid / 100 == 1030509 || mapid / 100 == 1030505) { //影武者Dual Blade
            return true;
        } else if (mapid / 10000 == 13003) { //皇家騎士團Cygnus
            return true;
        } else if (mapid / 100000 == 9000) { //龍魔導士Evan
            return true;
        } else if (mapid / 10000 == 91015) { //精靈遊俠Mercedes
            return true;
        } else if (mapid / 10000 == 91307) { //米哈逸Mihile
            return true;
        } else if (mapid / 10000 == 91400 || mapid / 10000 == 14009) { //狂狼勇士Aran
            return true;
        } else if (mapid / 10000 == 91500) { //幻影俠盜Phantom
            return true;
        } else if (mapid / 10000 == 93100) { //末日反抗軍Resistance
            return true;
        } else if (mapid / 10000 == 93105) { //惡魔殺手Demon Slayer
            return true;
        } else if (mapid / 100 == 8071000) { //劍豪
            return true;
        } else if (mapid / 100 == 8071001) { //陰陽師
            return true;
        } else if (mapid > 866000000) { //幻獸師Beast Tamer
            return true;
        }
        return false;
        //There might be included other maps like main town or job advancements,
        //But we don't care since you don't get much exp here and you're locked on teasers.
    }

    public static boolean isItemSkill(MapleCharacter chr, int skillId) {
        boolean is = false;
        switch (skillId) {
            case 80011120://使用立體機動裝置
            case 80011121://立體機動攻擊 : 交叉斬擊
            case 80011122://立體機動攻擊 : 迴旋斬擊
                if (chr.haveItem(1073010)) {
                    is = true;
                }
                break;
        }
        return is;
    }

    public static ArrayList<Integer> get6YearSet() {
        int[] set = {1462116, 1342039, 1402109, 1472139, 1332147, 1322105, 1442135, 1452128, 1312071, 1382123, 1492100, 1372099, 1432098, 1422072, 1302172, 1482101, 1412070};
        ArrayList<Integer> list = new ArrayList();
        for (int i : set) {
            list.add(i);
        }
        return list;
    }

    public static ArrayList<Integer> get7YearSet() {
        int[] set = {1003243, 1052358, 1072522, 1082315, 1102295, 1132093, 1152061, 1332145, 1402107, 1442133, 1462114, 1472137, 1532070, 1522066, 1452126, 1312069, 1382121, 1492098, 1372097, 1362058, 1432096, 1422070, 1302170, 1482099, 1412068};
        ArrayList<Integer> list = new ArrayList();
        for (int i : set) {
            list.add(i);
        }
        return list;
    }

    public static ArrayList<Integer> get8YearSet() {
        int[] set = {1462159, 1462156, 1402145, 1402151, 1052461, 1052457, 1532073, 1532074, 1472177, 1472179, 1332186, 1332193, 1322154, 1322162, 1442173, 1442182, 1522068, 1522071, 1452165, 1312114, 1312116, 1382160, 1132154, 1132151, 1072666, 1072660, 1212069, 1212068, 1492152, 1492138, 1372139, 1372131, 1222063, 1222064, 1082433, 1082430, 1362060, 1362067, 1432138, 1432135, 1152088, 1152089, 1003529, 1003552, 1422107, 1422105, 1232070, 1232063, 1302227, 1302212, 1113036, 1113035, 1112743, 1112742, 1482140, 1482138, 1242048, 1242075, 1412102, 1412014, 1102394, 1102441};
        ArrayList<Integer> list = new ArrayList();
        for (int i : set) {
            list.add(i);
        }
        return list;
    }

    public static ArrayList<Integer> get10YearSet() {
        int[] set = {
            1004172,//帽子
            1012471,//臉飾
            1052758,//套服
            1102691,//披風
            1122280,//墜飾
            1212095,//魔法克魯
            1222089,//靈魂射手
            1232089,//魔劍
            1242095,//能量劍
            1302304,//單手劍
            1312179,//單手斧
            1322230,//單手棍
            1332254,//短劍
            1342094,//雙刀
            1362115,//手杖
            1372201,//短杖
            1382239,//长杖
            1402229,//雙手劍
            1412158,//雙手斧
            1422165,//雙手棍
            1432194,//槍
            1442248,//矛
            1452232,//弓
            1462219,//弩
            1472241,//拳套
            1482196,//指虎
            1492205,//火槍
            1522118,//雙弩槍
            1532124,//加農炮
        };
        ArrayList<Integer> list = new ArrayList();
        for (int i : set) {
            list.add(i);
        }
        return list;
    }

    public static boolean canUseCube(Equip eq, int cubeId) {
        switch (cubeId) {
            case 2711007://10週年武器專用方塊
                if (get10YearSet().contains(eq.getItemId()) && isWeapon(eq.getItemId())) {
                    return true;
                }
                return false;
            case 5062100://楓葉奇幻方塊(罕見)
                if (get7YearSet().contains(eq.getItemId()) && eq.getState() < 20) {
                    return true;
                }
                return false;
            case 5062102://[6週年]奇幻方塊
                if (get6YearSet().contains(eq.getItemId()) && isWeapon(eq.getItemId())) {
                    return true;
                }
                return false;
            case 5062103://梦幻的神奇魔方
                if (get8YearSet().contains(eq.getItemId())) {
                    return true;
                }
                return false;
            case 2711000://可疑的方塊
            case 2711001://奇怪的方塊
                if (eq.getState() < 18) {
                    return true;
                }
                return false;
            case 2710000://奇怪的方塊(罕見)
            case 2711005://工匠的方塊
            case 5062000://奇幻方塊
            case 5062004://星星方塊
                if (eq.getState() < 20) {
                    return true;
                }
                return false;
            default:
                return true;
        }
    }

    public enum CubeType {

        特殊(0x1),
        稀有(0x2),
        罕見(0x4),
        傳說(0x8),
        等級下降(0x10),
        調整潛能條數(0x20),
        洗後無法交易(0x40),
        對等(0x80),
        去掉無用潛能(0x100),
        前兩條相同(0x200);
        private final int value;

        private CubeType(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public final boolean check(int flag) {
            return (flag & value) == value;
        }
    }

    public static int getCubeType(int itemId) {
        int type = CubeType.特殊.getValue() | CubeType.稀有.getValue() | CubeType.罕見.getValue() | CubeType.傳說.getValue();
        switch (itemId) {
            case 2711000://可疑的方塊(稀有)
            case 2711001://奇怪的方塊(傳說,說明上是傳說,實際只能洗到稀有)
                type -= CubeType.罕見.getValue();
            case 2710000://奇怪的方塊(罕見)
                type -= CubeType.傳說.getValue();
                type |= CubeType.等級下降.getValue();
                break;
            case 2710001://情谊魔方(洗后装备不可交换)
                type -= CubeType.傳說.getValue();
            case 3994895://楓方塊
                type |= CubeType.洗後無法交易.getValue();
                break;
            case 2711005://工匠的方塊
            case 2711007://10週年武器專用方塊
            case 5062000://奇幻方塊
                type -= CubeType.傳說.getValue();
                break;
            case 5062001://超級奇幻方塊
                type -= CubeType.傳說.getValue();
                type |= CubeType.調整潛能條數.getValue();
                break;
            case 5062004://星星方塊
                type -= CubeType.傳說.getValue();
                type |= CubeType.去掉無用潛能.getValue();
                break;
            case 5062013://太陽方塊
                type |= CubeType.去掉無用潛能.getValue();
            case 5062005://驚奇方塊
            case 5062006://白金奇幻方塊
            case 5062021://對等方塊
                type |= CubeType.對等.getValue();
                break;
            case 5062008://鏡射方塊
            case 5062019://閃耀鏡射方塊
                type |= CubeType.前兩條相同.getValue();
                break;
            case 2711006://名匠的方塊
            case 5062002://傳說方塊
            case 5062009://紅色方塊
            case 5062010://黑色方塊
            case 5062017://閃耀方塊
            case 5062020://閃炫方塊
            case 5062090://記憶方塊
            case 5062100://楓葉奇幻方塊
            case 5062102://[6週年]奇幻方塊
            case 5062103://奇異奇幻方塊
            case 5062500://大師附加奇幻方塊
            case 5062501://[MS特價] 大師附加奇幻方塊
            default:
                break;
        }
        return type;
    }

    public static int getCubeFragment(int itemId) {
        switch (itemId) {
            case 5062000://奇幻方塊
                return 2430112;
            case 5062002://傳說方塊
                return 2430481;
            case 5062004://星星方塊
                return 2432114;
            case 5062005://驚奇方塊
                return 2430759;
            case 5062006://白金奇幻方塊
                return 2431427;
            case 5062009://紅色方塊
                return 2431893;
            case 5062010://黑色方塊
                return 2431894;
            case 5062013://太陽方塊
                return 2432115;
            case 5062090://記憶方塊
                return 2431445;
            case 5062100://枫叶魔方
                return 2430112;
            case 5062102://[7周年]神奇魔方
                return 2430112;
            case 5062103://奇異奇幻方塊
                return 2430112;
            case 5062500://大師附加奇幻方塊
                return 2430915;
            default:
                return 0;
        }
    }

    public static boolean canLockCube(int itemId) {
        switch (itemId) {
            case 5062000://奇幻方塊
            case 5062004://星星方塊
            case 5062006://白金奇幻方塊
            case 5062013://太陽方塊
                return true;
            default:
                return false;
        }
    }

    public static boolean isSoulEnchanter(int itemId) {
        return itemId / 1000 == 2590;
    }

    public static boolean isSoulScroll(int itemId) {
        return itemId / 1000 == 2591;
    }

    public static boolean isUselessPotential(StructItemOption pot) {
        boolean useless = false;
        for (String s : pot.getItemOption()) {
            if (pot.get(s) > 0) {
                switch (s) {
                    case "incSTRr":
                    case "incDEXr":
                    case "incINTr":
                    case "incLUKr":
                    case "incPADr":
                    case "incMADr":
                    case "incMHPr":
                    case "incMMPr":
                    case "incDAMr":
                    case "incTerR":
                    case "incAsrR":
                    case "incMaxDamage":
                    case "level":
                    case "prop":
                    case "time":
                    case "ignoreTargetDEF":
                    case "ignoreDAM":
                    case "incAllskill":
                    case "ignoreDAMr":
                    case "RecoveryUP":
                    case "incCriticaldamageMin":
                    case "incCriticaldamageMax":
                    case "DAMreflect":
                    case "mpconReduce":
                    case "reduceCooltime":
                    case "incMesoProp":
                    case "incRewardProp":
                    case "boss":
                    case "attackType":
                        break;
                    default:
                        useless = true;
                }
            }
        }
        return useless;
    }

    public static Pair<Integer, Integer> getDefaultFaceAndHair(int job, int gender) {
        int face = gender == 1 ? 20100 : 21700;
        int hair = gender == 1 ? 30030 : 31002;
        if (MapleJob.is影武者(job)) {
            face = gender == 0 ? 20265 : 21261;
            hair = gender == 0 ? 33830 : 34820;
        } else if (MapleJob.is蒼龍俠客(job)) {
            face = gender == 0 ? 20100 : 21700;
            hair = gender == 0 ? 36120 : 34990;
        } else if (MapleJob.is精靈遊俠(job)) {
            face = gender == 0 ? 20549 : 21547;
            hair = gender == 0 ? 33453 : 34423;
        } else if (MapleJob.is幻影俠盜(job)) {
            face = gender == 0 ? 20659 : 21656;
            hair = gender == 0 ? 33703 : 34703;
        } else if (MapleJob.is夜光(job)) {
            face = gender == 0 ? 20174 : 21169;
            hair = gender == 0 ? 36190 : 37070;
        } else if (MapleJob.is惡魔殺手(job)) {
            face = gender == 0 ? 20248 : 21246;
            hair = gender == 0 ? 33531 : 34411;
        } else if (MapleJob.is惡魔復仇者(job)) {
            face = gender == 0 ? 20248 : 21280;
            hair = gender == 0 ? 36460 : 37450;
        } else if (MapleJob.is傑諾(job)) {
            face = gender == 0 ? 20185 : 21182;
            hair = gender == 0 ? 36470 : 37490;
        } else if (MapleJob.is米哈逸(job)) {
            face = gender == 0 ? 20169 : 21700;
            hair = gender == 0 ? 36033 : 31002;
        } else if (MapleJob.is凱撒(job)) {
            face = gender == 0 ? 20576 : 21571;
            hair = gender == 0 ? 36245 : 37125;
        } else if (MapleJob.is天使破壞者(job)) {
            face = gender == 0 ? 20576 : 21374;
            hair = gender == 0 ? 36245 : 37242;
        }
        return new Pair(face, hair);
    }

    public static long getMapleCubeCost(int times, int potentialState) {
        potentialState -= 1;
        if (potentialState < 0) {
            return 100;
        }
        long cost = 0;
        long[] mapleCubeCostPlus = {100, 10000, 500000, 20000000};
        long[] mapleCubeCostInitial = {100, 100000, 1000000, 10000000};
        long[] mapleCubeCostMax = {15000, 47400000, 5113000000L, 9999999999L};
        if (times >= 50) {
            cost = mapleCubeCostMax[potentialState];
        } else {
            for (int i = 1; i <= times; i++) {
                long plus = 1;
                for (int j = 0; j < i / (potentialState == 0 ? 10 : 5); j++) {
                    if (potentialState == 0) {
                        plus += 1;
                    } else if (potentialState == 1) {
                        plus *= 2;
                    } else if (potentialState == 2) {
                        plus *= 2 + (j == 0 ? 2 : 0);
                    } else if (potentialState == 3) {
                        plus *= 2 + (j == 3 ? 1 : 0);
                    }
                }
                cost += mapleCubeCostPlus[potentialState] * plus;
            }
        }
        cost += mapleCubeCostInitial[potentialState];
        cost = cost > mapleCubeCostMax[potentialState] ? mapleCubeCostMax[potentialState] : cost;
        return cost;
    }

    private static int[] dmgskinitem = {2431965, 2431966, 2432084, 2431967, 2432131, 2432153, 2432638, 2432659, 2432154, 2432637, 2432658, 2432207, 2432354, 2432355, 2432972, 2432465, 2432479, 2432526, 2432639, 2432660, 2432532, 2432592, 2432640, 2432661, 2432710, 2432836, 2432973};
    private static int[] dmgskinnum = {0, 1, 1, 2, 3, 4, 4, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11, 11, 11, 12, 13, 14, 14, 15, 16, 17};

    public static int getDamageSkinNumberByItem(int itemid) {
        for (int i = 0; i < dmgskinitem.length; i++) {
            if (dmgskinitem[i] == itemid) {
                return dmgskinnum[i];
            }
        }
        return -1;
    }

    public static int getDamageSkinItemByNumber(int num) {
        for (int i = 0; i < dmgskinnum.length; i++) {
            if (dmgskinnum[i] == num) {
                return dmgskinitem[i];
            }
        }
        return -1;
    }

    public static Integer[] getDamageSkinsTradeBlock() {
        ArrayList<Integer> skins = new ArrayList<>();
        for (int i = 0; i < dmgskinitem.length; i++) {
            if (MapleItemInformationProvider.getInstance().isOnlyTradeBlock(dmgskinitem[i])) {
                skins.add(dmgskinitem[i]);
            }
        }
//        System.out.println(skins.size());
        Integer list[] = new Integer[skins.size()];
        return skins.toArray(list);
    }

    public static short getSoulName(int soulid) {
        return (short) (soulid - 2591000 + 1);
    }

    public static short getSoulEnchanter(int itemid) {
        return 10;
    }

    //新版魂珠固定潛能
    public static int soulItemid[] = {2591010, 2591011, 2591012, 2591013, 2591014, 2591015, 2591016, 2591017, 2591018, 2591019, 2591020, 2591021, 2591022, 2591023, 2591024, 2591025, 2591026, 2591027, 2591028, 2591029, 2591030, 2591031, 2591032, 2591033, 2591034, 2591035, 2591036, 2591037, 2591038, 2591039, 2591040, 2591041, 2591042, 2591043, 2591044, 2591045, 2591046, 2591047, 2591048, 2591049, 2591050, 2591051, 2591052, 2591053, 2591054, 2591055, 2591056, 2591057, 2591058, 2591059, 2591060, 2591061, 2591062, 2591063, 2591064, 2591065, 2591066, 2591067, 2591068, 2591069, 2591070, 2591071, 2591072, 2591073, 2591074, 2591075, 2591076, 2591077, 2591078, 2591079, 2591080, 2591081, 2591082, 2591085, 2591086, 2591087, 2591088, 2591089, 2591090, 2591091, 2591092, 2591093, 2591094, 2591095, 2591096, 2591097, 2591098, 2591099, 2591100, 2591101, 2591102, 2591103, 2591104, 2591105, 2591106, 2591107, 2591108, 2591109, 2591110, 2591111, 2591112, 2591113, 2591114, 2591115, 2591116, 2591117, 2591118, 2591119, 2591120, 2591121, 2591122, 2591123, 2591124, 2591125, 2591126, 2591127, 2591128, 2591129, 2591130, 2591131, 2591132, 2591133, 2591134, 2591135, 2591136, 2591137, 2591138, 2591139, 2591140, 2591141, 2591142, 2591143, 2591144, 2591145, 2591146, 2591147, 2591148, 2591149, 2591150, 2591151, 2591152, 2591153, 2591154, 2591155, 2591156, 2591157, 2591158, 2591159, 2591160, 2591161, 2591162, 2591163, 2591164, 2591165, 2591166, 2591167, 2591168, 2591169, 2591170, 2591171, 2591172, 2591173, 2591174, 2591175, 2591176, 2591177, 2591178, 2591179, 2591180, 2591181, 2591182, 2591183, 2591184, 2591185, 2591186, 2591187, 2591188, 2591189, 2591190, 2591191, 2591192, 2591193, 2591194, 2591195, 2591196, 2591197, 2591198, 2591199, 2591200, 2591201, 2591202, 2591203, 2591204, 2591205, 2591206, 2591207, 2591208, 2591209, 2591210, 2591211, 2591212, 2591213, 2591214, 2591215, 2591216, 2591217, 2591218, 2591219, 2591220, 2591221, 2591222, 2591223, 2591224, 2591225, 2591226, 2591227, 2591228, 2591229, 2591230, 2591231, 2591232, 2591233, 2591234, 2591235, 2591236, 2591237, 2591238, 2591239, 2591240, 2591241, 2591242, 2591243, 2591244, 2591245, 2591246, 2591247, 2591248, 2591249, 2591250, 2591251, 2591252, 2591253, 2591254, 2591255, 2591256, 2591257, 2591258, 2591259, 2591260, 2591261, 2591262, 2591263, 2591264, 2591265, 2591266, 2591267, 2591268, 2591269, 2591270, 2591271, 2591272, 2591273, 2591274, 2591275, 2591276, 2591277, 2591278, 2591279, 2591288, 2591289, 2591290, 2591291, 2591292, 2591293, 2591294, 2591295, 2591296, 2591297, 2591298, 2591299, 2591300, 2591301, 2591302, 2591303, 2591304, 2591305, 2591306, 2591307, 2591308, 2591309, 2591310, 2591311, 2591312, 2591313, 2591314, 2591315, 2591316, 2591317, 2591318, 2591319, 2591320, 2591321, 2591322, 2591323, 2591324, 2591325, 2591326, 2591327, 2591328, 2591329, 2591330, 2591331, 2591332, 2591333, 2591334, 2591335, 2591336, 2591337, 2591338, 2591339, 2591340, 2591341, 2591342, 2591343, 2591344, 2591345, 2591346, 2591347, 2591348, 2591349, 2591350, 2591351, 2591352, 2591353, 2591354, 2591355, 2591356, 2591357, 2591358, 2591359, 2591360, 2591361, 2591362, 2591363, 2591364, 2591365, 2591366, 2591367, 2591368, 2591369, 2591370, 2591371, 2591372, 2591373, 2591374, 2591375, 2591376, 2591377, 2591378, 2591379, 2591380, 2591381};
    public static short soulPotentials[] = {0xB1, 0x66, 0x67, 0x68, 0x83, 0x84, 0xC9, 0x65, 0x66, 0x67, 0x68, 0x83, 0x84, 0xC9, 0x69, 0x6A, 0x6B, 0x6C, 0x85, 0x86, 0xCA, 0x69, 0x6A, 0x6B, 0x6C, 0x85, 0x86, 0xCA, 0x6D, 0x6E, 0x6F, 0x70, 0x87, 0x88, 0xCB, 0x71, 0x72, 0x73, 0x74, 0xCC, 0x97, 0x98, 0x89, 0x193, 0x25B, 0x79, 0x7A, 0x7B, 0x7C, 0xCE, 0x9B, 0x9C, 0x8B, 0x193, 0x25B, 0x75, 0x76, 0x77, 0x78, 0xCF, 0x99, 0x9A, 0x8A, 0x193, 0x25B, 0xA7, 0xA8, 0xA9, 0xAA, 0xD0, 0xAB, 0xAC, 0xB1, 0x00, 0x00, 0x00, 0x00, 0x65, 0x66, 0x67, 0x68, 0x83, 0x84, 0xC9, 0x65, 0x66, 0x67, 0x68, 0x83, 0x84, 0xC9, 0x69, 0x6A, 0x6B, 0x6C, 0x85, 0x86, 0xCA, 0x69, 0x6A, 0x6B, 0x6C, 0x85, 0x86, 0xCA, 0x6D, 0x6E, 0x6F, 0x70, 0x87, 0x88, 0xCB, 0x71, 0x72, 0x73, 0x74, 0xCC, 0x97, 0x98, 0x89, 0x75, 0x76, 0x77, 0x78, 0xCF, 0x99, 0x9A, 0x8A, 0x79, 0x7A, 0x7B, 0x7C, 0xCE, 0x9B, 0x9C, 0x8B, 0x65, 0x66, 0x67, 0x68, 0x83, 0x84, 0xC9, 0xA3, 0xA4, 0xA5, 0xA6, 0xD2, 0x97, 0x98, 0xAF, 0x00, 0x65, 0x66, 0x67, 0x68, 0x83, 0x84, 0xC9, 0xA3, 0xA4, 0xA5, 0xA6, 0xD2, 0x97, 0x98, 0xAF, 0xA7, 0xA8, 0xA9, 0xAA, 0xD0, 0xAB, 0xAC, 0xB1, 0xB3, 0xB4, 0xB5, 0xB6, 0xB7, 0xB8, 0xC9, 0xB9, 0xBA, 0xBB, 0xBC, 0xCD, 0x99, 0x9A, 0xBD, 0x00, 0xB3, 0xB4, 0xB5, 0xB6, 0xB7, 0xB8, 0xC9, 0xB9, 0xBA, 0xBB, 0xBC, 0xCD, 0x99, 0x9A, 0xBD, 0x6D, 0x6E, 0x6F, 0x70, 0x87, 0x88, 0xCB, 0x75, 0x76, 0x77, 0x78, 0xCF, 0x99, 0x9A, 0x8A, 0x00, 0x6D, 0x6E, 0x6F, 0x70, 0x87, 0x88, 0xCB, 0x75, 0x76, 0x77, 0x78, 0xCD, 0x99, 0x9A, 0x8A, 0x65, 0x66, 0x67, 0x68, 0x83, 0x84, 0xC9, 0xA7, 0xA8, 0xA9, 0xAA, 0xD0, 0xAD, 0xAC, 0xB1, 0x00, 0x65, 0x66, 0x67, 0x68, 0x83, 0x84, 0xC9, 0xA7, 0xA8, 0xA9, 0xAA, 0xD0, 0xAD, 0xAC, 0xB1, 0xA7, 0xA8, 0xA9, 0xAA, 0xD0, 0xAB, 0xAC, 0xB1, 0x00, 0x79, 0xBA, 0xBB, 0xBC, 0xCD, 0x99, 0x9A, 0xBD, 0x00, 0xB9, 0xBA, 0xBB, 0xBC, 0xCF, 0x99, 0x9A, 0xBD, 0x00, 0xB9, 0xBA, 0xBB, 0xBC, 0xCD, 0x99, 0x9A, 0xBD, 0x00, 0xB9, 0xBA, 0xBB, 0xBC, 0xCF, 0x99, 0x9A, 0xBD, 0x00, 0xB9, 0xBA, 0xBB, 0xBC, 0xCE, 0x99, 0x9A, 0xBD, 0x00, 0x79, 0xBA, 0xBB, 0xBC, 0xCD, 0x99, 0x9A, 0xBD, 0xB9, 0xBA, 0xBB, 0xBC, 0xCD, 0x99, 0x9A, 0xBD, 0xB9, 0xBA, 0xBB, 0xBC, 0xCD, 0x99, 0x9A, 0xBD, 0xB9, 0xBA, 0xBB, 0xBC, 0xCF, 0x99, 0x9A, 0xBD, 0xB9, 0xBA, 0xBB, 0xBC, 0xCE, 0x99, 0x9A, 0xBD};

    public static short getSoulPotential(int soulid, Equip eqq) {
        short potential = 0;
        for (int i = 0; i < soulItemid.length; i++) {
            if (soulItemid[i] == soulid) {
                potential = soulPotentials[i];
                break;
            }
        }
        //無固定寶珠潛能的隨機潛能
        if (potential == 0) {
            final MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
            int reqLevel = ii.getReqLevel(eqq.getItemId()) / 10;
            boolean rewarded = false;
            while (!rewarded) {
                final List<List<StructItemOption>> pots = new LinkedList<>(ii.getAllPotentialInfo().values());
                StructItemOption pot = pots.get(Randomizer.nextInt(pots.size())).get(reqLevel);
                if (pot != null && pot.reqLevel / 10 <= reqLevel && optionTypeFits(pot.optionType, eqq.getItemId()) && potentialIDFits(pot.opID, 19, 1) && isAllowedPotentialStat(eqq, pot.opID, false)) {
                    potential = (short) pot.opID;
                    rewarded = true;
                }
            }
        }
        return potential;
    }

    public static int getSoulSkill(int soulid) {
        int skillid = 0;
        switch (soulid) {
            //舊版寶珠:
            case 2591000://巴洛古的靈魂寶珠
                skillid = 80001210;
                break;
            case 2591001://闇黑龍王的靈魂寶珠
                skillid = 80001211;
                break;
            case 2591002://克雷斯的靈魂寶珠
                skillid = 80001212;
                break;
            case 2591003://皮卡啾的靈魂寶珠
                skillid = 80001219;
                break;
            case 2591004://龍騎士的靈魂寶珠
                skillid = 80001214;
                break;
            case 2591005://凡雷恩的靈魂寶珠
                skillid = 80001215;
                break;
            case 2591006://殘暴炎魔的靈魂寶珠
                skillid = 80001216;
                break;
            case 2591007://搖滾精神的靈魂寶珠
                skillid = 80001217;
                break;
            case 2591008://武公的靈魂寶珠
                skillid = 80001218;
                break;
            case 2591009://亞尼的靈魂寶珠
                skillid = 80001213;
                break;
            case 2591280://西格諾斯的靈魂寶珠
                skillid = 80001369;
                break;
            case 2591281://薛西斯的靈魂寶珠
                skillid = 80001370;
                break;
            case 2591282://艾畢奈亞的靈魂寶珠
                skillid = 80001371;
                break;
            case 2591283://阿卡依農的靈魂寶珠
                skillid = 80001372;
                break;
            case 2591284://海努斯的靈魂寶珠
                skillid = 80001373;
                break;
            case 2591285://希拉的靈魂寶珠
                skillid = 80001374;
                break;
            case 2591286://黑水靈的靈魂寶珠
                skillid = 80001375;
                break;
            case 2591287://梅格奈斯的靈魂寶珠
                skillid = 80001376;
                break;

            //新版寶珠
            case 2591045:
            case 2591046:
            case 2591047:
            case 2591048:
            case 2591049:
            case 2591050:
            case 2591051:
            case 2591052:
            case 2591053:
            case 2591054:
            case 2591124:
            case 2591125:
            case 2591126:
            case 2591127:
            case 2591128:
            case 2591129:
            case 2591130:
            case 2591131:
                skillid = 80001210;
                break;
            case 2591031:
            case 2591032:
            case 2591033:
            case 2591034:
            case 2591035:
            case 2591036:
            case 2591037:
            case 2591110:
            case 2591111:
            case 2591112:
            case 2591113:
            case 2591114:
            case 2591115:
            case 2591116:
                skillid = 80001012;
                break;
            case 2591017:
            case 2591018:
            case 2591019:
            case 2591020:
            case 2591021:
            case 2591022:
            case 2591023:
            case 2591096:
            case 2591097:
            case 2591098:
            case 2591099:
            case 2591100:
            case 2591101:
            case 2591102:
                skillid = 80001213;
                break;
            case 2591024:
            case 2591025:
            case 2591026:
            case 2591027:
            case 2591028:
            case 2591030:
            case 2591103:
            case 2591104:
            case 2591105:
            case 2591106:
            case 2591107:
            case 2591108:
            case 2591109:
                skillid = 80001214;
                break;
            case 2591065:
            case 2591066:
            case 2591067:
            case 2591068:
            case 2591069:
            case 2591070:
            case 2591071:
            case 2591072:
            case 2591073:
            case 2591074:
            case 2591132:
            case 2591133:
            case 2591134:
            case 2591135:
            case 2591136:
            case 2591137:
            case 2591138:
            case 2591139:
                skillid = 80001215;
                break;
            case 2591155:
            case 2591156:
            case 2591157:
            case 2591158:
            case 2591159:
            case 2591160:
            case 2591161:
            case 2591162:
            case 2591171:
            case 2591172:
            case 2591173:
            case 2591174:
            case 2591175:
            case 2591176:
            case 2591177:
            case 2591178:
                skillid = 80001216;
                break;
            case 2591010:
            case 2591011:
            case 2591012:
            case 2591013:
            case 2591014:
            case 2591015:
            case 2591016:
            case 2591089:
            case 2591090:
            case 2591091:
            case 2591092:
            case 2591093:
            case 2591094:
            case 2591095:
                skillid = 80001217;
                break;
            case 2591038:
            case 2591039:
            case 2591040:
            case 2591041:
            case 2591042:
            case 2591043:
            case 2591044:
            case 2591117:
            case 2591118:
            case 2591119:
            case 2591120:
            case 2591121:
            case 2591122:
            case 2591123:
                skillid = 80001218;
                break;
            case 2591055:
            case 2591056:
            case 2591057:
            case 2591058:
            case 2591059:
            case 2591060:
            case 2591061:
            case 2591062:
            case 2591063:
            case 2591064:
            case 2591140:
            case 2591141:
            case 2591142:
            case 2591143:
            case 2591144:
            case 2591145:
            case 2591146:
            case 2591147:
                skillid = 80001219;
                break;
            case 2591085:
                skillid = 80001267;
                break;
            case 2591075:
            case 2591076:
            case 2591077:
            case 2591078:
            case 2591079:
            case 2591080:
            case 2591081:
            case 2591082:
            case 2591179:
            case 2591180:
            case 2591181:
            case 2591182:
            case 2591183:
            case 2591184:
            case 2591185:
            case 2591186:
                skillid = 80001266;
                break;
            case 2591086:
                skillid = 80001268;
                break;
            case 2591087:
                skillid = 80001269;
                break;
            case 2591088:
                skillid = 80001270;
                break;
            case 2591148:
            case 2591149:
            case 2591150:
            case 2591151:
            case 2591152:
            case 2591153:
            case 2591154:
            case 2591164:
            case 2591165:
            case 2591166:
            case 2591167:
            case 2591168:
            case 2591169:
            case 2591170:
                skillid = 80001273;
                break;
            case 2591163:
                skillid = 80001274;
                break;
            case 2591187:
            case 2591188:
            case 2591189:
            case 2591190:
            case 2591191:
            case 2591192:
            case 2591193:
            case 2591203:
            case 2591204:
            case 2591205:
            case 2591206:
            case 2591207:
            case 2591208:
            case 2591209:
                skillid = 80001280;
                break;
            case 2591194:
            case 2591195:
            case 2591196:
            case 2591197:
            case 2591198:
            case 2591199:
            case 2591200:
            case 2591201:
            case 2591210:
            case 2591211:
            case 2591212:
            case 2591213:
            case 2591214:
            case 2591215:
            case 2591216:
            case 2591217:
                skillid = 80001281;
                break;
            case 2591202:
                skillid = 80001282;
                break;
            case 2591218:
            case 2591219:
            case 2591220:
            case 2591221:
            case 2591222:
            case 2591223:
            case 2591224:
            case 2591234:
            case 2591235:
            case 2591236:
            case 2591237:
            case 2591238:
            case 2591239:
            case 2591240:
                skillid = 80001321;
                break;
            case 2591225:
            case 2591226:
            case 2591227:
            case 2591228:
            case 2591229:
            case 2591230:
            case 2591231:
            case 2591232:
            case 2591241:
            case 2591242:
            case 2591243:
            case 2591244:
            case 2591245:
            case 2591246:
            case 2591247:
            case 2591248:
                skillid = 80001322;
                break;
            case 2591233:
                skillid = 80001323;
                break;
            case 2591249:
            case 2591250:
            case 2591251:
            case 2591252:
            case 2591253:
            case 2591254:
            case 2591255:
            case 2591265:
            case 2591266:
            case 2591267:
            case 2591268:
            case 2591269:
            case 2591270:
                skillid = 80001339;
                break;
            case 2591256:
            case 2591257:
            case 2591258:
            case 2591259:
            case 2591260:
            case 2591261:
            case 2591262:
            case 2591263:
            case 2591272:
            case 2591273:
            case 2591274:
            case 2591275:
            case 2591276:
            case 2591277:
            case 2591278:
            case 2591279:
                skillid = 80001340;
                break;
            case 2591264:
                skillid = 80001341;
                break;
            case 2591288:
            case 2591289:
            case 2591290:
            case 2591291:
            case 2591292:
            case 2591293:
            case 2591294:
            case 2591295:
                skillid = 80001395;
                break;
            case 2591296:
                skillid = 80001396;
                break;
            case 2591297:
            case 2591298:
            case 2591299:
            case 2591300:
            case 2591301:
            case 2591302:
            case 2591303:
            case 2591304:
            case 2591342:
            case 2591343:
            case 2591344:
            case 2591345:
            case 2591346:
            case 2591347:
            case 2591348:
            case 2591349:
                skillid = 80001493;
                break;
            case 2591305:
                skillid = 80001494;
                break;
            case 2591306:
            case 2591307:
            case 2591308:
            case 2591309:
            case 2591310:
            case 2591311:
            case 2591312:
            case 2591313:
            case 2591350:
            case 2591351:
            case 2591352:
            case 2591353:
            case 2591354:
            case 2591355:
            case 2591356:
            case 2591357:
                skillid = 80001495;
                break;
            case 2591314:
                skillid = 80001496;
                break;
            case 2591315:
            case 2591316:
            case 2591317:
            case 2591318:
            case 2591319:
            case 2591320:
            case 2591321:
            case 2591322:
            case 2591358:
            case 2591359:
            case 2591360:
            case 2591361:
            case 2591362:
            case 2591363:
            case 2591364:
            case 2591365:
                skillid = 80001497;
                break;
            case 2591323:
                skillid = 80001498;
                break;
            case 2591324:
            case 2591325:
            case 2591326:
            case 2591327:
            case 2591328:
            case 2591329:
            case 2591330:
            case 2591331:
            case 2591366:
            case 2591367:
            case 2591368:
            case 2591369:
            case 2591370:
            case 2591371:
            case 2591372:
            case 2591373:
                skillid = 80001499;
                break;
            case 2591332:
                skillid = 80001500;
                break;
            case 2591333:
            case 2591334:
            case 2591335:
            case 2591336:
            case 2591337:
            case 2591338:
            case 2591339:
            case 2591340:
            case 2591374:
            case 2591375:
            case 2591376:
            case 2591377:
            case 2591378:
            case 2591379:
            case 2591380:
            case 2591381:
                skillid = 80001501;
                break;
            case 2591341:
                skillid = 80001502;
                break;
            default:
                break;
        }
        return skillid;
    }

    public static boolean isForGM(int itemId) {
        return (itemId >= 2049335 && itemId <= 2049349) || //強化捲軸
                itemId == 2430011 || //特務召喚
                itemId == 2430012 || //移除特務
                itemId == 2430124 || //GM測試
                itemId == 2002085;//GM的無敵飲料
    }

    public static int getEnhanceTimes(int itemId) {
        MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
        int level = ii.getReqLevel(itemId);
        boolean isSuperiorEquip = ii.isSuperiorEquip(itemId);
        int enhanceTimes = 0;
        if (level >= 0 && level < 95) {
            enhanceTimes = isSuperiorEquip ? 3 : 5;
        } else if (level >= 95 && level < 108) {
            enhanceTimes = isSuperiorEquip ? 5 : 8;
        } else if (level >= 108 && level < 118) {
            enhanceTimes = isSuperiorEquip ? 8 : 10;
        } else if (level >= 118 && level < 128) {
            enhanceTimes = isSuperiorEquip ? 10 : 15;
        } else if (level >= 128 && level < 138) {
            enhanceTimes = isSuperiorEquip ? 12 : 20;
        } else if (level >= 138) {
            enhanceTimes = isSuperiorEquip ? 15 : 25;
        }
        return enhanceTimes;
    }

    public static boolean isBossMap(int mapid) {
        switch (mapid) {
            case 0:
            case 105100300:
            case 105100400:
            case 211070100:
            case 211070101:
            case 211070110:
            case 220080001:
            case 240040700:
            case 240060200:
            case 240060201:
            case 270050100:
            case 271040100:
            case 271040200:
            case 280030000:
            case 280030001:
            case 280030100:
            case 300030310:
            case 551030200:
            case 802000111:
            case 802000211:
            case 802000311:
            case 802000411:
            case 802000611:
            case 802000711:
            case 802000801:
            case 802000802:
            case 802000803:
            case 802000821:
            case 802000823:
                return true;
        }
        return false;
    }

    //questID; FAMILY USES 19000x, MARRIAGE USES 16000x, EXPED USES 16010x
    //dojo = 150000, bpq = 150001, master monster portals: 122600
    //compensate evan = 170000, compensate sp = 170001
    public static final int OMOK_SCORE = 122200;
    public static final int MATCH_SCORE = 122210;
    public static final int HP_ITEM = 122221;
    public static final int MP_ITEM = 122222;
    public static final int BUFF_ITEM = 122223;
    public static final int PART_JOB = 122750;
    public static final int PART_JOB_REWARD = 122751;
    public static final int JAIL_TIME = 123455;
    public static final int JAIL_QUEST = 123456;
    public static final int REPORT_QUEST = 123457;
    public static final int PLAYER_INFORMATION = 123568;

    //codex = -55 slot
    //crafting/gathering are designated as skills(short exp then byte 0 then byte level), same with recipes(integer.max_value skill level)
    public static final int 精靈耳朵 = 7784;
    public static final int 申請公會ID = 26011;
    public static final int 申請公會名 = 26015;
    public static final int 楓方塊 = 52889;
    public static final int 閃耀方塊 = 52997;//不知是不是這個
    public static final int 閃炫方塊 = 52998;
    public static final int 幻獸師的修養 = 59340;
    public static int ULT_EXPLORER = 111111;
    public static final int JAGUAR = 111112;
    public static final int ENERGY_DRINK = 122500;
    public static final int HARVEST_TIME = 122501;
    public static final int 墜飾欄 = 122700;
    public static final int CURRENT_SET = 122800;
    public static final int 組隊請求 = 122900;
    public static final int 組隊邀請 = 122901;
    public static final int QUICK_SLOT = 123000;
    public static final int ITEM_TITLE = 124000;//稱號
    public static final int BOSS_PQ = 150001;
    public static final int CUSTOM_BANK = 150002;
    public static final int DOJO = 150100;
    public static final int DOJO_RECORD = 150101;

    public static final int HOOK_SHOT = 1073010;//立體機動道具ID,需要修復後去除的
}
