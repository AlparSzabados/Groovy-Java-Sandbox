package szabados.alpar.exercises;

import java.util.*;

public class VolleyballPlayerRotation {
    public static String[][] getInitialPosition(String[][] formation, int k) {
        List<String> initialFormation = getFormation(formation, k);
        rebuild(initialFormation, formation);

        return formation;
    }

    private static List<String> getFormation(String[][] formation, int k) {
        List<List<String>> squash = squash(formation);

        Deque<String> stack1 = new ArrayDeque<>();
        Deque<String> stack2 = new ArrayDeque<>();
        stack1.addAll(squash.get(0));
        stack2.addAll(squash.get(1));

        for (int i = 0; i < k; i++) {
            stack1.addLast(stack2.pollLast());
            stack2.addFirst(stack1.pollFirst());
        }

        stack1.addAll(stack2);
        List<String> result = new ArrayList<>();
        result.addAll(stack1);

        return result;
    }

    private static void rebuild(List<String> initialFormation, String[][] formation) {
        formation[0][1] = initialFormation.get(1);
        formation[1][0] = initialFormation.get(0);
        formation[1][1] = "empty";
        formation[1][2] = initialFormation.get(2);
        formation[2][1] = initialFormation.get(4);
        formation[3][0] = initialFormation.get(3);
        formation[3][1] = "empty";
        formation[3][2] = initialFormation.get(5);
    }

    private static List<List<String>> squash(String[][] formation) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i < formation.length; i += 2) {
            formation[i][1] = formation[i - 1][1];
            result.addAll(Arrays.asList(new ArrayList<>(Arrays.asList(formation[i]))));
        }
        return result;
    }
}
