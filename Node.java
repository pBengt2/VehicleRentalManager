public class Node{
	private Vehicle vehicle;
	private Node next;
	
	Node(Vehicle v){
		vehicle = v;
		next = null;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node n){
		next = n;
	}
	
	public Vehicle getVehicle(){
		return vehicle;
	}
}