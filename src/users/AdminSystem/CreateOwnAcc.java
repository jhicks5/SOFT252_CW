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

/**
 *
 * @author joshh
 */
public class CreateOwnAcc {
    public static Boolean createAccount(String givenName, String givenAdd, String givenPass){
        //int adminCount = 0;
        String newId = "";
        JSONObject newData = new JSONObject();
        JSONArray adminAccount = new JSONArray();
        JSONArray userCount = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        //System.out.println(dataArray);
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                
                adminAccount = curItem.getJSONArray("administrators");
                int adminCount = adminAccount.length() + 1;
                
                if(adminCount < 10){
                    newId = "A000"+Integer.toString(adminCount);
                }
                else if(adminCount > 10 && adminCount < 100){
                    newId = "A00"+Integer.toString(adminCount);
                }
                else{
                    newId = "A0"+Integer.toString(adminCount);
                }

                newData.put("id", newId);
                newData.put("name", givenName);
                newData.put("address", givenAdd);
                newData.put("password", givenPass);
                adminAccount.put(newData);
                }
            catch(Exception e){
                continue;
            }
        }
        String dataToAppend = dataArray.toString();
        //System.out.println(dataToAppend);
        //System.out.println(dataArray);
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
        return true;
    }
}
