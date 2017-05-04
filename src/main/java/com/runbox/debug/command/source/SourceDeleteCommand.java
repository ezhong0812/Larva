package com.runbox.debug.command.source;

import java.util.LinkedList;
import java.util.List;

import com.runbox.debug.command.Command;
import com.runbox.debug.manager.SourceManager;

public class SourceDeleteCommand extends Command {

    public SourceDeleteCommand(String command) throws Exception {
        super(command);
        if (null == argument()) {
            throw new Exception("invalid argument");
        }
    }

    @Override
    public boolean execute() throws Exception {
        for (Integer number : numbers()) {
            if (!SourceManager.instance().delete(number)) {
                System.out.println("invalid number/" + number);
            }
        }
        return super.execute();
    }

    private List<Integer> numbers() {
        List<Integer> numbers = new LinkedList<Integer>();
        for (String number : argument().split(",")) {
            numbers.add(Integer.valueOf(number.trim()));
        }
        return numbers;
    }
}