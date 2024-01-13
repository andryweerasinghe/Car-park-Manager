/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/9/23

 */

package lk.ijse.carparkManager.dto;


public class RegistrationDTO {
    String id;
    String name;
    String jobRole;
    String userName;
    String email;
    String password;
    int mobile;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobRole='" + jobRole + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", password='" + password + '\'' +
                '}';
    }


    public RegistrationDTO() {
    }

    public RegistrationDTO(String id, String name, String jobRole, String email, int mobile, String password, String userName) {
        this.id = id;
        this.name = name;
        this.jobRole = jobRole;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.userName = userName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
