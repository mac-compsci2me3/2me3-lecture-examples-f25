package thirdWeek;

public class SubClass extends MyClass {
    
    public int increaseValue(){
        System.out.println("in MySub's increaseValue - triple");
        value = value * 3;
        return value;
        }

    /*******************************************
     * 
     * Alternative way for its child class to use its parent's method
     * 
     *******************************************/    
    public int increaseMyClassValue(){
        int v = super.increaseValue();
        return v;
    }
    
}
