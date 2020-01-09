/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.PatientSystem;
import org.json.*;
import usersdata.AllData;
import usersdata.PatientUser;
import java.util.*;
/**
 *
 * @author joshh
 */
public class ReadAppointment {
    protected String doctorId;
    protected String patientId;
    protected String date;
    
    public String getAppointment(){
        String appString = "";
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);

        String patientID = PatientUser.userID;
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray appointments = curItem.getJSONArray("appointments");
                for (int j = 0; j < appointments.length(); j++){
                    var currentApp = appointments.getJSONObject(j);
                    String attended = currentApp.getString("attended");
                    if (Objects.equals(attended, "false")){
                        String patId = currentApp.getString("patientid");

                        if(Objects.equals(patId, patientID)){
                            doctorId = currentApp.getString("doctorid");
                            patientId = currentApp.getString("patientid");
                            date = currentApp.getString("date");
                            appString += ("Doctor: "+doctorId+"\n To see: "+patientId+"\n On date: "+date+" \n\n");
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
