package szabados.alpar.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BallDistanceFromPlayer {
    private static Ball ball = new Ball();
    private static List<Player> players = new ArrayList<>();

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
