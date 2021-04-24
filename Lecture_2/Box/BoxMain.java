package Box;

public class BoxMain {
    public static void main(String[] args) {
        
        BoxClass box1 = new BoxClass();
        box1.setDepth(12);
        box1.setHeight(16);
        box1.setWidth(14);
        box1.setName("jiji");

        BoxClass box2 = new BoxClass();
        box2.setDepth(11);
        box2.setHeight(56);
        box2.setWidth(13);
        box2.setName("ji");

        box1.desc();
        box2.desc();
    }
}