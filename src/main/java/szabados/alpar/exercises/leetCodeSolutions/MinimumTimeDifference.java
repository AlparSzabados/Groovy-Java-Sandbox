package szabados.alpar.exercises.leetCodeSolutions;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format,
 * find the minimum minutes difference between any two time points in the list.
 */

public class MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {
        List<LocalTime> times = timePoints.stream().map(LocalTime::parse).sorted().collect(Collectors.toList());

        int result = 1440;
        LocalTime prev = times.get(times.size() - 1);
        for (LocalTime time : times) {
            long duration = Duration.between(prev, time).toMinutes();
            result = (int) Math.min(result, (duration < 0 ? duration + 1440 : duration));
            prev = time;
        }
        return result;
    }
}
