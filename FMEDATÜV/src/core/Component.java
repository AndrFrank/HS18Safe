package core;

import java.util.LinkedList;

public class Component {

	public int componentNumber = 0;
	public String componentType ="";
	public String componentFunction = "";
	
	public LinkedList<FailureMode> failuremodeList = new LinkedList<>();
	
	
	
	
	
	public Component(int cNumber, String cType, String cFunction) {
		this.componentNumber = cNumber;
		this.componentType = cType;
		this.componentFunction = cFunction;
	}
	
	
	
	public void addFailureMode(String failurModeDescription, double overAllProportion, String measures, double dc, String comment, double lSd, double lSu, double lDd, double lDu) {
		failuremodeList.add(new FailureMode(this.componentType, failurModeDescription, overAllProportion, measures, dc, comment, lSd, lSu, lDd, lDu));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
