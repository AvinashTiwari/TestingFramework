package learn.reflection.annotation;



@MostUsed
public class Utility {
    void doStuff(){
        System.out.println("Doing something ");
    }

    @MostUsed("Python")
    void doStuff(String arg){
        System.out.println("Doing something operating " + arg);
    }

    void doStuff(int arg){
        System.out.println("Doing something operating " + arg);
    }
}

class subUtility extends Utility {

}
