
public class Selling extends Apple{
	
	int sellingclassproperty = 20;
	
	Selling(int a) {
		super(a);
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		
		/*Apple b = new Apple();
		
		System.out.println(b.getPrice()+1);*/
		
		Selling a  = new Selling(5);
		int price = a.getPrice();
		System.out.println("Price  " +price);
		
		
	}

}
