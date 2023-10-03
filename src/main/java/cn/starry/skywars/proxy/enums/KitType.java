package cn.starry.skywars.proxy.enums;

import cn.starry.skywars.proxy.util.DataUtils;
import cn.starry.skywars.proxy.util.ItemBuilder;
import cn.starry.skywars.proxy.util.ItemUtil;
import cn.starry.skywars.proxy.util.MathUtils;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Arrays;

public enum KitType {
    /*
    Default(null,new ItemBuilder(Material.WOOD_PICKAXE).toItemStack(), "默认",
            new String[]{
                    "§7木镐",
                    "§7木斧",
                    "§7木锹"
    }),

     */
    Armorer(Rarity.RARE,new ItemBuilder(Material.GOLD_CHESTPLATE).toItemStack(),"装备师",
            new String[]{
                    "§7金胸甲",
                    "§7金护腿",
                    "§7金靴子"
    }),
    Armorsmith(Rarity.COMMON,new ItemBuilder(Material.ANVIL).toItemStack(), "附魔师",
            new String[]{
                    "§7铁砧",
                    "§7附魔书",
                    "   §8· 保护 III",
                    "   §8· 锋利 I",
                    "§7附魔之瓶 §8x64",
                    "§7钻石头盔"

    }),
    BaseBallPlayer(Rarity.RARE,new ItemBuilder(Material.IRON_HELMET).toItemStack(),"棒球手",
            new String[]{
                    "§7铁头盔",
                    "   §8· 保护 I",
                    "§7木剑",
                    "   §8· 击退 I"
    }),
    Cannoneer(Rarity.LEGENDARY,new ItemBuilder(Material.TNT).toItemStack(),"炮手",
            new String[]{
                    "§7TNT §8x16",
                    "§7红石块 §8x4",
                    "§7铁靴子",
                    "   §8· 摔落保护 III",
                    "   §8· 爆炸保护 III",
                    "§7水桶",
                    "§压力板 §8x4"
    }),
    Ecologist(Rarity.COMMON,ItemUtil.addItemFlag(new ItemBuilder(Material.IRON_AXE).toItemStack(),ItemFlag.HIDE_ATTRIBUTES),"生态学家",
            new String[]{
                    "§7铁斧",
                    "   §8· 效率 I",
                    "§7橡木 §8x16"
    }),
    Enchanter(Rarity.COMMON,new ItemBuilder(Material.ENCHANTMENT_TABLE).toItemStack(),"附魔师",
            new String[]{
                    "§7附魔台",
                    "§7附魔之瓶 §8x64",
                    "§7书架 §8x8"
    }),
    EnderChest(Rarity.RARE,new ItemBuilder(Material.ENDER_CHEST).toItemStack(),"末影拾荒者",
            new String[]{
                    "§7金苹果",
                    "§7在你的笼子下生成第四个",
                    "§7带有出生物品的箱子"
    }),
    Enderman(Rarity.LEGENDARY,new ItemBuilder(Material.ENDER_PEARL).toItemStack(),"末影人",
            new String[]{
                    "§7损坏的珍珠 §8(§730秒冷却§8)"
    }),
    Farmer(Rarity.RARE,new ItemBuilder(Material.IRON_LEGGINGS).toItemStack(),"农夫",
            new String[]{
                    "§7铁护腿",
                    "   §8· 弹射物保护 III",
                    "§7蛋 §8x64",
                    "§7金苹果"
    }),
    Fisherman(Rarity.RARE,new ItemBuilder(Material.FISHING_ROD).toItemStack(),"渔夫",
            new String[]{
                    "§7钓鱼竿",
                    "   §8· 耐久 X",
                    "   §8· 击退 I",
                    "   §8· 海之眷顾 X",
                    "   §8· 饵钓 VII",
                    "§7熟鱼 §8x16",
    }),
    Hunter(Rarity.RARE,new ItemBuilder(Material.BOW).toItemStack(),"猎人",
            new String[]{
                    "§7弓",
                    "   §8· 力量 I",
                    "§7箭 §8x16"
    }),
    Knight(Rarity.RARE,ItemUtil.addItemFlag(new ItemBuilder(Material.GOLD_SWORD).toItemStack(),ItemFlag.HIDE_ATTRIBUTES),"骑士",
            new String[]{
                    "§7金剑",
                    "   §8· 锋利 II",
                    "   §8· 耐久 V",
                    "§7金头盔",
                    "   §7· 保护 I"
    }),
    Pharaoh(Rarity.RARE,new ItemBuilder(Material.GOLD_HELMET).toItemStack(),"法老",
            new String[]{
                    "§7金头盔",
                    "§7白色皮革外套",
                    "§7白色皮革裤子",
                    "§7信标",
                    "§7绿宝石块 §8x42"
    }),
    Pyro(Rarity.LEGENDARY,new ItemBuilder(Material.FLINT_AND_STEEL).toItemStack(),"纵火者",
            new String[]{
                    "§7打火石",
                    "   §8· 耐久 X",
                    "§7熔岩桶 §8x5",
                    "§7铁胸甲",
                    "§f喷溅型抗火药水 (无限)"
    }),
    Rookie(Rarity.COMMON,new ItemBuilder(Material.LEATHER_HELMET).toItemStack(),"菜鸟",
            new String[]{
                    "§7皮革帽子",
                    "§7皮革外套",
                    "§7皮革裤子",
                    "§7皮革靴子",
                    "§7木剑",
                    "§7玻璃 §8x16",
                    "§7牛排"
    }),
    Snowman(Rarity.RARE,new ItemBuilder(Material.SNOW_BALL).toItemStack(),"雪人",
            new String[]{
                    "§7雪球 §8x16",
                    "§7雪块 §8x2",
                    "§7铁锹",
                    "§7南瓜"
            }),
    Speleologist(Rarity.RARE,ItemUtil.addItemFlag(new ItemBuilder(Material.IRON_PICKAXE).toItemStack(),ItemFlag.HIDE_ATTRIBUTES),"考古学家",
            new String[]{
                    "§7铁镐",
                    "   §8· 效率 III",
                    "   §8· 锋利 I",
                    "   §8· 耐久 III",
                    "§7木头 §8x16"
    }),
    Troll(Rarity.LEGENDARY,new ItemBuilder(Material.WEB).toItemStack(),"熊孩子",
            new String[]{
                    "§7蜘蛛网 §8x16",
                    "§7烟花火箭 §8x5",
                    "§7皮革帽子",
                    "§7皮革外套",
                    "§7皮革裤子",
                    "§7皮革靴子"
    }),
    Batguy(Rarity.COMMON,new ItemBuilder(Material.LEATHER_HELMET).setLeatherArmorColor(Color.BLACK).toItemStack(),"蝙蝠人",
            new String[]{
                    "§7皮革帽子",
                    "§7皮革外套",
                    "§7皮革裤子",
                    "§7皮革靴子",
                    "§a蝙蝠人药水 (8秒)",
                    "§7蝙蝠 蛋 §8x5"

    }),
    Disco(Rarity.COMMON,new ItemBuilder(Material.JUKEBOX).toItemStack(),"迪斯科",
            new String[]{
                    "§7金头盔",
                    "   §8· 弹射物保护 IV",
                    "§7皮革外套",
                    "   §8· 保护 II",
                    "   §8· 荆棘 III",
                    "§7皮革裤子",
                    "§7皮革靴子",
                    "   §8· 摔落保护 II",
                    "§7唱片机",
                    "§7音符盒 §8x12",
                    "§7随机音乐唱片"
    }),
    Energix(Rarity.COMMON,new ItemBuilder(Material.BREWING_STAND_ITEM).toItemStack(),"大力士",
            new String[]{
                    "§7力量药水 (5秒)"
    }),
    Frog(Rarity.COMMON,ItemUtil.getCustomSkull("ewogICJ0aW1lc3RhbXAiIDogMTU5NTMxOTUxNDgyMSwKICAicHJvZmlsZUlkIiA6ICI1NjY3NWIyMjMyZjA0ZWUwODkxNzllOWM5MjA2Y2ZlOCIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGVJbmRyYSIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9kMmIyMTJiNzNiYmEwNjRkNWYyZmUwNjFlNDZmZmZmNzMwZWQ1NWZiODM2N2NiZTEyZTcxYmRiMjdhYzAwZGU3IgogICAgfQogIH0KfQ==")
            ,"青蛙",
            new String[]{
                    "§a青蛙头饰",
                    "§7皮革外套",
                    "§7皮革裤子",
                    "§7皮革靴子",
                    "§a青蛙药水 (20秒)"
    }),
    Grenade(Rarity.COMMON,new ItemBuilder(Material.MONSTER_EGG,1,(byte)50).toItemStack(),"苦力怕",
            new String[]{
                    "§a闪电苦力怕蛋"
            }),
    Guardian(Rarity.LEGENDARY,new ItemBuilder(Material.OBSIDIAN).toItemStack(),"守卫者",
            new String[]{
                    "§7黑曜石 §8x6",
                    "§f喷溅型抗性提升药水 (10秒)",
                    "§7骷髅 蛋§8x2",
                    "§7僵尸 蛋§8x2"
            }),
    Healer(Rarity.COMMON,new ItemBuilder(Material.CAKE).toItemStack(),"医师",
            new String[]{
                    "§7喷溅型药水 - 治疗 §8x3",
                    "§7喷溅型药水 - 生命恢复 §8x2",
            }),
    Scout(Rarity.COMMON,ItemUtil.addPotionEffect(new Potion(PotionType.SPEED).splash().toItemStack(1),new PotionEffect(PotionEffectType.SPEED,20*15,1)),"侦察兵",
            new String[]{
                    "§7喷溅性药水 - 速度 §8x3"
            }),
    Princess(Rarity.RARE,new ItemBuilder(Material.RED_ROSE).toItemStack(),"公主",
            new String[]{
                    "§7金头盔",
                    "   §8· 保护 I",
                    "§7弓",
                    "   §8· 火失 I",
                    "§7箭"
            }),
    Engineer(Rarity.RARE,new ItemBuilder(Material.REDSTONE).toItemStack(),"工程师",
            new String[]{
                    "§7绊线钩 §8x2",
                    "§7蜘蛛网 §8x8",
                    "§7活塞 §8x4",
                    "§7粘液球 §8x4",
                    "§7红石 §8x16",
                    "§7拉杆",
                    "§7发射器 §8x2",
            }),
    Salmon(Rarity.LEGENDARY,new ItemBuilder(Material.RAW_FISH,1,(byte)1).toItemStack(),"鲑鱼",
            new String[]{
                    "§7钻石靴子",
                    "   §8· 深海探索者 III",
                    "§7水桶 §8x3"
            }),
    PigRider(Rarity.RARE,new ItemBuilder(Material.CARROT_STICK).toItemStack(),"野猪骑士",
            new String[]{
                    "§7鞍",
                    "§7猪 蛋",
                    "§7金头盔",
                    "   §8· 保护 IV",
                    "§7胡萝卜钓竿"
            }),
    Slime(Rarity.LEGENDARY,new ItemBuilder(Material.SLIME_BLOCK).toItemStack(),"史莱姆",
            new String[]{
                    "§7铁靴子",
                    "   §8· 摔落保护 IV",
                    "§7史莱姆块 §8x16"
            }),
    Jester(Rarity.LEGENDARY,new ItemBuilder(Material.DIAMOND_SWORD).toItemStack(),"小丑",
            new String[]{
                    "§7随机的剑",
                    "§7喷溅型药水 - 生命恢复"
            }),
    Zookeeper(Rarity.LEGENDARY,new ItemBuilder(Material.MONSTER_EGG).toItemStack(),"饲养员",
            new String[]{
                    "§dMystery Egg §8x3"
            }),
    Sloth(Rarity.RARE,ItemUtil.addPotionEffect(new Potion(PotionType.SLOWNESS).toItemStack(1),new PotionEffect(PotionEffectType.SLOW,20*5,1)),"小树懒",
            new String[]{
                    "§7树懒药水 §8x3",
                    "§7皮革帽子",
                    "§7皮革外套",
                    "§7皮革裤子",
                    "§7皮革靴子",
                    "§7丛林木 §8x4",
                    "§7永久受到缓慢II影响",
            }),
    Magician(Rarity.RARE,ItemUtil.addPotionEffect(new Potion(PotionType.INVISIBILITY).splash().toItemStack(1),new PotionEffect(PotionEffectType.INVISIBILITY,20*15,1)),"魔术师",
            new String[]{
                    "§7兔子 蛋",
                    "§7皮革帽子",
                    "§7魔术师药水 §8x2",
                    "§7法杖",
                    "   §8· 锋利 IV"
            }),
    EnderMan(Rarity.LEGENDARY,ItemUtil.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E1OWJiMGE3YTMyOTY1YjNkOTBkOGVhZmE4OTlkMTgzNWY0MjQ1MDllYWRkNGU2YjcwOWFkYTUwYjljZiJ9fX0="),"末影领主",
            new String[]{
                    "§cWaiting Editor..."
            });

