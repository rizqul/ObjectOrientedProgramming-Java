import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player("jono", "fighter", 2);
        Player player2 = new Player("sukri", "assassin", 3);

        while (player1.getHp() > 0 && player2.getHp() > 0) {
            System.out.println();
            System.out.println("which player you want to play");
            System.out.printf("0. Exit\n1. %s \n2. %s\n", player1.getName(), player2.getName());
            switch (sc.nextInt()) {
                case 1:
                        System.out.println("\nchoose action :");
                        System.out.println("1.attack\n2.healing\n3.buy an item\n4.sell an item");
                        switch (sc.nextInt()) {
                            case 1:
                                System.out.printf("%s has attack %s with %f damage",player1.getName(),player2.getName(),player1.getDamage());
                                player1.attack(player2);
                                break;
                            case 2:
                            System.out.println("how much hp you want to heal : ");
                                player1.healing(sc.nextInt());
                                break;
                            case 3:
                                System.out.println("choose what item you want to buy :");
                                player2.showItems();
                                int itemNum = sc.nextInt() - 1;
                                player1.buyItem(player2, itemNum);
                                break;
                            case 4:
                                System.out.println("which item you want to sell");
                                player1.showItems();
                                player1.sellItem(sc.nextInt());
                                break;
                        
                            default:
                                break;
                        }
                    
                    
                    break;
                case 2:
                System.out.println("\nchoose action :");
                        System.out.println("1.attack\n2.healing\n3.buy an item\n4.sell an item");
                        switch (sc.nextInt()) {
                            case 1:
                                player2.attack(player1);
                                break;
                            case 2:
                                System.out.println("how much hp you want to heal : ");
                                player2.healing(sc.nextInt());
                                break;
                            case 3:
                                System.out.println("choose what item you want to buy :");
                                player1.showItems();
                                int itemNum = sc.nextInt() - 1;
                                player2.buyItem(player1, itemNum);
                                break;
                            case 4:
                                System.out.println("which item you want to sell");
                                player2.showItems();
                                player2.sellItem(sc.nextInt());
                                break;
                        
                            default:
                                break;
                        }
                    
                    break;
                case 0:
                    return;
            }
        }

    }
}