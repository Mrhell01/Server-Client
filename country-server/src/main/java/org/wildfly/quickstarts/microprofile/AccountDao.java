package org.wildfly.quickstarts.microprofile;

public interface AccountDao {
    Account getForAccountuser(String accountUser);


    Account getForUsername(String username);

    static void createAccount(Account account) {

    }
}
