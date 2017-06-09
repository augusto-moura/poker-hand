package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand
import zg.augusto.dominio.ValorCarta

class CombinacaoRoyalStraightFlush extends CombinacaoStraightFlush<CombinacaoRoyalStraightFlush> {

	CombinacaoRoyalStraightFlush(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.STRAIGHT_FLUSH)
	}

	@Override
	Boolean temCombinacao() {
		return super.temCombinacao() && mao.maiorCarta.valor == ValorCarta.AS
	}

	int compararCom(CombinacaoRoyalStraightFlush o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}

}
