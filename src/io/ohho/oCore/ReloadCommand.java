package io.ohho.oCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("oCore reload"))
    {
      if (!sender.hasPermission("ohho.reload"))
      {
        sender.sendMessage(ChatColor.RED + "You do not have permssion for that command.");
        return true;
      }
      Player p = (Player)sender;
      p.sendMessage(ChatColor.YELLOW + "oCore has been reloaded." + ChatColor.GRAY + (" (/help, /rules, /coords)"));
      Main.getInstance().reloadConfig();
    }
    return true;
  }
}
