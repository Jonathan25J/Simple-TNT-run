package jonaqhan.TntRun.remove;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Walked {

	public static void stats(Location loc1, Location loc2, Player p) {

		loc1.getBlock().setType(Material.AIR);
		loc2.getBlock().setType(Material.AIR);

	}

}
