package org.games.stratego.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 * Handles comments associated with requests.
 */

@RestController
@RequestMapping(value="game")
public class GameController{

    @CrossOrigin
    @RequestMapping(value="testOne", method = RequestMethod.GET)
    public String testOne() throws JSONException {

        return "One";
    }

    @CrossOrigin
    @RequestMapping(value="testTwo", method = RequestMethod.GET)
    public String testTwo() throws JSONException {

        return "Two";
    }

    @CrossOrigin
    @RequestMapping(value="/testThree/{param}", method = RequestMethod.GET)
    public String testThree(@PathVariable("param") String parameter) throws JSONException {

        return "Here is the parameter you sent: " + parameter;
    }





}
