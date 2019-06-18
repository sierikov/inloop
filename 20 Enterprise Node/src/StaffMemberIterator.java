import java.util.*;

public class StaffMemberIterator implements EnterpriseNodeIterator {

    private Set<StaffMember> allMembers;
    private Iterator<StaffMember> iterator;

    public StaffMemberIterator(Set<StaffMember> allMembers) {
        if (allMembers == null){
            throw new NullPointerException();
        }
        this.allMembers = allMembers;
        List<StaffMember> list = new LinkedList<>();
        list.addAll(allMembers);
        for (StaffMember m : list){
            findSubordinatesRecursively(m);
        }
        list.clear();
        list.addAll(allMembers);
        Collections.sort(list);
        System.out.println(list);
        allMembers.clear();
        allMembers.addAll(list);
        this.iterator = list.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Object next() {
        if (!iterator.hasNext()){
            throw new NoSuchElementException();
        }
        return iterator.next();
    }
    private void findSubordinatesRecursively(StaffMember m){
        Set<StaffMember> set = new HashSet<>();
        List<StaffMember> sublist = new LinkedList<>();
        sublist.addAll(m.getDirectSubordinates());
        set.addAll(m.getDirectSubordinates());
        set.add(m);
        while(!sublist.isEmpty()){
            List<StaffMember> between = new LinkedList<>();
            for (StaffMember member : sublist){
                between.addAll(member.getDirectSubordinates());
            }
            set.addAll(between);
            sublist = between;

        }
        sublist.clear();
        sublist.addAll(set);
        allMembers.addAll(set);
    }
}