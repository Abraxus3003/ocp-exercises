package info.krogulec.localization;

import info.krogulec.Utils;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleClass_en_US extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"tax", new Object()}
        };
    }

    /**
     * Domyślnie jest szukany plik nazwany ResourceBundleClass_en_US.properties
     *
     * @param args
     */
    public static void main(String[] args) {
        Utils.breakingParts("Wyciąganie obiektu - ");
        ResourceBundle bundle = ResourceBundle.getBundle("ResourceBundleClass", Locale.US); //dostanie się do klasy wymaga podania pełnej kwalifikowanej nazwy
        System.out.println(bundle.getObject("tax"));
        System.out.println(bundle.getString("props"));

    }
}
