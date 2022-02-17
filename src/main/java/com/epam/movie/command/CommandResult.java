package com.epam.movie.command;

public class CommandResult {
    private final String path;
    private final boolean isRedirect;

    public CommandResult(String path, boolean isRedirect) {
        this.path = path;
        this.isRedirect = isRedirect;
    }

    public String getPath() {
        return path;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public static CommandResult forward (String path) {
        return new CommandResult(path, false);
    }

    public static CommandResult redirect (String path) {
        return new CommandResult(path, true);
    }
}
