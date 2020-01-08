/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersdata;
import Forms.DoctorForms.*;
/**
 *
 * @author joshh
 */
public class DoctorUser implements UserInt {
    String userID = "";
    String name = "";
    String address = "";
    public DoctorUser(String userID, String name, String address)
    {
    this.userID = userID;
    this.name = name;
    this.address = address;
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
    
    public void doctorLogin(){
        DoctorHome homePage = new DoctorHome();
        homePage.setVisible(true);
    }
}
