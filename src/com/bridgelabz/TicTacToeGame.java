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
	//UC3
	private void diplayBoard() {
		for(int row = 0;row<3;row++) {
			for(int col = row*3+1;col<row*3+4;col++) {
				System.out.print(board[col]);
			}
			System.out.println(" ");
		}
	}
	
	//UC4
	private int abilityToMakeMoveForPlayer() {
		System.out.println("Enter the position where you want to add : " + playerChar);
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		if(index<1&&index>10) {
			System.out.println("Invalid position");
			return -1;
		}
		if (board[index] == ' ') {
			board[index] = playerChar;
			return index;
		}
		else {
			System.out.println("This position is already filled");
			return 0;
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] ticTacToeBoard = ticTacToeGame.assignEmptySpace();
		ticTacToeGame.ChoseFromXandO();
		ticTacToeGame.diplayBoard();
		int index = ticTacToeGame.abilityToMakeMoveForPlayer();
		ticTacToeGame.diplayBoard();
	}
}
