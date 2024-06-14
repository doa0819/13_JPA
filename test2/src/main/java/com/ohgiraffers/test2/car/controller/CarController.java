package com.ohgiraffers.test2.car.controller;

import com.ohgiraffers.test2.car.model.dto.CarDTO;
import com.ohgiraffers.test2.car.model.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


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

        return "redirect:/car/list";

    }

    @GetMapping("/list")
    public String findAllCar(Model model){

        List<CarDTO> carList = carService.findAllCar();
        model.addAttribute("carList", carList);

        return "car/list";

    }

    @PostMapping("/modify/{carNo}")
    public String modifyCar(@PathVariable int carNo, Model model){

        CarDTO resultCar = carService.findCarByNo(carNo);
        model.addAttribute("car", resultCar);


        return "car/modify";


    }



}
