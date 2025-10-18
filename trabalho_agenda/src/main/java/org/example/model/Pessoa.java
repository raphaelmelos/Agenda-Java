package org.example.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dia, int mes, int ano) {
        try {
            this.dataNascimento = LocalDate.of(dia, mes, ano);
        } catch (Exception e){

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(telefone, pessoa.telefone) && Objects.equals(email, pessoa.email) && Objects.equals(dataNascimento, pessoa.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, email, dataNascimento);
    }

    @Override
    public String toString() {
        return
                " \n " +
                        " \n Nome = " + nome +
                        " \n Telefone = " + telefone +
                        " \n Email = " + email +
                        " \n DataNascimento = " + dataNascimento +
                        " \n ";
    }

    public void setDataNascimento(LocalDate of) {

    }
}
