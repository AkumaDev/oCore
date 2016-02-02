package io.ohho.oCore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.ohho.oCore.Main;

public class RulesCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3)
  {
    if (cmd.getName().equalsIgnoreCase("rules"))
    {
      Player p = (Player)sender;
      p.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "                                                   ");
      p.sendMessage(ChatColor.RED + Main.getInstance().getConfig().getString("rule1"));
      p.sendMessage(ChatColor.RED + Main.getInstance().getConfig().getString("rule2"));
      p.sendMessage(ChatColor.RED + Main.getInstance().getConfig().getString("rule3"));
      p.sendMessage(ChatColor.RED + Main.getInstance().getConfig().getString("rule4"));
      p.sendMessage(ChatColor.RED + Main.getInstance().getConfig().getString("rule5"));
      p.sendMessage(ChatColor.RED + Main.getInstance().getConfig().getString("rule6"));
      p.sendMessage(ChatColor.RED + Main.getInstance().getConfig().getString("rule7"));
      p.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "                                                   ");

    }
    return false;
  }
}
