import java.util.ArrayList;

abstract class Employee{

    // access modifer
    private String name;
    private int id;


    // Constructor
    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    //  Encapsulation, get methods to get name
    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }
 

    // Abstraction, method not implemented here
    public abstract double calculateSalary();
    
    // Polymorphism, Override toString from Object class 
    @Override
    public String toString(){
        return "Employee [name = " + this.name + ", id = " + this.id + ", salary = " + calculateSalary() + "]";
    }
}


class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id); // constructor to get name and id from parent class
        this.monthlySalary = monthlySalary;  
    }

    // implementing abstract method of parent
    @Override
    public  double calculateSalary(){
        return monthlySalary;
    }
}



class PartTimeEmployee extends Employee{

    private double hourlySalary;
    private int hourWorks;

    public PartTimeEmployee(String name, int id, double hourlySalary, int hourWorks){
        super(name, id); // constructor to get name and id from parent class
        this.hourlySalary = hourlySalary;
        this.hourWorks = hourWorks;
    }

    // implementing abstract method of parent
    @Override
    public  double calculateSalary(){
        double totalSalary = this.hourlySalary* this.hourWorks;
        return totalSalary;
    }
}

// make payroll system
class PayrollSystem{

    // list of employees
    private ArrayList<Employee> employeeList;

    //constructor
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    // adding employee in list
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
         
    }

}



public class Main{
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}