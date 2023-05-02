package ru.igoregorov;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    public void move(SomeThing obj, Double dx, Double dy) {
        CommandMove move = new CommandMove(obj, dx, dy);
        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(obj);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(obj);
        List<Command> commandList = new ArrayList<>();
        commandList.add(checkFuelCommand);
        commandList.add(move);
        commandList.add(burnFuelCommand);
        MacroCommand macroCommand = new MacroCommand(commandList);
        try {
            macroCommand.execute();
        } catch (CommandException e) {
            return;
        }
    }
}
