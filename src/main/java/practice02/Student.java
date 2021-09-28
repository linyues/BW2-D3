package practice02;

public class Student extends Person{
    private String name;
    private int age;
    private int klass;

    public Student(String name,int age,int klass){
        super("tom",21);
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

    public int getKlass() {
        return klass;
    }
    public String introduce(){
        return "I am a Student. I am at Class "+klass+".";
    }
}
