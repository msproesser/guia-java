package programinhas.jokenpo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static programinhas.jokenpo.MatchupResult.*;
public class GameSummary {

    private final Player challenger;
    private final Player opponent;
    private final int rounds;
    private final Map<MatchupResult, Integer> score;
    private final boolean isChallengerWin;


    public GameSummary(Player challenger, Player opponent, int rounds, List<MatchupResult> results) {
        this.challenger = challenger;
        this.opponent = opponent;
        this.rounds = rounds;
        score = results.stream().collect(Collectors.groupingBy(result -> result, Collectors.summingInt(result -> 1)));
        this.isChallengerWin = score.getOrDefault(WIN, 0) > score.getOrDefault(LOSE, 0);
    }

    public Player getWinner() {
        return isChallengerWin ? challenger : opponent;
    }

    public Player getLoser() {
        return isChallengerWin ? opponent : challenger;
    }

    public int getRounds() {
        return rounds;
    }

    public Map<MatchupResult, Integer> getScore() {
        return score;
    }

    public boolean isChallengerWin() {
        return isChallengerWin;
    }
}
