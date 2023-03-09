package br.com.sandro.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandro.mudi.model.Pedido;
import br.com.sandro.mudi.model.StatusPedido;
import br.com.sandro.mudi.repository.PedidoRepository;


@RestController
@RequestMapping("/api/pedidos")
public class PedidoRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas(){
		
		Sort sort = Sort.by("id").ascending();
		PageRequest paginacao = PageRequest.of(0, 2,sort);
		
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);

	}

}
