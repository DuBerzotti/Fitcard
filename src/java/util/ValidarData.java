/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author maurocésar
 */
public class ValidarData {
    

   public static boolean isValid(String date) {
       if(date.equals("")){
           return true;
       }else{
       
      try {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         LocalDate d = LocalDate.parse(date, formatter);    
         return true;
      } catch (DateTimeParseException e) {
        return false;
      } 
   }
   }
    
}
