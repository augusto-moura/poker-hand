package zg.augusto.combinacoes

import spock.lang.Specification
import spock.lang.Unroll
import zg.augusto.dominio.PokerHand

@SuppressWarnings("GroovyPointlessBoolean")
class CombinacaoSequenciaSpec extends Specification {

	@Unroll
	def "Deve considerar uma combinação válida toda mão que esteja em sequência"() {
		given:
		PokerHand mao = new PokerHand(textoMao)

		expect:
		CombinacaoSequencia.temCombinacao(mao) == temCombinacao

		where:
		textoMao         || temCombinacao
		"AS KS QS JS TS" || true
		"9S KS QS JS TS" || true
		"AS KC QD JD TH" || true
		"2S 3S KS KS KS" || false
	}

	@Unroll
	def "Quando comparado com outra combinação do tipo Sequencia, avaliar maior carta"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoSequencia(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoSequencia(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 3C 4D 6D 5H" | "9S QC JD TD KH" || -1
		"AS KC JD TD QH" | "9S QC JD TD KH" || 1
	}

}
