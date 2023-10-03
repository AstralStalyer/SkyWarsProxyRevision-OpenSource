package cn.starry.skywars.proxy.inventory.skywars;

import cn.starry.skywars.proxy.enums.Data;
import cn.starry.skywars.proxy.enums.GameMode;
import cn.starry.skywars.proxy.enums.PerkType;
import cn.starry.skywars.proxy.inventory.ConfirmBasic;
import cn.starry.skywars.proxy.inventory.MenuBasic;
import cn.starry.skywars.proxy.util.DataUtils;
import cn.starry.skywars.proxy.util.ItemBuilder;
import cn.starry.skywars.proxy.util.MathUtils;
import cn.starry.skywars.proxy.util.inventory.InventoryUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalPerk extends MenuBasic {

    public NormalPerk(Player p){
        super(p,"§8普通模式增益效果",6);
    }

    @Override
    protected void Setup() {
        ArrayList<InventoryUI.ClickableItem> items = new ArrayList<>();
        Integer coin = DataUtils.getInt(player, Data.PLAYERINFO, Data.field.COIN);
        for(PerkType perk:PerkType.values()){
            //if(kit == KitType.Default) continue;
            Integer level = DataUtils.getInt(player, Data.field.PERKLEVEL,GameMode.NORMAL,perk);
            if(level.equals(perk.getMaxLevel())){
                items.add(new InventoryUI.EmptyClickableItem(perk.getItem(player,GameMode.NORMAL)));
            }else {
                items.add(new InventoryUI.AbstractClickableItem(perk.getItem(player, GameMode.NORMAL)) {
                    @Override
                    public void onClick(InventoryClickEvent e) {
                        if(coin < perk.getPrice(level+1)){
                            e.getWhoClicked().closeInventory();
                            e.getWhoClicked().sendMessage("§c你没有足够的硬币购买此物品！");
                            e.setCancelled(true);
                            return;
                        }
                        new ConfirmBasic(player, perk.getPrice(level + 1), perk.getDBName()+" "+ MathUtils.toRome(level+1)) {
                            @Override
                            public void Confirm(Integer price) {
                                DataUtils.set(player, Data.field.COIN,coin-price);
                                DataUtils.set(player, Data.field.PERKLEVEL,GameMode.NORMAL,perk,level+1);
                                new NormalPerk(player).open();
                            }
                            @Override
                            public void unConfirm() {
                                open();
                            }
                        };
                    }
                });
            }
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

    }
}
