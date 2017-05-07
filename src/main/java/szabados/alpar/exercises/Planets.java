package szabados.alpar.exercises;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Planets {
    private static List<Star> STARS = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        String input = "";
        try {
            input = new String(Files.readAllBytes(Paths.get("foobar")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        parseInput(input, STARS);
        groupBrightness(STARS);
        findEvents(STARS);
        hasPlanets(STARS);

        printResult(STARS);
    }

    private static void hasPlanets(List<Star> stars) {
        for (Star star : stars) {
            int countTransits = 0;
            if (star.events >= 3) {
                int timeBetweenTransits = 0;
                int prevBrightness = 0;
                int prevDuration = 0;
                for (int i = 2; i < star.groupedLightCurve.size() - 1; i += 2) {
                    int currBrightness = star.groupedLightCurve.get(i);
                    int currDuration = star.groupedLightCurve.get(i + 1);
                    if (isTransit(currBrightness, currDuration)) {
                        if (currBrightness == prevBrightness && currDuration == prevDuration && (timeBetweenTransits + prevDuration) == (timeBetweenTransits + currDuration)) {
                            countTransits++;
                        } else {
                            prevBrightness = currBrightness;
                            prevDuration = currDuration;
                        }
                    } else
                        timeBetweenTransits += currDuration;
                }
            }

            if (countTransits >= 3) star.planets = "Yes";
            else star.planets = "No";
        }
    }

    private static void findEvents(List<Star> stars) {
        for (Star star : stars) {
            int countFlares = 0;
            int countEvents = 0;
            for (int i = 0; i < star.groupedLightCurve.size(); i += 2) {
                if (isFlare(star.groupedLightCurve.get(i))) countFlares++;
                else if (isTransit(star.groupedLightCurve.get(i), star.groupedLightCurve.get(i + 1))) countEvents++;
            }
            star.flares = countFlares;
            star.events = countEvents;
        }
    }

    private static boolean isFlare(int brightness) {
        return brightness > 1000000;
    }


    private static boolean isTransit(int brightness, int duration) {
        return brightness <= (1000000 - 5000) && duration >= 5;
    }

    private static void printResult(List<Star> stars) {
        stars.forEach(star -> System.out.print(star.name + " " + star.planets + " "));
    }

    private static void groupBrightness(List<Star> stars) {
        for (Star star : stars) {
            int curr = star.lightCurve[0];
            int count = 1;
            for (int i = 1; i < star.lightCurve.length; i++) {
                if (star.lightCurve[i] == curr) {
                    count++;
                } else {
                    star.groupedLightCurve.add(curr);
                    star.groupedLightCurve.add(count);
                    curr = star.lightCurve[i];
                    count = 1;
                }
            }
            star.groupedLightCurve.add(curr);
            star.groupedLightCurve.add(count);
        }
    }

    private static void parseInput(String input, List<Star> stars) {
        String[] strings = input.substring(3).split("\\s");

        for (int i = 2; i < strings.length; i += 302) {
            int length = Integer.parseInt(strings[i - 1]);
            int[] lightCurve = new int[length];
            for (int j = i; j < i + length; j++) {
                lightCurve[j - i] = Integer.parseInt(strings[j]);
            }
            stars.add(new Star(strings[i - 2], length, lightCurve));
        }
    }
}

class Star {
    String name;
    int length;
    int[] lightCurve;
    List<Integer> groupedLightCurve = new ArrayList<>();
    int flares;
    int events;
    String planets;

    Star(String name, int length, int[] lightCurve) {
        this.name = name;
        this.length = length;
        this.lightCurve = lightCurve;
    }
}