package cn.starry.skywars.proxy.inventory.skywars;

import cn.starry.skywars.proxy.enums.Data;
import cn.starry.skywars.proxy.enums.GameMode;
import cn.starry.skywars.proxy.enums.KitType;
import cn.starry.skywars.proxy.inventory.ConfirmBasic;
import cn.starry.skywars.proxy.inventory.MenuBasic;
import cn.starry.skywars.proxy.util.DataUtils;
import cn.starry.skywars.proxy.util.ItemBuilder;
import cn.starry.skywars.proxy.util.MathUtils;
import cn.starry.skywars.proxy.util.TimeUtil;
import cn.starry.skywars.proxy.util.inventory.InventoryUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class KitPreview extends MenuBasic {

    KitType kitType;
    GameMode gm;
    Inventory back;
    public KitPreview(Player p, KitType kit, GameMode gm, Inventory mb){
        super(p,kit.getDBName()+"职业",6);
        this.kitType = kit;
        this.gm = gm;
        this.back = mb;
    }

    @Override
    protected void Setup() {
        ItemBuilder ib = new ItemBuilder(kitType.getItem());
        ib.setLore(kitType.getLore());
        ib.setName("§a"+kitType.getDBName());
        Integer coin = DataUtils.getInt(player, Data.PLAYERINFO, Data.field.COIN);
        inventoryUI.setItem(12,new InventoryUI.EmptyClickableItem(ib.toItemStack()));
        if(DataUtils.get(player, Data.field.ISBOUGHT,gm,kitType) == null) {
            if(coin < kitType.getRarity().getKitprice()) {
                inventoryUI.setItem(13, new InventoryUI.AbstractClickableItem(
                        new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)
                                14).setName("§e" + kitType.getDBName())
                                .setLore(kitType.getLore()).addLoreLine("")
                                .addLoreLine("§7稀有度: §a" + kitType.getRarity().getDisplayname())
                                .addLoreLine("§7花费: §6" + MathUtils.Format(kitType.getRarity().getKitprice()))
                                .addLoreLine("§b也可以通过灵魂之井获得!")
                                .addLoreLine("")
                                .addLoreLine("§c你没有足够的硬币以购买此物品!")
                                .toItemStack()

                ) {
                    @Override
                    public void onClick(InventoryClickEvent e) {

                    }
                });
            }else {
                inventoryUI.setItem(13, new InventoryUI.AbstractClickableItem(
                        new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)
                                4).setName("§e" + kitType.getDBName())
                                .setLore(kitType.getLore()).addLoreLine("")
                                .addLoreLine("§7稀有度: §a" + kitType.getRarity().getDisplayname())
                                .addLoreLine("§7花费: §a§6" + MathUtils.Format(kitType.getRarity().getKitprice()))
                                .addLoreLine("§b也可以通过灵魂之井获得!")
                                .addLoreLine("")
                                .addLoreLine("§a点击解锁!")
                                .toItemStack()

                ) {
                    @Override
                    public void onClick(InventoryClickEvent e) {
                        new ConfirmBasic(player, kitType.getRarity().getKitprice(), kitType.getDBName()) {
                            @Override
                            public void Confirm(Integer price) {
                                DataUtils.set(player, Data.field.COIN, coin - kitType.getRarity().getKitprice());
                                DataUtils.set(player, Data.field.ISBOUGHT,gm,kitType,1);
                                new NormalKit(player).open();
                            }
                            @Override
                            public void unConfirm() {
                                open();
                            }
                        };
                    }
                });
            }
        }else{
            inventoryUI.setItem(13, new InventoryUI.AbstractClickableItem(
                    new ItemBuilder(Material.STAINED_GLASS_PANE,1,(byte)5).setName("§a"+kitType.getDBName())
                            .setLore(kitType.getLore()).addLoreLine("")
                            .addLoreLine("§7稀有度: §a"+kitType.getRarity().getDisplayname())
                            .addLoreLine("§a已解锁").toItemStack()) {
                @Override
                public void onClick(InventoryClickEvent e) {

                }
            });
        }
        int timeplayed = DataUtils.getInt(player, Data.field.TIME_PLAYED,gm,kitType)/1000;
        int fastestwin = DataUtils.getInt(player, Data.field.FASTEST_WIN,gm,kitType)/1000;
        inventoryUI.setItem(29,new InventoryUI.EmptyClickableItem(new ItemBuilder(Material.ITEM_FRAME)
                .setName("§a统计信息")
                .addLoreLine("§7游戏时间: §a"+ (timeplayed == 0 ? "N/A":TimeUtil.getTime(timeplayed))).addLoreLine("")
                .addLoreLine("§7胜场数: §a"+DataUtils.getIntFormated(player, Data.field.WIN,gm,kitType))
                .addLoreLine("§7最速胜利: §a"+(fastestwin == 0 ? "N/A":TimeUtil.getTime(fastestwin))).addLoreLine("")
                .addLoreLine("§7最高杀敌数: §a"+ DataUtils.getIntFormated(player, Data.field.MOST_KILLS_IN_A_GAME,gm,kitType))
                .addLoreLine("§7击杀生物: §a"+ DataUtils.getIntFormated(player, Data.field.MOBS_KILLED,gm,kitType))
                .addLoreLine("§7打开箱子个数: §a"+ DataUtils.getIntFormated(player, Data.field.CHESTS_OPENED,gm,kitType)).addLoreLine("")
                .addLoreLine("§7获得玩家头数: §a"+DataUtils.getIntFormated(player, Data.field.HEADS_GATHERED,gm,kitType))
                .toItemStack()));
        inventoryUI.setItem(31,new InventoryUI.EmptyClickableItem(new ItemBuilder(Material.DIAMOND_SWORD)
                .setName("§a击杀数").addFlag(ItemFlag.HIDE_ATTRIBUTES)
                .addLoreLine("§7击杀数: §a"+DataUtils.getIntFormated(player, Data.field.KILL,gm,kitType))
                .addLoreLine("§7助攻: §a"+DataUtils.getIntFormated(player, Data.field.ASSIST,gm,kitType)).addLoreLine("")
                .addLoreLine("§7近战杀敌: §a" + DataUtils.getIntFormated(player, Data.field.MELEE_KILL,gm,kitType))
                .addLoreLine("§7弓箭击杀: §a"+ DataUtils.getIntFormated(player, Data.field.BOW_KILL,gm,kitType))
                .addLoreLine("§7推入虚空: §a"+DataUtils.getIntFormated(player, Data.field.VOID_KILL,gm,kitType))
                .addLoreLine("§7使用生物击杀对手: §a"+DataUtils.getIntFormated(player, Data.field.KILLS_BY_MOBS,gm,kitType))
                .toItemStack()));
        inventoryUI.setItem(33, new InventoryUI.EmptyClickableItem(new ItemBuilder(Material.BOW)
                .setName("§a弓术")
                .addLoreLine("§7命中率: §a"+MathUtils.getPercent(DataUtils.getInt(player, Data.field.BOW_HIT,gm,kitType),DataUtils.getInt(player, Data.field.BOW_SHOT,gm,kitType)))
                .addLoreLine("§7弓箭击杀: §a"+ DataUtils.getIntFormated(player, Data.field.BOW_KILL,gm,kitType)).addLoreLine("")
                .addLoreLine("§7最远击杀距离: §a"+ DataUtils.getIntFormated(player, Data.field.BOW_LONGEST_KILL,gm,kitType))
                .addLoreLine("§7最远射击击中: §a"+DataUtils.getIntFormated(player, Data.field.BOW_LONGEST_SHOT,gm,kitType))

                .toItemStack()));
        inventoryUI.setItem(48, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.ARROW)
                .setName("§a返回").setLore("§7至空岛战争商店").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                player.openInventory(back);
            }
        });
        inventoryUI.setItem(49,
                new InventoryUI.EmptyClickableItem(new ItemBuilder(Material.EMERALD)
                        .setName("§7总硬币: §a§6"+ DataUtils.getIntFormated(player, Data.PLAYERINFO, Data.field.COIN)).setLore("§bStarry§3Country").toItemStack()));
    }
}
