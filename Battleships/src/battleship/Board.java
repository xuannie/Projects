package battleship;

public class Board {
	int[][] board;

	/**
	 * Creates an empty board. 
	 */
	public Board(){
		board = new int[10][10];
		for (int i=0; i<10; i++){
			for (int j=0; j<10; j++)
				board[i][j] = -1;
		}
	}	
	
	boolean checkHit(int x, int y){
		//check(this.board[x][y])
		return false;
	}
}
