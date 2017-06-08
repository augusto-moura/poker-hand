package zg.augusto.classificacoes

import zg.augusto.dominio.Carta

final class Sequencia extends Grupo {

	private Sequencia(Carta[] cartas) {
		super(cartas)
	}

	static Grupo[] fromCartas(Carta[] cartas) {
		return cartas
			.sort(false) { it.valor }
			.inject([] as List<List<Carta>>) { List<List<Carta>> acc, Carta carta ->
				List<Carta> sequenciaAnterior = acc.find {
					it.last().valor == carta.valor.previous()
				}

				List<List<Carta>> listaSemSequenciaAtual = acc.findAll { it != sequenciaAnterior }
				List<Carta> sequenciaAtual = (sequenciaAnterior ?: []) + [carta]

				return listaSemSequenciaAtual + [sequenciaAtual]
			}
			.findAll { it.size() > 1 }
			.collect { new Sequencia(it as Carta[]) }
	}

}
