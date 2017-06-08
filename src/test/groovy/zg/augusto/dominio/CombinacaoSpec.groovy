package zg.augusto.dominio

import spock.lang.Specification
import spock.lang.Unroll

class CombinacaoSpec extends Specification {

	@Unroll
	def "Identificar as melhores combinações"() {
		given: "dado uma determinada cartas de poker"
		final PokerHand pokerHand = new PokerHand(cartas)

		expect: "é esperado determinada combinação como melhor"
		Combinacao.encontrarMelhorCombinacao(pokerHand) == respostaCombinacao

		where:
		cartas           || respostaCombinacao
		"AS 2H 5H 9D QS" || Combinacao.MAIOR_CARTA
		"2H 2S 4H 5H 6H" || Combinacao.PAR
		"2H 2S 4H 4C 6H" || Combinacao.DOIS_PARES
		"2H 2S 4H 2C 6H" || Combinacao.TRINCA
		"2H 3S 4H 5H 6H" || Combinacao.SEQUENCIA
		"2H AH 4H QH 6H" || Combinacao.FLUSH
		"2H 2S 3H 3C 3D" || Combinacao.FULL_HOUSE
		"2H 2S 3H 3C 3D" || Combinacao.FULL_HOUSE
		"2H 2S 4H 2C 2D" || Combinacao.QUADRA
		"2H 3H 4H 5H 6H" || Combinacao.STRAIGHT_FLUSH
		"TH JH QH KH AH" || Combinacao.ROYAL_STRAIGHT_FLUSH
	}

}