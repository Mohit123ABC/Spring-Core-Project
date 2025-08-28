package com.rays.ioc;

public class Order2 {
	
	private Payment payment;
	private Inventory inventory;
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void bookATicket(int items) {
		
		int price = 10;
		
		double totleAmount = items * price;
		
		 double updateBalance = payment.makePayment(totleAmount);
		 
		  int updateStock = inventory.sold(items);
		  
		  System.out.println("Tickets are booked");
		  System.out.println("Total Amount Paid:"+totleAmount);
		  System.out.println("Remaining Balance:"+updateBalance);
		  System.out.println("Updated Stock:"+updateStock);
		 
	}


}
