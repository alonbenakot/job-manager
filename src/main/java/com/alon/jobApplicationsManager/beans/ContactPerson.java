package com.alon.jobApplicationsManager.beans;

import lombok.Data;

import java.util.Objects;

@Data
public abstract class ContactPerson {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private ContactType contactType;
    private boolean interviewing;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactPerson that = (ContactPerson) o;

        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        return Objects.equals(phoneNumber, that.phoneNumber);
    }
}
