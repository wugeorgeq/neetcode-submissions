class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        /*
        wow i don't really know how this gonna work
        super brute is for each array, find all anagrams, i think that's O(n^2) ish?
        with subfunction of isAnagram(arr, arr)

        but how to have a stable equality comparison, can we key a map to the anagram somehow? sort each one each time? but then we'd need pairs
        to retain the original ordering huh

        we'd have a map of the sorted anagram to a list of anagrams and each time sort to compare

        then the complexity would be O(nLogn * n) which is n^2 log n?
        */
        val map = mutableMapOf<String, MutableList<String>>()
    
        strs.forEach { word ->
            // Create a proper String key from the sorted characters
            val key = word.toCharArray().apply { sort() }.concatToString()
        
            // getOrPut retrieves the list if it exists, 
            // or creates/adds a new one if it doesn't.
            map.getOrPut(key) { mutableListOf() }.add(word)
        }
    
        return map.values.toList()
    }
}
