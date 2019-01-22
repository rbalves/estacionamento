package modelo;

public class Registro {
    
    private int codigoRegistro;
    private String status;
    private String data;
    private String hora;
    private String codigoVeiculo;
    
    public Registro(int codigoRegistro, String status, String data, String hora, String codigoVeiculo){
        this.codigoRegistro = codigoRegistro;
        this.status = status;
        this.data = data;
        this.hora = hora;
        this.codigoVeiculo = codigoVeiculo;
    }

    public int getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(int codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCodigoVeiculo() {
        return codigoVeiculo;
    }

    public void setCodigoVeiculo(String codigoVeiculo) {
        this.codigoVeiculo = codigoVeiculo;
    }
}
