package com.edsolstice.educationportal.auth;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.HashSet;

public class AuthorizedUserManager {

    private static class AuthorizedUser {
    	 private String email;
         private String authToken;
         private String password;
         private long lastHeartbeat;
        
         public AuthorizedUser(String email, String authToken, String password) {
            this.email = email;
            this.authToken = authToken;
            this.password = password;
        }

        public String getAuthToken() { 
            return authToken;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }

        public long getLastHeartbeat() {
            return lastHeartbeat;
        }
        
        public void setAuthToken(String authToken) {
            this.authToken = authToken;
        }

        public void setLastHeartbeat(long lastHeartbeat) {
            this.lastHeartbeat = lastHeartbeat;
        }

       
    }


    public synchronized String addUser(String email, String password) {
        String authToken;
        AuthorizedUser existingUser = getUser(email, password);
        if (existingUser != null) {
            authToken = existingUser.getAuthToken();
        } else {
            authToken = getSessionToken();
            authorizedUsers.add(new AuthorizedUser(email, authToken, password));
        }
        return authToken;
    }


    public void isUserValid(String email, String authToken, String password) throws Exception {
        AuthorizedUser user = getUser(email, password);
        if( (user != null) && user.getAuthToken().equals(authToken)) return;
        throw new Exception("Not a valid user");
    }
    
    public void isUserValid(String authToken) throws Exception {
    	AuthorizedUser result = null;
        for (AuthorizedUser user : authorizedUsers) {
            if (user.getAuthToken().equals(authToken)){
                result = user;
            }
        }
      if(result==null)  throw new Exception("session token is not valid");
    }


    public synchronized void updateHeartbeat(String email, String password) {
        AuthorizedUser existingUser = getUser(email, password);
        if (existingUser != null) {
            existingUser.setLastHeartbeat(System.currentTimeMillis());
        }
    }


    public void removeIdleUsers(long timeoutInSecond) {
        long currentTime = System.currentTimeMillis();
        for (AuthorizedUser user : authorizedUsers) {
            if ((user.getLastHeartbeat() + (1000*timeoutInSecond)) < currentTime) {
                authorizedUsers.remove(user);
            }
        }
    }


    public synchronized void removeUser(String email, String password) {
        authorizedUsers.remove(getUser(email, password));
    }


    private synchronized AuthorizedUser getUser(String email, String password) {
        AuthorizedUser result = null;
        for (AuthorizedUser user : authorizedUsers) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                result = user;
            }
        }
        return result;
    }
    
    private Collection<AuthorizedUser> authorizedUsers = new HashSet<AuthorizedUser>();
    
    public static String getSessionToken() {
    	return new BigInteger(130, AuthorizedUserManager.getRandom()).toString(32);
	}
    
    public static String getActivationToken() {
    	return new BigInteger(120, AuthorizedUserManager.getRandom()).toString();
	}


	private static SecureRandom getRandom() {
		return new SecureRandom();
	}

}
