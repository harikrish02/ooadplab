ID: rc1
Name: modi
Type of Customer: Regular Customer
Gross Amount: 100.0
Discount: 12.0
Amount Payable: 88.0

ID: sc1
Name: trump
Type of Customer: Senior Customer
Gross Amount: 100.0
Discount: 10.0
Amount Payable: 90.0

ID: ftc1
Name: raga
Type of Customer: First Time Customer
Gross Amount: 100.0
Discount: 15.000001
Amount Payable: 85.0

abstract class Customer.java
interface Discount
3 classes extend Customer
3 classes implement interface



//Customer.java
import java.util.*;
abstract class Customer {

	String id,name,typeOfCust;
	Discount d;
	
	public Customer(String id,String name) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
	}
	
	void printBill(float amt) {
		System.out.println("\nID: "+id);
		System.out.println("Name: "+name);
		System.out.println("Type of Customer: "+typeOfCust);
		System.out.println("Gross Amount: "+amt);
		System.out.println("Discount: "+d.calcDiscount(amt));
		System.out.println("Amount Payable: "+(amt-d.calcDiscount(amt)));
		
	}
	
}

//Discount.java

interface Discount {
	float calcDiscount(float amount);

}

//FTCCustomer.java

class FTCCustomer extends Customer {

	public FTCCustomer(String id, String name) {
		super(id, name);
		this.d=new FTCDiscount();
		typeOfCust="First Time Customer";
		// TODO Auto-generated constructor stub
	}

}





//FTCDiscount.java


class FTCDiscount implements Discount {

	@Override
	public float calcDiscount(float amount) {
		// TODO Auto-generated method stub
		return 0.15f*amount;
	}

}


//RCCustomer.java


class RCCustomer extends Customer {

	public RCCustomer(String id, String name) {
		super(id, name);
		d=new RCDiscount();
		typeOfCust="Regular Customer";
		
		// TODO Auto-generated constructor stub
	}

}

//RCDiscount.java




class RCDiscount implements Discount{

	@Override
	public float calcDiscount(float amount) {
		// TODO Auto-generated method stub
		return 0.12f*amount;
	}

}



//SCCustomer.java

class SCCustomer extends Customer {

	public SCCustomer(String id, String name) {
		super(id, name);
		this.d=new SCDiscount();
		this.typeOfCust="Senior Customer";
		// TODO Auto-generated constructor stub
	}

}

//SCDiscount.java

class SCDiscount implements Discount {

	@Override
	public float calcDiscount(float amount) {
		// TODO Auto-generated method stub
		return 0.1f*amount;
	}

}

//StrategyDemo.java

public class StrategyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer c1=new RCCustomer("rc1", "modi");
		c1.printBill(100);
		
		c1=new SCCustomer("sc1", "trump");
		c1.printBill(100);
		
		c1=new FTCCustomer("ftc1", "raga");
		c1.printBill(100);
		
	}

}
