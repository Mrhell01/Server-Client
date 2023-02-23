package org.wildfly.quickstarts.microprofile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="Account")
public class Account {

@Column(unique = true)
private String Accountuser;

private String firstName;

private String lastName;

public String getAccountuser() {
    return Accountuser;
}

public void setAccountuser(String accountuser) {
    Accountuser = accountuser;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}


}


