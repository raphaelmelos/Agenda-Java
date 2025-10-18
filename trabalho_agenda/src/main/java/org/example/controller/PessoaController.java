package org.example.controller;

import org.example.exception.AplicationException;
import org.example.exception.ParametroInvalidoException;
import org.example.model.Pessoa;
import org.example.model.service.PessoaService;
import org.example.util.TecladoUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;


public class PessoaController {

    public static List<Pessoa> pessoas = new ArrayList<>();
    PessoaService pessoaService = new PessoaService();

    public static void criarLista() {
        pessoas.add(new Pessoa("Mikael", "54545546", "raphaemelo41@dauhau", LocalDate.of(1999, 2, 23)));
        pessoas.add(new Pessoa("Raphael", "54545546", "raphaemelosas41@dauhau", LocalDate.of(1999, 2, 24)));
    }

    public static void alterarContato() {
        listar(pessoas);
        String nome = TecladoUtil.lerString("Digite o nome da pessoa que quer editar:");

        Pessoa pessoaEditada = pessoas.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);

        System.out.println("Editando nome " + pessoaEditada.getNome());

        String nomeEditado = TecladoUtil.lerString("Digite o nome: ");
        pessoaEditada.setNome(nomeEditado);

        String telefoneEditado = TecladoUtil.lerString("Digite o telefone: ");
        pessoaEditada.setTelefone(telefoneEditado);


        int dia = TecladoUtil.lerInt("Dia de nascimento:");
        int mes = TecladoUtil.lerInt("Mês de nascimento:  *Dois digitos*");
        int ano = TecladoUtil.lerInt("Ano de nascimento");
        pessoaEditada.setDataNascimento(dia, mes, ano);

        String emailEditado = TecladoUtil.lerString("Digite seu e-mail: ");
        pessoaEditada.setEmail(emailEditado);

    }

    public static void removerContato() throws AplicationException {

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
            System.out.println("Pessoa nao encontrada..");
        }
    }

    public static void listar(List<Pessoa> pessoas) {
        System.out.println("Listando Pessoas da agenda...");
        pessoas.stream().sorted(Comparator.comparing(Pessoa::getNome)).forEach(System.out::println);
        //pessoas.forEach(System.out::println);
        //queria tratar para caso não tenha ninguém na lista ele indicar
        if (pessoas.isEmpty()) {
            System.out.println("Lista vazia");
        }

    }


    public static void adicionarContato() throws AplicationException, ParametroInvalidoException {
        Pessoa p = new Pessoa();
        try {
            p.setNome(TecladoUtil.lerString("Digite o nome:"));

            p.setTelefone(TecladoUtil.lerString("Digite o telefone: "));

            int dia = TecladoUtil.lerInt("Dia de nascimento:");
            int mes = TecladoUtil.lerInt("Mes de nascimento");
            int ano = TecladoUtil.lerInt("Ano de nascimento");
            p.setDataNascimento(dia, mes, ano);

        } catch (InputMismatchException e) {
            System.out.println("Nome, Telefone, email Incorretos ");
            adicionarContato();
        }
        p.setEmail(TecladoUtil.lerString("Digite o email: "));

        pessoas.add(p);
        System.out.println("\n Contato salvo com sucesso!");

    }

    public static void adicionarNaLista(Pessoa p) {
        pessoas.add(p);
    }

    public static void listarContatosPorLetra(String letra) throws AplicationException, InputMismatchException {

        if (pessoas.contains(null)) {
            System.out.println("Lista vazia, nada para ver aqui");
        } else
            try {
                //String letra = TecladoUtil.lerString("Digite a letra inicial do nome do contato: ");


                pessoas.stream().filter(p -> p.getNome().toLowerCase().startsWith(letra.toLowerCase())).forEach(p -> System.out.println(
                        "nome" + p.getNome() + "telefone" + p.getTelefone() + "e-mail " + p.getEmail()));

                //estou filtrando, pegando minha Pessoa p, definindo lower case, iniciando quando, letra for chamada, e tranformando
                //em lower case. Fazendo um forEach para imprimir a pessoa e mostrando os dados pelo get

            } catch (NullPointerException e) {
                System.out.println("Digite um nome");
                //listarContatosPorLetra();
            }
    }
}