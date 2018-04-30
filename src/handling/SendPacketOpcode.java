package handling;

import constants.ServerConfig;
import tools.FileoutputUtil;
import tools.StringUtil;

public enum SendPacketOpcode implements WritableIntValueHolder {

    // [CLogin::OnPacket]
    // 密碼驗證[完成]
    LOGIN_STATUS((short) 0x00),
    // 帳號信息[完成]
    ACCOUNT_INFO((short) 0x01),
    // 遊客登入[完成]
    GUEST_ID_LOGIN((short) 0x02),
    // 伺服器選單[完成]
    SERVERLIST((short) 0x03),
    // 角色選單[完成]
    CHARLIST((short) 0x04),
    // 伺服器IP[完成]
    SERVER_IP((short) 0x05),
    // 檢查角色名稱[完成]
    CHAR_NAME_RESPONSE((short) 0x06),
    // 建立角色[完成]
    ADD_NEW_CHAR_ENTRY((short) 0x07),
    // 刪除角色[完成]
    DELETE_CHAR_RESPONSE((short) 0x08),

    // 0x09 【刪除新星世界角色】[Int][Boolean] false => [Long][Long]
    // 0x0A 【登入新星世界伺服器(未確認)】[Int][Byte]
    
    // 變更角色名稱[完成] [Int][String][Short]
    CHANGE_NAME((short) 0x0B),
    
    // 0x0C [Int]

    // 變更頻道[完成]
    CHANGE_CHANNEL((short) 0x0D),
    // Ping[完成]
    PING((short) 0x0E),
    // 購物商城[完成]
    CS_USE((short) 0x0F),
    
    // 0x10 CClientSocket::OnAuthenMessage【驗證訊息】[Int][Byte]
    // 0x11 
    // 0x12 [位置未知]
    // 0x13 【外掛偵測】[位置未知]
    // 0x14 [位置未知]
    // 0x15 [位置未知]
    // 0x16 【身分驗證】[Byte]
    // 0x17 [位置未知]
    // 0x18 CClientSocket::OnCheckCrcResult【外掛偵測】[Boolean]

    // 推薦伺服器[完成]
    ENABLE_RECOMMENDED((short) 0x19),
    // 推薦伺服器訊息[未知] [IDA => 0 Byte]
    SEND_RECOMMENDED((short) 0x1A),
    // 打工系統[完成]
    PART_TIME((short) 0x1B),
    
    // 0x1C [-]
    
    // 選擇伺服器[完成] [Int(伺服器編號)]
    GAME_STATUS((short) 0x1D),
    
    // 0x1E [Long] * 8
    // 0x1F [-] => 接收 0x44
    // 0x20 [Int][Int]
    // 0x21 【購買道具】[Int][Int][Int][Byte][Byte][Byte]
    
    // 選擇性別 + 設置第二組密碼[完成]
    CHOOSE_GENDER((short) 0x22),
    // 選擇性別 + 設置第二組密碼回覆[完成]
    GENDER_SET((short) 0x23),
    // 外掛偵測[完成]
    HACKSHIELD_REQUEST((short) 0x24),
    // 強制變更角色名稱[完成] [-]
    FORCED_CHANGE_CHAR_NAME((short) 0x25),
    // 強制變更角色名稱訊息[完成] [Byte]
    FORCED_CHANGE_CHAR_NAME_NOTICE((short) 0x26),  
    // 伺服器狀態[完成]
    SERVERSTATUS((short) 0x27),
    // 背景驗證[完成]
    LOGIN_AUTH((short) 0x28),
    
    // 0x29 [位置未知]
    // 0x2A [位置未知]
    // 0x2B [Byte][Byte][Int]
    // 0x2C 【新星世界按鈕 + 刪除角色按鈕】[Int]
    // 0x2D
    // 0x2E
    
    // 第二組密碼錯誤[完成]
    SECONDPW_ERROR((short) 0x2F),
    
    // 0x4A7 【獲得驗證碼 + 獲得可建立職業】
    // 0x4A8
    
    //================================
    // CWvsContext::OnPacket 開始
    //================================    
    // 道具操作[完成]
    INVENTORY_OPERATION((short) 0x30),
    // 擴充道具欄位[完成]
    INVENTORY_GROW((short) 0x31),
    // 更新能力值[完成]
    UPDATE_STATS((short) 0x32),
    // 獲得輔助效果[完成]
    GIVE_BUFF((short) 0x33),
    // 取消輔助效果[完成]
    CANCEL_BUFF((short) 0x34),
    // 臨時能力值開始[完成]
    TEMP_STATS((short) 0x35),
    // 重置臨時能力值[完成]
    TEMP_STATS_RESET((short) 0x36),
    // 更新技能[完成]
    UPDATE_SKILLS((short) 0x37),
    // 幻影俠盜複製技能成功
    UPDATE_STOLEN_SKILLS((short) 0x38),
    // 幻影俠盜竊取技能時顯示 
    TARGET_SKILL((short) 0x39),
    
    // 0x3A [Byte]
    
    // 偷竊技能檢查(Done)
    STEEL_SKILL_CHECK((short) 0x3B),
    
    // 0x3C
    // 0x3D
    
    // 名聲回覆[完成]
    FAME_RESPONSE((short) 0x3E),
    // 顯示角色狀態信息[完成]
    SHOW_STATUS_INFO((short) 0x3F),
    // 訊息[完成]
    SHOW_NOTES((short) 0x40),
    // 瞬移之石[完成]
    TROCK_LOCATIONS((short) 0x41),
    // 測謊機[完成]
    LIE_DETECTOR((short) 0x42),
    // 炸彈測謊機[完成]
    BOMB_LIE_DETECTOR((short) 0x43),
    
    // 0x44 (null)
    
    // 設置舉報[完成]
    REPORT_RESPONSE((short) 0x45),
    // 舉報時間[完成]
    REPORT_TIME((short) 0x46),
    // 舉報狀態[完成]
    REPORT_STATUS((short) 0x47),
    
    // 0x48 [Int] [do { [Int][Int] }] [176+]
    
    // 更新騎寵[完成]
    UPDATE_MOUNT((short) 0x49),
    // 任務完成[完成]
    SHOW_QUEST_COMPLETION((short) 0x4A),
    // 精靈商人[完成]
    SEND_TITLE_BOX((short) 0x4B),
    // 使用技能書[完成]
    USE_SKILL_BOOK((short) 0x4C),
    // 重置SP[完成]
    SP_RESET((short) 0x4D),
    // 重置AP[完成]
    AP_RESET((short) 0x4E),
    // 經驗瓶[完成]
    EXP_POTION((short) 0x4F),
    // 散佈道具[完成] [Byte][Int][Byte]
    DISTRIBUTE_ITEM((short) 0x50),
    // 擴充角色欄位[完成]
    EXPAND_CHARACTER_SLOTS((short) 0x51),
    // 申請變更角色名稱[完成]
    APPLY_NAME_CHANGE((short) 0x52),
    // 向上整理[完成]
    FINISH_SORT((short) 0x53),
    // 種類排序[完成]
    FINISH_GATHER((short) 0x54),
    
    // 0x55 (null)
    // 0x56 (null)
    
    // 角色信息[完成]
    CHAR_INFO((short) 0x57),
    // 隊伍操作[完成]
    PARTY_OPERATION((short) 0x58),
    // 尋找隊員
    MEMBER_SEARCH((short) 0x59),
    // 隊伍搜尋
    PARTY_SEARCH((short) 0x5A),
    
    // 0x5B
    // 0x5C
    // 0x5D (null)
    
    // 遠征隊操作
    EXPEDITION_OPERATION((short) 0x5E),
    // 好友列表[完成]
    BUDDYLIST((short) 0x5F),
    
    // 0x60 [176+]
    // 0x61 [176+]
    
    // 請求回覆[完成]
    GUILD_REQUEST((short) 0x62),      
    // 公會操作[完成]
    GUILD_OPERATION((short) 0x63),
    // 公會聯盟操作[完成]
    ALLIANCE_OPERATION((short) 0x64),
    // 時空門[完成]
    SPAWN_PORTAL((short) 0x65),
    // 開放通道[完成]
    MECH_PORTAL((short) 0x66),
    // 伺服器訊息[完成]
    SERVERMESSAGE((short) 0x67),
    // 阿斯旺海防戰訊息[完成]
    AZWAN_MSG((short) 0x68),
    // 花生機獎勵[完成]
    PIGMI_REWARD((short) 0x69),
    // 獲得道具[完成]
    ITEM_OBTAIN((short) 0x6A),
    // 智慧貓頭鷹[完成]
    OWL_OF_MINERVA((short) 0x6B),
    // 智慧貓頭鷹回覆
    OWL_RESULT((short) 0x6C),
    
    // 0x6D (null)
    // 0x6E (null)
    
    // 戒指操作請求[完成]
    ENGAGE_REQUEST((short) 0x6F),
    // 戒指操作返回[完成]
    ENGAGE_RESULT((short) 0x70),
    // 結婚禮物[完成]
    WEDDING_GIFT((short) 0x71),
    // 結婚地圖變更[完成] [Int][Int]
    WEDDING_MAP_TRANSFER((short) 0x72),
    // 使用寵物飼料[完成]
    USE_CASH_PET_FOOD((short) 0x73),
    // 使用寵物技能[完成]
    USE_CASH_PET_SKILL((short) 0x74),
    
    // 0x75 [-]
    
    // 神秘的鐵砧[完成]
    FUSION_ANVIL((short) 0x76),
    
    // 0x77 [Byte][Long]
    
    // 黃色公告[完成]
    YELLOW_CHAT((short) 0x78),
    // 商店優惠[完成]
    SHOP_DISCOUNT((short) 0x79),
    // 捕捉怪物[完成]
    CATCH_MOB((short) 0x7A),
    // 建立玩家Npc[完成] [Byte]
    MAKE_PLAYER_NPC((short) 0x7B),
    // 玩家Npc[完成]
    PLAYER_NPC((short) 0x7C),
    
    // 0x7D(null)
    
