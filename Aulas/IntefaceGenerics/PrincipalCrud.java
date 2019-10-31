package Aulas.IntefaceGenerics;

import java.util.Arrays;

public class PrincipalCrud {
    public static void main(String[] args) {
        RepositorioDeLoja rl = new RepositorioDeLoja();
        rl.inserir(new Loja(1, "BestCode", "Rua x"));
        rl.inserir(new Loja(2, "Magazine", "Rua z"));

        RepositorioDeProduto rp = new RepositorioDeProduto();
        rp.inserir(new Produto(1, "Mouse"));
        rp.inserir(new Produto(2, "Teclado"));

        RepositorioDeEvento re = new RepositorioDeEvento();
        re.inserir(new Evento(2019, "Copa TV Sergipe de Futsal", "TV Sergipe"));

        System.out.println(Arrays.toString(rl.listar()));
        System.out.println(Arrays.toString(rp.listar()));
        System.out.println(Arrays.toString(re.listar()));

        System.out.println(re.buscar(2019));


    }
}
