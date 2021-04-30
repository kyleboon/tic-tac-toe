package boon

import boon.PositionState.X

fun main() {
    val game = GameState(3)
    game.apply(Move(1,1, X)).ttyDisplay()
}
