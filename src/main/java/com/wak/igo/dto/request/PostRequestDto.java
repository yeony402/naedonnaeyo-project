package com.wak.igo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {


    private Long id;
    private String title;
    private String content;
    private String imgurl;
    private int time;
    private int amount;
    private String address;

    private String tag;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    //혹시나 몰라서


}