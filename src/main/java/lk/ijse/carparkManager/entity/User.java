/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/10/24

 */

package lk.ijse.carparkManager.entity;

public class User {
    String id;
    String name;
    String jobRole;
    String userName;
    String email;
    String password;
    String mobile;

    public User(String id, String name, String jobRole, String userName, String email, String password, String mobile) {
        this.id = id;
        this.name = name;
        this.jobRole = jobRole;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