    // 隱藏Npc[完成]
    DISABLE_NPC((short) 0x7E),
    // 獲得卡片[完成]
    GET_CARD((short) 0x7F),
    // 卡片設置[完成] [Int]
    CARD_SET((short) 0x80),
    // 變更小時[完成]
    CHANGE_HOUR((short) 0x81),
    // 重置小地圖[完成]
    RESET_MINIMAP((short) 0x82),
    // 教師更新[完成]
    CONSULT_UPDATE((short) 0x83),
    // 班級更新[完成]
    CLASS_UPDATE((short) 0x84),
    // 網頁瀏覽更新[完成]
    WEB_BOARD_UPDATE((short) 0x85),
    // 擊殺數量[完成]
    SESSION_VALUE((short) 0x86),
    // 組隊數值[完成]
    PARTY_VALUE((short) 0x87),
    // 地圖數值[完成]
    MAP_VALUE((short) 0x88),
    
    // 0x89 [String][String]
    
    // 精靈墜飾[完成]
    EXP_BONUS((short) 0x8A),
    // 家族系統[已關閉][完成]
    SEND_PEDIGREE((short) 0x8B),
    OPEN_FAMILY((short) 0x8C),
    FAMILY_MESSAGE((short) 0x8D),
    FAMILY_INVITE((short) 0x8E),
    FAMILY_JUNIOR((short) 0x8F),
    SENIOR_MESSAGE((short) 0x90),
    FAMILY((short) 0x91),
    REP_INCREASE((short) 0x92),
    FAMILY_LOGGEDIN((short) 0x93),
    FAMILY_BUFF((short) 0x94),
    FAMILY_USE_REQUEST((short) 0x95),
    // (公會成員)升級訊息[完成]
    LEVEL_UPDATE((short) 0x96),
    // 结婚訊息[完成]
    MARRIAGE_UPDATE((short) 0x97),
    // 轉職訊息[完成]
    JOB_UPDATE((short) 0x98),
    // 項鍊擴充[完成]
    SLOT_UPDATE((short) 0x99),
    // 請求跟隨提示[完成]
    FOLLOW_REQUEST((short) 0x9A),
    // 新頂部訊息[完成]
    TOP_MSG2((short) 0x9B),
    // 頂部訊息[完成]
    TOP_MSG((short) 0x9C),
    // 新頂部訊息[完成]
    NEW_TOP_MSG((short) 0x9D),
    // 中間訊息[完成]
    MID_MSG((short) 0x9E),
    // 清理中間的訊息[完成]
    CLEAR_MID_MSG((short) 0x9F),
    // 特殊訊息[完成]
    SPECIAL_MSG((short) 0xA0),
    // 楓之谷提示訊息[完成]
    MAPLE_TIP_MSG((short) 0xA1),
    // 楓之谷管理員訊息[完成]
    MAPLE_ADMIN_MSG((short) 0xA2),
    // 檢查道具欄位[完成]
    INVENTORY_FULL((short) 0xA3),
    // 更新美洲豹[完成]
    UPDATE_JAGUAR((short) 0xA4),
    // 神之子能力值
    ZERO_STATS((short) 0xA5),
    // 神之子更新
    ZERO_UPDATE((short) 0xA6),
    
    // 0xA7
    
    // 終極冒險家[完成]
    ULTIMATE_EXPLORER((short) 0xA8),
    
    // 0xA9
    
    // 能力值信息[完成]
    SPECIAL_STAT((short) 0xAA),
    // 更新培養皿時間[完成]
    UPDATE_IMP_TIME((short) 0xAB),
    // 使用培養皿[完成]
    ITEM_POT((short) 0xAC),
    
    // 0xAD
    // 0xAE

    // 武陵道場訊息
    MULUNG_MESSAGE((short) 0xAF),
    // 傳授角色技能
    GIVE_CHARACTER_SKILL((short) 0xB0),
    
    // 0xB1【00 00】
    // 0xB2
    // 0xB3
    // 0xB4
    
    // 武陵排行[完成]
    MULUNG_DOJO_RANKING((short) 0xB5),
    
    // 0xB6
    
    // 更新潛在能力值
    UPDATE_INNER_ABILITY((short) 0xB7),
    
    // 0xB8
    
    // 使用/刪除技能[完成]
    REPLACE_SKILLS((short) 0xB9),
    // 內在能力值訊息[完成]
    INNER_ABILITY_MSG((short) 0xBA),
    // 地圖指引[完成] [Int]
    MINIMAP_ARROW((short) 0xBB),
    
    // 0xBC [Boolean][Int] true => [Int]
    
    // 角色潛在能力設定[完成]
    ENABLE_INNER_ABILITY((short) 0xBD),
    // 角色潛在能力重置
    DISABLE_INNER_ABILITY((short) 0xBE),
    // 獲得名聲值[完成]
    UPDATE_HONOUR((short) 0xBF),
    // 阿斯旺未知[未知]
    AZWAN_UNKNOWN((short) 0xC0),
    // 阿斯旺結果[完成] [Int][Int][Int][Int][Int][Int][Int][Int][Boolean]
    AZWAN_RESULT((short) 0xC1),
    // 阿斯旺擊殺[完成]
    AZWAN_KILLED((short) 0xC2),
    
    // 0xC3 【point】
    // 0xC4 阿斯旺復活[String(玩家名稱)][Int](復活時間)
    
    // 能力傳播者[完成]
    CIRCULATOR_ON_LEVEL((short) 0xC5),
    // 十字獵人訊息[完成]
    SILENT_CRUSADE_MSG((short) 0xC6),
    // 十字獵人商店[完成]
    SILENT_CRUSADE_SHOP((short) 0xC7),
    
    // 0xC8 幸運怪物【UI/UIWindow2.img/mapleMuseum】【UI/UIWindow2.img/mapleMuseum2)(UI/UIWindow2.img/luckyMonstery】
    // 0xC9
    // 0xCA 幸運怪物【UI/UIWindow2.img/mapleMuseum】【UI/UIWindow2.img/mapleMuseum2)(UI/UIWindow2.img/luckyMonstery】
    // 0xCB 【state】
    // 0xCC 【state】
    // 0xCD
    // 自動飛行[完成] [Int]
    AUTO_FLYING((short) 0xCE),
    // 禁止完成任務
    DISALLOW_DELIVERY_QUEST((short) 0xCF),
    // 0xD0 【彈跳視窗】
    // 0xD1 【賓果活動?】 [Byte] 【deck】【bingo】
    // 0xD2 【賓果活動?】 [Byte] 【deck】【bingo】
    // 0xD3
    // 0xD4 【獲取物品?】【---】
    
    // 楓葉點數(完成)
    MAPLE_POINT((short) 0xD5),
    
    // 0xD6 [Long]
    // 0xD7 【方塊洗洗樂?】
    // 0xD8 【重置神聖SP】 [Byte][Int][Byte]
    // 0xD9 【Debug信息?】 [Short](年)[Short](月)[Short](日)[Short](點)[Short](分)[Int]((DWORD)%u, (LONG)%d)【(DWORD)%u, (LONG)%d】
    // 0xDA 【Debug信息?】 [Int][Long]
    // 0xDB
    // 0xDC 【沒有可以套用回復效果的對象。】【Recv => 0x176([Int][Byte])】
    // 0xDD
    // 0xDE 【Recv => 0xC9([Int][Short][Long])】
    // 0xDF 【Recv => 0xC9([Int][Short][Long])】
    // 0xE0
    
    // 變成破壞天使【Recv => 0x173([Byte])
    CHANGE_ANGELIC((short) 0xE1),
    // 解鎖充電技能
    UNLOCK_CHARGE_SKILL((short) 0xE2),
    // 上鎖充電技能
    LOCK_CHARGE_SKILL((short) 0xE3),
    
    // 0xE4
    // 0xE5 【寵物名牌戒指?】【[BP:%02d] %d】【///////////////////////////////】
    
    // 進化系統[完成]
    EVOLVING_ACTION((short) 0xE6),
    // BossPvP技能【Recv => 0x16D】[完成]
    BOSSPVP_SKILL_UI((short) 0xE7),
    
    // 0xE8
    
    // 公會搜索
    GUILD_SEARCH((short) 0xE9),
    
    // 0xEA
    // 0xEB 【幸運怪物】【UI/UIWindow2.img/mapleMuseum】【UI/UIWindow2.img/mapleMuseum2】【UI/UIWindow2.img/luckyMonstery】【UI/UIWindow2.img/luckyMonResult】
    // 0xEC 【獲取物品?】
    // 0xED 【10 00 00 00 00 00 00 00 00 00 00 00 00 00 00】
    // 0xEE
    
    // 請求進程列表[完成]
    SYSTEM_PROCESS_LIST((short) 0xEF),
    
    // 0xF0
    // 0xF1
    // 0xF2

    // 情景喇叭訊息[完成]
    AVATAR_MEGA_RESULT((short) 0xF3),
    // 情景喇叭[完成]
    AVATAR_MEGA((short) 0xF4),
    // 移除情景喇叭[完成]
    AVATAR_MEGA_REMOVE((short) 0xF5),
    // 活動清單[完成]
    EVENT_LIST((short) 0xF6),
    // 楓之谷聊天室
    MESSENGER_OPEN((short) 0xF7),
    
    // 0xF8 【簽名】
    // 0xF9 【問候玩家】
    
    // 王冠活動[完成]
    EVENT_CROWN((short) 0xFA),
    
    // 0xFB [Byte][Byte]
    
    // 自由轉職[完成]
    FREE_CHANGE_JOB((short) 0xFC),
    
    // 0xFD
    // 0xFE
    // 0xFF
    // 0x100
    // 0x101
    // 0x102
    // 0x103
    // 0x104
    // 0x105
    // 0x106 【頂部訊息】
    // 0x107 【IP驗證】
    // 0x108 【Etc/CashPackage.img/%d/SN】
    // 0x109 【獸魔激鬥擂台賽】
    // 0x10A 【UI/UIWindowBT.img/MonsterBattleSelection/num】
    // 0x10B 【任務抵達】
    // 0x10C
    // 0x10D
    // 0x10E
    // 0x10F
    // 0x110

    // 開啟墜飾欄(175+)
    UPDATE_PENDANT_SLOT((short) 0x111),    
    // 魔王競技場配對成功[完成]
    BOSSPVP_FOUND((short) 0x112),
    // 魔王競技場配對失敗[完成]【Recv => 0x1FD ([Byte])】
    BOSSPVP_FAIL((short) 0x113),
    // 參加魔王競技場配對[完成]
    BOSSPVP_SEARCH((short) 0x114),
    // 0x115
    // 0x116
    // 0x117
    // 0x118
    // 0x119 【00】
    // 0x11A 【伺服器移民】
    // 0x11B 【擴充倉庫欄位】
    
