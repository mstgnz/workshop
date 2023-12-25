public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;
    private double tax;
    private double bonus;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    // Maaşa uygulanan vergiyi hesaplayacaktır.
    // Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
    // Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.
    public double tax(){
        if(this.salary > 1000){
            return this.salary * 0.03;
        }
        return 0;
    }

    // Haftada 40 saatten fazla çalışıldığında saat başına 30 TL olacak şekilde maaşa uygulanacak bonus ücretleri hesaplayacaktır.
    public double bonus(){
        if(this.workHours > 40){
            return (this.workHours - 40) * 30;
        }
        return 0;
    }

    // Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır. Şuan ki yılı 2021 olarak alın.
    // Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
    // Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
    // Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.
    public double raiseSalary(){
        int diff = 2021 - this.hireYear;
        if(diff < 10){
            return this.salary * 0.05;
        }else if(diff < 20){
            return this.salary * 0.10;
        }else {
            return this.salary * 0.15;
        }
    }

    @Override
    public String toString() {
        return "Adı : "+ this.name+"\n" +
                "Maaş : "+this.salary+"\n" +
                "Çalışma Saati : "+this.workHours+"\n" +
                "Başlangıç Yılı : "+this.hireYear+"\n" +
                "Vergi : "+this.tax()+"\n" +
                "Bonus : "+this.bonus()+"\n" +
                "Maaş artışı : "+ this.raiseSalary()+"\n" +
                "Vergi ve Bonuslar ile birlikte maaş : "+ (this.salary - this.tax() + this.bonus())+"\n" +
                "Toplam Maaş : "+ (this.salary - this.tax() + this.bonus() + this.raiseSalary());
    }
}
