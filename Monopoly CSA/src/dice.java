


	public class dice {

	    public static void main(String[] args) {
	    	while (true)  
	    	{ 
	    	  int diceX=(int)(Math.random()*6+1); 
	    	  int diceY=(int)(Math.random()*6+1); 
	    	  int sum1 = diceX + diceY; 
	    	  System.out.println("Roll: total = " + sum1);  
	    	  if (sum1==2 || sum1==3 || sum1==12) { 
	    	  System.out.println("Sorry with a " + sum1 + " You LOSE :("); 
	    	  break; 
	    	  } else if(sum1==7 || sum1==11) {  
	    	  System.out.println("Woah!!! With a " + sum1 + " You WIN!!!!!!!"); 
	    	  break;  
	    	  } 
	    	} 
	}}

