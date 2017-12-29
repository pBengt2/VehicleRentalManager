abstract class Vehicle{
	protected String make;
	protected String model;
	protected int year;
	protected String status;
	protected int id;
	protected double dailyCost;
	
	public void changeStatus(String Status){
		status = Status;
	}
	
	public void printInfo(){
		System.out.println(id + ": " + make + " " + model + ", " + year);
		System.out.println("   Status:     " + status);
		System.out.println("   Cost:       " + dailyCost);
	}
	
	public int getID(){
		return id;
	}
	
	public boolean isAvailable(){
		if (status.equals("available"))
			return true;
		return false;
	}
}

class Car extends Vehicle{
	private String bodyType;
	
	Car(){
		make = "Unknown";
		model = "Unknown";
		year = -1;
		status = "Unknown";
		id = -1;
		bodyType = "Unknown";
	}
	
	Car(String Make, String Model, int Year, String Status, int ID, double DailyCost, String BodyType){
		make = Make;
		model = Model;
		year = Year;
		status = Status;
		id = ID;
		dailyCost = DailyCost;
		bodyType = BodyType;
	}
	
	@Override
	public void printInfo(){
		super.printInfo();
		System.out.println("   Body type:  " + bodyType);
	}
}

class Truck extends Vehicle{
	double maxCargo;
	
	Truck(String Make, String Model, int Year, String Status, int ID, double DailyCost, double MaxCargo){
		make = Make;
		model = Model;
		year = Year;
		status = Status;
		id = ID;
		dailyCost = DailyCost;			
		maxCargo = MaxCargo;
	}

	@Override
	public void printInfo(){
		super.printInfo();
		System.out.println("   Max cargo:  " + maxCargo);
	}		
}

class Minivan extends Vehicle{
	private double length;
	private double width;
	
	Minivan(String Make, String Model, int Year, String Status, int ID, double DailyCost, double Length, double Width){
		make = Make;
		model = Model;
		year = Year;
		status = Status;
		id = ID;
		dailyCost = DailyCost;			
		length = Length;
		width = Width;
	}
	
	@Override
	public void printInfo(){
		super.printInfo();
		System.out.println("   Dimensions: " + length + " x " + width);
	}		
}