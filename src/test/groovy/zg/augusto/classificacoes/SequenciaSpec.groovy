package zg.augusto.classificacoes

import spock.lang.Specification
import spock.lang.Unroll
import zg.augusto.dominio.Carta
import zg.augusto.dominio.Naipe
import zg.augusto.dominio.PokerHand
import zg.augusto.dominio.ValorCarta

class SequenciaSpec extends Specification {

	@Unroll
	def "Encontra corretamente grupos em sequencia"() {
		given: "dada uma mão com determinadas cartas"
		PokerHand maoPoker = new PokerHand(cartas)

		expect: "os grupos em sequencia de valor deveriam ser"
		Sequencia.fromCartas(maoPoker.cartas).collect {it.cartas} as List<Grupo> == grupoCartas

		where:
		cartas           || grupoCartas
		'2S 3H 4C QH 7C' || [[new Carta(Naipe.ESPADAS, ValorCarta.DOIS), new Carta(Naipe.COPAS, ValorCarta.TRES), new Carta(Naipe.PAUS, ValorCarta.QUATRO)]]
		'2S 2H 4S 5H 7C' || [[new Carta(Naipe.ESPADAS, ValorCarta.QUATRO), new Carta(Naipe.COPAS, ValorCarta.CINCO)]]
		'KS AH 4S 5H 7C' || [[new Carta(Naipe.ESPADAS, ValorCarta.QUATRO), new Carta(Naipe.COPAS, ValorCarta.CINCO)], [new Carta(Naipe.ESPADAS, ValorCarta.REI), new Carta(Naipe.COPAS, ValorCarta.AS)]]
		'2S QD 4S 9H 7C' || []
	}
}
