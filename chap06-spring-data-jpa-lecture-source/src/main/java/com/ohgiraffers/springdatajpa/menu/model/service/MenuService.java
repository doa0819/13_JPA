package com.ohgiraffers.springdatajpa.menu.model.service;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.model.dao.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.model.dao.MenuRepository;
import com.ohgiraffers.springdatajpa.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.model.dto.MenuDTO;
import jakarta.persistence.Temporal;
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
public class MenuService {

    private final MenuRepository repository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MenuService(MenuRepository repository, ModelMapper  modelMapper, CategoryRepository categoryRepository){
        this.repository = repository;
        this.modelMapper= modelMapper;
        this.categoryRepository =  categoryRepository;
    }

    /* 1. findById() */
    public MenuDTO findMenuByCode(int menuCode) {

        Menu foundMenu = repository.findById(menuCode).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(foundMenu, MenuDTO.class);

    }

    /* no paging 버전 메뉴 전체 조회 */
    public List<MenuDTO> findMenuList() {

        List<Menu> menuList = repository.findAll(Sort.by("menuCode").descending());

        // 반환 값이 MenuDTO 이기 때문에 엔티티 타입을 DTO 타입으로 변환 필요
        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))      // 여기서 Stream<MenuDTO> 로 변환
                .collect(Collectors.toList());          // List 타입인데 stream 으로 펼쳐놨기 때문에 List 로 변환
    }

    /* paging 버전 메뉴 전체 조회 */
    // 오버로딩 : 메소드의 시그니쳐 -> 메소드 이름이 같더라도 매개변수가 다르면 사용가능
    public Page<MenuDTO> findMenuList(Pageable pageable){

        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1,
                                  pageable.getPageSize(),
                                  Sort.by("menuCode").descending());

        Page<Menu> menuList = repository.findAll(pageable);

        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

    /* Query 메소드를 사용해서 조회하기 */
    public List<MenuDTO> findByMenuPrice(int menuPrice) {

//        List<Menu> menuList = repository.findByMenuPriceGreaterThan(menuPrice);
//        List<Menu> menuList = repository.findByMenuPriceGreaterThanOrderByMenuPrice(menuPrice);
        List<Menu> menuList = repository.findByMenuPriceGreaterThan(menuPrice, Sort.by("menuPrice").descending());


        return menuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
    }

    /* 5. @Query : JPQL Native Query */
    public List<CategoryDTO> findAllCategory() {

        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    // save() 등록 관련 메소드
    @Transactional
    public void registNewMenu(MenuDTO menuDTO) {

        // save 는 entity 를 받으니깐 우리는 현재 DTO 를 받고 있기 때문에 DTO -> entity 로 바꿔야 한다
        repository.save(modelMapper.map(menuDTO, Menu.class));

    }

    // 수정
    @Transactional
    public void modifyMenu(MenuDTO modifyMenu) {

        Menu foundMenu = repository.findById(modifyMenu.getMenuCode()).orElseThrow(IllegalArgumentException::new);

        /* 1. setter 사용해서 수정해보기  - setter 사용은 지양한다.*/
//        foundMenu.setMenuName(modifyMenu.getMenuName());

        /* 2. @Builder */
//        foundMenu = foundMenu.toBuilder().menuName(modifyMenu.getMenuName()).build();
//        repository.save(foundMenu);

        /* 3. Entity 클래스 내부에서 builder 패턴을 사용해서 구현 */
        foundMenu = foundMenu.menuName(modifyMenu.getMenuName()).builder();
        repository.save(foundMenu);
    }

    // 삭제
    @Transactional
    public void deleteMenu(int menuCode) {

        repository.deleteById(menuCode);
    }
}
