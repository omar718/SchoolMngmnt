package models;

public class Teacher extends Person{
    double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String getData() {
        return this.getName()+" is "+this.getAge()+" with salary "+this.getSalary();

    }
}
