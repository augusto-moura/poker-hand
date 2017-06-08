package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand
import zg.augusto.dominio.ValorCarta

class CombinacaoStraightFlush extends CombinacaoSequencia {

	CombinacaoStraightFlush(PokerHand mao) {
		super(mao)
	}

	@Override
	Boolean temCombinacao() {
		final CombinacaoFlush combinacaoFlush = new CombinacaoFlush(mao)
		return super.temCombinacao() && combinacaoFlush.temCombinacao()
	}

	int compareTo(CombinacaoStraightFlush o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}
}
