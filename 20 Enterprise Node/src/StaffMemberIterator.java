package enterprise_node;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StaffMemberIterator implements EnterpriseNodeIterator {

    private TreeSet<StaffMember> allMembers;
    private Iterator<StaffMember> it;

    public StaffMemberIterator(Set<StaffMember> directSubordinates) {
        AbstractEnterpriseUnit.notNull(directSubordinates);
        this.allMembers = new TreeSet<>();
        directSubordinates.forEach(this::findSubordinatesRecursively);
        this.it = allMembers.iterator();
    }

    private void findSubordinatesRecursively(StaffMember m) {
        this.allMembers.add(m);
        m.getDirectSubordinates().forEach(this::findSubordinatesRecursively);
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public StaffMember next() {
        return it.next();
    }
}
