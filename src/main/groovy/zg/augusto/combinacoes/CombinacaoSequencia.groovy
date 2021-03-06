package zg.augusto.combinacoes

import zg.augusto.classificacoes.Sequencia
import zg.augusto.dominio.PokerHand

class CombinacaoSequencia extends Combinacao {

	CombinacaoSequencia(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.SEQUENCIA)
	}

	static Boolean temCombinacao(PokerHand mao) {
		return mao.grupos.any { it instanceof Sequencia && it.cartas.size() == QUANTIDADE_MAXIMA_CARTAS_NA_MAO }
	}

	int compararCom(CombinacaoSequencia o) {
		return mao.maiorCarta <=> o.mao.maiorCarta
	}

}
