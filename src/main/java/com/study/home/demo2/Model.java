package com.study.home.demo2;

import java.util.Random;

public class Model {
    private final char[][] board;
    public char currentPlayer;

    public Model() {
        board = new char[3][3];
        currentPlayer = 'X'; // Start with player X
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void makeMove(int row, int col) {
        if (isCellOccupied(row, col)) {
            return; // Prevent making moves on occupied cells
        }
        board[row][col] = currentPlayer;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean isCellOccupied(int row, int col) {
        return board[row][col] != '-';
    }

    public boolean isGameOver() {
        // Check rows, columns, and diagonals for winning combinations
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) || checkColumn(i) || checkDiagonal(i)) {
                return true;
            }
        }

        // Check for a draw (no empty cells remaining)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true; // Game is over (either win or draw)
    }

    private boolean checkRow(int row) {
        return board[row][0] != '-' && board[row][0] == board[row][1] && board[row][1] == board[row][2];
    }

    private boolean checkColumn(int col) {
        return board[0][col] != '-' && board[0][col] == board[1][col] && board[1][col] == board[2][col];
    }

    private boolean checkDiagonal(int diagonal) {
        if (diagonal == 0) { // Main diagonal
            return board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2];
        } else { // Off-diagonal
            return board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0];
        }
    }

    public char getWinner() {
        if (isGameOver()) {
            // Check rows, columns, and diagonals for winning combinations
            for (int i = 0; i < 3; i++) {
                if (checkRow(i)) {
                    return board[i][0];
                } else if (checkColumn(i)) {
                    return board[0][i];
                } else if (checkDiagonal(i)) {
                    return board[0][0]; // Assuming diagonal 0 is the winning diagonal
                }
            }
            return '-'; // Draw if no winner
        }
        return '-';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void computerMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (isCellOccupied(row, col));
        makeMove(row, col);
    }

    public char[][] getBoard() {
        return board;
    }
}
