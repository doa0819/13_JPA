package com.ohgiraffers.jpql.section07.namedquery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NamedQueryRepository {

    @PersistenceContext
    public EntityManager manager;

    public List<Menu> selectByDynamicQuery(String searchName, int searchCode) {
        // String : 문자열을 합치면 새로운 인스턴스를 생성한다(공간을 하나 더 만든다)
        // 예)
        // StringBuilder : 합친 거에 인스턴스가 계속 합쳐진다
        StringBuilder jpql = new StringBuilder("SELECT m FROM section07Menu m ");

        if (searchName != null && !searchName.isEmpty() && searchCode >0 ){
            // append : jpql 에 합친다
            jpql.append("WHERE ");
            jpql.append("m.menuName LIKE '%' || :menuName || '%'");
            jpql.append("AND ");
            jpql.append("m.categoryCode = :categoryCode");
        }else {
            if (searchName != null && !searchName.isEmpty()){
                jpql.append("WHERE ");
                jpql.append("m.menuName LIKE '%' || :menuName || '%'");
            }else if(searchCode > 0){
                jpql.append("WHERE ");
                jpql.append("m.categoryCode = :categoryCode");
            }
        }

        TypedQuery<Menu> query = manager.createQuery(jpql.toString(), Menu.class);
        if (searchName != null && !searchName.isEmpty() && searchCode > 0){
            query.setParameter("menuName", searchName);
            query.setParameter("categoryCode", searchCode);
        }else {
            if (searchName != null && !searchName.isEmpty()){
                query.setParameter("menuName", searchName);
            } else if (searchCode > 0) {
                query.setParameter("categoryCode", searchCode);

            }
        }

        List<Menu> menuList = query.getResultList();

        return menuList;
    }

    public List<Menu> selectByNamedQuery() {

        List<Menu> menuList = manager.createNamedQuery("section07Manu.selectMenuList", Menu.class).getResultList();

        return  menuList;
    }


    public List<Menu> selectSingleNamedQuery(String menuName, int categoryCode) {

        List<Menu> menuList = manager.createNamedQuery("section07Manu.selectMenuList2", Menu.class)
                .setParameter("menuName", menuName)
                .setParameter("categoryCode", categoryCode)
                .getResultList();

        return menuList;
    }
}
