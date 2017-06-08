package zg.augusto.combinacoes

import zg.augusto.classificacoes.MesmoNaipe
import zg.augusto.dominio.PokerHand

class CombinacaoFlush extends Combinacao {

	CombinacaoFlush(PokerHand mao) {
		super(mao)
	}

	@Override
	Boolean temCombinacao() {
		return mao.grupos.any { it instanceof MesmoNaipe && it.cartas.size() == QUANTIDADE_MAXIMA_CARTAS_NA_MAO }
	}

	int compareTo(CombinacaoFlush o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}

}
