/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersdata;
import java.io.*;
import org.json.*;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author joshh
 */
public class AllData {
    public static String getJSONData() {
        File file = new File("C:\\Users\\joshh\\Documents\\NetBeansProjects\\SOFT252_CW\\data\\testJSON.json");
        String result = "";
        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())){
            while(sc.hasNext()) {
            result += sc.nextLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        
        String trim = result.trim();
        return trim;
    }
}