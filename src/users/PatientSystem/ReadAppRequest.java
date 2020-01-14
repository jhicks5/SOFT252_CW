/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.PatientSystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import usersdata.AllData;
import java.util.*;
import usersdata.PatientUser;
import usersdata.SecretaryUser;
/**
 *
 * @author joshh
 */
public class ReadAppRequest {
    public boolean appendToFile(String patId, String docId, String date){
        //String patID = PatientUser.userID;
        JSONObject newData = new JSONObject();
        JSONArray appoints = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        System.out.println(dataArray);
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                appoints = curItem.getJSONArray("appointments");
                //newData = appoints.getJSONObject(0);
                newData.put("doctorid", docId);
                newData.put("patientid", patId);
                newData.put("attended", "false");
                if(Objects.equals(SecretaryUser.name, "")){
                    newData.put("requested", "pending");
                    
                }
                else{
                    newData.put("requested", "approved");
                }
                newData.put("date", date);
                appoints.put(newData);
                //dataArray.put(appoints);
                break;
                }
            catch(Exception e){
                continue;
            }
        }
        String dataToAppend = dataArray.toString();
        System.out.println(dataToAppend);
        System.out.println(dataArray);
        try
        {
            PrintWriter out = new PrintWriter(".\\data\\testJSON.json");
            out.println(dataToAppend);
            out.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return true;
    }
}
