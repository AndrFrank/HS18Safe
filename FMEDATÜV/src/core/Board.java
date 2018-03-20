package core;

import java.util.LinkedList;

public class Board {

	
	public String boardName = "";
	private int boardNr = 0;
		
	LinkedList<Component> boardComponentList = new LinkedList<Component>();
	LinkedList<SafetyFunction> safetyFunctionList = new LinkedList<SafetyFunction>();
	
	
	
	public Board(String boardName, int boardNr) {
		this.boardName = boardName;
		this.boardNr = boardNr;
	}
	
	
	
	
	public void addSafetyFunction(SafetyFunction safety) {
		safetyFunctionList.add(safety);
	}
	
	public void addSafetyFunction(String safetyFunctionName) {
		safetyFunctionList.add(new SafetyFunction(safetyFunctionName));
	}
	
	
	
}
