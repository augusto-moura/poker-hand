package zg.augusto.combinacoes

import zg.augusto.classificacoes.MesmoValor
import zg.augusto.dominio.PokerHand

class CombinacaoTrinca extends Combinacao<CombinacaoTrinca> {

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

		return trincaAtual.valor <=> trincaAlvo.valor
	}

}
