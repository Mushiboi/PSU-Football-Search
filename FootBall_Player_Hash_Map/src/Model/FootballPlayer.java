package Model;

import java.util.ArrayList;

public class FootballPlayer extends Person implements TableMember{
    private int number;
    private String position;


    @Override
    public String toString() {
        return super.toString() + " FootballPlayer{" + "number=" + getNumber() + ", position=" + getPosition() + '}';
    }
    public FootballPlayer(String name, Height height, int weight, String hometown, String highSchool, int number, String position) {
        super(name, height, weight, hometown, highSchool);
        this.setNumber(number);
        this.setPosition(position);
        this.setHeight(height);
        this.setName(name);
        this.setHighSchool(highSchool);
        this.setHometown(hometown);
        this.setWeight(weight);
    }

    public FootballPlayer() {
        super();
        this.setNumber(0);
        this.setPosition("N/A");
    }


    @Override
    public String getAttribute(int f) {
        ArrayList<String> attributeStringList = new ArrayList<>();
        attributeStringList.add(Integer.toString(number));
        attributeStringList.add(position);
        attributeStringList.add(name);
        attributeStringList.add(height.toString());
        attributeStringList.add(Integer.toString(weight));
        attributeStringList.add(hometown);
        attributeStringList.add(highSchool);
        return attributeStringList.get(f);
    }

    @Override
    public ArrayList<String> getAttributes() {
        ArrayList<String> attributeStringList = new ArrayList<>();
        attributeStringList.add(Integer.toString(number));
        attributeStringList.add(position);
        attributeStringList.add(name);
        attributeStringList.add(height.toString());
        attributeStringList.add(Integer.toString(weight));
        attributeStringList.add(hometown);
        attributeStringList.add(highSchool);
        return attributeStringList;
    }

    @Override
    public String getAttributeName(int n) {
        ArrayList<String> attributeStringList = new ArrayList<>();
        attributeStringList.add("number");
        attributeStringList.add("position");
        attributeStringList.add("name");
        attributeStringList.add("height");
        attributeStringList.add("weight");
        attributeStringList.add("hometown");
        attributeStringList.add("highschool");
        return attributeStringList.get(n);
    }
    @Override
    public ArrayList<String> getAttributeNames() {
        ArrayList<String> attributeStringList = new ArrayList<>();
        attributeStringList.add("number");
        attributeStringList.add("position");
        attributeStringList.add("name");
        attributeStringList.add("height");
        attributeStringList.add("weight");
        attributeStringList.add("hometown");
        attributeStringList.add("highschool");
        return attributeStringList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
