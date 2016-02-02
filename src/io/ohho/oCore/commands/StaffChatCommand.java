package io.ohho.oCore.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class StaffChatCommand
implements CommandExecutor {
    private List<String> chatters = new ArrayList<String>();

    private boolean canUseAdminChat(CommandSender sender) {
        if (sender.hasPermission("oCore.staff") || sender.isOp()) {
            return true;
        }
        return sender.isOp();
    }

    private String buildMessage(String[] args, int start) {
        StringBuilder msg = new StringBuilder();
        int i = start;
        while (i < args.length) {
            if (i != start) {
                msg.append(" ");
            }
            msg.append(args[i]);
            ++i;
        }
        return msg.toString();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        String msg = this.buildMessage(args, 0);
        if (commandLabel.equalsIgnoreCase("sc") || commandLabel.equalsIgnoreCase("ac")) {
            if (this.canUseAdminChat(sender)) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("toggle")) {
                        if (!(sender instanceof Player)) {
                            sender.sendMessage("[oCore] Console can't use the toggle!");
                            return false;
                        }
                        if (this.chatters.contains(sender.getName())) {
                            this.chatters.remove(sender.getName());
                            sender.sendMessage((Object)ChatColor.RED+ "(" + ChatColor.BLUE + "SC" + (Object)ChatColor.RED + ") " + (Object)ChatColor.RED + "The toggle has been disabled!");
                        } else {
                            this.chatters.add(sender.getName());
                            sender.sendMessage((Object)ChatColor.RED + "(" + ChatColor.BLUE + "SC" + (Object)ChatColor.RED + ") " + (Object)ChatColor.GREEN + "The toggle has been enabled!");
                        }
                        return true;
                    }
                    this.sendToChat(msg, sender);
                } else {
                    sender.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <message>");
                }
            } else {
                sender.sendMessage((Object)ChatColor.RED + "You don't have permission to execute this command!");
            }
        }
        return false;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (this.chatters.contains(event.getPlayer().getName())) {
            this.sendToChat(event.getMessage(), (CommandSender)event.getPlayer());
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String pname = event.getPlayer().getName();
        if (this.chatters.contains(pname)) {
            this.chatters.remove(pname);
        }
    }

    @SuppressWarnings({ "unused", "deprecation" })
	private void sendToChat(String msg, CommandSender sender) {
        String pname = sender.getName();
        if (sender instanceof Player) {
            pname = ((Player)sender).getName();
        }
        Player[] arrplayer = Bukkit.getServer().getOnlinePlayers();
        int n = arrplayer.length;
        int n2 = 0;
        while (n2 < n) {
            Player p = arrplayer[n2];
            if (this.canUseAdminChat((CommandSender)p)) {
                p.sendMessage((Object)ChatColor.RED+ "(" + ChatColor.BLUE + "SC" + (Object)ChatColor.RED + ") " + sender.getName() + ChatColor.GRAY + ": " + ChatColor.translateAlternateColorCodes((char)'&', (String)msg));
            }
            ++n2;
        }
    }
}

