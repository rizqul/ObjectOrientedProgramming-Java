public class OuterClass{
    private Integer id;

    class InnerClass{
        Integer getId(){
            return id;
        }
    }

    public InnerClass getInner(){
        return new InnerClass();
    }
}