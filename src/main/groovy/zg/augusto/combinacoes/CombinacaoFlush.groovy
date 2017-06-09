package zg.augusto.combinacoes

import zg.augusto.classificacoes.MesmoNaipe
import zg.augusto.dominio.Carta
import zg.augusto.dominio.PokerHand

class CombinacaoFlush extends Combinacao<CombinacaoFlush> {

	CombinacaoFlush(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.FLUSH)
	}

	@Override
	Boolean temCombinacao() {
		return mao.grupos.any { it instanceof MesmoNaipe && it.cartas.size() == QUANTIDADE_MAXIMA_CARTAS_NA_MAO }
	}

	@Override
	int compararCom(CombinacaoFlush alvo) {
		return [
			mao.cartas.sort(false).reverse(),
			alvo.mao.cartas.sort(false).reverse(),
		].transpose().collect { parAtualAlvo ->
			def (Carta cartaAtual, Carta cartaAlvo) = parAtualAlvo
			return cartaAtual <=> cartaAlvo
		}.find { it != 0 } ?: 0
	}

}
