package com.ohgiraffers.test2.car.model.dto;

import java.time.LocalDate;

public class CarDTO {

    private int carNo;
    private String carName;
    private String carPurpose;
    private LocalDate carReservationDate;
    private LocalDate carReturnDueDate;
    private String carRentalStatus;

    public CarDTO() {
    }


    public int getCarNo() {
        return carNo;
    }

    public void setCarNo(int carNo) {
        this.carNo = carNo;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPurpose() {
        return carPurpose;
    }

    public void setCarPurpose(String carPurpose) {
        this.carPurpose = carPurpose;
    }

    public LocalDate getCarReservationDate() {
        return carReservationDate;
    }

    public void setCarReservationDate(LocalDate carReservationDate) {
        this.carReservationDate = carReservationDate;
    }

    public LocalDate getCarReturnDueDate() {
        return carReturnDueDate;
    }

    public void setCarReturnDueDate(LocalDate carReturnDueDate) {
        this.carReturnDueDate = carReturnDueDate;
    }

    public String getCarRentalStatus() {
        return carRentalStatus;
    }

    public void setCarRentalStatus(String carRentalStatus) {
        this.carRentalStatus = carRentalStatus;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                ", carNo=" + carNo +
                ", carName='" + carName + '\'' +
                ", carPurpose='" + carPurpose + '\'' +
                ", carReservationDate=" + carReservationDate +
                ", carReturnDueDate=" + carReturnDueDate +
                ", carRentalStatus='" + carRentalStatus + '\'' +
                '}';
    }
}
