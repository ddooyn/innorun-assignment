package org.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Classroom {
    private final List<Student> students;

    public Classroom() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Optional<Student> findById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }

    public List<Student> getPassedStudents() {
        return students.stream().filter(s -> s.getPassStatus() == PassStatus.PASSED).toList();
    }

    public Optional<Student> findTopStudent() {
        if (students.isEmpty()) return Optional.empty();

        Student top = students.getFirst();
        for (Student s : students) {
            if (s.getScore() > top.getScore()) top = s;
        }
        return Optional.of(top);
    }

    public List<Student> searchByName(String name) {
        return students.stream().filter(s -> s.getName().contains(name)).toList();
    }
}
