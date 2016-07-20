package szabados.alpar.exercises

import spock.lang.Specification

class CamelCaseMatchingTest extends Specification {
    /*@formatter:off*/
    def 'pattern matches CamelCase class names'() {
        given:  def classNames = ['HelloMars', 'HelloWorld', 'HelloWorldMars', 'HiHo', 'H']
        when:   def matching = CamelCase.matching(pattern, classNames)
        then:   matching == results

        where:  pattern  || results
                'H'      || ['HelloMars', 'HelloWorld', 'HelloWorldMars', 'HiHo', 'H']
                'HW'     || ['HelloWorld', 'HelloWorldMars']
                'Ho'     || []
                'HeWorM' || ['HelloWorldMars']
    }
}
