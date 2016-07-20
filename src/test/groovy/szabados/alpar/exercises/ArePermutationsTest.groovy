package szabados.alpar.exercises

import spock.lang.Specification

import static szabados.alpar.exercises.ArePermutations.*

/**
 * Test to see if one string is permutation of another
 */

class ArePermutationsTest extends Specification {
    /*@formatter:off*/
    def 'Permutations check'() {
        when:   def permutations = permutationCheck(strinOne, stringTwo)
        then:   permutations == result

        where:  strinOne    | stringTwo     ||      result
                'abc'       | 'abc'         ||      true
                'a'         | 'b'           ||      false
                'abc'       | 'cba'         ||      true
                'bca'       | 'BCA'         ||      true
                '12azx'     | 'az1x2'       ||      true
                'Ac1bd'     | 'Ab1cd'       ||      true
                'Dc1ba'     | 'Ab1cd'       ||      true
                'Ac1bd'     | 'Ab1cd'       ||      true
                'DcaE2'     | 'Ab1cd'       ||      false
                'Dcab2'     | 'Ab1cEd'      ||      false
                'DcaXb2'    | 'AZb1cd'      ||      false
    }
    /*@formatter:on*/
}
