package models;

import java.util.ArrayList;

public class School {
    String name,address,Phone_num;
    ArrayList<Teacher> teachers;
    ArrayList<Student> students;
    ArrayList<Grade> grades;

    public School(String name, String address, String phone_num) {
        this.name = name;
        this.address = address;
        Phone_num = phone_num;
        this.teachers = new ArrayList<Teacher>();
        this.students = new ArrayList<Student>();
        this.grades = new ArrayList<Grade>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_num() {
        return Phone_num;
    }

    public void setPhone_num(String phone_num) {
        Phone_num = phone_num;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }



    public ArrayList<Student> getStudents() {
        return students;
    }



    public ArrayList<Grade> getGrades() {
        return grades;
    }
    public Grade getGrade(String name) {
        for (Grade grade : grades) {
            if ((grade.name).equals(name)) {
                return grade;
            }
        }
        return null;
    }


}
