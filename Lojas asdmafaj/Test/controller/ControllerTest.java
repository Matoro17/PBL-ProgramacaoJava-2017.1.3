package controller;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import model.Produto;

public class ControllerTest {

	@Test
	public void testeabrirarquivo() {
		Controller control = new Controller();
		String local = "armazem.csv";
		
		boolean pegou = control.lerAqruivo(local);
		
		assertEquals(true, pegou);
		
	}
	
	@Test
	public void testemmutuo() throws IOException{			
		Controller control = new Controller();
		
		control.lerAqruivo("armazem.csv");
		String lotee = "1";
		String primeiro = "16587";
		String bloco = "B1";
		String numero = "513";
		String forne = "F1";
		
		Produto test = control.acharProdutoporCoda(lotee, primeiro, bloco, numero, forne);
		if(test == null){
			System.out.println("deu ruim berg");
		}
		boolean test2 = control.escreverArvoreToda("armario.csv");
		assertEquals(true, test2);
		assertEquals("1", test.getLote());
	}
	
	@Test
	public void testDeletar(){
		Controller control = new Controller();		
		control.lerAqruivo("armazem.csv");
		String lotee = "1";
		String primeiro = "16587";
		String bloco = "B1";
		String numero = "513";
		String forne = "F1";
		
		Produto test2 = control.acharProdutoporCoda(lotee, primeiro, bloco, numero, forne);
		
		control.deletarproduto(lotee, primeiro, bloco, numero, forne);
		
		Produto test = control.acharProdutoporCoda(lotee, primeiro, bloco, numero, forne);
		
		assertEquals("1", test2.getLote());
		assertEquals(null, test);
		
	}
	
	@Test
	public void testNovoProduto(){
		Controller control = new Controller();	
		control.lerAqruivo("armazem.csv");
		String lotee = "4";
		String primeiro = "44568";
		String bloco = "T1";
		String numero = "513";
		String forne = "G1";
		String data = "23/12/2017";
		String hr = "13:00";
		
		control.novaMercadoria(lotee, primeiro, bloco, numero, forne, data, hr);
		
		Produto test = control.acharProdutoporCoda(lotee, primeiro, bloco, numero, forne);
		
		assertEquals("13:00", test.getHora());
		
	}
	
}
