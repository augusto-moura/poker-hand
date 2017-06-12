package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand
import zg.augusto.dominio.ValorCarta

class CombinacaoRoyalStraightFlush extends Combinacao {

	CombinacaoRoyalStraightFlush(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.STRAIGHT_FLUSH)
	}

	static Boolean temCombinacao(PokerHand mao) {
		return CombinacaoStraightFlush.temCombinacao(mao) && mao.maiorCarta.valor == ValorCarta.AS
	}

	int compararCom(CombinacaoRoyalStraightFlush o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}

}
