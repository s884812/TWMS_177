package client;

import constants.GameConstants;
import handling.Buffstat;
import java.io.Serializable;

public enum MapleBuffStat implements Serializable, Buffstat {

    //未知
    BEARASSAULT(0x6000, 1),
    飛行坐騎(0x10000, 3),
    //0x800000 debuff, shiny yellow

    //==========================Mask - 1 - IDA[0xE]
    //物理攻擊力增加(176-OK)
    INDIE_PAD(0x80000000, 1, true),//indiePad
    //魔法攻擊力增加(176-OK)
    INDIE_MAD(0x40000000, 1, true),//indieMad
    //物理防御力增加(176-OK)
    WDEF_BOOST(0x20000000, 1, true),//indiePdd
    //魔法防御力增加(176-OK)
    MDEF_BOOST(0x10000000, 1, true),//indieMdd
    //最大體力(176-OK)
    HP_BOOST(0x8000000, 1, true), //indieMaxHp, indieMhp
    //最大體力百分比(176-OK)
    HP_BOOST_PERCENT(0x4000000, 1, true), //indieMhpR
    //最大魔法
    MP_BOOST(0x2000000, 1, true),//indieMaxMp
    //最大魔法百分比(176-OK)
    MP_BOOST_PERCENT(0x1000000, 1, true), //indieMmpR
    //命中值增加(176-OK)
    ANGEL_ACC(0x800000, 1, true),//indieAcc
    // 聖靈神速(176-OK)
    ANGEL_AVOID(0x400000, 1, true),
    //疾速之輪行蹤(176-OK)
    ANGEL_JUMP(0x200000, 1, true),
    //疾速之輪行蹤(176-OK)
    INDIE_SPEED(0x100000, 1, true),
    //所有能力提升(176-OK)
    INDIE_ALL_STATE(0x80000, 1, true), //indieAllStat    
    //疾速之輪行蹤(176-OK)
    ATTACK_SPEED2(0x20000, 1, true),
    //攻擊速度提升(176-OK)
    ATTACK_SPEED(0x10000, 1, true), //UNIGNORABLE_PDR or DAMAGE_REFLECT or ATTACK_SPEED or WATK
    //提高技能攻擊力(176-OK)
    DAMAGE_PERCENT(0x20, 1, true),//indieDamR
    //傷害最大值(176-OK)
    DAMAGE_CAP_INCREASE(0x4, 1, true),
    //狀態異常耐性(176-OK)
    狀態異常耐性(0x2, 1, true),
    //所有屬性抵抗(176-OK)
    所有屬性抵抗(0x1, 1, true),
    //==========================Mask - 2 - IDA[0xD]
    //爆擊率提升(176-OK)
    CRITICAL_PERCENT_UP(0x80000000, 2, true), //critical or damage%
    //超衝擊防禦_防禦力
    PARASHOCK_GUARD_DEF(0x40000000, 2, true),//超衝擊防禦.z
    //BOSS攻擊力(176-OK)
    BOSS攻擊力(0x20000000, 2, true),
    //無視怪物防禦率
    IGNORE_MONSTER_DEF(0x10000000, 2),//indieIgnoreMobpdpR
    //物理攻擊力
    WATK(0x4000, 2),
    //物理防御力
    WDEF(0x2000, 2),
    //魔法攻擊力
    MATK(0x1000, 2),
    //魔法防御力
    MDEF(0x800, 2),
    //命中率
    ACC(0x400, 2),
    //迴避率
    AVOID(0x200, 2),
    //手技
    HANDS(0x100, 2),
    //移動速度(176-OK)
    SPEED(0x80, 2),
    //跳躍力(176-OK)
    JUMP(0x40, 2), //d
    //魔心防禦(176-OK)
    MAGIC_GUARD(0x20, 2),
    //隱藏術(176-OK)
    DARKSIGHT(0x10, 2), //d
    //攻擊加速(176-OK)
    BOOSTER(0x8, 2), // d
    //傷害反擊
    POWERGUARD(0x4, 2),
    //神聖之火_最大MP(不被其他最大魔法百分比覆盖)(176-OK)
    MAXMP(0x2, 2),
    //神聖之火_最大HP(不被其他最大体力百分比覆盖)(176-OK)
    MAXHP(0x1, 2),
    //==========================Mask - 3 - IDA[0xC]
    //神聖之光
    INVINCIBLE(0x80000000, 3),
    //無形之箭
    SOULARROW(0x40000000, 3),
    //昏迷
    STUN(0x20000000, 3),
    //中毒
    POISON(0x10000000, 3),
    //封印
    SEAL(0x8000000, 3),
    //黑暗
    DARKNESS(0x4000000, 3),
    //鬥氣集中
    COMBO(0x2000000, 3),
    //召喚獸
    SUMMON(0x2000000, 3),
    //屬性攻擊
    WK_CHARGE(0x1000000, 3),
    //龍之力量
    DRAGONBLOOD(0x1000000, 3),
    //神聖祈禱(176-OK)
    HOLY_SYMBOL(0x800000, 3),
    //(CMS_聚財術)
    MESOUP(0x400000, 3),
    //影分身(IDA-Check-OK)(176-OK)
    SHADOWPARTNER(0x200000, 3), // d
    //勇者掠奪術
    PICKPOCKET(0x100000, 3),
    //替身術
    PUPPET(0x100000, 3), // HACK - shares buffmask with pickpocket - odin special ^.-
    //楓幣護盾
    MESOGUARD(0x80000, 3),
    //
    HP_LOSS_GUARD(0x40000, 3),
    //虛弱
    WEAKEN(0x20000, 3),
    //詛咒
    CURSE(0x10000, 3),
    //緩慢(IDA-Check-OK)
    SLOW(0x8000, 3),
    //變身(176-OK)
    MORPH(0x4000, 3),
    //恢復(176-OK)
    RECOVERY(0x2000, 3),
    //楓葉祝福(176-OK)
    MAPLE_WARRIOR(0x1000, 3),
    //格擋(穩如泰山)(176-OK)
    STANCE(0x800, 3),
    //銳利之眼
    SHARP_EYES(0x400, 3),
    //魔法反擊
    MANA_REFLECTION(0x200, 3),
    //誘惑
    SEDUCE(0x100, 3),
    //暗器傷人
    SPIRIT_CLAW(0x80, 3), // d
    //時空門
    MYSTIC_DOOR(0x80, 3),
    //魔力無限
    INFINITY(0x40, 3),
    //進階祝福
    HOLY_SHIELD(0x20, 3), //advanced blessing after ascension
    //敏捷提升(176-OK)
    HAMSTRING(0x10, 3),
    //命中率增加
    BLIND(0x8, 3),
    //集中精力
    CONCENTRATE(0x4, 3),
    //不死化
    ZOMBIFY(0x2, 3),
    //(CMS_英雄回聲)
    ECHO_OF_HERO(0x1, 3),
    //==========================Mask - 4 - IDA[0xB]
    //楓幣獲得率
    MESO_RATE(0x80000000, 4),
    //
    GHOST_MORPH(0x40000000, 4),
    //
    ARIANT_COSS_IMU(0x20000000, 4), // The white ball around you
    //混亂
    REVERSE_DIRECTION(0x10000000, 4),
    //掉寶幾率
    DROP_RATE(0x8000000, 4), //d
    //經驗倍率
    EXPRATE(0x4000000, 4),
    //樂豆倍率
    ACASH_RATE(0x2000000, 4),
    //
    ILLUSION(0x1000000, 4),
    //8 = unknown
    //狂暴戰魂
    BERSERK_FURY(0x400000, 4),
    //金剛霸體
    DIVINE_BODY(0x200000, 4),
    //(CMS_闪光击)
    SPARK(0x80000, 4),
    //(CMS_终极弓剑)
    FINALATTACK(0x80000, 4),
    //隱藏刀(176-OK)
    BLADE_CLONE(0x40000, 4),
    //自然力重置
    ELEMENT_RESET(0x20000, 4),
    //(CMS_风影漫步)
    WIND_WALK(0x10000, 4),
    //組合無限
    UNLIMITED_COMBO(0x8000, 4),
    //矛之鬥氣
    ARAN_COMBO(0x4000, 4),
    //嗜血連擊(176-OK)
    COMBO_DRAIN(0x2000, 4),
    //宙斯之盾
    COMBO_BARRIER(0x1000, 4),
    //強化連擊(CMS_戰神抗壓)
    BODY_PRESSURE(0x800, 4),
    //釘錘(CMS_戰神威勢)
    SMART_KNOCKBACK(0x400, 4),
    //(CMS_天使狀態)
    PYRAMID_PQ(0x200, 4),
    // 1 ?
    //無法使用藥水
    POTION_CURSE(0x80, 4),
    //
    SHADOW(0x40, 4), //receiving damage/moving
    //致盲
    BLINDNESS(0x20, 4),
    //緩慢術
    SLOWNESS(0x10, 4),
    //守護之力(CMS_魔法屏障)
    MAGIC_SHIELD(0x8, 4),
    //魔法抵抗．改
    MAGIC_RESISTANCE(0x4, 4),
    //靈魂之石
    SOUL_STONE(0x2, 4),
    //飛天騎乘
    SOARING(0x1, 4),
    //==========================Mask - 5 - IDA[0xA]
    //冰凍
    FREEZE(0x80000000, 5),
    //雷鳴之劍
    LIGHTNING_CHARGE(0x40000000, 5),
    //鬥氣爆發(176-OK)
    ENRAGE(0x20000000, 5),
    //貓頭鷹召喚(176-OK)
    OWL_SPIRIT(0x10000000, 5),
    //隱‧鎖鏈地獄(176-OK)
    CHAINS_OF_HELL(0x8000000, 5),
    //絕殺刃(176-OK)
    FINAL_CUT(0x4000000, 5),
    //
    DAMAGE_BUFF(0x2000000, 5),
    //
    ATTACK_BUFF(0x1000000, 5), //attack %? feline berserk v143
    //地雷(IDA-Check-OK)
    RAINING_MINES(0x800000, 5),
    //增強_MaxHP(176-OK)
    ENHANCED_MAXHP(0x400000, 5),
    //增強_MaxMP(176-OK)
    ENHANCED_MAXMP(0x200000, 5),
    //增強_物理攻擊力(176-OK)
    ENHANCED_WATK(0x100000, 5),
    //增強_魔法攻擊力
    ENHANCED_MATK(0x80000, 5),
    //增強_物理防禦力(176-OK)
    ENHANCED_WDEF(0x40000, 5),
    //增強_魔法防禦力(176-OK)
    ENHANCED_MDEF(0x20000, 5),
    //全備型盔甲(176-OK)
    PERFECT_ARMOR(0x10000, 5),
    //終極賽特拉特_PROC
    SATELLITESAFE_PROC(0x8000, 5),
    //終極賽特拉特_吸收
    SATELLITESAFE_ABSORB(0x4000, 5),
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_11(0x2000, 5),
    //颶風
    TORNADO(0x2000, 5),
    //咆哮_會心一擊機率增加
    CRITICAL_RATE_BUFF(0x1000, 5),
    //咆哮_MaxMP 增加
    MP_BUFF(0x800, 5),
    //咆哮_傷害減少
    DAMAGE_TAKEN_BUFF(0x400, 5),
    //咆哮_迴避機率
    DODGE_CHANGE_BUFF(0x200, 5),
    //
    CONVERSION(0x100, 5),//幻灵转化?不知道對不對<--被改成被動技
    //甦醒(176-OK)
    REAPER(0x40, 5),
    //潛入(176-OK)
    INFILTRATE(0x20, 5),
    //(CMS_金属机甲)
    MECH_CHANGE(0x10, 5),
    //黑色繩索(IDA-Check-OK)(176-OK)
    DARK_AURA(0x8, 5),
    //藍色繩索(IDA-Check-OK)(176-OK)
    BLUE_AURA(0x4, 5),
    //黃色繩索(IDA-Check-OK)(176-OK)
    YELLOW_AURA(0x2, 5),
    //超級體(IDA-Check-OK)(176-OK)
    BODY_BOOST(0x1, 5),
    //==========================Mask - 6 - IDA[0x9]
    //暴走形态
    FELINE_BERSERK(0x80000000, 6),
    //幸运骰子(IDA-Check-OK)
    DICE_ROLL(0x40000000, 6),
    //祝福护甲
    DIVINE_SHIELD(0x20000000, 6),
    //攻击力增加百分比(176-OK)
    DAMAGE_RATE(0x10000000, 6),
    //瞬間移動精通(176-OK)
    TELEPORT_MASTERY(0x8000000, 6),
    //戰鬥命令
    COMBAT_ORDERS(0x8000000, 6),
    //追隨者
    BEHOLDER(0x4000000, 6),
    //裝備潛能無效化
    DISABLE_POTENTIAL(0x2000000, 6),
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF11(0x2000000, 6),
    //
    GIANT_POTION(0x1000000, 6),
    //玛瑙的保佑
    ONYX_SHROUD(0x800000, 6),
    //玛瑙的意志
    ONYX_WILL(0x400000, 6),//-2
    //龍捲風
    TORNADO_CURSE(0x200000, 6),
    //天使祝福
    BLESS(0x100000, 6),
    //8 //blue star + debuff
    //4 debuff	 but idk
    //压制术
    THREATEN_PVP(0x20000, 6),
    //冰骑士
    ICE_KNIGHT(0x10000, 6),
    //8 debuff idk.
    //4 unknown
    //力量(176-OK)
    STR(0x1000, 6),//-2
    //智力(176-OK)
    INT(0x800, 6),//-2
    //敏捷(176-OK)
    DEX(0x400, 6),//-2
    //運氣(176-OK)
    LUK(0x200, 6),//-2
    //未知(未確定)
    ATTACK(0x100, 6), //used also for kaiser majesty //-2
    //2 unknown tornado debuff? - hp
    //未知(未確定)
    //未知(未確定)
    STACK_ALLSTATS(0x100, 6),
    //未知(未確定)
    PVP_DAMAGE(0x80, 6),
    //IDA移動Buff(IDA-Check-OK) -- 還不知道功能
    IDA_MOVE_BUFF7(0x80, 6),
    //未知(未確定)
    PVP_ATTACK(0x40, 6), //skills
    //未知(未確定)
    INVINCIBILITY(0x20, 6),
    //隱藏潛能(未確定)
    HIDDEN_POTENTIAL(0x10, 6),
    //未知(未確定)
    ELEMENT_WEAKEN(0x8, 6),
    //未知(未確定)
    SNATCH(0x4, 6), //however skillid is 90002000, 1500 duration
    //凍結(未確定)
    FROZEN(0x2, 6),
    //1, unknown

