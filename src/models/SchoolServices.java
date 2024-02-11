package models;

public class SchoolServices {
    School school;
    public SchoolServices(School school) {
        this.school = school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public School getSchool() {
        return school;
    }
    public void addStudent(Student student){
        school.getStudents().add(student);
    }
    public void addTeacher(Teacher teacher){
        school.getTeachers().add(teacher);
    }
    public void addGrade (Grade grade){school.getGrades().add(grade);}
    public void deleteTeacher(Teacher teacher){
        school.getTeachers().remove(teacher);
    }
    public void deleteStudent (Student student ){
        school.getStudents().remove(student);
    }

    public void deleteGrade (Grade grade){
        school.getGrades().remove(grade);
    }
    public Student searchStudent(String name){
        for (Student student :school.getStudents()){
            if (name.toUpperCase().equals(student.getName().toUpperCase())){
                return student;
            }
        }
        return null;
    }
    /*public Grade searchStudentG(String name) {
        for (Student student : school.getStudents()) {
            if (name.equals(student.getName())) {
                return student;
            }
        }
        return null;
    }
    */
    public Teacher searchTeacher(String name){
        for(Teacher teacher : school.getTeachers()){
            if (name.toUpperCase().equals(teacher.getName().toUpperCase())){
                return teacher;
            }
        }
        return null;
    }
    public Grade searchGrade(String code){
        for (Grade grade: school.getGrades()){
            if (code.equals(grade.getCode())){
                return grade;
            }
        }
        return null;
    }
    public Grade gradeTest(String name){
        return school.getGrade(name);
    }
    public void addStudentG(Student student,String name){
        school.getGrade(name).getStudents().add(student);
    }
    public void deleteStudentG(Student student, String name){
        school.getGrade(name).getStudents().remove(student);
    }
}


