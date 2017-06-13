package zg.augusto.combinacoes

import zg.augusto.classificacoes.MesmoValor
import zg.augusto.dominio.Carta
import zg.augusto.dominio.PokerHand

class CombinacaoTrinca extends Combinacao {

	CombinacaoTrinca(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.TRINCA)
	}

	static Boolean temCombinacao(PokerHand mao) {
		return mao.temGrupoComMesmoValor(QUANTIDADE_CARTAS_TRINCA)
	}

	int compararCom(CombinacaoTrinca alvo) {
		final MesmoValor trincaAtual = mao.grupos.find {
			return it instanceof MesmoValor && it.cartas.size() == QUANTIDADE_CARTAS_TRINCA
		} as MesmoValor

		final MesmoValor trincaAlvo = alvo.mao.grupos.find {
			return it instanceof MesmoValor && it.cartas.size() == QUANTIDADE_CARTAS_TRINCA
		} as MesmoValor

		int comparacaoTrinca = trincaAtual.valor <=> trincaAlvo.valor
		if (comparacaoTrinca != 0) {
			return comparacaoTrinca
		}

		return [
			(mao.cartas - trincaAtual.cartas).sort(false).reverse(),
			(alvo.mao.cartas - trincaAlvo.cartas).sort(false).reverse(),
		].transpose().collect { parAtualAlvo ->
			def (Carta cartaAtual, Carta cartaAlvo) = parAtualAlvo
			return cartaAtual <=> cartaAlvo
		}.find { it != 0 } ?: 0
	}

}
