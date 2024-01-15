package com.bursu.springmongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "owner")
public class Owner {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Owner() {}

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Owner[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}