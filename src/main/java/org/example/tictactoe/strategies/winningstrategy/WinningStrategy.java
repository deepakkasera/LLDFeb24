package org.example.tictactoe.strategies.winningstrategy;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Cell;
import org.example.tictactoe.models.Move;
import org.example.tictactoe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
