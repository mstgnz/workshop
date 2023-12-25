import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Standings implements Comparable<Standings>{
    private final Team team;

    public Standings(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public static Queue<Standings> getStandigs(List<Team> teams){
        Queue<Standings> standigs = new PriorityQueue<>();
        for (Team team: teams) {
            standigs.offer(new Standings(team));
        }
        return standigs;
    }

    public static void print(Queue<Standings> standings){
        StringBuilder blank = new StringBuilder();
        Team team;
        boolean title = true;
        while (!standings.isEmpty()){
            team = Objects.requireNonNull(standings.poll()).getTeam();
            blank.append(" ".repeat(Math.max(0, 25 - team.getName().length())));
            if(title){
                System.out.println("Takım Adı"+blank+" O   G   B   M   A   Y   Av  P");
                System.out.println("------------------------------------------------------");
            }
            System.out.println(team.getName()+blank+team.getO()+"   "+team.getG()+"   "+team.getB()+"   "+team.getM()+"   "+team.getA()+"   "+team.getY()+"   "+team.getAv()+"   "+team.getP());
            blank = new StringBuilder();
            title = false;
        }
        System.out.println();
    }

    @Override
    public int compareTo(Standings std) {
        if(this.getTeam().getP() > std.getTeam().getP()){
            return -1;
        }else if(this.getTeam().getP() < std.getTeam().getP()){
            return 1;
        } else if(this.getTeam().getAv() > std.getTeam().getAv()){
            return -1;
        }else if(this.getTeam().getAv() < std.getTeam().getAv()){
            return 1;
        }
        return 0;
    }
}
