package a_DefiningClassesEx;

public class Box {
    private double length;
    private double width;
    private double height;
    private double surfaceArea;
    private double lateralSurfaceArea;
    private double Volume;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getSurfaceArea() {
        return 2*length*width + 2*length*height + 2*width*height;
    }

    public double getLateralSurfaceArea() {
        return 2*length*height + 2*width*height;
    }

    public double getVolume() {
        return length * height * width;
    }
}
