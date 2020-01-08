/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.PatientSystem;
import org.json.*;
import usersdata.AllData;
import java.util.*;
/**
 *
 * @author joshh
 */
public class AppendFeedback {
    public ArrayList<String> getDocNames(){
        ArrayList<String> docIds = new ArrayList<String>();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray doctors = curItem.getJSONArray("doctors");

                for (int j = 0; j < doctors.length(); j++){
                    var currentApp = doctors.getJSONObject(j);
                    String docId = currentApp.getString("name");
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
        JSONArray docFeedback = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        System.out.println(dataArray);
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                docFeedback = curItem.getJSONArray("docfeedback");
                newData = docFeedback.getJSONObject(0);
                newData.put("doctorid", docId);
                newData.put("rating", rating);
                newData.put("notes", notes);
                docFeedback.put(newData);
                dataArray.put(docFeedback);
                break;
                }
            catch(Exception e){
                continue;
            }
        }
        System.out.println(dataArray);
        return true;
    }
}
