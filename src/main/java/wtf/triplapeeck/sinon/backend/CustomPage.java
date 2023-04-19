package wtf.triplapeeck.sinon.backend;

import wtf.triplapeeck.sinon.backend.commands.Command;
import wtf.triplapeeck.sinon.backend.commands.FakeCommand;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomPage extends Page {

    public CustomPage() {
        super("Custom");
    }

    @Override
    public ArrayList<Command> getCommandList(DataCarriage carriage) {
        ArrayList<Command> list = new ArrayList<>();
        for (Iterator<String> it = carriage.guildStorable.getCustomCommandList().keys().asIterator(); it.hasNext(); ) {
            String str = it.next();
            list.add(new FakeCommand(str));

        }
        return list;
    }
}
