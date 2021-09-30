package com.bankAPI.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Data
@Setter
@Getter
public class CardDto {
    int id;
    String cardNumber;
}
