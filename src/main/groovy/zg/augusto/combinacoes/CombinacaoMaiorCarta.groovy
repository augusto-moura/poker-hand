package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

class CombinacaoMaiorCarta extends Combinacao<CombinacaoMaiorCarta> {

	CombinacaoMaiorCarta(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.MAIOR_CARTA)
	}

	@Override
	Boolean temCombinacao() {
		return true
	}

	@Override
	int compararCom(CombinacaoMaiorCarta alvo) {
		return alvo.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}

}
