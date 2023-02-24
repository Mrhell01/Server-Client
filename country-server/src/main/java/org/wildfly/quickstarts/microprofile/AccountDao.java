package org.wildfly.quickstarts.microprofile;

public interface AccountDao {
    Account getForAccountuser(String accountUser);


//    Account getForUsername(String username);

    public void createAccount(Account account);

}

