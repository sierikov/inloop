

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Team extends AbstractEnterpriseUnit {

    private StaffMember teamLeader;

    Team(String name, StaffMember teamLeader) {
        super(name);
        this.teamLeader = Objects.requireNonNull(teamLeader);
    }

    StaffMember getTeamLeader() {
        return teamLeader;
    }

    List<StaffMember> getTeamMembers() {
        List<StaffMember> members = new ArrayList<>();
        members.add(teamLeader);
        StaffMemberIterator memberIterator = new StaffMemberIterator(this.teamLeader.getDirectSubordinates());
        while(memberIterator.hasNext()){
            members.add(memberIterator.next());
        }
        members.sort(StaffMember::compareTo);
        return members;

    }
}
