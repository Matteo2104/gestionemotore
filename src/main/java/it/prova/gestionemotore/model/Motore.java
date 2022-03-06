package it.prova.gestionemotore.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "motore")
public class Motore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "codice")
	private String codice;
	@Column(name = "cilindrata")
	private int cilindrata;
	@Column(name = "potenza")
	private int potenza;
	@Column(name = "coppia")
	private int coppia;
	@Column(name = "dataproduzione")
	private Date dataProduzione;

	// campi per le time info del record
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Motore() {}

	public Motore(String codice) {
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public String getCodice() {
		return codice;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public int getPotenza() {
		return potenza;
	}

	public int getCoppia() {
		return coppia;
	}

	public Date getDataProduzione() {
		return dataProduzione;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	public void setPotenza(int potenza) {
		this.potenza = potenza;
	}

	public void setCoppia(int coppia) {
		this.coppia = coppia;
	}

	public void setDataProduzione(Date dataProduzione) {
		this.dataProduzione = dataProduzione;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public String toString() {
		return "Motore [id=" + id + ", codice=" + codice + ", cilindrata=" + cilindrata + ", potenza=" + potenza
				+ ", coppia=" + coppia + ", dataProduzione=" + dataProduzione + ", createDateTime=" + createDateTime
				+ ", updateDateTime=" + updateDateTime + "]";
	}
	

}
