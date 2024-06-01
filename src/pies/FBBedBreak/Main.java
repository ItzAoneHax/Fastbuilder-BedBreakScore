package pies.FBBedBreak;

import cf.pies.fastbuilder.api.FastbuilderPlayer;
import cf.pies.fastbuilder.api.FastbuilderProvider;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void blockBreakEvent(BlockBreakEvent event) {
        FastbuilderPlayer player = FastbuilderProvider.getApi().getPlayer(event.getPlayer());
        if (!player.isPlaying()) return;
        if (event.getBlock().getType() == Material.BED_BLOCK) {
            player.reset();
        }
    }
}
