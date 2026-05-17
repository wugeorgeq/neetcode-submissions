class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        /*
        Set equality doesn't quite work out even with size checks because we could have aab and abb
        Map of char to occurences works
        Oh of course sorting then checking list equality works as well
        Sorting is O(nlogn) and equality is ... O(n) ? is it?

        Map of char to occurences is O(3n) i think?

        Oh no I don't understand sorting or equality of arrays?!

        OK at least lets think about map of char to occurences...
        */
        val mapS = s.toList().groupBy { it }
        val mapT = t.toList().groupBy { it }
        return mapS == mapT
    }
}
