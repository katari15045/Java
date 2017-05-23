package com.github.katari15045;

public class LoginService 
{
	private User user;
	
	public User start(String inpUserId, String inpPassword)
	{
		if( inpUserId.equals("Saketh") && inpPassword.equals("Katari") )
		{
			user = new User();
			user.setUserId(inpUserId);
			user.setUserName("Saketh Katari");
			user.setCountry("India");
			
			return user;
		}
		
		return null;
	}
}
