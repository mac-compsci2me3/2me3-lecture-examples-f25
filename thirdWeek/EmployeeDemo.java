package thirdWeek;

public class EmployeeDemo {
    public static void main(String[] args) {

        /*******************************************
         * 
         * Implicit type casting from manager to employee
         * 
         *******************************************/        
        Employee e = new Manager("Joe", 10023, "Development", 1000);
    
        /*******************************************
         * 
         * Java check employee getSalary when compiling (since the type is employee)
         * But the object stored at the reference is a manager object, it will use its method at runtime
         * 
         *******************************************/
        float s = e.getSalary(); 

        //float s = e.getSalary(true); 
        System.out.println(s);

    
    }
}