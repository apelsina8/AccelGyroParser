package ru.lab.lab2;

public class Employee {

    private double time;
    private int acc_x;
    private int acc_y;
    private int acc_z;
    private int gyro_x;
    private int gyro_Y;
    private int gyro_z;


    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getAcc_x() {
        return acc_x;
    }

    public void setAcc_x(int acc_x) {
        this.acc_x = acc_x;
    }

    public int getAcc_y() {
        return acc_y;
    }

    public void setAcc_y(int acc_y) {
        this.acc_y = acc_y;
    }

    public int getAcc_z() {
        return acc_z;
    }

    public void setAcc_z(int acc_z) {
        this.acc_z = acc_z;
    }

    public int getGyro_x() {
        return gyro_x;
    }

    public void setGyro_x(int gyro_x) {
        this.gyro_x = gyro_x;
    }

    public int getGyro_Y() {
        return gyro_Y;
    }

    public void setGyro_Y(int gyro_Y) {
        this.gyro_Y = gyro_Y;
    }

    public int getGyro_z() {
        return gyro_z;
    }

    public void setGyro_z(int gyro_z) {
        this.gyro_z = gyro_z;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "time=" + time +
                ", acc_x=" + acc_x +
                ", acc_y=" + acc_y +
                ", acc_z=" + acc_z +
                ", gyro_x=" + gyro_x +
                ", gyro_Y=" + gyro_Y +
                ", gyro_z=" + gyro_z +
                '}';
    }
}
