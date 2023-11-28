
public class Cliente extends Pessoa {
    private String email;
    private String cpf;
    
    public Cliente(String nome, String cpf, String email, String endereco, String telefone) {
      super(nome, endereco, telefone);
      this.email = email;
      this.cpf = cpf;
    }
    
    public String getEmail() {
      return email;
    }
    public void imprimeCliente(){
      super.imprimePessoa();
      System.out.println("cpf: " + this.cpf);
      System.out.println("Email: " + this.email);
      System.out.println("Cliente cadastrado com sucesso!");



    }

    public String getCpf() {
        return null;
    }
  }