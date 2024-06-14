package com.ohgiraffers.test2.car.model.service;

import com.ohgiraffers.test2.car.entity.Car;
import com.ohgiraffers.test2.car.model.dao.CarRepository;
import com.ohgiraffers.test2.car.model.dto.CarDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CarService(CarRepository carRepository, ModelMapper modelMapper){
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;

    }


    @Transactional
    public void registCar(CarDTO carDTO) {

        carRepository.save(modelMapper.map(carDTO, Car.class));
    }

    public List<CarDTO> findAllCar() {

        // findAll -> carRepository class 에서 extends JpaRepository(Sort sort) 메소드에 이미 저장되어 있는 값이다.
        List<Car> carList = carRepository.findAll(Sort.by("carNo").descending());

        return carList.stream()
                .map(car -> modelMapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }

    public CarDTO findCarByNo(int carNo) {

        Car foundCar = carRepository.findById(carNo).orElseThrow(IllegalAccessError::new);

        return modelMapper.map(foundCar, CarDTO.class);
    }
}
