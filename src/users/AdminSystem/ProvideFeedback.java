/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.AdminSystem;

import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;
import usersdata.AllData;

/**
 *
 * @author joshh
 */
public class ProvideFeedback {
    protected  String doctorId;
    protected String rating;
    protected String notes;
    
    public String getFeedback(String selectedDoctor){
    String feedbackString = "";
    String data = AllData.getJSONData();
    JSONArray dataArray = new JSONArray(data);

    int count = 0;

    for (int i = 0; i < data.length(); i++){
        try {
            JSONObject curItem = dataArray.getJSONObject(i);
            JSONArray docFeedback = curItem.getJSONArray("docfeedback");
            for (int j = 0; j < docFeedback.length(); j++){
                var currentFb = docFeedback.getJSONObject(j);
                doctorId = currentFb.getString("doctorid");
                if(Objects.equals(selectedDoctor, doctorId)){
                    notes = currentFb.getString("notes");
                    rating = currentFb.getString("rating");
                    feedbackString += ("Doctor: "+doctorId+"\n Rating: "+rating+"\n Notes: "+notes+" \n\n");
                    count += 1;
                }
                else{
                    continue;
                }
            }
        }
        catch(Exception e){
            continue;
        }
    }
    System.out.println("Returned string: "+feedbackString);
    return feedbackString;
    }
}