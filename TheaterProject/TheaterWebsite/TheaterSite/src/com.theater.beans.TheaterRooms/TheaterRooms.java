	//created with
	//Class Coder Application
	//To get Latest Version Contact eloquencetechs@gmail.com
	//Eloquence Technalogies Islamabad, Pakistan




package com.theater.beans.TheaterRooms;


import java.sql.Date; 

public class TheaterRooms implements Comparable{
	
	
	private  int roomId = 0;
	
	
	private  int movieID = 0;
	
	
	private  int movieName = 0;
	
	
	private  java.sql.Date openingTime = new java.sql.Date(new java.util.Date().getTime());
	
	
	private  java.sql.Date closingTime = new java.sql.Date(new java.util.Date().getTime());
	
	
	private  java.sql.Date manager = new java.sql.Date(new java.util.Date().getTime());
	
	
	private  int totalMovies = 0;
	
	
	private  double totalEarn = 0.0;
	
public TheaterRooms()
	{
	}
public TheaterRooms(int argroomId ,int argmovieID ,int argmovieName ,java.sql.Date argopeningTime ,java.sql.Date argclosingTime ,java.sql.Date argmanager ,int argtotalMovies ,double argtotalEarn )
	{
	roomId = argroomId;
	movieID = argmovieID;
	movieName = argmovieName;
	openingTime = argopeningTime;
	closingTime = argclosingTime;
	manager = argmanager;
	totalMovies = argtotalMovies;
	totalEarn = argtotalEarn;

	}


	public void setRoomId(int argroomId)
	{
	roomId = argroomId;
	}
	public void setMovieID(int argmovieID)
	{
	movieID = argmovieID;
	}
	public void setMovieName(int argmovieName)
	{
	movieName = argmovieName;
	}
	public void setOpeningTime(java.sql.Date argopeningTime)
	{
	openingTime = argopeningTime;
	}
	public void setClosingTime(java.sql.Date argclosingTime)
	{
	closingTime = argclosingTime;
	}
	public void setManager(java.sql.Date argmanager)
	{
	manager = argmanager;
	}
	public void setTotalMovies(int argtotalMovies)
	{
	totalMovies = argtotalMovies;
	}
	public void setTotalEarn(double argtotalEarn)
	{
	totalEarn = argtotalEarn;
	}

	 public int getRoomId()
	{
	return   roomId;
	}
	 public int getMovieID()
	{
	return   movieID;
	}
	 public int getMovieName()
	{
	return   movieName;
	}
	 public java.sql.Date getOpeningTime()
	{
	return   openingTime;
	}
	 public java.sql.Date getClosingTime()
	{
	return   closingTime;
	}
	 public java.sql.Date getManager()
	{
	return   manager;
	}
	 public int getTotalMovies()
	{
	return   totalMovies;
	}
	 public double getTotalEarn()
	{
	return   totalEarn;
	}


@Override
public String toString()
	{
	return this.roomId+""+this.movieID+""+this.movieName+""+this.openingTime+""+this.closingTime+""+this.manager+""+this.totalMovies+""+this.totalEarn;
	}



@Override
public int compareTo( Object o)
{
	int mod=0;
	TheaterRooms a=(TheaterRooms)o;
	TheaterRooms b=this;
	if(mod==0){	
		if(a.roomId>b.roomId)
		return -1;
		else if(a.roomId<b.roomId)
		return 1;
		else return 0;
	}
	else if(mod==1){	
		if(a.movieID>b.movieID)
		return -1;
		else if(a.movieID<b.movieID)
		return 1;
		else return 0;
	}
	else if(mod==2){	
		if(a.movieName>b.movieName)
		return -1;
		else if(a.movieName<b.movieName)
		return 1;
		else return 0;
	}
	else if(mod==6){	
		if(a.totalMovies>b.totalMovies)
		return -1;
		else if(a.totalMovies<b.totalMovies)
		return 1;
		else return 0;
	}
	else if(mod==7){	
		if(a.totalEarn>b.totalEarn)
		return -1;
		else if(a.totalEarn<b.totalEarn)
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