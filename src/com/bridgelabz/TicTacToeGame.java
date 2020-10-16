package com.bridgelabz;

import java.util.Random;
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
	private void displayBoard() {
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
	// UC5
		public void checkFreeSpace(Scanner input) {
			while (true) {
				for (int position = 0; position < 10; position++) {
					if (board[position] == ' ') {
						abilityToMakeMoveForPlayer();
						displayBoard();
					}
				}
			}
		}
		
	//UC6
		private void tossToDecidePlayer() {
			
			if(this.returnHeadOrTail().equalsIgnoreCase("head")) {
				System.out.println("Player plays first");
			}
			else {
				System.out.println("Computer plays first");
			}
		}

		private String returnHeadOrTail() {
			String checkForHeadOrTail;
			int toss = new Random().nextInt(2);
			if(toss==0)
				checkForHeadOrTail = "Head";
			else checkForHeadOrTail = "Tail";
			return checkForHeadOrTail;
		}
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] ticTacToeBoard = ticTacToeGame.assignEmptySpace();
		ticTacToeGame.ChoseFromXandO();
		ticTacToeGame.displayBoard();
		int index = ticTacToeGame.abilityToMakeMoveForPlayer();
		ticTacToeGame.displayBoard();
		ticTacToeGame.tossToDecidePlayer();

	}
}
