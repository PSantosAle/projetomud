package br.com.sandro.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandro.mudi.interceptor.InteceptadorDeAcessos;
import br.com.sandro.mudi.interceptor.InteceptadorDeAcessos.Acesso;


@RequestMapping("acessos")
@RestController
public class AcessosRest {
	
	@GetMapping
	public List<Acesso> getAcessos(){
		return InteceptadorDeAcessos.acessos;
	}
	
}
