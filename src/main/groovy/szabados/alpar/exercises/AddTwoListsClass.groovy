package szabados.alpar.exercises

class AddTwoLists {

    static addTwoLists(num1, num2) {
        def listOneReverse = num1.toString().toList().reverse()*.toInteger()
        def listTwoReverse = num2.toString().toList().reverse()*.toInteger()

        def bigNum = (listOneReverse.size() > listTwoReverse.size()) ? listOneReverse : listTwoReverse
        def smallNum = (listOneReverse.size() < listTwoReverse.size()) ? listOneReverse : listTwoReverse
        if (listOneReverse.size() == listTwoReverse.size()) {
            bigNum = listOneReverse
            smallNum = listTwoReverse
        }

        def resultNumber = []

        int carry = 0
        for (i in 0..bigNum.size() - 1) {
            def sum = sum(smallNum, i, bigNum)
            def result
            if ((sum + carry) > 9) {
                result = (sum + carry) % 10
                resultNumber << result
                carry = ((sum + carry) - result) / 10
            } else {
                resultNumber << sum + carry
                carry = 0
            }
        }
        if (carry > 0)
            resultNumber << carry

        resultNumber.reverse().join('').toBigInteger()
    }
    static sum(ArrayList<Integer> smallNum, int i, ArrayList<Integer> bigNum) {
        (smallNum[i] != null) ? bigNum[i] + smallNum[i] : bigNum[i]
    }
}

