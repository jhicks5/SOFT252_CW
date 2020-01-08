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
    
    public void Login(String id, String Pass){
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);

        if (id.charAt(0) == 'P'){
            for (int i = 0; i < data.length(); i++){
                try {
                    JSONObject curItem = dataArray.getJSONObject(i);
                    JSONArray patients = curItem.getJSONArray("patients");

                    for (int j = 0; j < patients.length(); j++){
                        var currentPat = patients.getJSONObject(j);
                        String patId = currentPat.getString("id");

                        if(Objects.equals(patId, id)){
                            id = currentPat.getString("id");
                            name = currentPat.getString("name");
                            System.out.println(name);
                            gender = currentPat.getString("gender");
                            age = currentPat.getString("age");
                            address = currentPat.getString("address");
                        }
                    }
                }
                catch(Exception e){
                    continue;
                }
            }
            PatientUser p = new PatientUser(id, name, gender, age, address);
            System.out.println("ID is: "+id+"Name: "+name+age+gender);
            p.patientLogin();
        }
        else{
            Login login = new Login();
            login.setVisible(true);
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password, ", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
