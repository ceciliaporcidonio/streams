import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        // Leitura de pessoas no formato Nome, Sexo (M ou F)
        System.out.println("Digite o nome e o sexo (M ou F) das pessoas. Digite 'sair' para encerrar.");

        while (true) {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }
            System.out.print("Digite o sexo (M ou F): ");
            String sexo = scanner.nextLine().toUpperCase();

            if (!sexo.equals("M") && !sexo.equals("F")) {
                System.out.println("Sexo inválido. Digite novamente.");
                continue;
            }

            pessoas.add(new Pessoa(nome, sexo));
        }

        // Filtragem das mulheres (sexo F) usando Lambda e Streams
        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equals("F"))
                .collect(Collectors.toList());

        // Imprimindo a lista de mulheres
        System.out.println("Lista de mulheres:");
        mulheres.forEach(System.out::println);
    }
}
