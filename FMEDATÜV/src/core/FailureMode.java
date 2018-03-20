package core;

public class FailureMode {

	public String isPartOfComponent = "";
	public String failureModeDescription = "";
	public double overAllProportion = 0.0;
	
	public String measures = "";
	
	public double dc = 0.0;
	//FÜR DC: Eingabehilfe für Normen. Neue Klasse für DC mit double und zugehörige Norm
	public String comment = "";
	
	private double lSd = 0.0;
	private double lSu = 0.0;
	private double lDd = 0.0;
	private double lDu = 0.0;
	
	//don´t care boolische variable 
	
	
	public FailureMode(String isPartofComponent, String failurModeDescription, double overAllProportion, String measures, double dc, String comment, double lSd, double lSu, double lDd, double lDu) {
		
		this.isPartOfComponent = isPartofComponent;
		this.failureModeDescription = failurModeDescription;
		this.overAllProportion = overAllProportion;
		this.measures = measures;
		this.dc = dc;
		this.comment = comment;
		this.lSd = lSd;
		this.lSu = lSu;
		this.lDd = lDd;
		this.lDu = lDu;
		
		
		
	}
	
	
	public FailureMode(String isPartOfComponent, String failurModeDescription) {
		this.isPartOfComponent = isPartOfComponent;
		this.failureModeDescription = failurModeDescription;
	}
	
	
	
	public void setLambdaSd(double lSd) {
		this.lSd = lSd;
	}
	
	public void setLambdaSu(double lSu) {
		this.lSu = lSu;
	}
	
	
	public void setLambdaDd(double lDd) {
		this.lDd = lDd;
	}
	
	
	public void setLambdaDu(double lDu) {
		this.lDu = lDu;
	}
	
	
	public double getLambdaSd() {
		return this.lSd;
	}
	
	public double getLambdaSu() {
		return this.lSu;
	}
	public double getLambdaDd() {
		return this.lDd;
	}
	public double getLambdaDu() {
		return this.lDu;
	}
	
	
	
	
	
	
	
	
}
