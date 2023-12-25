import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private int O;
    private int G;
    private int B;
    private int M;
    private int A;
    private int Y;
    private int Av;
    private int P;

    public Team(String name) {
        this.name = name;
        this.O = 0;
        this.G = 0;
        this.B = 0;
        this.M = 0;
        this.A = 0;
        this.Y = 0;
        this.Av = 0;
        this.P = 0;
    }

    public String getName() {
        return name;
    }

    public int getO() {
        return O;
    }

    public void setO(int o) {
        O = o;
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        G = g;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getAv() {
        return Av;
    }

    public void setAv(int av) {
        Av = av;
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Team> getTeams(){
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Fenerbahçe"));
        teams.add(new Team("Galatasaray"));
        teams.add(new Team("Beşiktaş"));
        teams.add(new Team("Trabzonspor"));
        teams.add(new Team("Hatayspor"));
        teams.add(new Team("Göztepe"));
        teams.add(new Team("Konyaspor"));
        teams.add(new Team("Karagümrük"));
        teams.add(new Team("Alanyaspor"));
        teams.add(new Team("Gençlerbirliği"));
        teams.add(new Team("Kayserispor"));
        teams.add(new Team("Gaziantep FK"));
        teams.add(new Team("Sivasspor"));
        teams.add(new Team("Antalyaspor"));
        teams.add(new Team("Başakşehir"));
        teams.add(new Team("Kasımpaşa"));
        teams.add(new Team("Samsunspor"));
        teams.add(new Team("Göztepe"));
        teams.add(new Team("Giresunspor"));
        teams.add(new Team("Rizespor"));

        return teams;
    }
}