    //==========================Mask - 7 - IDA[0x8]
    //冰技能(未確定)
    ICE_SKILL(0x80000000, 7),
    //4 - debuff
    //无限精气
    BOUNDLESS_RAGE(0x20000000, 7),
    //未知(未確定)
    PVP_FLAG(0x10000000, 7),
    //8
    HOLY_MAGIC_SHELL(0x4000000, 7),
    核爆術(0x2000000, 7),
    //神秘狙擊
    MANY_USES(0x1000000, 7/*, true*/),
    //大魔法師(已改成被動,無BUFF)
    BUFF_MASTERY(0x800000, 7), //buff duration increase //was 0x80, 6
    //異常抗性(176-OK)
    ABNORMAL_STATUS_R(0x200000, 7), // %
    //屬性抗性(176-OK)
    ELEMENTAL_STATUS_R(0x100000, 7), // %
    //水之盾(176-OK)
    WATER_SHIELD(0x80000, 7),
    //黑暗变形
    DARK_METAMORPHOSIS(0x40000, 7),
    //随机橡木桶
    BARREL_ROLL(0x20000, 7),
    //精神连接(IDA-Check-OK) [跟靈魂灌注是同個東西]
    SPIRIT_LINK(0x10000, 7),
    //靈魂灌注_攻擊增加(IDA-Check-OK)(176-OK)
    DAMAGE_R(0x10000, 7),
    //神圣拯救者的祝福
    VIRTUE_EFFECT(0x8000, 7),
    //靈魂灌注_爆擊率增加(176-OK)
    CRITICAL_RATE(0x2000, 7),
    //未知(未確定)
    NO_SLIP(0x400, 7),
    //未知(未確定)
    FAMILIAR_SHADOW(0x200, 7),
    //未知(未確定)
    LEECH_AURA(0x100, 7),
    //吸血鬼之触
    ABSORB_DAMAGE_HP(0x40, 7),
    //提高防禦力
    DEFENCE_BOOST_R(0x20, 7),
    // 1 unknown
    //未知(未確定)
    UNKNOWN8(0x20, 7),
    // 0x40 add attack, 425 wd, 425 md, 260 for acc, and avoid
    // 0x80
    //未知(未確定)
    WEAPON_ATTACK(0x800, 7),
    //未知(未確定)
    UNKNOWN12(0x1000, 7), //+ 5003 wd
    // 1,
    // 8, true
    // 4
    // WEAPON ATTACK 2, true
    // 1, true
    // 8, true
    // 4  true
    // 2 idk
    // 1  true

