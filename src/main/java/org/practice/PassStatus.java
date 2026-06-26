package org.practice;

public enum PassStatus {
    PASSED("합격"),
    FAILED("불합격");

    private final String label;

    PassStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
