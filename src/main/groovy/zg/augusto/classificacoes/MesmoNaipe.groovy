package zg.augusto.classificacoes

import zg.augusto.dominio.Carta
import zg.augusto.dominio.Naipe

final class MesmoNaipe extends Grupo {

	final Naipe naipe

	MesmoNaipe(Carta[] cartas, Naipe naipe) {
		super(cartas)
		this.naipe = naipe
	}

	static Grupo[] fromCartas(Carta[] cartas) {
		return cartas
			.groupBy { it.naipe }
			.findAll { it.value.size() > 1 }
			.collect { it.value }
			.collect { new MesmoNaipe(it as Carta[], it[0].naipe) }
	}

}
