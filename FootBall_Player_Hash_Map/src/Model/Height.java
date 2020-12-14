package Model;

public class Height {

    private int feet;
    private int inches;

    @Override
    public String toString() {
        return  feet + "'" + inches + '"' ;
    }

    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }
    public Height() {
        this.feet = 0;
        this.inches = 0;
    }
    public int fixedHeight(int feet, int inches)
    {
        int totalHeight = (feet * 12) + inches;
        return totalHeight;
    }

    public int fixedHeight()
    {
        int totalHeight = (feet * 12) + inches;
        return totalHeight;
    }

    public int getFeet() {
        return feet;
    }

    public void setFeet(int feet) {
        this.feet = feet;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

}
