class Player {
    private String name;
    private int hp;
    private int attackPower;
    private int defense;

    public Player (String name, int defense){
        this.name = name;
        this.defense = defense;
        hp = 100;
    }

    public Player (String name, int attackPower, int defense){
        this.name = name;
        this.attackPower = attackPower;
        this.defense = defense;
        hp = 100;
    }

    public int getAttackPower(Player player){
        return attackPower;
    }

    public void setAttackPower(int attackPower){
        this.attackPower = attackPower;
    }

    public void getDamage(Player enemy){
        hp = hp - (enemy.getAttackPower(enemy) - defense);
    }

    public void status(){
        System.out.println(name + " Status");
        System.out.println("Hp = " + hp);
        System.out.println("Defense = " + defense);
        System.out.println("Attack = " + attackPower + "\n");
    }


}