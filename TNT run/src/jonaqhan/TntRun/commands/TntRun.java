package jonaqhan.TntRun.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import jonaqhan.TntRun.Main;
import jonaqhan.TntRun.tools.Chat;

public class TntRun implements CommandExecutor, TabCompleter {

	private Main plugin;

	public TntRun(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("tntrun").setExecutor(this);

	}

	List<String> tab = new ArrayList<String>();

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {

		if (args.length == 1) {
			tab.add("true");
			tab.add("false");
			tab.add("status");
			return tab;
		}

		return null;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

		if (!(sender instanceof Player))
			return true;

		Player p = (Player) sender;
		
		if (args.length == 0) { 
			p.sendMessage(Chat.tools("&cNo arguments were given"));
			
			return true;
		}
		if (args.length > 1) {
			p.sendMessage(Chat.tools("&cOnly possibilities are true, false and status"));

			return true;
		}
		if (((args[0].equalsIgnoreCase("true")))) {

			plugin.getConfig().set("TNT-run.status", "true");

			p.sendMessage(Chat.tools("#C7411DTNT run#31F65C is now enabled"));

			plugin.saveConfig();

		} else if (((args[0].equalsIgnoreCase("false")))) {

			plugin.getConfig().set("TNT-run.status", "false");

			p.sendMessage(Chat.tools("#C7411DTNT run#31F65C is now disabled"));

			plugin.saveConfig();

		} else if (((args[0].equalsIgnoreCase("status")))) {

			if (plugin.getConfig().getString("TNT-run.status").equalsIgnoreCase("true"))
				p.sendMessage(Chat.tools("#C7411DTNT run#31F65C is enabled"));

			if (plugin.getConfig().getString("TNT-run.status").equalsIgnoreCase("false"))
				p.sendMessage(Chat.tools("#C7411DTNT run#31F65C is disabled"));

		} else
			p.sendMessage(Chat.tools("&cNo matches were found"));

		return false;
	}

}
