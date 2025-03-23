import java.time.LocalDate;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o ano de publicação: ");
        int anoDePublicacao = scanner.nextInt();

        System.out.print("Digite o número de cópias disponíveis: ");
        int numCopiasDisponiveis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();

        Livro livro = new Livro(titulo, anoDePublicacao, numCopiasDisponiveis, autor);


        System.out.print("Digite a data de devolução (YYYY-MM-DD): ");
        String dataString = scanner.nextLine();
        LocalDate dataDevolucao = LocalDate.parse(dataString);

        if (livro.emprestar(dataDevolucao)) {
            System.out.println("Agora o número de cópias disponíveis é: " + livro.numCopiasDisponiveis);
        }


        System.out.println("\nAgora simulamos a devolução...");
        livro.devolver();
        System.out.println("Número de cópias disponíveis após devolução: " + livro.numCopiasDisponiveis);

        scanner.close();
    }
}
