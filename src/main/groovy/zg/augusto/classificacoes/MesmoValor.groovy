package zg.augusto.classificacoes

import zg.augusto.dominio.Carta
import zg.augusto.dominio.ValorCarta

final class MesmoValor extends Grupo {

	final ValorCarta valor

	MesmoValor(Carta[] cartas, ValorCarta valor) {
		super(cartas)
		this.valor = valor
	}

	static Grupo[] fromCartas(Carta[] cartas) {
		return cartas
			.groupBy { it.valor }
			.findAll { it.value.size() > 1 }
			.collect { it.value }
			.collect { new MesmoValor(it as Carta[], it[0].valor) }
	}

}
