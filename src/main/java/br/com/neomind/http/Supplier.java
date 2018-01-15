package br.com.neomind.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Supplier {
	
	private int codigo;
	private String nome;
	private String email;
	private String comentario;
	private String cnpj;
 
	public Supplier(){
 
	}
 
	public Supplier(int codigo, String nome, String email, String comentario, String cnpj) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.comentario = comentario;
		this.cnpj = cnpj;
	}
 
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}	

}
