import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MinhaClasseDAO dao = new MinhaClasseDAO();
        Scanner scanner = new Scanner(System.in);
        
        int opcao;
        
        do {
            System.out.println("1. Listar");
            System.out.println("2. Inserir");
            System.out.println("3. Excluir");
            System.out.println("4. Atualizar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    List<MinhaClasse> lista = dao.listar();
                    for (MinhaClasse objeto : lista) {
                        System.out.println(objeto.getId() + ", " + objeto.getNome() + ", " + objeto.getIdade());
                    }
                    break;
                // Implemente os outros cases para as opções restantes
            }
            
        } while (opcao != 5);
        
        scanner.close();
    }
}

