package com.bridgelabz;

public class TicTacToeGame {
	char []board;
	
	//UC1
			private char[] assignEmptySpace() {
				this.board = new char[10];
				for (int index = 1; index < 10; index++) {
					board[index] = ' ';
				}
				return board;
			}
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] ticTacToeBoard = ticTacToeGame.assignEmptySpace();
	}
}
