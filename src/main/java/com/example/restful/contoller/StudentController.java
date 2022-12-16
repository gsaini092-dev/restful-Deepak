package com.example.restful.contoller;

import com.example.restful.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Value("${application.message}")
    String message;

    // 1. Create Student Details
    // URL: http://localhost:8080/student
    @PostMapping("")
    public String createStudent(@RequestBody Student student){
        return "Created a student data successfully.";
    }

    // 2. Get all Student details
    //URL: http://localhost:8080/student/list
    @GetMapping("/list")
    public List<Student> getStudentList(){
        System.out.println("Get all the students");
        Student student1 = new Student();
        student1.setStudentId(1);
        student1.setName("Deepak");
        student1.setRollNo("10010020");

        Student student2 = new Student();
        student2.setStudentId(2);
        student2.setName("Gaurav");
        student2.setRollNo("10010044");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        System.out.println(message);
        return studentList;
    }

    // 3. Get student details by Id
    // URL: http://localhost:8080/student/1
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id){
        System.out.println("Fetching student details by id: "+ id);
        Student student1 = new Student();
        student1.setStudentId(1);
        student1.setName("Deepak");
        student1.setRollNo("10010020");
        return student1;
    }

    // 4. Delete student
    // URL: http://localhost:8080/student/1
    @DeleteMapping("")
    public String deleteStudentById(@RequestParam String id){
        return String.format("Student has be deleted having is %d", id);
    }

    // 5. Update Student Data
    // URL: http://localhost:8080/student
    @PutMapping("")
    public String updateStudentDetails(@RequestBody Student student){
       return "Student details has been updated.";
    }
}
