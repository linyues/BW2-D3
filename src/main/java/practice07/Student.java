package practice07;


public class Student extends Person {
    private String name;
    private int age;
    private Klass klass;

    public Student(String name, int age, Klass klass) {
        super("Tom" ,21);
        this.name = name;
        this.age = age;
        this.klass = klass;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){
        return super.introduce() + " I am a Student. I am at Class "+ klass.getNumber() +".";
    }
}

