package core;

import java.util.LinkedList;

/**
 * Board, is the class to handle a circuit board. Each circuit board has a list for the installed components, and a list for the relevant safety functions.
 * @author  Andreas Frank
 * @version 1.0
 */



public class Board {
	 /**
     * The boardName is used to identify the board in later operations
     * 
     */
	
	public String boardName = "";
	private int boardNr = 0;
		
	LinkedList<Component> boardComponentList = new LinkedList<Component>();
	LinkedList<SafetyFunction> safetyFunctionList = new LinkedList<SafetyFunction>();
	
	/**
     * Construktor for the class Board.
     * @param boardName, which specify a board by the name.
     * @param boardNr, which gives the board a specific number.
     * @see If the constructor is called from the project class, the board number is generated automatically.
     */
	
	public Board(String boardName, int boardNr) {
		this.boardName = boardName;
		this.boardNr = boardNr;
	}
	
	
	/**
     * Adding a new safetyFunction to the safetyfunctionList of the board 
     * @param safety, which is a already created SafetyFunction object
     */
	
	public void addSafetyFunction(SafetyFunction safety) {
		safetyFunctionList.add(safety);
	}
	
	/**
     * Adding a new safetyFunction to the safetyfunctionList of the board, by creating a new SafetyFunction with the given function name 
     * @param safetyFunctionName, which is the name of the new created function
     */
	
	public void addSafetyFunction(String safetyFunctionName) {
		safetyFunctionList.add(new SafetyFunction(safetyFunctionName));
	}
	
	/**
     * Adding a new component to the ComponentList of the board, by creating a new Component with the given parameters 
     * @param cType, which describes the component Type e.g. "Oktokoppler".
     * @param cFunction, which describes the function of the component.
     */
	
	public void addComponent(String cType, String cFunction) {
		int size = boardComponentList.size();
		boardComponentList.add(new Component(cType,size, cFunction));
	}
	
	/**
     * Adding a new component to the ComponentList of the board, using an already existing component. 
     * @param component, which is the existing component, that should be added.
     */
	
	public void addComponent(Component component) {
		boardComponentList.add(component);
	}
	
}
