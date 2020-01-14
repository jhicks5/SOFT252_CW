/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.SecretarySystem;

import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;
import usersdata.AllData;
/**
 *
 * @author joshh
 */
public class HandoverMedicine {
        public ArrayList<String> getPrescriptions(String givenId){
        ArrayList<String> appData = new ArrayList<String>();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);

        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray prescriptions = curItem.getJSONArray("prescriptions");

                for (int j = 0; j < prescriptions.length(); j++){
                    var currentPre = prescriptions.getJSONObject(j);
                    String patientId = currentPre.getString("patientid");

                    if(Objects.equals(patientId, givenId)){
                        String doctorId = currentPre.getString("doctorid");
                        String doctorNotes = currentPre.getString("doctornotes");
                        String medicine = currentPre.getString("medicine");
                        String dosage = currentPre.getString("dosage");

                        appData.add(j, "Administered by Dr ID: "+doctorId+
                                "\n for Patient ID: "+patientId+"\n Notes: "
                                +doctorNotes+"\n Medicine: "+medicine
                                +"\n Dosage: "+dosage+"\n\n");
                    }
                }
            }
            catch(Exception e){
                continue;
            }
        }
        System.out.println("Returned string: "+appData);
        return appData;
    }
}
