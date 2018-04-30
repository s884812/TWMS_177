package server;

import client.SkillFactory;
import client.ZZMSEvent;
import client.inventory.MapleInventoryIdentifier;
import constants.GameConstants;
import constants.ServerConfig;
import constants.ServerConstants;
import database.DatabaseConnection;
import handling.cashshop.CashShopServer;
import handling.channel.ChannelServer;
import handling.channel.MapleDojoRanking;
import handling.channel.MapleGuildRanking;
import handling.farm.FarmServer;
import handling.login.LoginInformationProvider;
import handling.login.LoginServer;
import handling.world.World;
import handling.world.family.MapleFamily;
import handling.world.guild.MapleGuild;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;
import server.Timer.BuffTimer;
import server.Timer.CloneTimer;
import server.Timer.EtcTimer;
import server.Timer.EventTimer;
import server.Timer.MapTimer;
import server.Timer.PingTimer;
import server.Timer.WorldTimer;
import server.events.MapleOxQuizFactory;
import server.life.MapleLifeFactory;
import server.life.MapleMonsterInformationProvider;
import server.life.MobSkillFactory;
import server.life.PlayerNPC;
import server.maps.MapleMapFactory;
import server.quest.MapleQuest;
import tools.MapleAESOFB;

public class Start {

    public static long startTime = System.currentTimeMillis();
    public static final Start instance = new Start();
    public static AtomicInteger CompletedLoadingThreads = new AtomicInteger(0);

    public void run() throws InterruptedException, IOException {
        long start = System.currentTimeMillis();
        System.setProperty("path", "");
        System.setProperty("wzpath", ServerProperties.getProperty("wzpath", "wz"));

        if (ServerConfig.adminOnly || ServerConstants.Use_Localhost) {
            System.out.println("Admin Only mode is active.");
        }
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("UPDATE accounts SET loggedin = 0")) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("運行時錯誤: 無法連接到MySQL數據庫服務器 - " + ex);
        }

        System.out.println("正在加載" + ServerConfig.serverName + "伺服器");
        World.init();
        System.out.println("\r\n主機: " + ServerConfig.interface_ + ":" + LoginServer.PORT);
        System.out.println("支援遊戲版本: " + ServerConstants.MAPLE_TYPE + "的" + ServerConstants.MAPLE_VERSION + "." + ServerConstants.MAPLE_PATCH + "版本" + (ServerConstants.TESPIA ? "測試機" : "") + "用戶端");
        System.out.println("主伺服器名稱: " + ServerConstants.MAIN_WORLD);

        if (ServerConstants.MAPLE_TYPE == ServerConstants.MapleType.GLOBAL) {
            boolean encryptionfound = false;
            for (MapleAESOFB.EncryptionKey encryptkey : MapleAESOFB.EncryptionKey.values()) {
                if (("V" + ServerConstants.MAPLE_VERSION).equals(encryptkey.name())) {
                    System.out.println("Packet Encryption: Up‑To‑Date!");
                    encryptionfound = true;
                    break;
                }
            }
            if (!encryptionfound) {
                System.out.println("Cannot find the packet encryption for the Maple Version you entered. Using the previous packet encryption instead.");
            }
        }
        System.out.print("\r\n正在加載線程");
        WorldTimer.getInstance().start();
        EtcTimer.getInstance().start();
        MapTimer.getInstance().start();
        CloneTimer.getInstance().start();
        System.out.print(/*"\u25CF"*/".");
        EventTimer.getInstance().start();
        BuffTimer.getInstance().start();
        PingTimer.getInstance().start();
        GameConstants.LoadEXP();
        System.out.print(/*"\u25CF"*/".");
        MapleDojoRanking.getInstance().load();
        MapleGuildRanking.getInstance().load();
        MapleGuild.loadAll();
        MapleFamily.loadAll();
        System.out.print(/*"\u25CF"*/".");
        MapleLifeFactory.loadQuestCounts();
        MapleQuest.initQuests();
        MapleItemInformationProvider.getInstance().runEtc();
        MapleMonsterInformationProvider.getInstance().load();
        System.out.print(/*"\u25CF"*/".");
        MapleItemInformationProvider.getInstance().runItems();
        SkillFactory.load();
        LoginInformationProvider.getInstance();
        RandomRewards.load();
        System.out.print(/*"\u25CF"*/".");
        MapleOxQuizFactory.getInstance();
        MapleCarnivalFactory.getInstance();
        CharacterCardFactory.getInstance().initialize();
        MobSkillFactory.getInstance();
        System.out.print(/*"\u25CF"*/".");
        SpeedRunner.loadSpeedRuns();
        MapleInventoryIdentifier.getInstance();
        MapleMapFactory.loadCustomLife();
        GameConstants.loadFaceHair();
        System.out.println("完成!\r\n");
        CashItemFactory.getInstance().initialize();
        LoginServer.run_startup_configurations();
        ChannelServer.startChannel_Main();
        CashShopServer.run_startup_configurations();
        if (ServerConstants.MAPLE_TYPE == ServerConstants.MapleType.GLOBAL) {
            FarmServer.run_startup_configurations();
        }
        Runtime.getRuntime().addShutdownHook(new Thread(new Shutdown()));
        World.registerRespawn();
        PlayerNPC.loadAll();
        MapleMonsterInformationProvider.getInstance().addExtra();
        LoginServer.setOn();
        RankingWorker.run();
        ZZMSEvent.start();
        //System.out.println("Event Script List: " + ServerConfig.getEventList());
        if (ServerConfig.logPackets) {
            System.out.println("數據包日誌模式已啟用");
        }
        if (ServerConfig.USE_FIXED_IV) {
            System.out.println("反抓包功能已啟用");
        }
        long now = System.currentTimeMillis() - start;
        long seconds = now / 1000;
        long ms = now % 1000;
        System.out.println("\r\n加載完成, 耗時: " + seconds + "秒" + ms + "毫秒");
    }

    public static class Shutdown implements Runnable {

        @Override
        public void run() {
            ShutdownServer.getInstance().run();
        }
    }

    public static void main(final String args[]) throws InterruptedException, IOException {
        instance.run();
    }
}
