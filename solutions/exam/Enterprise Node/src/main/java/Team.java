

import java.util.*;

class Team extends AbstractEnterpriseUnit {

    private StaffMember teamLeader;

    Team(String name, StaffMember teamLeader) {
        super(name);
        this.teamLeader = Objects.requireNonNull(teamLeader);
    }

    StaffMember getTeamLeader() {
        return teamLeader;
    }

    SortedSet<StaffMember> getTeamMembers() {
        SortedSet<StaffMember> members = new TreeSet<>(StaffMember::compareTo);
        members.add(teamLeader);
        StaffMemberIterator memberIterator = new StaffMemberIterator(this.teamLeader.getDirectSubordinates());
        while(memberIterator.hasNext()){
            members.add(memberIterator.next());
        }
        return members;

    }
}
