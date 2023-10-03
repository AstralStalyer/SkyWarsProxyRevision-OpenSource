package cn.starry.skywars.proxy.inventory;

import cn.starry.skywars.proxy.util.inventory.InventoryUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class MenuBasic implements Listener {
    protected InventoryUI inventoryUI;
    protected Player player;
    protected MenuBasic mb;
    public MenuBasic(Player p,String title,Integer rows){
        this.player = p;
        inventoryUI = new InventoryUI(title,rows);
        mb = this;
    }
    public MenuBasic(String title,Integer rows){
        inventoryUI = new InventoryUI(title,rows);
        mb = this;
    }
    protected abstract void Setup();
    public void open(){
        Setup();
        player.openInventory(inventoryUI.getCurrentPage());
    }
}
