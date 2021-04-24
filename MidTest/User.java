import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;

class User {
    private String name;
    private double money;
    private List<Item> itemList = new ArrayList<>();

    public User(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    public double getMoney() {
        return money;
    }
    public List<Item> getItemList() {
        return itemList;
    }
    public String getName() {
        return name;
    }

    public String readProductList(String fileDir) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileDir)));
        return data;
    }

    public void setProduct(String list) {
        String itemList[] = list.split("\n");
        for (int i = 0; i < itemList.length; i++) {
            String itemAtribute[] = itemList[i].split(";");
            this.itemList.add(new Item(Double.parseDouble(itemAtribute[0]),Integer.parseInt(itemAtribute[1]),itemAtribute[2]));
        }
    }


    public void buyFromUser(Item items, int quantity, User owner) {
        if (money >= items.getPrice() * quantity && items.getQuantity() >= quantity) {
            money -= items.getPrice() * quantity;
            owner.setMoney(owner.getMoney() + items.getPrice() * quantity);
            this.addItem(items, quantity);
            owner.removeItem(items, quantity);
        } else {
            System.out.println(items.getQuantity() >= quantity ? "" : "stock doesnt enough");
            System.out.println(money >= items.getPrice() * quantity ? "" : "money doesnt enough");
        }
    }

    public void sellToOwner(Item sellItems, int stock, User costumer){
        if (costumer.getMoney() >= sellItems.getPrice() * stock) {
            money += sellItems.getPrice() *stock;
            costumer.setMoney(costumer.getMoney() - sellItems.getPrice() *stock);
            costumer.addItem(sellItems, stock);
            this.removeItem(sellItems, stock);
        } else {
            System.out.println(costumer.getName() + " money is not enough");
        }
    }

    public void buyFromStore(Item items, int quantity, Store owner) {
        if (money >= items.getPrice() * quantity && items.getQuantity() >= quantity) {
            money -= items.getPrice() * quantity;
            owner.getOwner().setMoney(owner.getOwner().getMoney() + items.getPrice() * quantity);
            this.addItem(items, quantity);
            owner.removeItem(items, quantity);
        } else {
            System.out.println(items.getQuantity() >= quantity ? "" : "stock doesnt enough");
            System.out.println(money >= items.getPrice() * quantity ? "" : "money doesnt enough");
        }
    }

    public void sellToStore(Item sellItems, int stock, Store costumer){
        if (costumer.getOwner().getMoney() >= sellItems.getPrice() * stock) {
            money += sellItems.getPrice() *stock;
            costumer.getOwner().setMoney(costumer.getOwner().getMoney() - sellItems.getPrice() *stock);
            costumer.addItem(sellItems, stock);
            this.removeItem(sellItems, stock);
        } else {
            System.out.println(costumer.getOwner().getName() + " money is not enough");
        }
    }


    public void addItem(Item addedItem, int stock){
        boolean containAddedItem = false;
        for (Item item : itemList) {
            if (item.getDetail() == addedItem.getDetail()) {
                containAddedItem = true;
                item.setQuantity(item.getQuantity()+stock);
                break;
            } 
        }
        if (!containAddedItem) {
            itemList.add(new Item(addedItem.getPrice(), stock, addedItem.getDetail()));
        }
    }

    public void removeItem(Item removedItem, int stock){
        boolean itemAvailable = false;
        for (Item item : itemList) {
            if (item.getDetail() == removedItem.getDetail()) {
                itemAvailable = true;
                if (item.getQuantity() > stock) {
                    item.setQuantity(item.getQuantity() - stock);
                } else if (item.getQuantity() == stock) {
                    itemList.remove(item);
                } else {
                    System.out.println(name + " stock is not enough");
                }
                break;
            }
        }
        if (!itemAvailable) {
            System.out.println("there no such Item");
        }
    }

    public void showItemList(){
        int count = 1;
        for (Item item : itemList) {
            System.out.println(count +". "+" ("+item.getQuantity()+") \t"+ item.getPrice()+" $"+"\t"+item.getDetail());
            count++;
        }
        System.out.println();
    }

    public void showStatus(){
        System.out.println("Name\t: " + name);
        System.out.println("Money\t: " + money);
    }
}