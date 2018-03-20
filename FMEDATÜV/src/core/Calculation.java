package core;

public class Calculation {

	/**
	 * Calculation, is the class to handle all calcualations .
	 * @author  Andreas Frank
	 * @version 1.0
	 */

	
	
	
	
	
	
	public double calculateSFF(double lSd, double lSu, double lDd, double lDu) {
		
		double sff = ((lSd + lSu + lDd) / (lSd + lSu + lDd + lDu));
		return sff;
	}
	
	
}
