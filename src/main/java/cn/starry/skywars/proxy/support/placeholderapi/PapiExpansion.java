package cn.starry.skywars.proxy.support.placeholderapi;

import cn.starry.skywars.proxy.SkyWarsProxy;
import cn.starry.skywars.proxy.enums.Data;
import cn.starry.skywars.proxy.util.DataUtils;
import cn.starry.skywars.proxy.util.MathUtils;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PapiExpansion extends PlaceholderExpansion {
    @NotNull
    public String getIdentifier() {
        return "sw";
    }

    @NotNull
    public String getAuthor() {
        return "Starry_Killer";
    }

    @NotNull
    public String getVersion() {
        return SkyWarsProxy.getInstance().getDescription().getVersion();
    }

    public String onPlaceholderRequest(Player p, @NotNull String label) {
        switch (label) {
            case "level": {
                return DataUtils.getIntFormated(p, Data.PLAYERINFO, Data.field.LEVEL);
            }
            case "all_kills": {
                return MathUtils.Format(DataUtils.getTotalStat(p, Data.field.KILL, "SOLO") + DataUtils.getTotalStat(p, Data.field.KILL, "TEAM"));
            }
            case "all_wins": {
                return MathUtils.Format(DataUtils.getTotalStat(p, Data.field.WIN, "SOLO") + DataUtils.getTotalStat(p, Data.field.WIN, "TEAM"));
            }
            case "solo_kills": {
                return MathUtils.Format(DataUtils.getTotalStat(p, Data.field.KILL, "SOLO"));
            }
            case "solo_wins": {
                return MathUtils.Format(DataUtils.getTotalStat(p, Data.field.WIN, "SOLO"));
            }
            case "double_kills": {
                return MathUtils.Format(DataUtils.getTotalStat(p, Data.field.KILL, "TEAM"));
            }
            case "double_wins": {
                return MathUtils.Format(DataUtils.getTotalStat(p, Data.field.WIN, "TEAM"));
            }
        }
        return "PLACEHOLDER_NOT_FOUND";
    }
}

