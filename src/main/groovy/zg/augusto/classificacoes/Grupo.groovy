package zg.augusto.classificacoes

import zg.augusto.dominio.Carta

abstract class Grupo {

	final Carta[] cartas

	protected Grupo(Carta[] cartas) {
		this.cartas = cartas
	}

}