

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class StaffMemberIterator implements EnterpriseNodeIterator {

    private TreeSet<StaffMember> allMembers;
    private Iterator<StaffMember> iterator;

    public StaffMemberIterator(Set<StaffMember> directSubordinates) {
        Objects.requireNonNull(directSubordinates);
        this.allMembers = new TreeSet<>();
        directSubordinates.forEach(this::findSubordinatesRecursively);
        this.iterator = allMembers.iterator();
    }

    private void findSubordinatesRecursively(StaffMember member) {
        this.allMembers.add(member);
        member
                .getDirectSubordinates()
                .forEach(this::findSubordinatesRecursively);
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public StaffMember next() {
        return iterator.next();
    }
}
