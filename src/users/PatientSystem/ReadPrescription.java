package users.PatientSystem;

import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;
import usersdata.AllData;
import usersdata.PatientUser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshh
 */
public class ReadPrescription {
    protected String doctorId;
    protected String patientId;
    protected String doctorNotes;
    protected String medicine;
    protected String dosage;
    
    public String getPrescription(){
        String appString = "";
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);

        String patientID = PatientUser.userID;
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray prescriptions = curItem.getJSONArray("prescriptions");

                for (int j = 0; j < prescriptions.length(); j++){
                    var currentPre = prescriptions.getJSONObject(j);
                    String patId = currentPre.getString("patientid");

                    if(Objects.equals(patId, patientID)){
                        doctorId = currentPre.getString("doctorid");
                        patientId = currentPre.getString("patientid");
                        doctorNotes = currentPre.getString("doctornotes");
                        medicine = currentPre.getString("medicine");
                        dosage = currentPre.getString("dosage");
                        appString += ("Administered by Dr ID: "+doctorId+
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
        System.out.println("Returned string: "+appString);
        return appString;
    }
}
