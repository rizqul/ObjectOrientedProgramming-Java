

class Item {
    private double price;
    private int quantity;
    private String detail;
    private boolean sellAble;

    public Item(double price, int quantity, String detail){
    this.price = price;
    this.quantity = quantity;
    this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean getSellable() {
        return sellAble;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setSellAble(boolean sellAble) {
        this.sellAble = sellAble;
    }

    




}