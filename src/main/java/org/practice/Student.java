package org.practice;

public class Student {
    private final int id;
    private final String name;
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0부터 100 사이의 정수여야 합니다.");
        }
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0부터 100 사이의 정수여야 합니다.");
        }
        this.score = score;
    }

    public PassStatus getPassStatus() {
        return score >= 60 ? PassStatus.PASSED : PassStatus.FAILED;
    }

    @Override
    public String toString() {
        return "Student " + id + " / " + name + " / " + score + "점 -> " + getPassStatus().getLabel();
    }
}
