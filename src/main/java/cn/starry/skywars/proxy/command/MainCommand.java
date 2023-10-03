package cn.starry.skywars.proxy.command;

import cn.starry.skywars.proxy.SkyWarsProxy;
import cn.starry.skywars.proxy.enums.Data;
import cn.starry.skywars.proxy.inventory.skywars.StatsMenu;
import cn.starry.skywars.proxy.util.DataUtils;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public class MainCommand extends Command {

    public MainCommand(){
        super("skywars");
        setAliases(Collections.singletonList("sw"));
    }
    @SneakyThrows
    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if(!(sender instanceof Player)) return true;
        if(!sender.hasPermission("skywars.admin")) return true;
        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage("§c用法: /skywars <value>");
            return true;
        }
        if(args[0].equalsIgnoreCase("stats")){
            new StatsMenu(p).open();
            return true;
        }
        if(args[0].equalsIgnoreCase("coins")){
            if(args.length != 4){
                p.sendMessage("§c用法: /skywars coins <add/set/remove> <player> <value>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[2]);
            if (args[1].equalsIgnoreCase("add")) {
                if (target == null) {
                    p.sendMessage("§c此玩家不在线或不存在");
                    return true;
                }
                DataUtils.set(target, Data.field.COIN,DataUtils.getInt(p, Data.PLAYERINFO, Data.field.COIN) + Integer.valueOf(args[3]));
                p.sendMessage("§f成功为用户 §b" + target.getName() + " §f增加了§6 " + args[3] + " §f硬币");
                //SkyWarsProxy.getInstance().getScoreBoardManager().sendScoreBoard(target);
            }
            if (args[1].equalsIgnoreCase("set")) {
                if (target == null) {
                    p.sendMessage("§c此玩家不在线或不存在");
                    return true;
                }
                DataUtils.set(target, Data.field.COIN, Integer.valueOf(args[3]));
                p.sendMessage("§f成功将用户 §b" + target.getName() + " §f设置为§6 " + args[3] + " §f硬币");
                //SkyWarsProxy.getInstance().getScoreBoardManager().sendScoreBoard(target);
            }
            if (args[1].equalsIgnoreCase("remove")) {
                if (target == null) {
                    p.sendMessage("§c此玩家不在线或不存在");
                    return true;
                }
                DataUtils.set(target, Data.field.COIN, DataUtils.getInt(p, Data.PLAYERINFO, Data.field.COIN) - Integer.valueOf(args[3]));
                p.sendMessage("§f成功为用户 §b" + target.getName() + " §f减少了§6 " + args[3] + " §f硬币");
                //SkyWarsProxy.getInstance().getScoreBoardManager().sendScoreBoard(target);
            }
            return true;
        }
        if(args[0].equalsIgnoreCase("tokens")){
            if(args.length != 4){
                p.sendMessage("§c用法: /skywars tokens <add/set/remove> <player> <value>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[2]);
            if (args[1].equalsIgnoreCase("add")) {
                if (target == null) {
                    p.sendMessage("§c此玩家不在线或不存在");
                    return true;
                }
                DataUtils.set(target, Data.field.TOKEN,DataUtils.getInt(p, Data.PLAYERINFO, Data.field.TOKEN) + Integer.valueOf(args[3]));
                p.sendMessage("§f成功为用户 §b" + target.getName() + " §f增加了§2 " + args[3] + " §f代币");
                //SkyWarsProxy.getInstance().getScoreBoardManager().sendScoreBoard(target);
            }
            if (args[1].equalsIgnoreCase("set")) {
                if (target == null) {
                    p.sendMessage("§c此玩家不在线或不存在");
                    return true;
                }
                DataUtils.set(target, Data.field.TOKEN, Integer.valueOf(args[3]));
                p.sendMessage("§f成功将用户 §b" + target.getName() + " §f设置为§2 " + args[3] + " §f代币");
                //SkyWarsProxy.getInstance().getScoreBoardManager().sendScoreBoard(target);
            }
            if (args[1].equalsIgnoreCase("remove")) {
                if (target == null) {
                    p.sendMessage("§c此玩家不在线或不存在");
                    return true;
                }
                DataUtils.set(target, Data.field.TOKEN, DataUtils.getInt(p, Data.PLAYERINFO, Data.field.TOKEN) - Integer.valueOf(args[3]));
                p.sendMessage("§f成功为用户 §b" + target.getName() + " §f减少了§2 " + args[3] + " §f代币");
                //SkyWarsProxy.getInstance().getScoreBoardManager().sendScoreBoard(target);
            }
            return true;
        }
        return true;
    }
}
