package modelo;

public class Motorista {
    
    private int codigoMotorista;
    private String cnh;
    private String nome;
    private String contato;
    private String bloco;
    private int apartamento;
    private int veiculo;
    
    public Motorista(String nome,String cnh,String contato,int codigoMotorista,int apartamento, String bloco, int veiculo){
        this.apartamento = apartamento;
        this.bloco = bloco;
        this.cnh = cnh;
        this.codigoMotorista = codigoMotorista;
        this.nome = nome;
        this.contato = contato;
        this.veiculo = veiculo;
    }
    
    public Motorista(){
        
    }

    public int getCodigoMotorista() {
        return codigoMotorista;
    }

    public void setCodigoMotorista(int codigoMotorista) {
        this.codigoMotorista = codigoMotorista;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    public int getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(int veiculo) {
        this.veiculo = veiculo;
    }
    
}
