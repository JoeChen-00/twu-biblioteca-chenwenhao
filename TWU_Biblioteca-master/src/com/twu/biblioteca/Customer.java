package com.twu.biblioteca;

public class Customer {
    private String UserName;
    private String Password;
    private String Name;
    private String Email;
    private String PhoneNumber;

    Customer(String userName,String password,String name,String email,String phoneNumber){
        this.UserName = userName;
        this.Password = password;
        this.Name = name;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
    }

    public boolean signIn(String password) {
        if (this.Password.equals(password))
            return true;
        else
            return false;
    }

    public void showUserInfo(){
        System.out.println("name:"+this.Name);
        System.out.println("Email:"+this.Email);
        System.out.println("Phone Number:"+this.PhoneNumber);
    }

    public String getUserName(){return this.UserName;}
}
