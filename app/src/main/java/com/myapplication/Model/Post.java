package com.myapplication.Model;

public class Post {

    String userName,password;
    int id;
    String access_token;

   /* public Post(String email, String password,int id) {
        this.userName = email;
        this.password = password;
        this.id = id;
    }*/

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                "userName=" + userName +
                ", password='" + password +
                '}';
    }
}
