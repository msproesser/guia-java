package programinhas.jokenpo;
import static programinhas.jokenpo.MatchupResult.*;

/**
 * <h1>Start</h1>
 * <p>Classe principal para dar inicio ao jogo <b>Jokenpo-Spock-Lizard</b> (inspirado no Dr. Sheldon Cooper da série TBBT)</p>
 * <br>
 * <p>A jogabilidade se dá de duas formas: IAPlayer x IAPlayer, ou ShellPlayer x IAPlayer.</p>
 * @author Matheus Sproesser
 * @version 1.1
 * @since 25/12/2022
 * @contributed Lígia Alves
 */
public class Start {
    /**
     * <p>Método <b>main</b>.</p>
     * <p>É criado uma instancia do construtor da classe <b>Game</b>.</p>
     * <p>O objeto Game precisa receber um challenger, um opponent e um valor para a quantidade de rodadas/partidas.</p>
     * <p>O challenger e o opponent podem ser duas instancias de IAPlayer.</p>
     * <p>Para dar ao user a possiblidade de interagir, um dos jogadores pode ser uma instancia de <b>ShellPlayer</b>.</p>
     *
     * @return resultado do jogo usando o construtor da classe GameSummary contendo: nome do ganhador, nome do perdedor, pontuação de cada um, quantidade de empates e pontuação final.
     */
    public static void main(String[] args) {

        var game = new Game(new ShellPlayer("challenger"), new IAPlayer("opponent"), 5);
        while (!game.isFinished()) {
            var roundResult = game.newRound();
            System.out.println("Round result is: " + roundResult.name());
        }

        System.out.println("\n************************************");
        var summary = game.getSummary();
        System.out.println("\t\t\tGame result: \n");
        System.out.println("Winner is: " + summary.getWinner().getName());
        System.out.println("Loser is: " + summary.getLoser().getName());
        var score = summary.getScore();
        System.out.println("Challenger won " +score.getOrDefault(WIN, 0)+ " rounds");
        System.out.println("Challenger lost " +score.getOrDefault(LOSE, 0)+ " rounds");
        System.out.println("Draw " +score.getOrDefault(DRAW, 0)+ " rounds");
        System.out.println("************************************");

    }
}