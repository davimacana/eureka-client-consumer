package com.client.consumer.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.consumer.eureka.consumer.FraseDoDiaConsumer;

@Service
public class FraseDoDiaService {
	
	@Autowired
    private FraseDoDiaConsumer fraseDoDiaConsumer;

    public String getFraseDoDia(String nome) {
        String fraseDoDia = fraseDoDiaConsumer.getRandomFraseDoDia();
        return "Olá, " + nome + " a frase do dia hoje é: " + fraseDoDia;
    }
}
