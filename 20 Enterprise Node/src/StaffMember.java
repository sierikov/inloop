package enterprise_node;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class StaffMember implements EnterpriseNode, Comparable<StaffMember> {

    private String name;
    private String job;
    private Set<StaffMember> directSubordinates;

    public StaffMember(String name, String job) {
        AbstractEnterpriseUnit.notNull(name, job);
        AbstractEnterpriseUnit.notEmpty(name, job);
        this.directSubordinates = new HashSet<>();
        this.name = name;
        this.job = job;
    }

    public boolean addDirectSubordinate(StaffMember m) {
        AbstractEnterpriseUnit.notNull(m);
        if (this.directSubordinates.contains(m)) {
            return false;
        } else {
            this.directSubordinates.add(m);
            return true;
        }
    }

    public boolean removeDirectSubordinate(StaffMember m) {
        AbstractEnterpriseUnit.notNull(m);
        return this.directSubordinates.remove(m);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getJob() {
        return job;
    }

    @Override
    public int compareTo(@NotNull StaffMember o) {
        return this.name.compareTo(o.getName());
    }

    public Set<StaffMember> getDirectSubordinates() {
        return directSubordinates;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
