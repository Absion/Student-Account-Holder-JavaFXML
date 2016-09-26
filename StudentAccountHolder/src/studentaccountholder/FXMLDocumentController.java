package studentaccountholder;

import java.io.*;
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

    
    LinkedList<Student> studentList = new LinkedList<Student>();
    String firstNameHolder;
    String lastNameHolder;
    String dOfBirthHolder;
    String gradeHolder;
    int index;
    int numberOfStudents;

    @FXML
    private TextField firstNameField = new TextField();
    @FXML
    private TextField lastNameField = new TextField();
    @FXML
    private TextField dateOfBirthField = new TextField();
    @FXML
    private TextField gradeLevelField = new TextField();
    @FXML
    private Button newStudentButton;
    @FXML
    private Button loadNextStudentButton;
    @FXML
    private Button loadPreviousStudentButton;
    @FXML
    private Button deleteStudentButton;
    @FXML
    private TextField statusField = new TextField();
    @FXML
    private Button writeButton;
    @FXML
    private Button loadButton;

    @FXML
    private void handleNewButtonAction(ActionEvent event) {

        Student student = new Student();
        
        if (gradeLevelField.getText().toUpperCase().equals("FRESHMAN") || gradeLevelField.getText().toUpperCase().equals("SOPHMORE") || gradeLevelField.getText().toUpperCase().equals("JUNIOR") || gradeLevelField.getText().toUpperCase().equals("SENIOR")) {
            firstNameHolder = this.firstNameField.getText();

            lastNameHolder = this.lastNameField.getText();

            dOfBirthHolder = this.dateOfBirthField.getText();

            gradeHolder = this.gradeLevelField.getText();

            student.setFirstName(firstNameHolder);
            student.setLastName(lastNameHolder);
            student.setDateOfBirth(dOfBirthHolder);
            student.setGradeLevel(gradeHolder);

            studentList.add(student);
            numberOfStudents = studentList.size();
            
            
            
            this.firstNameField.clear();
            this.lastNameField.clear();
            this.dateOfBirthField.clear();
            this.gradeLevelField.clear();

            this.statusField.setText("Student Added Succesfully");
        } else {
            this.statusField.setText("Invalid Entry Given");
        }

    }

    @FXML
    private void handleDeleteButtonAction(ActionEvent event) {
        if(isInt(statusField.getText())){
            studentList.remove(Integer.parseInt(statusField.getText()) - 1);
            this.statusField.setText("Student Deleted");
            this.firstNameField.clear();
            this.lastNameField.clear();
            this.dateOfBirthField.clear();
            this.gradeLevelField.clear();
        }
        else
            this.statusField.setText("No student loaded");

    }

    @FXML
    private void handleNextButtonAction(ActionEvent event) {
        
        
        
        if(!isInt(this.statusField.getText()))
        this.statusField.clear();
        
        
        if (studentList.isEmpty()) {
            this.statusField.setText("No Students in Memory");
        } 
        else {
        
        if (this.statusField.getText().isEmpty()) {
            this.statusField.setText("1");
            index = Integer.parseInt(this.statusField.getText()) - 1;
            
           
            this.firstNameField.setText(studentList.get(index).getFirstName());
            this.lastNameField.setText(studentList.get(index).getLastName());
            this.dateOfBirthField.setText(studentList.get(index).getDateOfBirth());
            this.gradeLevelField.setText(studentList.get(index).getGradeLevel());
            
            this.firstNameField.clear();
            this.lastNameField.clear();
            this.dateOfBirthField.clear();
            this.gradeLevelField.clear();
        } 
        
        else {
          if (Integer.parseInt(this.statusField.getText()) < numberOfStudents) {
             index++;
            this.statusField.setText(Integer.toString(index + 1));
            
            this.firstNameField.setText(studentList.get(index).getFirstName());
            this.lastNameField.setText(studentList.get(index).getLastName());
            this.dateOfBirthField.setText(studentList.get(index).getDateOfBirth());
            this.gradeLevelField.setText(studentList.get(index).getGradeLevel());
            
        }
          else
       
            this.statusField.setText("Last student reached");
        }
        }

    }

    @FXML
    private void handlePreviousButtonAction(ActionEvent event) {
        
        if(!isInt(this.statusField.getText()))
        this.statusField.setText("No Students Viewed Yet");
        else{
            if (Integer.parseInt(this.statusField.getText()) > 1) {
            
            index = Integer.parseInt(this.statusField.getText()) - 2;
            this.statusField.setText(Integer.toString(Integer.parseInt(this.statusField.getText()) - 1));
           
            this.firstNameField.setText(studentList.get(index).getFirstName());
            this.lastNameField.setText(studentList.get(index).getLastName());
            this.dateOfBirthField.setText(studentList.get(index).getDateOfBirth());
            this.gradeLevelField.setText(studentList.get(index).getGradeLevel());
            
            
        }
            else
                this.statusField.setText("First Student Reached");
        }

    }
    
    @FXML
    private void handleWriteButtonAction(ActionEvent event){
   
        Student studentHolder=null;
        //WILL ONLY WRITE TO FILE IF THERE ARE STUDENTS LOADED IN MEMORY
        if(!studentList.isEmpty()){
        
        try{
String savePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "StudentList.ser";
FileOutputStream fileOut = new FileOutputStream(savePath);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(studentList);        
         out.close();
         fileOut.close();
         this.statusField.setText("Serialized data is saved in " + savePath);
        
         }
         catch(IOException e) {
         e.printStackTrace();
      }
        
        System.out.println(studentList.toString());
        }
        
        else
            this.statusField.setText("StudentList is empty");
    }
            
    @FXML
    private void handleLoadButtonAction(ActionEvent event){
        LinkedList<Student> studentListHolder=null;
        try {
        String savePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "StudentList.ser";
         FileInputStream fileIn = new FileInputStream(savePath);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         studentListHolder = (LinkedList<Student>)in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c) {
         System.out.println("StudentList not found");
         c.printStackTrace();
         return;
      }
        System.out.println(studentListHolder.toString());
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
