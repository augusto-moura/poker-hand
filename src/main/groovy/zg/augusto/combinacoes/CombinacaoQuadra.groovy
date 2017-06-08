package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

class CombinacaoQuadra extends Combinacao {

	CombinacaoQuadra(PokerHand mao) {
		super(mao)
	}

	@Override
	Boolean temCombinacao() {
		return mao.temGrupoComMesmoValor(QUANTIDADE_CARTAS_QUADRA)
	}

	int compareTo(CombinacaoQuadra o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}
}
