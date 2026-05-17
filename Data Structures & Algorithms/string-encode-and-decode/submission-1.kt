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
            val lengthBuilder = StringBuilder()
            while (str[i] != DELIM) {
                lengthBuilder.append("${str[i]}")
                i++
            }
            i++
            var len = lengthBuilder.toString().toInt()
            val stopIndex = i + len
            val strBuilder = StringBuilder()
            while (i < stopIndex) {
                strBuilder.append("${str[i]}")
                i++
            }
            toReturn.add(strBuilder.toString())
        }

        return toReturn
    }
}
