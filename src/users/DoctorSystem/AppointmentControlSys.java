/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.DoctorSystem;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;
import usersdata.AllData;
/**
 *
 * @author joshh
 */
public class AppointmentControlSys {
    public ArrayList<String> getPatientIds(){
        ArrayList<String> patientIds = new ArrayList<String>();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray patients = curItem.getJSONArray("patients");

                for (int j = 0; j < patients.length(); j++){
                    var currentApp = patients.getJSONObject(j);
                    String patId = currentApp.getString("id");
                    patientIds.add(patId);
                }
            }
            catch(Exception e){
                continue;
            }
        }
        System.out.println(patientIds);
        return patientIds;
    }
    
    public String getPatHistory(String patientID){
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
                            String doctorId = currentApp.getString("doctorid");
                            String patientId = currentApp.getString("patientid");
                            String date = currentApp.getString("date");
                            String note = currentApp.getString("notes");
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
    
    public ArrayList<String> getPatientApps(String selectedPat){
        ArrayList<String> patientApps = new ArrayList<String>();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray appointments = curItem.getJSONArray("appointments");

                for (int j = 0; j < appointments.length(); j++){
                    var currentApp = appointments.getJSONObject(j);
                    String patId = currentApp.getString("patientid");
                    String attended = currentApp.getString("attended");
                    String request = currentApp.getString("request");
                    
                    if(Objects.equals(patId, selectedPat) &&
                            Objects.equals(attended, "false") &&
                            Objects.equals(request, "approved")){
                        String appDate = currentApp.getString("date");
                        patientApps.add(appDate);
                    }
                }
            }
            catch(Exception e){
                continue;
            }
        }
        System.out.println(patientApps);
        return patientApps;
    }
    
    public Boolean markAsAttended(String selectedApp, String patientId){
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray appointments = curItem.getJSONArray("appointments");

                for (int j = 0; j < appointments.length(); j++){
                    var currentApp = appointments.getJSONObject(j);
                    String patId = currentApp.getString("patientid");
                    String date = currentApp.getString("date");
                    
                    if(Objects.equals(patId, patientId) &&
                        Objects.equals(date, selectedApp)){
                        currentApp.put("attended", "true");
                    }
                }
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
        return true;
    }
    
    public Boolean appendAppNotes(String notes, String patientId, String selectedApp){
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        System.out.println("Notes: "+notes);
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray appointments = curItem.getJSONArray("appointments");

                for (int j = 0; j < appointments.length(); j++){
                    var currentApp = appointments.getJSONObject(j);
                    String patId = currentApp.getString("patientid");
                    String date = currentApp.getString("date");
                    
                    if(Objects.equals(patId, patientId) &&
                        Objects.equals(date, selectedApp)){
                        currentApp.put("notes", notes);
                        System.out.println(notes);
                    }
                }
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
        return(true);
    }
    
    public ArrayList<String> getMedicines(){
        ArrayList<String> medArray = new ArrayList<String>();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                JSONArray medicines = curItem.getJSONArray("medicines");
                
                for (int j = 0; j < medicines.length(); j++){
                    var currentMed = medicines.getJSONObject(j);
                    String requestStatus = currentMed.getString("request");
                    String medName = currentMed.getString("name");
                    
                    if(Objects.equals(requestStatus, "approved")){
                        medArray.add(medName);
                    }
                }
            }
            catch(Exception e){
                continue;
            }
        }
        System.out.println(medArray);
        return medArray;
    }
    
    public Boolean appendPrescription(String doctorid, String patientid, String dosage, String notes, String medicine){
        JSONObject newData = new JSONObject();
        JSONArray prescriptions = new JSONArray();
        String data = AllData.getJSONData();
        JSONArray dataArray = new JSONArray(data);
        
        for (int i = 0; i < data.length(); i++){
            try {
                JSONObject curItem = dataArray.getJSONObject(i);
                prescriptions = curItem.getJSONArray("prescriptions");

                newData.put("doctorid", doctorid);
                newData.put("patientid", patientid);
                newData.put("dosage", dosage);
                newData.put("notes", notes);
                newData.put("medicine", medicine);
                newData.put("received", "false");
                
                prescriptions.put(newData);

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
        
        return true;
    }
}
