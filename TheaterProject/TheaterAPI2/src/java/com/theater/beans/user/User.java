	//created with
	//Class Coder Application
	//To get Latest Version Contact eloquencetechs@gmail.com
	//Eloquence Technalogies Islamabad, Pakistan




package com.theater.beans.user;


import java.sql.Date; 
 
public class User implements Comparable{
	
	
	private  int id = 0;
	
	
	private  String name = null;
	
	
	private  String email = null;
	
	
	private  String phoneNumber = null;
	
	
	private  String gender = null;
	
	
	private  String address = null;
	
	
	private  java.sql.Date joinedDate = new java.sql.Date(new java.util.Date().getTime());
	
	
	private  String userName = null;
	
	
	private  String passwrd = null;
	
public User()
	{
	}
public User(int argid ,String argname ,String argemail ,String argphoneNumber ,String arggender ,String argaddress ,java.sql.Date argjoinedDate ,String arguserName ,String argpasswrd )
	{
	id = argid;
	name = argname;
	email = argemail;
	phoneNumber = argphoneNumber;
	gender = arggender;
	address = argaddress;
	joinedDate = argjoinedDate;
	userName = arguserName;
	passwrd = argpasswrd;

	}


	public void setId(int argid)
	{
	id = argid;
	}
	public void setName(String argname)
	{
	name = argname;
	}
	public void setEmail(String argemail)
	{
	email = argemail;
	}
	public void setPhoneNumber(String argphoneNumber)
	{
	phoneNumber = argphoneNumber;
	}
	public void setGender(String arggender)
	{
	gender = arggender;
	}
	public void setAddress(String argaddress)
	{
	address = argaddress;
	}
	public void setJoinedDate(java.sql.Date argjoinedDate)
	{
	joinedDate = argjoinedDate;
	}
	public void setUserName(String arguserName)
	{
	userName = arguserName;
	}
	public void setPasswrd(String argpasswrd)
	{
	passwrd = argpasswrd;
	}

	 public int getId()
	{
	return   id;
	}
	 public String getName()
	{
	return   name;
	}
	 public String getEmail()
	{
	return   email;
	}
	 public String getPhoneNumber()
	{
	return   phoneNumber;
	}
	 public String getGender()
	{
	return   gender;
	}
	 public String getAddress()
	{
	return   address;
	}
	 public java.sql.Date getJoinedDate()
	{
	return   joinedDate;
	}
	 public String getUserName()
	{
	return   userName;
	}
	 public String getPasswrd()
	{
	return   passwrd;
	}


@Override
public String toString()
	{
	return this.id+""+this.name+""+this.email+""+this.phoneNumber+""+this.gender+""+this.address+""+this.joinedDate+""+this.userName+""+this.passwrd;
	}



@Override
public int compareTo( Object o)
{
	int mod=0;
	User a=(User)o;
	User b=this;
	if(mod==0){	
		if(a.id>b.id)
		return -1;
		else if(a.id<b.id)
		return 1;
		else return 0;
	}	else if(mod==1)
	{
	return a.name.compareTo(b.name);
	}
	else if(mod==2)
	{
	return a.email.compareTo(b.email);
	}
	else if(mod==3)
	{
	return a.phoneNumber.compareTo(b.phoneNumber);
	}
	else if(mod==4)
	{
	return a.gender.compareTo(b.gender);
	}
	else if(mod==5)
	{
	return a.address.compareTo(b.address);
	}
	else if(mod==7)
	{
	return a.userName.compareTo(b.userName);
	}
	else if(mod==8)
	{
	return a.passwrd.compareTo(b.passwrd);
	}
return 0;
	
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