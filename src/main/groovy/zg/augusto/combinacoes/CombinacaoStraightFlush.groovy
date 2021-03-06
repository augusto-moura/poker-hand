package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

class CombinacaoStraightFlush extends Combinacao {

	CombinacaoStraightFlush(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.STRAIGHT_FLUSH)
	}

	static Boolean temCombinacao(PokerHand mao) {
		return CombinacaoSequencia.temCombinacao(mao) && CombinacaoFlush.temCombinacao(mao)
	}

	int compararCom(CombinacaoStraightFlush o) {
		return mao.maiorCarta <=> o.mao.maiorCarta
	}

}
