package model;

public class Produto {
	private String[] info = new String[7];
	
	public Produto(){
		
	}
	
	public Produto(String lote, String end, String bloco, String numero, String fornce){
		this.info[0]= lote;
		this.info[1]= end;
		this.info[2]= bloco;
		this.info[3]= numero;
		this.info[4]= fornce;
	}

	public String[] getVetor() {
		return info;
	}

	public void setVetor(String[] info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%s;%s;%s;%s;%s;%s\n", getLote(),getEndereco(),getBloco(),getNumero(),getFornecedor(),getData(),getHora())   ;
	}

	
	public String getLote(){
		return this.info[0];		
	}
	public String getEndereco() {
		return this.info[1];
	}
	
	public String getBloco(){
		return this.info[2];		
	}
	public String getNumero(){
		return this.info[3];		
	}
	public String getFornecedor(){
		return this.info[4];
	}
	public String getData(){
		return this.info[5];
	}
	public String getHora(){
		return this.info[6];
	}
	public void setLote(String info) {
		this.info[0] = info;
	}
	public void setEndereco(String info) {
		this.info[1] = info;
	}
	public void setBloco(String info) {
		this.info[2] = info;
	}
	public void setNumero(String info) {
		this.info[3] = info;
	}
	public void setFornecedor(String info){
		this.info[4] = info;
	}
	public void setData(String info){
		this.info[5] = info;
	}
	public void setHora(String info){
		this.info[6] = info;
	}
	
	public String getCoda(){
		return info[0]+info[1]+info[2]+info[3]+info[4];
	}

	public int compareTo(Produto comparado) {		
		return getCoda().compareTo(comparado.getCoda());
	}

	

	
	
}
