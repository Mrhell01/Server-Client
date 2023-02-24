package org.wildfly.quickstarts.microprofile;

import jakarta.ws.rs.Produces;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

public class CreateController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private AccountDao accountDao;

    @Named
    @RequestScoped
    private Account newAccount = new Account();
    public void create() {
        try {
            AccountDao.createAccount(newAccount);
            String message = "A new user with id " + newAccount.getId() + " has been created successfully";
            facesContext.addMessage(null, new FacesMessage(message));
        } catch (Exception e) {
            String message = "An error has occured while creating the user (see log for details)";
            facesContext.addMessage(null, new FacesMessage(message));
        }
    }

    private class FacesContext {
        public void addMessage(Object o, FacesMessage facesMessage) {
        }
    }
}
