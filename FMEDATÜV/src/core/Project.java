package core;
/**
 * Project, is the class, on which all Stuff is based. Each Project contains a list of circuit boards and a list of components which are the same on each circuit boards.
 * @author  Andreas Frank
 * @version 1.0
 */

import java.util.LinkedList;

public class Project {

	public String porjectName = "";
	public String projectDescription = "";
	public String module = "";
	public int projectnumber = 0;
	public String referenz = "";
	public String Date = "";
	public String author= "";
	public double version = 0.0;
	
	LinkedList<Board> boardList = new LinkedList<Board>();
	LinkedList<Component> usedForAllBoards = new LinkedList<Component>();
	
	
	

	/**
     * Constructor for the class Board.
     * @param pName, which is the name of this project.
     * @param pDescription, which contains a description of the project.
     * @param module, needs to be edited.
     * @param pNumber, which gives the project a number to specify it.
     * @param referenz,
     * @param date, which is the creation date.
     * @param author, which is the creator of the project.
     * @param version, which is the version of this project.
     */
	
	
	public Project(String pName, String pDescription, String module, int pNumber, String referenz, String date, String author, double version) {
		this.porjectName = pName;
		this.projectDescription = pDescription;
		this.module = module;
		this.projectnumber = pNumber;
		this.referenz = referenz;
		this.Date = date;
		this.author = author;
		this.version = version;
	}
	
	/**
     * Adding a new circuit board to the project board list.
     * @param boardName, which is a spesific board name.
     */
	
	public void addBoard(String boardName) {
		int boardID = boardList.size();
		boardList.add(new Board(boardName, boardID));
	}
	
	/**
     * Removing a new circuit board from the project board list.
     * @param boardName, which is the name of the board that should be removed.
     * TODO: Add logic
     */
	
	public void removeboard(String boardName) {
		for(Board b : boardList) {
			
		}
	}
	
	
	/**
     * Finding a new circuit board in the project board list.
     * @param boardName, which is the name of the board that should be found.
     * 
     */
	
	public Board getBoardFromList(String boardName) throws Exception {
		Board board = new Board("Dummy",0);
		for(Board b : boardList) {
			if (b.boardName == boardName){
				board = b;
			}
			else {
				throw new Exception("Board konnte nicht gefunden werden!");
				
			}
		}
		return board;
		
	}
	
	
}
