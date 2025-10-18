package org.example.model.service;

import org.example.controller.PessoaController;
import org.example.model.Pessoa;
import org.example.util.TecladoUtil;

import java.util.ArrayList;
import java.util.List;

public class PessoaService {

    private static List<Pessoa> pessoas = new ArrayList<>();

    public static void adicionarPessoa(Pessoa p){
        pessoas.add(p);
    }

    public static void buscarPorLetra(){
        String letra = TecladoUtil.lerString("Digite sua letra");
        PessoaController.listarContatosPorLetra(letra);
    }

    
}
