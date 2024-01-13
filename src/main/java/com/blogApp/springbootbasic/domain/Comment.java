package com.blogApp.springbootbasic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Comment {
    private  Integer id;
    private String title;
    private  String authorName;
    private  String body;
    private LocalDate createdOn;
   private  LocalDateTime updatedOn;
}
