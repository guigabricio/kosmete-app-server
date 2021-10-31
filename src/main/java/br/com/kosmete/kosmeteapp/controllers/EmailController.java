package br.com.kosmete.kosmeteapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.kosmete.kosmeteapp.entitites.UsuarioEntity;
import br.com.kosmete.kosmeteapp.enums.StatusUsuario;
import br.com.kosmete.kosmeteapp.exceptions.EmailExisteException;
import br.com.kosmete.kosmeteapp.services.UsuarioService;

@Controller
public class EmailController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/confirmacaoemail/{tokenDeConfirmacaoDeEmail}", method = RequestMethod.GET)
    public String procurarPorTokenDeConfirmacaoDeEmail(@PathVariable String tokenDeConfirmacaoDeEmail, Model model) throws EmailExisteException {
		UsuarioEntity usuario = this.usuarioService.procurarPorTokenDeConfirmacaoDeEmail(tokenDeConfirmacaoDeEmail);
		if (usuario != null) {
			if (usuario.getStatus().equals(StatusUsuario.NAO_CONFIRMADO.name())) {				
				usuario.setStatus(StatusUsuario.CONFIRMADO.name());
				this.usuarioService.editar(usuario);
			}
			model.addAttribute("name", usuario.getUsuario());
		} else {
			return null;
		}
		return "congratulations";
    }

}
