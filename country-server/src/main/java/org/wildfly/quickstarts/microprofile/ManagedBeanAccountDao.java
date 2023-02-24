package org.wildfly.quickstarts.microprofile;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.security.auth.login.AccountException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.core.api.annotation.Inject;

public class ManagedBeanAccountDao implements AccountDao {

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserTransaction utx;

    public ManagedBeanAccountDao() {
    }

    public Account getForAccountuser(String accountuser) {
        try {

            Account account;
            try {
                utx.begin();
                Query query = entityManager.createQuery("select u from User u where u.accountuser = :accountuser");
                query.setParameter("username", accountuser);
                account = (Account) ((Query) query).getSingleResult();
            } catch (NoResultException e) {
                account = null;
            }
            utx.commit();
            return account;
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }

    }

//    @Override
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
