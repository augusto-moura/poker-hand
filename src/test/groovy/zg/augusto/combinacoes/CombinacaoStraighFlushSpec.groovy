package zg.augusto.combinacoes

import spock.lang.Specification
import spock.lang.Unroll
import zg.augusto.dominio.PokerHand

@SuppressWarnings("GroovyPointlessBoolean")
class CombinacaoStraighFlushSpec extends Specification {

	@Unroll
	def "Deve considerar uma combinação válida toda mão que esteja em sequência e seja do mesmo naipe"() {
		given:
		PokerHand mao = new PokerHand(textoMao)

		expect:
		CombinacaoStraightFlush.temCombinacao(mao) == temCombinacao

		where:
		textoMao         || temCombinacao
		"AS KS QS JS TS" || true
		"3S KS QS JS 6S" || false
		"AS KC QD JD TH" || false
		"8S 7S 6S 5S 4S" || true
	}

	@Unroll
	def "Quando comparado com outra combinação do tipo StraightFlush, avaliar maior carta"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoStraightFlush(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoStraightFlush(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 3S 4S 6S 5S" | "9C QC JC TC KC" || -1
		"AD KD JD TD QD" | "9H QH JH TH KH" || 1
	}

}
