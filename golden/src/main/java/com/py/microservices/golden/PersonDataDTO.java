package com.py.microservices.golden;

import java.io.Serializable;

/**
 * @author mgonzalez
 */
public class PersonDataDTO implements Serializable {
    private String name;
    private String surname;
    private String ciNumber;
    private String photo;

    public PersonDataDTO(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCiNumber() {
        return ciNumber;
    }

    public void setCiNumber(String ciNumber) {
        this.ciNumber = ciNumber;
    }
}
