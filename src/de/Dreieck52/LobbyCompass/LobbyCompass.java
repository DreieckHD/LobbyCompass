package de.Dreieck52.LobbyCompass;

import net.gravitydevelopment.updater.Updater;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyCompass extends JavaPlugin {

	public static String prefix = "§f[§eCompass§f] ";
	
	public static String use_Permission = "lobbycompass.use";
	public static String get_Permission = "lobbycompass.get";
	public static String admin_Permission = "lobbycompass.admin";
	
	@Override
	public void onEnable() {
		
		getCommand("lobbycompass").setExecutor(new LobbyCompassCommand(this));
		Bukkit.getPluginManager().registerEvents(new LobbyCompassCommand(this), this);
		
		getConfig().options().header(
				"#############################################" + "\n" +
				"#      - LobbyCompass by Dreieck52 -        #" + "\n" +
				"#############################################" + "\n" +
				"# Option 'executedByPlayer' means:" + "\n" +
				"#    > true = Command is executed as the player typed it" + "\n" +
				"#    > false = Command is executed by console (%n% is player name)" + "\n" +
				"# There can be only at most 6 lines in one inventory!" + "\n" +
				"# If get-compass-on-join-slot is -1 it will add the compass in a free slot" + "\n" +
				"# NOTE: If you wish, you can disable auto-updating in -Updater/config.yml-" + "\n" +
				"#############################################" + "\n"
		);
		
		getConfig().addDefault("compass-name", "&f&lClick this to open warp menu!");
		getConfig().addDefault("compass-inventory-name", "&a&lAWESOME Warp-Compass Oo");
		getConfig().addDefault("get-compass-on-join", true);
		getConfig().addDefault("get-compass-on-join-slot", 4);
		getConfig().addDefault("get-compass-worlds", new String[] { "world", "world_nether", "world_the_end" });
		getConfig().addDefault("only-allow-command-lc_get-in-worlds", true);
		getConfig().addDefault("can-drop-compass", false);
		getConfig().addDefault("inventory-lines-amount", 5);
		getConfig().addDefault("sound-effect", true);
		
		getConfig().addDefault("options", new String[] { "spawn", "pvp" });
		
		getConfig().addDefault("data.spawn.name", "&e&lSpawn");
		getConfig().addDefault("data.spawn.lore", new String[] { "&7Teleport back to spawn", "&8&l/warp spawn" });
		getConfig().addDefault("data.spawn.item", 347);
		getConfig().addDefault("data.spawn.cmd", "warp spawn");
		getConfig().addDefault("data.spawn.executedByPlayer", true);
		getConfig().addDefault("data.spawn.position-in-inventory", 22);
		
		getConfig().addDefault("data.pvp.name", "&c&lSurvival Games");
		getConfig().addDefault("data.pvp.lore", new String[] { "&cD&ei&as&bc&do", "&8&lCompete with friends or foes in this thrilling game" });
		getConfig().addDefault("data.pvp.item", 267);
		getConfig().addDefault("data.pvp.cmd", "warp survivalgames");
		getConfig().addDefault("data.pvp.executedByPlayer", true);
		getConfig().addDefault("data.pvp.position-in-inventory", 20);
		
		getConfig().options().copyHeader(true);
		getConfig().options().copyDefaults(true);
		
		saveConfig();
		reloadConfig();
		
		@SuppressWarnings("unused")
		Updater updater = new Updater(this, 82437, getFile(), Updater.UpdateType.DEFAULT, true);
		
	}
	
	@Override
	public void onDisable() {
		
		
		
	}
	
}
