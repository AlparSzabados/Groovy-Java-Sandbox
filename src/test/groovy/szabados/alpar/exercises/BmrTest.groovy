package szabados.alpar.exercises

import spock.lang.Specification

import static HelperClass.almostEqual
import static szabados.alpar.exercises.Bmr.Activity.LIGHT
import static szabados.alpar.exercises.Bmr.Activity.NONE
import static szabados.alpar.exercises.Bmr.Gender.FEMALE
import static szabados.alpar.exercises.Bmr.Gender.MALE
import static szabados.alpar.exercises.Bmr.basalMetabolicRate
import static szabados.alpar.exercises.Bmr.dailyCalorieIntake

/**
 * Simple test for the BMR Calculator
 */
class BmrTest extends Specification {
    /*@formatter:off*/
    def 'bmr calculator'() {
        when:   def bmi = basalMetabolicRate(gender, weight, height, age)
        then:   almostEqual(bmi, expectedResult)

        where:  gender | weight | height | age || expectedResult
                MALE   | 64     | 170    | 27  || 1608.3
                FEMALE | 54     | 167    | 36  || 1308.4
    }

    def 'daily calorie intake'() {
        when:   def CalorieIntake = dailyCalorieIntake(basalMetabolicRate, activity)
        then:   almostEqual(CalorieIntake, expectedResult)

        where:  basalMetabolicRate | activity || expectedResult
                1608.321           | NONE     || 1929.9
                1308.417           | LIGHT    || 1799
    }
    /*@formatter:on*/
}