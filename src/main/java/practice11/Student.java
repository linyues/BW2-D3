package practice11;

public class Student extends Person {
    private Klass klass;

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public Student(Integer id, String name, Integer age, Klass klass) {
        super(id,name, age);
        this.klass = klass;
    }

    private boolean isClassLeader() {
        Student classLeader =  klass.getLeader();
        return this.equals(classLeader);
    }

    @Override
    public String introduce() {
        String words = super.introduce() + " I am a Student.";
        words += this.isClassLeader() ? String.format(" I am Leader of %s.", this.getKlass().getDisplayName()) : String.format(" I am at %s.", this.getKlass().getDisplayName());
        return words;
    }
}