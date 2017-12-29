import java.util.Scanner;

class VehicleRentalManager{
	private Node vHead = null;
	private int nextID = 1;
	
	public static void main(String[] args){
		System.out.println("\nWelcome to the Vehicle Rental Manager!");
		
		VehicleRentalManager vrm = new VehicleRentalManager();
		
		vrm.processCommandLoop();
	}
	
	public void processCommandLoop(){
		Scanner scan;
		
		while (true){
			System.out.println("\nPlease enter a command:");			
			scan = new Scanner(System.in);
			String command = scan.next();
			
			if (command.equals("v"))
				addVehicle(scan);
			else if (command.equals("c"))
				changeStatus(scan);
			else if (command.equals("d"))
				resetList();
			else if (command.equals("l"))
				listVehicles();
			else if (command.equals("a"))
				listVehiclesForRental();
			else if (command.equals("q"))
				System.exit(1);
			else
				System.out.println("Command unknown");
		}
	}
	
	void addVehicle(Scanner scan){
		String kind;
		String make;
		String model;
		int year;
		String status;
		double dailyCost;
		Vehicle tempV;
		
		System.out.println("Input vehicle kind (car, truck, minivan):");
		kind = scan.next();
		
		if (!kind.equals("car") && !kind.equals("truck") && !kind.equals("minivan")){
			System.out.println("Invalid vehicle kind");
			return;
		}
		
		System.out.println("Input vehicle make: ");
		make = scan.next();
		
		System.out.println("Input vehicle model: ");
		model = scan.next();
		
		System.out.println("Input vehicle year: ");
		year = scan.nextInt();
		
		System.out.println("Input vehicle status (available, rented, repair): ");
		status = scan.next();
		
		System.out.println("Input the price for rental (daily): ");
		dailyCost = scan.nextDouble();
		
		if (kind.equals("car")){
			String bodyType;
			System.out.println("Input vehicle body type: ");
			bodyType = scan.next();
			
			tempV = new Car(make, model, year, status, nextID, dailyCost, bodyType);
		}
		else if (kind.equals("truck")){
			double maxCargo;
			System.out.println("Input max cargo: ");
			maxCargo = scan.nextDouble();
			
			tempV = new Truck(make, model, year, status, nextID, dailyCost, maxCargo);
			
		}
		else if (kind.equals("minivan")){
			double length;
			double width;
			System.out.println("Input length: ");
			length = scan.nextDouble();
			System.out.println("Input width: ");
			width = scan.nextDouble();
		
			tempV = new Minivan(make, model, year, status, nextID, dailyCost, length, width);		
		}
		else
			return; //not possible, but pleases compiler.

		if (vHead == null)
			vHead = new Node(tempV);
		else{				
			Node cur = vHead;
			while (cur.getNext() != null)
				cur = cur.getNext();
			cur.setNext(new Node(tempV));
		}
		nextID++;
	}
	
	void changeStatus(Scanner scan){
		int id;
		String status;
		
		System.out.println("Enter the vehicle id: ");
		id = scan.nextInt();
		
		Node cur = vHead;
		while (cur != null){
			if (cur.getVehicle().getID() == id){
				System.out.println("Enter the status (available, rented, repair: ");
				status = scan.next();
				
				cur.getVehicle().changeStatus(status);
				return;
			}
		}
		System.out.println("Vehicle not found");
	}
	
	void resetList(){
		vHead = null;
		nextID = 1;
	}
	
	void listVehicles(){
		Node cur = vHead;
		while (cur != null){
			cur.getVehicle().printInfo();
			cur = cur.getNext();
		}
	}
	
	void listVehiclesForRental(){
		Node cur = vHead;
		while (cur != null){
			Vehicle curVehicle = cur.getVehicle();
			
			if (curVehicle.isAvailable())
				curVehicle.printInfo();
			
			cur = cur.getNext();
		}
	}
}