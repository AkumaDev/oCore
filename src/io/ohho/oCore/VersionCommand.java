package io.ohho.oCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class VersionCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3)
  {
    if (cmd.getName().equalsIgnoreCase("oCore"))
    {
      Player p = (Player)sender;
      p.sendMessage(ChatColor.YELLOW + "This server is running oCore version: " + ChatColor.GRAY + "1.0-beta");

    }
    return false;
  }
}