    // 菁英王訊息[完成]
    ELITE_BOSS_NOTICE((short) 0x11C),
    
    // 0x11D 【00 00 00 00 00 00 00 00 00】
    
    // 咒文的痕跡[完成]
    EQUIPMENT_ENCHANT((short) 0x11E),    
    // The Seed 排行
    TOWER_OF_OZ_RANKING((short) 0x11F),
    // The Seed 好友排行
    TOWER_OF_OZ_FRIEND_RANKING((short) 0x120),
    // The Seed 獎勵[完成] [Int](樓層)[Int](時間)[Int](The Seed點數)[Int](獲得經驗值)[Int][Int]
    TOWER_OF_OZ_REWARD((short) 0x121),
    // 0x122 [Int][Int][Byte]
    // 0x123
    // 0x124
    // 0x125
    // 0x126
    // 0x127

    // 離開遊戲[完成]
    EXIT_GAME((short) 0x128),
    
    // 0x129
    // 0x12A
    // 0x12B
    // 0x12C 【臉部情緒?】【Unlock request Failed】
    // 0x12D 【Recv => 0x23D ([Byte][Int][String][Byte])】
    // 0x12E 【Item/Cash/0501.img/%08d/effect】
    // 0x12F
    // 0x130
    // 0x131
    // 0x132
    // 0x133
    // 0x134 【彈跳視窗】
    // 申請變更角色名稱[完成]
    NAME_CHANGE((short) 0x135),
    // 雪橇活動[完成]【UI/Sboating.img/Basic/backgrnd】【Recv => 0x243 ([Byte])】
    SELECT_SLEIGH((short) 0x136),
    // 潘姆音樂[完成]
    PAM_SONG((short) 0x137),
    // 餽贈認證[完成]
    MAPLE_FEED_AUTHEN((short) 0x138),
    // 速配指數[完成]
    QUICK_PAIR_RESULT((short) 0x139),
    // 0x13A
    // 0x13B
    // 0x13C
    // 贈送小鋼珠[完成]
    GIFTS_BALL((short) 0x13D),
    // 九龍珠
    DRAGON_BALL((short) 0x13E),
    // 開啟寶箱[完成]
    TREASURE_BOX((short) 0x13F), //[Int] [0:金、1:銀、5:神秘開罐器、6:幻想開罐器]
    // 0x140
    // 0x141 【釣魚系統】
    // 0x142
    // 0x143 【周圍沒有攻擊的怪物。】、【無法連續使用.】
    
    // 管理員警告[完成]
    GM_POLICE((short) 0x144),
    // 新年賀卡[完成]
    NEW_YEAR_CARD((short) 0x145),
    // 隨機變身藥水[完成]
    RANDOM_MORPH((short) 0x146),    
    // 個性文字[完成](5480000)
    DISPOSITION_TEXT((short) 0x147),   
    // 經驗值椅子[完成]
    CHAIR_EXP_MSG((short) 0x148),
    
    // 0x149
    // 0x14A
    
    // 變更頻道 + 訊息[完成]
    AUTO_CC_MSG((short) 0x14B),
    
    // 0x14C
    // 0x14D
    // 0x14E
    // 0x14F [Int][Int]
    // 0x150
    // 0x151
    // 0x152
    
    // 獲得獎勵[完成]
    REWARD((short) 0x153),
    
    // 0x154
    // 0x155

    // 閃炫方塊回覆
    SHIMMER_CUBE_RESPONSE((short) 0x156),
    
    // 0x157 【任務抵達】
    // 0x158
    // 0x159 【購物商城 => [B0 1A 25 00 00 00 00 00 00 80 59 DA 6B 2E CE 01 80 29 A5 02 EC 33 CE 01 18 00 00 00 98 A3 98 00 99 A3 98 00 9A A3 98 00 9B A3 98 00 24 52 A6 00 25 52 A6 00 76 6F 40 01 77 6F 40 01 78 6F 40 01 79 6F 40 01 20 4A CB 01 22 4A CB 01 2E 4A CB 01 2F 4A CB 01 30 4A CB 01 4E 4A CB 01 4F 4A CB 01 50 4A CB 01 55 4A CB 01 6C 4A CB 01 6D 4A CB 01 6E 4A CB 01 6F 4A CB 01 70 4A CB 01]
    // 0x15A 【[BlackListLoadDone] [BlackSize:%d] [sTargetIGNs:%s]】
    // 0x15B 【神奇剪刀】
    // 0x15C
    // 0x15D 【組隊任務?】
    // 0x15E 
    // 0x15F 【輸入觀戰板內容】【Recv => 0x95】
    // 0x160 【UI/UIMiniGame.img/starPlanetResult/backgrnd】
    // 0x161 【新星世界試穿衣服】
    // 0x162 【等待列表】
    // 0x163
    // 0x164
    // 0x165
    // 0x166
    
    // 咒文的痕跡(FOREVER_TIME)
    FEVER_TIME((short) 0x7FFE), 
    
    // 技能組合[完成]
    SKILL_MACRO((short) 0x167),
    
    //================================
    // CStage::OnPacket 開始
    //================================ 
    
    // 地圖傳送[完成]
    WARP_TO_MAP((short) 0x168),
    // 拍賣系統[完成]
    MTS_OPEN((short) 0x169),
    // 購物商城[完成]
    CS_OPEN((short) 0x16A),
    // 購物商城信息[完成]
    CS_INFO((short) 0x16B),
    CASH_SHOP((short) 0x7FFE),
    
    //================================
    // CMapLoadable::OnPacket 開始
    //================================ 
    
    // 移除BG層[完成]
    REMOVE_BG_LAYER((short) 0x16C),
    // 變更背景[完成]
    CHANGE_BACKGROUND((short) 0x16D),
    // 設置物件狀態
    SET_MAP_OBJECT_VISIBLE((short) 0x16E),
    
    // 0x16F
    
    // 重置畫面[完成]
    RESET_SCREEN((short) 0x170),
    
    //================================
    // CField::OnPacket 開始
    //================================ 
    
    // 地圖阻擋[完成]
    MAP_BLOCKED((short) 0x171),
    // 伺服器阻擋[完成]
    SERVER_BLOCKED((short) 0x172),
    // 隊伍阻擋[完成]
    PARTY_BLOCKED((short) 0x173),
    // 裝備效果[完成]
    SHOW_EQUIP_EFFECT((short) 0x174),
    // 组队家族聊天[别人说话可抓到]
    MULTICHAT((short) 0x175),
    // 世界聊天模式[完成]
    WORLD_MULTICHAT((short) 0x176),
    // 悄悄话
    WHISPER((short) 0x177),
    // 夫妻聊天
    SPOUSE_CHAT((short) 0x178),
    // Boss血條[完成]
    BOSS_ENV((short) 0x179),
    // 地圖效果[完成]
    MAP_EFFECT((short) 0x17A),
    // 祝賀音樂(5100000)[完成]
    CASH_SONG((short) 0x17B),
    // GM效果[完成]
    GM_EFFECT((short) 0x17C),
    // GM日誌[完成]
    GM_LOG((short) 0x17D),    
    // 選邊站[完成]
    OX_QUIZ((short) 0x17E),
    // GM活動說明[完成]
    GMEVENT_INSTRUCTIONS((short) 0x17F),
    // 計時器[完成]
    CLOCK((short) 0x180),
    // 船隻移動[完成]
    BOAT_MOVE((short) 0x181),
    // 船隻狀態[完成]
    BOAT_STATE((short) 0x182),
    
    // 0x183
    // 0x184
    // 0x185
    
    // 停止計時[完成]
    STOP_CLOCK((short) 0x186),
    // 納希競技大會分數[完成]
    ARIANT_SCOREBOARD((short) 0x187),
    
    // 0x188
    
    // 金字塔更新[完成]
    PYRAMID_UPDATE((short) 0x189),
    // 金字塔分數[完成]
    PYRAMID_RESULT((short) 0x18A),
    // 快速按鍵[完成]
    QUICK_SLOT((short) 0x18B),
    // 移動平臺[完成]
    MOVE_PLATFORM((short) 0x18C),
    
    // 0x18D 【接收 => 0x2B7】
    
    // 金字塔擊殺數量[完成]
    PYRAMID_KILL_COUNT((short) 0x18E),
    
    // 0x18F [Int][Int][Int][Int][String]
    // 0x190 [Int][Int][Byte]
    // 0x191 [Int][Int]
    
    // sub_697DDF {
    // 0x192 [-]
    // }
    
    // PvP信息[完成]
    PVP_INFO((short) 0x193),
    // 角色站立方向狀態[完成]
    DIRECTION_STATUS((short) 0x194),
    // 惡魔之力[完成]
    GAIN_FORCE((short) 0x195),
    // 組隊任務達成率[完成]
    ACHIEVEMENT_RATIO((short) 0x196),
    // 快速移動[完成]
    QUICK_MOVE((short) 0x197),
    
    // 0x198
    // 0x199
    // 0x19A 
    // 0x19B
    // 0x19C // 副本BOSS技能特效
    // 0x19D
    // 0x19E // 副本BOSS技能特效
    // 0x19F
    // 0x1A0
    // 0x1A1
    // 0x1A2
    // 0x1A3 
    // 0x1A4 // 帳號保護
    // 0x1A5
    // 0x1A6
    // 0x1A7
    // 0x1A8
    // 0x1A9 // 完成造型王預賽參加申請
    // 0x1AA // 菁英怪物
    // 0x1AB
    // 0x1AC
    // 0x1AD
    // 0x1AE
    // 0x1AF
    // 0x1B0
    // 0x1B1
    // 0x1B2
    
    //================================
    // CUserPool::OnPacket 開始
    //================================ 

    // 召喚玩家[完成]
    SPAWN_PLAYER((short) 0x1B3),
    // 移除玩家[完成]
    REMOVE_PLAYER_FROM_MAP((short) 0x1B4),//0x198+0x1C 176ok
    
    //================================
    // CUserPool::OnUserCommonPacket 開始
    //================================ 
    
    // 普通聊天[完成]
    CHATTEXT((short) 0x1B5),//0x199+1C 176ok
    // 黑板[完成]
    CHALKBOARD((short) 0x1B6),
    // 更新玩家[完成]
    UPDATE_CHAR_BOX((short) 0x1B7),
    // 消費效果[未知]
    SHOW_CONSUME_EFFECT((short) 0x1B8),
    // 使用卷軸效果[完成]
    SHOW_SCROLL_EFFECT((short) 0x1B9),
    
