class Solution {
    /**
        [0,1] [1,2] [2,3] with 3 numCourses returns true

        brute force means looping through every prereq and going through dfs until there
        are no more prereqs for each prereq and lastly checking number of courses encountered

        as we loop through though we can mark prereqs as satisfied up the call stack?

        meaning a recursive satisfies function returns true when there are no prereqs as a base case

        ok ... brute force ish done, but
        1) can use adjacency list instead - Array<List<Int>>
        2) can memoize
        3) can simply use ints for nodes instead of IntArray
        4) yes, we are detecting cycles...
    */
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // val map = buildMap(prerequisites)
        val list = buildAdjacencyList(numCourses, prerequisites)
        return prerequisites.all {
            satisfies(it[1], prerequisites, list, mutableSetOf<Int>())
        }
    }

    fun buildAdjacencyList(numCourses: Int, prerequisites: Array<IntArray>): Array<MutableList<Int>> {
        val arr = Array<MutableList<Int>>(numCourses) { mutableListOf() }
        prerequisites.forEach { prereq ->
            arr[prereq[0]].add(prereq[1])
        }
        return arr
    }

    // map is a map of class to its prereqs, so it would be 1 -> [[1,2]]
    fun satisfies(current: Int, prerequisites: Array<IntArray>, adjList: Array<MutableList<Int>>, visited: MutableSet<Int>): Boolean {
        if (visited.contains(current)) return false
        val prereqs = adjList[current]
        if (prereqs == null || prereqs.isEmpty()) {
            return true
        }
        visited.add(current)
        return prereqs.all {
            satisfies(it, prerequisites, adjList, visited)
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
}
