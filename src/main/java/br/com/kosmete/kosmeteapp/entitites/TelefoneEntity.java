package br.com.kosmete.kosmeteapp.entitites;

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
public class TelefoneEntity {

	private String tipo;
	private String ddd;
	private String numero;

}
