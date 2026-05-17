class Solution {
    /**
    1,2,+,3,4,+,* means (1 + 2) * (3 + 4)

    at every step we're either holding one operand or two, both of which we're waiting
    for an operator. then we can combine the 2 held values with operand

    but ... how do we know if the result is going to be part of another expression like
    the above example? i guess we keep holding it? 

    lifo stack makes sense here because we always want the most recent operand when
    evaluating. 

    at the end there's no tokens left and we've evaluated?
    */
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<String>()
        for (token in tokens) {
            when (token) {
                "+", "*", "/", "-" -> {
                    val operand2 = stack.removeLast().toInt()
                    val operand1 = stack.removeLast().toInt()
                    stack.addLast(when (token) {
                        "+" -> operand1 + operand2
                        "-" -> operand1 - operand2
                        "*" -> operand1 * operand2
                        "/" -> operand1 / operand2
                        else -> throw IllegalStateException("impossibru")
                    }.toString())
                }
                else -> stack.addLast(token)
            }
        }
        return stack.removeLast().toInt()
    }
}
