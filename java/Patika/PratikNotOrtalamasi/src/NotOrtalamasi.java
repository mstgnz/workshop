
public class NotOrtalamasi {

    private int gecmeNotu = 55;
    private int math,physics,chemistry,history,music,turkish;

    public NotOrtalamasi(int gecmeNotu) {
        this.gecmeNotu = gecmeNotu;
    }

    public int getGecmeNotu() {
        return gecmeNotu;
    }

    public void setGecmeNotu(int gecmeNotu) {
        this.gecmeNotu = this.checkNote(gecmeNotu);
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = this.checkNote(math);
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = this.checkNote(physics);
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = this.checkNote(chemistry);
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = this.checkNote(history);
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = this.checkNote(music);
    }

    public int getTurkish() {
        return turkish;
    }

    public void setTurkish(int turkish) {
        this.turkish = this.checkNote(turkish);
    }

    public void hesapla(){
        double result;
        double total = this.math + this.physics + this.chemistry + this.history + this.music + this.turkish;
        String textResult;
        result = total / 6;
        textResult = result > this.gecmeNotu ? "Sınıfı Geçti" : "Sınıfta Kaldı";
        System.out.println("Not Ortalamanız : " + result);
        System.out.println("Durum : " + textResult);
    }

    private int checkNote(int note){
        return note >= 0 && note <= 100 ? note : 0;
    }
}
