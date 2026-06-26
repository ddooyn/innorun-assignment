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

            printAllStudents(classroom);

            while (true) {
                printMenu();
                System.out.print("\uD83D\uDC49 ");
                String command = scanner.nextLine().toLowerCase().trim();

                switch (command) {
                    case "a" -> printAllStudents(classroom);
                    case "t" -> printTopScoreStudent(classroom);
                    case "p" -> printPassedStudents(classroom);
                    case "u" -> updateStudentScoreById(classroom);
                    case "n" -> printStudentByNameKeyword(classroom);
                    case "q" -> {
                        return;
                    }
                    default -> System.out.println("⚠️ 존재하지 않는 명령어입니다.");
                }
            }
        } catch(IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private void printMenu() {
        System.out.println("""
            =================
            [a] 전체 학생 조회
            [t] 최고점 학생 조회
            [p] 합격자 조회
            [u] 학생 점수 수정
            [n] 이름 검색
            [q] 종료
            """);
    }

    private void updateStudentScoreById(Classroom classroom) {
        System.out.print("점수를 수정할 학생 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<Student> target = classroom.findById(id);

        if (target.isEmpty()) {
            System.out.println("⚠️ 조건에 맞는 학생을 찾을 수 없습니다. (id: " + id + ")");
            return;
        }

        System.out.print("점수: ");
        int score = scanner.nextInt();
        scanner.nextLine();

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

    private void printStudentByNameKeyword(Classroom classroom) {
        System.out.print("학생 이름: ");
        String keyword = scanner.nextLine().trim();
        List<Student> targets = classroom.searchByName(keyword);

        if (targets.isEmpty()) {
            System.out.println("⚠️ 조건에 맞는 학생을 찾을 수 없습니다. (name: " + keyword + ")");
            return;
        }

        targets.forEach(System.out::println);
    }
}
