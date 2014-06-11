// DO NOT ADD NEW METHODS OR DATA FIELDS!

package PJ3;

class Customer
{
    private int customerID;
    private int checkoutDuration;
    private int arrivalTime;

    Customer()
    {
	// add statements
    	customerID = 0;
    	checkoutDuration = 0;
    	arrivalTime = 0;
    }

    Customer(int customerid, int checkoutduration, int arrivaltime)
    {
	// add statements
    	customerID = customerid;
    	checkoutDuration = checkoutduration;
    	arrivalTime = arrivaltime;
    }

    int getCheckoutDuration() 
    {
	// add statements
  	return checkoutDuration;
    }

    int getArrivalTime() 
    {
	// add statements
  	return arrivalTime;
    }

    int getCustomerID() 
    {
  	return customerID; 
    }

    public String toString()
    {
    	return ""+customerID+":"+checkoutDuration+":"+arrivalTime;

    }

    public static void main(String[] args) {
        // quick check!
	Customer mycustomer = new Customer(20,30,40);
	System.out.println("Customer Info:"+mycustomer);

    }
}
