package info.krogulec.advancedclassdesign;

/**
 * Klasay można zagnieżdżać na wiele poziomów
 */
public class Matrix {
    private int level = 1;

    class Deep{
        private int level = 2;

        class Deeper{
            private int level = 3;

            public void printRrality(){
                System.out.println(level);
                System.out.println(" " + Deep.this.level);
                System.out.println(" " + Deep.this.level);
            }
        }
    }

    /**
     * Trzeba pamiętać, że w przypadku member class musimy mieć obiket klasy nadrzędnej, żeby dostać się do podrzędnej
     *
     * @param args
     */
    public static void main(String[] args) {
        Matrix.Deep.Deeper sim = new Matrix().new Deep().new Deeper();
        sim.printRrality();

        //Drugi sposób, bez odwołania się do Matrix
        Deep.Deeper sim2 = new Matrix().new Deep().new Deeper();
        sim2.printRrality();

    }
}
