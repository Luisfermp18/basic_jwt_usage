package model;

public class Person {

    private String userCode;
    private String token;

    public Person(String userCode, String token) {
        this.userCode = userCode;
        this.token = token;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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
                "userCode='" + userCode + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
