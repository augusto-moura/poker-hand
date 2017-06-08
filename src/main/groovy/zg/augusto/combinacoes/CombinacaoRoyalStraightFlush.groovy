package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand
import zg.augusto.dominio.ValorCarta

class CombinacaoRoyalStraightFlush extends CombinacaoStraightFlush {

	CombinacaoRoyalStraightFlush(PokerHand mao) {
		super(mao)
	}

	@Override
	Boolean temCombinacao() {
		return super.temCombinacao() && mao.maiorCarta.valor == ValorCarta.AS
	}

	int compareTo(CombinacaoRoyalStraightFlush o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}

}
