package zg.augusto.combinacoes

import zg.augusto.classificacoes.MesmoValor
import zg.augusto.dominio.PokerHand

class CombinacaoDoisPares extends Combinacao {

	CombinacaoDoisPares(PokerHand mao) {
		super(mao)
	}

	@Override
	Boolean temCombinacao() {
		return mao.grupos.findAll {
			return it instanceof MesmoValor && it.cartas.size() == QUANTIDADE_CARTAS_PAR
		}.size() == QUANTIDADE_CARTAS_PAR
	}

	int compareTo(CombinacaoDoisPares o) {
		return o.mao.maiorCarta.naipe <=> mao.maiorCarta.naipe
	}

}
