package io.ohho.oCore;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Help
  implements Listener
{
  @EventHandler
  public void onHelpView(PlayerCommandPreprocessEvent event)
  {
    String[] disabledStrings = {
      "help", "plugins", "pl", "a", "about", "?", "ver", "bukkit:ver", "bukkit:pl", "bukkit:plugin", "bukkit:a", "bukkit:?" };
    String[] arrayOfString1;
    int j = (arrayOfString1 = disabledStrings).length;
    for (int i = 0; i < j; i++)
    {
      String disabledString = arrayOfString1[i];
      if (event.getMessage().equalsIgnoreCase("/" + disabledString))
      {
    	event.getPlayer().sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "                                                   ");
    	event.getPlayer().sendMessage(ChatColor.YELLOW + "Map: " + ChatColor.GOLD + Main.getInstance().getConfig().getString("mapnumber"));
    	event.getPlayer().sendMessage(ChatColor.YELLOW + " Warzone Claim: " + ChatColor.GRAY + Main.getInstance().getConfig().getString("warzone"));
    	event.getPlayer().sendMessage(ChatColor.GREEN + " World Sizes: ");
    	event.getPlayer().sendMessage(ChatColor.BLUE + "  Normal " + ChatColor.GRAY + Main.getInstance().getConfig().getString("normalborder"));
    	event.getPlayer().sendMessage(ChatColor.BLUE + "  Nether " + ChatColor.GRAY + Main.getInstance().getConfig().getString("netherborder"));
    	event.getPlayer().sendMessage(ChatColor.BLUE + "  End " + ChatColor.GRAY + Main.getInstance().getConfig().getString("endborder"));
        event.getPlayer().sendMessage(ChatColor.GREEN + " Teamspeak " + ChatColor.BLUE + Main.getInstance().getConfig().getString("teamspeak"));
        event.getPlayer().sendMessage(ChatColor.GREEN + " Website " + ChatColor.BLUE + Main.getInstance().getConfig().getString("website"));
        event.getPlayer().sendMessage(ChatColor.GREEN + " Forums " + ChatColor.BLUE + Main.getInstance().getConfig().getString("forums"));
        event.getPlayer().sendMessage(" ");
        event.getPlayer().sendMessage(ChatColor.YELLOW + "Any other help, please contact a staff member.");
        event.getPlayer().sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "                                                   ");
        event.setCancelled(true);
      }
    }
  }
}