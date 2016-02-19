package szabados.alpar.exercises

/* Check if one string is permutation of another */

class ArePermutations {
    static permutationCheck(String one, String two) {
        def text1 = one.toUpperCase().toList().sort()
        def text2 = two.toUpperCase().toList().sort()
        if (text1 == text2) {
            true
        } else
            false
    }
}
