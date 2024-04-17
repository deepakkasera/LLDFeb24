package org.example.tictactoe.controllers;

import org.example.tictactoe.exception.InvalidMoveException;
import org.example.tictactoe.models.Game;
import org.example.tictactoe.models.GameState;
import org.example.tictactoe.models.Player;
import org.example.tictactoe.strategies.winningstrategy.WinningStrategy;

import java.util.List;

public class GameController {
    //makeMove
    //undo
    //checkWinner
    //gameState

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        return Game.getBuilder().setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState gameState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void undo(Game game) {

    }
}
