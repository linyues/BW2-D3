package practice04;

import practice03.Person;

public class Worker extends Person {
    private String name;
    private int age;

    public Worker(String name,int age){
        super("Tom",21);
        this.name = name ;
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
    public String introduce(){
        return super.introduce()+ " I am a Worker. I have a job.";
    }
}
