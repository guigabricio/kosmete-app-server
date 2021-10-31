package br.com.kosmete.kosmeteapp.entitites;

import java.time.ZonedDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "produtos_e_servicos")
public class ProdutoServicoEntity {

	@Id
	private ObjectId id;
	private ObjectId idEmpresa;
	private ZonedDateTime dataRegistro;
	private String descricao;
	private String categoria;
	private Double custo;
	private Double precoVenda;
	private Double descontoMaximo;
	private String tipoComissao;
	private String comissaoPercentual;

}
