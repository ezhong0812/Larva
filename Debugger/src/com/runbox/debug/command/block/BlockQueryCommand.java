package com.runbox.debug.command.block;

import com.runbox.debug.command.Command;
import com.runbox.debug.manager.BlockManager;
import com.runbox.debug.parser.statement.node.BlockNode;

import java.util.Map;

/**
 * Created by qstesiro
 */
public class BlockQueryCommand extends Command {

    public BlockQueryCommand(String command) throws Exception {
        super(command);
    }

    @Override
    public boolean execute() throws Exception {
        String name = name();
        if (null != name) {
            System.out.println(BlockManager.instance().string(name));
        } else {
            Map<String, BlockNode> map = BlockManager.instance().get();
            for (String key : map.keySet()) {
                System.out.println(BlockManager.instance().string(map.get(key).name()));
            }
        }
        return super.execute();
    }

    private String name() throws Exception {
        if (null != argument) {
            String name = argument.trim();
            if (null == BlockManager.instance().get(name)) {
                throw new Exception("invalid block name");
            }
            return name;
        }
        return null;
    }

    @Override
    public void help() {
        String help = "block.query [name]\r\n";
        help += "description\r\n";
        help += "print block statement in single line.";
        help += "arguments";
        help += "name is optional, if it`s omitted debugger will print all blocks defined. Otherwise, debugger will \r\n" +
                "print the block which name equals name.";
        help += "example";
        help += "";
        System.out.println(help);
    }
}
