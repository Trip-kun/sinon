package wtf.triplapeeck.sinon.backend.commands.games.cards.blackjack;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
import wtf.triplapeeck.sinon.backend.DataCarriage;
import wtf.triplapeeck.sinon.backend.Main;
import wtf.triplapeeck.sinon.backend.Page;
import wtf.triplapeeck.sinon.backend.commands.Command;
import wtf.triplapeeck.sinon.backend.listeners.ThreadManager;
import wtf.triplapeeck.sinon.backend.runnable.NewTable;

public class CreateBlackjackTable extends Command {
    public CreateBlackjackTable() {
        Page.CardGames.addCommand(this);
    }
    @Override
    public void handler(MessageReceivedEvent event, DataCarriage carriage, ThreadManager listener) {
        if(ensureCurrencyEnabled(carriage) && ensureTableIsEmpty(carriage)) {
            carriage.channel.sendMessage("Creating a new blackjack table.").queue();
            Main.threadManager.addTask(new NewTable(carriage.channel.getIdLong()));
        }
    }

    @NotNull
    @Override
    public String getDocumentation() {
        return "Usage:" +
                "\ns!newblackjacktable" +
                "\nThis will create a new table in blackjack mode." +
                "\nIt will start in recruitment mode until 4 players are reached" +
                "\nOr until a requested time-out finishes.";
    }

    @Override
    public @NotNull String getName() {
        return "newblackjacktable";
    }

    @Override
    public @NotNull boolean hasPermission(DataCarriage carriage, User user) {
        return currencyEnabled(carriage);
    }
}
