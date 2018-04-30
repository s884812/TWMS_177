/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import client.MapleJob;
import client.Skill;
import client.SkillFactory;
import handling.RecvPacketOpcode;
import handling.SendPacketOpcode;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.ItemInformation;
import server.MapleItemInformationProvider;
import server.quest.MapleQuest;

/**
 *
 * @author Pungin
 */
public class SearchGenerator {

    public enum SearchType {

        道具(1),
        NPC(2),
        地圖(3),
        怪物(4),
        任務(5),
        技能(6),
        職業(7),
        包頭(8),
        未知;

        private int value;

        SearchType() {
            this.value = 0;
        }

        SearchType(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static String nameOf(int value) {
            for (SearchType type : SearchType.values()) {
                if (type.getValue() == value) {
                    return type.name();
                }
            }
            return "未知";
        }
    }
    public static final int 道具 = SearchType.道具.getValue();
    public static final int NPC = SearchType.NPC.getValue();
    public static final int 地圖 = SearchType.地圖.getValue();
    public static final int 怪物 = SearchType.怪物.getValue();
    public static final int 任務 = SearchType.任務.getValue();
    public static final int 技能 = SearchType.技能.getValue();
    public static final int 包頭 = SearchType.包頭.getValue();

    public static String searchData(int type, String search) {
        return searchData(SearchType.valueOf(SearchType.nameOf(type)), search);
    }

