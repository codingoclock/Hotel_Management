package com.prakharSinghJPA.Hotel_Management.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenderCountResponseEntity {
    private String gender;
    private Long id;
}
