/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/10/23

 */

package lk.ijse.carparkManager.dto;

public class LoginDTO {
    String password;
    String username;

    @Override
    public String toString() {
        return "LoginDTO{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public LoginDTO(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public LoginDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginDTO(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
