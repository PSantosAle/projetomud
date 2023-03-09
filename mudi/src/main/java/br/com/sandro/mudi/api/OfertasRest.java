package br.com.sandro.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandro.mudi.dto.RequisicaoNovaOferta;
import br.com.sandro.mudi.model.Oferta;
import br.com.sandro.mudi.model.Pedido;
import br.com.sandro.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criarOferta(@Valid @RequestBody RequisicaoNovaOferta requisicaoNO) {
		
		
		Optional<Pedido> retornoPedido = pedidoRepository.findById(requisicaoNO.getPedidoId());	
		
		if(!retornoPedido.isPresent()) {
			return null;
		}
		
		Pedido pedido = retornoPedido.get();
		Oferta novaOferta = requisicaoNO.toOFerta();
		novaOferta.setPedido(pedido);
		pedido.getOfertas().add(novaOferta);
		pedidoRepository.save(pedido);
		
		return novaOferta;
	
	}
}
