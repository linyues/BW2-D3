package practice11;

import java.util.Iterator;
import java.util.List;

public class Teacher extends Person implements BroadcastJoinListener, BroadcastLeaderListener {
    private List<Klass> classes;

    public Teacher(int id,String name, int age, List<Klass> classes) {
        super(id,name, age);
        this.classes = classes;
        for (Klass klass : classes) {
            klass.registerJoinListener(this);
            klass.registerLeaderListener(this);
        }
    }

    public Teacher(Integer id,String name, Integer age) {
        super(id,name, age);
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public String introduceWith(Student student){
        String words = String.format("My name is %s. I am %d years old. I am a Teacher.", this.getName(), this.getAge());
        words += this.isTeaching(student) ? String.format(" I teach %s.",student.getName()) : String.format(" I don't teach %s.",student.getName());
        return words;
    }

    public boolean isTeaching(Student student) {
        return this.getClasses().contains(student.getKlass());
    }

    @Override
    public String introduce() {
        StringBuilder words = new StringBuilder(super.introduce() + " I am a Teacher.");
        if (this.classes != null) {
            words.append(" I teach Class");
            Iterator it = this.classes.iterator();
            while (it.hasNext()) {
                Klass klass= (Klass) it.next();
                words.append(String.format(" %d,", klass.getNumber()));
            }
            char[] items= words.toString().toCharArray();
            items[items.length-1]='.';
            words = new StringBuilder(new String(items));
        }else {
            words.append(" I teach No Class.");
        }
        return words.toString();
    }

    @Override
    public void broadcastJoinListener(Student student, Klass klass) {
        System.out.printf("I am %s. I know %s has joined %s.%n", getName(), student.getName(), klass.getDisplayName());
    }


    @Override
    public void broadcastLeaderListener(Student student, Klass klass) {
        System.out.printf("I am %s. I know %s become Leader of %s.%n", getName(), student.getName(), klass.getDisplayName());
    }
}