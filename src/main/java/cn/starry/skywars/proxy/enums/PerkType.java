package cn.starry.skywars.proxy.enums;

import cn.starry.skywars.proxy.util.DataUtils;
import cn.starry.skywars.proxy.util.ItemBuilder;
import cn.starry.skywars.proxy.util.ItemUtil;
import cn.starry.skywars.proxy.util.MathUtils;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public enum PerkType {
    ArrowRecovery(Rarity.RARE,new ItemBuilder(Material.ARROW).toItemStack(),5,new String[]
            {
            "§7当你用弓箭击杀一名玩家后，你射出的下一支箭将对命中目标附带冲击效果."
            },"箭矢回收"),
    BlazingArrows(Rarity.RARE,new ItemBuilder(Material.BLAZE_POWDER).toItemStack(),5,new String[]
            {
                    "§7射击时有%%value%%%的概率射出一发火焰箭"
            },"火焰箭矢"),
    Bulldozer(Rarity.LEGENDARY,new ItemBuilder(Material.ANVIL).toItemStack(),5, new String[]
            {
                    "§7每杀死一名敌人后将获得%%value%%秒的力量 I 效果"
            },"推土机"),
    EnderMastery(Rarity.COMMON,new ItemBuilder(Material.ENDER_PEARL).toItemStack(),5,new String[]
            {
                    "§7减少末影珍珠所产生的%%value%%%伤害"
            },"末影专精"),
    InstantSmelting(Rarity.COMMON,new ItemBuilder(Material.FURNACE).toItemStack(),1,new String[]
            {
                    "§7你挖到的矿石将会自动治炼成锭！"
            },"瞬间烧炼"),
    Juggernaut(Rarity.RARE,new ItemBuilder(Material.DIAMOND_HELMET).toItemStack(),5,new String[]
            {
                    "§7每击杀一名敌人后，你都可以获得%%value%%秒的生命恢复I效果"
            },"主宰者"),
    Marksmanship(Rarity.LEGENDARY,new ItemBuilder(Material.BOW).toItemStack(),1,new String[]
            {
                    "§7在你使用弓箭射杀两名玩家之后，你物品栏中的所有弓都将提升一级力量附魔"
            },"百步穿杨"),
    MiningExpertise(Rarity.COMMON,new ItemBuilder(Material.IRON_PICKAXE).toItemStack(),5,new String[]
            {
                    "§7每挖一块矿石将有%%value%%%的机率掉落双倍矿物"
            },"挖掘专家"),
    ResistanceBoost(Rarity.COMMON,new ItemBuilder(Material.IRON_CHESTPLATE).toItemStack(),3,new String[]
            {
                    "§7当游戏开始时你会获得%%value%%秒的抗性提升II效果"
            },"抗性提升"),
    SpeedBoost(Rarity.RARE,new ItemBuilder(Material.BREWING_STAND_ITEM).toItemStack(),5,new String[]
            {
                    "§7当游戏开始时你会获得%%value%%秒的急迫I效果"
            },"速度提升"),
    Knowledge(Rarity.COMMON,new ItemBuilder(Material.BOOK).toItemStack(),3,new String[]
            {
                    "§7每当击杀一个人时，你将获得%%value%%经验等级"
            },"知识"),
    AnnoyOMite(Rarity.RARE,new ItemBuilder(Material.MONSTER_EGG,1,(byte)60).toItemStack(),5,new String[]
            {
                    "§7当你用弓射中敌人时有%%value%%%的概率在其旁边生成一只蠹虫"
            },"群虫射手"),
    Nourishment(Rarity.COMMON,new ItemBuilder(Material.BREAD).toItemStack(),1,new String[]
            {
                    "§7每次击杀会将饥饿值和饱和度完全恢复."
            },"能量汲取"),
    Revenge(Rarity.LEGENDARY,new ItemBuilder(Material.IRON_SWORD).toItemStack(),1,new String[]
            {
                    "§7有5%的几率在你死亡后生成一只蜘蛛."
            },"复仇"),
    Fat(Rarity.RARE,new ItemBuilder(Material.GOLDEN_APPLE).toItemStack(),5,new String[]
            {
                    "§7当游戏开始时，你都可以获得%%value%%秒的伤害吸收I效果"
            },"胖子"),
    Bridger(Rarity.COMMON,new ItemBuilder(Material.WOOD).toItemStack(),5,new String[]
            {
                    "§7有%%value%%%的几率放置方块时",
                    "§7不消耗方块数量"
            },"建造者"),
    EnvironmentalExpert(Rarity.RARE,new ItemBuilder(Material.LEATHER_CHESTPLATE).toItemStack(),3,new String[]
            {
                    "§7减少%%value%%%的环境伤害",
            },"生存专家"),
    LuckyCharm(Rarity.COMMON,new ItemBuilder(Material.SPECKLED_MELON).toItemStack(),20,new String[]
            {
                    "§7%%value%%%的几率在获得一次击杀",
                    "§7后得到一个金苹果."
            },"幸运符"),
    Necromancer(Rarity.LEGENDARY,new ItemBuilder(Material.ROTTEN_FLESH).toItemStack(),5,new String[]
            {
                    "§7击杀一名玩家后有%%value%%%的概率生成一只友好僵尸"
            },"亡灵法师"),
    BlackMagic(Rarity.LEGENDARY,new ItemBuilder(Material.CAULDRON_ITEM).toItemStack(),5,new String[]
            {
                    "§7将一名玩家扔下虚空后将有%%value%%%的概率获得末影珍珠"
            },"黑魔法"),
    Robbery(Rarity.LEGENDARY,new ItemBuilder(Material.IRON_FENCE).toItemStack(),10,new String[]
            {
                    "§7%%value%%%几率在空手攻击的时候，掉落",
                    "§7目标手中物品."
            },"盗窃"),
    Frost(Rarity.LEGENDARY,new ItemBuilder(Material.ICE).toItemStack(),5,new String[]
            {
                    "§7拉满的弓箭命中时，有%%value%%%几率对目标",
                    "§7施加缓慢I效果，持续3秒"
            },"冰霜法术"),
    Barbarian(Rarity.LEGENDARY,new ItemBuilder(Material.IRON_AXE).toItemStack(), 5,new String[]
            {
                    "§7用斧头击杀一名玩家后,有%%value%%%几率该斧头将提升一级锋利"
            },"斧头帮");

    @Getter
    private final Rarity rarity;
    @Getter
    private final ItemStack item;
    @Getter
    private final String DBName;
    @Getter
    private final Integer maxLevel;
    @Getter
    private final String[] lore;
    //private final String[] lore;

    PerkType(Rarity rarity,ItemStack item, Integer maxLevel,String[] lore,String DBName) {
        this.rarity = rarity;
        this.item = item;
        this.DBName = DBName;
        this.lore = lore;

        this.maxLevel = maxLevel;
    }
    public ItemStack getItem(Player player,GameMode gm){
        ItemUtil.addItemFlag(item, ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> re = new ArrayList<>();
        Integer coin = DataUtils.getInt(player, Data.PLAYERINFO, Data.field.COIN);
        Integer level = DataUtils.getInt(player, Data.field.PERKLEVEL,gm,this);
        for(String s: lore){
            if(maxLevel.equals(level)){
                re.add(s.replace("%%value%%", String.valueOf(getprobably( level))));
            }else {
                re.add(s.replace("%%value%%", String.valueOf(getprobably(level + 1))));
            }
        }
        re.addAll(Arrays.asList("","§7稀有度: "+rarity.getDisplayname()));
        if(level.equals(maxLevel)){
            re.add("§a已解锁");
        }else{
            re.add("§7花费: §6"+ MathUtils.Format(getPrice(level+1)));
            re.add("§b也可以通过灵魂之井获得!");
            re.add("");
            re.add("§e点击升级!");
        }

        ChatColor cc = ChatColor.GREEN;
        if(level == 0 || coin < getPrice(level)) cc = ChatColor.RED;
        ItemUtil.reloreItem(item,re.toArray(new String[0]));
        ItemUtil.renameItem(item,cc+getDBName()+(maxLevel == 1 ? "":(" "+MathUtils.toRome(maxLevel.equals(level) ? level:(level+1)))));
        return item;
    }
    public Integer getprobably(Integer level){
        switch (this){
            case ArrowRecovery:
                return level*5;
            case BlazingArrows:
                return level;
            case Bulldozer:
                return level;

            case EnderMastery:
                return 20*level;

            case Juggernaut:
                return level*2;

            case MiningExpertise:
                return level*10;

            case ResistanceBoost:
                return level*5;

            case SpeedBoost:
                switch (level){
                    case 1:
                        return  5;
                    case 2:
                        return  11;
                    case 3:
                        return  17;
                    case 4:
                        return  23;
                    case 5:
                        return  30;

                }

            case Knowledge:
                return level;

            case AnnoyOMite:
                switch (level){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return  4+level;
                        
                    case 5:
                        return 10;
                        
                }
                
            case Fat:
                return level*4;

            case Bridger:
                return level*5;

            case EnvironmentalExpert:
                switch (level){
                    case 1:
                        return  5;
                        
                    case 2:
                        return  15;
                        
                    case 3:
                        return  20;
                        
                }
                
            case LuckyCharm:
                if(level <= 10){
                    return level*2;
                }else{
                    return  10+ level;
                }
                
            case Necromancer:
                return 3+level;
                
            case BlackMagic:
                return 3*level;

            case Robbery:
                return level;

            case Frost:
                return level;
            case Barbarian:
                return  level*3;
            default:
                return null;

        }
    }
    public Integer getPrice(Integer level){
        Rarity rarity = getRarity();
        Integer maxlevel = getMaxLevel();
        switch (rarity){
            case COMMON:
                switch (maxlevel){
                    case 1:
                        return 5000;
                    case 3:
                        switch (level){
                            case 1:
                            case 2:
                                return 5000;
                            case 3:
                                return 25000;
                        }
                    case 5:
                        return level*5000;
                    case 20:
                        return level*5000;
                }
            case RARE:
                switch (maxlevel){
                    case 3:
                        switch (level){
                            case 1:
                                return 50000;
                            case 2:
                                return 15000;
                            case 3:
                                return 25000;
                        }
                    case 5:
                        switch (level){
                            case 1:
                                return 50000;
                            case 2:
                                return 5000;
                            case 3:
                                return 15000;
                            case 4:
                                return 20000;
                            case 5:
                                return 25000;
                        }
                }
            case LEGENDARY:
                if(this == Bulldozer){
                    switch (level){
                        case 1:
                            return 150000;
                        case 2:
                            return 5000;
                        case 3:
                            return 15000;
                        case 4:
                            return 20000;
                        case 5:
                            return 25000;
                    }
                }
                switch (maxlevel){
                    case 1:
                        return 150000;
                    case 5:
                        switch (level){
                            case 1:
                                return 150000;
                            case 2:
                                return 50000;
                            case 3:
                                return 100000;
                            case 4:
                                return 150000;
                            case 5:
                                return 200000;
                        }
                    case 10:
                        switch (level){
                            case 1:
                                return 150000;
                            case 2:
                                return 40000;
                            case 3:
                                return 50000;
                            case 4:
                                return 65000;
                            case 5:
                                return 80000;
                            case 6:
                                return 100000;
                            case 7:
                                return 125000;
                            case 8:
                                return 150000;
                            case 9:
                                return 175000;
                            case 10:
                                return 200000;
                        }
                }
            default:
                return 100000000;
        }
    }

}
