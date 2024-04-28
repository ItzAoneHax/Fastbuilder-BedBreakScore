package pies.FBBedBreak;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import pies.FastbuilderAPI.FastbuilderProvider;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    void a(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (!FastbuilderProvider.getApi().getManager().isPlaying(player)) return;
        if (e.getBlock().getType() == Material.BED_BLOCK) {
            FastbuilderProvider.getApi().getManager().resetPlayer(player, true, true);
        }
    }
}
