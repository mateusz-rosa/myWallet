package com.mywallet.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Mateusz on 2017-01-08.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    private String login;
    @Email
    private String mail;
    private float accountBallance;

    public User() {

    }

    public User(String login, String mail, float accountBallance) {
        this.login = login;
        this.mail = mail;
        this.accountBallance = accountBallance;
    }

    public String getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public float getAccountBallance() {
        return accountBallance;
    }

    public void setAccountBallance(float accountBallance) {
        this.accountBallance = accountBallance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", login='" + login + '\'' +
                ", mail='" + mail + '\'' +
                ", accountBallance=" + accountBallance +
                '}';
    }
}
