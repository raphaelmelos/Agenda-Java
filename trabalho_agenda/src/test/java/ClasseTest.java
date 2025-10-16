import org.example.model.Pessoa;
import org.example.view.Sistema;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClasseTest {
    @Test
    public void testarAdicionarPessoa(){
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa p = new Pessoa();
        p.setNome("Raphael");
        p.setTelefone("312121212");
        p.setDataNascimento(LocalDate.of(1999,3,2));

        Sistema.adicionarContato(p);

        assertTrue(Sistema.pessoas.contains(p), "Pessoa adicionada a lista");
    }

    public void testarListagemdePessoas(){

    }
}
