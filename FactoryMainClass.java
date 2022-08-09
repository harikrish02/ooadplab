import java.util.*;

interface Customer 
{
  void getType();
}

class CustomerFactory {

	Customer getCustomer(String type) {
		if(type.equalsIgnoreCase("first time"))
			return new FTCustomer();
		else if(type.equalsIgnoreCase("regular"))
			return new RegCustomer();
		else if(type.equalsIgnoreCase("senior citizen"))
			return new SCCustomer();
		else
			return null;
	}
}

class FTCustomer implements Customer {

	@Override
	public void getType() {
		// TODO Auto-generated method stub
		System.out.println("First Time Customer");

	}

}

class RegCustomer implements Customer {

	@Override
	public void getType() {
		// TODO Auto-generated method stub
		System.out.println("Regular Customer");
	}

}

class SCCustomer implements Customer {

	@Override
	public void getType() {
		// TODO Auto-generated method stub
		System.out.println("Senior Citizen Customer");
	}

}

public class FactoryMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerFactory cf=new CustomerFactory();
		Customer c1=cf.getCustomer("senior citizen");
		Customer c2=cf.getCustomer("first time");
		Customer c3=cf.getCustomer("regular");
		
		c1.getType();
		c2.getType();
		c3.getType();
		
		
	}

}
