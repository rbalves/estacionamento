package execucao;

import modelo.*;

public class Execucao {
    public static void main(String[] args){
        
        Estacionamento estacionamento = new Estacionamento();
        int opcao;
        
        do{
            opcao = estacionamento.menu();
            switch(opcao){
                case 1:
                    estacionamento.menuMotorista();
                    break;
                case 2:
                    estacionamento.menuVeiculo();
                    break;
                case 3:
                    estacionamento.menuRegistro();
                    break;
                default:
                    break;
            }
        }while(opcao!= 4);
        
    }
}
