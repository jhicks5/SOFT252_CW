/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersdata;
import Forms.SecretaryForms.*;
/**
 *
 * @author joshh
 */
public class SecretaryUser implements UserInt{
    String userID = "";
    String name = "";
    String address = "";
    String pass = "";
    
    public SecretaryUser(String userID, String name, String address, String pass)
    {
    this.userID = userID;
    this.name = name;
    this.address = address;
    this.pass = pass;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPass(){
        return pass;
    }
    
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public void secretaryLogin(){
        SecretaryHome homePage = new SecretaryHome();
        homePage.setVisible(true);
    }
}
