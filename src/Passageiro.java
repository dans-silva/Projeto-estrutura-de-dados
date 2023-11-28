public class Passageiro extends Pessoa{
    String senha;
    String confirmeSenha;
    String pais;
    String estado;
    String cidade;

    public Passageiro(String senha, String confirmeSenha, String estado, String cidade, String nome, String cpf, String telefone){
        super(nome, cpf, telefone);
        this.senha = senha;
        this.confirmeSenha = confirmeSenha;
        this.estado = estado;
        this.cidade = cidade;
    
    }

        public void imprimePassageiro(){

            System.out.println("Digite sua senha: " + this.senha);
            System.out.println("Confirme sua senha: " + this.confirmeSenha);
            System.out.println("Digite seu estado: " + this.estado);
            System.out.println("Digite sua cidade: " + this.cidade);
            System.out.println("Passageiro cadastrado com sucesso!");



    }

}
