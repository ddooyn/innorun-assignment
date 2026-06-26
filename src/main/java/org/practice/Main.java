package org.practice;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final Scanner scanner;

    public Main() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        try {
            Classroom classroom = new Classroom();
            classroom.addStudent(new Student(1, "김하나", 87));
            classroom.addStudent(new Student(2, "이도윤", 92));
            classroom.addStudent(new Student(3, "박서준", 58));

            updateStudentScoreById(classroom, 2, 96);
            printPassedStudents(classroom);
            printTopStudent(classroom);

        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public void updateStudentScoreById(Classroom classroom, int id, int score) {
        Optional<Student> target = classroom.findById(id);

        if (target.isEmpty()) {
            System.out.println("학생을 찾을 수 없습니다.");
            return;
        }

        target.get().updateScore(score);
        System.out.println("점수를 수정했습니다.");
    }

    public void printPassedStudents(Classroom classroom) {
        classroom.getPassedStudents().forEach(System.out::println);
    }

    public void printTopStudent(Classroom classroom) {
        Optional<Student> top = classroom.findTopStudent();

        if (top.isEmpty()) {
            System.out.println("학생을 찾을 수 없습니다.");
            return;
        }

        System.out.println("최고점: " + top.get());
    }
}
