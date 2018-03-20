package core;


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
	
	
	public void addBoard(String boardName) {
		int boardID = boardList.size();
		boardList.add(new Board(boardName, boardID));
	}
	
	
	public void removeboard() {
		for(Board b : boardList) {
			
		}
	}
	
	
	
	
}
