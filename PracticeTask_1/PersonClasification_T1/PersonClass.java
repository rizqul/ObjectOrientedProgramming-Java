package PersonClasification_T1;

class PersonClass{
    String name;
    int age;
    boolean isMale;

    void setName(String name){
        this.name = name;
    }
    void setAge(int age){
       this.age = age;
    }
    void setGender(boolean isMale){
        this.isMale = isMale;
    }

    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }
    boolean getGender(){
        return isMale;
    }

}