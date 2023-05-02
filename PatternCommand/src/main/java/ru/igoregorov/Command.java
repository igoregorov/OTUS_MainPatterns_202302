package ru.igoregorov;

public interface Command {
    void execute() throws CommandException;
}
