package programinhas.jokenpo;

public class Inicio {

    public static void main(String[] args) {
        var game = new Game(new IAPlayer("challenger"), new IAPlayer("opponent"), 5);
        while(!game.isFinished()) {
            var roundResult = game.newRound();
            System.out.println("Round result is: " + roundResult.name());
        }
        var summary = game.getSummary();
        System.out.println("Game result :");
        System.out.println("Winner is: " + summary.getWinner().getName());
        System.out.println("Loser is: " + summary.getLoser().getName());
        var score = summary.getScore();
        System.out.println("Challenger won " +score.getOrDefault(MatchupResult.WIN, 0)+ " rounds");
        System.out.println("Challenger lost " +score.getOrDefault(MatchupResult.LOSE, 0)+ " rounds");
        System.out.println("Draw " +score.getOrDefault(MatchupResult.DRAW, 0)+ " rounds");

    }

    private static void printResultSummary(Game game) {

    }
}