    //==========================Mask - 8 - IDA[0x7]
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_1(0x4000000, 8),
    //IDA移動Buff(IDA-Check-OK) -- 還不知道功能
    IDA_MOVE_BUFF1(0x20000000, 8),
    //角設預設Buff(176-OK)
    CHAR_BUFF(0x800000, 8),
    //角設預設Buff(176-OK)
    MOUNT_MORPH(0x400000, 8),
    //未知(未確定)
    UNKNOWN9(0x200000, 8),
    //繼承人(176-OK)
    KILL_COUNT(0x100000, 8),
    //無視防禦力(IDA-Check-OK)
    IGNORE_DEF(0x80000, 8),
    //幸運幻影(176-OK)
    FINAL_FEINT(0x40000, 8),
    //幻影斗蓬(176-OK)
    PHANTOM_MOVE(0x20000, 8),
    //最小爆击伤害(176-OK)
    最小爆击伤害(0x10000, 8),
    //爆击概率增加(176-OK)
    爆击概率增加(0x8000, 8),
    //審判(IDA-Check-OK)
    JUDGMENT_DRAW(0x4000, 8),
    //增加_物理攻击(IDA-Check-OK) -- 172 加強戰力使用的Buff
    DAMAGE_UP(0x2000, 8),
    
    //IDA移動Buff(IDA-Check-OK) -- 還不知道功能
    IDA_MOVE_BUFF2(0x800, 8),
    //IDA移動Buff(IDA-Check-OK) -- 還不知道功能
    IDA_MOVE_BUFF3(0x400, 8),
    //IDA移動Buff(IDA-Check-OK) -- 還不知道功能
    IDA_MOVE_BUFF4(0x200, 8),
    //全面防禦
    HYBRID_DEFENSES(0x200, 8),
    //虚空重压
    虚空重压(0x100, 8),
    //光蝕 & 暗蝕(IDA-Check-OK)
    LUMINOUS_GAUGE(0x40, 8),
    //黑暗強化(IDA-Check-OK)
    DARK_CRESCENDO(0x20, 8),
    //黑暗祝福
    BLACK_BLESSING(0x10, 8),
    //抵禦致命異常狀態(如 元素適應(火、毒), 元素適應(雷、冰), 聖靈守護)
    PRESSURE_VOID(0x8, 8),
    //血之限界(IDA-Check-OK)(176-OK)
    LUNAR_TIDE(0x4, 8), //hp to damage
    //凱撒變型值(IDA-Check-OK)(176-OK)
    KAISER_COMBO(0x1, 8),
    //==========================Mask - 9 - IDA[0x6]
    //堅韌護甲(176-OK)
    堅韌護甲(0x80000000, 9),
    //凱撒模式切換(IDA-Check-OK)(176-OK)
    KAISER_MODE_CHANGE(0x40000000, 9),
    //0x20000000
    //IDA移動Buff(IDA-Check-OK) -- 還不知道功能
    IDA_MOVE_BUFF5(0x10000000, 9),
    //意志之劍(IDA-Check-OK)(176-OK)
    TEMPEST_BLADES(0x8000000, 9),
    //會心一擊傷害(IDA-Check-OK)(176-OK)
    CRIT_DAMAGE(0x4000000, 9),
    //0x2000000
    //靈魂傳動(IDA-Check-OK)
    DAMAGE_ABSORBED(0x100000, 9),
    伤害置换(0x2000000, 9),
    天使亲和(0x1000000, 9),
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_12(0x1000000, 9),
    三位一体(0x800000, 9),
    
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF3(0x400000, 9),
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF5(0x80000, 9),

    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_3(0x200000, 9),
    //繼承人(176-OK)
    SOUL_BUSTER(0x100000, 9),
    //未知(未確定)
    PRETTY_EXALTATION(0x100000, 9),
    //未知(未確定)
    KAISER_MAJESTY3(0x80000, 9), //UNIGNORABLE_PDR or DAMAGE_REFLECT or ATTACK_SPEED or WATK
    //未知(未確定)
    KAISER_MAJESTY4(0x40000, 9), //UNIGNORABLE_PDR or DAMAGE_REFLECT or ATTACK_SPEED or WATK\
    //IDA移動Buff(IDA-Check-OK) -- 還不知道功能
    IDA_MOVE_BUFF6(0x40000, 9),
    //靈魂深造
    RECHARGE(0x20000, 9),
    //0x10000
    //未知(未確定)
    
