package org.wildfly.quickstarts.microprofile;

// import javax.ejb.Stateful;
// import javax.enterprise.inject.Alternative;
// import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateful
@Alternative
public class EJBAccountDao implements  AccountDao{
    
    private EntityManager entityManager;
    
    public Account getforAccount(String acccountuser) {
        try{
            Query query = entityManager.createQuery("select u from User u where u.accountuser = ?");
            query.setParameter(1, acccountuser);
            return (Account) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
    }
    public void createAccount(Account account) {
        entityManager.persist(account);
    }
    @Override
    public Account getForAccountuser(String accountUser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getForAccountuser'");
    }

}
