package zg.augusto.combinacoes

import zg.augusto.classificacoes.MesmoValor
import zg.augusto.dominio.Carta
import zg.augusto.dominio.PokerHand

class CombinacaoPar extends Combinacao<CombinacaoPar> {

	CombinacaoPar(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.PAR)
	}

	static Boolean temCombinacao(PokerHand mao) {
		return mao.temGrupoComMesmoValor(QUANTIDADE_CARTAS_PAR)
	}

	@Override
	int compararCom(CombinacaoPar o) {
		MesmoValor parAtual = mao.grupos.find { it instanceof MesmoValor } as MesmoValor
		MesmoValor parAlvo = o.mao.grupos.find { it instanceof MesmoValor } as MesmoValor

		int comparacaoPares = parAtual.valor <=> parAlvo.valor
		if (comparacaoPares != 0) {
			return comparacaoPares
		}


		return [
			(mao.cartas - parAtual.cartas).sort(false).reverse(),
			(o.mao.cartas - parAlvo.cartas).sort(false).reverse(),
		].transpose().collect { parAtualAlvo ->
			def (Carta cartaAtual, Carta cartaAlvo) = parAtualAlvo
			return cartaAtual <=> cartaAlvo
		}.find { it != 0 } ?: 0
	}

}
