package com.juvenxu.mvnbook.account.persist;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-5
 * Time: 下午8:59
 */
public class Account {
    private String id;
    private String name;
    private String email;
    private String password;

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private boolean activated;

}
