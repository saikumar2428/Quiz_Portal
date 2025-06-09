package com.UserInfo;
 
public class User {
    private String firstName;
    private String lastName;
    private String country;
    private String[] languages;
    private String gender;
 
    public User(String firstName, String lastName, String country, String[] languages, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.languages = languages;
        this.gender = gender;
    }
 
    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCountry() { return country; }
    public String[] getLanguages() { return languages; }
    public String getGender() { return gender; }
}
 