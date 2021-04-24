import java.util.List;
import java.util.ArrayList;

class Player{
    private String name;
    private String role;
    private int level;
    private double damage;
    private double hp;
    private double energy;
    private int money = 5000;
    private List <Item> items = new ArrayList<>();

    Item item1 = new Item("heal potion", 500, "heal 10% of your hp");
    Item item2 = new Item("mana potion", 500, "restore 10% of your energy");

    public Player(String name, String role, int level){
        this.name = name;
        this.role = role; 
        this.level = level;
        damage = 100 * (double)level;
        hp = 500 * level;
        energy = 200 * level;
    }

    public String getName(){
        return name;
    }
    public String getRole(){
        return role;
    }
    public int getLevel(){
        return level;
    }
    public double getHp(){
        return hp;
    }
    public double getEnergy(){
        return energy;
    }
    public int getMoney(){
        return money;
    }
    public double getDamage(){
        return damage;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setRole(String role){
        this.role = role;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void setHp(double hp){
        this.hp = hp;
    }
    public void setEnergy(double energy){
        this.energy = energy;
    }
    public void setMoney(int money){
        this.money = money;
    }


    public void showStatus(){
        System.out.println(name);
        System.out.println(role);
        System.out.println(level);
        System.out.println(damage);
        System.out.println(hp);
        System.out.println(energy);
        System.out.println(money);
        System.out.println();
    }
    public void showItems(){
        items.add(item1);
        items.add(item2);

        int count = 1;
        for (Item item : items) {
            System.out.println(count +". " + item.getName());
            count++;
        }
    }
    public void attack(Player player){
        player.setHp(player.getHp() - damage);
        System.out.println(player.getName() + " get " + damage + "damage");
    }

    public void healing(int hp){
        if (hp <= energy) {
            this.hp += hp;
            energy -= hp;
        } else {
           System.out.println("energy it's not enough ");
        }
    }
    
    public void buyItem(Player player, int num){

        if (money > player.items.get(num).getPrice()) {
            items.add(player.items.get(num));
            money = money - player.items.get(num).getPrice();
            System.out.printf("you have buy %s from %s",player.items.get(num).getName(), player.getName());
        } else {
            System.out.println("your money is not enough");
        }
    }

    public void sellItem(int num){
        money += items.get(num).getPrice();
        items.remove(num);
    }

}