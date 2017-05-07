package szabados.alpar.exercises

import spock.lang.Specification

class UnblockTest extends Specification {
    def 'is valid move'() {
        given:  def blocks = Arrays.asList(new Block(0, "h", 2, 3, 3),
                                           new Block(1, "h", 2, 5, 5),
                                           new Block(2, "v", 6, 2, 2),
                                           new Block(3, "h", 4, 4, 2),
                                           new Block(4, "v", 1, 1, 4))

        when:   def blockGame = new Unblock(screenHeight, screenWidth, blocks)
        then:   blockGame.willClash(blockId, numberOfMoves) == result

        where:  screenHeight | screenWidth  | blockId | numberOfMoves || result
                5            | 6            | 0       |  2            || true
                5            | 6            | 0       |  1            || false
                5            | 6            | 2       | -2            || true
                5            | 6            | 1       | -2            || true
                5            | 6            | 1       |  1            || true
                5            | 6            | 1       |  0            || false
                5            | 6            | 2       |  3            || true
                5            | 7            | 1       |  1            || false
                5            | 7            | 1       | -1            || false
                5            | 7            | 3       |  1            || false
                5            | 6            | 4       |  1            || false
    }

    def 'unmovable blocks'() {
        given:  def blocks = "0 h 8 7 2 1 v 10 7 6 2 v 4 5 4 3 v 2 7 3 4 v 9 1 3 5 v 5 4 3 6 h 7 6 3 7 h 5 8 3 8 h 10 6 2 9 h 2 2 4 10 h 1 3 2 11 v 1 4 4 12 v 3 4 3 13 v 2 4 2 14 v 3 8 3 15 v 4 9 4 16 v 6 9 4 17 h 7 11 3 18 h 7 10 3 19 h 5 7 3 20 h 6 5 5 21 h 6 4 5 22 h 5 3 4"

        when:   def blockGame = new Unblock(screenHeight, screenWidth, parseInput(blocks))
        then:   blockGame.unmovable() == result


        where:  screenHeight | screenWidth  || result
                12           | 12           || [0, 1, 4, 5, 15, 16, 17, 18, 19]
    }

    def 'throws if ID not found' () {
        given:  def blocks = Arrays.asList(new Block(0, "h", 2, 3, 3))

        when:   def blockGame = new Unblock(screenHeight, screenWidth, blocks)
                blockGame.willClash(blockId, numberOfMoves)
        then:   thrown(IllegalArgumentException)

        where:  screenHeight | screenWidth  | blockId | numberOfMoves
                5            | 6            | 10      | -1
    }

    def 'perform moves' () {
        given:  def blocks = "0 h 2 3 2 1 v 1 8 4 2 h 5 5 3 3 h 2 5 2 4 h 5 4 3 5 v 4 4 3 6 v 7 1 3 7 v 7 6 5 8 h 4 10 3 9 h 3 11 4 10 h 4 7 3 11 h 10 7 2 12 h 9 5 3 13 h 8 3 4 14 v 10 8 4 15 v 2 10 2"

        when:   def blockGame = new Unblock(screenHeight, screenWidth, parseInput(blocks))
        then:   blockGame.performMoves(moves) == result

        where:  screenHeight  | screenWidth   | moves                                                   || result
                12            | 11            | [7, 15, -3, 8, -2, 11, -2, 12, -1, 14, -2, 9, 4, 14, 2] || 6
    }

    List<Block> parseInput(String s) {
        def result = []
        def strings = s.split(" ")

        for (int i = 0; i < strings.length; i += 5) {
            Block block = new Block()
            block.id = strings[i] as int
            block.orientation = strings[i + 1]
            block.x = strings[i + 2] as int
            block.y = strings[i + 3] as int
            block.length = strings[i + 4] as int
            result.add(block)
        }

        result
    }
}