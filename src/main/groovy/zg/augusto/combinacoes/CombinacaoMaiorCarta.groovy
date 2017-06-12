package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

class CombinacaoMaiorCarta extends Combinacao<CombinacaoMaiorCarta> {

	CombinacaoMaiorCarta(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.MAIOR_CARTA)
	}

	static Boolean temCombinacao(PokerHand mao) {
		return true
	}

	@Override
	int compararCom(CombinacaoMaiorCarta alvo) {
		return alvo.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}

}
