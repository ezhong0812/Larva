package com.runbox.debug.command.template;

import com.runbox.debug.parser.expression.token.operand.ArrayOperand;
import com.runbox.debug.parser.expression.token.operand.Operand;
import com.sun.jdi.ArrayReference;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qstesiro
 */
public class TemplateStackCommand extends TemplateCommand {

    public TemplateStackCommand(String command) throws Exception {
        super(command);
    }

    @Override
    public boolean execute() throws Exception {
        if (stack()) {
            print(entries());
        }
        return super.execute();
    }

    private void print(List<Operand> entries) throws Exception {
        int index = 0;
        System.out.println("index\tentry");
        for (Operand operand : entries) {
            System.out.println(index++ + "\t" + format(operand));
        }
    }

    private List<Operand> entries() throws Exception {
        List<Operand> entries = new LinkedList<>();
        Operand elements = field("elementData");
        for (int i = 0; i < ((ArrayReference)elements.value()).length(); ++i) {
            ArrayOperand entry = new ArrayOperand((ArrayReference)elements.value(), i);
            if (null != entry.value()) {
                entries.add(0, entry);
            }
        }
        return entries;
    }

    private boolean stack() throws Exception {
        if (superClass("java.util.Stack")) {
            boolean condition = exist("elementData");
            condition = condition && exist("elementCount");
            condition = condition && exist("capacityIncrement");
            return condition;
        }
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
