package org.example.tictactoe.models;

import com.sun.source.doctree.SerialTree;
import org.example.tictactoe.exception.InvalidMoveException;
import org.example.tictactoe.strategies.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;

    public static Builder getBuilder() {
        return new Builder();
    }

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.nextMovePlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void printBoard() {
        board.printBoard();
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getDimension() || col < 0 || col >= board.getDimension()) {
            return false;
        }

        //Whether the cell at which player is trying to make a move is empty or not.
        if (!board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            return false;
        }

        return true;
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextMovePlayerIndex);

        System.out.println("This is " + currentPlayer.getName() + "'s move.");

        //Player will choose the move that they want to make.
        Move move = currentPlayer.makeMove(board);

        //Game will validate if the move that player has chosen is valid or not.
        if (!validateMove(move)) {
            //throw some exception to the player.
            throw new InvalidMoveException("Invalid move, please retry");
        }

        //Move is valid, so apply this move to the board.
        int row = move.getCell().getRow(); // 2
        int col = move.getCell().getCol(); // 1

        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        Move finalMove = new Move(currentPlayer, cell);
        moves.add(finalMove);

        nextMovePlayerIndex = (nextMovePlayerIndex + 1) % players.size();

        if (checkWinner(finalMove)) {
            winner = currentPlayer;
            gameState = GameState.ENDED;
        } else if (moves.size() == board.getDimension() * board.getDimension()) {
            gameState = GameState.DRAW;
        }
    }

    private boolean checkWinner(Move move) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        //private List<Move> moves;
        //private Player winner;
        //private GameState gameState;
        //private int nextMovePlayerIndex;

        private Builder() {
            this.players = new ArrayList<>();
            this.dimension = 0;
            this.winningStrategies = new ArrayList<>();
        }

        private void validateBotCount() {
            int count = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    count += 1;
                    if (count > 1) {
                        throw new RuntimeException("Only one BOT is allowed per game");
                    }
                }
            }
        }

        private void validateUniqueSymbols() {
            Set<Character> symbolSet = new HashSet<>();
            for (Player player : players) {
                symbolSet.add(player.getSymbol().getaChar());
            }

            if (symbolSet.size() != dimension - 1) {
                throw new RuntimeException("Every player should have a unique symbol");
            }
        }

        private void validations() {
            validateBotCount();
            validateUniqueSymbols();
        }

        public Game build() {
            //validations
            validations();

            return new Game(dimension, players, winningStrategies);
        }

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
    }
}
