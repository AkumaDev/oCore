package io.ohho.oCore;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import io.ohho.oCore.RulesCommand;
import io.ohho.oCore.listeners.Blocks;
import io.ohho.oCore.listeners.EnderpearlListener;
import io.ohho.oCore.listeners.SpawnTag.SpawnTagHandler;

public class Main
  extends JavaPlugin
{
  public final Server server = getServer();
  public final PluginManager pm = this.server.getPluginManager();
  public static Main main;
  public static Main plugin;
  
  public void onEnable()
  {	 
    getCommand("rules").setExecutor(new RulesCommand());
    getCommand("commandsreload").setExecutor(new ReloadCommand());;
    getCommand("cc").setExecutor(new ClearChatCommand());;
    getCommand("coords").setExecutor(new CoordsCommand());
    loadConfig();
    getLogger().info("oCore has been enabled without bugs");
    main = this;
    this.pm.registerEvents(new Help(), this);
    pm.registerEvents(new Blocks(), this);
    pm.registerEvents(new EnderpearlListener(), this);
    pm.registerEvents((Listener) new SpawnTagHandler(), this);
  }
  
  public void onDisable() {}
  
  public static Main getInstance()
  {
    return main;
  }
  
  public void loadConfig()
  {
    if (!getDataFolder().exists())
    {  
      getConfig().set("coordscommand", "Please use /f i <koth name>");
      
      getConfig().set("mapnumber", "11");
      getConfig().set("warzone", "800");
      getConfig().set("normalborder", "3000");
      getConfig().set("netherborder", "3000");
      getConfig().set("endborder", "3000");
      getConfig().set("teamspeak", "ts.ParaPvP.com");
      getConfig().set("website", "http://www.ParaPvP.com");
      getConfig().set("forums", "http://parapvp.com/community");
      
      getConfig().set("rule1", "Be nice to ohho");
      getConfig().set("rule2", "Be nice to itsBlue");
      getConfig().set("rule3", "Be nice to Raft");
      getConfig().set("rule4", "Be nice to Glove");
      getConfig().set("rule5", "Be nice to Boog");
      getConfig().set("rule6", "Be nice to BeSocial");
      getConfig().set("rule7", "Be nice to Everyone");
      
      
      getConfig().set("spawncoord", "0, 0");
      getConfig().set("endcoord", "500, 500");
      getConfig().set("koth1", "This is KoTH 1");
      getConfig().set("koth2", "This is KoTH 2");
      getConfig().set("koth3", "This is KoTH 3");
      getConfig().set("kothcoord1", "0, 0");
      getConfig().set("kothcoord2", "0, 0");
      getConfig().set("kothcoord3", "0, 0");
      getConfig().set("endkoth", "End");
      getConfig().set("endkothcoords", "0, 0");
      
      getConfig().set("koth1time", "koth1time");
      getConfig().set("koth2time", "koth2time");
      getConfig().set("koth3time", "koth3time");
      getConfig().set("kothendtime", "kothendtime");
      
      getConfig().set("koth1day", "koth1day");
      getConfig().set("koth2day", "koth2day");
      getConfig().set("koth3day", "koth3day");
      getConfig().set("kothendtime", "kothendday");
      
      getConfig().set("scoreboardtitle", "HCPots");
      saveConfig();
    }
  }
}
