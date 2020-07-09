package test.day9_testBase_Properties_DriverUtil;

public class Singleton {

    private Singleton(){ // constructor

    }

    private static String word;

    public static String getWord(){ // getter method
        if (word == null){
            System.out.println("First call. Word object is null" + " Assigning value to word right now");
            word = "something";
        }else {
            System.out.println("Word already has value");
        }
        return word;
    }




}
