package szabados.alpar.Tekla

import spock.lang.Specification

/*@formatter:off*/
class AndrasTest extends Specification {

    def "Andras meglepi"() {
        when:   def dateTest = Andras.main(time)
        then:   dateTest == currentTest

        where:  time           || currentTest
                '2016/03/29'   || time


    }
    /*@formatter:on*/
}

