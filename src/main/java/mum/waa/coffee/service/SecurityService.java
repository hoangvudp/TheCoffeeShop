package mum.waa.coffee.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
