package core;

import java.util.LinkedList;
/**
 * Component, is the class to create components. Each component contains a list of failure modes.
 * @author  Andreas Frank
 * @version 1.0
 */

public class Component {

	public int componentNumber = 0;
	public String componentType ="";
	public String componentFunction = "";
	
	public LinkedList<FailureMode> failuremodeList = new LinkedList<>();
	
	
	/**
     * Constructor for the class Component.
     * @param cType, which specify the component type e.g. "Oktokoppler" .
     * @param cNumber, which gives the component a specific number.
     * @param cFunction, which describes the function of component.
     */
	
	
	public Component(String cType, int cNumber, String cFunction) {
		
		this.componentType = cType;
		this.componentNumber = cNumber;
		this.componentFunction = cFunction;
	}
	
	
	
	/**
     * Adding a new failure mode to the failure mode list, by creating a new FailureMode with the given parameters 
     * @param failureModeDescription, which describes the failureMode.
     * @param overAllProportion, this is holding the overall percentage of the failureMode.
     * @param measure, which comments the measures that could be used to handle the failureMode.
     * @param dc, which is the diagnostic coverage.
     * @param comment, which can be used to write an informational comment
     * @param lSd, which is the lambda safe detected.
     * @param lSu, which is the lambda safe undetected.
     * @param lDd, which is the lambda dangerous detected.
     * @param lDu, which is the lambda dangerous undetected.
     */
	
	
	public void addFailureMode(String failurModeDescription, double overAllProportion, String measures, double dc, String comment, double lSd, double lSu, double lDd, double lDu) {
		failuremodeList.add(new FailureMode(this.componentType, failurModeDescription, overAllProportion, measures, dc, comment, lSd, lSu, lDd, lDu));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
