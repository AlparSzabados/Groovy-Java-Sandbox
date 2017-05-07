package szabados.alpar.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BallDistanceFromPlayer {
    private static Ball ball = new Ball();
    private static List<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        new BallDistanceFromPlayer().calculateDistance("15 64 1 1 11 48 1 2 19 43 1 3 21 51 1 4 20 35 1 5 17 61 1 6 39 48 1 7 29 42 1 8 23 51 1 9 51 20 1 10 36 65 1 11 62 40 2 1 107 40 2 2 63 59 2 3 29 63 2 4 16 64 2 5 67 29 2 6 52 24 2 7 19 36 2 8 64 50 2 9 63 40 2 10 24 50 2 11 52 33");
    }

    private static void setup(String s) {
        String[] input = s.split(" ");
        ball.x = Integer.parseInt(input[0]);
        ball.y = Integer.parseInt(input[1]);

        for (int i = 2; i < input.length; i += 4) {
            Player p = new Player();
            p.teamNumber = Integer.parseInt(input[i]);
            p.playerNumber = Integer.parseInt(input[i + 1]);
            p.x = Integer.parseInt(input[i + 2]);
            p.y = Integer.parseInt(input[i + 3]);
            players.add(p);
        }
    }

    private void calculateDistance(String input) {
        setup(input);
        Map<Double, String> playerPositions = new TreeMap<>();

        for (Player player : players) {
            double distance = this.distance(player);
            playerPositions.put(distance, player.teamNumber + " " + player.playerNumber);
        }

        playerPositions.forEach((k, v) -> System.out.print(v + " "));
    }

    private double distance(Player player) {
        return Math.hypot(player.x - ball.x, player.y - ball.y);
    }
}

class Player {
    int teamNumber;
    int playerNumber;
    int x = 0;
    int y = 0;
}

class Ball {
    int x = 0;
    int y = 0;
}
