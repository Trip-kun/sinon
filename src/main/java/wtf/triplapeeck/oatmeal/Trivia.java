package wtf.triplapeeck.sinon.backend;

import java.util.List;

public class Trivia {
    public String question;
    public List<String> answers;
    public Trivia(String quest, List<String> ans) {
        question=quest; answers=ans;
    }
}
