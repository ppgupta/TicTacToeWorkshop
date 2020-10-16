package com.bridgelabz;

import java.util.Scanner;

public class TicTacToeGame {
	char []board;
	private char playerChar;
	private char computerChar;
	
	
	public char getPlayerChar() {
		return playerChar;
	}

	public char getComputerChar() {
		return computerChar;
	}

	public void setComputerChar(char playerChar) {
		if(playerChar == 'O')
			this.computerChar = 'X';
		else
			this.computerChar = 'O';
	}

	public void setPlayerChar(char playerChar) {

		this.playerChar = playerChar;
	}
	//UC1
	
	private char[] assignEmptySpace() {
				this.board = new char[10];
				for (int index = 1; index < 10; index++) {
					board[index] = ' ';
				}
				return board;
	}
			
	//UC2
	private void ChoseFromXandO() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice : X or O");
		this.setPlayerChar(sc.next().charAt(0));
		this.setComputerChar(this.playerChar);
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] ticTacToeBoard = ticTacToeGame.assignEmptySpace();
		ticTacToeGame.ChoseFromXandO();
	}
}
