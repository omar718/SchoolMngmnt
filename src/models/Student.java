package models;

public class Student extends Person{
    String parentPhNum;

    public Student(String name, int age, String parentPhNum) {
        super(name, age);
        this.parentPhNum = parentPhNum;
    }

    public void setParentPhNum(String parentPhNum) {
        this.parentPhNum = parentPhNum;
    }

    public String getParentPhNum() {
        return parentPhNum;
    }

    @Override
    public String getData() {
        return this.getName()+" is "+this.getAge()+" with phone "+this.getParentPhNum();
    }
}
