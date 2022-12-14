package wtf.triplapeeck.sinon.backend.runnable;

import net.dv8tion.jda.api.entities.TextChannel;
import wtf.triplapeeck.sinon.backend.Logger;
import wtf.triplapeeck.sinon.backend.Main;
import wtf.triplapeeck.sinon.backend.errors.UsedTableException;
import wtf.triplapeeck.sinon.backend.errors.ValidTableException;
import wtf.triplapeeck.sinon.backend.games.cards.Table;
import wtf.triplapeeck.sinon.backend.storable.ChannelStorable;
import wtf.triplapeeck.sinon.backend.storable.StorableManager;

public class NewTable implements Runnable {
    private long id;
    Table table;
    ChannelStorable channelStorable;
    public NewTable(long ID) {
        id=ID;
    }
    @Override
    public void run() {
        channelStorable = StorableManager.getChannel(id);
        Logger.customLog("NewTable","Starting. Waiting On Table.");
        while (true) {
            boolean complete=false;


            try {
                while (true) {
                    table = channelStorable.getTable();
                    complete=true;
                }
            } catch (UsedTableException e) {
            }
            if (complete) {
                break;
            }
        }

        Logger.customLog("NewTable", "Table Requested. Now Owner");
        if (table==null) {
            try {
                Logger.customLog("NewTable","Attempting To Make New Table.");
                channelStorable.setTable( new Table(id));
            } catch (ValidTableException e) {
            }
        } else {
            TextChannel channel = Main.api.getTextChannelById(id);
            channel.sendMessage("A Table Already Exists!").queue();
        }
        channelStorable.relinquishTable();
        channelStorable.relinquishAccess();
        Logger.customLog("NewTable","Table Relinquished. Finished. ");
    }
}