    public static String searchData(SearchType type, String search) {
        MapleData data;
        MapleDataProvider dataProvider = MapleDataProviderFactory.getDataProvider(new File(System.getProperty("wzpath") + "/" + "String.wz"));
        StringBuilder sb = new StringBuilder();

        switch (type) {
            case 道具: {
                List<String> retItems = new ArrayList<>();
                for (ItemInformation itemPair : MapleItemInformationProvider.getInstance().getAllItems()) {
                    if (itemPair != null && ((itemPair.name != null && itemPair.name.toLowerCase().contains(search.toLowerCase())) || String.valueOf(itemPair.itemId).toLowerCase().contains(search.toLowerCase()))) {
                        retItems.add("\r\n#L" + itemPair.itemId + "##i" + itemPair.itemId + ":# #z" + itemPair.itemId + "#(" + itemPair.itemId + ")#l");
                    }
                }
                if (retItems != null && retItems.size() > 0) {
                    for (String singleRetItem : retItems) {
                        if (sb.length() > 3500) {
                            sb.append("\r\n後面還有很多搜尋結果, 但已經無法顯示更多");
                            break;
                        }
                        sb.append(singleRetItem);
                    }
                }
                break;
            }
            case NPC: {
                List<String> retNpcs = new ArrayList<>();
                data = dataProvider.getData("Npc.img");
                List<Pair<String, Integer>> npcPairList = new LinkedList<>();
                for (MapleData npcIdData : data.getChildren()) {
                    npcPairList.add(new Pair<>(MapleDataTool.getString(npcIdData.getChildByPath("name"), "無名稱"), Integer.parseInt(npcIdData.getName())));
                }
                for (Pair<String, Integer> npcPair : npcPairList) {
                    if (npcPair.getLeft().toLowerCase().contains(search.toLowerCase()) || String.valueOf(npcPair.getRight()).toLowerCase().contains(search.toLowerCase())) {
                        retNpcs.add("\r\n#L" + npcPair.getRight() + "##p" + npcPair.getRight() + "##" + npcPair.getLeft() + "(" + npcPair.getRight() + ")#l");
                    }
                }
                if (retNpcs != null && retNpcs.size() > 0) {
                    for (String singleRetNpc : retNpcs) {
                        if (sb.length() > 3500) {
                            sb.append("\r\n後面還有很多搜尋結果, 但已經無法顯示更多");
                            break;
                        }
                        sb.append(singleRetNpc.toString());
                    }
                }
                break;
            }
            case 地圖: {
                List<String> retMaps = new ArrayList<>();
                data = dataProvider.getData("Map.img");
                List<Pair<String, Integer>> mapPairList = new LinkedList<>();
                for (MapleData mapAreaData : data.getChildren()) {
                    for (MapleData mapIdData : mapAreaData.getChildren()) {
                        mapPairList.add(new Pair<>("'" + MapleDataTool.getString(mapIdData.getChildByPath("streetName"), "無名稱") + " : " + MapleDataTool.getString(mapIdData.getChildByPath("mapName"), "無名稱") + "'", Integer.parseInt(mapIdData.getName())));
                    }
                }
                for (Pair<String, Integer> mapPair : mapPairList) {
                    if (mapPair.getLeft().toLowerCase().contains(search.toLowerCase()) || String.valueOf(mapPair.getRight()).toLowerCase().contains(search.toLowerCase())) {
                        retMaps.add("\r\n#L" + mapPair.getRight() + "##m" + mapPair.getRight() + "#(" + mapPair.getRight() + ")#l");
                    }
                }
                if (retMaps != null && retMaps.size() > 0) {
                    for (String singleRetMap : retMaps) {
                        if (sb.length() > 3500) {
                            sb.append("\r\n後面還有很多搜尋結果, 但已經無法顯示更多");
                            break;
                        }
                        sb.append(singleRetMap);
                    }
                }
                break;
            }
            case 怪物: {
                List<String> retMobs = new ArrayList<>();
                data = dataProvider.getData("Mob.img");
                List<Pair<String, Integer>> mobPairList = new LinkedList<>();
                for (MapleData mobIdData : data.getChildren()) {
                    mobPairList.add(new Pair<>(MapleDataTool.getString(mobIdData.getChildByPath("name"), "無名稱"), Integer.parseInt(mobIdData.getName())));
                }
                for (Pair<String, Integer> mobPair : mobPairList) {
                    if (mobPair.getLeft().toLowerCase().contains(search.toLowerCase()) || String.valueOf(mobPair.getRight()).toLowerCase().contains(search.toLowerCase())) {
                        retMobs.add("\r\n#L" + mobPair.getRight() + "##o" + mobPair.getRight() + "#(" + mobPair.getRight() + ")#l");
                    }
                }
                if (retMobs != null && retMobs.size() > 0) {
                    for (String singleRetMob : retMobs) {
                        if (sb.length() > 3500) {
                            sb.append("\r\n後面還有很多搜尋結果, 但已經無法顯示更多");
                            break;
                        }
                        sb.append(singleRetMob);
                    }
                }
                break;
            }
            case 任務: {
                List<String> retQuests = new ArrayList<>();
                for (MapleQuest questPair : MapleQuest.getAllInstances()) {
                    if ((questPair.getName().length() > 0 && questPair.getName().toLowerCase().contains(search.toLowerCase())) || String.valueOf(questPair.getId()).toLowerCase().contains(search.toLowerCase())) {
                        retQuests.add("\r\n#L" + questPair.getId() + "#" + questPair.getName() + "(" + questPair.getId() + ")#l");
                    }
                }
                if (retQuests != null && retQuests.size() > 0) {
                    for (String singleRetQuest : retQuests) {
                        if (sb.length() > 3500) {
                            sb.append("\r\n後面還有很多搜尋結果, 但已經無法顯示更多");
                            break;
                        }
                        sb.append(singleRetQuest);
                    }
                }
                break;
            }
            case 技能: {
                List<String> retSkills = new ArrayList<>();
                for (Skill skill : SkillFactory.getAllSkills()) {
                    if ((skill.getName() != null && skill.getName().toLowerCase().contains(search.toLowerCase())) || String.valueOf(skill.getId()).toLowerCase().contains(search.toLowerCase())) {
                        retSkills.add("\r\n#L" + skill.getId() + "##s" + skill.getId() + "#" + skill.getName() + "(" + skill.getId() + ")#l");
                    }
                }
                if (retSkills != null && retSkills.size() > 0) {
                    
                    for (String singleRetSkill : retSkills) {
                        if (sb.length() > 3500) {
                            sb.append("\r\n後面還有很多搜尋結果, 但已經無法顯示更多");
                            break;
                        }
                        sb.append(singleRetSkill);
                    }
                }
                break;
            }
            case 職業: {
                List<String> retJobs = new ArrayList<>();
                for (MapleJob job : MapleJob.values()) {
                    if ((job.name().length() > 0 && job.name().toLowerCase().contains(search.toLowerCase())) || String.valueOf(job.getId()).toLowerCase().contains(search.toLowerCase())) {
                        retJobs.add("\r\n#L" + job.getId() + "#" + job.name() + "(" + job.getId() + ")#l");
                    }
                }
                if (retJobs != null && retJobs.size() > 0) {
                    for (String singleRetJobs : retJobs) {
                        if (sb.length() > 3500) {
                            sb.append("\r\n後面還有很多搜尋結果, 但已經無法顯示更多");
                            break;
                        }
                        sb.append(singleRetJobs);
                    }
                }
                break;
            }
            case 包頭: {
                List<String> headers = new ArrayList<>();
                headers.add("\r\n伺服端包頭:");
                for (SendPacketOpcode send : SendPacketOpcode.values()) {
                    if (send.name() != null && send.name().toLowerCase().contains(search.toLowerCase())) {
                        headers.add("\r\n" + send.name() + " 值: " + send.getValue() + " 16進制: " + HexTool.getOpcodeToString(send.getValue()));
                    }
                }
                headers.add("\r\n用戶端包頭:");
                for (RecvPacketOpcode recv : RecvPacketOpcode.values()) {
                    if (recv.name() != null && recv.name().toLowerCase().contains(search.toLowerCase())) {
                        headers.add("\r\n" + recv.name() + " 值: " + recv.getValue() + " 16進制: " + HexTool.getOpcodeToString(recv.getValue()));
                    }
                }
                for (String header : headers) {
                    if (sb.length() > 3500) {
                        sb.append("\r\n後面還有很多搜尋結果, 但已經無法顯示更多");
                        break;
                    }
                    sb.append(header);
                }
                break;
            }
            default: {
                sb.append("對不起, 這個檢索類型不被支援");
            }
        }

        StringBuilder sbs = new StringBuilder();
        if (!sb.toString().isEmpty() && !sb.toString().equalsIgnoreCase("對不起, 這個檢索指令不被支援")) {
            sbs.append("<<類型: ").append(type.name()).append(" | 搜尋訊息: ").append(search).append(">>");
        }
        sbs.append(sb);
        if (sbs.toString().isEmpty()) {
            sbs.append("搜尋不到此" + type.name());
        }
        return sbs.toString();
    }

    public static boolean foundData(int type, String search) {
        String str = searchData(type, search);
        return !str.startsWith("搜尋不到此") && !str.equalsIgnoreCase("對不起, 這個檢索指令不被支援");
    }
}
