package org.example.view;

import org.example.controller.PessoaController;
import org.example.exception.ParametroInvalidoException;
import org.example.model.Pessoa;
import org.example.util.TecladoUtil;
import org.example.exception.AplicationException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.example.controller.PessoaController.listar;
import static org.example.controller.PessoaController.removerContato;


public class Sistema {
    private static boolean sair = false;
    public static List<Pessoa> pessoas = new ArrayList<>();

    public static void criarLista() {
        pessoas.add(new Pessoa("Mikael", "54545546", "raphaemelo41@dauhau", LocalDate.of(1999, 2, 23)));
        pessoas.add(new Pessoa("Raphael", "54545546", "raphaemelosas41@dauhau", LocalDate.of(1999, 2, 24)));
    }


    public static void main(String[] args) {

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
                    adicionarContato();
                    break;
                case 2:
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
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opcao inválida!");
                    break;
            }
        } catch (AplicationException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void menu() {
        System.out.println("bem vindo ao menu da Agenda");
        System.out.println("---------------------------");
        System.out.println("1---Adicionar--------------");
        System.out.println("2---Listar contatos-------");
        System.out.println("3---Remover contato---------");
        System.out.println("4---Alterara contato------");
        System.out.println("5---Aniversáriantes-do-mês-");
        System.out.println("6---Sair-------------------");
    }

    private static void adicionarContato() throws AplicationException, ParametroInvalidoException {
        Pessoa p = new Pessoa();
        try {
            p.setNome(TecladoUtil.lerString("Digite o nome:"));

            p.setTelefone(TecladoUtil.lerString("Digite o telefone: "));

            int dia = TecladoUtil.lerInt("Dia de nascimento:");
            int mes = TecladoUtil.lerInt("Mês de nascimento");
            int ano = TecladoUtil.lerInt("Ano de nascimento");
            p.setDataNascimento(dia, mes, ano);

        } catch (ParametroInvalidoException e) {
            System.out.println("Nome, Telefone, email Incorretos ");
            adicionarContato();
        }
        p.setEmail(TecladoUtil.lerString("Digite o email: "));

        pessoas.add(p);

    }

    public static void adicionarContato(Pessoa p) {
        pessoas.add(p);
    }



}


