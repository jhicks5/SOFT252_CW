/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.SecretarySystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import usersdata.AllData;

/**
 *
 * @author joshh
 */
public class ApprovePatientAcc {
    public ArrayList<String> getPatientIds(){
        ArrayList<String> patientIds = new ArrayList<String>();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray accounts = curItem.getJSONArray("accountrequest");

                for (int j = 0; j < accounts.length(); j++){
                    var currentAcc = accounts.getJSONObject(j);
                    String requestType = currentAcc.getString("requesttype");
                    if(Objects.equals(requestType, "Create")){
                        String tempId = currentAcc.getString("tempid");
                        patientIds.add(tempId);
                    }
                }
            }
            catch(Exception e){
                continue;
            }
        }
        System.out.println(patientIds);
        return patientIds;
    }
    
    public String displayInfo(String patId){
        String info = "";
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        String currId = null;
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray patients = curItem.getJSONArray("accountrequest");

                for (int j = 0; j < patients.length(); j++){
                    var currentPat = patients.getJSONObject(j);
                    try {
                        currId = currentPat.getString("tempid");
                    }
                    catch(Exception e){
                    }
                    System.out.println("we got here");
                    if(Objects.equals(currId, patId)){
                        String name = currentPat.getString("name");
                        String address = currentPat.getString("address");
                        String gender = currentPat.getString("gender");
                        String age = currentPat.getString("age");
                        info = ("Name: "+name+"\n"+"Address: "+address+"\n"
                                +"Gender: "+gender+"\n"+"Age: "+age+"\n");
                    }
                }
            }
            catch(Exception e){
            }
        }
        System.out.println("Patient info: "+info);
        return info;
    }
    
    public void requestDenied(String patId){
        JSONObject newData = new JSONObject();
        JSONArray accounts = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        Boolean done = false;
        String currId = null;

        for (int i = 0; i < dataArray.length(); i++){
            try{
                JSONObject curItem = dataArray.getJSONObject(i);
                accounts = curItem.getJSONArray("accountrequest");

                for (int j = 0; j < accounts.length(); j++){
                    var curAcc = accounts.getJSONObject(j);
                    try{
                        currId = curAcc.getString("tempid");
                    }
                    catch(Exception e){  
                    }
                    
                    if(Objects.equals(patId, currId)){
                        accounts.remove(j);
                        System.out.println("Current Account: "+curAcc);
                        done = true;
                    }
                }
            }
            catch(Exception e){
            }
        }
        String dataToAppend = dataArray.toString();
        append(dataToAppend);
        if (done == true){
            JOptionPane.showMessageDialog(null, "Request successfully denied", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Unable to deny request, user not found. Check ID", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void requestApproved(String patId){
        String ID = "";
        JSONObject newData = new JSONObject();
        JSONArray patients = new JSONArray();
        JSONArray accountrequests = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        System.out.println(dataArray);
        Boolean done = false;
        String tempId = null;
        
        String name = null;
        String address = null;
        String gender = null;
        String age = null;
        String password = null;
        
        for (int i = 0; i < dataArray.length(); i++){
            try{
                JSONObject curItem = dataArray.getJSONObject(i);
                accountrequests = curItem.getJSONArray("accountrequests");

                for (int j = 0; j < accountrequests.length(); j++){
                    var curPat = accountrequests.getJSONObject(j);
                    try{
                        tempId = curPat.getString("tempid");
                    }
                    catch(Exception e){
                    }
                    
                    if(Objects.equals(patId, tempId)){
                        name = curPat.getString("name");
                        address = curPat.getString("address");
                        gender = curPat.getString("gender");
                        age = curPat.getString("age");
                        password = curPat.getString("password");
                        
                        accountrequests.remove(j);
                        System.out.println("Current Pat: "+curPat);
                        done = true;
                    }
                }
            }
            catch(Exception e){
            }
        }
        String dataToAppend = dataArray.toString();
        append(dataToAppend);
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                patients = curItem.getJSONArray("patients");

                ID = String.format("P" + "%04d", patients.length() + 1);

                newData.put("id", ID);
                newData.put("name", name);
                newData.put("address", address);
                newData.put("age", age);
                newData.put("password", password);
                newData.put("gender", gender);
                patients.put(newData);
                done = true;
                break;
                }
            catch(Exception e){
                continue;
            }
        }
        dataToAppend = dataArray.toString();
        append(dataToAppend);
        
        if (done == true){
            JOptionPane.showMessageDialog(null, "New login successfully created with id: "+ID, "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void append(String dataToAppend){
        try
        {
            PrintWriter out = new PrintWriter("./data/testJSON.json");
            out.println(dataToAppend);
            out.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
