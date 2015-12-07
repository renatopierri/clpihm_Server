/**
 * 
 */
package br.com.nets_nuts.clpihm.model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * Os métodos dessa classe possuem as ferramentas necessárias para 
 * montar uma linha de log para uso na aplicação tanto para persistir
 * como para recuperar dados do banco de dados.
 * @author Renato de Pierri - renato.pierri@gmail.com
 *
 */
public class Log {

	/**
	 * 
	 */
	private Boolean o0,o1,o2,o3,o4,o5,o6,o7,o8,o9,o10,o11;
	private Boolean i0,i1,i2,i3,i4,i5,i6,i7,i8,i9;
	private int idlog, an1,an0;
	private String hr_sistema;
	private String hr_clp,nome_clp;
	

	
	/**
	 * @return the idlog
	 */
	public int getIdlog() {
		return this.idlog;
	}
	public void setIdlog(Integer idlog) {
		this.idlog = idlog;
	}
	
	/**
	 * @return the hr_Sistema
	 */
	public String getHr_Sistema() {
		return this.hr_sistema;
	}
	/**
	 * @param hr_Sistema the hr_Sistema to set
	 */
	public void setHr_Sistema(String hr_Sistema) {
		this.hr_sistema = hr_Sistema;
	}
	/**
	 * Sobrecarca do método acima
	 */
	public void setHr_Sistema() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.hr_sistema = df.format(new Date());
	}
	/**
	 * @return the o0
	 */
	public Boolean getO0() {
		return o0;
	}
	/**
	 * @param o0 the o0 to set
	 */
	public void setO0(Boolean o0) {
		this.o0 = o0;
	}
	/**
	 * @return the o1
	 */
	public Boolean getO1() {
		return o1;
	}
	/**
	 * @param o1 the o1 to set
	 */
	public void setO1(Boolean o1) {
		this.o1 = o1;
	}
	/**
	 * @return the o2
	 */
	public Boolean getO2() {
		return o2;
	}
	/**
	 * @param o2 the o2 to set
	 */
	public void setO2(Boolean o2) {
		this.o2 = o2;
	}
	/**
	 * @return the o3
	 */
	public Boolean getO3() {
		return o3;
	}
	/**
	 * @param o3 the o3 to set
	 */
	public void setO3(Boolean o3) {
		this.o3 = o3;
	}
	/**
	 * @return the o4
	 */
	public Boolean getO4() {
		return o4;
	}
	/**
	 * @param o4 the o4 to set
	 */
	public void setO4(Boolean o4) {
		this.o4 = o4;
	}
	/**
	 * @return the o5
	 */
	public Boolean getO5() {
		return o5;
	}
	/**
	 * @param o5 the o5 to set
	 */
	public void setO5(Boolean o5) {
		this.o5 = o5;
	}
	/**
	 * @return the o6
	 */
	public Boolean getO6() {
		return o6;
	}
	/**
	 * @param o6 the o6 to set
	 */
	public void setO6(Boolean o6) {
		this.o6 = o6;
	}
	/**
	 * @return the o7
	 */
	public Boolean getO7() {
		return o7;
	}
	/**
	 * @param o7 the o7 to set
	 */
	public void setO7(Boolean o7) {
		this.o7 = o7;
	}
	/**
	 * @return the o8
	 */
	public Boolean getO8() {
		return o8;
	}
	/**
	 * @param o8 the o8 to set
	 */
	public void setO8(Boolean o8) {
		this.o8 = o8;
	}
	/**
	 * @return the o9
	 */
	public Boolean getO9() {
		return o9;
	}
	/**
	 * @param o9 the o9 to set
	 */
	public void setO9(Boolean o9) {
		this.o9 = o9;
	}
	/**
	 * @return the o10
	 */
	public Boolean getO10() {
		return o10;
	}
	/**
	 * @param o10 the o10 to set
	 */
	public void setO10(Boolean o10) {
		this.o10 = o10;
	}
	/**
	 * @return the o11
	 */
	public Boolean getO11() {
		return o11;
	}
	/**
	 * @param o11 the o11 to set
	 */
	public void setO11(Boolean o11) {
		this.o11 = o11;
	}
	/**
	 * @return the i0
	 */
	public Boolean getI0() {
		return i0;
	}
	/**
	 * @param i0 the i0 to set
	 */
	public void setI0(Boolean i0) {
		this.i0 = i0;
	}
	/**
	 * @return the i1
	 */
	public Boolean getI1() {
		return i1;
	}
	/**
	 * @param i1 the i1 to set
	 */
	public void setI1(Boolean i1) {
		this.i1 = i1;
	}
	/**
	 * @return the i2
	 */
	public Boolean getI2() {
		return i2;
	}
	/**
	 * @param i2 the i2 to set
	 */
	public void setI2(Boolean i2) {
		this.i2 = i2;
	}
	/**
	 * @return the i3
	 */
	public Boolean getI3() {
		return i3;
	}
	/**
	 * @param i3 the i3 to set
	 */
	public void setI3(Boolean i3) {
		this.i3 = i3;
	}
	/**
	 * @return the i4
	 */
	public Boolean getI4() {
		return i4;
	}
	/**
	 * @param i4 the i4 to set
	 */
	public void setI4(Boolean i4) {
		this.i4 = i4;
	}
	/**
	 * @return the i5
	 */
	public Boolean getI5() {
		return i5;
	}
	/**
	 * @param i5 the i5 to set
	 */
	public void setI5(Boolean i5) {
		this.i5 = i5;
	}
	/**
	 * @return the i6
	 */
	public Boolean getI6() {
		return i6;
	}
	/**
	 * @param i6 the i6 to set
	 */
	public void setI6(Boolean i6) {
		this.i6 = i6;
	}
	/**
	 * @return the i7
	 */
	public Boolean getI7() {
		return i7;
	}
	/**
	 * @param i7 the i7 to set
	 */
	public void setI7(Boolean i7) {
		this.i7 = i7;
	}
	/**
	 * @return the i8
	 */
	public Boolean getI8() {
		return i8;
	}
	/**
	 * @param i8 the i8 to set
	 */
	public void setI8(Boolean i8) {
		this.i8 = i8;
	}
	/**
	 * @return the i9
	 */
	public Boolean getI9() {
		return i9;
	}
	/**
	 * @param i9 the i9 to set
	 */
	public void setI9(Boolean i9) {
		this.i9 = i9;
	}
	/**
	 * @return the an1
	 */
	public int getAN1() {
		return an1;
	}
	/**
	 * @param an1 the an1 to set
	 */
	public void setAN1(int an1) {
		this.an1 = an1;
	}
	/**
	 * @return the an0
	 */
	public int getAN0() {
		return an0;
	}
	/**
	 * @param an0 the an0 to set
	 */
	public void setAN0(int an0) {
		this.an0 = an0;
	}
	public String getHr_clp() {
		// TODO Auto-generated method stub
		return this.hr_clp;
	}

	/**
	 * @param hr_clp the hr_clp to set
	 */
	public void setHr_CLP(String hr_clp) {
		this.hr_clp = hr_clp;
	}
	/**
	 * Sobrecarca do método acima
	 */
	public void setHr_CLP() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.hr_clp = df.format(new Date());
	}

	public String getNome_CLP() { 
		// TODO Auto-generated method stub
		return this.nome_clp;
	}

	/**
	 * @param nome_clp the nome_clp to set
	 */
	public void setNome_CLP(String nome_clp) {
		this.nome_clp = nome_clp;
	}
	/**
	 * Sobrecarca do método acima
	 */
	public void setNome_CLP() {
		this.nome_clp = "CLPTST";
	}	

	

}
