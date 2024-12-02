package org.javaboy.innovationschool.students;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.javaboy.innovationschool.commons.BaseEntity;

@Entity
@Table(name = "students")
public class StudentEntity extends BaseEntity {

    @NotNull(message = "firstname must not be null.")
    private String firstName;

    @NotNull(message = "Last name must not be null.")
    private String lastName;

    private byte[] profilePicture;
    private String email;
    private String phoneNumber;

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

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
