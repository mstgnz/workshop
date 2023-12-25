public class Felines extends Animal{

    private String name;

    public Felines(String typeName, double weight, int age, String name) {
        super(typeName, weight, age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getDosage() {
        System.out.println(this.getName() + " için ilaç zamanı");
    }

    @Override
    public void getFeedSchedule() {
        System.out.println(this.getName() + " için yemek yeme zamanı");
    }
}
