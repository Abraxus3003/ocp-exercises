package info.krogulec.assertion;

import java.util.Properties;

public class Assertions {

    public static void main(String[] args) {

    }

    //Wykorzystanie statycznego bloku inicjalizacyjnego
    //TODO Dlaczego nic się nie wyświetla?
    static {
        int a = 4;
        int b = 5;
        int d = 6;

        assert a > 0 : "a nie jest większe od zera";
        assert (a < b); //nie musi być komunikatu
        assert (d < a) : d + " nie jest mniejsze od " + a;

    }
}
