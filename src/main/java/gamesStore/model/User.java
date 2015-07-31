package gamesStore.model;

import javax.persistence.*;

/**
 * Created by Przemek_Swiderski on 2015-07-31.
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String login;

    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}