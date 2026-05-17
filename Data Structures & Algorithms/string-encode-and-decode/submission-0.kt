class Solution {

    /*
    need to have info to join all the strings then expand them back out

    choose a delimeter 
    ["hello", "world"]

    for each string, do #[len]<string>
    so 
    "#5hello#5world"
    */

    fun encode(strs: List<String>): String {
        val builder = StringBuilder()
        strs.forEach { str ->
            builder.append(str.length)
                .append("#")
                .append(str)
        }
        return builder.toString()
    }

    /**
    "#5hello#5world"
    */
    fun decode(str: String): List<String> {
        val list = mutableListOf<String>()
        var i = 0
        
        while (i < str.length) {
            // 1. Find the delimiter to know where the length ends
            var j = i
            while (str[j] != '#') {
                j++
            }
            
            // 2. Parse the length (works for "5#", "10#", "100#", etc.)
            val length = str.substring(i, j).toInt()
            
            // 3. Move i to the start of the actual string content
            i = j + 1
            
            // 4. Extract the string based on the length
            val word = str.substring(i, i + length)
            list.add(word)
            
            // 5. Move i to the start of the next length block
            i += length
        }
        return list
    }
}
