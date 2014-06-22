package com.edsolstice.educationportal.auth;




public class SessionService {

  private static AuthorizedUserManager authorizedUserManager = new AuthorizedUserManager();
       
    public static void updateHeartbeat(String userName, String password) {
        authorizedUserManager.updateHeartbeat(userName, password);
    }


    public static String addUser(String userName, String password) {
        return authorizedUserManager.addUser(userName, password);
    }

    public static void isUserValid(String userName, String authToken, String password) throws Exception {
         authorizedUserManager.isUserValid(userName, authToken, password);
    }
    
    
    public static void isUserValid(String authToken) throws Exception {
         authorizedUserManager.isUserValid(authToken);
    }
    
    
}