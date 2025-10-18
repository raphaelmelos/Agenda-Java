package org.example.view;

import org.example.controller.PessoaController;
import org.example.exception.ParametroInvalidoException;
import org.example.model.Pessoa;
import org.example.util.TecladoUtil;
import org.example.exception.AplicationException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import static org.example.controller.PessoaController.listar;
import static org.example.controller.PessoaController.removerContato;


public class Sistema {
    private static boolean sair = false;
    private static List<Pessoa> pessoas = new ArrayList<>();
    PessoaController pessoaController = new PessoaController();

    public static void criarLista() {
        pessoas.add(new Pessoa("Mikael", "54545546", "mikael@dauhau.com", LocalDate.of(1999, 2, 13)));
        pessoas.add(new Pessoa("Raphael", "54545546", "raphaemelosas41@gmail.com", LocalDate.of(1997, 3, 24)));
        pessoas.add(new Pessoa("Abner", "54sasas6", "abner@gmail.com", LocalDate.of(1989, 7, 2)));
    }


    public static void main(String[] args) throws AplicationException, InputMismatchException {

        Sistema.criarLista();

        while (!sair) {
            menu();
            int opcao = TecladoUtil.lerInt("Informe a opcao");
            executaAcao(opcao);
        }
    }

    private static void executaAcao(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    System.out.println("Adicionando contato...");
                    PessoaController.adicionarContato();
                    break;
                case 2:
                    System.out.println("Listando Pessoas...");
                    PessoaController.listar(pessoas);
                    break;
                case 3:
                    System.out.println("Removendo contato...");
                    PessoaController.removerContato();
                    break;
                case 4:
                    System.out.println("Alterar contato...");
                    PessoaController.alterarContato();
                    break;
                case 5:
                    PessoaController.listarContatosPorLetra();
                    System.out.println("Listar contatos por letra...");
                    break;
                case 6:
                    System.out.println("Data de aniverario...");
                    break;
                case 7:
                    sair = true;
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } catch (AplicationException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void menu() {
        System.out.println("---------------------------");
        System.out.println("Bem vindo ao menu da Agenda");
        System.out.println("---------------------------");
        System.out.println("1---Adicionar--------------");
        System.out.println("2---Listar contatos--------");
        System.out.println("3---Remover contato--------");
        System.out.println("4---Alterar contato--------");
        System.out.println("5---Listar contato por Letra-");
        System.out.println("6---Listar contato por Letra-");
        System.out.println("7---Sair-------------------");
    }


}


