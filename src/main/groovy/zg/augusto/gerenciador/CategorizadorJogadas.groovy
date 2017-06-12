package zg.augusto.gerenciador

import zg.augusto.combinacoes.*
import zg.augusto.dominio.PokerHand

class CategorizadorJogadas {

	static private final Class<Combinacao>[] COMBINACOES_POSSIVEIS = [
		CombinacaoRoyalStraightFlush,
		CombinacaoStraightFlush,
		CombinacaoQuadra,
		CombinacaoFullHouse,
		CombinacaoFlush,
		CombinacaoSequencia,
		CombinacaoTrinca,
		CombinacaoDoisPares,
		CombinacaoPar,
	]

	final Combinacao melhorCombinacao
	final PokerHand mao

	CategorizadorJogadas(PokerHand mao) {
		this.mao = mao
		this.melhorCombinacao = calcularMelhorJogada()
	}

	Combinacao calcularMelhorJogada() {
		for (Class<Combinacao> comb in COMBINACOES_POSSIVEIS) {
			final Combinacao auxCombinacao = comb.newInstance(mao)

			if (auxCombinacao.temCombinacao()) {
				return auxCombinacao
			}
		}

		return new CombinacaoMaiorCarta(mao)
	}
}
