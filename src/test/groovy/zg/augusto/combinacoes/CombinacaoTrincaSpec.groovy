package zg.augusto.combinacoes

import spock.lang.Specification
import spock.lang.Unroll
import zg.augusto.dominio.PokerHand

@SuppressWarnings("GroovyPointlessBoolean")
class CombinacaoTrincaSpec extends Specification {

	@Unroll
	def "Deve considerar uma combinação válida toda mão que tenham uma trinca de cartas com mesmo valores"() {
		given:
		PokerHand mao = new PokerHand(textoMao)

		expect:
		CombinacaoTrinca.temCombinacao(mao) == temCombinacao

		where:
		textoMao         || temCombinacao
		"AS KS JS JD JH" || true
		"AS AC JS JD JH" || true
		"3S KS QS JS 6S" || false
		"AS KC QD JD TH" || false
		"AS 7S AD AC 4S" || true
	}

	@Unroll
	def "Quando comparado com outra combinação do tipo Trinca, avaliar maior carta das trincas"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoTrinca(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoTrinca(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 3S 4S 4D 4C" | "9C QC AC AS AH" || -1
		"2S 3S TS TD TC" | "9C QC 8C 8S 8H" || 1
	}

	@Unroll
	def "Quando comparado com outra combinação do tipo Trinca e mesma trinca, avaliar maior carta não repetida fora da trinca"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoTrinca(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoTrinca(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 3S AC AS AH" | "9C QC AC AS AH" || -1
		"KS 3S AC AS AH" | "9C QC AC AS AH" || 1
		"KS 3S AC AS AH" | "KS 4C AC AS AH" || -1
	}

}
