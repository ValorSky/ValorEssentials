package fr.kalipso.hexael.utils.command;

import fr.kalipso.hexael.hEssentials;
import lombok.Getter;

import java.io.IOException;

public abstract class ICommand {

	@Getter private hEssentials instance;

	public ICommand()
	{
		instance = hEssentials.getInstance();
	}

	public abstract void onCommand(CommandArgs args) throws IOException;
}

