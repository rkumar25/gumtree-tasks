package com.gumtree.tasks.domain;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by Sameer on 25/01/2015.
 */
public class Person {

    private final String fullName;

    private final Gender gender;

    private final LocalDate dateOfBirth;

    /**
     *
     * @param fullName
     * @param gender
     * @param dob
     */
    public Person(String fullName, String gender, String dob) {
        this.fullName = fullName.trim();
        this.gender = Gender.valueOf(gender.trim());
        dateOfBirth = createDOB(dob.trim());
    }

    private LocalDate createDOB(String dob) {
        return LocalDate.parse(dob,
                DateTimeFormat.forPattern("dd/MM/yy"));
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender.toString();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    private enum Gender {
        Male,Female

    }
}
