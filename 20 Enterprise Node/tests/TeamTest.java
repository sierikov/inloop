import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TeamTest {
    private Team team;
    private StaffMember teamLeader;

    @Before
    public void setUp() {
        teamLeader = new StaffMember("Thomas", "Executive");
        team = new Team("Team", teamLeader);
    }

    @Test
    public void testGetTeamLeader() {
        assertEquals("Team.getTeamLeader() should return the correct value!", teamLeader, team.getTeamLeader());
    }

    @Test
    public void testGetTeamMembersWithoutTeam() {
        assertEquals("Team.getTeamMembers() should return all of the Team's members!", Arrays.asList(teamLeader),
                team.getTeamMembers());
    }

    @Test
    public void testGetTeamMembersWithTeam() {
        assertEquals("Team.getTeamMembers() should return all of the Team's members!", createTeamHierarchy(teamLeader),
                team.getTeamMembers());
    }

    public static List<StaffMember> createTeamHierarchy(StaffMember teamLeader) {
        StaffMember a1, a2, a3, a11, a12, a121, a122, a123, a13, a31, a32, a33;
        a1 = new StaffMember("Allie", "J1");
        a2 = new StaffMember("Joseph", "J2");
        a3 = new StaffMember("Lilith", "J3");
        a11 = new StaffMember("Annabel", "J11");
        a12 = new StaffMember("Camellia", "J12");
        a13 = new StaffMember("Hutch", "J13");
        a31 = new StaffMember("Norris", "J31");
        a32 = new StaffMember("Sofia", "J32");
        a33 = new StaffMember("Valentine", "J33");
        a121 = new StaffMember("Gerard", "J121");
        a122 = new StaffMember("Graham", "J122");
        a123 = new StaffMember("Henry", "J123");

        teamLeader.addDirectSubordinate(a2);
        teamLeader.addDirectSubordinate(a3);
        teamLeader.addDirectSubordinate(a1);
        a1.addDirectSubordinate(a11);
        a1.addDirectSubordinate(a13);
        a1.addDirectSubordinate(a12);
        a12.addDirectSubordinate(a121);
        a12.addDirectSubordinate(a123);
        a12.addDirectSubordinate(a122);
        a3.addDirectSubordinate(a33);
        a3.addDirectSubordinate(a31);
        a3.addDirectSubordinate(a32);

        return Arrays.asList(a1, a11, a12, a121, a122, a123, a13, a2, a3, a31, a32, teamLeader, a33);
    }
}
