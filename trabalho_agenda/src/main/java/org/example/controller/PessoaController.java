package org.example.controller;

import org.example.exception.AplicationException;
import org.example.exception.ParametroInvalidoException;
import org.example.model.Pessoa;
import org.example.util.TecladoUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PessoaController {

    public static List<Pessoa> pessoas = new ArrayList<>();

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
            System.out.println("Pessoa não encontrada..");
        }
    }
    public static void listar(List<Pessoa> pessoas) {
        System.out.println("Listando Pessoas da agenda...");
        pessoas.forEach(System.out::println);
        //queria tratar para caso não tenha ninguém na lista ele indicar

    }
    public static void adicionarContato(Pessoa p) {
        pessoas.add(p);
    }

    public static void adicionarContato() throws AplicationException, ParametroInvalidoException {
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
}