    //隱‧鎖鏈地獄(176-OK)
    STATUS_RESIST_TWO(0x8000, 9),
    
    //未知(未確定)
    PARTY_STANCE(0x4000, 9),
    
    終極審判(0x1000, 5),
    //冰雪結界
    ABSOLUTE_ZERO_AURA(0x800, 9),
    //火靈結界
    INFERNO_AURA(0x400, 9),
    
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF6(0x400, 9),
    
    //復仇天使
    AVENGING_ANGEL(0x200, 9, true),
    天堂之門(0x100, 9),
    //戰鬥準備
    BOWMASTERHYPER(0x80, 9),
    //0x40
    //0x20
    //0x10
    //0x8
    撫慰甘露(0x4, 9),
    
    //修羅(176-OK)
    ASURA_IS_ANGER(0x1, 9),
    
    //==========================Mask - 10 - IDA[0x5]
    //暴能續發
    STIMULATING_CONVERSATION(0x80000000, 10),
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_2(0x10000000, 10),
    //未知(未確定)
    MOON_STANCE2(0x10000000, 10), //critical or damage%
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF10(0x8000000, 10),
    //BOSS傷害
    BOSS_DAMAGE(0x4000000, 10),
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF8(0x4000000, 10),
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF9(0x2000000, 10),
    //0x2000000
    //0x400000
    //0x200000
    //超越_攻擊(176-OK)
    EXCEED_ATTACK(0x800000, 10),
    //急速療癒(176-OK)
    DIABOLIC_RECOVERY(0x400000, 10),
    // 0x200000  
    // 0x100000    
    //超越(176-OK)
    EXCEED(0x80000, 10),
    //沉月-攻擊數量(176-OK)
    ATTACK_COUNT(0x40000, 10),
    霰弹炮(0x80000, 10),
    //0x40000
    //0x20000

