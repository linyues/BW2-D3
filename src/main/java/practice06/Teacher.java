package practice06;

public class Teacher extends Person {
    private String name;
    private int age;
    private int name1;

    public Teacher(String name, int age, int name1) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.name1 = name1;
    }

    public Teacher(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public int getKlass() {
        return name1;
    }

    public String introduce(){
        if(name1 != 0){
            return super.introduce()+" I am a Teacher. I teach Class "+ name1 +".";
        }

        return super.introduce()+" I am a Teacher. I teach No Class.";
    }
}
