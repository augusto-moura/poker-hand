package zg.augusto.gerenciador

import zg.augusto.combinacoes.*
import zg.augusto.dominio.PokerHand
import zg.augusto.utils.Dupla

class CategorizadorJogadas {

	static private final List<Dupla<Closure<Boolean>, Class<Combinacao>>> COMBINACOES_POSSIVEIS = [
		new Dupla<>(CombinacaoRoyalStraightFlush.&temCombinacao, CombinacaoRoyalStraightFlush),
		new Dupla<>(CombinacaoStraightFlush.&temCombinacao, CombinacaoStraightFlush),
		new Dupla<>(CombinacaoQuadra.&temCombinacao, CombinacaoQuadra),
		new Dupla<>(CombinacaoFullHouse.&temCombinacao, CombinacaoFullHouse),
		new Dupla<>(CombinacaoFlush.&temCombinacao, CombinacaoFlush),
		new Dupla<>(CombinacaoSequencia.&temCombinacao, CombinacaoSequencia),
		new Dupla<>(CombinacaoTrinca.&temCombinacao, CombinacaoTrinca),
		new Dupla<>(CombinacaoDoisPares.&temCombinacao, CombinacaoDoisPares),
		new Dupla<>(CombinacaoPar.&temCombinacao, CombinacaoPar),
	]

	static Combinacao calcularMelhorJogada(PokerHand mao) {
		return COMBINACOES_POSSIVEIS.find {
			Closure<Boolean> predicado = it.get1()
			return predicado(mao)
		}?.get2()?.newInstance(mao) ?: new CombinacaoMaiorCarta(mao)
	}
}
