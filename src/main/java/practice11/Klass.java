package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {

    private Integer klassCode;
    private Student leader;
    private List<BroadcastJoinListener> joinObservers = new ArrayList<BroadcastJoinListener>();
    private List<BroadcastLeaderListener> leaderObservers = new ArrayList<BroadcastLeaderListener>();

    public void assignLeader(Student student) {
        if (this.isIn(student)) {
            this.leader = student;
            for (BroadcastLeaderListener leaderListener : leaderObservers) {
                leaderListener.broadcastLeaderListener(student, this);
            }
        } else {
            System.out.println("It is not one of us.");
        }
    }

    private boolean isIn(Student student) {
        return student.getKlass().equals(this);
    }

    public Student getLeader() {
        return leader;
    }

    public Integer getNumber() {
        return klassCode;
    }

    public String getDisplayName() {
        return "Class " + klassCode;
    }

    public Klass(Integer klassCode) {
        this.klassCode = klassCode;
        this.joinObservers = new ArrayList<>();
        this.leaderObservers = new ArrayList<>();
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        for (BroadcastJoinListener joinObserver : joinObservers) {
            joinObserver.broadcastJoinListener(student, this);
        }
    }

    public void registerJoinListener(Teacher teacher) {
        this.joinObservers.add(teacher);
    }

    public void registerLeaderListener(Teacher teacher) {
        this.leaderObservers.add(teacher);
    }
}