import java.util.*;

/**
 * User class represent player or store owner or both
 */
public class User {
    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void giveMoney(User player, int amount) {
        if ((money - amount) < 0)
            throw new IllegalArgumentException("money < 0");

        money -= amount;
        player.money += amount;
    }

    public Item[] getInventory() {
        Item[] result = new Item[inventory.size()];
        inventory.toArray(result);
        return result;
    }

    public void addItem(Item item) {
        for (Item i : inventory) {
            if (i.equals(item)) {
                i.add(item);
                return;
            }
        }

        inventory.add(item);
    }

    public void addItem(Item[] items) {
        for (Item i : items)
            addItem(i);
    }

    private String name;
    private int money;
    private ArrayList<Item> inventory;
}