package org.example.tictactoe;

import org.example.tictactoe.controllers.GameController;
import org.example.tictactoe.models.*;
import org.example.tictactoe.strategies.winningstrategy.ColWinningStrategy;
import org.example.tictactoe.strategies.winningstrategy.DiagonalWinningStrategy;
import org.example.tictactoe.strategies.winningstrategy.RowWinningStrategy;
import org.example.tictactoe.strategies.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) {
        System.out.println("GAME STARTS");
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        //int dimension = scanner.nextInt();
        int dimension = 3;

        //Take players information in the input.
        List<Player> players = new ArrayList<>();
        players.add(
                new Player(new Symbol('X'), "Anand", PlayerType.HUMAN)
        );

        players.add(
                new Bot(new Symbol('O'), "Scaler", PlayerType.BOT, BotDifficultyLevel.EASY)
        );

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        Game game = gameController.startGame(dimension, players, winningStrategies);

        //gameController.printBoard(game);
        //Let's play the game.

        while (gameController.gameState(game).equals(GameState.IN_PROGRESS)) {
            //1. Show the board.
            //2. make a move.

            gameController.printBoard(game);

            System.out.println("Do you want to undo ?");
            String isUndo = scanner.next();

            if (isUndo.equalsIgnoreCase("y")) {
                //make an undo operation
                gameController.undo(game);
                continue;
            }

            gameController.makeMove(game);
        }

        System.out.println("DEBUG");


    }
}
