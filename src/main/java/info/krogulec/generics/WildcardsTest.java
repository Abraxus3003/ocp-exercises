package info.krogulec.generics;

public class WildcardsTest  {
    public static void main(String[] args) {
        getWild(new SuperWild<WildClass>());
        getWildWithExtends(new SuperWild<SecondCalss>());
    }

    //? reprezentuje typ, który jest "super" da klasy FirstClass
    public static void getWild(SuperWild<? super FirstClass> superWild){
        System.out.println(superWild);
    }

    //? reprezentuje tym, który jest rozszerza FirstClass
    public static void getWildWithExtends(SuperWild<? extends FirstClass> superWild){
        System.out.println(superWild);
    }
}

class WildClass{}

class FirstClass extends WildClass{}

class SecondCalss extends FirstClass{}

class SuperWild <T>{}
