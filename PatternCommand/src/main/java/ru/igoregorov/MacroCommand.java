package ru.igoregorov;
import java.util.List;

public class MacroCommand implements Command {
    private final List<Command> commandList;
    public MacroCommand(List<Command> commandList) {
        this.commandList = commandList;
    }
    @Override
    public void execute() throws CommandException {
        if (commandList == null) {
            return;
        }
        for (Command command : commandList) {
            command.execute();
        }
    }
}
