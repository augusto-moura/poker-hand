package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

class CombinacaoStraightFlush<T extends CombinacaoStraightFlush> extends CombinacaoSequencia<T> {

	CombinacaoStraightFlush(PokerHand mao, PossibilidadeCombinacoes tipo = PossibilidadeCombinacoes.STRAIGHT_FLUSH) {
		super(mao, tipo)
	}

	@Override
	Boolean temCombinacao() {
		final CombinacaoFlush combinacaoFlush = new CombinacaoFlush(mao)
		return super.temCombinacao() && combinacaoFlush.temCombinacao()
	}

	int compararCom(CombinacaoStraightFlush o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}
}
