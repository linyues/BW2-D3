package practice07;



public class Teacher extends Person {
    private String name;
    private int age;
    private Klass klass;

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.klass = klass;
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

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){
        if(klass != null){
            return super.introduce()+" I am a Teacher. I teach Class "+ klass.getNumber() +".";
        }

        return super.introduce()+" I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student){
        if(student.getKlass().equals(klass)){
            return "My name is "+ name +". I am "+ age +" years old. I am a Teacher. I teach "+ student.getName() +".";
        }
        return "My name is "+ name +". I am "+ age +" years old. I am a Teacher. I don't teach "+ student.getName() +".";
    }
}