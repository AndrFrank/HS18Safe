package core;
/**
 * FailureMode, is the class to create failurModes. 
 * @author  Andreas Frank
 * @version 1.0
 */

public class FailureMode {
	/**
     * The isPartOfComponent is used for later database operations
     * 
     */
	
	
	public String isPartOfComponent = "";
	public String failureModeDescription = "";
	public double overAllProportion = 0.0;
	
	public String measures = "";
	
	public double dc = 0.0;
	//TODO FÜR DC: Eingabehilfe für Normen. Neue Klasse für DC mit double und zugehörige Norm
	public String comment = "";
	
	private double lSd = 0.0;
	private double lSu = 0.0;
	private double lDd = 0.0;
	private double lDu = 0.0;
	
	//TODO: don´t care boolische variable 
	
	/**
     * Constructor for the class Component.
     * @param isPartofComponent, which is used for later database operations.
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
	
	
	/**
     * Constructor for the class Component. To create an empty failureMode. This is used, if the lambda values are not available at the creation moment
     * @param isPartofComponent, which is used for later database operations.
     * @param failureModeDescription, describes what the FailureMode is about.
     */
	
	public FailureMode(String isPartOfComponent, String failurModeDescription) {
		this.isPartOfComponent = isPartOfComponent;
		this.failureModeDescription = failurModeDescription;
	}
	
	/**
     * Setter of the different lambda values.
     */
	
	
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
	
	
	/**
     * Getter of the different lambda values.
     */
	
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
