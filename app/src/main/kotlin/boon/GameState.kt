package boon

enum class PositionState { X, O }

class GameState(
    val size: Int,
    val moves: List<Move> = emptyList<Move>(),
    val nextTurn: PositionState = PositionState.X
) {
    fun apply(move: Move): GameState {
        if (moves.any { it.x == move.x && it.y == move.y }) {
            throw IllegalStateException("Cannot make ${move} because that spot is taken")
        }

        val newGrid = ArrayList(this.moves).plus(move)
        return GameState(size, newGrid)
    }

    fun get(x: Int, y: Int): PositionState? =
        moves.find { it.x == x && it.y == y }?.positionState

    fun isGameOver() : Boolean {
        // check rows
        repeat(size) { index: Int ->
            // check rows
            val rowMoves = moves.filter { it.x == index }
            if (rowMoves.size == size && (rowMoves.all { it.positionState == PositionState.X } || rowMoves.all { it.positionState == PositionState.O})) return true

            val columnMoves = moves.filter { it.y == index }
            if (columnMoves.size == size && (columnMoves.all { it.positionState == PositionState.X } || columnMoves.all { it.positionState == PositionState.O})) return true
        }

        // check 1 diagonal
        val diagonalMoves = moves.filter { it.x == it.y }
        if (diagonalMoves.size == size && (diagonalMoves.all { it.positionState == PositionState.X } || diagonalMoves.all { it.positionState == PositionState.O})) return true

        // check opposite diagonal
        val oppositeDiagonalPairs = (1..size).map { index ->
            Pair(size - (index - 1), index)
        }
        val oppositeDiagonalMoves = moves.filter { move -> oppositeDiagonalPairs.any { it.first == move.x && it.second == move.y} }
        if (oppositeDiagonalMoves.size == size && (oppositeDiagonalMoves.all { it.positionState == PositionState.X } || oppositeDiagonalMoves.all { it.positionState == PositionState.O})) return true

        return false
    }
}

data class Move(val x: Int, val y: Int, val positionState: PositionState)

fun GameState.ttyDisplay() {
    var result = ""

    repeat(this.size) { rowIdx ->
        repeat(this.size) { colIdx ->
            result += this.get(rowIdx, colIdx) ?: " "
            if (colIdx < size - 1) {
                result += "|"
            }
        }

        if (rowIdx < size - 1) {
            result += "\n"
            for (i in 1..size * 2 - 1) {
                result += if (i % 2 == 0) '+' else "-"
            }
            result += "\n"
        }
    }

    println(result)
}