package thirdWeek;

public class Employee {
    private float salary;
    private String name;
    private String department;
    private int employeeId;

    /*******************************************
     * 
     * Detailed example for constructor chaining
     * 
     *******************************************/
    public Employee (){
        this("Unknown", -1, "Unassigned", 0);
    }

    public Employee(String name, String department){
        this(name, -1, department, 0);
    }

    public Employee(String name, int employeeId, String department, float salary){
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    /*******************************************
     * 
     * this is the version of get salary checked 
     * when compiling
     * 
     *******************************************/
	float getSalary(){
	    return salary;
	}

    // float getSalary(boolean isCAD){
    //     float resSalary = salary;
    //     if(isCAD)
    //         resSalary = resSalary * 1.35f;
    //     return resSalary;
    // }
}
