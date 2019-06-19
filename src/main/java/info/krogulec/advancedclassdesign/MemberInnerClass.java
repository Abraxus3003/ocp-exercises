package info.krogulec.advancedclassdesign;

public class MemberInnerClass {

    private String outerClassVariable = "outerClassVariable";
    private static String outerClassStaticVariable = "outerClassStaticVariable";
    private String outerInnerClassSharedNameVar = "outerInnerClassSharedNameVarInOuter";

    // Wywołanie z wewnetrz
    public static void main(String[] args) {
        Inner inner = new MemberInnerClass().new Inner();
        inner.go();
    }

    /**
     * Nie można umieszczać staticów
     */
    class Inner{

        private String outerInnerClassSharedNameVar = "outerInnerClassSharedNameVarInInner";

        // Sposób dostania się do zmiennych klasy zewnętrznej
        public void go(){
            System.out.printf(outerClassVariable + " " + outerClassStaticVariable + " " + outerInnerClassSharedNameVar);
            System.out.printf(outerClassVariable + " " + MemberInnerClass.outerClassStaticVariable + " " + outerInnerClassSharedNameVar);
        }
    }

}

class ClientClass{

    //Wywołanie z zewnątrz
    public static void main(String[] args) {
        MemberInnerClass.Inner inner = new MemberInnerClass().new Inner();
        inner.go();
    }


}
