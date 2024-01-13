package com.blogApp.springbootbasic.repository;

import com.blogApp.springbootbasic.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository {
    void addPost(Post post);
    List<Post>getPost();
    Post getPostById(Integer id);
    int removePostById(Integer id);
    void updatePostById(Integer id,Post post);

    Post getPostByid(Integer id);


}

