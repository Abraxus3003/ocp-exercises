package info.krogulec.advancedclassdesign;

public class JavaBean {

}

/**
 * Prawidłowy java bean
 */
class Car{
    private String make;
    private String model;
    private boolean sportCar;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isSportCar() {
        return sportCar;
    }

    public void setSportCar(boolean sportCar) {
        this.sportCar = sportCar;
    }
}
