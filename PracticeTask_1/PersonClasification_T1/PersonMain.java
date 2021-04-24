package PersonClasification_T1;

class PersonMain{
    public static void main(String[] args) {
        PersonClass person1 = new PersonClass();

        int age = 18;
        String name = "jjjj";
        boolean isMale = true;
        person1.setAge(age);
        person1.setName(name);
        person1.setGender(isMale);
        System.out.println(person1.getAge());

        
    }
}