package szabados.alpar.exercises;

import java.util.*;


/* Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1, 4), new Interval(5, 6), new Interval(5, 6), new Interval(0, 10));
        final List<Interval> merge = MergeIntervals.merge(intervals);
        for (Interval interval : merge) {
//            System.out.println(interval.start);
//            System.out.println(interval.end);
        }
    }

    static public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> result = new LinkedList<>();
        if (intervals.size() <= 1) return intervals;
        else {
            intervals.sort(Comparator.comparing(i -> i.start));
            Queue<Interval> queue = new LinkedList<>(intervals);
            for (Interval next : intervals) {
                System.out.println(queue.poll().end);
                if (result.isEmpty()) {
                    result.add(next);
                } else if (isOverlapping(result.getLast(), next)) {
                    Interval curr = result.getLast();
                    result.getLast().end = (curr.end > next.end ? curr : next).end;
                } else {
                    result.add(next);
                }
            }
        }
        return result;
    }

    private static boolean isOverlapping(Interval curr, Interval next) {
        return curr.start <= next.end && curr.end >= next.start;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
