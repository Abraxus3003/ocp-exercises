package info.krogulec.advancedclassdesign;

public class InnerInterfaace {

    // interfejsy inner mogą być prywatne, ale wszytskie metody wewnątrz muszą być publiczne
    private interface SomeContract{
        void contractOne();
    }

    private class InnerClass implements SomeContract{

        //metoda musi być publiczna zawsze przy implementacji interfejsu, niezależnie, czy jest prywatnys
        @Override
        public void contractOne() {

        }
    }
}
