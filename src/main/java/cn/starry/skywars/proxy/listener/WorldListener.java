package cn.starry.skywars.proxy.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if(!e.getPlayer().hasPermission("rmc.admin")){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if(!e.getPlayer().hasPermission("rmc.admin")){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onWra(WeatherChangeEvent e){
        e.setCancelled(true);
        e.getWorld().setWeatherDuration(0);
        e.getWorld().setThundering(false);
    }
    //环境
    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        if(!e.getPlayer().hasPermission("rml.admin")){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e){
        Player p = (Player)e.getEntity();
        p.setFoodLevel(20);
        e.setCancelled(true);
    }
    @EventHandler
    public void onLightning(LightningStrikeEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onIgnite(BlockIgniteEvent e){
        e.setCancelled(true);
    }

}
