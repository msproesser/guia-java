package programinhas.jokenpo;

import java.util.List;
/**
 * <h1>Options</h1>
 * <p>Classe do tipo Enum, responsavel por criar as constantes <b>ROCK, PAPER, SCISSOR, LIZARD e SPOCK</b>.</p>
 * <p>Essas constantes são as opções que serão utilizadas pelos jogadores se confrontarem.</p>
 * <p>Cada constante recebe um List.of com 2 elementos, que define as regras do jogo.</p>
 * @author Matheus Sproesser
 * @version 1.0
 * @since 25/12/2022
 */
public enum Options {
    ROCK, PAPER, SCISSOR, LIZARD, SPOCK;

    static {
        ROCK.winAgainst = List.of(SCISSOR, LIZARD);
        PAPER.winAgainst = List.of(ROCK, SPOCK);
        SCISSOR.winAgainst = List.of(PAPER, LIZARD);
        LIZARD.winAgainst = List.of(SPOCK, PAPER);
        SPOCK.winAgainst = List.of(ROCK, SCISSOR);
    }
    private List<Options> winAgainst = List.of();

    public MatchupResult against(Options other) {
        if (this.equals(other)) return MatchupResult.DRAW;

        return this.winAgainst.contains(other) ? MatchupResult.WIN : MatchupResult.LOSE;
    }
}