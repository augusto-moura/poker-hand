package zg.augusto.dominio

import spock.lang.Specification
import spock.lang.Unroll

class CartaSpec extends Specification {

	@Unroll
	def "Deveria construir a mao a partir de texto puro"() {
		expect:
		new Carta(textoCarta) == carta

		where:
		textoCarta || carta
		"2S"       || new Carta(Naipe.ESPADAS, ValorCarta.DOIS)
		"3D"       || new Carta(Naipe.OUROS, ValorCarta.TRES)
		"4C"       || new Carta(Naipe.PAUS, ValorCarta.QUATRO)
		"5H"       || new Carta(Naipe.COPAS, ValorCarta.CINCO)
		"6S"       || new Carta(Naipe.ESPADAS, ValorCarta.SEIS)
		"7D"       || new Carta(Naipe.OUROS, ValorCarta.SETE)
		"8H"       || new Carta(Naipe.COPAS, ValorCarta.OITO)
		"9C"       || new Carta(Naipe.PAUS, ValorCarta.NOVE)
		"TS"       || new Carta(Naipe.ESPADAS, ValorCarta.DEZ)
		"JS"       || new Carta(Naipe.ESPADAS, ValorCarta.VALETE)
		"QS"       || new Carta(Naipe.ESPADAS, ValorCarta.RAINHA)
		"KS"       || new Carta(Naipe.ESPADAS, ValorCarta.REI)
		"AS"       || new Carta(Naipe.ESPADAS, ValorCarta.AS)
	}

}
