package cn.starry.skywars.proxy.database;

public class SQLSettings {
    public static final KeyValue KV_PLAYERINFO = (new KeyValue("UUID", "VARCHAR(36) PRIMARY KEY"))
            .add("CurrentKit", "VARCHAR(40)")
            .add("Level", "VARCHAR(40)")
            .add("Experience", "VARCHAR(40)")
            .add("Coins", "VARCHAR(40)")
            .add("Tokens", "VARCHAR(40)")
            .add("Souls", "VARCHAR(40)")
            .add("Souls_Added", "VARCHAR(40)")
            .add("Blocks_Broken", "VARCHAR(40)")
            .add("Blocks_Placed", "VARCHAR(40)")
            .add("Soul_Well_Uses", "VARCHAR(40)")
            .add("Soul_Well_Legendaries", "VARCHAR(40)")
            .add("Soul_Well_Rares", "VARCHAR(40)")
            .add("Souls_Paid", "VARCHAR(40)")
            .add("Souls_Gathered", "VARCHAR(40)")
            .add("Eggs_Thrown", "VARCHAR(40)")
            .add("Kills", "VARCHAR(40)")  // 添加 Kills 列
            .add("Wins", "VARCHAR(40)");  // 添加 Wins 列

    public static final KeyValue KV_KIT = (new KeyValue("UUID", "VARCHAR(40)"))
            .add("KitName", "VARCHAR(40)")
            .add("isBought", "VARCHAR(40)")
            .add("Inventory", "VARCHAR(40)")
            .add("Time_Played", "VARCHAR(40)")
            .add("Fastest_Win", "VARCHAR(40)")
            .add("Most_Kills_in_a_Game", "VARCHAR(40)")
            .add("Mobs_Killed", "VARCHAR(40)")
            .add("Kills_by_Mobs", "VARCHAR(40)")
            .add("Bow_Longest_Kill", "VARCHAR(40)")
            .add("Bow_Longest_Shot", "VARCHAR(40)")
            .add("Wins", "VARCHAR(40)")
            .add("Chests_Opened", "VARCHAR(40)")
            .add("Heads_Gathered", "VARCHAR(40)")
            .add("Kills", "VARCHAR(40)")
            .add("Assists", "VARCHAR(40)")
            .add("Melee_Kills", "VARCHAR(40)")
            .add("Bow_Kills", "VARCHAR(40)")
            .add("Void_Kills", "VARCHAR(40)")
            .add("Bow_Hits", "VARCHAR(40)")
            .add("Bow_Shots", "VARCHAR(40)")
            .add("Enderperls_Thrown", "VARCHAR(40)");

    public static final KeyValue KV_PERK = (new KeyValue("UUID", "VARCHAR(40)"))
            .add("PerkName", "VARCHAR(40)")
            .add("PerkLevel", "VARCHAR(40)");
}

