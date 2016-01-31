package io.ohho.oCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CoordsCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3)
  {
    if (cmd.getName().equalsIgnoreCase("coords"))
    {
      Player p = (Player)sender;
      p.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "                                                   ");
      p.sendMessage(ChatColor.YELLOW + "Server Coordinates for " + ChatColor.YELLOW + "Map " + ChatColor.GOLD + Main.getInstance().getConfig().getString("mapnumber"));
      p.sendMessage(ChatColor.GREEN + "Spawn: " + ChatColor.GRAY + Main.getInstance().getConfig().getString("spawncoord") + ChatColor.YELLOW + " (Overworld)");    
      p.sendMessage(ChatColor.GREEN + "End Portals: " + ChatColor.GRAY + Main.getInstance().getConfig().getString("endcoord") + ChatColor.YELLOW + " (Overworld)");
      p.sendMessage(ChatColor.GREEN + Main.getInstance().getConfig().getString("koth1") + ChatColor.LIGHT_PURPLE + " KOTH: " + ChatColor.GRAY + Main.getInstance().getConfig().getString("kothcoord1") + ChatColor.YELLOW + " (Overworld)" + ChatColor.GRAY + " (All Quadrants)"); 
      p.sendMessage(ChatColor.GREEN + Main.getInstance().getConfig().getString("koth2") + ChatColor.LIGHT_PURPLE + " KOTH: " + ChatColor.GRAY + Main.getInstance().getConfig().getString("kothcoord2") + ChatColor.YELLOW + " (Overworld)");
      p.sendMessage(ChatColor.GREEN + Main.getInstance().getConfig().getString("koth3") + ChatColor.LIGHT_PURPLE + " KOTH: " + ChatColor.GRAY + Main.getInstance().getConfig().getString("kothcoord3") + ChatColor.YELLOW + " (Overworld)"); 
      p.sendMessage(ChatColor.GREEN + Main.getInstance().getConfig().getString("endkoth") + ChatColor.LIGHT_PURPLE + " KOTH: " + ChatColor.GRAY + Main.getInstance().getConfig().getString("endkothcoord" + ChatColor.YELLOW + " (End)"));
      p.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "                                                   ");

    }
    return false;
  }
}
