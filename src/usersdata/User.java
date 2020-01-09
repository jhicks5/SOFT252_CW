/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersdata;
import org.json.*;
import java.util.*;
import Forms.Login;
import javax.swing.JOptionPane;
/**
 *
 * @author joshh
 */
public class User implements UserInt{
    protected String id;
    protected String pass;
    protected String name;
    protected String address;
    protected String age;
    protected String gender;
    
    public User(String newID, String newPass){
        String id = newID;
        String password = newPass;
    }
    
    public User(String newID, String newPass, String newName,
        String newAddress, String newAge, String newGender)
    {
        id = newID;
        pass = newPass;
        name = newName;
        address = newAddress;
        age = newAge;
        gender = newGender;
    }
    
    public void Login(String id, String userPass){
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        Boolean loginToken = false;
        if (id.charAt(0) == 'P'){
            for (int i = 0; i < data.length(); i++){
                try {
                    JSONObject curItem = dataArray.getJSONObject(i);
                    JSONArray patients = curItem.getJSONArray("patients");

                    for (int j = 0; j < patients.length(); j++){
                        var currentPat = patients.getJSONObject(j);
                        String patId = currentPat.getString("id");
                        String patPass = currentPat.getString("password");

                        if(Objects.equals(patId, id) && Objects.equals(patPass, userPass)){
                            id = currentPat.getString("id");
                            name = currentPat.getString("name");
                            gender = currentPat.getString("gender");
                            age = currentPat.getString("age");
                            address = currentPat.getString("address");
                            pass = currentPat.getString("password");
                            loginToken = true;
                        }
                    }
                }
                catch(Exception e){
                    continue;
                }
            }
            PatientUser p = new PatientUser(id, name, gender, age, address, pass);
            System.out.println("ID is: "+id+"Name: "+name+age+gender+"PASSWORD "+pass);
            
            if (loginToken == true){
                p.patientLogin();            
            }
            else{
                loginFail();
            }

        }
        else if (id.charAt(0) == 'A'){
            for (int i = 0; i < data.length(); i++){
                try {
                    JSONObject curItem = dataArray.getJSONObject(i);
                    JSONArray admins = curItem.getJSONArray("administrators");

                    for (int j = 0; j < admins.length(); j++){
                        var currentAdm = admins.getJSONObject(j);
                        String admId = currentAdm.getString("id");
                        String admPass = currentAdm.getString("password");
                        
                        if(Objects.equals(admId, id) && Objects.equals(admPass, userPass)){
                            id = currentAdm.getString("id");
                            name = currentAdm.getString("name");
                            address = currentAdm.getString("address");
                            pass = currentAdm.getString("password");
                            loginToken = true;
                        }
                    }
                }
                catch(Exception e){
                    continue;
                }
            }
            AdminUser a = new AdminUser(id, name, address, pass);
            System.out.println("ID is: "+id+"Name: "+name+address);
          
            if(loginToken == true){
                a.adminLogin();
            }
            else{
                loginFail();
            }

        }
        else if (id.charAt(0) == 'D'){
            for (int i = 0; i < data.length(); i++){
                try {
                    JSONObject curItem = dataArray.getJSONObject(i);
                    JSONArray doctors = curItem.getJSONArray("doctors");

                    for (int j = 0; j < doctors.length(); j++){
                        var currentDoc = doctors.getJSONObject(j);
                        String docId = currentDoc.getString("id");
                        String docPass = currentDoc.getString("password");
                        
                        if(Objects.equals(docId, id) && Objects.equals(docPass, userPass)){
                            id = currentDoc.getString("id");
                            name = currentDoc.getString("name");
                            address = currentDoc.getString("address");
                            pass = currentDoc.getString("password");
                            loginToken = true;
                        }
                    }
                }
                catch(Exception e){
                    continue;
                }
            }
            DoctorUser d = new DoctorUser(id, name, address, pass);
            System.out.println("ID: "+id+" Name: "+name+" Address: "+address);
            
            if (loginToken == true){
                d.doctorLogin();
            }
            else{
                loginFail();
            }
        }
        else if (id.charAt(0) == 'S'){
            for (int i = 0; i < data.length(); i++){
                try {
                    JSONObject curItem = dataArray.getJSONObject(i);
                    JSONArray secretaries = curItem.getJSONArray("secretaries");

                    for (int j = 0; j < secretaries.length(); j++){
                        var currentSec = secretaries.getJSONObject(j);
                        String secId = currentSec.getString("id");
                        String secPass = currentSec.getString("password");

                        if(Objects.equals(secId, id) && Objects.equals(secPass, userPass)){
                            id = currentSec.getString("id");
                            name = currentSec.getString("name");
                            address = currentSec.getString("address");
                            pass = currentSec.getString("password");
                            loginToken = true;
                        }
                    }
                }
                catch(Exception e){
                    continue;
                }
            }
            SecretaryUser s = new SecretaryUser(id, name, address, pass);
            System.out.println("ID: "+id+" Name: "+name+" Address: "+address);
            if (loginToken == true){
                s.secretaryLogin();               
            }
            else{
                loginFail();
            }
        }
        else{
            loginFail();
        }
    }
    
    public void loginFail(){
        Login login = new Login();
        login.setVisible(true);
        JOptionPane.showMessageDialog(null, "Incorrect Username or Password, ", "Invalid Credentials", JOptionPane.INFORMATION_MESSAGE);
    }
}
