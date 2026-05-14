package com.hspedu.exercise.homework09;

public class LabelPoint extends Point {
    private String label;

    public LabelPoint(String label,double x, double y) {
        super(x, y);
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabelPoint{" +
                "label='" + label + '\'' +
                ", x = " + this.getX() +
                ", y = " + this.getY() +
                '}';
    }
}
