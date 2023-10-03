package cn.starry.skywars.proxy.manager;

import cn.starry.skywars.proxy.object.PlayerData;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {
    HashMap<UUID, PlayerData> data = new HashMap<>();
    public PlayerData add(Player p){
        if(!data.containsKey(p.getUniqueId())) {
            PlayerData pd = new PlayerData(p.getUniqueId());
            data.put(p.getUniqueId(), pd);
        }
        return data.get(p.getUniqueId());
    }
    public PlayerData get(Player p){
        return data.containsKey(p.getUniqueId()) ? data.get(p.getUniqueId()):add(p);
    }
    public void remove(Player p){
        if(data.containsKey(p.getUniqueId())) data.remove(p.getUniqueId());
    }
}
