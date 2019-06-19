package info.krogulec.advancedclassdesign;

public class LocalInnerClass {

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        System.out.println(localInnerClass.go());
    }

    public int go(){

        int someLocalVar = 4;

        // po dodaniu tej linii brak kompilacji - zmienna nie byłaby effectively finals
        //someLocalVar += 3;

        class LocalInner{
            private int value = 3;

            // można wykorzystać zmienne klasowe, ale nie można zmiennych lokalnych, chyba że są final lub effectively finals
            public void someCalc(){
                value += 5;
                System.out.println("Result of someCalc: " + someLocalVar);
            }


        }

        LocalInner localInner = new LocalInner();

        return localInner.value;
    }
}
