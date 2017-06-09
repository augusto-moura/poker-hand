package zg.augusto.combinacoes

import zg.augusto.classificacoes.Sequencia
import zg.augusto.dominio.PokerHand

class CombinacaoSequencia <T extends CombinacaoSequencia> extends Combinacao<T> {

	CombinacaoSequencia(PokerHand mao, PossibilidadeCombinacoes tipo = PossibilidadeCombinacoes.SEQUENCIA) {
		super(mao, tipo)
	}

	@Override
	Boolean temCombinacao() {
		return mao.grupos.any { it instanceof Sequencia && it.cartas.size() == QUANTIDADE_MAXIMA_CARTAS_NA_MAO }
	}

	int compararCom(CombinacaoSequencia o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}
}
