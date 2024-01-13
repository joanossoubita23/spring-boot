package com.blogApp.springbootbasic.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.stream.events.Comment;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Post {

    private  Integer id;
    @NotNull
    @Size(min=3,max=50,message = "Title must be min 3 character and max 50")
    private  String title;
    @NotNull
    @Size(min=3,max = 500,message = "Description must be minimum 3 character and maximum 5000 characters")
    private  String description;
    private  String body;
    private  PostStatus status;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<Comment> comments;



}
