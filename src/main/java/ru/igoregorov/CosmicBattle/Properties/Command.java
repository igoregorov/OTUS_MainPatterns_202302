package ru.igoregorov.CosmicBattle.Properties;

import ru.igoregorov.exceptions.CommandException;

public interface Command {
    void execute() throws CommandException;
}