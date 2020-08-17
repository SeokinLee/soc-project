/*
package com.seokin.book.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seokin.book.springboot.domain.posts.Posts;
import com.seokin.book.springboot.domain.posts.PostsRepository;
import com.seokin.book.springboot.web.dto.PostsSaveRequestDto;
import com.seokin.book.springboot.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// For mockMvc

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    //@WithMockUser(roles="USER")
    public void Posts_등록된다() throws Exception {
        //given
        String device_nm = "device_nm";
        String serial_no = "serial_no";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .device_nm("device_nm")
                .serial_no("serial_no")
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getDevice_nm()).isEqualTo(device_nm);
        assertThat(all.get(0).getSerial_no()).isEqualTo(serial_no);
    }

    @Test
    //@WithMockUser(roles="USER")
    public void Posts_수정된다() throws Exception {
        //given
        Posts savedPosts = postsRepository.save(Posts.builder()
                .device_nm("device_nm")
                .serial_no("serial_no")
                .build());

        Long updateId = savedPosts.getId();
        String expectedDevice_nm = "device_nm2";
        String expectedSerial_no = "serial_no2";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .device_nm(expectedDevice_nm)
                .serial_no(expectedSerial_no)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        //when
        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getDevice_nm()).isEqualTo(expectedDevice_nm);
        assertThat(all.get(0).getSerial_no()).isEqualTo(expectedSerial_no);
    }
}*/