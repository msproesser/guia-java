package programinhas.jokenpo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static programinhas.jokenpo.MatchupResult.*;

/**
 * <h1>GameSummary</h1>
 * <p>Classe responsavel em apresentar as pontuações e quem será o vencedor.</p>
 * @author Matheus Sproesser
 * @version 1.0
 * @since 25/12/2022
 */
public class GameSummary {

    /**
     * atributos do tipo final (que não podem ser alterados)
     * visibilidade privada, uso restrito somente dessa classe
     */
    private final Player challenger;
    private final Player opponent;
    private final int rounds;
    private final Map<MatchupResult, Integer> score;
    private final boolean isChallengerWin;

    /**
     * Método construtor para apresentar as pontuações finais.
     * @param challenger jogador 1
     * @param opponent jogador 2
     * @param rounds partidas
     * @param results recebe o valor e atribui a a variavel <b>score<b>
     */

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