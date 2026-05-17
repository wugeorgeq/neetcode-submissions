const val DELIM = '#'
class Solution {

    /**
    we need to encode length as well as characters. i think there's a delimeter as well here?
    length before hash, then next length # of characters when decoding
    "hello" "world"
    5#hello5#world
    */
    fun encode(strs: List<String>): String {
        val builder = StringBuilder()
        strs.forEach { str ->
            builder.append("${str.length}")
            builder.append(DELIM)
            builder.append("$str")
        }
        return builder.toString()
    }

    //5#hello5#world
    fun decode(str: String): List<String> {
        var i = 0
        val toReturn = mutableListOf<String>()
        while (i < str.length) {
            var j = i
            while (str[j] != DELIM) {
                j++
            }
            val len = str.substring(i, j).toInt()
            i = j + 1
            toReturn.add(str.substring(i, i + len))
            i += len
        }

        return toReturn
    }
}
