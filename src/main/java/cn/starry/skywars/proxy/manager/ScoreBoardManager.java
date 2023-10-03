package cn.starry.skywars.proxy.manager;

import cn.starry.skywars.proxy.SkyWarsProxy;
import cn.starry.skywars.proxy.enums.Data;
import cn.starry.skywars.proxy.object.PlayerData;
import cn.starry.skywars.proxy.runnable.ScoreBoardRunnable;
import cn.starry.skywars.proxy.util.DataUtils;
import cn.starry.skywars.proxy.util.MathUtils;
import org.bukkit.entity.Player;

public class ScoreBoardManager {

    public void sendScoreBoard(Player p){
        PlayerData pd= SkyWarsProxy.getInstance().getPlayerManager().get(p);
        String[] s = new String[]{
                "",
                "你的等级: §7" + DataUtils.getIntFormated(p, Data.PLAYERINFO, Data.field.LEVEL),
                "",
                "单挑模式击杀: §a" + MathUtils.Format(DataUtils.getTotalStat(p, Data.field.KILL, "SOLO")),
                "单挑模式胜场: §a" + MathUtils.Format(DataUtils.getTotalStat(p, Data.field.WIN, "SOLO")),
                "双人模式击杀: §a" + MathUtils.Format(DataUtils.getTotalStat(p, Data.field.KILL, "TEAM")),
                "双人模式胜场: §a" + MathUtils.Format(DataUtils.getTotalStat(p, Data.field.WIN, "TEAM")),
                "",
                "硬币: §6"+DataUtils.getIntFormated(p,Data.PLAYERINFO, Data.field.COIN),
                "灵魂: §b"+DataUtils.getInt(p, Data.PLAYERINFO,Data.field.SOUL)+"§7/"+(100+DataUtils.getInt(p,Data.PLAYERINFO, Data.field.SOUL_ADDED)),
                "代币: §2"+DataUtils.getIntFormated(p, Data.PLAYERINFO,Data.field.TOKEN),
                "",
                "§bStarry§3Country"};
        new ScoreBoardRunnable(pd,"§b§l空岛§3§l战争",s).runTask(SkyWarsProxy.getInstance());
    }
}
