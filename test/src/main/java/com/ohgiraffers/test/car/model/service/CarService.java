package com.ohgiraffers.test.car.model.service;

import com.ohgiraffers.test.car.entity.Car;

import com.ohgiraffers.test.car.model.dao.CarRepository;
import com.ohgiraffers.test.car.model.dto.CarDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    // private final 로 필드 선언 후 생성자 통해 주입(this) 받는 이유?
    // -> 불변성 보장(한번 초기화 하면 변경할 수 없음), 의존성주입명확(해당 클래스에 필요한 의존성 명확히 하기 위해)
    //    코드의 안정성, 가독성(코드의 의도 쉽게 파악)이 좋아짐

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;


    @Autowired
    private CarService(CarRepository carRepository, ModelMapper modelMapper){
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;

    }

//    @Transactional
//    public void registCar(CarDTO newCar){
//
//        Car car = new Car(
//                newCar.getCarNo(),
//                newCar.getCarName(),
//                newCar.getCarPurpose(),
//                newCar.getCarReservationDate(),
//                newCar.getCarReturnDueDate(),
//                newCar.getCarRentalStatus()
//        );
//
//        carRepository.save(car);
//
//
//    }


    @Transactional
    public void registCar(CarDTO carDTO) {

        carRepository.save(modelMapper.map(carDTO, Car.class));
    }
}
