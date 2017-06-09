package zg.augusto.combinacoes

import zg.augusto.dominio.PokerHand

abstract class Combinacao<T> {

	protected static final Integer QUANTIDADE_CARTAS_PAR = 2
	protected static final Integer QUANTIDADE_CARTAS_TRINCA = 3
	protected static final QUANTIDADE_CARTAS_QUADRA = 4
	protected static final Integer QUANTIDADE_MAXIMA_CARTAS_NA_MAO = 5


	final PokerHand mao
	final PossibilidadeCombinacoes tipo

	Combinacao(PokerHand mao, PossibilidadeCombinacoes tipo) {
		this.mao = mao
		this.tipo = tipo
	}

	int compararCom(Combinacao o) {
	 	return tipo <=> o.tipo
	}

	abstract Boolean temCombinacao()

	abstract int compararCom(T alvo)

}
