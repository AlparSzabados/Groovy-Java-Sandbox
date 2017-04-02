package szabados.alpar.exercises;

import java.time.Duration;

/**
 * Calculates the current page you are listening to from an audiobook
 * based on the elapsed time, remaining time and total number of pages.
 */
public class CurrentPage {
    public int currentPage(Duration elapsedTime, Duration remainingTime, int totalPages) {
        final Duration totalTime = elapsedTime.plus(remainingTime);
        final long singlePageTime = totalTime.dividedBy(totalPages).toMillis();
        return (int) elapsedTime.dividedBy(singlePageTime).toMillis();
    }
}