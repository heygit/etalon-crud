package project.model;

public class Currency {

    private String integer;
    private String fractional;

    public Currency(String integer, String fractional) {
        this.integer = integer;
        this.fractional = fractional;
    }

    public String getInteger() {
        return integer;
    }

    public void setInteger(String integer) {
        this.integer = integer;
    }

    public String getFractional() {
        return fractional;
    }

    public void setFractional(String fractional) {
        this.fractional = fractional;
    }
}
