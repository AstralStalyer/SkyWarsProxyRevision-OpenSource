package cn.starry.skywars.proxy.inventory;

import cn.starry.skywars.proxy.SkyWarsProxy;
import cn.starry.skywars.proxy.util.ItemBuilder;
import cn.starry.skywars.proxy.util.MathUtils;
import cn.starry.skywars.proxy.util.inventory.InventoryUI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public abstract class ConfirmBasic extends MenuBasic {
    Integer price;
    String product;
    public ConfirmBasic(Player p,Integer price,String product){
        super(p,"你确定吗?",3);
        this.price = price;
        this.product = product;
        Setup();
        p.playSound(p.getLocation(), Sound.NOTE_PLING,1,1);
        p.openInventory(inventoryUI.getCurrentPage());
    }
    public void Setup(){
        inventoryUI.setItem(11, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.STAINED_CLAY,1,(byte)13)
                .setName("§a确认").setLore("§7以"+ MathUtils.Format(price)+"硬币的价格购买"+product+".").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                player.playSound(player.getLocation(), Sound.NOTE_STICKS,1,1);
                //e.getWhoClicked().closeInventory();
                Confirm(price);
                player.sendMessage("§6恭喜你购买了§a"+product+"§6!");
                //SkyWarsProxy.getInstance().getScoreBoardManager().sendScoreBoard(player);
            }
        });
        inventoryUI.setItem(15, new InventoryUI.AbstractClickableItem(new ItemBuilder(Material.STAINED_CLAY,1,(byte)14)
                .setName("§c取消").setLore("§7返回上一级菜单.").toItemStack()) {
            @Override
            public void onClick(InventoryClickEvent e) {
                unConfirm();
            }
        });
    }

    public abstract void Confirm(Integer price);
    public abstract void unConfirm();
}
