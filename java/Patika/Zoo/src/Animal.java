abstract class Animal {
    private String typeName;
    private double weight;
    private int age;

    public Animal(String typeName, double weight, int age) {
        this.typeName = typeName;
        this.weight = weight;
        this.age = age;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void getDosage();
    public abstract void getFeedSchedule();
}
