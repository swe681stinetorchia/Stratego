package org.games.stratego.Services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.games.stratego.database.UserDBConnection;
import org.games.stratego.model.admin.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

public class UserService
{
    private static final long serialVersionUID = 1L;

    private static HashMap<String, String> loginMap;

    private static UserService validation = new UserService();
    protected final Logger log = LogManager.getLogger(getClass());



    private UserService()
    {
        loginMap = new HashMap();
        loginMap.put( "KentDolan", "Dolan123456" );
    }
    
    public static UserService getInstance()
    {
        return validation;
    }
    
    public User addUser(String username, String password )
    {
        try {
            String hash = SecureHash.generateStrongPasswordHash(password);

            UserDBConnection userDBConnection = new UserDBConnection();

            System.out.println("1 adding " + username + " : " + hash + " : " +SecureHash.validatePassword(password, hash));

            int id = userDBConnection.addUser(username, hash);

            return new User(username, id);
        }
        catch (NoSuchAlgorithmException nsae)
        {
            nsae.printStackTrace();
        }
        catch (InvalidKeySpecException ikse)
        {
            ikse.printStackTrace();
        }
        throw new RuntimeException("Failed to add user.");
    }
    
    public boolean validate( String username, String password )
    {
        System.out.println("Password to check: " + password);

        UserDBConnection userDBConnection = new UserDBConnection();

        return userDBConnection.checkPassword(username, password);
    }
    
}
