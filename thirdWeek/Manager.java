package thirdWeek;


public class Manager extends Employee {
    private float bonus; 

    /*******************************************
     * 
     * Another example for constructor chaining
     * 
     *******************************************/    
    public Manager(String name, int employeeId, String department, float salary, float bonus){
        super(name, employeeId, department, salary);
        this.bonus = bonus;
    }

    public Manager(String name, int employeeId, String department, float salary){
        this(name, employeeId, department, salary, 1000);
    }

    public Manager(){
        this("Unknown", -1, "Unassigned", 0, 1000);
    }

    /*******************************************
     * 
     * This is the version will be used because 
     * of the object stored at reference is a manger
     * object
     * 
     *******************************************/    
    float getSalary(){
        return super.getSalary() + bonus;
    }
    
    float getSalary(boolean isCAD){
        float resSalary = super.getSalary() + bonus;
        if(isCAD)
            resSalary = resSalary * 1.35f;
        return resSalary;
    }
}