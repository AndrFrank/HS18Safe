package core;

public class Main {

	public static void main(String[] args) {
	
		
		Project test = new Project("Testproject", "Dieses Project dient als Test", "Keinen Ahnung", 1, "enz", "2018.02.28", "Andi", 0.1);
		
		
		
		
		
		test.addSafetyFunction("Platine");
		SafetyFunction plat = test.getSafetyFunctionByName("Platine");
		System.out.println(plat.safetyFunctionName);
		
		plat.addComponent(1, "Optokoppler", "Entkoppelt eingangssignale");
		
		Component opto = plat.getComponentByType("Optokoppler");
		opto.addFailureMode("Unterbrechung Sender", 0.25, "measures", 1, "comment", 0.5, 0.2, 0.2, 0.1);
		opto.addFailureMode("Kurz Schluss", 0.033, "measures", 1, "comment", 0.2, 0.3, 0.3, 0.2);
		opto.addFailureMode("Unterbrechung Empfänger", 0.25, "measures", 1, "comment", 0.0, 0.2, 0.2, 0.6);
		opto.addFailureMode("Unterbrechung Sender", 0.25, "measures", 1, "comment", 0.5, 0.2, 0.2, 0.1);
		
		
		plat.calculateSFF();
		System.out.println(plat.SafeFailureFraction);
		
	}

}
