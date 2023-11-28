public class Motorista extends Pessoa{
    String cnh;
    String modeloVeiculo;
    String corVeiculo;
    String placaVeiculo;
    String email;
    //Construtor de motorista

    public Motorista(String nome, String telefone, String cpf, String email, String cnh, String modeloVeiculo, String corVeiculo, String placaVeiculo){
        super(nome, cpf, telefone);
        this.cnh = cnh;
        this.modeloVeiculo = modeloVeiculo;
        this.corVeiculo = corVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.email = email;
    }  
   
    public void imprimeMotorista(){
        super.imprimePessoa();
        System.out.println("CNH: " + this.cnh);
        System.out.println("Modelo do Veículo: " + this.modeloVeiculo);
        System.out.println("Cor do Veículo: " + this.corVeiculo);
        System.out.println("Placa do Veículo: " + this.placaVeiculo);
        System.out.println("Motorista cadastrado com sucesso!");
 
    }
    public String getCnh (){
        return this.cnh;
    
    }
    public void setCnh (String cnh){
        this.cnh = cnh;
    }

}
