import java.util.List;
import java.util.Queue;
import java.util.Random;

public class FixtureBuilder {

    public static void main(String[] args) {

        // Takımlar
        List<Team> teams = Team.getTeams();

        // Puan Durumu
        Queue<Standings> standings = Standings.getStandigs(teams);
        //Standings.print(standings);

        // fixtür oluştur
        Fixture[][] weeks =  Fixture.createFixture(teams);

        // fixtür yaz
        //Fixture.print(weeks);

        Random random = new Random();

        // Maçları oynat
        for (Fixture[] week : weeks) {
            for (Fixture fixture : week) {
                fixture.setHostGoal(random.nextInt(4));
                fixture.setAwayGoal(random.nextInt(4));
                // puan durumu güncelle
                // oynadığı maç
                fixture.getHost().setO(fixture.getHost().getO() +1);
                fixture.getAway().setO(fixture.getAway().getO() +1);
                // avaraj
                fixture.getHost().setA(fixture.getHost().getA() + fixture.getHostGoal());
                fixture.getHost().setY(fixture.getHost().getY() + fixture.getAwayGoal());
                fixture.getHost().setAv(fixture.getHost().getA() - fixture.getHost().getY());

                fixture.getAway().setA(fixture.getAway().getA() + fixture.getAwayGoal());
                fixture.getAway().setY(fixture.getAway().getY() + fixture.getHostGoal());
                fixture.getAway().setAv(fixture.getAway().getA() - fixture.getAway().getY());

                // galibiyet, beraberlik, mağlubiyet, puan
                if(fixture.getHostGoal() > fixture.getAwayGoal()){
                    fixture.getHost().setG(fixture.getHost().getG() +1);
                    fixture.getHost().setP(fixture.getHost().getP() +3);
                    fixture.getAway().setM(fixture.getAway().getM() +1);
                }else if(fixture.getHostGoal() < fixture.getAwayGoal()){
                    fixture.getAway().setG(fixture.getAway().getG() +1);
                    fixture.getAway().setP(fixture.getAway().getP() +3);
                    fixture.getHost().setM(fixture.getHost().getM() +1);
                }else{
                    fixture.getHost().setB(fixture.getHost().getB() +1);
                    fixture.getAway().setB(fixture.getAway().getB() +1);
                    fixture.getHost().setP(fixture.getHost().getP() +1);
                    fixture.getAway().setP(fixture.getAway().getP() +1);
                }

            }
        }

        //Fixture.print(weeks);

        standings = Standings.getStandigs(teams);

        System.out.println("******************************************");
        System.out.println("ŞAMPİYON "+ standings.peek().getTeam().getName().toUpperCase());
        System.out.println("ŞAMPİYON "+ standings.peek().getTeam().getName().toUpperCase());
        System.out.println("ŞAMPİYON "+ standings.peek().getTeam().getName().toUpperCase());
        System.out.println("ŞAMPİYON "+ standings.peek().getTeam().getName().toUpperCase());
        System.out.println("******************************************");
        System.out.println();

        Standings.print(standings);




    }

}
