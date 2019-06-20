package enterprise_node;

import java.util.ArrayList;
import java.util.List;

public class Team extends AbstractEnterpriseUnit {

    private StaffMember teamLeader;

    public Team(String name, StaffMember teamLeader) {
        super(name);
        AbstractEnterpriseUnit.notNull(teamLeader);
        this.teamLeader = teamLeader;
    }

    public List<StaffMember> getTeamMembers() {
        List<StaffMember> members = new ArrayList<>();
        members.add(teamLeader);
        var it = new StaffMemberIterator(this.teamLeader.getDirectSubordinates());
        while(it.hasNext()){
            members.add(it.next());
        }
        members.sort(StaffMember::compareTo);
        return members;

    }

    public StaffMember getTeamLeader() {
        return teamLeader;
    }
}
