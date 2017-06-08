package zg.augusto.gerenciador

import zg.augusto.combinacoes.Combinacao
import zg.augusto.combinacoes.CombinacaoDoisPares
import zg.augusto.combinacoes.CombinacaoFlush
import zg.augusto.combinacoes.CombinacaoFullHouse
import zg.augusto.combinacoes.CombinacaoPar
import zg.augusto.combinacoes.CombinacaoQuadra
import zg.augusto.combinacoes.CombinacaoRoyalStraightFlush
import zg.augusto.combinacoes.CombinacaoSequencia
import zg.augusto.combinacoes.CombinacaoStraightFlush
import zg.augusto.combinacoes.CombinacaoTrinca
import zg.augusto.dominio.PokerHand

class CategorizadorJogadas {

	final Combinacao[] combinacoes
	final PokerHand mao

	CategorizadorJogadas(PokerHand mao) {
		this.mao = mao
		this.combinacoes = [
			new CombinacaoRoyalStraightFlush(mao),
			new CombinacaoStraightFlush(mao),
			new CombinacaoQuadra(mao),
			new CombinacaoFullHouse(mao),
			new CombinacaoFlush(mao),
			new CombinacaoSequencia(mao),
			new CombinacaoTrinca(mao),
			new CombinacaoDoisPares(mao),
			new CombinacaoPar(mao),
		]
	}

	Combinacao calcularMelhorJogada() {
		return combinacoes.find { it.temCombinacao() }
	}
}
