package info.krogulec.advancedclassdesign;

public class StaticNestedClass {

    private int variable;
    private static int staticVar;

    static class Nested{
        private int val = 199;

        public void accessVar(){
            //dostęp tylko do statycznych pól klasy zewnętrznej
            System.out.println(staticVar);
        }
    }

    class NestedNotStatic{

        public void accessVar(){
            //dostęp do obiketowych pól i statycznych
            System.out.println(variable);
            System.out.println(staticVar);
        }
    }

    public static void main(String[] args) {

        //Wewnętrz wywołujemy klasę jak standardową klasę
        Nested nested = new Nested();
        System.out.println(nested.val);
        StaticNestedClass snc = new StaticNestedClass();
        //Można również wywołać w ten sposób
        StaticNestedClass.Nested sncn = new StaticNestedClass.Nested();
        }
}

class AsserionsPractice{

    public static void main(String[] args) {
        //Wywołanie na zewnątrz wymaga podania klasy zewnetrznej, ale nie ma potrzeby tworzenia obiektu
        StaticNestedClass.Nested nested = new StaticNestedClass.Nested();
    }
}
