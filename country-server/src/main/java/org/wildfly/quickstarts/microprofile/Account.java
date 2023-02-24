    package org.wildfly.quickstarts.microprofile;

    import javax.persistence.*;

    @Entity
    @Table(name ="Account")
    public class Account {
        @Id
        @GeneratedValue
        private Long id;

        @Column(unique = true)
    private String Accountuser;

    private String firstName;

    private String lastName;

        public Long getId() {
            return id;
        }

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


