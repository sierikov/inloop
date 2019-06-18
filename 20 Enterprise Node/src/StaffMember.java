import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class StaffMember implements Comparable, EnterpriseNode {
    private String name;
    private String job;
    private Set<StaffMember> directSubordinates;

    StaffMember(String name, String job){
        this.directSubordinates = new HashSet<>();
        this.name = Validator.checkParam(name);
        this.job = Validator.checkParam(job);
    }

    public String getJob() {
        return this.job;
    }

    boolean addDirectSubordinate(StaffMember subordinate){
        Objects.requireNonNull(subordinate);
        return this.directSubordinates.add(subordinate);
    }

    boolean removeDirectSubordinate(StaffMember subordinate){
        Objects.requireNonNull(subordinate);
        return this.directSubordinates.remove(subordinate);
    }

    Set<StaffMember> getDirectSubordinates() {
        return this.directSubordinates;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        StaffMember aMember = (StaffMember) o;
        System.out.println(this.getName() + this.getJob() + " " + aMember.getName() + aMember.getJob());
        return (this.getName()).compareTo(aMember.getName());
    }


}
