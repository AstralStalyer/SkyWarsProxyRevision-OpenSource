package cn.starry.skywars.proxy.inventory.skywars;

import cn.starry.skywars.proxy.enums.Data;
import cn.starry.skywars.proxy.inventory.MenuBasic;
import cn.starry.skywars.proxy.util.DataUtils;
import cn.starry.skywars.proxy.util.ItemBuilder;
import cn.starry.skywars.proxy.util.MathUtils;
import cn.starry.skywars.proxy.util.inventory.InventoryUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class StatsMenu extends MenuBasic {

    public StatsMenu(Player p){
        super(p,"空岛战争数据统计",6);
    }

    @Override
    protected void Setup() {
        inventoryUI.setItem(4, new InventoryUI.EmptyClickableItem(new ItemBuilder(Material.PAPER)
                .setName("§a全部模式统计信息").setLore(
                        "§7胜场数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.WIN, "NORMAL") + DataUtils.getTotalStat(player, Data.field.WIN, "INSANE")),
                        "§7败场数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.LOSS, "NORMAL") + DataUtils.getTotalStat(player, Data.field.LOSS, "INSANE")),
                        "",
                        "§7击杀数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.KILL, "NORMAL") + DataUtils.getTotalStat(player, Data.field.KILL, "INSANE")),
                        "§7助攻数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.ASSIST, "NORMAL") + DataUtils.getTotalStat(player, Data.field.ASSIST, "INSANE")),
                        "§7死亡数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.DEATH, "NORMAL") + DataUtils.getTotalStat(player, Data.field.DEATH, "INSANE")),
                        "",
                        "§7近战杀敌: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.MELEE_KILL, "NORMAL") + DataUtils.getTotalStat(player, Data.field.MELEE_KILL, "INSANE")),
                        "§7弓箭击杀: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.BOW_KILL, "NORMAL") + DataUtils.getTotalStat(player, Data.field.BOW_KILL, "INSANE")),
                        "§7推入虚空: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.VOID_KILL, "NORMAL") + DataUtils.getTotalStat(player, Data.field.VOID_KILL, "INSANE")),
                        "",
                        "§7箭矢射击数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.BOW_SHOT, "NORMAL") + DataUtils.getTotalStat(player, Data.field.BOW_SHOT, "INSANE")),
                        "§7箭矢射中数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.BOW_HIT, "NORMAL") + DataUtils.getTotalStat(player, Data.field.BOW_HIT, "INSANE")),
                        "",
                        "§7打开箱子个数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.CHESTS_OPENED, "NORMAL") + DataUtils.getTotalStat(player, Data.field.CHESTS_OPENED, "INSANE")),
                        //"§7扔出末影珍珠数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.ENDERPERLS_THROWN, "NORMAL") + DataUtils.getTotalStat(player, Data.field.ENDERPERLS_THROWN, "INSANE")),
                        "§7获得灵魂数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.SOUL_GATHERED, "NORMAL") + DataUtils.getTotalStat(player, Data.field.SOUL_GATHERED, "INSANE")),
                        "§7头颅: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.HEADS_GATHERED, "NORMAL") + DataUtils.getTotalStat(player, Data.field.HEADS_GATHERED, "INSANE"))
                ).
                        toItemStack()) {
        });
        inventoryUI.setItem(21, new InventoryUI.EmptyClickableItem(new ItemBuilder(Material.PAPER)
                .setName("§a单挑模式信息").setLore(
                        "§7胜场数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.WIN, "SOLO")),
                        "§7败场数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.LOSS, "SOLO")),
                        "",
                        "§7击杀数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.KILL, "SOLO")),
                        "§7助攻数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.ASSIST, "SOLO")),
                        "§7死亡数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.DEATH, "SOLO")),
                        "",
                        "§7近战杀敌: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.MELEE_KILL, "SOLO")),
                        "§7弓箭击杀: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.BOW_KILL, "SOLO")),
                        "§7推入虚空: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.VOID_KILL, "SOLO")),
                        "",
                        "§7箭矢射击数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.BOW_SHOT, "SOLO")),
                        "§7箭矢射中数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.BOW_HIT, "SOLO")),
                        "",
                        "§7打开箱子个数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.CHESTS_OPENED, "SOLO")),
                        "",
                        "§7头颅: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.HEADS_GATHERED, "SOLO"))
                ).
                toItemStack()) {
        });
        inventoryUI.setItem(23, new InventoryUI.EmptyClickableItem(new ItemBuilder(Material.PAPER)
                .setName("§a双人模式信息").setLore(
                        "§7胜场数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.WIN, "TEAM")),
                        "§7败场数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.LOSS, "TEAM")),
                        "",
                        "§7击杀数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.KILL, "TEAM")),
                        "§7助攻数: §a" + MathUtils.Format(DataUtils.getTotalStat(player, Data.field.ASSIST, "TEAM")),
                        "§7死亡数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.DEATH, "TEAM")),
                        "",
                        "§7近战杀敌: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.MELEE_KILL, "TEAM")),
                        "§7弓箭击杀: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.BOW_KILL, "TEAM")),
                        "§7推入虚空: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.VOID_KILL, "TEAM")),
                        "",
                        "§7箭矢射击数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.BOW_SHOT, "TEAM")),
                        "§7箭矢射中数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.BOW_HIT, "TEAM")),
                        "",
                        "§7打开箱子个数: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.CHESTS_OPENED, "TEAM")),
                        "",
                        "§7头颅: §a" +  MathUtils.Format(DataUtils.getTotalStat(player, Data.field.HEADS_GATHERED, "TEAM"))
                ).
                toItemStack()) {
        });
        inventoryUI.setItem(49, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.BARRIER)
                .setName("§c关闭").
                toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                player.closeInventory();
            }
        });
    }

    public String allTotal(Player player, Data.field data) {
        return MathUtils.Format(DataUtils.getTotalStat(player, data, "NORMAL") + DataUtils.getTotalStat(player, data, "INSANE"));
    }
}
