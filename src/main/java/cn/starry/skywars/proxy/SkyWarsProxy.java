package cn.starry.skywars.proxy;

import cn.starry.skywars.proxy.command.MainCommand;
import cn.starry.skywars.proxy.database.SQLSettings;
import cn.starry.skywars.proxy.listener.*;
import cn.starry.skywars.proxy.manager.NPCManager;
import cn.starry.skywars.proxy.manager.PlayerManager;
import cn.starry.skywars.proxy.support.placeholderapi.PapiExpansion;
import cn.starry.skywars.proxy.util.Config;
import cn.starry.skywars.proxy.database.DataBase;
import cn.starry.skywars.proxy.util.inventory.UIListener;
import lombok.Getter;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class SkyWarsProxy extends JavaPlugin {

    @Getter
    private static DataBase dataBase;
    @Getter
    private PlayerManager playerManager;
    @Getter
    private static SkyWarsProxy instance;
    public static Config config;

    @Override
    public void onEnable() {
        instance = this;
        regListener();
        regCommand();
        regclass();
        regMysql();
        boolean isPapi = Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
        if (isPapi) {
            new PapiExpansion().register();
        }
    }

    void regListener(){
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Arrays.asList(
                new NPCManager(),
                new PlayerListener(),
                new PlayerChatListener(),
                new PlayerInteractListener(),
                new UIListener(),
                new WorldListener()
        ).forEach(listener -> Bukkit.getPluginManager().registerEvents(listener,this));
    }

    void regCommand(){
        registerCommand(new MainCommand());
    }

    void regclass(){
        //scoreBoardManager = new ScoreBoardManager();
        playerManager = new PlayerManager();
    }
    void configload(){
        if(!getDataFolder().exists()){
            getDataFolder().mkdir();
        }
        File config = new File(this.getDataFolder(),"config.yml");
        if(!config.exists()) {
            try {
                config.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        this.config = new Config(config);

    }
    void regMysql(){
        dataBase = DataBase.create(new MemoryConfiguration(){{
            set("ip","localhost");
            set("port",3306);
            set("database","skywars");
            set("username","skywars");
            set("password","n8w34j3Fh44xJeEt");
        }});
        dataBase.createTables("playerinfo", SQLSettings.KV_PLAYERINFO, null);
        dataBase.createTables("kit", SQLSettings.KV_KIT, null);
        dataBase.createTables("perk", SQLSettings.KV_PERK, null);
    }

    private void registerCommand(Command cmd) {
        MinecraftServer.getServer().server.getCommandMap().register(cmd.getName(), this.getName(), cmd);
    }

}
