/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Users;



/**
 *
 * @author umeshn
 */
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    
    @Inject
    private UsersController userController;
    
    private String userName ;
    
    private String passWord ;
    
    private boolean adminRole = false;
    
    private boolean success = false;
    
    private boolean failure = false;
    
    
    public String login(){
        
         success = false;
         
      
        Collection<Users> allUsers = userController.getItems();
        
        for(Users sUser : allUsers){
            if(sUser.getName().equals(userName) && sUser.getPassword().equals(passWord)){
                
                success = true;
                if(sUser.getRole().equals("admin")){
                  adminRole = true;  
                }else{
                    adminRole = false;
                }
            }
        }
        
        
        if(success){
            failure = true;
        return "index";
        }else{
            failure = true;
            return null;
        }
        
    }
    
    public String logOut(){
         success = false;
         adminRole = false;
         return "index";
        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isAdminRole() {
        return adminRole;
    }

    public void setAdminRole(boolean adminRole) {
        this.adminRole = adminRole;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isFailure() {
        return failure;
    }

    public void setFailure(boolean failure) {
        this.failure = failure;
    }

    
    
    
    
}
