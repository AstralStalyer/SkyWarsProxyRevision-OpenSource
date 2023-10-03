package cn.starry.skywars.proxy.util;

import cn.starry.skywars.proxy.SkyWarsProxy;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;

public class BungeeUtil {
    public static void sendPlayer(Player p,String server){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        p.sendPluginMessage(SkyWarsProxy.getInstance(),"BungeeCord",out.toByteArray());
    }
}
