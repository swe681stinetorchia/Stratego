package org.games.stratego.Services;

import java.util.HashMap;

public class UserService
{
    private static final long serialVersionUID = 1L;

    private static HashMap<String, String> loginMap;

    private static UserService validation = new UserService();



    private UserService()
    {
        loginMap = new HashMap();
        loginMap.put( "KentDolan", "Dolan123456" );
    }
    
    public static UserService getInstance()
    {
        return validation;
    }
    
    public void addUser( String username, String password )
    {
        loginMap.put( username, password );
    }
    
    public boolean validate( String username, String password )
    {
        //System.out.println( "username = " + username + ", password = " + password );
        
        String storedPassword = loginMap.get( username );
        
        if( storedPassword != null && storedPassword.equals( password ))
        {
            return true;
        }
        
        return false;
    }
    
}