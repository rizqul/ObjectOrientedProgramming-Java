package Box;

public class BoxClass {
    private double height;
    private double width;
    private double depth;
    private String name;


    public void setHeight(double height){
        this.height = height;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public void setDepth(double depth){
        this.depth = depth;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getVolume (){
        return height * depth * width;
    }

    public void desc (){
        System.out.println(name);
        System.out.println(height);
        System.out.println(width);
        System.out.println(depth);

    }
}