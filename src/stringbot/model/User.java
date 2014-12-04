package stringbot.model;

public class User
{

/**
 * variable that stores the user's name when they input it
 */
	private String userName;
/**
 * stores user's age when they input it
 */
	private int ageNumber;
/**
 * stores the user's favorite animal when they input it 
 */
	private String favoriteAnimal;
/**
 * stores a boolean (true/false) of if the user likes ponies or not
 */
	private boolean likesPonies;
/**
 * puts defaults on all of the variables so when they are called they have something atleast inside them
 */
	public User()
	{
		this.userName = "";
		this.ageNumber = -99;
		this.favoriteAnimal = "";
		this.likesPonies = false;
	}
/**
 * returns if they like ponies
 * @return
 */
	public boolean isLikesPonies() 
	{
		return likesPonies;
	}
/**
 * sets the variable to the users answer on if they like ponies or not
 * @param likesPonies
 */
	public void setLikesPonies(boolean likesPonies) 
	{
		this.likesPonies = likesPonies;
	}
/**
 *  returns the user's name
 * @return
 */
	public String getUserName() 
	{
		return userName;
	}
/**
 * changes the variable of the users name dependent on 
 * @param userName
 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
/**
 * returns the age of the user
 * @return
 */
	public int getAgeNumber() 
	{
		return ageNumber;
	}
/**
 *  allows changes to the age of the user when called
 * @param ageNumber
 */
	public void setAgeNumber(int ageNumber) 
	{
		this.ageNumber = ageNumber;
	}
/**
 * returns the favorite animal of the user
 * @return
 */
	public String getFavoriteAnimal() 
	{
		return favoriteAnimal;
	}
/**
 * allows to change the favorite animal
 * @param favoriteAnimal
 */
	public void setFavoriteAnimal(String favoriteAnimal) 
	{
		this.favoriteAnimal = favoriteAnimal;
	}
	
	
}