    // 0x1BA(null)
    
    // 咒文的痕跡[完成]
    SHOW_ENCHANTER_EFFECT((short) 0x1BB), 
    // 使用魂之珠[完成]
    SHOW_SOULSCROLL_EFFECT((short) 0x1BC), 
    // 放大鏡效果[完成]
    SHOW_MAGNIFYING_EFFECT((short) 0x1BD),
    // 擴充潛能欄位
    SHOW_POTENTIAL_EXPANSION((short) 0x1BE),//175ok
    // 潛能重置效果
    SHOW_POTENTIAL_RESET((short) 0x1BF),
    // 重新設置潛能效果
    SHOW_BONUS_POTENTIAL_RESET((short) 0x1C0),
    
    // 0x1C1 使用幸運卷?
    
    // 顯示煙花效果
    SHOW_FIREWORKS_EFFECT((short) 0x1C2),
    
    // 0x1C3
    // 0x1C4
    // 0x1C5
    
    // 顯示星岩效果
    SHOW_NEBULITE_EFFECT((short) 0x1C6),
    // 顯示合成效果
    SHOW_FUSION_EFFECT((short) 0x1C7),
    // PvP攻擊
    PVP_ATTACK((short) 0x1C8),
    // PvP煙霧[完成] find:[ invenom ]
    PVP_MIST((short) 0x1C9),
    
    // 0x1CA
    
    //PvP冷卻時間
    PVP_COOL((short) 0x1CB),
    //磁場技能
    TESLA_TRIANGLE((short) 0x1CC),
    
    //0x1CD
    
    //跟随状态
    FOLLOW_EFFECT((short) 0x1CE),
    //顯示組隊任務獎勵[完成]
    SHOW_PQ_REWARD((short) 0x1CF),
    //工藝效果
    CRAFT_EFFECT((short) 0x1D0),
    //工藝完成
    CRAFT_COMPLETE((short) 0x1D1),
    //採集結束特效
    HARVESTED_EFFECT((short) 0x1D2),
    //採集結束
    HARVESTED((short) 0x1D3),
    
    // 0x1D4
    
    //玩家傷害
    PLAYER_DAMAGED((short) 0x1D5),
    //奈特的金字塔
    NETT_PYRAMID((short) 0x1D6),
    //設定特效
    SET_PHASE((short) 0x1D7),
    
    // 0x1D8
    // 0x1D9
    // 0x1DA
    // 0x1DB
    
    //潘姆音樂
    PAMS_SONG((short) 0x1DC),
    //取消椅子
    CANCEL_CHAIR((short) 0x1DD),
    
    // 0x1DE
    // 0x1DF
    
    //攻擊Skin(176.Done)
    SHOW_DAMAGE_SKIN((short) 0x1E0),
    
    // 0x1E1 (Done)
    // 0x1E2 (Done)
    // 0x1E3
    // 0x1E4
    // 0x1E5
    // 0x1E6    

    //================================
    // CUserPool::OnUserPetPacket 開始
    //================================ 
    
    //召喚寵物[完成]
    SPAWN_PET((short) 0x1E7),
    //寵物移動[完成]
    MOVE_PET((short) 0x1E8),
    //寵物說話[完成]
    PET_CHAT((short) 0x1E9),
    //變更寵物名稱
    PET_NAMECHANGE((short) 0x1EA),
    
    // 0x1EB
    
    //寵物例外清單[完成]
    PET_EXCEPTION_LIST((short) 0x1EC),
    //寵物顏色[完成]
    PET_COLOR((short) 0x1ED),
    //寵物大小[完成]
    PET_SIZE((short) 0x1EE),
    
    // 0x1EF
    
    //顯示寵物[完成]
    SHOW_PET((short) 0x1F0),
    //寵物指令[完成]
    PET_COMMAND((short) 0x1F1),
    
    //================================
    // CUserPool::OnUserDragonPacket 開始
    //================================ 
    
    //召喚龍神[完成] 
    DRAGON_SPAWN((short) 0x1F2),
    //龍神移動[完成]
    DRAGON_MOVE((short) 0x1F3),
    //移除龍神[完成]
    DRAGON_REMOVE((short) 0x1F4),
    
    //================================
    // CUserPool::OnUserAndroidPacket 開始
    //================================ 
    
    //召喚機器人[完成]
    ANDROID_SPAWN((short) 0x1F5),
    //機器人移動[完成]
    ANDROID_MOVE((short) 0x1F6),
    //機器人情緒[完成]
    ANDROID_EMOTION((short) 0x1F7),
    //更新機器人外觀[完成]
    ANDROID_UPDATE((short) 0x1F8),
    //移除機器人[完成]
    ANDROID_DEACTIVATED((short) 0x1F9),
    
    //================================
    // CUserPool::OnUserHakuPacket1 開始
    //================================ 
    
    //變更花弧
    HAKU_CHANGE_1((short) 0x1FA),
    
    // 0x1FB
    
    //花狐使用技能後發的(Done)
    HAKU_USE_BUFF((short) 0x1FC),
    //變更花弧
    HAKU_CHANGE_0((short) 0x1FD),
    
    // 0x1FE
    
    //花弧未知
    HAKU_UNK((short) 0x1FF),
    
    //================================
    // CUserPool::OnUserHakuPacket2 开始
    //================================ 
    
    // 0x200
    
    //花狐移動
    HAKU_MOVE((short) 0x201),
    //花狐更新
    HAKU_UPDATE((short) 0x202),
    //變更花狐
    HAKU_CHANGE((short) 0x203),
    
    // 0x204[NULL]
    // 0x205[NULL]
    
    //召喚花狐[完成]
    SPAWN_HAKU((short) 0x206),
    
    // 0x207
    // 0x208
    
    //================================
    // CUserPool::OnUserCommonPacket 開始
    //================================ 
    
    // 玩家移動[完成]
    MOVE_PLAYER((short) 0x209),
    
    // 0x20A
    
    // 近距離攻擊[完成]
    CLOSE_RANGE_ATTACK((short) 0x20B),
    // 遠距離攻擊[完成]
    RANGED_ATTACK((short) 0x20C),
    // 魔法攻擊[完成]
    MAGIC_ATTACK((short) 0x20D),
    // 能量攻擊[完成]
    ENERGY_ATTACK((short) 0x20E),
    //技能效果[完成][用主教的创世之破抓到包]
    SKILL_EFFECT((short) 0x20F),
    //移動攻擊
    MOVE_ATTACK((short) 0x210),
    //取消技能效果[完成]
    CANCEL_SKILL_EFFECT((short) 0x211),
    //玩家受到傷害[完成]
    DAMAGE_PLAYER((short) 0x212),
    //玩家面部表情[完成]
    FACIAL_EXPRESSION((short) 0x213),
    
    // 0x214
    
    //显示物品效果
    SHOW_EFFECT((short) 0x215),
    //显示头上称号
    SHOW_TITLE((short) 0x216),
    //天使破壞者變更
    ANGELIC_CHANGE((short) 0x217),
    
    // 0x218
    // 0x219
    // 0x21A
    
    //顯示椅子效果[完成]
    SHOW_CHAIR((short) 0x21B),
    //更新玩家外觀[完成]
    UPDATE_CHAR_LOOK((short) 0x21C),
    //玩家外觀效果[完成]
    SHOW_FOREIGN_EFFECT((short) 0x21D),//0x1FB+4 175ok
    //獲得異常狀態[完成]
    GIVE_FOREIGN_BUFF((short) 0x21E),
    //取消異常狀態
    CANCEL_FOREIGN_BUFF((short) 0x21F),
    //更新隊員血量
    UPDATE_PARTYMEMBER_HP((short) 0x220),
    //讀取公會名稱[完成]
    LOAD_GUILD_NAME((short) 0x221),
    //讀取公會標誌[完成]
    LOAD_GUILD_ICON((short) 0x222),
    //讀取隊伍(Done)
    LOAD_TEAM((short) 0x223),
    //採集
    SHOW_HARVEST((short) 0x224),
    //PvP血量
    PVP_HP((short) 0x225),
    
    // 0x226
    // 0x227
    // 0x228
    // 0x229
    // 0x22A
    // 0x22B
    // 0x22C
    // 0x22D
    // 0x22E
    // 0x22F
    
    //神之子狀態
    ZERO_MUITTAG((short) 0x230),
    
    // 0x231
    // 0x232
    // 0x233
    // 0x234[NULL]
    // 0x235
    // 0x236
    // 0x237
    // 0x238
    
    //================================
    // CUserPool::OnUserLocalPacket 開始
    //================================ 
    
    // 動畫表情[完成]
    DIRECTION_FACIAL_EXPRESSION((short) 0x239),
    // 畫面移動
    MOVE_SCREEN((short) 0x23A),
    // 顯示物品效果[完成]
    SHOW_SPECIAL_EFFECT((short) 0x23B),
    // 武陵道場傳送
    CURRENT_MAP_WARP((short) 0x23C),
    
    // 0x23D
    
    // 使用福包成功(5200000)[完成]
    MESOBAG_SUCCESS((short) 0x23E),
    // 使用福包失敗(5200000)[完成]
    MESOBAG_FAILURE((short) 0x23F),
    // 更新任務信息
    UPDATE_QUEST_INFO((short) 0x240),
    // 血量減少
    HP_DECREASE((short) 0x241),
    
    // 變更寵物技能[完成]
    PET_FLAG_CHANGE((short) 0x242),
    //玩家提示
    PLAYER_HINT((short) 0x243),
    //播放事件音效
    PLAY_EVENT_SOUND((short) 0x244),
    //播放迷你遊戲音效
    PLAY_MINIGAME_SOUND((short) 0x245),
    //生產用技能
    MAKER_SKILL((short) 0x246),
    
    // 0x247 (Null)
    // 0x248
    
    //打开界面
    OPEN_UI((short) 0x249),
    
    // 0x24A
    
    //打开界面选项
    OPEN_UI_OPTION((short) 0x24B),
    //锁玩家按键动作(176.Done)
    INTRO_LOCK((short) 0x24C),
    //剧情锁界面(176.Done)
    INTRO_ENABLE_UI((short) 0x24D),
    //剧情锁界面2(176.Done)
    INTRO_DISABLE_UI((short) 0x24E),
    //新手帮助召唤兽
    SUMMON_HINT((short) 0x24F),
    //新手帮助召唤兽信息
    SUMMON_HINT_MSG((short) 0x250),
    
