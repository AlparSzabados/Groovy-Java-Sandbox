package szabados.alpar.exercises

import spock.lang.Specification

class ParsePersonTest extends Specification {
    def 'parse person'() {
        when:   def persons = ParsePerson.parsePerson(text)
        then:   persons.toString() == result.toString()

        where:  text                                                                                           || result
                "John.Davison/05051988/Belgrade Michael.Barton/01011968/Krakov Ivan.Perkinson/23051986/Moscow" || ["John Davison 05 May 1988 Belgrade", "Michael Barton 01 Jan 1968 Krakov", "Ivan Perkinson 23 May 1986 Moscow"]


    }
}
