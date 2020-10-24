/*Posts 클래스로 database를 접근하게 해주는 DB Layer 접근자*/
/*Entity클래스와 Entity Repository는 항상 함께 위치*/
package com.seokin.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {//JpaRepository<Entity클래스, PK타입>
                                                                     // 기본적인 CRUD 메소드 자동 생성
    @Query("SELECT p FROM posts p ORDER BY p.id ASC")
    List<Posts> findAllDesc();


}