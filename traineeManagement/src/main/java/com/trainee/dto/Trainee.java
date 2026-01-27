package com.trainee.dto;

public class Trainee {

    private int traineeID;
    private String traineeName;
    private String branch;
    private double percentage;

    public Trainee(int traineeID, String traineeName, String branch, double percentage) {
        this.traineeID = traineeID;
        this.traineeName = traineeName;
        this.branch = branch;
        this.percentage = percentage;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "ID=" + traineeID + " Name=" + traineeName +
               " Branch=" + branch + " Percentage=" + percentage;
    }
}
