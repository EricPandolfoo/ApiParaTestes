package com.example.api.calculadora.controller;


import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class GerenciadorChamadas {


    @GetMapping(path = "/somar/{num1}/{num2}")
    public ResponseEntity<Integer> somar(@PathVariable("num1") Integer textA, @PathVariable("num2") Integer textB) {
        System.out.println("\nChamada de Soma recebida");
        Integer resultado = textA + textB;
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    @PostMapping(path = "/cargas")
    public ResponseEntity<String> cargas(@Valid @RequestBody String bodyRequest) throws JSONException {
        System.out.printf("\nChamada POST de cargas recebida" + "\nBody:\n");
        //System.out.println(bodyRequest);

        JSONArray json = new JSONArray(bodyRequest);
        System.out.println(json);

        return ResponseEntity.status(HttpStatus.OK).body(bodyRequest);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<String> listar() {
        System.out.printf("\nChamada GET de vagões disponíveis recebida");
        String retorno = "[{\n" +
                "\t\t\"codigo\": \"7153708\",\n" +
                "\t\t\"serie\": \"HFS\",\n" +
                "\t\t\"pesoMaximo\": 100000\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"codigo\": \"0524999\",\n" +
                "\t\t\"serie\": \"HFT\",\n" +
                "\t\t\"pesoMaximo\": 118000\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"codigo\": \"4501465\",\n" +
                "\t\t\"serie\": \"HFS\",\n" +
                "\t\t\"pesoMaximo\": 100000\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"codigo\": \"416848\",\n" +
                "\t\t\"serie\": \"HFT\",\n" +
                "\t\t\"pesoMaximo\": 118000\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"codigo\": \"87465132\",\n" +
                "\t\t\"serie\": \"HFS\",\n" +
                "\t\t\"pesoMaximo\": 100000\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"codigo\": \"2130846\",\n" +
                "\t\t\"serie\": \"HFT\",\n" +
                "\t\t\"pesoMaximo\": 124600\n" +
                "\t}\n" +
                "]";
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }

}
