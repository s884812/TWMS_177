package server.buffs.buffclasses.hero;

import client.MapleBuffStat;
import client.MapleJob;
import client.MonsterStatus;
import server.MapleStatEffect;
import server.MapleStatInfo;
import server.buffs.AbstractBuffClass;

public class EunWolBuff extends AbstractBuffClass {
	public EunWolBuff() {
		buffs = new int[]{
			20050286,
			25111209,
                        25111206,
                        25121132,
		};
	}
	
	@Override
    public boolean containsJob(int job) {
        return MapleJob.is隱月(job);
    }

    @Override
    public void handleBuff(MapleStatEffect eff, int skill) {
        switch (skill) {
            case 20050286:
                    eff.statups.put(MapleBuffStat.WILLOW_DODGE, eff.info.get(MapleStatInfo.prop));
                    break;
            case 25111209:
                    eff.statups.put(MapleBuffStat.JUDGMENT_DRAW, eff.info.get(MapleStatInfo.y));
                    break;
            case 25111206:
                    eff.monsterStatus.put(MonsterStatus.FREEZE, 1);
                    eff.info.put(MapleStatInfo.time, Integer.MAX_VALUE);
//                    eff.overTime = true;
                    break;
            case 25121132:
                    eff.statups.put(MapleBuffStat.DAMAGE_PERCENT, eff.info.get(MapleStatInfo.indieDamR));
                    eff.statups.put(MapleBuffStat.BOSS攻擊力, eff.info.get(MapleStatInfo.indieMaxDamageOver));
                    eff.info.put(MapleStatInfo.time,  60 * 1000);
                    break;
            default:
                System.out.println("未知的 隱月(2500) Buff: " + skill);
                break;
        }
    }
}
