package org.practice;

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

//            TODO
        } finally {
            scanner.close();
        }
    }
}
