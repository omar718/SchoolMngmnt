package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Hmi {
    private static Scanner reader = new Scanner(System.in);
    private static SchoolServices schoolServices;

    public static void display(){
        School school=Hmi.createSchool();
        System.out.println("This is "+school.getName()+" located in "+school.getAddress()
        +" to contact "+school.getPhone_num());
        String action=null;
        do{
            System.out.println("what do you want to do ?");
            action=reader.next();
            switch (action){
                case "addStudent":
                    Hmi.addStudent();
                    break;
                case "printStudents":
                    Hmi.printAllStudents();
                    break;
                case "addTeacher":
                    Hmi.addTeacher();
                    break;
                case "printTeachers":
                    Hmi.printAllTeachers();
                    break;
                case "addGrade":
                    Hmi.addGrade();
                    break;
                case "printGrades":
                    Hmi.printAllGrades();
                    break;
                case "deleteStudent":
                    Hmi.deleteStudent();
                    break;
                case "deleteTeacher":
                    Hmi.deleteTeacher();
                    break;
                case "deleteGrade":
                    Hmi.deleteGrade();
                    break;
                case "searchStudent":
                    Hmi.searchStudent();
                    break;
                case "searchTeacher":
                    Hmi.searchTeacher();
                    break;
            }


        }
        while(!action.equals("exit"));
    }
    private static School createSchool(){
        School school = new School("All Star School","Chebba","97070033");
        Hmi.schoolServices= new SchoolServices(school);
        return school;
    }
    private static void addStudent(){
        System.out.println("enter the name:");
        String name = reader.next();
        System.out.println("enter age:");
        int age= reader.nextInt();
        System.out.println("enter parent phone number:" );
        String parentPhNumb= reader.next();
        Student student = new Student(name,age,parentPhNumb);
        Hmi.schoolServices.addStudent(student);
    }
    private static void printAllStudents(){
        for (Student student : Hmi.schoolServices.getSchool().getStudents()){
            System.out.println(student.getData());
        }
    }
    private static void addTeacher(){
        System.out.println("enter the name:");
        String name = reader.next();
        System.out.println("enter age:");
        int age= reader.nextInt();
        System.out.println("enter salary:" );
        double salary= reader.nextDouble();
        Teacher teacher = new Teacher(name,age,salary);
        Hmi.schoolServices.addTeacher(teacher);
    }

    private static void printAllTeachers(){
        for (Teacher teacher : Hmi.schoolServices.getSchool().getTeachers()){
            System.out.println(teacher.getData());
        }
    }
    private static void addGrade(){
        System.out.println("enter grade name: ");
        String name=reader.next();
        System.out.println("enter code: ");
        String code = reader.next();
        Grade grade= new Grade(code,name);
        System.out.println("enter teacher name: ");
        String teacherName = reader.next();
        Teacher teacher =Hmi.schoolServices.searchTeacher(teacherName);
        Hmi.schoolServices.addGrade(grade);

        if (teacher!=null)
        {
            grade.teacher=teacher;
        }
        else{
            System.out.println("teacher not found in school");
        }
        System.out.println(Hmi.schoolServices.gradeTest(name));



        String action=null;
        do {
            System.out.println("add student yes or no:");
            action = reader.next();
            if (action.equals("yes")){


                System.out.println("enter student name:");
                String studentName= reader.next();
                Student student =Hmi.schoolServices.searchStudent(studentName);
                if (student!=null)
                {
                    Hmi.schoolServices.addStudentG(student,name);
                }
                else{
                    System.out.println("student not found in school");
                }

            }
        }
        while (action.equals("yes"));
    }
    private static void printAllGrades(){
        for (Grade grade : Hmi.schoolServices.getSchool().getGrades()){
            System.out.println(grade.getName()+" with the code "+grade.getCode());
        }
    }
    private static void deleteStudent(){
        System.out.println("enter student name you want to delete: ");
        String studentName= reader.next();
        System.out.println("enter grade name of the student: ");
        String gradeName = reader.next();
        Student student = Hmi.schoolServices.searchStudent(studentName);
        if (student!=null)
        {
            Hmi.schoolServices.deleteStudent(student);

            Hmi.schoolServices.deleteStudentG(student,gradeName);

        }
        else{
            System.out.println("student not found in school");
        }

    }
    private static void deleteTeacher(){
        System.out.println("enter teacher name you want to delete: ");
        String teacherName= reader.next();
        Teacher teacher =Hmi.schoolServices.searchTeacher(teacherName);
        if (teacher!=null)
        {
            Hmi.schoolServices.deleteTeacher(teacher);
        }
        else{
            System.out.println("teacher not found in school");
        }
    }
    private static void deleteGrade(){
        System.out.println("enter grade name you want to delete: ");
        String gradeName= reader.next();
        Grade grade =Hmi.schoolServices.searchGrade(gradeName);
        if (grade!=null)
        {
            Hmi.schoolServices.deleteGrade(grade);
        }
        else{
            System.out.println("grade not found in school");
        }
    }
    private static void searchStudent(){
        System.out.println("enter student name: ");
        String studentName= reader.next();
        Student student =Hmi.schoolServices.searchStudent(studentName);
        if (student!=null)
        {
            System.out.println("student exists");
        }
        else{
            System.out.println("student not found in school"); ;
        }
    }
    private static String searchTeacher(){
        System.out.println("enter teacher name: ");
        String teacherName= reader.next();
        Teacher teacher =Hmi.schoolServices.searchTeacher(teacherName);
        if (teacher!=null)
        {
            return "teacher exists";
        }
        else{
            return "teacher not found in school";
        }
    }


}