    // 0x251
    // 0x252
    
    //战神连击
    ARAN_COMBO((short) 0x253),
    //战神斗气重生
    ARAN_COMBO_RECHARGE((short) 0x254),
    
    // 0x255
    // 0x256
    
    //公告提示
    GAME_MSG((short) 0x257),
    //遊戲訊息 
    GAME_MESSAGE((short) 0x258),//0x236+3 175ok
    
    // 0x259 [String][Int]
    
    //
    BUFF_ZONE_EFFECT((short) 0x25A),
    //
    DAMAGE_METER((short) 0x25B),
    //炸彈攻擊
    TIME_BOMB_ATTACK((short) 0x25C),
    //跟随移动
    FOLLOW_MOVE((short) 0x25D),
    //跟随信息
    FOLLOW_MSG((short) 0x25E),
    
    //　0x25F
    
    //建立終極冒險家
    CREATE_ULTIMATE((short) 0x260),
    //採集訊息
    HARVEST_MESSAGE((short) 0x261),
    //符文介面
    RUNE_ACTION((short) 0x262),
    //礦物背包
    OPEN_BAG((short) 0x263),
    //龍之氣息
    DRAGON_BLINK((short) 0x264),
    //PvP冰騎士
    PVP_ICEGAGE((short) 0x265),
    //位置信息(176.Done)
    DIRECTION_INFO((short) 0x266),//0x247+1F 176ok
    //重新獲得勳章
    REISSUE_MEDAL((short) 0x267),
    
    // 0x268
    // 0x269 [Int]
    
    //动画播放[完成]
    PLAY_MOVIE((short) 0x26A),//0x24B+1F 176ok
    //蛋糕 vs 派餅 活動
    CAKE_VS_PIE_MSG((short) 0x26B),
    //幻影俠盜卡片[完成]
    PHANTOM_CARD((short) 0x26C),
    
    // 0x26D [Int]
    // 0x26E [Int]
    
    //夜光連擊
    LUMINOUS_COMBO((short) 0x26F), // 175ok (0x250)
    
    // sub_6DB241 {
    // 0x276
    // 0x277
    // }
    
    //時間膠囊(176.Done)
    TIME_CAPSULE((short) 0x281),
    
    // 0x282
    
    //神之子衝擊波(Done)
    ZERO_SHOCKWAVE((short) 0x283),
    //設定槍的名稱(Done)
    SET_GUN_NAME((short) 0x284),
    //設定槍彈(Done)
    SET_GUN_AMMO((short) 0x285),
    //建立槍(Done)
    CREATE_GUN((short) 0x286),
    //清除槍(Done)
    CLEAR_GUN((short) 0x287),
    
    // 0x288
    // 0x289
    // 0x28A
    // 0x28B
    // 0x28C
    // 0x28D
    
    //戰鬥回復(Done) (101110205)
    ZERO_BATTLE_HEAL((short) 0x28E),
    
    // 0x28F
    // 0x290
    // 0x291
    // 0x292
    // 0x293
    // 0x294
    // 0x295
    // 0x296
    // 0x297
    // 0x298
        
    //神之子參數(Done)
    ZERO_OPTION((short) 0x299),
    //翻轉硬幣(Done)
    FLIP_THE_COIN((short) 0x29A),
    
    // 0x29B
    // 0x29C
    // 0x29D
    // 0x29E
    
    //幽靈水彩特效(Done) (skill == 80001408)
    GHOST_WATERCOLOR_EFFECT((short) 0x29F),
    
    // 0x2A0
    
    //符文特效(Done) (80001429)
    RUNE_EFFECT((short) 0x2A1),
    
    // 0x2A2
    // 0x2A3
    // 0x2A4
    // 0x2A5
    // 0x2A6
    // 0x2A7
    // 0x2A8
    // 0x2A9
    // 0x2AA
    // 0x2AB
    // 0x2AC
    // 0x2AD
    
    // Setp GiftID
    SETP_GIFT_ID((short) 0x2AE),
    
    // 0x2AF
    
    // Step Coin
    SETP_COIN((short) 0x2B0),    
    //凱薩快速鍵(176.Done)
    KAISER_QUICK_KEY((short) 0x2B1),
    
    // +33
    
    //閃耀方塊反饋(176.Done) (CField頂端內容有/12的用xRef回找)
    FLASH_CUBE_RESPONSE((short) 0x2D1), //176ok (0x2B1)
    
    // +15

    //技能冷却[完成]
    COOLDOWN((short) 0x2E0),//0x2B3+5 176ok (0x2B8)
    
    // 0x2E1

    //================================
    // CMobPool::OnSummonPacket 開始
    //================================ 
    
    //招喚招喚獸[完成]
    SPAWN_SUMMON((short) 0x02E2),
    //移除招喚獸[完成]
    REMOVE_SUMMON((short) 0x2E3),
    //招喚獸移動[完成]
    MOVE_SUMMON((short) 0x2E4),
    //招喚獸攻击[完成]
    SUMMON_ATTACK((short) 0x2E5),
    //PvP招喚獸
    PVP_SUMMON((short) 0x2E6),
    //招喚獸技能
    SUMMON_SKILL_2((short) 0x2E7),
    //招喚獸技能
    SUMMON_SKILL((short) 0x2E8),
    //招喚獸延遲
    SUMMON_DELAY((short) 0x2E9),
    //招喚獸受傷
    DAMAGE_SUMMON((short) 0x2EA),
    
    //0x2EB
    //0x2EC
    //0x2ED
    
    //================================
    // CMobPool::OnMobPacket 開始
    //================================ 
    
    // 怪物召喚[完成]
    SPAWN_MONSTER((short) 0x2EE),
    // 殺除怪物[完成]
    KILL_MONSTER((short) 0x2EF),
    // 控制召喚怪物[完成]
    SPAWN_MONSTER_CONTROL((short) 0x2F0),
    
    // 0x2F1 [Int(MOB_ID)][Short][Int][Byte]
    
    // 怪物移動[完成]
    MOVE_MONSTER((short) 0x2F2),
    // 怪物移動回覆[完成]
    MOVE_MONSTER_RESPONSE((short) 0x2F3),
    
    // 0x2F4 (NULL)
    
    //添加怪物状态[完成]
    APPLY_MONSTER_STATUS((short) 0x2F5),
    //取消怪物状态[完成]
    CANCEL_MONSTER_STATUS((short) 0x2F6),    
    //怪物暫停重置[完成]
    MONSTER_SUSPEND_RESET((short) 0x2F7),
    //影響怪物[完成]
    MONSTER_AFFECTED((short) 0x2F8),    
    //怪物受到伤害
    DAMAGE_MONSTER((short) 0x2F9),
    //怪物技能特效[完成]
    SKILL_EFFECT_MOB((short) 0x2FA),
    
    // 0x2FB (NULL)
    
    //怪物CRC[完成] 接收=> 0x156
    MONSTER_CRC_CHANGE((short) 0x2FC),
    //顯示怪物HP[完成]
    SHOW_MONSTER_HP((short) 0x2FD),
    //捕抓怪物[完成]
    CATCH_MONSTER((short) 0x2FE),
    //怪物物品特效[完成]
    ITEM_EFFECT_MOB((short) 0x2FF),
    
    // 0x300
    
    //怪物說話[完成]
    TALK_MONSTER((short) 0x301),    
    //移除怪物說話
    REMOVE_TALK_MONSTER((short) 0x302),
    //怪物技能延遲[完成]
    MONSTER_SKILL_DELAY((short) 0x303),
    //怪物護送全部路徑[完成]
    MONSTER_ESCORT_FULL_PATH((short) 0x304),
    //怪物護送暫停/停止允許[完成]
    MONSTER_ESCORT_STOP_END_PERMISSION((short) 0x305),
    //怪物護送暫停說話[完成]
    MONSTER_ESCORT_STOP_SAY((short) 0x306),
    //怪物護送返回前[完成]
    MONSTER_ESCORT_RETURN_BEFORE((short) 0x307),
    //怪物下個攻擊[完成]
    MONSTER_NEXT_ATTACK((short) 0x308),
    
    // 0x309
    // 0x30A
    // 0x30B
    // 0x30D
    // 0x30E
    // 0x30F
    // 0x310
    // 0x311
    // 0x312
    // 0x313
    // 0x314
    // 0x315
    // 0x316
    // 0x317
    // 0x318
    // 0x319
    // 0x31A
    // 0x31B
    // 0x31C
    // 0x31D
    
    //怪物攻擊怪物[完成]
    MOB_TO_MOB_DAMAGE((short) 0x31E),
    
    // 0x31F (NULL)    
    
    //================================
    // CMobPool::OnAzwanMobPacket 開始
    //================================ 
    
    // 阿斯旺怪物攻擊怪物[完成]
    AZWAN_MOB_TO_MOB_DAMAGE((short) 0x320),
    // 阿斯旺怪物召喚[完成]
    AZWAN_SPAWN_MONSTER((short) 0x321),
    // 阿斯旺怪物死亡[完成]
    AZWAN_KILL_MONSTER((short) 0x322),
    // 阿斯旺控制召喚怪物[完成]
    AZWAN_SPAWN_MONSTER_CONTROL((short) 0x323),
    
    //================================
    // CNpcPool::OnPacket 開始
    //================================ 
    
    // 召喚Npc[完成]
    SPAWN_NPC((short) 0x324),
    // 移除Npc[完成]
    REMOVE_NPC((short) 0x325),
    
    // 0x326
    
    // 控制召喚Npc[完成]
    SPAWN_NPC_REQUEST_CONTROLLER((short) 0x327),
    // Npc動作[完成]
    NPC_ACTION((short) 0x328),
    
    // 0x329
    // 0x32A
    // 0x32B
    
    // 更新NPC狀態信息
    NPC_UPDATE_LIMITED_INFO((short) 0x32C),
    
    // 0x32D
    // 0x32E
    // 0x32F
    // 0x330
    // 0x331
    // 0x332
    // 0x333
    // 0x334
    // 0x335
    // 0x336
    // 0x337
    
    // Npc特殊事件[完成]
    NPC_SET_SPECIAL_ACTION((short) 0x338),
    // 設置Npc腳本[完成]
    NPC_SCRIPTABLE((short) 0x339),
    
    // 0x33A
    
    //================================
    // CObjectPool::OnHiredMerchantPacket 開始
    //================================ 
    
