/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.AdminSystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import usersdata.AllData;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author joshh
 */
public class AddRemDocSec {
    Boolean done = false;
    public void addRemDocSec(String docOrSec, String id, String selection, String name, String address, String password){
        String ID = "";
        JSONObject newData = new JSONObject();
        JSONArray doctors = new JSONArray();
        JSONArray secretaries = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        System.out.println(dataArray);

        if(Objects.equals(docOrSec, "doctor")){
            if (Objects.equals(selection, "add")){
                for (int i = 0; i < data.length(); i++){
                    try {
                        JSONObject curItem = dataArray.getJSONObject(i);
                        doctors = curItem.getJSONArray("doctors");

                        ID = String.format("D" + "%04d", doctors.length() + 1);

                        newData.put("id", ID);
                        newData.put("name", name);
                        newData.put("address", address);
                        newData.put("password", password);
                        doctors.put(newData);
                        done = true;
                        break;
                        }
                    catch(Exception e){
                        continue;
                    }
                }
                String dataToAppend = dataArray.toString();
                append(dataToAppend);
                if (done == true){
                    JOptionPane.showMessageDialog(null, "New login successfully created with id: "+ID, "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if (Objects.equals(selection, "remove")){
                System.out.println("Remove confirmed");
                for (int i = 0; i < dataArray.length(); i++){
                    try{
                        JSONObject curItem = dataArray.getJSONObject(i);
                        doctors = curItem.getJSONArray("doctors");

                        for (int j = 0; j < doctors.length(); j++){
                            var curDoc = doctors.getJSONObject(j);
                            String docId = curDoc.getString("id");
                            if(Objects.equals(id, docId)){
                                doctors.remove(j);
                                System.out.println("Current Doc: "+curDoc);
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
                    JOptionPane.showMessageDialog(null, "Doctor login successfully removed", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Unable to remove login, user not found. Check ID", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
        if(Objects.equals(docOrSec, "secretary")){
            if (Objects.equals(selection, "add")){
                for (int i = 0; i < data.length(); i++){
                    try {
                        JSONObject curItem = dataArray.getJSONObject(i);
                        secretaries = curItem.getJSONArray("secretaries");

                        ID = String.format("S" + "%04d", secretaries.length() + 1);

                        newData.put("id", ID);
                        newData.put("name", name);
                        newData.put("address", address);
                        newData.put("password", password);
                        secretaries.put(newData);
                        done = true;
                        break;
                        }
                    catch(Exception e){
                        continue;
                    }
                }
                String dataToAppend = dataArray.toString();
                append(dataToAppend);
                if (done == true){
                    JOptionPane.showMessageDialog(null, "New login successfully created with id: "+ID, "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if (Objects.equals(selection, "remove")){
                System.out.println("Remove confirmed");
                for (int i = 0; i < dataArray.length(); i++){
                    try{
                        JSONObject curItem = dataArray.getJSONObject(i);
                        secretaries = curItem.getJSONArray("secretaries");

                        for (int j = 0; j < secretaries.length(); j++){
                            var curSec = secretaries.getJSONObject(j);
                            String secId = curSec.getString("id");
                            if(Objects.equals(id, secId)){
                                secretaries.remove(j);
                                System.out.println("Current Sec: "+curSec);
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
                    JOptionPane.showMessageDialog(null, "Secretary login successfully removed", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Unable to remove login, user not found. Check ID", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
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
