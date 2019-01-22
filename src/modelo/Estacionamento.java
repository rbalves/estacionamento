package modelo;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Estacionamento {
    
    public int menu(){
        
        Scanner entrada = new Scanner(System.in);
        int opcao;
        
        System.out.println("SISEST - SISTEMA PARA ESTACIONAMENTO");
        System.out.println("1. MOTORISTA");
        System.out.println("2. VEÍCULO");
        System.out.println("3. REGISTRO");
        System.out.println("4. SAIR");
        System.out.print("ESCOLHA: ");
        return opcao = entrada.nextInt();
    }
    
    List <Veiculo> lista_veiculo= new ArrayList<Veiculo>();

    public void menuVeiculo (){
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("SISEST - SISTEMA PARA ESTACIONAMENTO");
            System.out.println("***********  VEICULO  *************");
            System.out.println("1. CADASTRAR VEICULO");
            System.out.println("2. REMOVER VEÍCULO");
            System.out.println("3. ALTERAR VEICULO");
            System.out.println("4. QUANTIDADE DE VEICULOS NO ESTACIONAMENTO");
            System.out.println("5. CONSULTAR VEICULO");
            System.out.println("6. SAIR");
            System.out.print("ESCOLHA: ");
            opcao = entrada.nextInt();
            switch(opcao){
                    case 1:
                      this.cadastraVeiculo();
                    break;
                    case 2:
                     this.removerVeiculo();
                    break;
                    case 3:
                      this.alteraVeiculo();
                    break;
                    case 4:
                      System.out.println("CARROS INTERNOS: " + this.obterTamanhoEstacionamento());
                      break;
                    case 5:
                      this.consultarVeiculo();
                      break;
            }
        }while(opcao!= 6);
    }
    public void cadastraVeiculo(){
      
      Scanner entrada = new Scanner(System.in);
      Motorista objMotorista = new Motorista();
      Veiculo objVeiculo;
      String cnh;
      String placa,tipo,modelo,fabricante,cor;
      boolean achouMotorista = false,achouVeiculo = false;
      
      System.out.println("Informe o CNH do proprietario");
      cnh = entrada.nextLine();
      
      for(int i=0;i<this.lista_motorista.size();i++){
          objMotorista = lista_motorista.get(i);
          if(objMotorista.getCnh().equalsIgnoreCase(cnh)){
                achouMotorista=true;
                if(objMotorista.getVeiculo()==0){
                    objMotorista.setVeiculo(1);
                    System.out.print("Informe a placa: ");
                    placa = entrada.nextLine();
                    for (int j=0;j<this.lista_veiculo.size();j++){
                        objVeiculo = this.lista_veiculo.get(i);
                        if (objVeiculo.getPlaca().equalsIgnoreCase(placa)){   
                            achouVeiculo=true;;
                            break;
                        }
                    }
                    if(achouVeiculo){
                        System.out.println("VEICULO JA FOI CADASTRADO NO SISTEMA!");
                    }else{
                        System.out.print("Informe o tipo: ");
                        tipo = entrada.nextLine();
                        System.out.print("Informe o modelo: ");
                        modelo = entrada.nextLine();
                        System.out.print("Informe o fabricante: ");
                        fabricante = entrada.nextLine();
                        System.out.print("Informe a cor: ");
                        cor = entrada.nextLine();
                        objVeiculo = new Veiculo(placa,tipo,modelo,fabricante,cor,"INTERNO",cnh);
                        this.lista_veiculo.add(objVeiculo);
                        System.out.println("VEICULO CADASTRADO COM SUCESSO!");

                        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
                        Registro registro = new Registro(1, "ENTRADA", data.format(new Date()), hora.format(new Date()), placa);
                        this.listRegistro.add(registro);
                    }
                }else{
                    System.out.println("Motorista já possui veículo!");
                }
           }
       }
        if(!achouMotorista){
            System.out.println("Motorista não encontrado");
        }
    }
    public void removerVeiculo(){
        Scanner entrada = new Scanner(System.in);
        Veiculo objVeiculo = new Veiculo();
        Motorista objMotorista= new Motorista();
        String placa;
        boolean achou = false;
        
        System.out.print("Informe a placa: ");
        placa = entrada.nextLine();
        for(int i=0;i<this.lista_veiculo.size();i++){
        objVeiculo = lista_veiculo.get(i);
        if(objVeiculo.getPlaca().equalsIgnoreCase(placa)){
            for(int j=0;j<this.lista_motorista.size();j++){
                objMotorista = lista_motorista.get(j);
                if(objMotorista.getCnh().equalsIgnoreCase(objVeiculo.getCodigoProprietario())){
                    objMotorista.setVeiculo(0);
                }
            }
            this.lista_veiculo.remove(i);
            System.out.println("Veiculo removido...");
            achou = true;
            break;
        }
        }
        if(!achou){
            System.out.println("Veiculo não encontrado...");
        }
    }
 
    public void alteraVeiculo(){
        Scanner entrada = new Scanner(System.in);
        String placaAlterar, nPlaca, nTipo, nModelo, nFabricante, nCor;
        Veiculo objVeiculo = new Veiculo();
        Boolean achou = false;
        System.out.print("Informe a placa para alterar: ");
        placaAlterar = entrada.nextLine();
        for (int i=0;i<this.lista_veiculo.size();i++){
          objVeiculo = this.lista_veiculo.get(i);
          if (objVeiculo.getPlaca().equalsIgnoreCase(placaAlterar)){
            System.out.print("Informe a nova placa: ");
            nPlaca = entrada.nextLine();
            System.out.print("Informe o novo tipo: ");
            nTipo = entrada.nextLine();
            System.out.print("Informe o novo modelo: ");
            nModelo = entrada.nextLine();
            System.out.print("Informe o novo fabricante: ");
            nFabricante = entrada.nextLine();
            System.out.print("Informe a nova cor: ");
            nCor = entrada.nextLine();             
            objVeiculo.setPlaca(nPlaca);
            objVeiculo.setTipo(nTipo);
            objVeiculo.setModelo(nModelo);
            objVeiculo.setFabricante(nFabricante);
            objVeiculo.setCor(nCor);
            this.lista_veiculo.set(i,objVeiculo);
            System.out.println("Veiculo alterado...");
            achou=true;
            break;
          }
        }
        if(!achou){
            System.out.println("Veiculo não encontrado...");
        }
      }
 
    public int obterTamanhoEstacionamento(){
   	Veiculo objVeiculo;
        int cont = 0;
        for (int i=0;i<this.lista_veiculo.size();i++){
            objVeiculo = this.lista_veiculo.get(i);
            if (objVeiculo.getStatus().equalsIgnoreCase("INTERNO") || objVeiculo.getStatus().equalsIgnoreCase("interno")){
                cont++;
            }
   	 } 
        return cont;
    }
    public void consultarVeiculo(){
   	 Scanner entrada = new Scanner(System.in);
   	 //String placa,tipo,modelo,fabricante,cor;
   	 Veiculo objVeiculo = new Veiculo();
   	 Boolean achou = false;
   	 System.out.print("Informe a placa para consultar: ");
   	 String placa = entrada.nextLine();
   	 
   	 for (int i=0;i<this.lista_veiculo.size();i++){
            objVeiculo = this.lista_veiculo.get(i);
            if (objVeiculo.getPlaca().equalsIgnoreCase(placa)){
                System.out.println("Placa: "+objVeiculo.getPlaca());
                System.out.println("Tipo: "+objVeiculo.getTipo());
                System.out.println("Modelo: "+objVeiculo.getModelo());
                System.out.println("Fabricante: "+objVeiculo.getFabricante());
                System.out.println("Cor: "+objVeiculo.getCor());
                System.out.println("Proprietário: "+objVeiculo.getCodigoProprietario());
                achou=true;
                break;
            }
   	 }
   	 if(!achou){
   		 System.out.println("Veiculo não encontrado...");
 	}
    }
    
    List<Motorista> lista_motorista = new ArrayList<Motorista>(); 

    public void menuMotorista (){
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
        	System.out.println("SISEST - SISTEMA PARA ESTACIONAMENTO");
        	System.out.println("***********  MOTORISTA  *************");
        	System.out.println("1. CADASTRAR MOTORISTA");
        	System.out.println("2. CONSULTAR MOTORISTA");
        	System.out.println("3. EXCLUIR MOTORISTA");
        	System.out.println("4. ALTERAR MOTORISTA");
        	System.out.println("5. SAIR");
        	System.out.print("ESCOLHA: ");
        	opcao = entrada.nextInt();
        	switch(opcao){
            	case 1:
                    this.CadastrarMotorista();
                    break;
            	case 2:
                    this.ConsultarMotorista();
                    break;
            	case 3:
                    this.ExcluirMotorista();
                    break;
            	case 4:
                    this.AlterarMotorista();
                    break; 
        	}
    	}while(opcao!= 5);

     }
    public void CadastrarMotorista(){
        Scanner entrada = new Scanner(System.in);
    	Motorista objMotorista;
        
        String nome, cnh, contato,   bloco; 
    	int codigoMotorista,apartamento;
        boolean achou = false;    
        
        if(this.lista_motorista.size() == 0){
            codigoMotorista = 1;
        }else{
            codigoMotorista = this.lista_motorista.size() + 1;
        }
    	
        System.out.print("Informe o cnh do motorista: ");
        cnh = entrada.nextLine();
        for(int i = 0; i<this.lista_motorista.size(); i++){
            objMotorista = this.lista_motorista.get(i);
            if (objMotorista.getCnh().equalsIgnoreCase(cnh)){
                achou = true;
                break;
            }
        }
        if(achou){
                System.out.println("Este CNH já foi cadastrado...");
        }else{
            System.out.print("Informe o nome do motorista: ");
            nome = entrada.nextLine();
            System.out.print("Informe o contato do motorista: ");
            contato = entrada.nextLine();
            System.out.print("Informe o bloco do motorista: ");
            bloco = entrada.nextLine();
            System.out.print("Informe o numero do apartamento do motorista: ");
            apartamento = entrada.nextInt();
            objMotorista = new Motorista( nome, cnh, contato, codigoMotorista, apartamento, bloco, 0);
            this.lista_motorista.add(objMotorista);	
            System.out.println("Motorista cadastrado com sucesso!");
        }    	
    }
    
    public void cadastraVeiculo(String cnh){
      
      Scanner entrada = new Scanner(System.in);
      Veiculo objVeiculo;
      String placa,tipo,modelo,fabricante,cor;
      boolean achouVeiculo = false;

      
        System.out.print("Informe a placa: ");
        placa = entrada.nextLine();
        for (int j=0;j<this.lista_veiculo.size();j++){
            objVeiculo = this.lista_veiculo.get(j);
            if (objVeiculo.getPlaca().equalsIgnoreCase(placa)){   
                achouVeiculo=true;;
                break;
            }
        }
        if(achouVeiculo){
            System.out.println("VEICULO JA FOI CADASTRADO NO SISTEMA!");
        }else{
            System.out.print("Informe o tipo: ");
            tipo = entrada.nextLine();
            System.out.print("Informe o modelo: ");
            modelo = entrada.nextLine();
            System.out.print("Informe o fabricante: ");
            fabricante = entrada.nextLine();
            System.out.print("Informe a cor: ");
            cor = entrada.nextLine();
            objVeiculo = new Veiculo(placa,tipo,modelo,fabricante,cor,"INTERNO",cnh);
            this.lista_veiculo.add(objVeiculo);
            System.out.println("VEICULO CADASTRADO COM SUCESSO!");

            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
            Registro registro = new Registro(1, "ENTRADA", data.format(new Date()), hora.format(new Date()), placa);
            this.listRegistro.add(registro);
        }
    }
    
    public void ConsultarMotorista(){
    	Scanner entrada = new Scanner(System.in);
        String nome;
    	System.out.println("Informe o nome do motorista: ");
    	nome = entrada.nextLine();
    	
		Motorista objMotorista = new Motorista();
		Boolean achou = false;
		for(int i = 0; i<this.lista_motorista.size(); i++){
			objMotorista = this.lista_motorista.get(i);
			
			if (objMotorista.getNome().equalsIgnoreCase(nome)){
				System.out.println("Nome: "+ objMotorista.getNome());
				System.out.println("Cnh: "+ objMotorista.getCnh());
				System.out.println("Contato: "+ objMotorista.getContato());
				System.out.println("Bloco: "+ objMotorista.getBloco());
				System.out.println("Codigo do motorista: "+ objMotorista.getCodigoMotorista());
				System.out.println("Apartamento: "+ objMotorista.getApartamento());
				achou = true;
				break;
			}
		}
		if(!achou){
			System.out.println("Motorista não encontrado...");
		}
		
	}
	public void ExcluirMotorista(){
            Scanner entrada = new Scanner(System.in);
            String nome;
		
            System.out.println("Informe o nome do motorista: ");
            nome = entrada.nextLine();
		
            Motorista objMotorista = new Motorista();
            boolean achou = false;

            for(int i=0;i<this.lista_motorista.size();i++){
                    objMotorista = lista_motorista.get(i);
                    if(objMotorista.getNome().equalsIgnoreCase(nome)){
                    this.lista_motorista.remove(i);
                    this.removerVeiculo(objMotorista.getCnh());
                    System.out.println("Motorista removido...");
                    achou = true;
                    break;
                    }
            }
            if(!achou){
                    System.out.println("Motorista não encontrado...");
            }
	
		
	}
        
        public void removerVeiculo(String cnh){
        Veiculo objVeiculo = new Veiculo();
   
        for(int i=0;i<this.lista_veiculo.size();i++){
        objVeiculo = lista_veiculo.get(i);
        if(objVeiculo.getCodigoProprietario().equalsIgnoreCase(cnh)){
            this.lista_veiculo.remove(i);
            System.out.println("Veiculo removido...");
            break;
        }
        }
    }
        
	public void AlterarMotorista(){
            Scanner entrada = new Scanner(System.in);
            String nomeAlterar, nNome, nCnh, novoContato, nBloco;
            int nApartamento;
            Motorista objMotorista = new Motorista();
            Boolean achou = false;
            
            System.out.println("Informe o nome do motorista ser alterado: ");
            nomeAlterar = entrada.nextLine();
            
            for(int i = 0; i<this.lista_motorista.size(); i++){
                objMotorista = this.lista_motorista.get(i);
                if (objMotorista.getNome().equalsIgnoreCase(nomeAlterar)){
                    System.out.println("Informe o nome do motorista: ");
                    nNome = entrada.nextLine();
                    System.out.println("Informe o cnh do motorista: ");
                    nCnh = entrada.nextLine();
                    System.out.println("Informe o contato do motorista: ");
                    novoContato = entrada.nextLine();
                    System.out.println("Informe o bloco do motorista: ");
                    nBloco = entrada.nextLine();
                    System.out.println("Informe o apartamento do motorista: ");
                    nApartamento = entrada.nextInt();

                    objMotorista.setNome(nNome);
                    objMotorista.setCnh(nCnh);
                    objMotorista.setContato(novoContato);
                    objMotorista.setApartamento(nApartamento);
                    objMotorista.setBloco(nBloco);
                    this.lista_motorista.set(i, objMotorista);
                    achou = true;
                    break;
                }
            }
            if(!achou){
                    System.out.println("Motorista não encontrado...");
            }
    }
    
    List<Registro> listRegistro = new ArrayList<Registro>();
    
    //métodos veiculo
    
    public void menuRegistro(){
        
        Scanner entrada = new Scanner(System.in);
        int opcao;
        
        do{
            System.out.println("SISEST - SISTEMA PARA ESTACIONAMENTO");
            System.out.println("***********  REGISTRO  *************");
            System.out.println("1. REGISTRAR ENTRADA");
            System.out.println("2. REGISTRAR SAÍDA");
            System.out.println("3. CONSULTAR HISTÓRICO");
            System.out.println("4. SAIR");
            System.out.print("ESCOLHA: ");
            opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    this.registraEntrada();
                    break;
                case 2:
                    this.registraSaida();
                    break;
                case 3:
                    this.consultaHistorico();
                    break;
            }
        }while(opcao!= 4);
    }
    
    public void registraEntrada(){
        
        Scanner entrada = new Scanner(System.in);
        Veiculo veiculo ;
    
        boolean achou = false;
        
        int codigo;
        String status;
        String placaVeiculoRegistrado;
        
        System.out.println("SISEST - SISTEMA PARA ESTACIONAMENTO");
        System.out.println("******** REGISTRO - ENTRADA ********");
        
        if(this.listRegistro.size() == 0){
            codigo = 1;
        }else{
            codigo = this.listRegistro.size() + 1;
        }
        
        System.out.print("INFORME A PLACA DO VEICULO: ");
        placaVeiculoRegistrado = entrada.nextLine();
        for(int i=0;i<this.lista_veiculo.size();i++){
            veiculo = lista_veiculo.get(i);
            if(veiculo.getPlaca().equalsIgnoreCase(placaVeiculoRegistrado)){
                if(veiculo.getStatus().equalsIgnoreCase("EXTERNO")){
                    veiculo.setStatus("INTERNO");
                    status = "ENTRADA";
                    SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
                    Registro registro = new Registro(codigo, status, data.format(new Date()), hora.format(new Date()), placaVeiculoRegistrado);
                    this.listRegistro.add(registro);
                    System.out.println("REGISTRO FEITO COM SUCESSO");
                }else{
                    System.out.println("VEICULO JA ESTA INTERNO");
                }
 
                achou = true;
                break;
            }   
        }
        if(!achou){
            System.out.println("VEICULO NAO ENCONTRADO...");
        }
    }
    
    public void registraSaida(){
        
        Scanner entrada = new Scanner(System.in);
        Veiculo veiculo;
        boolean achou = false;
        
        int codigo;
        String status;
        String placaVeiculoRegistrado;
        
        System.out.println("SISEST - SISTEMA PARA ESTACIONAMENTO");
        System.out.println("******** REGISTRO - SAIDA ********");
        
        if(this.listRegistro.size() == 0){
            codigo = 1;
        }else{
            codigo = this.listRegistro.size() + 1;
        }
        
        System.out.print("INFORME A PLACA DO VEICULO: ");
        placaVeiculoRegistrado = entrada.nextLine();
        for(int i=0;i<this.lista_veiculo.size();i++){
            veiculo = lista_veiculo.get(i);
            if(veiculo.getPlaca().equalsIgnoreCase(placaVeiculoRegistrado)){
                if(veiculo.getStatus().equalsIgnoreCase("INTERNO")){
                    veiculo.setStatus("EXTERNO");
                    status = "SAIDA";
                    SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
                    Registro registro = new Registro(codigo, status, data.format(new Date()), hora.format(new Date()), placaVeiculoRegistrado);

                    this.listRegistro.add(registro);
                    System.out.println("REGISTRO FEITO COM SUCESSO");

                }else{
                    System.out.println("VEICULO JA ESTA EXTERNO");
                }
 
                achou = true;
                break;
            }   
        }
        if(!achou){
            System.out.println("VEICULO NAO ENCONTRADO...");
        }
    }
    
    public void consultaHistorico(){
        
        Scanner entrada = new Scanner(System.in);
        Registro registro;
        
        boolean achou = false;
        
        String placaVeiculoRegistrado;
        
        System.out.println("SISEST - SISTEMA PARA ESTACIONAMENTO");
        System.out.println("****** CONSULTA AO HISTÓRICO *******");
        
        System.out.print("INFORME A PLACA DO VEICULO: ");
        placaVeiculoRegistrado = entrada.nextLine();
       
        for(int i=0;i<this.listRegistro.size();i++){
            registro = listRegistro.get(i);
            if(registro.getCodigoVeiculo().equalsIgnoreCase(placaVeiculoRegistrado)){
                System.out.println("CODIGO: " + registro.getCodigoRegistro());
                System.out.println("STATUS: " + registro.getStatus());
                System.out.println("DATA: " + registro.getData());
                System.out.println("HORA: " + registro.getHora());
                achou = true;
            }   
        }
        if(!achou){
            System.out.println("VEICULO NAO ENCONTRADO...");
        }      
    }
}