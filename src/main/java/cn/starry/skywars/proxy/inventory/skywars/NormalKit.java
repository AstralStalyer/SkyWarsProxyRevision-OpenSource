package cn.starry.skywars.proxy.inventory.skywars;

import cn.starry.skywars.proxy.enums.Data;
import cn.starry.skywars.proxy.enums.GameMode;
import cn.starry.skywars.proxy.enums.KitType;
import cn.starry.skywars.proxy.inventory.MenuBasic;
import cn.starry.skywars.proxy.util.DataUtils;
import cn.starry.skywars.proxy.util.ItemBuilder;
import cn.starry.skywars.proxy.util.inventory.InventoryUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalKit extends MenuBasic {

    public NormalKit(Player p){
        super(p,"普通模式职业 Page #1",6);
        page2 = new InventoryUI("普通模式职业 Page #2",6);
    }
    InventoryUI page2;
    @Override
    protected void Setup() {
        ArrayList<InventoryUI.AbstractClickableItem> items = new ArrayList<>();
        for(KitType kit:KitType.values()){
            //if(kit == KitType.Default) continue;
            items.add(new InventoryUI.AbstractClickableItem(kit.getItem(player,GameMode.NORMAL)) {
                @Override
                public void onClick(InventoryClickEvent e) {
                    new KitPreview(player,kit,GameMode.NORMAL,player.getOpenInventory().getTopInventory()).open();
                }
            });
        }
        List<Integer> ints = Arrays.asList(9,18,27,36,17,26,35);
        for (int i = 10;i<44;i++){
            if(ints.contains(i)) continue;
            if(items.size() <= 0) break;
            inventoryUI.setItem(i,items.get(0));
            items.remove(0);
        }
        inventoryUI.setItem(48, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.ARROW)
                .setName("§a返回").setLore("§7至职业套装&加成效果").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                new KitsPerks((Player)e.getWhoClicked()).open();
            }
        });
        inventoryUI.setItem(49,
                new InventoryUI.EmptyClickableItem(new ItemBuilder(Material.EMERALD)
                        .setName("§7总硬币: §6"+ DataUtils.getIntFormated(player, Data.PLAYERINFO, Data.field.COIN)).setLore("§bStarry§3Country").toItemStack()));
        if(items.size() == 0) return;
        inventoryUI.setItem(53, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.ARROW).
                setName("§a下一页").setLore("§e页序号: 2").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                player.openInventory(page2.getCurrentPage());
            }
        });
        page2.setItem(45, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.ARROW).
                setName("§a上一页").setLore("§e页序号: 1").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                open();
            }
        });
        page2.setItem(48, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.ARROW)
                .setName("§a返回").setLore("§7至职业套装&加成效果").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                new KitsPerks((Player)e.getWhoClicked()).open();
            }
        });
        page2.setItem(49,
                new InventoryUI.EmptyClickableItem(new ItemBuilder(Material.EMERALD)
                        .setName("§7总硬币: §6"+ DataUtils.getIntFormated(player, Data.PLAYERINFO, Data.field.COIN)).setLore("§bStarry§3Country").toItemStack()));
        for (int i = 10;i<44;i++){
            if(ints.contains(i)) continue;
            if(items.size() <= 0) break;
            page2.setItem(i,items.get(0));
            items.remove(0);
        }
    }
}
