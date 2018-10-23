package ru.stqa.pft.adressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String phoneNumber;
    private final String email;

    public ContactData(String firstname, String lastname, String phoneNumber, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
