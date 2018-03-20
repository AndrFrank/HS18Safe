package core;

import java.util.LinkedList;


/**
 * SafetyFunction, is the class to handle
 * @author  Andreas Frank
 * @version 1.0
 */
public class SafetyFunction {

	public String safetyFunctionName = "";
	
	
	LinkedList<Component> componentList = new LinkedList<Component>();
	
	private double overAlllSd = 0.0;
	private double overAlllSu = 0.0;
	private double overAlllDd = 0.0;
	private double overAlllDu = 0.0;
	
	public double SafeFailureFraction = 0.0;
	Calculation calculate = new Calculation();
	
	
	/**
     * Constructor for the class SafetyFunction.
     * @param safetyFunctionName, which is the name of the function.
     */
	
	
	public SafetyFunction(String safetyFunctionName) {
		this.safetyFunctionName = safetyFunctionName;
	}
	
	/**
     * Adding a new component to the safety function, by creating a new Component with the given parameters. 
     * @param cNumber, which is the number of the component.
     * @param cType, which is the type of the component e.g. "Okotokoppler".
     * @param cFunction, which describes the function of the component.
     */
	
	
	
	public void addComponent(int cNumber, String cType, String cFunction) {
		componentList.add(new Component(cType, cNumber, cFunction));
	}
	
	/**
     * For each component in this safetyfunction, the different lambda values are added to the overAll variables.
     * The overall lambda values are used to calculate the Safefailurefraction.
     */
	
	public void calculateSFF() {
		
		for(Component comp : componentList) {
			for(FailureMode mode :comp.failuremodeList) {
				this.overAlllDd += mode.getLambdaDd();
				this.overAlllDu += mode.getLambdaDu();
				this.overAlllSd += mode.getLambdaSd();
				this.overAlllSu += mode.getLambdaSu();
			}
		}
		this.SafeFailureFraction = calculate.calculateSFF(overAlllSd, overAlllSu, overAlllDd, overAlllDu);
	}
	
	
	
	/**
     * Find a component in the list by the component name.
     * 
     */
	
	//TODO NULL POINTER ABFANGEN
	public Component getComponentByType(String compType) {
		Component comp = null;
		for(Component c : componentList) {
			if(c.componentType.equalsIgnoreCase(compType)) {
				comp = c;
			}
		}
		return comp;
	}
	
	
	
	
	
	
}
