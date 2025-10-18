import org.example.controller.PessoaController;
import org.example.model.Pessoa;
import org.example.model.service.PessoaService;
import org.example.view.Sistema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.security.Provider;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClasseTest {

    public static List<Pessoa> pessoas = new ArrayList<>();
    Pessoa p = new Pessoa("Raphael", "54545546", "raphaemelosas41@dauhau", LocalDate.of(1999,2,23));
    @Test
    void testarAdicionarPessoa() {
        p.setNome("Raphael");
        p.setTelefone("312121212");
        p.setDataNascimento(LocalDate.of(1999, 3, 2));

        PessoaController.adicionarNaLista(p);

        assertTrue(PessoaController.pessoas.contains(p), "Pessoa adicionada, OK");
    }

    @Test
    void testarListagemdePessoas() {

        PessoaController.criarLista();
        PessoaController.adicionarNaLista(p);
        PessoaController.listar(pessoas);


        assertTrue(PessoaController.pessoas.contains(p), "Pessoa dentro da lista, OK");


    }

    @Test
    void testaRemoverContato() {
        PessoaController.adicionarNaLista(p);

        PessoaController.listar(pessoas);

        assertTrue(!pessoas.contains(p), "Contato removido, OK");


    }

    @Test
    void testaListarPorLetra() {
        PessoaService.adicionarPessoa(p);
        pessoas.add(p);
        PessoaController.listarContatosPorLetra("R");

        assertTrue(pessoas.contains(p), "Contato pesquisado é igual ao encontrado");


    }

    @Test
    void testaAlterarContato() {

    }


}

