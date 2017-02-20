package tech.jinhaoma.service;

/**
 * Created by mjrt on 2/20/2017.
 */
public interface AuthorizationService {
    String login(String name ,String passWord);
    boolean signOut(String token);
    boolean authorize(String token,String userName);
}
