package cn.starry.skywars.proxy.inventory.skywars;

import cn.starry.skywars.proxy.inventory.MenuBasic;
import cn.starry.skywars.proxy.util.ItemBuilder;
import cn.starry.skywars.proxy.util.inventory.InventoryUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainMenu extends MenuBasic {

    public MainMenu(Player p){
        super(p,"空岛战争商店",3);
    }

    @Override
    protected void Setup() {
        inventoryUI.setItem(11, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.EYE_OF_ENDER)
                .setName("§a职业&增益效果").setLore("§7获取职业套装和增益效果,","§7丰富玩法!","","§7在§b灵魂井§7中赢取职业和",
                        "§7增益效果,或者使用§6硬币","§7直接购买","","§e点击浏览").
                        toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                new KitsPerks((Player)e.getWhoClicked()).open();
            }
        });
        inventoryUI.setItem(15, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.SLIME_BALL)
                .setName("§a我的特效").setLore("§7浏览和装备所有可获得的空岛战争特效","","§7从§c活动§7中获得特效,或者","§7用§2代币§7直接购买特效", "","§c待开放").
                toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
            }
        });
    }
}
