package entidade;

import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.TemporalType;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Jogo {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(length=500)
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new Date();
	@Transient
	private Random aleatorio = new Random();
	private Integer v1 = aleatorio.nextInt(30);
	private Integer v2 = aleatorio.nextInt(30);
	private Integer v3 = aleatorio.nextInt(30);
	private Integer v4 = aleatorio.nextInt(30);
	private Integer v5 = aleatorio.nextInt(30);
	private Integer v6 = aleatorio.nextInt(30);
	private Integer v7 = aleatorio.nextInt(30);
	private Integer v8 = aleatorio.nextInt(30);
	private Integer v9 = aleatorio.nextInt(30);
	private Integer v10 = aleatorio.nextInt(30);
	
	public List<Integer> pares(){
		return List.of(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10).stream().filter(v -> v % 2 == 0 ).toList();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getV1() {
		return v1;
	}
	public void setV1(Integer v1) {
		this.v1 = v1;
	}
	public Integer getV2() {
		return v2;
	}
	public void setV2(Integer v2) {
		this.v2 = v2;
	}
	public Integer getV3() {
		return v3;
	}
	public void setV3(Integer v3) {
		this.v3 = v3;
	}
	public Integer getV4() {
		return v4;
	}
	public void setV4(Integer v4) {
		this.v4 = v4;
	}
	public Integer getV5() {
		return v5;
	}
	public void setV5(Integer v5) {
		this.v5 = v5;
	}
	public Integer getV6() {
		return v6;
	}
	public void setV6(Integer v6) {
		this.v6 = v6;
	}
	public Integer getV7() {
		return v7;
	}
	public void setV7(Integer v7) {
		this.v7 = v7;
	}
	public Integer getV8() {
		return v8;
	}
	public void setV8(Integer v8) {
		this.v8 = v8;
	}
	public Integer getV9() {
		return v9;
	}
	public void setV9(Integer v9) {
		this.v9 = v9;
	}
	public Integer getV10() {
		return v10;
	}
	public void setV10(Integer v10) {
		this.v10 = v10;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
