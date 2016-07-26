package szabados.alpar.exercises

import spock.lang.Specification

class CompactorTest extends Specification {
    def 'compact string of repeating characters'() {
        /*@formatter:off*/
        when:   def matching = StringCompactor.compactString(pattern)
        then:   matching == results

        where:  pattern       || results
                ''            || ''
                'aaa'         || 'a3'
                'abc'         || 'a1b1c1'
                'aaaccdefss'  || 'a3c2d1e1f1s2'
                '111'         || '13'
        /*@formatter:on*/
    }
}