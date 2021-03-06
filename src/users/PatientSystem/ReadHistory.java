/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.PatientSystem;

import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;
import usersdata.AllData;
import usersdata.PatientUser;

/**
 *
 * @author joshh
 */
public class ReadHistory {
    protected String doctorId;
    protected String patientId;
    protected String date;
    protected String note;
    
    public String getAppointment(String patientID){
    String appString = "";
    String data = AllData.getJSONData();
    JSONArray dataArray = new JSONArray(data);


    for (int i = 0; i < data.length(); i++){
        try {
            JSONObject curItem = dataArray.getJSONObject(i);
            JSONArray appointments = curItem.getJSONArray("appointments");
            for (int j = 0; j < appointments.length(); j++){
                var currentApp = appointments.getJSONObject(j);
                String attended = currentApp.getString("attended");
                if (Objects.equals(attended, "true")){
                    String patId = currentApp.getString("patientid");

                    if(Objects.equals(patId, patientID)){
                        doctorId = currentApp.getString("doctorid");
                        patientId = currentApp.getString("patientid");
                        date = currentApp.getString("date");
                        note = currentApp.getString("notes");
                        appString += ("Doctor: "+doctorId+"\n Saw: "+patientId+"\n On date: "+date+" \n  Notes: \n"+note+"\n\n");
                    }
                }
            }
        }
        catch(Exception e){
            continue;
        }
    }
    System.out.println("Returned string: "+appString);
    return appString;
    }
}
