enter item name
bat

Name: bat
Quantity: 2
Price: 100.0
Tax Amount: 20.0
Bill Amount: 220.0

Name: bat
Quantity: 2
Price: 100.0
Tax Amount: 36.0
Bill Amount: 236.0

//class AdapterDemo
//interface calcTax
//class GST implements CalcTax 
//class MauriTaxAdapter implements CalcTax
//class MauriTax
//class Item


import java.util.Scanner;
class AdapterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcTax ct=new MauriTaxAdapter();
		//System.out.println(ct.taxAmount(1, 100));
    Scanner input=new Scanner(System.in);
    //var=Integer.parseInt(input.nextLine());
    System.out.println("enter item name");
    String name=input.nextLine();
		Item i1 = new Item(name,2,100,ct);
		i1.displayItem();
		
		i1.setTax(new GST());
		i1.displayItem();
	}

}


interface CalcTax {
	
	float taxAmount(int qty,float price);
}




class GST implements CalcTax {

	@Override
	public float taxAmount(int qty, float price) {
		// TODO Auto-generated method stub
		return qty*price*0.18f;
	}

}



class Item {
	String name;
	int qty;
	float price;
	CalcTax ct;
		public Item(String name,int qty,float price,CalcTax ct) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.price=price;
		this.qty=qty;
		this.ct=ct;
	}
	
	void setTax(CalcTax ct) {
		this.ct=ct;
	}
	
	void setQuantity(int qty) {
		this.qty=qty;
	}

	void displayItem() {
		System.out.println("\nName: "+name);
		System.out.println("Quantity: "+qty);
		System.out.println("Price: "+price);
		float tax=ct.taxAmount(qty, price);
		float billAmount=(qty*price)+tax;
		System.out.println("Tax Amount: "+tax);
		System.out.println("Bill Amount: "+billAmount);		
	}
}



class MauriTax {

	float mauriTaxAmount(int qty,float price) {
		return qty*price*0.1f;		
	}
}



class MauriTaxAdapter implements CalcTax {

	MauriTax mt=new MauriTax();
	@Override
	public float taxAmount(int qty, float price) {
		// TODO Auto-generated method stub
		return mt.mauriTaxAmount(qty, price);
	}

}
