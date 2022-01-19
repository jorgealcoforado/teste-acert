package com.grupoacert.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ApiModel
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HISTORICO")
public class Historico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HISTORICO")
    private Long id;
	
	@Column(name = "CELSIUS")
	private float celsius;
	
	@Column(name = "FAHRENHEIT")
	private float fahrenheit;
	
	@Column(name = "DATACADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
}
