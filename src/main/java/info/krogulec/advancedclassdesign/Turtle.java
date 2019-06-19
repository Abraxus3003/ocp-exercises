package info.krogulec.advancedclassdesign;

/**
 * Wykorzystanie annonymous inner class vs Lambda
 */
public class Turtle {
    public static void main(String[] args) {
        int distance = 7;

        CanSwimm cs = new CanSwimm() {
            @Override
            public void swim() {
                System.out.println(distance);
            }
        };

        //Alternatywa dla powyższego kodu
        CanSwimm cs2 = () -> System.out.println(distance);

        cs.swim();
        cs2.swim();
    }
}

interface CanSwimm{
    public void swim();
}
