package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Produto;

public class ArvoreAvl {

  protected No raiz;

	public void inserir(Produto k) {
		No n = new No(k);
		inserirAVL(this.raiz, n);
	}

	public boolean inserirAVL(No aComparar, No aInserir) {

		if (aComparar == null) {
			this.raiz = aInserir;
			return true;
		} else {

			if (aInserir.getChave().getLote().compareTo(aComparar.getChave().getLote()) == -1 ) {

				if (aComparar.getEsquerda() == null) {
					aComparar.setEsquerda(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);
					return true;
				} 
				else {
					inserirAVL(aComparar.getEsquerda(), aInserir);}

			} else if (aInserir.getChave().getLote().compareTo(aComparar.getChave().getLote()) == 1) {

				if (aComparar.getDireita() == null) {
					aComparar.setDireita(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);
					return true;
				} 
				else {
					inserirAVL(aComparar.getDireita(), aInserir);}

			} else {
				if (aInserir.getChave().getEndereco().compareTo(aComparar.getChave().getEndereco()) == -1 ){
					//inserção logo a esquerda
					if (aComparar.getEsquerda() == null) {
						aComparar.setEsquerda(aInserir);
						aInserir.setPai(aComparar);
						verificarBalanceamento(aComparar);
						return true;
					} 
					else {
						inserirAVL(aComparar.getEsquerda(), aInserir);}

					
				}
				else if(aInserir.getChave().getEndereco().compareTo(aComparar.getChave().getEndereco()) == 1){
					//insercao logo a direita
					if (aComparar.getDireita() == null) {
						aComparar.setDireita(aInserir);
						aInserir.setPai(aComparar);
						verificarBalanceamento(aComparar);
						return true;
					} 
					else {
						inserirAVL(aComparar.getDireita(), aInserir);}

				}
				else{
					if(aInserir.getChave().getBloco().compareTo(aComparar.getChave().getBloco()) == -1){
						//inserção logo a esquerda
						if (aComparar.getEsquerda() == null) {
							aComparar.setEsquerda(aInserir);
							aInserir.setPai(aComparar);
							verificarBalanceamento(aComparar);
							return true;
						} 
						else {
							inserirAVL(aComparar.getEsquerda(), aInserir);}
					}
					else if(aInserir.getChave().getBloco().compareTo(aComparar.getChave().getBloco()) == 1){
						//insercao logo a direita
						if (aComparar.getDireita() == null) {
							aComparar.setDireita(aInserir);
							aInserir.setPai(aComparar);
							verificarBalanceamento(aComparar);
							return true;
						} 
						else {
							inserirAVL(aComparar.getDireita(), aInserir);}
					}
					else{
						if (aInserir.getChave().getNumero().compareTo(aComparar.getChave().getNumero()) == -1){
							//inserção logo a esquerda
							if (aComparar.getEsquerda() == null) {
								aComparar.setEsquerda(aInserir);
								aInserir.setPai(aComparar);
								verificarBalanceamento(aComparar);
								return true;
							} 
							else {
								inserirAVL(aComparar.getEsquerda(), aInserir);}
						}
						else if (aInserir.getChave().getNumero().compareTo(aComparar.getChave().getNumero()) == 1){
							//insercao logo a direita
							if (aComparar.getDireita() == null) {
								aComparar.setDireita(aInserir);
								aInserir.setPai(aComparar);
								verificarBalanceamento(aComparar);
								return true;
							} 
							else {
								inserirAVL(aComparar.getDireita(), aInserir);}
						}
						else{
							if (aComparar.getChave().getFornecedor().compareTo(aInserir.getChave().getFornecedor()) == -1){
								//inserção logo a esquerda
								if (aComparar.getEsquerda() == null) {
									aComparar.setEsquerda(aInserir);
									aInserir.setPai(aComparar);
									verificarBalanceamento(aComparar);
									return true;
								} 
								else {
									inserirAVL(aComparar.getEsquerda(), aInserir);}
							}
							else if (aComparar.getChave().getFornecedor().compareTo(aInserir.getChave().getFornecedor()) == 1){
								//insercao logo a direita
								if (aComparar.getDireita() == null) {
									aComparar.setDireita(aInserir);
									aInserir.setPai(aComparar);
									verificarBalanceamento(aComparar);
									return true;
								} 
								else {
									inserirAVL(aComparar.getDireita(), aInserir);}
							}
							else{
								return false;
							}
						}
					}
				}

			}
		}
		return false;
	}

