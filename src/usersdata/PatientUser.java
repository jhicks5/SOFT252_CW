/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersdata;
import Forms.PatientForms.*;

/**
 *
 * @author joshh
 */
public class PatientUser implements UserInt{
    public static String userID = "";
    public String name = "";
    public String address = "";
    public String gender = "";
    public String age = "";
    
    public PatientUser(String newID, String newPass){
        String id = userID;
        String password = newPass;
    }
    
    public PatientUser(String userID, String name, String address, String gender, String age)
    {
    this.userID = userID;
    this.name = name;
    this.address = address;
    this.gender = gender;
    this.age = age;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    public void patientLogin(){
        PatientHome homePage = new PatientHome();
        homePage.setVisible(true);
    }
    
}
