package net.integrio.test.db;


public class User {

    private int id;
    private String login;
    private String password;
    private String lastName;
    private String firstName;

    public User(){ }
    public User(String login, String password){

        this.login = login;
        this.password = password;
    }
    public User(int id, String login, String password){

        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, String lastName, String firstName){

        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public User(String login, String password, String lastName, String firstName){

        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
