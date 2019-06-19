package info.krogulec.advancedclassdesign;

public class InnerClasses {

    //można zadeklarować statyczny interfejs - wewnętrz klasy jest domyślnie statyczny
    static interface Vehicle {}
    static class Bus implements Vehicle{}

    enum DaysOff{
        A, B, C
    }

    public static void main(String... args){

        //Sprawdzenie jakiego typu instancją jest obiket
        Bus bus = new Bus();

        boolean n = null instanceof Bus;
        boolean v = bus instanceof Vehicle;
        boolean b = bus instanceof Bus;

        System.out.println(n + " " + v + " " + b);


        //switch po enumie
        final DaysOff input = DaysOff.B;
        switch (input){
            default:
            case A:
                System.out.println("1");
            case B:
                System.out.println("2");
        }
    }
}
