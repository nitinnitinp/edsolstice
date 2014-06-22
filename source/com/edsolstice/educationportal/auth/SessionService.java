package com.edsolstice.educationportal.auth;




public class SessionService {

  private static AuthorizedUserManager authorizedUserManager = new AuthorizedUserManager();
       
    public static void updateHeartbeat(String userName, String password) {
        authorizedUserManager.updateHeartbeat(userName, password);
    }


    public static String addUser(String userName, String password) {
        return authorizedUserManager.addUser(userName, password);
    }

    public static boolean isUserValid(String userName, String authToken, String password) {
        return authorizedUserManager.isUserValid(userName, authToken, password);
    }
    
    
}