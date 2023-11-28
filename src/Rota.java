public class Rota {

    //atributos
    private String localPartida;
    private String chegada;
    private int distanciaEmKm;
    private Double velocidadeEmKmPorHora;
    private double valorCorrida;

    //gets e sets
    public Rota(String localPartida, String chegada, int distanciaEmKm) {
        this.localPartida = localPartida;
        this.chegada = chegada;
        this.distanciaEmKm = distanciaEmKm;
    }

    public Rota (){

    }
    public String getLocalPartida() {
        return localPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public String getChegada() {
        return chegada;
    }

    public void setChegada(String chegada) {
        this.chegada = chegada;
    }

    public int getDistanciaEmKm() {
        return distanciaEmKm;
    }
    public void setdistanciaEmKm(int distanciaEmKm) {
        this.distanciaEmKm = distanciaEmKm;
    }

    public Double getVelocidadeEmKmPorHora() {
        return velocidadeEmKmPorHora;
    }
    public void setVelocidadeEmKmPorHora(Double velocidadeEmKmPorHora) {
        this.velocidadeEmKmPorHora = velocidadeEmKmPorHora;
    }
    
    public double getValorCorrida() {
        return valorCorrida;
    }
    public void setValorCorrida(double valorCorrida) {
        this.valorCorrida = valorCorrida;
    }
 
   
    //metodos/função
    public void imprimirRota() {
        System.out.println("O Local de partida é " + getLocalPartida());
        System.out.println("O local de chegada é " + getChegada());

    }

    public void calcularTempoDaCorrida(int kmDigitado) {     
        
        double totalMinutosKmDouble = kmDigitado/1.2;

        int totalMinutos = (int) Math.round(totalMinutosKmDouble);

        int horas = totalMinutos / 60;
        int minutos = totalMinutos % 60;
        int segundos = 0;

        if (minutos >= 60) {
            horas += minutos / 60;
            minutos %= 60;
        }

        if (segundos >= 60) {
            minutos += segundos / 60;
            segundos %= 60;
        }

        String tempoFormatado = String.format("%02d:%02d:%02d", horas, minutos, segundos);  
        
        System.out.println("O Tempo Estimado de Chegada é " + tempoFormatado ); // imprime o resultado formatado
    
    } 
    
    public double valorCorrida(double kmDigitado) {
        
        double valor = 2 + (kmDigitado * 2);
        setValorCorrida(valor);
        
        System.out.println("O Valor da corrida será R$ " + valor+",0");
        
        return valor; 
    }
    

}

  