    //傑諾能量(176-OK)
    SUPPLY_SURPLUS(0x8000, 10),
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_5(0x4000, 10),
    //0x2000
    //傑諾飛行(IDA-Check-OK)(176-OK)
    XENON_FLY(0x1000, 10),
    //阿瑪蘭斯發電機
    AMARANTH_GENERATOR(0x1000, 10),
    //0x800
    //元素： 風暴
    STORM_ELEMENTAL(0x400, 10),
    //0x200
    //0x100
    //0x80
    暴风灭世(0x40, 10),
    //光之劍-命中提升(176-OK)
    ACCURACY_PERCENT(0x10, 10),
    迴避率提升(0x8, 10),
    //信天翁(CMS)
    ALBATROSS(0x8, 10),
    //0x4
    //0x2
    //雙重力量 : 沉月/旭日(176.Done)
    SOLUNA_EFFECT(0x1, 10),
    //==========================Mask - 11 - IDA[0x4]
    //光之劍(176-OK)
    ADD_AVOIDABILITY(0x80000000, 11),
    //元素： 靈魂(176-OK)
    SOUL_ELEMENT(0x40000000, 11),
    //靈魂球BUFF(176-OK)
    SOUL_WEAPON(0x4000000, 11),
    //靈魂BUFF(176-OK)
    SOUL_WEAPON_HEAD(0x2000000, 11),
    //
    元素衝擊(0x1000000, 11),
    //復原
    HP_RECOVER(0x800000, 11),
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF4(0x400000, 11),
    //十字深鎖鏈(176-OK)
    CROSS_SURGE(0x200000, 11),
    //
    騎士衝擊波(0x200000, 11),
    //
    轉生(0x100000, 11),
    //超衝擊防禦_防禦概率
    PARASHOCK_GUARD(0x80000, 11),//超衝擊防禦.x
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF12(0x80000, 11),
    //寒冰迅移(IDA-Check-OK)
    CHILLING_STEP(0x40000, 11),
    //0x20000
    //祝福福音
    PASSIVE_BLESS(0x10000, 11),
    //0x8000
    終極射擊_箭(0x4000, 11),
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF13(0x2000, 11),
    //0x2000
    魔幻箭筒(0x1000, 11),
    無限箭筒(0x800, 11),
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_8(0x1000, 11),
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_6(0x800, 11),
    //0x400
    //IDA移動Buff(IDA-Check-OK) -- 還不知道功能
    IDA_MOVE_BUFF8(0x200, 11),
    //0x100
    破甲射擊(0x80, 11),
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_7(0x80, 11),
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF14(0x40, 11),
    //時之威能(176-OK)
    DIVINE_FORCE_AURA(0x20, 11),
    //聖靈神速(176-OK)
    DIVINE_SPEED_AURA(0x10, 11),
    致命爆擊(0x10, 11),
    極速之指(0x8, 11),
    集中專注(0x4, 11),
    //0x2
    //0x1

