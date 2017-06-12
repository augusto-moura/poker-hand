package zg.augusto.combinacoes

import spock.lang.Specification
import spock.lang.Unroll
import zg.augusto.dominio.PokerHand

class CombinacaoParSpec extends Specification {

	@Unroll
	def "Deve considerar uma combinação válida toda mão que tenha apenas um par de cartas iguais"() {
		given:
		PokerHand mao = new PokerHand(textoMao)

		expect:
		CombinacaoPar.temCombinacao(mao) == temCombinacao

		where:
		textoMao         || temCombinacao
		"2S 2C 4D KD JH" || true
		"2S 2C 4D KD KH" || false
		"2S 3C 4D KD KH" || true
		"2S 3C KD KD KH" || false
		"2S 2C KD KD KH" || false
	}

	@Unroll
	def "Quando comparado com outra combinação do tipo par, avaliar maior carta dos pares"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoFlush(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoFlush(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 2C 3D 4D 8H" | "4S 4C 9D TD JH" || -1
		"AS AC 3D 4D 8H" | "4S 4C 9D TD JH" || 1
	}

	@Unroll
	def "Quando comparado com outra combinação do tipo par e mesmo carta do par, avaliar maior fora dos pares não repetida"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoFlush(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoFlush(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 2C 3D 4D 8H" | "2S 2C 9D TD JH" || -1
		"2S 2C 3D JD AH" | "2S 2C 9D TD AH" || 1
		"2S 2C 3D 4D 8H" | "2S 2C 3D 4D 5H" || 1
	}
}
