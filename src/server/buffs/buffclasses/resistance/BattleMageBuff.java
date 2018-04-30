/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.buffs.buffclasses.resistance;

import client.MapleBuffStat;
import client.MapleJob;
import client.MonsterStatus;
import server.MapleStatEffect;
import server.MapleStatInfo;
import server.buffs.AbstractBuffClass;

/**
 *
 * @author Dismal
 */
public class BattleMageBuff extends AbstractBuffClass {
    public BattleMageBuff() {
        buffs = new int[]{
                 
            32120000, // 進階黑色繩索
            32120013, // 進階黑色繩索              
            /*// 轉到 MapleStatEffect 處理     
            32001003, // 黑色繩索
            32110007, // 超級體-黑色繩索
            32111012, // 藍色繩索
            32110000, // 進階藍色繩索
            32120015, // 進階藍色繩索
            32110008, // 超級體-藍色繩索
            32101003, // 黃色繩索
            32110009, // 超級體-黃色繩索
            32111005, // 超級體
            */
            32120001, // 進階黃色繩索
            32120014, // 進階黃色繩索
            32101004, // 紅色吸血術
            32101005, // 長杖極速
            32111014, // 防禦姿態
            32111006, // 甦醒            
            32121010, // 煉獄鬥氣
            32121005, // 危機繩索
            32121007, // 楓葉祝福
            32111010, // 瞬間移動精通
            32121053, // 自由意志
            32121054, // 聯盟繩索
            32121056, // 戰鬥精通
        };
    }  
    
    @Override
    public boolean containsJob(int job) {
        return MapleJob.is煉獄巫師(job);
    }

    @Override
    public void handleBuff(MapleStatEffect eff, int skill) {
        switch (skill) {
           case 32120000: //進階黑色繩索
            case 32120013: //進階黑色繩索
                eff.info.put(MapleStatInfo.dot, eff.info.get(MapleStatInfo.damage));
                eff.info.put(MapleStatInfo.dotTime, 3);
                break;
            /*case 32001003: //黑色繩索
            case 32110007: //超級體-黑色繩索
                eff.info.put(MapleStatInfo.time, (skill == 32110007 ? (60+7*eff.getLevel()) : 2100000000));
                eff.statups.put(MapleBuffStat.DARK_AURA, eff.info.get(MapleStatInfo.x));
                break;
             case 32111012: //藍色繩索
            case 32110000: //進階藍色繩索
            case 32120015: //進階藍色繩索
            case 32110008: //超級體-藍色繩索
                eff.info.put(MapleStatInfo.time, (skill == 32110008 ? (60+7*eff.getLevel()) : 2100000000));
                eff.statups.put(MapleBuffStat.BLUE_AURA, (int) eff.getLevel());
                eff.statups.put(MapleBuffStat.HP_BOOST, (int) eff.info.get(MapleStatInfo.indieMhp));
                eff.statups.put(MapleBuffStat.MDEF_BOOST, (int) eff.info.get(MapleStatInfo.indieMdd));
                eff.statups.put(MapleBuffStat.WDEF_BOOST, (int) eff.info.get(MapleStatInfo.indiePdd));
                break;*/
            case 32120001: //進階黃色繩索
            case 32120014: //進階黃色繩索
                eff.monsterStatus.put(MonsterStatus.SPEED, eff.info.get(MapleStatInfo.speed));
                break;
            /*case 32101003: //黃色繩索
            case 32110009: //超級體-黃色繩索
                eff.info.put(MapleStatInfo.time, (skill == 32110009 ? (60+7*eff.getLevel()) : 2100000000));
                eff.statups.put(MapleBuffStat.YELLOW_AURA, (int) eff.info.get(MapleStatInfo.x));
                break;
            case 32111005: //超級體
                eff.info.put(MapleStatInfo.time, 150000);
                eff.statups.put(MapleBuffStat.BODY_BOOST, (int) eff.getLevel());
                break;*/
            case 32111006: //甦醒
                eff.info.put(MapleStatInfo.time, 2100000000);
                eff.statups.put(MapleBuffStat.REAPER, (int) eff.info.get(MapleStatInfo.x));
                break;
            case 32101004: //紅色吸血術
                eff.statups.put(MapleBuffStat.COMBO_DRAIN, eff.info.get(MapleStatInfo.x));
                break;
            case 32101005: //長杖極速
                eff.statups.put(MapleBuffStat.BOOSTER, eff.info.get(MapleStatInfo.x) * 2);
                break;
            case 32111014: //防禦姿態
                eff.statups.put(MapleBuffStat.STANCE, eff.info.get(MapleStatInfo.prop));
                break;
            case 32121005: //危機繩索
                eff.statups.put(MapleBuffStat.AURA_BOOST, (int) eff.getLevel());
                break;
            case 32121010: //煉獄鬥氣
                eff.info.put(MapleStatInfo.time, 2100000000);
                eff.statups.put(MapleBuffStat.ENRAGE, (eff.info.get(MapleStatInfo.x) * 100) + 1);
                eff.statups.put(MapleBuffStat.爆击概率增加, eff.info.get(MapleStatInfo.z));
                eff.statups.put(MapleBuffStat.最小爆击伤害, eff.info.get(MapleStatInfo.y));
                break;
            case 32111010: //瞬間移動精通
                eff.info.put(MapleStatInfo.mpCon, eff.info.get(MapleStatInfo.y));
                eff.info.put(MapleStatInfo.time, 2100000000);
                eff.statups.put(MapleBuffStat.TELEPORT_MASTERY, eff.info.get(MapleStatInfo.x));
                eff.monsterStatus.put(MonsterStatus.STUN, 1);
                break;
            case 32121007: //楓葉祝福
                eff.statups.put(MapleBuffStat.MAPLE_WARRIOR, eff.info.get(MapleStatInfo.x));
                break;
            case 32121053: //自由意志                
                break;
            case 32121054: //聯盟繩索                
                break;
            case 32121056: //戰鬥精通
                eff.statups.put(MapleBuffStat.STANCE, eff.info.get(MapleStatInfo.x));
                eff.statups.put(MapleBuffStat.BOSS攻擊力, eff.info.get(MapleStatInfo.indieMaxDamageOver));
                eff.statups.put(MapleBuffStat.DAMAGE_CAP_INCREASE, eff.info.get(MapleStatInfo.y));
                break;
            default:
                System.out.println("未知的 煉獄巫師(3200) Buff: " + skill);
                break;
        }
    }
}
