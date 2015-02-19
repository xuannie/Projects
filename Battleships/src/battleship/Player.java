package battleship;

public class Player {
	String name;
	Board player;
	Board opponent;
	
	public Player(){
		name = "Player 1";
		player = new Board();
		opponent = new Board();
	}
	
	public Player(String getName){
		if (getName.equals("comp"))
			name = "AI";
		else
			name = getName;
		
		player = new Board();
		opponent = new Board();
	}
	
	public void placeShips(Ships a){
		//TODO Add ships to board.
	}

	public void shoot(int x, int y){
		if (opponent.checkHit(x, y)){
			//TODO Change coordinates to 1 if hit, 0 if miss
		}
				
	}

	
	public void showBoard(){
		
	}

}
