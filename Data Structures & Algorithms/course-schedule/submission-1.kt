class Solution {
    /**
        [0,1] [1,2] [2,3] with 3 numCourses returns true

        brute force means looping through every prereq and going through dfs until there
        are no more prereqs for each prereq and lastly checking number of courses encountered

        as we loop through though we can mark prereqs as satisfied up the call stack?

        meaning a recursive satisfies function returns true when there are no prereqs as a base case

        and we can hash prereqs by the first index


    */
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = buildMap(prerequisites)
        return prerequisites.all {
            satisfies(it, prerequisites, map, mutableSetOf<Int>())
        }
    }

    fun buildMap(prerequisites: Array<IntArray>): Map<Int, List<IntArray>> {
        val map = mutableMapOf<Int, List<IntArray>>()
        prerequisites.forEach { it ->
            val prereq = it[1]
            val list = prerequisites.filter { it[0] == prereq }
            val current = map.getOrPut(it[0]) { emptyList<IntArray>() }.toMutableList()
            current.addAll(list)
            map[it[0]] = current
        }
        return map
    }

    // map is a map of class to its prereqs, so it would be 1 -> [[1,2]]
    fun satisfies(current: IntArray, prerequisites: Array<IntArray>, map: Map<Int, List<IntArray>>, visited: MutableSet<Int>): Boolean {
        if (visited.contains(current[0])) return false
        val prereqs = map[current[1]]
        if (prereqs == null || prereqs.isEmpty()) {
            return true
        }
        visited.add(current[0])
        return prereqs.all {
            satisfies(it, prerequisites, map, visited)
        }
    }
}
