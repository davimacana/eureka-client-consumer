package com.client.consumer.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.consumer.eureka.service.FraseDoDiaService;

@RestController
@RequestMapping("/frase")
public class FraseDoDiaController {

	@Autowired
	private FraseDoDiaService fraseDoDiaService;

    @GetMapping("/{nome}")
    public String getFraseDoDia(@PathVariable String nome) {
        return fraseDoDiaService.getFraseDoDia(nome);
    }

}
