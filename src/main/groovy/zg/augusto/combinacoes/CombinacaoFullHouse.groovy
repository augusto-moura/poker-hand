package zg.augusto.combinacoes

import zg.augusto.classificacoes.MesmoValor
import zg.augusto.dominio.PokerHand

class CombinacaoFullHouse extends Combinacao {

	CombinacaoFullHouse(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.FULL_HOUSE)
	}

	static Boolean temCombinacao(PokerHand mao) {
		return mao.temGrupoComMesmoValor(QUANTIDADE_CARTAS_PAR) && mao.temGrupoComMesmoValor(QUANTIDADE_CARTAS_TRINCA)
	}

	int compararCom(CombinacaoFullHouse alvo) {
		int comparacaoTrinca = comparaTrinca(alvo)

		if (comparacaoTrinca != 0) {
			return comparacaoTrinca
		}

		return comparaPar(alvo)
	}

	private int comparaTrinca(CombinacaoFullHouse alvo) {
		return comparaValorGrupoComNCartas(QUANTIDADE_CARTAS_TRINCA, alvo)
	}

	private int comparaPar(CombinacaoFullHouse alvo) {
		return comparaValorGrupoComNCartas(QUANTIDADE_CARTAS_PAR, alvo)
	}

	private int comparaValorGrupoComNCartas(int nCartas, CombinacaoFullHouse alvo) {
		final MesmoValor trincaAtual = mao.grupos.find {
			return it instanceof MesmoValor && it.cartas.size() == nCartas
		} as MesmoValor

		final MesmoValor trincaAlvo = alvo.mao.grupos.find {
			return it instanceof MesmoValor && it.cartas.size() == nCartas
		} as MesmoValor

		return trincaAtual.valor <=> trincaAlvo.valor
	}

}
