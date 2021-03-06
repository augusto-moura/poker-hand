package zg.augusto.combinacoes

import zg.augusto.classificacoes.MesmoValor
import zg.augusto.dominio.Carta
import zg.augusto.dominio.PokerHand

class CombinacaoQuadra extends Combinacao {

	CombinacaoQuadra(PokerHand mao) {
		super(mao, PossibilidadeCombinacoes.QUADRA)
	}

	static Boolean temCombinacao(PokerHand mao) {
		return mao.temGrupoComMesmoValor(QUANTIDADE_CARTAS_QUADRA)
	}

	int compararCom(CombinacaoQuadra alvo) {
		final MesmoValor quadraAtual = mao.grupos.find {it instanceof MesmoValor} as MesmoValor
		final MesmoValor quadraAlvo = alvo.mao.grupos.find {it instanceof MesmoValor} as MesmoValor

		int comparacaoQuadra = quadraAtual.valor <=> quadraAlvo.valor
		if (comparacaoQuadra != 0) {
			return comparacaoQuadra
		}

		final Carta kickerAtual = (mao.cartas - quadraAtual.cartas)[0]
		final Carta kickerAlvo = (alvo.mao.cartas - quadraAlvo.cartas)[0]

		return kickerAtual <=> kickerAlvo
	}

}
