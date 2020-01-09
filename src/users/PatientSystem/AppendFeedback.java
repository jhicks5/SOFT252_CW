/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.PatientSystem;
import org.json.*;
import usersdata.AllData;
import java.util.*;
import java.io.*;
/**
 *
 * @author joshh
 */
public class AppendFeedback {
    public ArrayList<String> getDocIds(){
        ArrayList<String> docIds = new ArrayList<String>();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray doctors = curItem.getJSONArray("doctors");

                for (int j = 0; j < doctors.length(); j++){
                    var currentApp = doctors.getJSONObject(j);
                    String docId = currentApp.getString("id");
                    docIds.add(docId);
                }
            }
            catch(Exception e){
                continue;
            }
        }
        System.out.println(docIds);
        return docIds;
    }
    
    public Boolean appendToFile(String docId, String rating, String notes){
        JSONObject newData = new JSONObject();
        JSONArray docFeedback;
        //docFeedback = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        System.out.println(dataArray);
        Boolean done = false;
        while(done = false){
            for (int i = 0; i < data.length(); i++){
                try {
                    JSONObject curItem = dataArray.getJSONObject(i);
                    docFeedback = curItem.getJSONArray("docfeedback");
                    //newData = docFeedback.getJSONObject(0);
                    newData.put("doctorid", docId);
                    newData.put("rating", rating);
                    newData.put("notes", notes);
                    //docFeedback.put(newData);
                    //dataArray.put(docFeedback);
                    done = true;
                    }
                catch(Exception e){
                    continue;
                }
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
