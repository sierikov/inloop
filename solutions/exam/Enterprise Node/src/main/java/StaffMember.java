import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StaffMember implements EnterpriseNode, Comparable<StaffMember> {

    private String name;
    private String job;
    private Set<StaffMember> directSubordinates;

    public StaffMember(String name, String job) {
        this.directSubordinates = new HashSet<>();
        this.name = Validator.checkParam(name);
        this.job = Validator.checkParam(job);
    }

    String getJob() {
        return job;
    }

    boolean addDirectSubordinate(StaffMember member) {
        Objects.requireNonNull(member);
        if (this.directSubordinates.contains(member)) return false;
        else return this.directSubordinates.add(member);
    }

    boolean removeDirectSubordinate(StaffMember member) {
        Objects.requireNonNull(member);
        return this.directSubordinates.remove(member);
    }

    Set<StaffMember> getDirectSubordinates() {
        return directSubordinates;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(StaffMember member) {
        Objects.requireNonNull(member);
        return this.name.compareTo(member.getName());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
