package szabados.alpar.bmr

import spock.lang.Specification

import static szabados.alpar.bmr.BmrClass.*
import static szabados.alpar.bmr.BmrClass.Activity.*
import static szabados.alpar.bmr.BmrClass.Gender.*
import static szabados.alpar.bmr.HelperClass.almostEqual

/**
 * Simple test for the BMR Calculator
 */
class BmrClassTest extends Specification {
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