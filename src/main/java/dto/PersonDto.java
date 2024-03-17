package dto;

import Models.Person;

public class PersonDto {
    private long id;
    private String fullName;
    private int age;

    private String userName;
    private String password;
    private String role;


    public PersonDto(long id, String fullName, int age, String userName, String password, String role) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public PersonDto(long idOwner){
        this.id = idOwner;
    }

    public PersonDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public PersonDto() {
    }

    public PersonDto(String userName, String password, String rol) {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
