package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

class CombinacaoMaiorCarta extends Combinacao {

	CombinacaoMaiorCarta(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.MAIOR_CARTA)
	}

	static Boolean temCombinacao(PokerHand mao) {
		return true
	}

	int compararCom(CombinacaoMaiorCarta alvo) {
		return mao.maiorCarta <=> alvo.mao.maiorCarta
	}

}