    // 召喚精靈商人
    SPAWN_HIRED_MERCHANT((short) 0x33B),
    // 移除精靈商人
    DESTROY_HIRED_MERCHANT((short) 0x33C),
    
    // 0x33D
    
    // 精靈商人更新
    UPDATE_HIRED_MERCHANT((short) 0x33E),
    
    //================================
    // CObjectPool::OnDropPacket 開始
    //================================ 
    
    // 物品掉落[完成]
    DROP_ITEM_FROM_MAPOBJECT((short) 0x33F),
    
    // 0x340 (null)
    
    // 物品消失[完成]
    REMOVE_ITEM_FROM_MAP((short) 0x341),
    
    //================================
    // CObjectPool::OnKitePacket 开始
    //================================ 
    
    // 召喚風箏錯誤[完成]
    SPAWN_KITE_ERROR((short) 0x342),
    // 召喚風箏[完成]
    SPAWN_KITE((short) 0x343),
    // 移除風箏[完成]
    DESTROY_KITE((short) 0x344),
    
    //================================
    // CObjectPool::OnMistPacket 开始
    //================================ 
    
    // 召喚煙霧[完成]
    SPAWN_MIST((short) 0x345),
    // 煙霧未知[完成]
    MIST_UNK((short) 0x346),
    // 移除煙霧[完成]
    REMOVE_MIST((short) 0x347),
    
    //================================
    // CObjectPool::OnDoorPacket 开始
    //================================ 
    
    // 時空門[完成]
    SPAWN_DOOR((short) 0x348),
    // 移除時空門[完成]
    REMOVE_DOOR((short) 0x349),
    
    //================================
    // CObjectPool::OnMechDoorPacket 开始
    //================================ 
    
    // 召喚開放通道[完成]
    MECH_DOOR_SPAWN((short) 0x34A),
    // 移除開放通道[完成]
    MECH_DOOR_REMOVE((short) 0x34B),
    
    //================================
    // CObjectPool::OnReactorPacket 开始
    //================================ 
    
    // 攻擊箱子[完成]
    REACTOR_HIT((short) 0x34C),
    // 箱子移動[完成]
    REACTOR_MOVE((short) 0x34D),
    // 召喚箱子[完成]
    REACTOR_SPAWN((short) 0x34E),
    // 箱子未知[完成]
    REACTOR_UNK((short) 0x34F),
    // 重置箱子[完成]
    REACTOR_DESTROY((short) 0x350),
    
    //================================
    // CObjectPool::OnExtractorPacket 开始
    //================================ 
    
    // 召喚分解機[完成]
    SPAWN_EXTRACTOR((short) 0x351),
    // 移除分解機[完成]
    REMOVE_EXTRACTOR((short) 0x352),
    
    //================================
    // CEventsPool::OnPacket 开始
    //================================ 
    
    //滾動雪球
    ROLL_SNOWBALL((short) 0x353),
    //攻擊雪球
    HIT_SNOWBALL((short) 0x354),
    //雪球訊息
    SNOWBALL_MESSAGE((short) 0x355),
    //向左擊飛
    LEFT_KNOCK_BACK((short) 0x356),
    //攻擊椰子
    HIT_COCONUT((short) 0x357),
    //椰子活動分數
    COCONUT_SCORE((short) 0x358),
    // CField_GuildBoss::OnHealerMove[完成]
    MOVE_HEALER((short) 0x359),
    // CField_GuildBoss::OnPulleyStateChange[完成]
    PULLEY_STATE((short) 0x35A),
    // 怪物擂台賽開始[完成]
    MONSTER_CARNIVAL_START((short) 0x35B),
    // 怪物擂台賽獲得CP[完成]
    MONSTER_CARNIVAL_OBTAINED_CP((short) 0x35C),
    // 怪物擂台賽狀態[完成]
    MONSTER_CARNIVAL_STATS((short) 0x35D),
    
    // 0x35E [Int] * 4
    
    // 怪物擂台賽召喚[完成]
    MONSTER_CARNIVAL_SUMMON((short) 0x35F),
    // 怪物擂台賽訊息[完成]
    MONSTER_CARNIVAL_MESSAGE((short) 0x360),
    // 怪物擂台賽死亡[完成]
    MONSTER_CARNIVAL_DIED((short) 0x361),
    // 怪物擂台賽離開[完成]
    MONSTER_CARNIVAL_LEAVE((short) 0x362),
    // 怪物擂台賽分數[完成]
    MONSTER_CARNIVAL_RESULT((short) 0x363),
    // 怪物擂台賽排名[完成]
    MONSTER_CARNIVAL_RANKING((short) 0x364),
    // 更新納希競技大會分數[完成]
    ARIANT_SCORE_UPDATE((short) 0x365),
    // 0x366
    // 開心牧場資訊
    SHEEP_RANCH_INFO((short) 0x367),
    // 開心牧場衣服
    SHEEP_RANCH_CLOTHES((short) 0x368),
    // 魔女之塔
    WITCH_TOWER((short) 0x369),
    // 遠征隊挑戰[完成]
    EXPEDITION_CHALLENGE((short) 0x36A),
    // 炎魔祭壇[完成]
    ZAKUM_SHRINE((short) 0x36B),
    // PvP類型[完成]
    PVP_TYPE((short) 0x36C),
    // PvP轉移[完成]
    PVP_TRANSFORM((short) 0x36D),
    // PvP[完成]
    PVP_DETAILS((short) 0x36E),
    // PvP開始[完成]
    PVP_ENABLED((short) 0x36F),
    // PvP分數[完成]
    PVP_SCORE((short) 0x370),
    // PvP結果[完成]
    PVP_RESULT((short) 0x371),
    // PvP隊伍[完成]
    PVP_TEAM((short) 0x372),
    // PvP計分板[完成]
    PVP_SCOREBOARD((short) 0x373),
    
    // 0x374 [Int][Byte]
    
    // PvP點數[完成]
    PVP_POINTS((short) 0x375),
    // PvP擊殺數[完成]
    PVP_KILLED((short) 0x376),
    // PvP模式[完成]
    PVP_MODE((short) 0x377),
    // PvP冰騎士[完成]
    PVP_ICEKNIGHT((short) 0x378),
    
    // sub_68236D {
    // 0x357
    // 0x358
    // }
    
    // sub_6923DD {
    // 0x359 [Short]
    // 0x35A [Byte]
    // }
    
    // sub_688DEC {
    // 0x379
    // 0x37A
    // 0x37B
    // 0x37D
    // }
    
    // sub_6BAE8E {
    // 0x37E
    // 0x381
    // }
    
    // sub_6C093D {
    // 0x37F
    // 0x380
    // 0x382
    // }
    
    // sub_6B8599 {
    // 0x383
    // 0x384
    // 0x385
    // 0x386
    // 0x387
    // 0x388
    // 0x389
    // 0x38A
    // 0x38B
    // }
    
    // sub_6A7E5B {
    // 0x38C
    // 0x38D
    // }
    
    // sub_6C8B36 { 【遊戲(未確認)】
    // 0x38F
    // 0x390
    // 0x391
    // 0x392
    // 0x393
    // 0x394
    // 0x395
    // 0x396
    // 0x397 【楓葉戰士】
    // 0x398
    // 0x399
    // 0x39A
    // 0x39E
    // }
    
    // sub_6BDC3E {
    // 0x39B
    // 0x39C
    // 0x39D
    // }
    
    // sub_63E919 {
    // 0x39F【排行介面】
    // }
    
    // sub_6AF283 {
    // 0x3A2
    // 0x3A3
    //}
    
    // sub_68DCA9 {
    // 0x3A5
    // 0x3A6
    // 0x3A7
    // 0x3A8
    // }
    
    // sub_679B8A { 【楓葉戰士(未確認)】
    // 0x367 [Byte][Byte]
    // 0x368 [Int][Byte][Int]
    // 0x3A9 【楓葉戰士】【Effect/BasicEff.img/rhythmGame/fever%d】 [Int][Int]
    // 0x3AA
    // 0x3AB
    // 0x3AC
    // 0x3AD
    // }
    
    // sub_697DDF {
    // 0x192
    // 0x3B3
    // 0x3B4
    // 0x3B5
    // 0x3B6
    // 0x3B9
    // }
    
    // sub_67E742 { 【BossPvP】
    // 0x3AE [Int]
    // 0x3AF [Int][Int][Int]
    // 0x3B0 [Int][Int][Int]
    // 0x3B1 【UI/UIWindow4.img/bossArena/selectUi/boss/%d】
    // 0x3B2 【UI/UIWindow4.img/bossArena/selectUi/ready】
    // 0x3B7
    // 0x3B8 [Int]
    // 0x3BA
    // 0x3BB 【座椅效果?】
    // 0x3BC
    // 0x3BD
    // }
    
    // sub_6D6C10 {
    // 0x3BE
    // 0x3BF
    // 0x3C0
    // 0x3C1
    // 0x3C2
    // 0x3C3
    // 0x3C4
    // }
    
    // 召喚符文[完成]
    SPAWN_RUNE((short) 0x3C6),
    // 移除符文[完成]
    REMOVE_RUNE((short) 0x3C7),
    // 重新召喚符文[完成]
    RESPAWN_RUNE((short) 0x3C8),
    
    // sub_63AB26 {
    // 0x3CB 【UI/StarCityUI.img/Screen/WorldEvent/%d】
    // }
    
    // sub_69A320 { 【迷你遊戲】
    // 0x3CE
    // 0x3CF
    // 0x3D0 【Sound/MiniGame.img/】
    // 0x3D1
    // 0x3D2
    // 0x3D3
    // 0x3D4
    // 0x3D5
    // }
    
    // sub_69D380 {
    // 0x3E2
    // 0x3E3
    // 0x3E4
    // 0x3E5
    // 0x3E6
    // 0x3E7
    // 0x3E8
    // }
    
    // sub_6CBFA7 {
    // 0x3E9
    // }
    
    // 混沌炎魔祭壇[完成]
    CHAOS_ZAKUM_SHRINE((short) 0x3EA),
    
    // 0x3EB
    
    // 闇黑龍王祭壇[完成]【未確認】
    HORNTAIL_SHRINE((short) 0x3EC),
    
    // sub_67C061 { 【怪物擂台賽】
    // 0x3F0
    // 0x3F1
    // 0x3F2 [-]
    // 0x3F3 [-]
    // 0x3F4
    // 0x3F5
    // 0x3F6
    // 0x3F7
    // 0x3F8
    // 0x3F9
    // 0x3FA
    // }
    
