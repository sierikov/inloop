import java.util.*;

public class Team extends AbstractEnterpriseUnit {

    private StaffMember teamleader;

    public Team(String name,StaffMember teamleader) {

        super(name);
        if (name ==null||teamleader==null){
            throw new NullPointerException();
        }
        if (name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.teamleader = teamleader;
    }

    public StaffMember getTeamLeader() {
        return teamleader;
    }

    @Override
    public String getName() {
        return teamleader.getName();
    }
    public List<StaffMember> getTeamMembers(){
        Set<StaffMember> set = new HashSet<>();
        List<StaffMember> sublist = new LinkedList<>();
        sublist.addAll(teamleader.getDirectSubordinates());
        set.addAll(teamleader.getDirectSubordinates());
        set.add(teamleader);
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
        Collections.sort(sublist);

        return sublist;
    }
}