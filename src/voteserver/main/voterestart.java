package voteserver.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class voterestart implements CommandExecutor 
{
    @SuppressWarnings("unused")
	private final main plugin;
    
    public voterestart(main plugin)
    {
        this.plugin = plugin;
    }
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
    	if(args.length != 0)
    		return false;
    	
    	votelogic vtlogic = plugin.getVotelogic();
        
        if (!vtlogic.isVoteActive()) {
        	vtlogic.startVote();
          //  sender.sendMessage("Vote restart server is !");
        } else {
            sender.sendMessage("Vote restart server is active!");
        }
        
        return true;	
    }
}
