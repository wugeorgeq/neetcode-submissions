class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        // ok now the sexy increment decrement hashtable solution
        if (s.length != t.length) return false
        val table = IntArray(26)
        for (i in s.indices) {
            table[s[i] - 'a']++
            table[t[i] - 'a']--
        }
        return !table.any { it != 0 }

        /* ah hash table is where it's at! */
        // lower case is important

        /*
        if (s.length != t.length) return false
        val sArr = s.toCharArray()
        val tArr = t.toCharArray()
        val sTable = IntArray(26)
        val tTable = IntArray(26)
        for (i in 0 until s.length) {
            sTable[sArr[i] - 'a'] = sTable[sArr[i] - 'a'] + 1
            tTable[tArr[i] - 'a'] = tTable[tArr[i] - 'a'] + 1
        }
        return sTable.contentEquals(tTable)
        */

        /*
        Set equality doesn't quite work out even with size checks because we could have aab and abb
        Map of char to occurences works
        Oh of course sorting then checking list equality works as well
        Sorting is O(nlogn) and equality is ... O(n) ? is it?

        Map of char to occurences is O(3n) i think?

        Oh no I don't understand sorting or equality of arrays?!

        OK at least lets think about map of char to occurences...
        */
        /*
        val mapS = s.toList().groupBy { it }
        val mapT = t.toList().groupBy { it }
        return mapS == mapT
        */
    }
}
