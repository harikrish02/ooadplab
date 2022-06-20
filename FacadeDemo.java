
//FacadeDemo.java
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
//import java.util.Scanner;
import java.util.Set;

public class FacadeDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Sports2000Facade f = new Sports2000Facade(false, 100);
    f.displayItems();
    f.dispAmount();

  }

}

// ItemPurchased.java

class ItemPurchased {
	HashMap<String, Integer> hm;
	int type;
	
	public ItemPurchased() {
		// TODO Auto-generated constructor stub
		hm=new HashMap<String, Integer>();
		storePurchase();
	}

	private void storePurchase() {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.print("Enter number of types of Items: ");
		type=Integer.parseInt(in.nextLine());
		for(int i=1;i<=type;i++) {
			System.out.print("Enter name of Item "+i+": ");
			String name=in.nextLine();
			System.out.print("Enter Quantity of Item "+i+": ");
			int qty=Integer.parseInt(in.nextLine());
			hm.put(name, qty);
		}
		
	}
	
	int getTypeCount() {
		return type;
	}
	
	void showItems() {
		System.out.println("Items Purchased:-");
		Set<Map.Entry<String,Integer>> set=hm.entrySet();
		for(Map.Entry<String,Integer> i:set) {
			System.out.println(i.getKey()+":"+i.getValue());
		}
	}
}

// Sports2000ProcessSales.jav

class Sport2000ProcessSales {

  boolean giftCert;
  float amount;
  int qty;

  public Sport2000ProcessSales(boolean g, float a, int q) {
    // TODO Auto-generated constructor stub
    giftCert = g;
    amount = a;
    qty = q;
  }

  void processSales() {
    if (!giftCert) {
      System.out.println("You don't have a Gift Certificate!");
      System.out.println("Amount Payable: " + amount);
    } else {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter Gift Certificate Value: ");
      float certValue = Float.parseFloat(in.nextLine());

      if (qty <= 0) {
        System.out.println("No Items in Cart!");
      } else if (qty > 1) {
        System.out.println("Only one Item can be purchased using Gift Certificate");
      } else if (amount > certValue) {
        System.out.println("Please pay balance amount in Cash: Rs." + (amount - certValue));
      } else if (amount <= certValue) {
        System.out.println("No cashback will be Refunded! Thankyou for your Purchase!");

      }

    }

  }

}

// Sports2000Facade.java

class Sports2000Facade {
  ItemPurchased i;
  Sport2000ProcessSales s;

  public Sports2000Facade(boolean b, float a) {
    // TODO Auto-generated constructor stub
    i = new ItemPurchased();
    s = new Sport2000ProcessSales(b, a, i.getTypeCount());

  }

  void displayItems() {
    i.showItems();
  }

  void dispAmount() {
    s.processSales();
  }

}
