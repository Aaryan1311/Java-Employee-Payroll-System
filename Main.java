import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee aniket = new FullTimeEmployee("aniket", 1001, 100000);
        FullTimeEmployee pranjal = new FullTimeEmployee("pranjal", 1002, 100001);
        PartTimeEmployee naman = new PartTimeEmployee("naman",2001, 8000, 280);
        payrollSystem.addEmployee(naman);
        payrollSystem.addEmployee(aniket);
        payrollSystem.addEmployee(pranjal);
        payrollSystem.removeEmployee(2001);

        payrollSystem.displayEmployeeList();

    }
}


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
        System.out.println(employee.getName() + " of id " + employee.getId() + " has been added");
    }

    // removing employee from list
    public void removeEmployee(int id){
         Employee employeetoRemove = null;
         for(Employee employee : employeeList){
            if(employee.getId() == id){
                employeetoRemove = employee;
                break;
            }
         }
        if(employeetoRemove != null){
            employeeList.remove(employeetoRemove);
            System.out.println("Employee has been kicked out of the company");
            return;  
        }
        else{
            System.out.println("No Employee with this id.");
            return;
        }
    }

//print list of employees
    public void displayEmployeeList(){
        for(Employee employee : employeeList){
            System.out.println("[name = " + employee.getId() + ", id =  " + employee.getName() + ", salary = " + employee.calculateSalary() + "]");
        }
    }
} 