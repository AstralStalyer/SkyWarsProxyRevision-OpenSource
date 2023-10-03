package cn.starry.skywars.proxy.inventory.skywars;

import cn.starry.skywars.proxy.enums.Data;
import cn.starry.skywars.proxy.inventory.MenuBasic;
import cn.starry.skywars.proxy.util.DataUtils;
import cn.starry.skywars.proxy.util.ItemBuilder;
import cn.starry.skywars.proxy.util.inventory.InventoryUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KitsPerks extends MenuBasic {
    public KitsPerks(Player p){
        super(p,"§8职业套装&加成效果",6);
    }

    @Override
    protected void Setup() {
        inventoryUI.setItem(12, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.STONE_SWORD)
                .setName("§a普通模式职业").setLore("§7适用于普通模式的特殊职业套装").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                new NormalKit((Player)e.getWhoClicked()).open();
            }
        });
        inventoryUI.setItem(21, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.BREWING_STAND_ITEM)
                .setName("§a普通模式增益效果").setLore("§7适用于普通模式的特殊增益效果").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                new NormalPerk((Player)e.getWhoClicked()).open();
            }
        });
        /*
        inventoryUI.setItem(39, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.SKULL_ITEM).setDurability((short) 1)
                .setName("§a神话职业").setLore("§7浏览和解锁不同的神话职业","","§7神话职业需要使用头颅来解锁,","§7且拥有特殊能力","§7你的皮肤也将在游戏中更改","§7以匹配你所选择的神话职业","","§7该分支仅可在单挑与双人模式中使用","","§e点击浏览").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                new NormalKit((Player)e.getWhoClicked()).open();
            }
        });

         */
        inventoryUI.setItem(48, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.ARROW)
                .setName("§a返回").setLore("§7至空岛战争商店").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                new MainMenu((Player)e.getWhoClicked()).open();
            }
        });
        inventoryUI.setItem(49,
                new InventoryUI.EmptyClickableItem(new ItemBuilder(Material.EMERALD)
                .setName("§7总硬币: §6"+ DataUtils.getIntFormated(player, Data.PLAYERINFO, Data.field.COIN)).setLore("§bStarry§3Country").toItemStack()));
    }
}
