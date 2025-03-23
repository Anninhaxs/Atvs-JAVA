import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class ItemBiblioteca {
    String titulo;
    int anoDePublicacao;
    int numCopiasDisponiveis;
    LocalDate dataDevolucao;

    ItemBiblioteca(String titulo, int anoDePublicacao, int numCopiasDisponiveis) {
        this.titulo = titulo;
        this.anoDePublicacao = anoDePublicacao;
        this.numCopiasDisponiveis = numCopiasDisponiveis;
        this.dataDevolucao = null;
    }

    public double calcularMulta(int atraso) {
        return atraso * 1.50;
    }

    public void verificarAtraso() {
        if (dataDevolucao == null) {
            System.out.println("O item '" + titulo + "' ainda não foi emprestado.");
            return;
        }

        LocalDate hoje = LocalDate.now();
        if (hoje.isAfter(dataDevolucao)) {
            long diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, hoje);
            double multa = calcularMulta((int) diasAtraso);
            System.out.println("O item '" + titulo + "' está atrasado " + diasAtraso + " dias.");
            System.out.println("Multa total: R$" + multa);
        } else {
            System.out.println("O item '" + titulo + "' foi devolvido no prazo.");
        }
    }

    public boolean emprestar(LocalDate dataDevolucao) {
        if (numCopiasDisponiveis > 0) {
            this.dataDevolucao = dataDevolucao;
            numCopiasDisponiveis--;
            System.out.println("Item '" + titulo + "' emprestado com sucesso!");
            return true;
        } else {
            System.out.println("Não há cópias disponíveis para empréstimo.");
            return false;
        }
    }

    public void devolver() {
        if (dataDevolucao == null) {
            System.out.println("Este item não foi emprestado.");
            return;
        }

        verificarAtraso();
        numCopiasDisponiveis++;
        dataDevolucao = null;
        System.out.println("Item '" + titulo + "' devolvido com sucesso!");
    }
}

class Livro extends ItemBiblioteca {
    String autor;

    Livro(String titulo, int anoDePublicacao, int numCopiasDisponiveis, String autor) {
        super(titulo, anoDePublicacao, numCopiasDisponiveis);
        this.autor = autor;
    }

    @Override
    public double calcularMulta(int atraso) {
        return atraso * 1.50;
    }
}
