package studentaccountholder;


/**
 *
 * @author Absion
 */

import java.io.*;

public class Student {
    
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private enum GradeLevel {
        FRESHMAN, SOPHMORE, JUNIOR, SENIOR
    }
    private GradeLevel gLevel;
    
    public String getGradeLevel() {
        return gLevel.toString();
    }

    public void setGradeLevel(String input) {
        
        switch (input.toUpperCase()){
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
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    
    
    
}
