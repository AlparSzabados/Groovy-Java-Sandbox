package szabados.alpar.exercises

import static Bmr.Activity.*
import static Bmr.Gender.*

class Bmr {
    enum Gender {
        MALE, FEMALE
    }

    enum Activity {
        NONE, LIGHT, MODERATE, HEAVY, VERY_HEAVY
    }

    /**
     * This is a simple Basal Metabolic Rate calculator
     *
     * @param gender (Male or Female)
     * @param weight in kg
     * @param height in cm
     * @param age in years
     * @return BMR
     */
    static basalMetabolicRate(Gender gender, Number weight, Number height, Number age) {
        switch (gender) {
            case MALE: return bmrFormula(88.362, (13.397 * weight), (4.799 * height), (5.677 * age))
            case FEMALE: return bmrFormula(447.593, (9.247 * weight), (3.098 * height), (4.330 * age))
        }
    }
    static bmrFormula(Number offset, Number scaledWeight, Number scaledHeight, Number scaledAge) {
        offset + scaledWeight + scaledHeight - scaledAge
    }

    /**
     * Calculates the daily calorie intake based on the BMR index and activity type
     *
     * @param basalMetabolicRate
     * @param activity type
     * @return daily calorie intake
     */
    static dailyCalorieIntake(Number basalMetabolicRate, Activity activity) {
        switch (activity) {
            case NONE: return basalMetabolicRate * 1.2        // with no daily exercise
            case LIGHT: return basalMetabolicRate * 1.375     // with light exercise (1-3 days per week)
            case MODERATE: return basalMetabolicRate * 1.55   // moderate exercise (3-5 days per week)
            case HEAVY: return basalMetabolicRate * 1.725     // heavy exercise (6-7 days per week)
            case VERY_HEAVY: return basalMetabolicRate * 1.9  // very heavy exercise (twice per day, extra heavy workouts)
        }
    }
}