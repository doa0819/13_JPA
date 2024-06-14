package com.ohgiraffers.test.car.controller;

import com.ohgiraffers.test.car.model.dto.CarDTO;
import com.ohgiraffers.test.car.model.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/regist")
    public void registCarPage(){}

    @PostMapping("/regist")
    public String registCar(CarDTO carDTO){

        carService.registCar(carDTO);

        return "redirect:/car/regist";

    }


}