	public void verificarBalanceamento(No atual) {
		setBalanceamento(atual);
		int balanceamento = atual.getBalanceamento();

		if (balanceamento == -2) {

			if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
				atual = rotacaoDireita(atual);

			} else {
				atual = duplaRotacaoEsquerdaDireita(atual);
			}

		} else if (balanceamento == 2) {

			if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
				atual = rotacaoEsquerda(atual);

			} else {
				atual = duplaRotacaoDireitaEsquerda(atual);
			}
		}

		if (atual.getPai() != null) {
			verificarBalanceamento(atual.getPai());
		} else {
			this.raiz = atual;
		}
	}

	public void remover(Produto k) {
		removerAVL(this.raiz, k);
	}

	public void removerAVL(No atual, Produto k) {
		if (atual == null) {
			return;

		} else {

			if (atual.getChave().compareTo(k) > 0) {
				removerAVL(atual.getEsquerda(), k);

			} else if (atual.getChave().compareTo(k) <0) {
				removerAVL(atual.getDireita(), k);

			} else if (atual.getChave().compareTo(k) == 0) {
				removerNoEncontrado(atual);
			}
		}
	}

	public void removerNoEncontrado(No aRemover) {
		No r;

		if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

			if (aRemover.getPai() == null) {
				this.raiz = null;
				aRemover = null;
				return;
			}
			r = aRemover;

		} else {
			r = sucessor(aRemover);
			aRemover.setChave(r.getChave());
		}

		No p;
		if (r.getEsquerda() != null) {
			p = r.getEsquerda();
		} else {
			p = r.getDireita();
		}

		if (p != null) {
			p.setPai(r.getPai());
		}

		if (r.getPai() == null) {
			this.raiz = p;
		} else {
			if (r == r.getPai().getEsquerda()) {
				r.getPai().setEsquerda(p);
			} else {
				r.getPai().setDireita(p);
			}
			verificarBalanceamento(r.getPai());
		}
		r = null;
	}

	public Produto retornar(Produto bota){
		return retornarAVL(this.raiz, bota);
	}
	
	public Produto retornarAVL(No atual, Produto bota){
		if(atual != null){
			if(bota.compareTo(atual.getChave())<0){
				return retornarAVL(atual.getEsquerda(),bota);
			}
			else if(bota.compareTo(atual.getChave())>0){
				return retornarAVL(atual.getDireita(),bota);
			}
			else{
				return atual.getChave();
			}
		}
		else{
			return null;
		}
	}
	
	
	public No rotacaoEsquerda(No inicial) {

		No direita = inicial.getDireita();
		direita.setPai(inicial.getPai());

		inicial.setDireita(direita.getEsquerda());

		if (inicial.getDireita() != null) {
			inicial.getDireita().setPai(inicial);
		}

		direita.setEsquerda(inicial);
		inicial.setPai(direita);

		if (direita.getPai() != null) {

			if (direita.getPai().getDireita() == inicial) {
				direita.getPai().setDireita(direita);
			
			} else if (direita.getPai().getEsquerda() == inicial) {
				direita.getPai().setEsquerda(direita);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(direita);

		return direita;
	}

	public No rotacaoDireita(No inicial) {

		No esquerda = inicial.getEsquerda();
		esquerda.setPai(inicial.getPai());

		inicial.setEsquerda(esquerda.getDireita());

		if (inicial.getEsquerda() != null) {
			inicial.getEsquerda().setPai(inicial);
		}

		esquerda.setDireita(inicial);
		inicial.setPai(esquerda);

		if (esquerda.getPai() != null) {

			if (esquerda.getPai().getDireita() == inicial) {
				esquerda.getPai().setDireita(esquerda);
			
			} else if (esquerda.getPai().getEsquerda() == inicial) {
				esquerda.getPai().setEsquerda(esquerda);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(esquerda);

		return esquerda;
	}

	public No duplaRotacaoEsquerdaDireita(No inicial) {
		inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
		return rotacaoDireita(inicial);
	}

	public No duplaRotacaoDireitaEsquerda(No inicial) {
		inicial.setDireita(rotacaoDireita(inicial.getDireita()));
		return rotacaoEsquerda(inicial);
	}

	public No sucessor(No q) {
		if (q.getDireita() != null) {
			No r = q.getDireita();
			while (r.getEsquerda() != null) {
				r = r.getEsquerda();
			}
			return r;
		} else {
			No p = q.getPai();
			while (p != null && q == p.getDireita()) {
				q = p;
				p = q.getPai();
			}
			return p;
		}
	}

	private int altura(No atual) {
		if (atual == null) {
			return -1;
		}

		if (atual.getEsquerda() == null && atual.getDireita() == null) {
			return 0;
		
		} else if (atual.getEsquerda() == null) {
			return 1 + altura(atual.getDireita());
		
		} else if (atual.getDireita() == null) {
			return 1 + altura(atual.getEsquerda());
		
		} else {
			return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
		}
	}

	private void setBalanceamento(No no) {
		no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
	}

	final protected ArrayList<No> inorder() {
		ArrayList<No> ret = new ArrayList<No>();
		inorder(raiz, ret);
		return ret;
	}

	final protected void inorder(No no, ArrayList<No> lista) {
		if (no == null) {
			return;
		}
		inorder(no.getEsquerda(), lista);
		lista.add(no);
		inorder(no.getDireita(), lista);
	}
	
	public void posOrdem() {
        posOrdem(raiz);
    }
	
    protected void posOrdem(No p) {
        if (p != null) {
             posOrdem(p.getEsquerda());
             posOrdem(p.getDireita());
             System.out.print(p.getChave().toString());
        }
    }
    
    protected No procurarPai (String el) {
        No p = raiz;
        No ant = null;
        while (p != null && !(p.getChave().getEndereco().compareTo(el) == 0)) {  // acha o nó p com a chave el
            ant = p;                           
            if (p.getChave().getEndereco().compareTo(el) == -1)
                  p = p.getDireita();
            else p = p.getEsquerda();
        }
        if (p!=null && p.getChave().getEndereco().compareTo(el) == 0)         	
        	return ant;
        return null;
    }
    
    public boolean escreverArvore(BufferedWriter buffer) throws IOException {    	
        if (raiz == null) return false;

    	buffer.write(raiz.getChave().toString());		
    	mostrarSubArvore(raiz.getEsquerda(), buffer);
    	mostrarSubArvore(raiz.getDireita(), buffer);

    	return true;
    }
    
    public boolean escreverArvore(FileWriter writer, BufferedWriter bw) throws IOException {
    	
    	if (this.raiz == null){    		
    	    return false;
        }    		
		
		try {
			writer.write(this.raiz.getChave().toString());
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mostrarSubArvore(raiz.getEsquerda(), bw);
		mostrarSubArvore(raiz.getDireita(), bw);
		return true;
	}    
    
    private void mostrarSubArvore(No no, BufferedWriter buffer) throws IOException {
    	if (no != null) {				
    		buffer.write(no.getChave().toString());					
    		mostrarSubArvore(no.getEsquerda(), buffer);
    		mostrarSubArvore(no.getDireita(), buffer);
    	}
    }

	
}
