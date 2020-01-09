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

/**
 *
 * @author joshh
 */
public class RequestAccTermination {
    public Boolean appendToFile(String userId){
    JSONObject newData = new JSONObject();
    JSONArray accRequests = new JSONArray();
    String data = AllData.getJSONData();
    JSONArray dataArray = new JSONArray(data);
    System.out.println(dataArray);
    for (int i = 0; i < data.length(); i++){
        try {
            JSONObject curItem = dataArray.getJSONObject(i);
            accRequests = curItem.getJSONArray("accountrequest");
            newData.put("id", userId);
            newData.put("requesttype", "Delete");
            accRequests.put(newData);
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
