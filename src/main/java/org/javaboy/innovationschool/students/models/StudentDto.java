package org.javaboy.innovationschool.students.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.javaboy.innovationschool.commons.BaseDto;

public class StudentDto extends BaseDto {
    //The validation annotations (@NotBlank, @NotNull, etc.) only check the value of fields if they are present in the request payload.
    @NotBlank(message = "First Name cannot be blank. Please provide a valid value.")
    @Size(min = 3, max = 35)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First Name must only contain letters")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank. Please provide a valid value.")
    @Size(min = 3, max = 35)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name must only contain letters")
    private String lastName;

    private byte[] profilePicture;

    @Email(message = "Email must be a valid email address.")
    private String email;

    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{3}$", message = "Phone number must be in the format NNN-NNN-NNN")
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