    //==========================Mask - 12 - IDA[0x3]
    //无视怪物伤害
    ignoreMobDamR(0x4000000, 12),
    靈魂結界(0x2000000, 12),
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_10(0x2000000, 12),
    死裡逃生(0x1000000, 12),
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF15(0x1000000, 12),
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_9(0x400000, 12),
    本鳳凰(0x8000, 12),
    燃燒(0x4000, 12),
    //IDA移動Buff(IDA-Check-OK) -- 還不知道功能
    IDA_MOVE_BUFF9(0x10000, 12),
    元素_闇黑(0x10000, 12),
    火焰防護(0x200, 12),
    暗影僕從(0x100, 12),
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF16(0x20, 12),
    //危機繩索[177-OK]
    AURA_BOOST(0x10, 12),
    //拔刀術[177-OK]
    HAYATO(0x8, 12),
    //拔刀術-新技體[177-OK]
    BATTOUJUTSU_SOUL(0x4, 12),
    //制敵之先[177-OK]
    COUNTERATTACK(0x2, 12),
    //柳身[177-OK]
    WILLOW_DODGE(0x1, 12),
    //==========================Mask - 13 - IDA[0x2]
    //紫扇仰波
    SHIKIGAMI(0x80000000, 13),
    //武神招來[177-OK]
    MILITARY_MIGHT(0x40000000, 13),
    //武神招來[177-OK]
    MILITARY_MIGHT1(0x20000000, 13),
    //武神招來[177-OK]
    MILITARY_MIGHT2(0x10000000, 13),
    //拔刀術[177-OK]
    BATTOUJUTSU_STANCE(0x8000000, 13),
    //0x4000000
    //0x2000000
    //迅速(176-OK)
    JINSOKU(0x1000000, 13),
    //一閃(176-OK)
    HITOKIRI_STRIKE(0x800000, 13),
    //0x400000
    //0x200000
    //0x100000
    //0x80000
    FOX_FIRE(0x40000, 13),
    HAKU_REBORN(0x20000, 13), // 影朋‧花狐(Done)
    HAKU_BLESS(0x10000, 13),
    //0x8000
    //0x4000
    
