package com.blogApp.springbootbasic.service;

import com.blogApp.springbootbasic.domain.Post;
import com.blogApp.springbootbasic.repository.PostRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostRepository {
    private JdbcTemplate jdbcTemplate;

    public PostService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addPost(Post post) {
        String SQL= """
                INSERT INTO posts(TITLE,DESCRIPTION,BODY,POST_STATUS,CREATE_ON,UPDATE_ON)
                VALUES(?,?,?,?,?,?)
                """;
        jdbcTemplate.update(SQL,post.getTitle(),
        post.getDescription(),post.getBody(),
        post.getStatus(),post.getCreatedOn(),post.getUpdatedOn());


    }

    @Override
    public List<Post> getPost() {
        String SQL="SELECT *FROM posts";
        return jdbcTemplate.query(SQL,(rs,rowNum)->{
            Post post= new Post();
            post.setId(rs.getInt("ID"));
            post.setTitle(rs.getString("Title"));
            post.setDescription(rs.getString("DESCRIPTION"));
            post.setBody(rs.getString("BODY"));
            return post;

        });

    }

    @Override
    public Post getPostById(Integer id) {
        String SQL ="SELECT *FROM POSTS WHERE ID=?";
        return  jdbcTemplate.query(SQL,rs -> {
            Post post=null;
            if(rs.next()){
                post=new Post();
                post.setId(rs.getInt("ID"));
                post.setTitle(rs.getString("Title"));
                post.setDescription(rs.getString("DESCRIPTION"));
                post.setBody(rs.getString("BODY"));
            }
            return post;
        },id);

    }

    @Override
    public int removePostById(Integer id) {
        String SQL="DELETE FROM POSTS WHERE ID =? ";
        return jdbcTemplate.update(SQL,id);

    }

    @Override
    public void updatePostById(Integer id, Post post) {
        String SQL="UPDATE POSTS SET TITLE=?,DESCRIPTION=?,BODY=? WHERE ID=?";
        jdbcTemplate.update(SQL,post.getTitle(),post.getDescription(),post.getBody(),id);

    }

    @Override
    public Post getPostByid(Integer id) {
        String SQL = "SELECT * FROM POSTS WHERE  ID=?";
        return jdbcTemplate.query(SQL,rs->{
            Post post = null;
            if (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("ID"));
                post.setTitle(rs.getString("TITLE"));
                post.setDescription(rs.getString("DESCRIPTION"));
                post.setBody(rs.getString("BODY"));
            }
            return post;
        },id);

    }


}
