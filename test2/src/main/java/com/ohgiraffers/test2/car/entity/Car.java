package com.ohgiraffers.test2.car.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_car")
public class Car {


    @Id
    @Column(name = "car_no")
    private int carNo;
    @Column(name = "car_name")
    private String carName;
    @Column(name = "car_purpose")
    private String carPurpose;
    @Column(name = "car_reservation_date")
    private LocalDate carReservationDate;
    @Column(name = "car_return_due_date")
    private LocalDate carReturnDueDate;
    @Column(name = "car_rental_status")
    private String carRentalStatus;

    public Car() {
    }

    public Car(int carNo, String carName, String carPurpose, LocalDate carReservationDate, LocalDate carReturnDueDate, String carRentalStatus) {
        this.carNo = carNo;
        this.carName = carName;
        this.carPurpose = carPurpose;
        this.carReservationDate = carReservationDate;
        this.carReturnDueDate = carReturnDueDate;
        this.carRentalStatus = carRentalStatus;
    }



    public int getCarNo() {
        return carNo;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarPurpose() {
        return carPurpose;
    }

    public LocalDate getCarReservationDate() {
        return carReservationDate;
    }

    public LocalDate getCarReturnDueDate() {
        return carReturnDueDate;
    }

    public String getCarRentalStatus() {
        return carRentalStatus;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", carNo=" + carNo +
                ", carName='" + carName + '\'' +
                ", carPurpose='" + carPurpose + '\'' +
                ", carReservationDate=" + carReservationDate +
                ", carReturnDueDate=" + carReturnDueDate +
                ", carRentalStatus='" + carRentalStatus + '\'' +
                '}';
    }
}
