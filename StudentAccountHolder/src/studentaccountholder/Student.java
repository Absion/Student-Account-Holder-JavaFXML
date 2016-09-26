package studentaccountholder;


/**
 *
 * @author Absion
 */

import java.io.*;

public class Student implements Serializable {
    
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private enum GradeLevel {
        FRESHMAN, SOPHMORE, JUNIOR, SENIOR
    }
    private GradeLevel gLevel;
    
    public String getGradeLevel() {
        return this.gLevel.toString();
    }

    public void setGradeLevel(String input) {
        
        String x = input.toUpperCase();
        
        switch (x){
            case "FRESHMAN":
                this.gLevel = GradeLevel.FRESHMAN;
                break;
            case "SOPHMORE":
                this.gLevel = GradeLevel.SOPHMORE;
                break;
            case "JUNIOR":
                this.gLevel = GradeLevel.JUNIOR;
                break;
            case "SENIOR":
                this.gLevel = GradeLevel.SENIOR;
                break;
            default:
                
        }
              
    }
    

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
   
    
    
}
