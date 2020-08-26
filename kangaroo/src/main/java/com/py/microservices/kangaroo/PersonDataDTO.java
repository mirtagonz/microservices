package com.py.microservices.kangaroo;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author mgonzalez
 */
public class PersonDataDTO implements Serializable {
    @NotNull
    @Size(max=100, min = 1)
    private String name;

    @NotNull
    @Size(max=200, min = 1)
    private String surname;

    @NotNull
    @Size(max=10, min = 1)
    private String ciNumber;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("surname", surname)
                .append("ciNumber", ciNumber)
                .toString();
    }
}
