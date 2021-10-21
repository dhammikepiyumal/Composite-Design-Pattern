// A Java program to demonstrate working of
// Composite Design Pattern with example
// of a company with different
// employee details

import java.util.ArrayList;
import java.util.List;


// A common interface for all employee
interface Employee
{
    public void showEmployeeDetails();
}

class Developer implements Employee
{
    private String name;
    private long empId;
    private String position;

    public Developer(long empId, String name, String position)
    {
        // Assign the Employee id,
        // name and the position
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails()
    {
        System.out.println(empId+" " +name+ " " + position );
    }
}

class Manager implements Employee
{
    private String name;
    private long empId;
    private String position;

    public Manager(long empId, String name, String position)
    {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails()
    {
        System.out.println(empId+" " +name+ " " + position );
    }
}


// Class used to get Employee List
// and do the operations like
// add or remove Employee

class CompanyDirectory implements Employee
{
    private List<Employee> employeeList = new ArrayList<Employee>();

    @Override
    public void showEmployeeDetails()
    {
        for(Employee emp:employeeList)
        {
            emp.showEmployeeDetails();
        }
    }

    public void addEmployee(Employee emp)
    {
        employeeList.add(emp);
    }

    public void removeEmployee(Employee emp)
    {
        employeeList.remove(emp);
    }
}

// Driver class
public class Company
{
    public static void main (String[] args)
    {
        Developer dev1 = new Developer(100, "Mahesh Bandara", "Pro Developer");
        Developer dev2 = new Developer(101, "Prasanna Kumara", "Developer");
        CompanyDirectory engDirectory = new CompanyDirectory();
        engDirectory.addEmployee(dev1);
        engDirectory.addEmployee(dev2);

        Manager man1 = new Manager(200, "Ranjith Perera", "SEO Manager");
        Manager man2 = new Manager(201, "Aravinda Ganegama", "Product Manager");

        CompanyDirectory accDirectory = new CompanyDirectory();
        accDirectory.addEmployee(man1);
        accDirectory.addEmployee(man2);

        CompanyDirectory directory = new CompanyDirectory();
        directory.addEmployee(engDirectory);
        directory.addEmployee(accDirectory);
        directory.showEmployeeDetails();
    }
}

