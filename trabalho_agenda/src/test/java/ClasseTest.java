import org.example.controller.PessoaController;
import org.example.model.Pessoa;
import org.example.view.Sistema;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClasseTest {

    public static List<Pessoa> pessoas = new ArrayList<>();
    Pessoa p = new Pessoa("Raphael", "54545546", "raphaemelosas41@dauhau", LocalDate.of(1999, 2, 24));

    @Test
    void testarAdicionarPessoa() {
        p.setNome("Raphael");
        p.setTelefone("312121212");
        p.setDataNascimento(LocalDate.of(1999, 3, 2));

        Sistema.adicionarContato(p);

        assertTrue(Sistema.pessoas.contains(p), "Pessoa adicionada a lista, OK");
    }

    @Test
    void testarListagemdePessoas() {
        Sistema.criarLista();
        PessoaController.listar(pessoas);

        assertTrue(pessoas.contains(p), "Pessoa dentro da lista, OK");


    }

    @Test
    void testaRemoverContato() {
        Sistema.adicionarContato(p);

        PessoaController.listar(pessoas);

        assertTrue(!pessoas.contains(p), "Contato removido, OK");


    }


}

