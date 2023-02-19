 


package com.theater.beans.movies;


import java.sql.Date; 
 
 
public class Movie implements Comparable{
	
	
	private  int movieId = 0;
	
	
	private  String movieName = null;
	
	
	private  String author = null;
	
	
	private  java.sql.Date publishedDate = new java.sql.Date(new java.util.Date().getTime());
	
	
	private  String managerName = null;
	
public Movie()
	{
	}
public Movie(int argmovieId ,String argmovieName ,String argauthor ,java.sql.Date argpublishedDate ,String argmanagerName )
	{
	movieId = argmovieId;
	movieName = argmovieName;
	author = argauthor;
	publishedDate = argpublishedDate;
	managerName = argmanagerName;

	}


	public void setMovieId(int argmovieId)
	{
	movieId = argmovieId;
	}
	public void setMovieName(String argmovieName)
	{
	movieName = argmovieName;
	}
	public void setAuthor(String argauthor)
	{
	author = argauthor;
	}
	public void setPublishedDate(java.sql.Date argpublishedDate)
	{
	publishedDate = argpublishedDate;
	}
	public void setManagerName(String argmanagerName)
	{
	managerName = argmanagerName;
	}

	 public int getMovieId()
	{
	return   movieId;
	}
	 public String getMovieName()
	{
	return   movieName;
	}
	 public String getAuthor()
	{
	return   author;
	}
	 public java.sql.Date getPublishedDate()
	{
	return   publishedDate;
	}
	 public String getManagerName()
	{
	return   managerName;
	}


@Override
public String toString()
	{
	return this.movieId+""+this.movieName+""+this.author+""+this.publishedDate+""+this.managerName;
	}



@Override
public int compareTo( Object o)
{
	int mod=0;
	Movie a=(Movie)o;
	Movie b=this;
            switch (mod) {
                case 0:
                    if(a.movieId>b.movieId)
                        return -1;
                    else if(a.movieId<b.movieId)
                        return 1;
                    else return 0;
                case 1:
                    return a.movieName.compareTo(b.movieName);
                case 2:
                    return a.author.compareTo(b.author);
                case 4:
                    return a.managerName.compareTo(b.managerName);
                default:
                    break;
            }
return 0;
	
}

 

}