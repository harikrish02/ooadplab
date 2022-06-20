public class BridgeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RCCustomer c1=new RCCustomer("Modi", 61, new Discount1());
		c1.showBill(100);
		
		c1.setDiscount(new Discount2());
		c1.showBill(100);
		
		c1.setDiscount(new Discount3());
		c1.showBill(100);
		
		c1.setDiscount(new Discount4());
		c1.showBill(100);
		
		Customer c2=new FTCCustomer("Raga", 6, new Discount1());
		c2.showBill(100);
		
		c2.setDiscount(new Discount2());
		c2.showBill(100);
		
		c2.setDiscount(new Discount3());
		c2.showBill(100);
		
		c2.setDiscount(new Discount4());
		c2.showBill(100);
		}
}
//Customer.java

abstract class Customer {

	String name;
	int age;
	Discount d;
	String typeOfCust;
	
	public Customer(String name,int age,Discount d) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.age=age;
		this.d=d;
	}
	
	void setDiscount(Discount d) {
		this.d=d;
	}
	
	void showBill(float amt) {
		System.out.println("\nName: "+name);
		System.out.println("Age: "+age);
		System.out.println("Type of Customer: "+typeOfCust);
		System.out.println("Gross Cost: "+amt);
		System.out.println("Discount: "+d.getDiscount(amt));
		System.out.println("Payable Amount: "+(amt-d.getDiscount(amt)));
	}
	
}
//Discount.java

interface Discount {
	float getDiscount(float amount);	
}
//Discount1.java

class Discount1 implements Discount {

	@Override
	public float getDiscount(float amount) {
		// TODO Auto-generated method stub
		return 0.3f*amount;
	}

}

//Discount2.java

class Discount2 implements Discount {

	@Override
	public float getDiscount(float amount) {
		// TODO Auto-generated method stub
		return 0.25f*amount;
	}

}

//Discount3.java

class Discount3 implements Discount{

	@Override
	public float getDiscount(float amount) {
		// TODO Auto-generated method stub
		return 0.2f*amount;
	}
	

}

//Discount4.java

class Discount4 implements Discount {

	@Override
	public float getDiscount(float amount) {
		// TODO Auto-generated method stub
		return 0.15f*amount;
	}
}
//FTCCustomer.java

class FTCCustomer extends Customer {

	public FTCCustomer(String name, int age, Discount d) {
		super(name, age, d);
		typeOfCust="First Time Customer";
		// TODO Auto-generated constructor stub
	}

}

//RCCustomer.java

class RCCustomer extends Customer {

	public RCCustomer(String name, int age, Discount d) {
		super(name, age, d);
		typeOfCust="Regular Customer";
		// TODO Auto-generated constructor stub
	}

}

//SSCustomer.java

class SSCustomer extends Customer {

	public SSCustomer(String name, int age, Discount d) {
		super(name, age, d);
		typeOfCust="Senior Customer";
		// TODO Auto-generated constructor stub
	}

}
