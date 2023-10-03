package cn.starry.skywars.proxy.runnable;

import cn.starry.skywars.proxy.object.Board;
import cn.starry.skywars.proxy.object.PlayerData;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public class ScoreBoardRunnable extends BukkitRunnable {
    PlayerData pd;
    String title;
    String[] strings;

    public ScoreBoardRunnable(PlayerData pd, String title, String[] strings) {
        this.pd = pd;
        this.title = title;
        this.strings = strings;
    }

    @Override
    public void run() {
        if (pd.getBoard() == null && pd.getPlayer() != null) pd.setBoard(new Board(pd.getPlayer()));
        pd.getBoard().send(title, Arrays.asList(strings));
    }
}
