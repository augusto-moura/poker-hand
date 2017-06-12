package zg.augusto.combinacoes

import spock.lang.Specification
import zg.augusto.dominio.PokerHand

@SuppressWarnings("GroovyPointlessBoolean")
class CombinacaoFullHouseSpec extends Specification {

	def "Dever considerar como uma combinação válida mãos com uma dupla e uma trinca"() {
		given:
		PokerHand mao = new PokerHand(textoMao)

		expect:
		CombinacaoFullHouse.temCombinacao(mao) == temCombinacao

		where:
		textoMao         || temCombinacao
		"2S 2C 2D KD KH" || true
		"2S 2C 3D KD KH" || false
		"3S 3C 3D JD JH" || true
	}

	def "Quando comparado com outra combinacao do tipo fullhouse, avaliar pela maior carta da trinca"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoFlush(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoFlush(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 2C 2D KD KH" | "4S 4C 4D KD KH" || -1
		"QS QC QD KD KH" | "4S 4C 4D KD KH" || 1
		"3S 3C 3D KD KH" | "4S 4C 4D KD KH" || -1
	}

	def "Quando comparado com outra combinacao do tipo fullhouse e mesma trinca, avaliar pela maior carta da dupla"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoFlush(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoFlush(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 2C 2D KD KH" | "2S 2C 2D JD JH" || 1
		"2S 2C 2D 8D 8H" | "2S 2C 2D JD JH" || -1
		"2S 2C 2D 8D 8H" | "2S 2C 2D AD AH" || -1
		"2S 2C 2D 8D 8H" | "2S 2C 2D 2D 2H" || 1
	}

}
