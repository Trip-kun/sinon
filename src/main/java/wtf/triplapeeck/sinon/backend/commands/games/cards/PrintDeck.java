package wtf.triplapeeck.sinon.backend.commands.games.cards;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
import wtf.triplapeeck.sinon.backend.DataCarriage;
import wtf.triplapeeck.sinon.backend.Page;
import wtf.triplapeeck.sinon.backend.commands.Command;
import wtf.triplapeeck.sinon.backend.games.cards.Deck;
import wtf.triplapeeck.sinon.backend.listeners.ThreadManager;

public class PrintDeck extends Command {
    public void handler(GuildMessageReceivedEvent event, DataCarriage carriage, ThreadManager listener) {


        carriage.channel.sendMessage(new Deck().deck.toString()).queue();
    }
    public java.lang.@NotNull String getDocumentation() { return "" +
            "Prints a 52 Card Deck" +
            "\nUsage: s!printdeck";}
    public @NotNull String getName() {
        return "printdeck";
    }

    @Override
    public @NotNull boolean hasPermission(DataCarriage carriage, User user) {
        return currencyEnabled(carriage);
    }

    public PrintDeck () {
        Page.CardGames.addCommand(this);
    }
}
