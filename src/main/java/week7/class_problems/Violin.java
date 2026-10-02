package main.java.week7.class_problems;

public class Violin extends StringInstrument {
    @Override
    public String play() {
        return super.play() + ", with a bow drawn across four strings";
    }
}