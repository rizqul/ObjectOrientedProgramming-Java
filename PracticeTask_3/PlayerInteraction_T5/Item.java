class Item{
    private String name;
    private int price;
    private String info;

    public Item(String name, int price, String info){
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public String getInfo(){
        return info;
    }


    public void use(){

    }
    public void sell(){

    }
    public void destroy(){

    }
}