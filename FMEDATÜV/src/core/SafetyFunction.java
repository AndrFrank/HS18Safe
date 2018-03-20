package core;

import java.util.LinkedList;

public class SafetyFunction {

	public String safetyFunctionName = "";
	
	
	
	LinkedList<Component> componentList = new LinkedList<Component>();
	
	private double overAlllSd = 0.0;
	private double overAlllSu = 0.0;
	private double overAlllDd = 0.0;
	private double overAlllDu = 0.0;
	
	public double SafeFailureFraction = 0.0;
	Calculation calculate = new Calculation();
	
	
	
	public SafetyFunction(String safetyFunctionName) {
		this.safetyFunctionName = safetyFunctionName;
	}
	
	
	public void addComponent(int cNumber, String cType, String cFunction) {
		componentList.add(new Component(cNumber,cType, cFunction));
	}
	
	
	
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
