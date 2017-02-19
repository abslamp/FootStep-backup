package edu.heu.soft.domain;

/**
 * Created by mjrt on 2/19/2017.
 */
public class User {

    private Long id;
    private String name;
    private String passWord;
    private String gender;
    private boolean isLeader;
    private String department;
    private String edu;

    public User() {
    }

    public User(String name, String passWord, String gender, boolean isLeader, String department, String edu) {
        this.name = name;
        this.passWord = passWord;
        this.gender = gender;
        this.isLeader = isLeader;
        this.department = department;
        this.edu = edu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", gender='" + gender + '\'' +
                ", isLeader=" + isLeader +
                ", department='" + department + '\'' +
                ", edu='" + edu + '\'' +
                '}';
    }
}
