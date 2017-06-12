package zg.augusto.combinacoes

import spock.lang.Specification
import spock.lang.Unroll
import zg.augusto.dominio.PokerHand

@SuppressWarnings("GroovyPointlessBoolean")
class CombinacaoQuadraSpec extends Specification {

	@Unroll
	def "Deve considerar uma combinação válida toda mão que tenha uma quadra de cartas"() {
		given:
		PokerHand mao = new PokerHand(textoMao)

		expect:
		CombinacaoQuadra.temCombinacao(mao) == temCombinacao

		where:
		textoMao         || temCombinacao
		"2S 2C 2D 2H JH" || true
		"2S 2C 4D KD KH" || false
		"2S 3C KS KD KH" || false
		"2S KC KD KS KH" || true
	}

	@Unroll
	def "Quando comparado a outra combinação do tipo quadra, avaliar pela carta das quadras"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoQuadra(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoQuadra(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 2C 2H 2D 8H" | "AS AC AD AH JH" || -1
		"8S 8C 8H 8D 7H" | "4S 4C 4D 4H JH" || 1
	}

}
