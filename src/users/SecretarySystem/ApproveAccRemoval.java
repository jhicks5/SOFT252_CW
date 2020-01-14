/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.SecretarySystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import usersdata.AllData;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author joshh
 */
public class ApproveAccRemoval {
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
                    if(Objects.equals(requestType, "Delete")){
                        String patId = currentAcc.getString("id");
                        patientIds.add(patId);
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
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray patients = curItem.getJSONArray("patients");

                for (int j = 0; j < patients.length(); j++){
                    var currentPat = patients.getJSONObject(j);
                    String currId = currentPat.getString("id");
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
                continue;
            }
        }
        System.out.println(info);
        return info;
    }
    
    public void requestDenied(String patId){
        JSONObject newData = new JSONObject();
        JSONArray accounts = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        Boolean done = false;

        for (int i = 0; i < dataArray.length(); i++){
            try{
                JSONObject curItem = dataArray.getJSONObject(i);
                accounts = curItem.getJSONArray("accountrequest");

                for (int j = 0; j < accounts.length(); j++){
                    var curAcc = accounts.getJSONObject(j);
                    String currId = curAcc.getString("id");
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
        JSONObject newData = new JSONObject();
        JSONArray patients = new JSONArray();
        JSONArray accounts = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        Boolean done = false;

        for (int i = 0; i < dataArray.length(); i++){
            try{
                JSONObject curItem = dataArray.getJSONObject(i);
                patients = curItem.getJSONArray("patients");

                for (int j = 0; j < patients.length(); j++){
                    var curAcc = patients.getJSONObject(j);
                    String currId = curAcc.getString("id");
                    if(Objects.equals(patId, currId)){
                        patients.remove(j);
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
            JOptionPane.showMessageDialog(null, "Request successfully approved, account has been removed", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Unable to deny request, user not found. Check ID", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
        for (int i = 0; i < dataArray.length(); i++){
            try{
                JSONObject curItem = dataArray.getJSONObject(i);
                accounts = curItem.getJSONArray("accountrequest");

                for (int j = 0; j < accounts.length(); j++){
                    var curAcc = accounts.getJSONObject(j);
                    String currId = curAcc.getString("id");
                    if(Objects.equals(patId, currId)){
                        accounts.remove(j);
                        System.out.println("Current Account: "+curAcc);
                    }
                }
            }
            catch(Exception e){
            }
        }
        dataToAppend = dataArray.toString();
        append(dataToAppend);
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
