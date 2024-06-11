package com.ohgiraffers.associationmapping.section03.bidirection;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BidirectionService {

    private BidirectionRepository bidirectionRepository;
    public BidirectionService(BidirectionRepository bidirectionRepository){
        this.bidirectionRepository = bidirectionRepository;
    }

    // @ManyToOne  이기 때문에 @Transactional 필요 없음
    public Menu findMenu(int menuCode) {

        return bidirectionRepository.findMenu(menuCode);

    }


    /*    @Transactional 붙인 이유는 @OneToMany 이기 때문이다 */
    @Transactional
    public Category findCategory(int categoryCode) {

        Category foundCategory = bidirectionRepository.findCategory(categoryCode);
        System.out.println("[category menuList] : " + foundCategory.getMenuList());
        return  foundCategory;
    }

    @Transactional
    public void registMenu(Menu menu) {

        bidirectionRepository.saveMenu(menu);
    }

    @Transactional
    public void registCategory(Category category) {
        bidirectionRepository.saveCategory(category);
    }
}
