package org.wildfly.quickstarts.microprofile;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.security.auth.login.AccountException;
import javax.transaction.SystemException;

import org.jboss.arquillian.core.api.annotation.Inject;
import org.wildfly.quickstarts.microprofile.rest.client.model.Account;

public class ManagedBeanAccountDao implements AccountDao {

    @Inject
    private EntityManager entityManager;

    @Inject
    private AccountException utx;

    public ManagedBeanAccountDao() {
    }

    public Account getForAccountuser(String accountuser) {
        try {
//            Account account;
            Account Account;
            try {
                utx.begin();
                Query query = entityManager.createQuery("select u from User u where u.accountuser = :accountuser");
                query.setParameter("username", accountuser);
                Account = (Account) ((Query) query).getSingleResult();
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
    public Account getForUsername(String username) {
        return null;
    }



    public void createAccount(Account account) {
        try {
            try {
                utx.begin();
                entityManager.persist(account);
            } finally {
                utx.commit();
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }
    }

}
