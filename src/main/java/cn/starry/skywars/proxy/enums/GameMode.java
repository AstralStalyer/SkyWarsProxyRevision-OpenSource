package cn.starry.skywars.proxy.enums;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum GameMode {
    NORMAL("普通"),
    INSANE("疯狂"),
    RANKED("排位"),
    MEGA("超级");

    @Getter
    private String displayname;
    GameMode(String displayname){
        this.displayname = displayname;
    }
}
