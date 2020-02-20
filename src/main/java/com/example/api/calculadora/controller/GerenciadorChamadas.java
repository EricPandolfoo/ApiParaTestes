package com.example.api.calculadora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/api/calculadora")
public class GerenciadorChamadas {


    @GetMapping(path = "/somar/{num1}/{num2}")
    public ResponseEntity<Integer> somar(@PathVariable("num1") Integer textA, @PathVariable("num2") Integer textB) {
        System.out.println("\nChamada de Soma recebida");
        Integer resultado = textA + textB;
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    @PostMapping(path = "/cargas")
    public ResponseEntity<String> cargas(@Valid @RequestBody String bodyRequest) {
        System.out.printf("\nChamada POST de cargas recebida" + "\nBody:\n");
        System.out.println(bodyRequest);
        return ResponseEntity.status(HttpStatus.OK).body(bodyRequest);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<String> listar() {
        System.out.printf("\nChamada GET de vagões disponíveis recebida");
        String retorno = "[{\n" +
                "\t\"codigo\": \"codigo\",\n" +
                "\t\"peso\": \"peso\",\n" +
                "\t\"produto\": \"produto\",\n" +
                "\t\"data\": \"data\",\n" +
                "\t\"densidade\": \"densidade\"\n" +
                "}, {\n" +
                "\t\"codigo\": \"codigo\",\n" +
                "\t\"peso\": \"peso\",\n" +
                "\t\"produto\": \"produto\",\n" +
                "\t\"data\": \"data\",\n" +
                "\t\"densidade\": \"densidade\"\n" +
                "}, {\n" +
                "\t\"codigo\": \"codigo\",\n" +
                "\t\"peso\": \"peso\",\n" +
                "\t\"produto\": \"produto\",\n" +
                "\t\"data\": \"data\",\n" +
                "\t\"densidade\": \"densidade\"\n" +
                "}]";
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }

}
