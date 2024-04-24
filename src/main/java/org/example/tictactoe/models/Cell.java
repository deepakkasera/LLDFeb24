package org.example.tictactoe.models;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    //If for any cell, player object is NULL then it means cell is empty.
    //If player isn't NULL then cell is filled.

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }

    public void display() {
        if (player == null) {
            //cell is empty
            System.out.print("| -- |");
        } else {
            System.out.print("| " + player.getSymbol().getaChar() + " |") ;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