    // sub_69EEC2 {
    // 0x3EB
    // }
    
    // sub_680FAC { 【蛋糕 Vs 派餅 活動】
    // 0x3FD
    // 0x3FE 【%s 陣營的Boss已經被召喚。】
    // 0x3FF 【更新Boss血條】
    // 0x400 【攻擊效果】[Byte(00:Miss、01:Cool)]
    // 0x404
    // 0x406
    // }
    
    // sub_67FEDA {
    // 0x401 [Byte][Int][Byte]
    // }
    
    // sub_67F7EB {
    // 0x402
    // 0x403
    // }
    
    // sub_67F8C5 {
    // 0x405 [Byte]
    // }
    
    // sub_6DAE51 {
    // 0x40A
    // 0x40B
    // 0x40C
    // 0x40D
    // 0x40E
    // 0x40F
    // 0x410
    // }
    
    // sub_6CF7E2 {
    // 0x411
    // 0x412
    // 0x413
    // 0x414
    // 0x415
    // 0x416
    // 0x417
    // }
    
    // sub_6D2059 {
    // 0x43A
    // 0x43B
    // 0x43C 【靈魂陷阱】
    // 0x43D
    // 0x43E
    // 0x43F
    // 0x440
    // 0x441 【姆勒姆勒地城地圖】、【姆勒姆勒的炸彈】
    // 0x442
    // }
    
    // sub_6E6480 {
    // 0x3D6
    // 0x3D7
    // 0x3D8
    // 0x3D9
    // 0x3DA
    // 0x3DB
    // 0x3DC 【UI/UIWindow4.img/typingDefense/Result/gameover】【UI/UIWindow4.img/typingDefense/Result/clear】
    // 0x3DD
    // 0x3DE
    // 0x3DF
    // 0x3E0
    // 0x3E1
    // }
    
    
    // PvP(奪旗模式)
    CAPTURE_FLAGS((short) 0x42C),
    CAPTURE_POSITION((short) 0x42D),
    CAPTURE_RESET((short) 0x42E),
    // 粉紅色炎魔祭壇[完成]
    PINK_ZAKUM_SHRINE((short) 0x42F),
    // Npc交談[完成]
    NPC_TALK((short) 0x430),//0x3D9+0x56 176ok
    // Npc商店[完成]
    OPEN_NPC_SHOP((short) 0x431),
    // 購買Npc商店道具[完成]
    CONFIRM_SHOP_TRANSACTION((short) 0x432),
    // 管理員商店[完成]
    ADMIN_SHOP_RESULT((short) 0x433),
    // 管理員商店-商品[完成]
    ADMIN_SHOP_COMMODITY((short) 0x434),
    
    // sub_68685A {
    // 0x445
    // }
    
    // 倉庫[完成]
    OPEN_STORAGE((short) 0x447),
    // 富蘭德里訊息
    MERCH_ITEM_MSG((short) 0x448),
    // 富蘭德里倉庫
    MERCH_ITEM_STORE((short) 0x449),
    // 猜拳遊戲[完成]
    RPS_GAME((short) 0x44A),
    
    // 0x44B
    
    // 聊天室[完成]
    MESSENGER((short) 0x44D),
    // 玩家互動[完成]
    PLAYER_INTERACTION((short) 0x44E),
    
    // 0x44D
    // 0x44E
    // 0x44F
    // 0x450
    
    // CField_Tournament::OnTournament[完成]
    TOURNAMENT((short) 0x451),
    // CField_Tournament::OnTournamentMatchTable[完成]
    TOURNAMENT_MATCH_TABLE((short) 0x452),
    // CField_Tournament::OnTournamentSetPrize[完成]
    TOURNAMENT_SET_PRIZE((short) 0x453),
    // CField_Tournament::OnTournamentUEW[完成]
    TOURNAMENT_UEW((short) 0x454),
    // CField_Tournament::OnTournamentAvatarInfo[完成]
    TOURNAMENT_CHARACTERS((short) 0x455),
    // CField_Wedding::OnWeddingProgress[完成]
    WEDDING_PROGRESS((short) 0x456),
    // CField_Wedding::OnWeddingCeremonyEnd[完成]
    WEDDING_CEREMONY_END((short) 0x457),
    
    //================================
    // CCashShop::OnPacket 開始
    //================================ 
    // 0x463
    
    // 購物商城更新[完成]
    CS_UPDATE((short) 0x464),
    // 購物商城操作[完成]
    CS_OPERATION((short) 0x465),
    // CCashShop::OnPurchaseExpChanged[完成]
    CS_EXP_PURCHASE((short) 0x466),
    
    // 0x468 【00 00 04 00 00 00 00 00 84 11 06 00 00 00 00 00 FF 00 00】
    
    // 購物商城未知[完成]
    CASH_USE4((short) 0x46B),
    // 購物商城帳號[完成]
    CS_ACCOUNT((short) 0x475),
    // 購物商城未知[完成]
    CASH_USE3((short) 0x476),
    // 購物商城未知[完成]
    CASH_USE((short) 0x477),
    // 購物商城未知[完成]
    CASH_USE2((short) 0x47D),
    
    // 0x47E 【CCashShop::OnMemberShopResult】
    
    // 購物商城更新楓幣
    CS_MESO_UPDATE((short) 0x3F6),
    // 商城搭配
    CS_COLLOCATTON((short) 0x3F9),
    // 0x450 【購物商城合約】
    
    // sub_6E782A {
    // 0x456
    // 0x457
    // }
    
    // sub_6A809E {
    // 0x458
    // 0x459
    // }
    
    // sub_6A8D7F { 【小鋼珠】
    // 0x45C
    // 0x45D
    // 0x45E
    // }
    
    // 宅配操作(完成)
    PACKAGE_OPERATION((short) 0x462),
    
    // 0x487 神獸學院
    // 0x48A 羊群牧場[Boolean] 【true => [String][Long]「[String][Long]」* 3】【false => [Int](分數)[Int](排行)[Int](咒文的痕跡)】

    // 鍵盤設置[完成]
    KEYMAP((short) 0x4A3),
    // 寵物技能(HP)[完成]
    PET_AUTO_HP((short) 0x4A4),
    // 寵物技能(MP)[完成]
    PET_AUTO_MP((short) 0x4A5),
    // 寵物技能(Buff)[完成]
    PET_AUTO_CURE((short) 0x4A6),
    
    //黃金鐵鎚使用完成[完成]
    VICIOUS_HAMMER((short) 0x4AE),
    // 0x4AF
    
    // sub_6DFA9F {
    // 0x451
    // 0x452
    // 0x453
    // 0x454
    // }
    
    ZERO_SCROLL_START((short) 0x4B0),
    ZERO_WEAPON((short) 0x4B2),
    ZERO_SCROLL((short) 0x4B2),
    ZERO_RESULT((short) 0x4B3),
    
    // 0x4B4
    // 0x4B5
    
    ZERO_WEAPONINFO((short) 0x4B6),
    // sub_63A99D {
    // 武器成長[完成]
     ZERO_UPGRADE((short) 0x4B7),
    // }
     
    // sub_6EB9DE {
    // 召喚箭座[完成]
    SPAWN_ARROW_BLASTER((short) 0x4BD),

    // 0x4BE 【dispear】

    // 取消箭座[完成]
    CANCEL_ARROW_BLASTER((short) 0x4BF),

    // 0x4C0
    // 0x4C7
    // }
    
    // 0x4C1

    // sub_6EA954 {
    // 箭座控制[完成]
    ARROW_BLASTER_CONTROL((short) 0x4C2),
    // 0x4C3
    // 0x4C4 【破除封印】
    // 0x4C5
    // }
    
    // sub_50630B {
    // 0x4CC
    // 0x4CD
    // 0x4CE
    // 0x4CF
    // 0x4D0
    // }
    
    // 潛能方塊[完成](CField頂端內容含/12的)
    STRENGTHEN_UI((short) 0x4D2),
    
    // sub_63AC91 {
    // 0x4D3 【階段介面】
    // }
    
    // sub_6921D9 {
    // 0x4D6
    // 0x4D7
    // }
     
    // sub_63AD6C {
    // 0x4D8 [Byte]
    // }


    // 每日免費強化任意門[完成]
    DAY_OF_CHRONOSPHERE((short) 0x4ED),//0x486+0x65 176
    // 強化任意門錯誤[完成]
    ERROR_CHRONOSPHERE((short) 0x4EE),//176ok
    
    // sub_6DF4C6 {
    // 0x4F2
    // 0x4F3
    // 0x4F4
    // 0x4F5
    // 0x4F6
    // }
    
    // General

    AUTH_RESPONSE((short) 0x16),
    // Login

    SEND_LINK((short) 0x01),
    PIN_OPERATION((short) 0x06),
    PIN_ASSIGNED((short) 0x07),
    ALL_CHARLIST((short) 0x08),
    RELOG_RESPONSE((short) 0x17),
    REGISTER_PIC_RESPONSE((short) 0x1A),
    CHANNEL_SELECTED((short) 0x21),
    EXTRA_CHAR_INFO((short) 0x22),//23
    SPECIAL_CREATION((short) 0x23),//24

    // Channel

    FULL_CLIENT_DOWNLOAD((short) 0x35),
    BOOK_INFO((short) 0x999),
    REPORT_RESULT((short) 0x4E),//v145
    TRADE_LIMIT((short) 0x50),//v145
    UPDATE_GENDER((short) 0x51),//50
    BBS_OPERATION((short) 0x52),//51

    CODEX_INFO_RESPONSE((short) 0x5B),//5C

    ECHO_MESSAGE((short) 0x63),//64

    BOOK_STATS((short) 0x81),//7E
    UPDATE_CODEX((short) 0x82),//7F
    CARD_DROPS((short) 0x83),//80
    FAMILIAR_INFO((short) 0x84),//81
    POTION_BONUS((short) 0x7FFE),
    
    MAPLE_TV_MSG((short) 0x8D),
    LUCKY_LUCKY_MONSTORY((short) 0x103),//new v147
    POPUP2((short) 0x9D),
    CANCEL_NAME_CHANGE((short) 0x9E),
    CANCEL_WORLD_TRANSFER((short) 0x9F),
    CLOSE_HIRED_MERCHANT((short) 0xA3),//A0
    CANCEL_NAME_CHANGE_2((short) 0x999),//A9

