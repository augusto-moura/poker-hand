package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

class CombinacaoPar extends Combinacao {

	CombinacaoPar(PokerHand mao) {
		super(mao)
	}

	@Override
	Boolean temCombinacao() {
		return mao.temGrupoComMesmoValor(QUANTIDADE_CARTAS_PAR)
	}

	int compareTo(CombinacaoPar o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}

}
