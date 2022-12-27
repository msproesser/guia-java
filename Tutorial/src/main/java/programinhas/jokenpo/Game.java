package programinhas.jokenpo;

import java.util.ArrayList;
import java.util.List;
import static programinhas.jokenpo.MatchupResult.*;
public class Game {

    private final Player challenger;
    private final Player opponent;
    private final int rounds;
    private final List<MatchupResult> matchHistory = new ArrayList<>();

    public Game(Player challenger, Player opponent, int rounds) {
        this.challenger = challenger;
        this.opponent = opponent;
        this.rounds = rounds;
    }

    public MatchupResult newRound() {
        if (isFinished()) return null;

        var gesture = challenger.getGesture();
        if (gesture == null) {
            matchHistory.add(LOSE);
            return LOSE;
        }
        var result = gesture.against(opponent.getGesture());
        matchHistory.add(result);
        return result;
    }

    public boolean isFinished() {
        return matchHistory.size() >= rounds;
    }

    public GameSummary getSummary() {
        return new GameSummary(challenger, opponent, rounds, matchHistory);
    }
}
