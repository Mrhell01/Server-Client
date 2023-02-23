package org.wildfly.quickstarts.microprofile;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.SystemException;

import jakarta.ws.rs.client.Entity;
// import org.jboss.arquillian.core.api.annotation.Inject;

public class ManagedBeanAccountDao implements AccountDao {
    
    @Inject
    private EntityManager entityManager;

    @Inject
    private AccountTransaction utx;
    
    public Account getForAccountuser(String accountuser) {
        try {
            Account account;
            try {
                utx.begin();
                Query query = entityManager.createQuery("select u from User u where u.accountuser = :accountuser");
                query.setParameter("username", accountuser);
                Account = (Account) query.getSingleResult();
            } catch (NoResultException e) {
                Account = null;
            }
            utx.commit();
            return Account;
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }

    }















    @Override
    public Account getForAccountuser(String accountUser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getForAccountuser'");
    }

    @Override
    public void createAccount(Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }
    
}
