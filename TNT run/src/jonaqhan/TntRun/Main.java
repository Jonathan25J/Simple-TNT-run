package jonaqhan.TntRun;

import org.bukkit.plugin.java.JavaPlugin;

import jonaqhan.TntRun.commands.TntRun;
import jonaqhan.TntRun.listeners.Tnt;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		new TntRun(this);
		new Tnt(this);
		saveDefaultConfig();
		
		
		
		
		
	}
	
	
	
}
