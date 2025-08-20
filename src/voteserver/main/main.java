package voteserver.main;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin 
{
	@SuppressWarnings("unused")
	private votelogic vtlogic;
	
    @Override
    public void onEnable() 
    {
    	vtlogic = new votelogic(this);
    	getLogger().info("Plugin Enable!");
    	
    	if (getCommand("vote") == null || getCommand("voterestart") == null)
    	{
    		getLogger().info("Commands not initialization! Check plugin.yml !");
    		return;
    	}
    		
        getCommand("vote").setExecutor(new Commandsvote(this));
        getCommand("voterestart").setExecutor(new voterestart(this));
    }
    
    @Override
    public void onDisable() 
    {
    	getLogger().info("Plugin Disable!");
    }
    
    public votelogic getVotelogic() 
    {
        return vtlogic; 
    }
}