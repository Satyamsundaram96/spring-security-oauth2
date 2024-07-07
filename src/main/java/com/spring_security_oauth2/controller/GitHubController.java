package com.spring_security_oauth2.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GitHubController {
	
// GitHub Settings -> Applications -> Authorized OAuth Apps (Find the apps we authorized all application to use GitHub account access)

// GitHub Settings -> Developer Settings -> OAuth Apps -> Click "Register a new OAuth application" ->
// Give all details (Application Name, Homepage URL, Authorization callback URL, Enable Device Flow) -> Register application
// Homepage URL - http://localhost:8989 , Authorization callback URL - http://localhost:8989/login/oauth2/code/github
// Client ID : , Client secrets :- click "Generate a new client secret" : -> "update application"
	
// For Google 
//	Google Cloud Console
//	Menu -> APIs & services -> Credentials -> CREATE NEW PROJECT -> Project Name -> Click 'Create'
//	Menu -> OAuth consent screen -> External -> Click 'Create'
//	Then Edit app registration -> Fill the App name, User support email -> App Domain -> Application home page -> Developer Contact Information -> Click 'Save & Continue'
//	Then Scopes -> Click 'Add or Remove scopes' -> Add all scopes -> Click 'Update' -> Click 'Save & Continue' -> Test Users -> Click 'Save & Continue'
//	Credentials -> + Create Credentials -> OAuth client ID -> Application type (Web application), Name, Authorised JavaScript origins (Add URIs: http://localhost:8989), Authorised redirect URIs (Add URIs: http://localhost:8989/login/oauth2/code/google) -> Click 'Create'
//	Then copy the Client ID & Client Secret. 

// For Facebook
	

	@GetMapping("/info")
	public String getUserInfoFromGitHub(Principal principal) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(principal);
	}
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Home!!";
	}
	
	@GetMapping("/secured")
	public String secured() {
		return "Hello, It's Secured!";
	}

}
