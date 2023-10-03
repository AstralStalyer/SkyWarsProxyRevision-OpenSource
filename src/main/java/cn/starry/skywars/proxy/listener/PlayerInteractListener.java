package cn.starry.skywars.proxy.listener;

import cn.starry.skywars.proxy.inventory.skywars.MainMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInt(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if(e.getItem() == null) return;
        switch (e.getItem().getType()){
            case EMERALD:
                new MainMenu(p).open();
                break;
        }
    }
}
