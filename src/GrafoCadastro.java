import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GrafoCadastro {
    private Map<String, Vertice> vertices;

    public GrafoCadastro() {
        this.vertices = new HashMap<>();
    }

    public void adicionarVertice(String chave, Vertice vertice) {
        vertices.put(chave, vertice);
    }

    public Vertice obterVertice(String chave) {
        return vertices.get(chave);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GrafoCadastro grafo = new GrafoCadastro();

        System.out.println("Bem-vindo ao sistema de cadastro!");

        do {
            System.out.println("Você deseja se cadastrar como motorista ou cliente?");
            System.out.print("Digite 'M' para motorista ou 'C' para cliente: ");
            String opcao = input.nextLine().toUpperCase();

            if (opcao.equals("M")) {
                cadastrarMotorista(input, grafo);
            } else if (opcao.equals("C")) {
                cadastrarCliente(input, grafo);
            } else {
                System.out.println("Opção inválida! Digite 'M' para motorista ou 'C' para cliente.");
            }
        } while (true); // Continua indefinidamente até que o usuário decida sair do programa.
    }

    private static void cadastrarMotorista(Scanner input, GrafoCadastro grafo) {
        System.out.println("Você escolheu se cadastrar como motorista.");

        System.out.print("Digite seu nome: ");
        String nome = input.nextLine();

        System.out.print("Digite seu telefone: ");
        String telefone = input.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = input.nextLine();

        System.out.print("Digite seu e-mail: ");
        String email = input.nextLine();

        System.out.print("Digite sua Carteira Nacional de Habilitação: ");
        String cnh = input.nextLine();

        System.out.print("Digite o modelo do seu veículo: ");
        String modeloVeiculo = input.nextLine();

        System.out.print("Digite a cor do seu veículo: ");
        String corVeiculo = input.nextLine();

        System.out.print("Digite a placa do seu veículo: ");
        String placaVeiculo = input.nextLine();

        Motorista motorista = new Motorista(nome, telefone, cpf, email, cnh, modeloVeiculo, corVeiculo, placaVeiculo);
        grafo.adicionarVertice(cpf, new Vertice(motorista));
        motorista.imprimeMotorista();
    }

    private static void cadastrarCliente(Scanner input, GrafoCadastro grafo) {
        System.out.println("Você escolheu se cadastrar como cliente.");

        System.out.print("Digite seu nome: ");
        String nome = input.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = input.nextLine();

        System.out.print("Digite seu e-mail: ");
        String email = input.nextLine();

        System.out.print("Digite seu endereço: ");
        String endereco = input.nextLine();

        System.out.print("Digite seu telefone: ");
        String telefone = input.nextLine();

        Cliente cliente = new Cliente(nome, cpf, email, endereco, telefone);
        grafo.adicionarVertice(cpf, new Vertice(cliente));
        cliente.imprimeCliente();

        System.out.print("Gostaria de realizar uma corrida? Digite '1' para sim ou '2' para não: ");
        String resposta = input.nextLine();

        if (resposta.equals("1")) {
            realizarCorrida(input, grafo, cliente);
        } else {
            System.out.println("Obrigado pela preferência!");
        }
    }

    private static void realizarCorrida(Scanner input, GrafoCadastro grafo, Cliente cliente) {
        System.out.print("Digite o Local de partida: ");
        String localPartida = input.nextLine();

        System.out.print("Digite o local de chegada: ");
        String chegada = input.nextLine();

        int distanciaEmKm = obterDistancia(input);

        Rota rota = new Rota(localPartida, chegada, distanciaEmKm);
        rota.calcularTempoDaCorrida(distanciaEmKm);
        rota.valorCorrida(distanciaEmKm);
        rota.imprimirRota();

        grafo.adicionarVertice(localPartida, new Vertice(new Local(localPartida)));
        grafo.adicionarVertice(chegada, new Vertice(new Local(chegada)));

        Aresta corrida = new Aresta(rota);
        grafo.obterVertice(cliente.getCpf()).adicionarAresta(grafo.obterVertice(localPartida).getId(), corrida);
        grafo.obterVertice(localPartida).adicionarAresta(grafo.obterVertice(chegada).getId(), corrida);

        Pagamento pagamento = new Pagamento();
        pagamento.pagarCorrida(rota.getValorCorrida());
    }

    private static int obterDistancia(Scanner input) {
        int distanciaEmKm = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("A distância em Km seria: ");
                distanciaEmKm = Integer.parseInt(input.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }

        return distanciaEmKm;
    }
}

class Vertice {
    private String id;
    private Object elemento;
    private Map<String, Aresta> arestas;

    public Vertice(Object elemento) {
        this.elemento = elemento;
        this.id = elemento.toString();
        this.arestas = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void adicionarAresta(String destino, Aresta aresta) {
        arestas.put(destino, aresta);
    }

    public Aresta obterAresta(String destino) {
        return arestas.get(destino);
    }

    public void removerAresta(String destino) {
        arestas.remove(destino);
    }

    public void imprimirElemento() {
        if (elemento instanceof Pessoa) {
            ((Pessoa) elemento).imprimePessoa();
        } else if (elemento instanceof Local) {
            System.out.println("Local: " + ((Local) elemento).getNome());
        }
    }
}

class Aresta {
    private Object elemento;

    public Aresta(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }
}

class Local {
    private String nome;

    public Local(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
