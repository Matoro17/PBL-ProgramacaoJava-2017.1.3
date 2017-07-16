package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.Produto;
import util.ArvoreAvl;

public class Controller {
	ArvoreAvl arvore = new ArvoreAvl();
	int quantidadeMercadorias = 0;
	
	public boolean lerAqruivo(String end){
		File arquivoCSV = new File(end);
		
		try{
	        @SuppressWarnings("resource")
			Scanner leitor = new Scanner(arquivoCSV);	        
	        String linhasDoArquivo = new String();	        
	        //percorre todo o arquivo
	        while(leitor.hasNext()){
	        	Produto novo = new Produto();
	            linhasDoArquivo = leitor.nextLine();	            
	            //separa os campos entre as virgulas de cada linha
	            novo.setVetor( linhasDoArquivo.split(";"));            
	            arvore.inserir(novo);
	            novo.toString();
	            quantidadeMercadorias++;
	        }
	        return true;
	    
	    }catch(FileNotFoundException e){
	        return false;
	    }
		
	}
	
	public boolean novaMercadoria(String lote, String end, String bloco, String numero, String fornce, String data, String hr){
		Produto novo = new Produto(lote,end,bloco,numero,fornce);
		novo.setData(data);
		novo.setHora(hr);
		arvore.inserir(novo);
		return true;
	}
	
	public boolean escreverNoarquivo(Produto caixa, String sFileName) throws IOException{		
		FileWriter writer = null;    
		try{
		        writer = new FileWriter(sFileName);
		        
		        for(int i=0;i<7;i++){
		        	writer.append(caixa.getVetor()[i]);
		        	writer.append(";");
		        }	
		       
		        
		        return true;
		    }catch(IOException e){
		         e.printStackTrace();
		         return false;
		    }finally{
		    	writer.flush();
		        writer.close();
		    } 
		    
		
	}
	
	public void listarArvore(){
		arvore.posOrdem();	
		
	}
	
	
	public boolean escreverArvoreToda(String file) throws IOException{
		BufferedWriter buffer = null;
		try {		
			buffer = new BufferedWriter(new FileWriter(file, true)); 
			//BufferedWriter buffer = new Files.newBufferedWriter(Paths.get(file)); Se não funcionar tenta essa
			arvore.escreverArvore(buffer);
			return true;		
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}finally{
			buffer.close();		
		}				
	}
	
	
	/*public boolean escreverArvoreToda(String sFileName) throws IOException{
		
		FileWriter writer = null;
		try {
			writer = new FileWriter(sFileName, true);
			BufferedWriter bw = new BufferedWriter(writer);
			arvore.escreverArvore(writer,bw);
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}finally{
			writer.close();
		}
		
		
		
	}*/
	
	public void arvoreVetor(){
		arvore.arvoreVetor(quantidadeMercadorias);
		
	}
	
	public Produto acharProdutoporCoda(String lote, String end, String bloco, String numero, String fornecedor){
		return arvore.retornar(new Produto(lote, end, bloco, numero, fornecedor));
	}
	
	public void deletarproduto(String lote, String end, String bloco, String numero, String fornecedor){
		arvore.remover(new Produto(lote, end, bloco, numero, fornecedor));
	}
	
	
	
	
}

