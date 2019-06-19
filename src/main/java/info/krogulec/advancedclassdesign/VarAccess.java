package info.krogulec.advancedclassdesign;

public class VarAccess {

    int a = 99;

    public static void main(String[] args) {
        VarAccess.Test test = new VarAccess().new Test();
        test.a = 2;
        test.in();

        int a = 4;

        assert (a < 0) : "msg";

    }

    class Test {
        private int a = 1;

        public void in(){
            //dostęp do swojej klasy
            System.out.println(this.a);

            //dostęp do klasy zewnetrznej
            System.out.println(VarAccess.this.a);
        }
    }
}