    @Getter
    private final String DBName;
    @Getter
    private final ItemStack item;
    @Getter
    private final String[] lore;
    @Getter
    private final Rarity rarity;

    public ItemStack getItem(Player player,GameMode gm){
        ItemUtil.addItemFlag(item, ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> re = new ArrayList<>(Arrays.asList(lore));
        re.addAll(Arrays.asList("","§7稀有度: "+rarity.getDisplayname()));
        if(DataUtils.getInt(player, Data.field.ISBOUGHT, gm,this) == 1){
            re.add("§a已解锁");
        }else{
            re.add("§7花费: §6"+ MathUtils.Format(getRarity().getKitprice()));
            re.add("§b也可以通过灵魂之井获得!");
        }
        re.add("");
        re.add("§e点击查看");
        ItemUtil.reloreItem(item,re.toArray(new String[0]));
        ChatColor cc = ChatColor.GREEN;
        if(DataUtils.getInt(player, Data.field.ISBOUGHT,gm,this) == 0) cc = ChatColor.RED;
        ItemUtil.renameItem(item,cc+getDBName());
        return item;
    }
    KitType(Rarity rarity,ItemStack itemStack,String DBName, String[] lore){
        this.rarity = rarity;
        this.item = itemStack;
        this.DBName = DBName;
        this.lore = lore;
    }
    /*
    public static ArrayList<KitType> valuesasList(){
        ArrayList<KitType> result = new ArrayList<>();
        for(KitType kitType:values()){
            result.add(kitType);
        }
        return result;
    }

     */
}
