package zg.augusto.classificacoes

import spock.lang.Specification
import spock.lang.Unroll
import zg.augusto.dominio.Carta
import zg.augusto.dominio.Naipe
import zg.augusto.dominio.PokerHand
import zg.augusto.dominio.ValorCarta

class MesmoNaipeSpec extends Specification {

	@Unroll
	def "Encontra corretamente grupos de mesmo naipe"() {
		given: "dada uma mão com determinadas cartas"
		PokerHand maoPoker = new PokerHand(cartas)

		expect: "os grupos de mesmo naipe deveriam ser"
		MesmoNaipe.fromCartas(maoPoker.cartas).collect { (it.cartas as List<Carta>).toSet() }.toSet() as Set<Set<Carta>> == grupoCartas

		where:
		cartas           || grupoCartas
		'2S 3S 4C 5H 7C' || [[new Carta(Naipe.ESPADAS, ValorCarta.DOIS), new Carta(Naipe.ESPADAS, ValorCarta.TRES)].toSet(), [new Carta(Naipe.PAUS, ValorCarta.QUATRO), new Carta(Naipe.PAUS, ValorCarta.SETE)].toSet()].toSet()
		'2S 3S 4S 5H 7C' || [[new Carta(Naipe.ESPADAS, ValorCarta.DOIS), new Carta(Naipe.ESPADAS, ValorCarta.TRES), new Carta(Naipe.ESPADAS, ValorCarta.QUATRO)].toSet()].toSet()
		'2S 3D 4S 5H 7C' || [[new Carta(Naipe.ESPADAS, ValorCarta.DOIS), new Carta(Naipe.ESPADAS, ValorCarta.QUATRO)].toSet()].toSet()
	}

}
