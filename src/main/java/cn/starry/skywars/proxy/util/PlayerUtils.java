package cn.starry.skywars.proxy.util;

import cn.starry.skywars.proxy.enums.Data;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PlayerUtils {

    public static void setFly(Player p){
        p.setAllowFlight(true);
        ((CraftPlayer) p).getHandle().abilities.isFlying = true;
        ((CraftPlayer) p).getHandle().updateAbilities();
    }
    public static void giveLobbyItem(Player p){
        Inventory inv = p.getInventory();
        inv.clear();
        inv.setItem(1,new ItemBuilder(Material.EMERALD).setName("§a商店 §7(右键点击)").setLore("§7硬币:§6"+DataUtils.getIntFormated(p, Data.PLAYERINFO, Data.field.COIN)).toItemStack());
    }
}
