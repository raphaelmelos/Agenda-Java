package org.example.view;

import org.example.model.Pessoa;
import org.example.util.TecladoUtil;
import org.example.exception.AplicationException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Sistema {
    private static boolean sair = false;
    public static List<Pessoa> pessoas = new ArrayList<>();

    private static void criarLista() {
        pessoas.add(new Pessoa("Mikael", "54545546", "raphaemelo41@dauhau", LocalDate.of(23, 02, 1999)));
        pessoas.add(new Pessoa("Raphael", "54545546", "raphaemelosas41@dauhau", LocalDate.of(24, 02, 1979)));
    }


    public static void main(String[] args) {
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
                    listar(pessoas);
                    break;
                case 3:
                    System.out.println("Removendo contato...");
                    removerContato();
                    break;
                case 4:
                    alterarContato();
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

    private static void adicionarContato() throws AplicationException {
        Pessoa p = new Pessoa();
        try {
            p.setNome(TecladoUtil.lerString("Digite o nome:"));
            p.setTelefone(TecladoUtil.lerString("Digite o telefone: "));

            int dia = TecladoUtil.lerInt("Dia de nascimento:");
            int mes = TecladoUtil.lerInt("Mês de nascimento");
            int ano = TecladoUtil.lerInt("Ano de nascimento");
            p.setDataNascimento(dia, mes, ano);

        } catch (AplicationException e) {
            System.out.println("Nome, Telefone, email Incorretos ");
        }
        p.setEmail(TecladoUtil.lerString("Digite o email: "));

        pessoas.add(p);

    }

    public static void adicionarContato(Pessoa p) {
        pessoas.add(p);
    }


    private static void listar(List<Pessoa> pessoas) {
        System.out.println("Listando Pessoas da agenda...");
        pessoas.forEach(System.out::println);
        //queria tratar para caso não tenha ninguém na lista ele indicar
    }

    private static void removerContato() throws AplicationException {
        String nome = TecladoUtil.lerString("Digite o nome da pessoa que quer remover: ");
        boolean removido = false;

        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                pessoas.remove(i);
                removido = true;
                System.out.println(nome + " Removido ");

            }
        }
        if (!removido) {
            System.out.println("Pessoa não encontrada..");
        }
    }

    private static void alterarContato() {
        listar(pessoas);

        String nome = TecladoUtil.lerString("Digite o nome da pessoa que quer editar:");
        Pessoa pessoaEditada = null;
        for (Pessoa p : pessoas){
            if(p.getNome().equalsIgnoreCase(nome)){
                pessoaEditada = p;
                break;
            }
        }
        System.out.println("Editando nome "+pessoaEditada.getNome());

        String nomeEditado = TecladoUtil.lerString("Digite o nome: ");
        pessoaEditada.setNome(nomeEditado);


    }
}


