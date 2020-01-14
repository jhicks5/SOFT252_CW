/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.DoctorSystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import usersdata.AllData;

/**
 *
 * @author joshh
 */
public class RequestMeds {
    public void appendMed(String medName, String quantity){
        JSONObject newData = new JSONObject();
        JSONArray medicines = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);

        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                medicines = curItem.getJSONArray("medicines");

                newData.put("name", medName);
                newData.put("quantity", quantity);
                newData.put("request", "pending");
                medicines.put(newData);

                break;
                }
            catch(Exception e){
                continue;
            }
        }
        String dataToAppend = dataArray.toString();
        
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
