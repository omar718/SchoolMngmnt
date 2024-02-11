package models;

import java.util.ArrayList;

public class Grade {
    String code,name;
    Teacher teacher;
    ArrayList<Student> students ;

    public Grade(String code, String name) {
        this.code = code;
        this.name = name;
        this.students=new ArrayList<Student>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }



}
