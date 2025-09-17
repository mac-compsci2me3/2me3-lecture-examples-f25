package thirdWeek;

public class SubSubClass extends SubClass {

    /*******************************************
     * 
     * Workaround to access its parent's parent
     * 
     *******************************************/
    public int increaseMyClassValue(){
        int v = super.increaseMyClassValue();
        return v;
        }
}
