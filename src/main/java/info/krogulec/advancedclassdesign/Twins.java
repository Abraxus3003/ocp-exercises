package info.krogulec.advancedclassdesign;

//TODO Co by było, gdyby klasa nie implementowała metody write?
public class Twins implements Alex, Michael {

    @Override
    public void write() {

    }

    @Override
    public void think() {

    }
}

interface Alex{
    default void write(){};
    static void publish(){};
    void think();
}

interface Michael{
    public default void write(){};
    public static void publish(){};
    public void think();
}
