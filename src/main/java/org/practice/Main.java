package org.practice;

import java.util.List;
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
            classroom.addStudent(new Student(4, "정다은", 75));

            updateStudentScoreById(classroom, 2, 96);
            printPassedStudents(classroom);
            printTopScoreStudent(classroom);

            printAllStudents(classroom);
            updateStudentScoreById(classroom, 99, 100);
            printStudentByNameKeyword(classroom, "김");
            printStudentByNameKeyword(classroom, "최");
            updateStudentScoreById(classroom, 4, 200);
        } catch(IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private void updateStudentScoreById(Classroom classroom, int id, int score) {
        Optional<Student> target = classroom.findById(id);

        if (target.isEmpty()) {
            System.out.println("⚠️ 조건에 맞는 학생을 찾을 수 없습니다. (id: " + id + ")");
            return;
        }

        target.get().updateScore(score);
        System.out.println("✅ 점수를 수정했습니다.");
    }

    private void printAllStudents(Classroom classroom) {
        classroom.getStudents().forEach(System.out::println);
    }

    private void printPassedStudents(Classroom classroom) {
        classroom.getPassedStudents().forEach(System.out::println);
    }

    private void printTopScoreStudent(Classroom classroom) {
        Optional<Student> top = classroom.findTopStudent();

        if (top.isEmpty()) {
            System.out.println("⚠️ " + "학생을 찾을 수 없습니다.");
            return;
        }

        System.out.println("최고점: " + top.get());
    }

    private void printStudentByNameKeyword(Classroom classroom, String keyword) {
        List<Student> targets = classroom.searchByName(keyword);

        if (targets.isEmpty()) {
            System.out.println("⚠️ 조건에 맞는 학생을 찾을 수 없습니다. (name: " + keyword + ")");
            return;
        }

        targets.forEach(System.out::println);
    }
}
