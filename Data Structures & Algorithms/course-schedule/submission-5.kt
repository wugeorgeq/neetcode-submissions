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
        val adjList = buildAdjacencyList(numCourses, prerequisites)
        
        // ok let's use a state array to manage the states of 
        // 0 unvisited
        // 1 visiting
        // 2 safe
        val state = IntArray(numCourses)
        fun hasCycle(current: Int): Boolean {
            if (state[current] == 1) return true
            if (state[current] == 2) return false
            val prereqs = adjList[current]
            state[current] = 1
            if (prereqs.any { hasCycle(it)}) return true
            state[current] = 2
            return false
        }
        return prerequisites.none { hasCycle(it[0]) }
    }

    fun buildAdjacencyList(numCourses: Int, prerequisites: Array<IntArray>): Array<MutableList<Int>> {
        val arr = Array<MutableList<Int>>(numCourses) { mutableListOf() }
        prerequisites.forEach { prereq ->
            arr[prereq[0]].add(prereq[1])
        }
        return arr
    }

    // map is a map of class to its prereqs, so it would be 1 -> [[1,2]]
    // fun satisfies(current: Int, prerequisites: Array<IntArray>, adjList: Array<MutableList<Int>>, visited: MutableSet<Int>,
    // satisfiedSet: MutableSet<Int>): Boolean {
    //     if (visited.contains(current)) return false
    //     if (satisfiedSet.contains(current)) return true
    //     val prereqs = adjList[current]
    //     if (prereqs == null || prereqs.isEmpty()) {
    //         satisfiedSet.add(current)
    //         return true
    //     }
    //     visited.add(current)
    //     val satisfied = prereqs.all {
    //         satisfies(it, prerequisites, adjList, visited, satisfiedSet)
    //     }
    //     visited.remove(current)
    // }
}
