package com.runbox.debug.command.execute;

import com.runbox.debug.Debugger;

/**
 * Created by qstesiro
 */
public class ExecuteQuitCommand extends ExecuteCommand {

    public ExecuteQuitCommand(String command) throws Exception {
        super(command);
    }

    @Override
    public boolean execute() throws Exception {
        Debugger.instance().flag(Debugger.QUIT);
        return false;
    }

    @Override
    public void help() {
        String help = "\r\n";
        help += "description\r\n";
        help += "";
        help += "note";
        help += "";
        help += "example";
        help += "";
        System.out.println(help);
    }
}
