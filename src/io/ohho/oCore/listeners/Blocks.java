package io.ohho.oCore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;

public class Blocks implements Listener 
	{

	  @EventHandler
	  public void joinWhenFull(PlayerLoginEvent e)
	  {
	    if ((e.getResult() == PlayerLoginEvent.Result.KICK_FULL) && (e.getPlayer().hasPermission("oCore.donator"))) {
	      e.allow();
	    }
	  }
	  
	  @EventHandler
	  public void goldenAppleCraft(CraftItemEvent event)
	  {
	    ItemStack itm = event.getRecipe().getResult();
	    Player player = (Player)event.getView().getPlayer();
	    @SuppressWarnings("deprecation")
		int id = itm.getTypeId();
	    if (id != 322) {
	      return;
	    }
	    player.sendMessage(ChatColor.RED + "Golden apples are disabled.");
	    event.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void goldenAppleEat(PlayerItemConsumeEvent event)
	  {
	    Player player = event.getPlayer();
	    if (event.getItem().getType().equals(Material.GOLDEN_APPLE))
	    {
	      player.sendMessage(ChatColor.RED + "Golden apples are disabled.");
	      event.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void enderChestCraft(CraftItemEvent event)
	  {
	    ItemStack itm = event.getRecipe().getResult();
	    Player player = (Player)event.getView().getPlayer();
	    @SuppressWarnings("deprecation")
		int id = itm.getTypeId();
	    if (id != 130) {
	      return;
	    }
	    player.sendMessage(ChatColor.RED + "Ender chests are disabled.");
	    event.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void enderChestPlace(BlockPlaceEvent event)
	  {
	    Player player = event.getPlayer();
	    Block block = event.getBlockPlaced();
	    @SuppressWarnings("deprecation")
		int id = block.getTypeId();
	    if (id != 130) {
	      return;
	    }
	    player.sendMessage(ChatColor.RED + "Ender chests are disabled.");
	    event.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void enderChestInteract(PlayerInteractEvent event)
	  {
	    Player player = event.getPlayer();
	    if ((event.getAction() != Action.RIGHT_CLICK_BLOCK) || (event.getClickedBlock().getType() != Material.ENDER_CHEST)) {
	      return;
	    }
	    player.sendMessage(ChatColor.RED + "Ender chests are disabled.");
	    event.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void tntPlace(BlockPlaceEvent event)
	  {
	    Player player = event.getPlayer();
	    Block block = event.getBlockPlaced();
	    @SuppressWarnings("deprecation")
		int id = block.getTypeId();
	    if (id != 46) {
	      return;
	    }
	    player.sendMessage(ChatColor.RED + "TNT is disabled.");
	    event.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void tntCraft(CraftItemEvent event)
	  {
	    ItemStack itm = event.getRecipe().getResult();
	    Player player = (Player)event.getView().getPlayer();
	    @SuppressWarnings("deprecation")
		int id = itm.getTypeId();
	    if (id != 46) {
	      return;
	    }
	    player.sendMessage(ChatColor.RED + "TNT is disabled.");
	    event.setCancelled(true);
	  }
	
}
