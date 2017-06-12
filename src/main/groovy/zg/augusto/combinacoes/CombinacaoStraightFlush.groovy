package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

class CombinacaoStraightFlush extends Combinacao<CombinacaoStraightFlush> {

	CombinacaoStraightFlush(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.STRAIGHT_FLUSH)
	}

	static Boolean temCombinacao(PokerHand mao) {
		return CombinacaoSequencia.temCombinacao(mao) && CombinacaoFlush.temCombinacao(mao)
	}

	int compararCom(CombinacaoStraightFlush o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}

}
