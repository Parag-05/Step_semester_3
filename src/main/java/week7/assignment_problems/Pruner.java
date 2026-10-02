package main.java.week7.assignment_problems;

public class Pruner extends CuttingTool {
    @Override
    public String use() {
        return super.use() + ", then trimming branches precisely";
    }
}