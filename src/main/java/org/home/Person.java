package org.home;

import java.time.LocalDate;

public class Person {
    private String secondName;
    private String name;
    private String patronymic;
    private LocalDate birthday;
    private Integer phone;
    private Gender gender;

    public Person() {
    }

    public Person(String secondName, String name,
                  String patronymic, LocalDate birthday,
                  Integer phone, Gender gender) {
        this.secondName = secondName;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Integer getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return secondName + " " + name + " " +  patronymic + " "
                + birthday.getDayOfMonth() + "."
                + birthday.getMonthValue() + "."
                + birthday.getYear() + " "
                + phone + " "
                + gender;
    }
}
