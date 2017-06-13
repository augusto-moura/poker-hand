package zg.augusto.gerenciador

import zg.augusto.combinacoes.*
import zg.augusto.dominio.PokerHand

class CategorizadorJogadas {

	def static final COMBINACOES_POSSIVEIS = [
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

	static Combinacao calcularMelhorJogada(PokerHand mao) {
		return COMBINACOES_POSSIVEIS.find {
			return it.temCombinacao(mao)
		}?.newInstance(mao) ?: new CombinacaoMaiorCarta(mao)
	}

}
