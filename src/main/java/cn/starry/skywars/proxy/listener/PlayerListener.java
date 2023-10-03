package cn.starry.skywars.proxy.listener;

import cn.starry.skywars.proxy.SkyWarsProxy;
import cn.starry.skywars.proxy.enums.Data;
import cn.starry.skywars.proxy.util.DataUtils;
import cn.starry.skywars.proxy.util.PlayerUtils;
import cn.starry.skywars.proxy.util.TitleUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        p.teleport(new Location(Bukkit.getWorld("world"),11.5,102,40.5,0,0));
        PlayerUtils.setFly(p);
        PlayerUtils.giveLobbyItem(p);
        SkyWarsProxy.getInstance().getPlayerManager().add(e.getPlayer());
        //DataUtils.set(p, Data.field.COIN,DataUtils.getInt(p, Data.PLAYERINFO, Data.field.COIN)+500000);
        //TitleUtils.sendFullTitle(p,20,60,20,"§e欢迎来到空岛战争§c删档内测","§c+10,000,000硬币! 首次进入内测礼包");
        //SkyWarsProxy.getInstance().getScoreBoardManager().sendScoreBoard(p);
        if(!e.getPlayer().hasPermission("group.admin")){
            e.getPlayer().setGameMode(GameMode.ADVENTURE);
        }
    }
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(e.getTo().getY() <= 0){
            e.getPlayer().teleport(new Location(Bukkit.getWorld("world"),0.5,50,0.5,0,0));
        }
//        if(e.getTo().distance(CitizensAPI.getNPCRegistry().getById(0).getStoredLocation()) <= 1){
//            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(-2));
//        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onClickinv(InventoryClickEvent e){
        if(!e.getWhoClicked().hasPermission("rml.admin")) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void ondrop(PlayerDropItemEvent e){
        if(e.getPlayer().hasPermission("rmc.admin")) return;
        e.setCancelled(true);
    }
    @EventHandler
    public void onChangeinv(PlayerItemHeldEvent e){
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.NOTE_STICKS,1,1);
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        e.setQuitMessage(null);
        SkyWarsProxy.getInstance().getPlayerManager().remove(e.getPlayer());
    }

}
