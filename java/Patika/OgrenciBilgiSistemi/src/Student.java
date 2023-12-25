public class Student {
    String name,stuNo;
    int classes;
    Course math, physics, chemistry;
    double average;
    boolean isPass;

    Student(String name, int classes, String stuNo, Course math, Course physics, Course chemistry) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.isPass = false;
        calcAvarage();
    }

    public void addBulkExamNote(int math, int physics, int chemistry) {

        if (math >= 0 && math <= 100) {
            this.math.examNote = math;
        }

        if (physics >= 0 && physics <= 100) {
            this.physics.examNote = physics;
        }

        if (chemistry >= 0 && chemistry <= 100) {
            this.chemistry.examNote = chemistry;
        }

    }

    public void addBulkVerbalNote(int math, int physics, int chemistry) {

        if (math >= 0 && math <= 100) {
            this.math.verbalNote = math;
        }

        if (physics >= 0 && physics <= 100) {
            this.physics.verbalNote = physics;
        }

        if (chemistry >= 0 && chemistry <= 100) {
            this.chemistry.verbalNote = chemistry;
        }

    }

    public void isPass() {
        if (this.math.examNote == 0 || this.physics.examNote == 0 || this.chemistry.examNote == 0 ||
                this.math.verbalNote == 0 || this.physics.verbalNote == 0 || this.chemistry.verbalNote == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.average);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        double examAverage = this.math.examNote * this.math.examRate;
        examAverage += this.physics.examNote * this.physics.examRate;
        examAverage += this.chemistry.examNote * this.chemistry.examRate;
        double verbalAverage = this.math.verbalNote * this.math.verbalRate;
        verbalAverage += this.physics.verbalNote * this.physics.verbalRate;
        verbalAverage += this.chemistry.verbalNote * this.chemistry.verbalRate;
        this.average = (examAverage + verbalAverage) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.average > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Sınav : " + this.math.examNote + " Sözlü : "+ this.math.verbalNote);
        System.out.println("Fizik Sınav : " + this.physics.examNote + " Sözlü : "+ this.physics.verbalNote);
        System.out.println("Kimya Sınav : " + this.chemistry.examNote + " Sözlü : "+ this.chemistry.verbalNote);
    }

}