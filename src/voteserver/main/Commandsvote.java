package voteserver.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandsvote implements CommandExecutor 
{
    @SuppressWarnings("unused")
	private final main plugin;
    
    public Commandsvote(main plugin)
    {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
    	if (!(sender instanceof Player)) {
            sender.sendMessage("Vote only player!");
            return true;
        }
        
        Player player = (Player) sender;
        
        if (args.length != 1)
            return false;
        
        votelogic vtlogic = main.getPlugin(main.class).getVotelogic();
        
        if (args[0].equalsIgnoreCase("yes")) 
        {
        	vtlogic.vote(player, true);
        } 
        else if (args[0].equalsIgnoreCase("no")) 
        {
        	vtlogic.vote(player, false);
        } 
        else 
        {
        	return false;
        }
        
        return true;
    }
}
