import java.util.*;

public class Fixture {

    private Team host;
    private Team away;
    private int hostGoal;
    private int awayGoal;

    public Fixture(Team host, Team away) {
        this.host = host;
        this.away = away;
        this.hostGoal = 0;
        this.awayGoal = 0;
    }

    public Team getHost() {
        return host;
    }

    public void setHost(Team host) {
        this.host = host;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public int getHostGoal() {
        return hostGoal;
    }

    public void setHostGoal(int hostGoal) {
        this.hostGoal = hostGoal;
    }

    public int getAwayGoal() {
        return awayGoal;
    }

    public void setAwayGoal(int awayGoal) {
        this.awayGoal = awayGoal;
    }

    // Fixtür Oluştur
    public static Fixture[][]  createFixture(List<Team> teams){

        Collections.shuffle(teams);

        Fixture[][] weeks = new Fixture[40][10];
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 10; j++) {
                weeks[i][j] = new Fixture(teams.get(j), teams.get(j+10));
            }
            Collections.shuffle(teams);
        }
        return weeks;
    }

    // Haftalık döküm
    public static void print(Fixture[][] weeks){
        StringBuilder blank1 = new StringBuilder();
        StringBuilder blank2 = new StringBuilder();
        for (int i = 0; i < weeks.length; i++) {
            System.out.println("-------------------- "+ (i+1) + ". hafta --------------------");
            for (int j = 0; j < weeks[i].length; j++) {
                if(weeks[i][j] != null){
                    blank1.append(" ".repeat(Math.max(0, 20 - weeks[i][j].getHost().getName().length())));
                    blank2.append(" ".repeat(Math.max(0, 20 - weeks[i][j].getAway().getName().length())));
                    System.out.println(
                            weeks[i][j].getHost().getName() +blank1+
                                    " ( "+weeks[i][j].getHostGoal()+" - "+weeks[i][j].getAwayGoal()+" ) "+blank2+
                                    weeks[i][j].getAway().getName());
                }
                blank1 = new StringBuilder(blank2 = new StringBuilder());
            }
            System.out.println();
        }
    }

}
