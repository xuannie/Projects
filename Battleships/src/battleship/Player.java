package battleship;

public class Player {
	String name;
	Board player;
	Board opponent;
	
	public Player(){
		name = "Jake";
		player = new Board();
		opponent = new Board();
	}
	
	public Player(String getName){
		name = getName;
		player = new Board();
		opponent = new Board();
	}

}
