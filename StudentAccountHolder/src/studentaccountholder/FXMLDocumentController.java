package studentaccountholder;

import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.lang.Integer;
import java.lang.Object;

/**
 *
 * @author Absion
 */
public class FXMLDocumentController implements Initializable {

    Student student = new Student();
    List<Student> studentList = new ArrayList<Student>();
    int index;
    int numberOfStudents;

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField dateOfBirthField;
    @FXML
    private TextField gradeLevelField;
    @FXML
    private Button newStudentButton;
    @FXML
    private Button loadNextStudentButton;
    @FXML
    private Button loadPreviousStudentButton;
    @FXML
    private Button deleteStudentButton;
    @FXML
    private TextField statusField;

    //THIS BUTTON SHOULD CREATE A STUDENT FROM DATA ENTERED BY USER AND ADD TO STUDENT ARRAY
    @FXML
    private void handleNewButtonAction(ActionEvent event) {
//CHECKS TO SEE IF VALID ENTRY HAS BEEN GIVEN FOR GRADE LEVEL
        if (gradeLevelField.getText().toUpperCase().equals("FRESHMAN") 
                || gradeLevelField.getText().toUpperCase().equals("SOPHMORE") 
                || gradeLevelField.getText().toUpperCase().equals("JUNIOR") 
                || gradeLevelField.getText().toUpperCase().equals("SENIOR")) {

            //MODIFES STUDENT OBJECT WITH DATA FROM TEXT FIELDS
            student.setFirstName(firstNameField.getText());
            student.setLastName(lastNameField.getText());
            student.setDateOfBirth(dateOfBirthField.getText());
            student.setGradeLevel(gradeLevelField.getText());

            //ADDS STUDENT OBJECT TO ARRAY
            studentList.add(student);
            numberOfStudents = studentList.size();
            
            System.out.println(student.toString());
            
            firstNameField.clear();
            lastNameField.clear();
            dateOfBirthField.clear();
            gradeLevelField.clear();

            statusField.setText("Student Added Succesfully");
        } else {
            statusField.setText("Invalid Entry Given");
        }

    }
//THIS BUTTON SHOULD DELETE STUDENT AT CURRENT INDEX GIVEN BY STATUSFIELD BOX
    @FXML
    private void handleDeleteButtonAction(ActionEvent event) {
        if(isInt(statusField.getText())){
            studentList.remove(Integer.parseInt(statusField.getText()) - 1);
            statusField.setText("Student Deleted");
            firstNameField.clear();
            lastNameField.clear();
            dateOfBirthField.clear();
            gradeLevelField.clear();
        }
        else
            statusField.setText("No student loaded");

    }
//THIS BUTTON SHOULD LOAD STUDENTS FROM ARRAY AND DISPLAY IN THE TEXT BOXES
    @FXML
    private void handleNextButtonAction(ActionEvent event) {
        
        
        //SHOULD ONLY RUN IF THE STATUS FIELD DOES NOT CONTAIN A NUMBER
        if(!isInt(statusField.getText()))
        statusField.clear();
        
        //CHECKS FOR PRESSES BEOFRE ANY STUDENTS ARE GIVEN
        if (studentList.isEmpty()){
            statusField.setText("No Students in Memory");
        } 
        else {
        //THIS SHOULD RUN ONLY FOR THE FIRST TIME THE BUTTON IS PRESSED AFTER STUDENTS ARE CREATED
        if (statusField.getText().isEmpty()) {
            statusField.setText("1");
            index = Integer.parseInt(statusField.getText()) - 1;
            
           
            firstNameField.setText(studentList.get(index).getFirstName());
            lastNameField.setText(studentList.get(index).getLastName());
            dateOfBirthField.setText(studentList.get(index).getDateOfBirth());
            gradeLevelField.setText(studentList.get(index).getGradeLevel());
            
            System.out.println(studentList.get(index).toString());
            
        } 
        //SHOULD LOAD EVERY FOLLOWING STUDENT
        else {
          if (Integer.parseInt(statusField.getText()) < numberOfStudents) {
             index = index + 1;
            statusField.setText(Integer.toString(index + 1));
            
            firstNameField.setText(studentList.get(index).getFirstName());
            lastNameField.setText(studentList.get(index).getLastName());
            dateOfBirthField.setText(studentList.get(index).getDateOfBirth());
            gradeLevelField.setText(studentList.get(index).getGradeLevel());
            
            System.out.println(studentList.get(index).toString());
            
        }
          else
       
            statusField.setText("Last student reached");
        }
        }

    }

    @FXML
    private void handlePreviousButtonAction(ActionEvent event) {
        
        if(!isInt(statusField.getText()))
        statusField.setText("No Students Viewed Yet");
        else{
            if (Integer.parseInt(statusField.getText()) > 1) {
            
            index = Integer.parseInt(statusField.getText()) - 2;
            statusField.setText(Integer.toString(Integer.parseInt(statusField.getText()) - 1));
           
            firstNameField.setText(studentList.get(index).getFirstName());
            lastNameField.setText(studentList.get(index).getLastName());
            dateOfBirthField.setText(studentList.get(index).getDateOfBirth());
            gradeLevelField.setText(studentList.get(index).getGradeLevel());
            
            
        }
            else
                statusField.setText("First Student Reached");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    static boolean isInt(String s)
{
 try
  { int i = Integer.parseInt(s); 
  return true; 
  }

 catch(NumberFormatException er){ 
     return false; 
  }
}

}
