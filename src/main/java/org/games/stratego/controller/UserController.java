package org.games.stratego.controller;

import org.games.stratego.database.DBConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletResponse;


/**
 * Handles comments associated with requests.
 */

@RestController
@RequestMapping(value="user")
public class UserController{



    @CrossOrigin
    @RequestMapping(value="userRoles", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUSer(@RequestHeader HttpHeaders httpHeaders,
                                                     @RequestParam(value="userId", required=true) Long userId,
                                                     @RequestParam(value="groupId", required=true) Long groupId,
                                                     @RequestParam(value="roleId", required=true) Integer roleId,
                                                     HttpServletResponse resp )  throws Exception
    {

        DBConnection dbConnection = new DBConnection(true);
        String custRet = dbConnection.getCustomers();
        return custRet + "\nTwo: Here is the DB parameter you sent: " + parameter;
    }


}