package cn.starry.skywars.proxy.enums;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum Rarity {
    FREE("§7免费",ChatColor.GRAY,0),
    COMMON("§a普通",ChatColor.GREEN,15000),
    RARE("§9稀有",ChatColor.BLUE,20000),
    LEGENDARY("§6传奇",ChatColor.GOLD,30000);
    @Getter
    private String displayname;
    @Getter
    private Integer kitprice;
    @Getter
    private ChatColor chatColor;
    Rarity(String displayname, ChatColor chatColor, Integer kitprice){
        this.displayname = displayname;
        this.chatColor = chatColor;
        this.kitprice = kitprice;
    }
}
