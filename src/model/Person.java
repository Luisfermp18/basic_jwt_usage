package model;

public class Person {

    private String name;
    private String surname;
    private String token;

    public Person(String name, String surname, String token) {
        this.name = name;
        this.surname = surname;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
