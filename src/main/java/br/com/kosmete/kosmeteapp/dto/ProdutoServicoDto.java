package br.com.kosmete.kosmeteapp.dto;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProdutoServicoDto {

	private String id;
	private String idEmpresa;
	private ZonedDateTime dataRegistro;
	private String descricao;
	private String categoria;
	private Double custo;
	private Double precoVenda;
	private Double descontoMaximo;
	private String tipoComissao;
	private String comissaoPercentual;

}
