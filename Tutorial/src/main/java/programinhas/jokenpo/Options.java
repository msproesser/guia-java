package programinhas.jokenpo;

import java.util.List;

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
