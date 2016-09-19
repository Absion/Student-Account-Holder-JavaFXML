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
    ArrayList<Student> studentList = new ArrayList<Student>();
    String firstNameHolder;
    String lastNameHolder;
    String dOfBirthHolder;
    String gradeHolder;
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

    @FXML
    private void handleNewButtonAction(ActionEvent event) {

        if (gradeLevelField.getText().toUpperCase().equals("FRESHMAN") || gradeLevelField.getText().toUpperCase().equals("SOPHMORE") || gradeLevelField.getText().toUpperCase().equals("JUNIOR") || gradeLevelField.getText().toUpperCase().equals("SENIOR")) {
            firstNameHolder = firstNameField.getText();

            lastNameHolder = lastNameField.getText();

            dOfBirthHolder = dateOfBirthField.getText();

            gradeHolder = gradeLevelField.getText();

            student.setFirstName(firstNameHolder);
            student.setLastName(lastNameHolder);
            student.setDateOfBirth(dOfBirthHolder);
            student.setGradeLevel(gradeHolder);

            studentList.add(student);
            numberOfStudents = studentList.size();
            
            firstNameField.clear();
            lastNameField.clear();
            dateOfBirthField.clear();
            gradeLevelField.clear();

            statusField.setText("Student Added Succesfully");
        } else {
            statusField.setText("Invalid Entry Given");
        }

    }

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

    @FXML
    private void handleNextButtonAction(ActionEvent event) {
        
        
        
        if(!isInt(statusField.getText()))
        statusField.clear();
        
        
        if (studentList.isEmpty()) {
            statusField.setText("No Students in Memory");
        } 
        else {
        
        if (statusField.getText().isEmpty()) {
            statusField.setText("1");
            index = Integer.parseInt(statusField.getText()) - 1;
            
           
            firstNameField.setText(studentList.get(index).getFirstName());
            lastNameField.setText(studentList.get(index).getLastName());
            dateOfBirthField.setText(studentList.get(index).getDateOfBirth());
            gradeLevelField.setText(studentList.get(index).getGradeLevel());
            
            firstNameField.clear();
            lastNameField.clear();
            dateOfBirthField.clear();
            gradeLevelField.clear();
        } 
        
        else {
          if (Integer.parseInt(statusField.getText()) < numberOfStudents) {
             index++;
            statusField.setText(Integer.toString(index + 1));
            
            firstNameField.setText(studentList.get(index).getFirstName());
            lastNameField.setText(studentList.get(index).getLastName());
            dateOfBirthField.setText(studentList.get(index).getDateOfBirth());
            gradeLevelField.setText(studentList.get(index).getGradeLevel());
            
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
