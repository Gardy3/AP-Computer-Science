
public class AddressEntry {
	
	String name = "";
	String address = "";
	int phoneNumber = 0;
	
	public AddressEntry(){
		
	}
	
	public AddressEntry(String name, String address, int phoneNumber){
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public void deleteInfo(){
		this.name = "";
		this.address = "";
		this.phoneNumber = 0;
	}
	
}
