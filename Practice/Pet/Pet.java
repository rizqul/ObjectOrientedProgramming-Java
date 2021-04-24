class Pet{
    String name;
    double mass;
    double height;
    String food;

    public Pet(String name, String food){
        this.name = name;
        this.food = food;
    }

    public double getHeight() {
        return height;
    }

    public double getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }
}