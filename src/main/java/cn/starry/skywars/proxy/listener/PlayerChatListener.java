package cn.starry.skywars.proxy.listener;

import cn.starry.skywars.proxy.util.LuckPerms;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.craftbukkit.v1_8_R3.CraftSound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        e.setFormat(LuckPerms.getPrefix(p)+p.getName()+LuckPerms.getSuffix(p)+"§f: "+ e.getMessage());
    }
}
