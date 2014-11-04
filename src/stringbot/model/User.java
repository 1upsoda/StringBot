package stringbot.model;

public class User
{

	
	private String userName;
	private int ageNumber;
	private String favoriteAnimal;
	private boolean likesPonies;
	

	public User()
	{
		this.userName = "";
		this.ageNumber = 0;
		this.favoriteAnimal = "";
		this.likesPonies = false;
	}
	
	public boolean isLikesPonies() 
	{
		return likesPonies;
	}

	public void setLikesPonies(boolean likesPonies) 
	{
		this.likesPonies = likesPonies;
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getAgeNumber() 
	{
		return ageNumber;
	}

	public void setAgeNumber(int ageNumber) 
	{
		this.ageNumber = ageNumber;
	}

	public String getFavoriteAnimal() 
	{
		return favoriteAnimal;
	}

	public void setFavoriteAnimal(String favoriteAnimal) 
	{
		this.favoriteAnimal = favoriteAnimal;
	}
	
	
}