    GM_STORY_BOARD((short) 0xB7),
    FIND_FRIEND((short) 0xBA),
    VISITOR((short) 0xBB),
    PINKBEAN_CHOCO((short) 0xBC),
    
    EQUIP_STOLEN_SKILL((short) 0xD5),//CE

    INNER_ABILITY_RESET_MSG((short) 0x999),
    CASSANDRAS_COLLECTION((short) 0xEA),//new v145

    SET_OBJECT_STATE((short) 0xEF),//E8
    POPUP((short) 0xF0),//E9
    YOUR_INFORMATION((short) 0x7FFE),

    CANDY_RANKING((short) 0xFF),//F8
    ATTENDANCE((short) 0x10A),//102

    RANDOM_RESPONSE((short) 0x121),
    MAGIC_WHEEL((short) 0x134),//125

    FARM_OPEN((short) 0x138),//129

    MOVE_ENV((short) 0x14A),//13B
    UPDATE_ENV((short) 0x14B),//13C

    CHATTEXT_1((short) 0x17B),//16A

    SPAWN_PET_2((short) 0x192),//16D

    SPAWN_FAMILIAR((short) 0x1A8),//183
    MOVE_FAMILIAR((short) 0x1A9),//184
    TOUCH_FAMILIAR((short) 0x1AA),//185
    ATTACK_FAMILIAR((short) 0x1AB),//186
    RENAME_FAMILIAR((short) 0x1AC),//187
    SPAWN_FAMILIAR_2((short) 0x1AD),//188
    UPDATE_FAMILIAR((short) 0x1AE),//189

    //((short) 0x1B8),//193弹出奖励

    R_MESOBAG_SUCCESS((short) 0x1EE),//1EB
    R_MESOBAG_FAILURE((short) 0x1EF),//1EC
    MAP_FADE((short) 0x201),//1F0
    MAP_FADE_FORCE((short) 0x202),//1F1

    RANDOM_EMOTION((short) 0x216),//205
    RADIO_SCHEDULE((short) 0x999),//206
    OPEN_SKILL_GUIDE((short) 0x218),//207

    AP_SP_EVENT((short) 0x999),//215
    QUEST_GUIDE_NPC((short) 0x999),//214
    REGISTER_FAMILIAR((short) 0x999),//218
    FAMILIAR_MESSAGE((short) 0x999),//219

    SHOW_MAP_NAME((short) 0x999),
    CAKE_VS_PIE((short) 0x228),//225

    MOVE_SCREEN_X((short) 0x199),//199
    MOVE_SCREEN_DOWN((short) 0x19A),//19A
    CAKE_PIE_INSTRUMENTS((short) 0x19B),//19B
    SEALED_BOX((short) 0x218),//212

    //怪物屬性
    MONSTER_PROPERTIES((short) 0x2DB),
    
    //
    CYGNUS_ATTACK((short) 0x2DF),
    //怪物抗擊
    MONSTER_RESIST((short) 0x2E2),

    TELE_MONSTER((short) 0x999),
    SHOW_MAGNET((short) 0x29E),//287
    
    NPC_TOGGLE_VISIBLE((short) 0x2C2),//2AA
    INITIAL_QUIZ((short) 0x2C4),//2AC

    RED_LEAF_HIGH((short) 0x2C8),//2B0

    LOGOUT_GIFT((short) 0x2FB),
    CS_CHARGE_CASH((short) 0x2CA),
    GIFT_RESULT((short) 0x23C),
    CHANGE_NAME_CHECK((short) 0x23D),
    CHANGE_NAME_RESPONSE((short) 0x23E),
    //0x314 int itemid int sn

    CASH_SHOP_UPDATE((short) 0x3A3),//373
    GACHAPON_STAMPS((short) 0x253),
    FREE_CASH_ITEM((short) 0x254),
    CS_SURPRISE((short) 0x255),
    XMAS_SURPRISE((short) 0x256),
    ONE_A_DAY((short) 0x258),
    NX_SPEND_GIFT((short) 0x999),
    RECEIVE_GIFT((short) 0x25A),//new v145
    RANDOM_CHECK((short) 0x274),//25E

    START_TV((short) 0x380),//37A
    REMOVE_TV((short) 0x381),//37B
    ENABLE_TV((short) 0x37C),//37C
    GM_ERROR((short) 0x26D),
    ALIEN_SOCKET_CREATOR((short) 0x341),
    BATTLE_RECORD_DAMAGE_INFO((short) 0x27A),
    CALCULATE_REQUEST_RESULT((short) 0x27B),
    BOOSTER_PACK((short) 0x999),
    BOOSTER_FAMILIAR((short) 0x999),
    BLOCK_PORTAL((short) 0x999),
    NPC_CONFIRM((short) 0x999),
    RSA_KEY((short) 0x999),
    BUFF_BAR((short) 0x999),
    GAME_POLL_REPLY((short) 0x999),
    GAME_POLL_QUESTION((short) 0x999),
    ENGLISH_QUIZ((short) 0x999),
    FISHING_BOARD_UPDATE((short) 0x999),
    BOAT_EFFECT((short) 0x999),
    FISHING_CAUGHT((short) 0x999),
    SIDEKICK_OPERATION((short) 0x999),
    FARM_PACKET1((short) 0x35C),
    FARM_ITEM_PURCHASED((short) 0x35D),
    FARM_ITEM_GAIN((short) 0x358),
    HARVEST_WARU((short) 0x35A),
    FARM_MONSTER_GAIN((short) 0x999),
    FARM_INFO((short) 0x999),
    FARM_MONSTER_INFO((short) 0x369),
    FARM_QUEST_DATA((short) 0x36A),
    FARM_QUEST_INFO((short) 0x36B),
    FARM_MESSAGE((short) 0x999),//36C
    UPDATE_MONSTER((short) 0x36D),
    AESTHETIC_POINT((short) 0x36E),
    UPDATE_WARU((short) 0x36F),
    FARM_EXP((short) 0x374),
    FARM_PACKET4((short) 0x375),
    QUEST_ALERT((short) 0x377),
    FARM_PACKET8((short) 0x378),
    FARM_FRIENDS_BUDDY_REQUEST((short) 0x37B),
    FARM_FRIENDS((short) 0x37C),
    FARM_USER_INFO((short) 0x3F0),//388
    FARM_AVATAR((short) 0x3F2),//38A
    FRIEND_INFO((short) 0x3F5),//38D
    FARM_RANKING((short) 0x3F7),//38F
    SPAWN_FARM_MONSTER1((short) 0x3FB),//393
    SPAWN_FARM_MONSTER2((short) 0x3FC),//394
    RENAME_MONSTER((short) 0x3FD),//395
    //Unplaced:
    DEATH_COUNT((short) 0x206),
    REDIRECTOR_COMMAND((short) 0x1337),
    UNKNOWN;

    private short code = -2;
    public static boolean record = false;

    private SendPacketOpcode() {
    }

    private SendPacketOpcode(short code) {
        this.code = code;
    }

    @Override
    public void setValue(short code) {
        this.code = code;
    }

    @Override
    public short getValue() {
        return getValue(true);
    }

    public short getValue(boolean show) {
        if (show && ServerConfig.logPackets) {
            if (isRecordHeader(this)) {
                record = true;
                String tab = "";
                for (int i = 4; i > name().length() / 8; i--) {
                    tab += "\t";
                }
                FileoutputUtil.log(FileoutputUtil.Packet_Record, "[發送]\t" + name() + tab + "\t包頭:0x" + StringUtil.getLeftPaddedStr(String.valueOf(code), '0', 4) + "\r\n");
            } else {
                record = false;
            }
        }
        return code;
    }

//    private SendPacketOpcode(short code) {
//        this.code = code;
//    }
    public String getType(short code) {
        String type = null;
        if (code >= 0 && code < 0xE || code >= 0x17 && code < 0x21) {
            type = "CLogin";
        } else if (code >= 0xE && code < 0x17) {
            type = "LoginSecure";
        } else if (code >= 0x21 && code < 0xCB) {
            type = "CWvsContext";
        } else if (code >= 0xD2) {
            type = "CField";
        }
        return type;
    }

    public static String nameOf(int value) {
        for (SendPacketOpcode opcode : SendPacketOpcode.values()) {
            if (opcode.getValue(false) == value) {
                return opcode.name();
            }
        }
        return "UNKNOWN";
    }

    public static boolean isRecordHeader(SendPacketOpcode opcode) {
        switch (opcode) {
//            case WARP_TO_MAP:
//            case GUILD_OPERATION:
//            case PARTY_OPERATION:
//            case GIVE_BUFF:
            case SPAWN_PLAYER:
//            case DROP_ITEM_FROM_MAPOBJECT:
//            case INVENTORY_OPERATION:
            case UNKNOWN:
                return true;
            default:
                return false;
        }
    }

    public static boolean isSpamHeader(SendPacketOpcode opcode) {
        switch (opcode) {
            case PING:
            case NPC_ACTION:
//            case AUTH_RESPONSE:
//            case SERVERLIST:
//            case UPDATE_STATS:
            case MOVE_PLAYER:
//            case SPAWN_NPC:
//            case SPAWN_NPC_REQUEST_CONTROLLER:
//            case REMOVE_NPC:
            case MOVE_MONSTER:
            case MOVE_MONSTER_RESPONSE:
//            case SPAWN_MONSTER:
//            case SPAWN_MONSTER_CONTROL:
//            case HAKU_MOVE:
//            case MOVE_SUMMON:
//            case MOVE_FAMILIAR:
//            case ANDROID_MOVE:
//            case INVENTORY_OPERATION:
//            case MOVE_PET:
//            case SHOW_SPECIAL_EFFECT:
//            case DROP_ITEM_FROM_MAPOBJECT:
//            case REMOVE_ITEM_FROM_MAP:
//            case UPDATE_PARTYMEMBER_HP:
//            case DAMAGE_PLAYER:
            case SHOW_MONSTER_HP:
//            case CLOSE_RANGE_ATTACK:
//            case RANGED_ATTACK:
//            case ARAN_COMBO:
//            case REMOVE_BG_LAYER:
//            case SPECIAL_STAT:
//            case TOP_MSG:
//            case ANGELIC_CHANGE:
//            case UPDATE_CHAR_LOOK:
            case KILL_MONSTER:
                return true;
        }
        return false;
    }
}