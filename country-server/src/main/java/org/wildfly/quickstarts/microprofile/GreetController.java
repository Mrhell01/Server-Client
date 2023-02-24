package org.wildfly.quickstarts.microprofile;

public class GreetController {

    @Inject
    private AccountDao accountDao;

    private String username;

    private String greeting;

    public void greet() {
        Account account = accountDao.getForUsername(username);
        if (account != null) {
            greeting = "Hello, " + account.getFirstName() + " " + account.getLastName() + "!";
        } else {
            greeting = "No such user exists! Use 'emuster' or 'jdoe'";
        }
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGreeting() {
        return greeting;
    }
}
