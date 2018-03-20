package core;

public class Calculation {

	
	
	
	
	
	
	
	public double calculateSFF(double lSd, double lSu, double lDd, double lDu) {
		
		double sff = ((lSd + lSu + lDd) / (lSd + lSu + lDd + lDu));
		return sff;
	}
	
	
}
