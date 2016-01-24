package szabados.alpar.exercises

class AddTwoLists {

    static addTwoLists(numList1, numList2) {
        def listOne = numList1.toString().toList()*.toInteger()
        def listTwo = numList2.toString().toList()*.toInteger()

        // TODO find a better solution to these two
        def listOneReverse = listOne.reverse()
        for (i in listTwo.indices) {
            if (listOneReverse[i] == null) {
                listOneReverse[i] = 0
            }
        }

        def listTwoReverse = listTwo.reverse()
        for (i in listOne.indices) {
            if (listTwoReverse[i] == null) {
                listTwoReverse[i] = 0
            }
        }

        // TODO make this part understandable
        def resultNumber = []
        int difference = 0
        for (i in 0..listTwoReverse.size() - 1) {
            def n1 = listOneReverse[i]
            def n2 = listTwoReverse[i]
            def result1 = n1 + n2
            def result2 = n1 + n2 + difference
            if (n1 + n2 > 9) {
                def reminder = result1 % 10
                resultNumber << reminder + difference
                difference = (result1 - reminder) / 10
            } else if (n1 + n2 + difference > 9) {
                def reminder = result2 % 10
                resultNumber << reminder
                difference = (result2 - reminder) / 10
            } else {
                resultNumber << result1 + difference
                difference = 0
            }
        }
        if (difference > 0) {
            resultNumber << difference
        }
        resultNumber.reverse().join('') //TODO find a workaround to the NumberFormatException that occurs when transforming long String to Integer.
    }
}

