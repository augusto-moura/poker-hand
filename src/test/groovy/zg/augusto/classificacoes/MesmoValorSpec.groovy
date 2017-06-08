package zg.augusto.classificacoes

import spock.lang.Specification
import spock.lang.Unroll
import zg.augusto.dominio.Carta
import zg.augusto.dominio.Naipe
import zg.augusto.dominio.PokerHand
import zg.augusto.dominio.ValorCarta

class MesmoValorSpec extends Specification {

	@Unroll
	def "Encontra corretamente grupos de mesmo valor"() {
		given: "dada uma mão com determinadas cartas"
		PokerHand maoPoker = new PokerHand(cartas)

		expect: "os grupos de mesmo valor deveriam ser"
		MesmoValor.fromCartas(maoPoker.cartas).collect {it.cartas as Set<Carta>}.toSet() == grupoCartas

		where:
		cartas           || grupoCartas
		'2S 2H 4C 5H 7C' || [[new Carta(Naipe.ESPADAS, ValorCarta.DOIS), new Carta(Naipe.COPAS, ValorCarta.DOIS)].toSet()].toSet()
		'2S 2H 2C 5H 7C' || [[new Carta(Naipe.ESPADAS, ValorCarta.DOIS), new Carta(Naipe.COPAS, ValorCarta.DOIS), new Carta(Naipe.PAUS, ValorCarta.DOIS)].toSet()].toSet()
		'2S 2H 4S 4H 7C' || [[new Carta(Naipe.ESPADAS, ValorCarta.DOIS), new Carta(Naipe.COPAS, ValorCarta.DOIS)].toSet(), [new Carta(Naipe.ESPADAS, ValorCarta.QUATRO), new Carta(Naipe.COPAS, ValorCarta.QUATRO)].toSet()].toSet()
		'2S 3D 4S 5H 7C' || [].toSet()
	}

}
