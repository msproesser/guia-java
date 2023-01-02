package programinhas.jokenpo;
import java.util.ArrayList;
import java.util.List;
import static programinhas.jokenpo.MatchupResult.*;
/**
 * <h1>Game</h1>
 * <p>Classe responsavel em criar os jogadores atravéz do uso da interface Player, criar round e um array da classe enum MatchuResult para o resultado dos rounds (matchHistory).</p>
 * @author Matheus Sproesser
 * @version 1.0
 * @since 25/12/2022
 */
public class Game {
    /**
     * atributos do tipo final (que não podem ser alterados)
     * visibilidade privada, uso restrito somente dessa classe
     * matchHistory = array criado usando a classe MatchuResult para retornar o historico de partidas
     */
    private final Player challenger;
    private final Player opponent;
    private final int rounds;
    private final List<MatchupResult> matchHistory = new ArrayList<>();
    /**
     * Método construtor para implementar os jogadores e os rounds
     * @param challenger implementa a interface Player, sendo o 1ª jogador
     * @param opponent implementa a interface Player, sendo o 2º jogador
     * @param rounds valor do tipo inteiro respresentando a quantidade de rounds que o jogo terá
     */
    public Game(Player challenger, Player opponent, int rounds) {
        this.challenger = challenger;
        this.opponent = opponent;
        this.rounds = rounds;
    }
    /**
     * Método responsavel em fazer os jogadores se confrontarem
     * @return o jogador vencedor ou perdedor do round
     */
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
    /**
     * Método responsável em verificar se todos os round terminaram
     * @return true, se o numero de elementos do array matchHistory for >= round, e finaliza o round
     */
    public boolean isFinished() {
        return matchHistory.size() >= rounds;
    }
    /**
     * Método que apresenta o resultado do jogo
     * @return o jogador 1, jogador 2, quantidade de rounds e o histórico da partida
     */
    public GameSummary getSummary() {
        return new GameSummary(challenger, opponent, rounds, matchHistory);
    }}