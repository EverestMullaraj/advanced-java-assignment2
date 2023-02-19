package com.theater.beans.Payment;

import java.sql.Date; 

public class Payment implements Comparable{
	
	
	private  int paymentId = 0;
	
	
	private  int customerId = 0;
	
	
	private  String customerName = null;
	
	
	private  java.sql.Date paymentDate = new java.sql.Date(new java.util.Date().getTime());
	
	
	private  int reservationNumber = 0;
	
	
	private  double totalAmount = 0.0;
	
public Payment()
	{
	}
public Payment(int argpaymentId ,int argcustomerId ,String argcustomerName ,java.sql.Date argpaymentDate ,int argreservationNumber ,double argtotalAmount )
	{
	paymentId = argpaymentId;
	customerId = argcustomerId;
	customerName = argcustomerName;
	paymentDate = argpaymentDate;
	reservationNumber = argreservationNumber;
	totalAmount = argtotalAmount;

	}


	public void setPaymentId(int argpaymentId)
	{
	paymentId = argpaymentId;
	}
	public void setCustomerId(int argcustomerId)
	{
	customerId = argcustomerId;
	}
	public void setCustomerName(String argcustomerName)
	{
	customerName = argcustomerName;
	}
	public void setPaymentDate(java.sql.Date argpaymentDate)
	{
	paymentDate = argpaymentDate;
	}
	public void setReservationNumber(int argreservationNumber)
	{
	reservationNumber = argreservationNumber;
	}
	public void setTotalAmount(double argtotalAmount)
	{
	totalAmount = argtotalAmount;
	}

	 public int getPaymentId()
	{
	return   paymentId;
	}
	 public int getCustomerId()
	{
	return   customerId;
	}
	 public String getCustomerName()
	{
	return   customerName;
	}
	 public java.sql.Date getPaymentDate()
	{
	return   paymentDate;
	}
	 public int getReservationNumber()
	{
	return   reservationNumber;
	}
	 public double getTotalAmount()
	{
	return   totalAmount;
	}


@Override
public String toString()
	{
	return this.paymentId+""+this.customerId+""+this.customerName+""+this.paymentDate+""+this.reservationNumber+""+this.totalAmount;
	}



@Override
public int compareTo( Object o)
{
	int mod=0;
	Payment a=(Payment)o;
	Payment b=this;
	if(mod==0){	
		if(a.paymentId>b.paymentId)
		return -1;
		else if(a.paymentId<b.paymentId)
		return 1;
		else return 0;
	}
	else if(mod==1){	
		if(a.customerId>b.customerId)
		return -1;
		else if(a.customerId<b.customerId)
		return 1;
		else return 0;
	}	else if(mod==2)
	{
	return a.customerName.compareTo(b.customerName);
	}

	else if(mod==4){	
		if(a.reservationNumber>b.reservationNumber)
		return -1;
		else if(a.reservationNumber<b.reservationNumber)
		return 1;
		else return 0;
	}
	else if(mod==5){	
		if(a.totalAmount>b.totalAmount)
		return -1;
		else if(a.totalAmount<b.totalAmount)
		return 1;
		else return 0;
	}return 0;
	
}


    //The select field given below is added by system. It is required 
    //if you want to do delete, edit or view operation on the object

    private  boolean select = false;
    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isSelect() {
        return select;
    }

}