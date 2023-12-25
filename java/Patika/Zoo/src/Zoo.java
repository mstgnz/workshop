public class Zoo {
    public static void main(String[] args) {
        Animal animal1 = new Horse("Tay", 210,8, "Bold Pilot");
        Animal animal2 = new Felines("Kaplan", 98.4,4, "Kaos");
        Animal animal3 = new Rodents("Fare",0.4,5,"Myke");

        animal1.getFeedSchedule();
        animal2.getFeedSchedule();
        animal3.getFeedSchedule();
        System.out.println();
        animal1.getDosage();
        animal2.getDosage();
        animal3.getDosage();

    }
}
