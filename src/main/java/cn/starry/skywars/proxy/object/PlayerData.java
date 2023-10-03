package cn.starry.skywars.proxy.object;

import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@Data
public class PlayerData {

    UUID uuid;
    Board board;
    Boolean inNoob = false;

    public PlayerData(UUID uuid){
        this.uuid = uuid;
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(uuid);
    }
}
