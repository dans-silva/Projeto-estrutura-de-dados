public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
  
    public Pessoa(String nome, String endereco, String telefone) {
      this.nome = nome;
      this.endereco = endereco;
      this.telefone = telefone;
    }
  
    public String getNome() {
      return nome;
    }
  
    public String getEndereco() {
      return endereco;
    }
  
    public String getTelefone() {
      return telefone;
    }

    public void imprimePessoa() {
    
    System.out.println("Nome: " + this.nome);
    System.out.println("Endereço: " + this.endereco);
    System.out.println("Telefone: " + this.telefone);
    }
  }
  
  
  /*public class Motorista extends Pessoa {
    private String numeroCNH;
    private double avaliacao;
    private String telefone;
    private String nome;
  
    public Motorista(String nome, String endereco, String telefone, String numeroCNH) {
      super(nome, endereco, telefone);
      this.numeroCNH = numeroCNH;
      this.avaliacao = 5.0; // Avaliação inicial do motorista é 5.0
    }
  
    /**
     * @param nome
     * @param cpf
     * @param telefone
     * @param cnh
     * @param modeloVeiculo
     * @param corVeiculo
     * @param placaVeiculo
     
    public Motorista(final String nome, String cpf, String telefone, String cnh, String modeloVeiculo, String corVeiculo,
            String placaVeiculo) {
                this.nome = nome;
                numeroCNH = nome;
                this.telefone = telefone;
    }

    public String getNumeroCNH() {
      return numeroCNH;
    }
  
    public double getAvaliacao() {
      return avaliacao;
    }
  
    public void atualizarAvaliacao(double novaAvaliacao) {
      this.avaliacao = novaAvaliacao;
    }

    public void imprimeMotorista() {
    */
    