    //精靈召喚模式[177-OK]
    ANIMAL_SELECT(0x2000, 13),
    
    //0x1000
    //0x800
    //0x400
    //0x200
    
    //IDA特殊Buff(IDA-Check-OK) -- 還不知道功能
    IDA_SPECIAL_BUFF_4(0x100, 13),
    
    
    //依古尼斯咆哮-迴避提升(177-OK)
    PROP(0x40, 13),
    
    //0x20
    
    //功能不知道，但是它是分析封包的重點(IDA-Check-OK)
    IDA_UNK_BUFF1(0x10, 13),
    
    //0x8
    
    //功能不知道(IDA-Check-OK)
    IDA_UNK_BUFF2(0x4, 13),
    //能量獲得(177-OK)
    ENERGY_CHARGE(0x2, 13, true),
    //衝鋒_速度(177-OK)
    DASH_SPEED(0x1, 13, true),
    //==========================Mask - 14 - IDA[0x0]
    //衝鋒_跳躍(177-OK)
    DASH_JUMP(0x80000000, 14, true),
    //怪物騎乘[177-OK]
    MONSTER_RIDING(0x40000000, 14, true),
    //最終極速
    SPEED_INFUSION(0x20000000, 14, true),
    //指定攻擊
    HOMING_BEACON(0x10000000, 14, true),
    //預設Buff-1
    DEFAULTBUFF1(0x8000000, 14, true),
    //預設Buff-2
    DEFAULTBUFF2(0x4000000, 14, true),
    FROZEN_SHIKIGAMI(0x400, 10),
    SPEED_LEVEL(0x8000, 10),//0x8000, 10
    WARRIOR_STANCE(0x10000, 10, true),
    EQUINOX_STANCE(0x80000, 10),;
    private static final long serialVersionUID = 0L;
    private final int buffstat;
    private final int first;
    private boolean stacked = false;
    // [12] [11] [10] [9] [8] [7] [6] [5] [4] [3] [2] [1]
    // [0] [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] [11]

    private MapleBuffStat(int buffstat, int first) {
        this.buffstat = buffstat;
        this.first = first;
    }

    private MapleBuffStat(int buffstat, int first, boolean stacked) {
        this.buffstat = buffstat;
        this.first = first;
        this.stacked = stacked;
    }

    @Override
    public int getPosition() {
        return getPosition(false);
    }

    public final int getPosition(boolean fromZero) {
        if (!fromZero) {
            return this.first;
        }
        if ((first > 0) && (first <= GameConstants.MAX_BUFFSTAT)) {
            return GameConstants.MAX_BUFFSTAT - first;

        }
        return 0;
    }

    @Override
    public int getValue() {
        return buffstat;
    }

    public final boolean canStack() {
        return stacked;
    }
}
