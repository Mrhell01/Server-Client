package org.wildfly.quickstarts.microprofile;

public interface AccountDao {
    Account getForAccountuser(String accountUser);

    void createAccount(Account account);
}
