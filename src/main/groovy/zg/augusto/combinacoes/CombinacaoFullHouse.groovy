package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

class CombinacaoFullHouse extends Combinacao {

	CombinacaoFullHouse(PokerHand mao) {
		super(mao)
	}

	@Override
	Boolean temCombinacao() {
		return mao.temGrupoComMesmoValor(QUANTIDADE_CARTAS_PAR) && mao.temGrupoComMesmoValor(QUANTIDADE_CARTAS_TRINCA)
	}

	int compareTo(CombinacaoFullHouse o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}
}
