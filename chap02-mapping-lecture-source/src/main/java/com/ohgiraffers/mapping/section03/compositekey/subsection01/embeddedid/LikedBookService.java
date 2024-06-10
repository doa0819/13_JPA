package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikedBookService {

    @Autowired
    private LikeRepository likeRepository;

    @Transactional
    public void generateLikeBook(LikeDTO likeDTO){

        Like like = new Like(
                // Like 안에 LikedCompositeKey 가 필드로 생성
                new LikedCompositeKey(
                        // LikedCompositeKey 안에 LikedMemberNo,LikedBookNo 가 필드로 생성 되어 있다.
                        new LikedMemberNo(likeDTO.getLikedMemberNo()),
                        new LikedBookNo(likeDTO.getLikedBookNo())
                )

        );

        likeRepository.save(like);
    }
}
