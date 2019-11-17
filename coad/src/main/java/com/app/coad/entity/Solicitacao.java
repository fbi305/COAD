package com.app.coad.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "solicitacao")
public class Solicitacao implements Serializable {

	private static final long serialVersionUID = 2995770932216256069L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "titulo", length = 100, nullable = false)
	private String titulo;
	@Column(name = "descricao", length = 455, nullable = false)
	private String descricao;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy-MM-dd")
	@Column(name = "data", length = 10, nullable = false)
	private Date data;
	@Column(name = "tipoOutros", length = 50, nullable = false)
	private String tipoOutros;
	@Column(name = "status", length = 1, nullable = false)
	private int status;
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "tipo_solicitacao_id")
	private TipoSolicitacao tipoSolicitacao;
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Solicitacao() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipoOutros() {
		return tipoOutros;
	}

	public void setTipoOutros(String tipoOutros) {
		this.tipoOutros = tipoOutros;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public TipoSolicitacao getTipoSolicitacao() {
		return tipoSolicitacao;
	}

	public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String dataFormat(Date data) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(data);
	}
	
	public String dataBaixa() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		return dateFormat.format(data);
	}

	public String dataAlta() {
		Date data = new Date();
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(data); 
		cal.add(Calendar.DATE, -2);
		data = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(data);
	}
}