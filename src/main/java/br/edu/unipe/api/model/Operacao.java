package br.edu.unipe.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_operacao")
public class Operacao {
	@Id
	private long id;
	private String papel;
	private double vlrUn;
	private double cp;
	private double lair;
	private int qtdAcm;
	private double pm;
	private double pf;
	private double vt;
	private double corret;
	private double emolum;
	private double liquid;
	private double registr;
	private double isseOutros;

}
