package com.bankAPI.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class ArrayOfCardsDto {
    List<CardDto> cards;
}
