package com.bridgelabz;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	char []board;
	private char playerChar;
	private char computerChar;
	private int count = 0;

	public static enum Player {
		USER, COMPUTER
	};
	
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
		private Player tossToDecidePlayer() {
			
			if(this.returnHeadOrTail().equalsIgnoreCase("head")) {
				System.out.println("Player plays first");
				return Player.USER;

			}
			else {
				System.out.println("Computer plays first");
				return Player.COMPUTER;

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
    
		//UC7
		private void determineNextMove(Player player) {
			count ++;
			if (player.USER == player) {
				displayBoard();
				abilityToMakeMoveForPlayer();
				if (checkifPlayerWon()) {
					System.out.println("Player won");
					displayBoard();
					return;
				}
				if (checkifComputerWon()) {
					System.out.println("Computer won");
					displayBoard();
					return;
				}
				if(count==9) {
					System.out.println("It resulted in a draw");
					displayBoard();
					return;
				}
				determineNextMove(player.COMPUTER);
			} else {
				abilityToMakeMoveForComputer8();
				if (checkifComputerWon()) {
					System.out.println("Computer won");
					displayBoard();
					return;
				}
				if (checkifPlayerWon()) {
					System.out.println("Player won");
					return;
				}
				if(count==9) {
					System.out.println("It resulted in a draw");
					displayBoard();
					return;
				}
				determineNextMove(player.USER);
			}
		}
		private boolean checkifComputerWon() {
			for (int i = 1; i <= 7; i = i + 3) {
				if ((board[i] == computerChar) && (board[i + 1] == computerChar) && (board[i + 2] == computerChar)) {
					return true;
				}
			}
			for (int i = 1; i <= 3; i++) {
				if ((board[i] == computerChar) && (board[i + 3] == computerChar) && (board[i + 6] == computerChar)) {
					return true;
				}
			}
			return ((board[1] == computerChar) && (board[5] == computerChar) && (board[9] == computerChar))
					|| ((board[3] == computerChar) && (board[5] == computerChar) && (board[7] == computerChar));
		}
		
		private boolean checkifPlayerWon() {
			for(int i = 1 ;i<=7;i=i+3) {
				if(board[i]==playerChar&&board[i+1]==playerChar&&board[i]==playerChar) {
					return true;
				}
			}
			for(int i = 1; i<=3 ;i++) {
				if(board[i]==playerChar&&board[i+3]==playerChar&&board[i+6]==playerChar) {
					return true;
				}
			}
			return (board[1]==playerChar&&board[5]==playerChar&&board[9]==playerChar)||(board[3]==playerChar&&board[5]==playerChar&&board[7]==playerChar);
		}

		private void abilityToMakeMoveForComputer() {
			while (true) {
				int index = new Random().nextInt(10);
				if (index < 1) {
					continue;
				}
				if (board[index] == ' ') {
					board[index] = computerChar;
					return;
				} else {
					continue;
				}
			}
		}
		private void abilityToMakeMoveForComputer8() {
			for (int i = 1; i < 10; i++) {
				if (board[i] == ' ') {
					board[i] = computerChar;
					if (checkifComputerWon()) {
						return;
					}
					board[i] = playerChar;
					if(checkifPlayerWon()) {
						board[i]=computerChar;
						return;
					}
					board[i]=' ';
				}
			}
			
			//choosing out of 4 corners
			if(board[1]==' ') {
				board[1]=computerChar;
				return;
			}
			else if(board[3]==' ') {
				board[3]=computerChar;
				return;
			}
			else if(board[7]==' ') {
				board[7]=computerChar;
				return;
			}
			else if(board[9]==' ') {
				board[9]=computerChar;
				return;
			}

			//choosing centre
			else if(board[5]==' ') {
				board[5]=computerChar;
				return;
			}

		}
		
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] ticTacToeBoard = ticTacToeGame.assignEmptySpace();
		ticTacToeGame.ChoseFromXandO();
		Player player = ticTacToeGame.tossToDecidePlayer();
		ticTacToeGame.determineNextMove(player);
        ticTacToeGame.abilityToMakeMoveForComputer8();
	}
}
