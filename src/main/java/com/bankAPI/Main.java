package com.bankAPI;

import com.bankAPI.service.CardService;
import com.bankAPI.service.ConfigDb;
import com.bankAPI.util.numberGenerator;

import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        ConfigDb.setDefaultConfigDb();

        System.out.println(CardService.getAllCards());

    }
}
