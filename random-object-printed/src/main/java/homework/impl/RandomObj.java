package homework.impl;

public class RandomObj {
    private String name;
    private double fraction;
    private int[] arrInts;
    private RandomObj[] randomObj;

    public RandomObj() {
    }

    public RandomObj(String name, double fraction, int[] arrInts, RandomObj[] randomObj) {
        this.name = name;
        this.fraction = fraction;
        this.arrInts = arrInts;
        this.randomObj = randomObj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFraction() {
        return fraction;
    }

    public void setFraction(double fraction) {
        this.fraction = fraction;
    }

    public int[] getArrInts() {
        return arrInts;
    }

    public void setArrInts(int[] arrInts) {
        this.arrInts = arrInts;
    }

    public RandomObj[] getRandomObj() {
        return randomObj;
    }

    public void setRandomObj(RandomObj[] randomObj) {
        this.randomObj = randomObj;
    }
}
