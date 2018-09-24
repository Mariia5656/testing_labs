package mmf.test.lab_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student student1=new Student("Мария", "Апанасевич", 3, new int[]{7, 10, 8, 7});
        Student student2=new Student("Иван", "Шишкарев", 3, new int[]{5, 8, 8});
        Student student3=new Student("Володя", "Сидаров", 3, new int[]{8, 3});
        Student student4=new Student("Евгения", "Петрова", 3, new int[]{8,8,8});
        Student student5=new Student("Ирина","Долгая",3,new int[]{4,5,10});
        System.out.println(student1+"Средний балл: "+student1.getAverageRating()+"\n");
        System.out.println(student2+"Средний балл: "+student2.getAverageRating()+"\n");
        System.out.println(student3+"Средний балл: "+student3.getAverageRating()+"\n");
        System.out.println(student4+"Средний балл: "+student4.getAverageRating()+"\n");
        System.out.println(student5+"Средний балл: "+student5.getAverageRating()+"\n");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        Group group = new Group(1, students);
        System.out.println(group+"Общий средний балл: "+group.getAverageRatingOfGroup());

    }
}
