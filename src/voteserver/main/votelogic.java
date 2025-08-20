package voteserver.main;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class votelogic 
{
    private boolean isVoteActive = false;
    private Map<UUID, Boolean> votes = new HashMap<>();
    private JavaPlugin plugin;
    
    public votelogic(main plugin) 
    {
    	this.plugin = plugin;
	}

	public void startVote() 
    {
        if (isVoteActive) return;
        
        isVoteActive = true;
        votes.clear();
        
        Bukkit.broadcastMessage("§l§eVote restart server!");
        Bukkit.broadcastMessage("/vote yes - Restart");
        Bukkit.broadcastMessage("/vote no - Not restart");
    
        startVoteTimer();
    }
    
    private void startVoteTimer() 
    {
        for (int i = 30; i > 0; i--) 
        {
            final int secondsLeft = i;
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                if (isVoteActive) 
                {
                    if (secondsLeft % 10 == 0 || secondsLeft <= 5) 
                    {
                        Bukkit.broadcastMessage("§l§eVote restart server will end in " + secondsLeft + " seconds!");
                    }
                    
                    if (secondsLeft == 1) 
                    {
                        endVote();
                    }
                }
            }, (30 - i) * 20L); 
        }
    }
    
    public boolean vote(Player player, boolean voteFor) 
    {
        if (!isVoteActive) 
        {
            player.sendMessage("Now not active voting!");
            return false;
        }
        
        if (votes.containsKey(player.getUniqueId())) 
        {
            player.sendMessage("You is already voted");
            return false;
        }
        
        votes.put(player.getUniqueId(), voteFor);
        player.sendMessage("You vote " + (voteFor ? "yes" : "no"));
        return true;
    }
    
    private void endVote() 
    {
        isVoteActive = false;
        
        int yes = 0, no = 0;
        for (Boolean vote : votes.values()) 
        {
            if (vote) yes++; else no++;
        }
        
        int total = yes + no;
        
        Bukkit.broadcastMessage("§e§lVote restart server end!");
        
        if (yes > no && total > 0) 
        {
            Bukkit.broadcastMessage("§e§lRestart server...");
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();  
            String command = "stop";  
            Bukkit.dispatchCommand(console, command);  
        } 
        else 
        {
            Bukkit.broadcastMessage("§c§lRestart server rejected!");
        }
    }
    
    public boolean isVoteActive() 
    {
        return isVoteActive;
    }
}