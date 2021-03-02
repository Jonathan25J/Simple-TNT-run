package jonaqhan.TntRun.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import jonaqhan.TntRun.Main;
import jonaqhan.TntRun.remove.Walked;
import jonaqhan.TntRun.tools.Chat;

public class Tnt implements Listener {

	private static Main plugin;

	public Tnt(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler

	public void Player(PlayerMoveEvent e) {

		Player p = e.getPlayer();

		Location loc = p.getLocation();

		Location block1c = new Location(loc.getWorld(), loc.getX(), loc.getY() - 1, loc.getZ());

		Material block1 = block1c.getBlock().getType();

		Location block2c = new Location(loc.getWorld(), loc.getX(), loc.getY() - 2, loc.getZ());

		Material block2 = block2c.getBlock().getType();

		if (block1 == Material.SAND && block2 == Material.TNT && plugin.getConfig().getString("TNT-run.status").equalsIgnoreCase("true")) {

			Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
				public void run() {
					Walked.stats(block1c, block2c, p);
				}
			}, 12L);

		}

	}

}
