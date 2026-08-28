package day1_livecoding.class_problems;

import java.util.Random;

public class RockPaperScissors {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Random random = new Random();
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int rounds = playerMoves.length;
        
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            String pMove = playerMoves[i];
            String cMove = MOVES[random.nextInt(3)];
            
            String result = playRound(pMove, cMove);
            computerMoves[i] = cMove;
            results[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        System.out.printf("%-10s | %-12s | %-14s | %-12s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-10d | %-12s | %-14s | %-12s\n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = ((double) wins / rounds) * 100;
        System.out.printf("\nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }
}
