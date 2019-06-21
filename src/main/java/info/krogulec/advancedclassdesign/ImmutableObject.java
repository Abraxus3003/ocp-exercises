package info.krogulec.advancedclassdesign;

import java.util.ArrayList;

//TODO Czy ta klasa jest immutable?
public class ImmutableObject {

    private final String name;
    private final ArrayList<String> strings;

    public ImmutableObject(String name, ArrayList<String> strings) {
        this.name = name;
        this.strings = strings;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getStrings() {
        return strings;
    }
}
