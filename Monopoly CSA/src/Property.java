
public class Property { 
	
	//variables for each property
	private String name;
	private int x; 
	private int y; 
	private int owner; 
	private int price; 
	private int pay;  
	
	
	//property constructor - 40 properties in an array in board class
	public Property(String name, int owner, int x, int y, int price, int pay) { 
		this.name =  name; 
		this.x = x; 
		this.y = y; 
		this.owner = owner; 
		this.price = price; 
		this.pay = pay; 
	}
	
	//getters and setters
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getX() {
		return x;
	}




	public void setX(int x) {
		this.x = x;
	}




	public int getY() {
		return y;
	}




	public void setY(int y) {
		this.y = y;
	}




	public int getOwner() {
		return owner;
	}




	public void setOwner(int owner) {
		this.owner = owner;
	}




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public int getPay() {
		return pay;
	}




	public void setPay(int pay) {
		this.pay = pay;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	}

}
