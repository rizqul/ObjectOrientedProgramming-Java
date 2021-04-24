import java.util.List;
import java.util.ArrayList;
import java.nio.file.*;

class Store {
    
    private User owner;
    private List<Item> product = new ArrayList<>();

    public Store(User owner){
        this.owner = owner;

    }


    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public List<Item> getProduct() {
        return product;
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
            product.add(new Item(Double.parseDouble(itemAtribute[0]),Integer.parseInt(itemAtribute[1]),itemAtribute[2]));
        }
    }


    public void buyFromPlayer(Item items, int quantity, User owner) {
        if (owner.getMoney() >= items.getPrice() * quantity && items.getQuantity() >= quantity) {
            this.owner.setMoney(this.owner.getMoney() - items.getPrice() * quantity);
            owner.setMoney(owner.getMoney() + items.getPrice() * quantity);
            this.addItem(items, quantity);
            owner.removeItem(items, quantity);
        } else {
            System.out.println(items.getQuantity() >= quantity ? "" : "stock doesnt enough");
            System.out.println(owner.getMoney() >= items.getPrice() * quantity ? "" : "money doesnt enough");
        }
    }

    public void sellToPlayer(Item sellItems, int stock, User costumer){
        if (costumer.getMoney() >= sellItems.getPrice() * stock) {
            owner.setMoney(owner.getMoney() + sellItems.getPrice() *stock);
            costumer.setMoney(costumer.getMoney() - sellItems.getPrice() *stock);
            costumer.addItem(sellItems, stock);
            this.removeItem(sellItems, stock);
        } else {
            System.out.println(costumer.getName() + " money is not enough");
        }
    }

    public void buyFromStore(Item items, int quantity, Store owner) {
        if (owner.getOwner().getMoney() >= items.getPrice() * quantity && items.getQuantity() >= quantity) {
            this.owner.setMoney(this.owner.getMoney() - items.getPrice() * quantity);
            owner.getOwner().setMoney(owner.getOwner().getMoney() + items.getPrice() * quantity);
            this.addItem(items, quantity);
            owner.removeItem(items, quantity);
        } else {
            System.out.println(items.getQuantity() >= quantity ? "" : "stock doesnt enough");
            System.out.println(owner.getOwner().getMoney() >= items.getPrice() * quantity ? "" : "money doesnt enough");
        }
    }

    public void sellToStore(Item sellItems, int stock, Store costumer){
        if (costumer.getOwner().getMoney() >= sellItems.getPrice() * stock) {
            owner.setMoney(owner.getMoney() + sellItems.getPrice() *stock);
            costumer.getOwner().setMoney(costumer.getOwner().getMoney() - sellItems.getPrice() *stock);
            costumer.addItem(sellItems, stock);
            this.removeItem(sellItems, stock);
        } else {
            System.out.println(costumer.getOwner().getName() + "'s store owner money is not enough");
        }
    }

    public void addItem(Item addedItem, int stock){
        boolean containAddedItem = false;
        for (Item item : product) {
            if (item.getDetail() == addedItem.getDetail()) {
                containAddedItem = true;
                item.setQuantity(item.getQuantity()+stock);
                break;
            } 
        }
        if (!containAddedItem) {
            product.add(new Item(addedItem.getPrice(), stock, addedItem.getDetail()));
        }
    }

    public void removeItem(Item removedItem, int stock){
        boolean itemAvailable = false;
        for (Item item : product) {
            if (item.getDetail() == removedItem.getDetail()) {
                itemAvailable = true;
                if (item.getQuantity() > stock) {
                    item.setQuantity(item.getQuantity() - stock);
                } else if (item.getQuantity() == stock) {
                    product.remove(item);
                } else {
                    System.out.println(owner.getName() + "'s store stock is not enough");
                }
                break;
            }
        }
        if (!itemAvailable) {
            System.out.println("there no such Item");
        }
    }

    public void showItemList(){
        for (Item item : product) {
            System.out.println(item.getQuantity() + " ; " + item.getPrice() + " ; " + item.getDetail());
        }
        System.out.println();
    }

    public void showStatus(){
        System.out.println("store name\t: "+owner.getName()+"'s store");
        System.out.println("Owner Status :");
        owner.showStatus();
    }

}