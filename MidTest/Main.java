import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("    WELCOME TO STORE    ");
        System.out.println("CREATE : ");

        System.out.println("Enter Player Name (no space)");
        String playerName = sc.next();
        System.out.println("Enter Player Money");
        double PlayerMoney = sc.nextDouble();
        User player = new User(playerName, PlayerMoney);
        player.setProduct(player.readProductList(
                "D:\\VisualStudioCode\\Java\\Semester_2\\OOP_Class\\Lecture\\MidTest\\PlayerItem.txt"));

        System.out.println("Enter StoreOwner Name (no space)");
        String storeOwnerName = sc.next();
        System.out.println("Enter StoreOwner Money");
        double storeOwnerMoney = sc.nextDouble();
        User storeOwner = new User(storeOwnerName, storeOwnerMoney);
        System.out.println("adding store owner item...");
        storeOwner.setProduct(storeOwner.readProductList(
                "D:\\VisualStudioCode\\Java\\Semester_2\\OOP_Class\\Lecture\\MidTest\\StoreOwnerItem.txt"));
        System.out.println("generating store...");
        Store store = new Store(storeOwner);
        System.out.println("adding store item...");
        store.setProduct(store
                .readProductList("D:\\VisualStudioCode\\Java\\Semester_2\\OOP_Class\\Lecture\\MidTest\\StoreItem.txt"));
        System.out.println("all generate");

        Integer count = 1;
        Map<Integer, Item> playerItem = new HashMap<>();
        for (Item pItem : player.getItemList()) {
            playerItem.put(count, pItem);
            count++;
        }
        count=1;
        Map<Integer, Item> storeOwnerItem = new HashMap<>();
        for (Item soItem : storeOwner.getItemList()) {
            storeOwnerItem.put(count, soItem);
            count++;
        }
        count=1;
        Map<Integer, Item> storeItem = new HashMap<>();
        for (Item sItem : store.getProduct()) {
            storeItem.put(count, sItem);
            count++;
        }

        while (true) {
            System.out.println("which role you want to use :");
            System.out.println("0.stop\n1.player\n2. store owner\n");
            switch (sc.nextInt()) {
                case 0:
                    System.out.println("Exit..");
                    return;
                case 1:
                    player.showStatus();
                    boolean stream1 = true;
                    while (stream1) {
                        System.out.println("which action you want to use :");
                        System.out.println(
                                "0. end action\n1. buy from player\n2. buy from store\n3. sell from player\n4. sell from store\n5. show Status\n6. show item list");
                        switch (sc.nextInt()) {
                            case 0:
                                stream1 = false;
                                break;
                            case 1:
                                System.out.println("Item list");
                                storeOwner.showItemList();
                                System.out.println("which item you want to buy");
                                int itemChoose1 = sc.nextInt();
                                System.out.println("how much you want to buy");
                                int amount1 = sc.nextInt();
                                player.buyFromUser(storeOwnerItem.get(itemChoose1),amount1 , storeOwner);
                                System.out.println("you have buy "+ amount1+" "+ storeOwnerItem.get(itemChoose1).getDetail());
    
                                break;
                            
                            case 2:
                                System.out.println("Item list");
                                store.showItemList();
                                System.out.println("which item you want to buy");
                                int itemChoose2 = sc.nextInt();
                                System.out.println("how much you want to buy");
                                int amount2 = sc.nextInt();
                                player.buyFromUser(storeItem.get(itemChoose2),amount2 , storeOwner);
                                System.out.println("you have buy "+ amount2+" "+ storeItem.get(itemChoose2).getDetail());
    
                                break;
    
                            case 3:
                                System.out.println("Item list");
                                player.showItemList();
                                System.out.println("which item you want to sell");
                                int itemChoose3 = sc.nextInt();
                                System.out.println("how much you want to sell");
                                int amount3 = sc.nextInt();
                                player.sellToOwner(playerItem.get(itemChoose3),amount3, storeOwner);
                                System.out.println("you have sell "+ amount3+" "+ playerItem.get(itemChoose3).getDetail()+" to "+storeOwner.getName());
    
                                break;
    
                            case 4:
                                System.out.println("Item list");
                                player.showItemList();
                                System.out.println("which item you want to buy");
                                int itemChoose4 = sc.nextInt();
                                System.out.println("how much you want to buy");
                                int amount4 = sc.nextInt();
                                player.sellToStore(playerItem.get(itemChoose4),amount4, store);
                                System.out.println("you have sell "+ amount4+" "+ playerItem.get(itemChoose4).getDetail()+" to "+storeOwner.getName()+"'s store");
    
                                break;
                            case 5:
                                player.showStatus();
                                break;
                            case 6:
                                player.showItemList();
                                break;
    
                            default:
                                break;
                        }
                    }

                        break;
                case 2:
                player.showStatus();
                boolean stream2 = true;
                    while (stream2) {
                        System.out.println("which action you want to use :");
                        System.out.println(
                                "1. buy from player\n2. buy from store\n3. sell from player\n4. sell from store\n");
                        switch (sc.nextInt()) {
                            case 0:
                                stream2 = false;
                                break;
                            case 1:
                                System.out.println("Item list");
                                storeOwner.showItemList();
                                System.out.println("which item you want to buy");
                                int itemChoose1 = sc.nextInt();
                                System.out.println("how much you want to buy");
                                int amount1 = sc.nextInt();
                                storeOwner.buyFromUser(playerItem.get(itemChoose1),amount1 , player);
                                System.out.println("you have buy "+ amount1+" "+ playerItem.get(itemChoose1).getDetail());
        
                                break;
                            
                            case 2:
                                System.out.println("Item list");
                                store.showItemList();
                                System.out.println("which item you want to buy");
                                int itemChoose2 = sc.nextInt();
                                System.out.println("how much you want to buy");
                                int amount2 = sc.nextInt();
                                storeOwner.buyFromStore(storeItem.get(itemChoose2),amount2 , store);
                                System.out.println("you have buy "+ amount2+" "+ storeItem.get(itemChoose2).getDetail());
        
                                break;
        
                            case 3:
                                System.out.println("Item list");
                                player.showItemList();
                                System.out.println("which item you want to sell");
                                int itemChoose3 = sc.nextInt();
                                System.out.println("how much you want to sell");
                                int amount3 = sc.nextInt();
                                storeOwner.sellToOwner(storeOwnerItem.get(itemChoose3),amount3, player);
                                System.out.println("you have sell "+ amount3+" "+ storeItem.get(itemChoose3).getDetail()+" to "+player.getName());
        
                                break;
        
                            case 4:
                                System.out.println("Item list");
                                player.showItemList();
                                System.out.println("which item you want to buy");
                                int itemChoose4 = sc.nextInt();
                                System.out.println("how much you want to buy");
                                int amount4 = sc.nextInt();
                                storeOwner.sellToStore(storeItem.get(itemChoose4),amount4, store);
                                System.out.println("you have sell "+ amount4+" "+ storeItem.get(itemChoose4).getDetail()+" to "+storeOwner.getName()+"'s store");
        
                                break;
                            case 5:
                                storeOwner.showStatus();
                                break;
                            case 6:
                                storeOwner.showItemList();
                                break;
        
                            default:
                                break;
                        }
                    }
                    break;
            }
        }

    }
}