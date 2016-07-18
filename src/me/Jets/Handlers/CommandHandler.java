package me.Jets.Handlers;

import java.util.Arrays;

import me.Jets.Commands.JetCommands;
import me.Jets.Commands.MainCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHandler {
	public static boolean execute(CommandSender sender, Command cmd,
			String[] args) {

		String label = cmd.getLabel();

		for (Class<? extends Enum<?>> c : Arrays.asList(JetCommands.class, MainCommands.class)) {
			try {
				if ((boolean) c.getMethod("contains", String.class).invoke(null, label)) {
					switch () {
					
					}
				}
			} catch (NoSuchMethodException e) {
				return false;
			} catch (ReflectiveOperationException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
		if (MainCommands.contains(label)) {
			
			return true;
		} else if (JetCommands.contains(label)){
			
			return true;
		}
		
		return false;
	}
}
