package modelo;

public class Veiculo {
    
    private String placa;
    private String tipo;
    private String modelo;
    private String fabricante;
    private String cor;
    private String status;
    private String codigoProprietario;
    
    public Veiculo(String placa, String tipo, String modelo, String fabricante, String cor, String status, String codigo){
        this.placa = placa;
        this.tipo = tipo;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.cor = cor;
        this.status = status;
        this.codigoProprietario = codigo;
    }
    
    public Veiculo(){
    
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCodigoProprietario() {
        return codigoProprietario;
    }

    public void setCodigoProprietario(String codigoProprietario) {
        this.codigoProprietario = codigoProprietario;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
