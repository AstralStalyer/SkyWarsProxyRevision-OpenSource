package cn.starry.skywars.proxy.manager;

import cn.starry.skywars.proxy.util.BungeeUtil;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NPCManager implements Listener {

    @EventHandler
    public void onClick(NPCRightClickEvent e){
        Player player = e.getClicker();
        switch (e.getNPC().getId()){
            case 0:
                BungeeUtil.sendPlayer(player,"Map#1");
                break;
        }
    }
}
