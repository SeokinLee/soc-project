package com.seokin.book.springboot.web;

import com.seokin.book.springboot.config.auth.LoginUser;
import com.seokin.book.springboot.config.auth.dto.SessionUser;
import com.seokin.book.springboot.service.PostsService;
import com.seokin.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    //메인 페이지
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index2";
    }

    //목록 페이지
    @GetMapping("/list")
    public String list(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "list";
    }

    //최적경로 페이지
    @GetMapping("/path")
    public String path(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "path";
    }

    //통계 페이지
    @GetMapping("/statistics")
    public String statistics(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "statistics";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }//post-save.mustache 호출

    @GetMapping("/posts/update/{id}")
    //Model : PostsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
