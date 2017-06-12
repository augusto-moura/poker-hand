package zg.augusto.gerenciador

import zg.augusto.combinacoes.*
import zg.augusto.dominio.PokerHand

class CategorizadorJogadas {

	static private final List<CombinacaoEntry> COMBINACOES_POSSIVEIS = [
		new CombinacaoEntry(predicado: CombinacaoRoyalStraightFlush.&temCombinacao, classe: CombinacaoRoyalStraightFlush),
		new CombinacaoEntry(predicado: CombinacaoStraightFlush.&temCombinacao, classe: CombinacaoStraightFlush),
		new CombinacaoEntry(predicado: CombinacaoQuadra.&temCombinacao, classe: CombinacaoQuadra),
		new CombinacaoEntry(predicado: CombinacaoFullHouse.&temCombinacao, classe: CombinacaoFullHouse),
		new CombinacaoEntry(predicado: CombinacaoFlush.&temCombinacao, classe: CombinacaoFlush),
		new CombinacaoEntry(predicado: CombinacaoSequencia.&temCombinacao, classe: CombinacaoSequencia),
		new CombinacaoEntry(predicado: CombinacaoTrinca.&temCombinacao, classe: CombinacaoTrinca),
		new CombinacaoEntry(predicado: CombinacaoDoisPares.&temCombinacao, classe: CombinacaoDoisPares),
		new CombinacaoEntry(predicado: CombinacaoPar.&temCombinacao, classe: CombinacaoPar),
	]

	static Combinacao calcularMelhorJogada(PokerHand mao) {
		return (COMBINACOES_POSSIVEIS.find { it.predicado(mao) }?.classe?.newInstance(mao)) ?: (new CombinacaoMaiorCarta(mao))
	}

	private static class CombinacaoEntry {
		Closure<Boolean> predicado
		Class<Combinacao> classe
	}

}
