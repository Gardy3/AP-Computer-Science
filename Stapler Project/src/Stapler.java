public class Stapler {
	
	String color = "black";
	int cap = 220;//staple capacity
	int numStaples = 210;
	String material = "domascus steel";
	int uses = 0;
	boolean isOpen = false;
	double size = 7.25;//length in inches
	
	/*
	 * Default Constructor
	 * NO RETURN TYPE
	 */
	public Stapler(){
		
	}
	
	/*
	 * Constructor
	 * 
	 */
	public Stapler(String color, double size, String material, int cap){
		this.color = color;
		this.size = size;
		this.material = material;
		this.cap = cap;
		
	}
	
	
	
	/*
	 * Check for open/close stapler
	 * check num staples
	 */
	public int staple(){
		if(!isOpen && numStaples != 0){
			numStaples--;
			uses++;
			System.out.println("Stapled!");
		}
		else if(isOpen)
			System.out.println("Close the stapler first");
		else if(numStaples == 0)
			System.out.println("Reload the stapler");
		return numStaples;
		
	}
	
	
	/*
	 *check numStaples with capacity
	 *check isOpen
	 * 
	 */
	public void reload(){
		if(!isOpen){
			System.out.println("Open the stapler!");
		}
		else if(numStaples + 210 > 220){
			System.out.println("There are too many staples left in the stapler.");
		}
		else
			numStaples += 210;
	}
	
	public void open(){
		isOpen = true;
		System.out.println("Opened");
	}
	
	public void close(){
		isOpen = false;
		System.out.println("Closed");
	}
	
	

}