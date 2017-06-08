package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

class CombinacaoTrinca extends Combinacao {

	CombinacaoTrinca(PokerHand mao) {
		super(mao)
	}

	@Override
	Boolean temCombinacao() {
		return mao.temGrupoComMesmoValor(QUANTIDADE_CARTAS_TRINCA)
	}

	int compareTo(CombinacaoTrinca o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}
}
