package boon

import boon.PositionState.O
import boon.PositionState.X
import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import org.junit.Test

internal class GameStateTest {
    @Test
    fun `game is over for X when a column has all Xs`() {
        val size = randomInt(2..10)
        val randomX = randomInt(1..size)
        val moves = (1..size).map { index ->
            Move(randomX, index, X)
        }

        GameState(size, moves).isGameOver().shouldBeTrue()
    }

    @Test
    fun `game is over for O when a column has all Xs`() {
        val size = randomInt(2..10)
        val randomX = randomInt(1..size)
        val moves = (1..size).map { index ->
            Move(randomX, index, O)
        }

        GameState(size, moves).isGameOver().shouldBeTrue()
    }

    @Test
    fun `game is not over when a column is full but not heterogeneous`() {
        val size = randomInt(2..10)
        val randomX = randomInt(1..size)
        val moves = (1..size).map { index ->
            Move(randomX, index, if (index % 2 == 0) X else O)
        }

        GameState(size, moves).isGameOver().shouldBeFalse()
    }

    @Test
    fun `game is over for X when a row has all Xs`() {
        val size = randomInt(2..10)
        val randomY = randomInt(1..size)
        val moves = (1..size).map { index ->
            Move(index, randomY, X)
        }

        GameState(size, moves).isGameOver().shouldBeTrue()
    }

    @Test
    fun `game is over for O when a row has all Xs`() {
        val size = randomInt(2..10)
        val randomY = randomInt(1..size)
        val moves = (1..size).map { index ->
            Move(index, randomY, O)
        }

        GameState(size, moves).isGameOver().shouldBeTrue()
    }

    @Test
    fun `game is not over when a row is full but not heterogeneous`() {
        val size = randomInt(2..10)
        val randomY = randomInt(1..size)
        val moves = (1..size).map { index ->
            Move(index, randomY, if (index % 2 == 0) X else O)
        }

        GameState(size, moves).isGameOver().shouldBeFalse()
    }

    @Test
    fun `game is over for X when a diagonal has all Xs`() {
        val size = randomInt(2..10)
        val moves = (1..size).map { index ->
            Move(index, index, X)
        }

        GameState(size, moves).isGameOver().shouldBeTrue()
    }

    @Test
    fun `game is over for X when a diagonal has all Os`() {
        val size = randomInt(2..10)
        val moves = (1..size).map { index ->
            Move(index, index, O)
        }

        GameState(size, moves).isGameOver().shouldBeTrue()
    }

    @Test
    fun `game is not over when a diagonal is full but not heterogeneous`() {
        val size = randomInt(2..10)
        val moves = (1..size).map { index ->
            Move(index, index, if (index % 2 == 0) X else O)
        }

        GameState(size, moves).isGameOver().shouldBeFalse()
    }

    @Test
    fun `game is over when opposite diagonal has all Xs`() {
        val size = 3
        val moves = listOf(
            Move(3, 1, X),
            Move(2, 2, X),
            Move(
                1, 3, X
            )
        )

        GameState(size, moves).isGameOver().shouldBeTrue()
    }


}