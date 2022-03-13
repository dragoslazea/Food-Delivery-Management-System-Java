package business;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clasa pentru utilizator
 * @author Dragos-Bogdan Lazea, CTI-UTCN, 30223
 * @since May 2021
 */
public class User implements Serializable {
    /**
     * ID-ul utilizatorului
     */
    private int id;

    /**
     * Numele de utiliztor
     */
    private String username;

    /**
     * Parola
     */
    private String password;

    /**
     * Tipul utilizatorului
     */
    private UserType userType;

    /**
     * Constructor
     * @param id ID
     * @param username username
     * @param password parola
     * @param userType tip
     */
    public User(int id, String username, String password, UserType userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    /**
     * Getter
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * Getter
     * @return usernam
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter
     * @return parola
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter
     * @return tip
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Suprasciere equals()
     * @param o obiect cu care se compara
     * @return valoare booleana
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && username.equals(user.username) && password.equals(user.password) && userType == user.userType;
    }

    /**
     * Suprascriere hashCode()
     * @return hashCode dupa username
     */
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    /**
     * Suprascriere toString()
     * @return string cu informatiile despre utilizator
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }


}
