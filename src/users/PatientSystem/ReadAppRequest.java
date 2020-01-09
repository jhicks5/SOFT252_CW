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
import org.joda.time.*;
import usersdata.PatientUser;
/**
 *
 * @author joshh
 */
public class ReadAppRequest {
    public boolean appendToFile(String patId,String docId,String date){
        String patID = PatientUser.userID;
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
                
                DateTime dt = new DateTime();
                int month = dt.getMonthOfYear();
                String monthStr = "";
                if (month < 10){
                    monthStr = ("0"+Integer.toString(month));
                }
                else{
                    monthStr = (Integer.toString(month));
                }
                String year = Integer.toString(dt.getYear());
                String formatDate = (date+"/"+monthStr+"/"+year);
                newData.put("date", formatDate);
                newData.put("requested", "true");
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
            PrintWriter out = new PrintWriter("C:\\Users\\joshh\\Documents\\NetBeansProjects\\SOFT252_CW\\data\\testJSON.json");
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
