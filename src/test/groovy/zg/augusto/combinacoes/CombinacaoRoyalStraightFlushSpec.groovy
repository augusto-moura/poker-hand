package zg.augusto.combinacoes

import spock.lang.Specification
import spock.lang.Unroll
import zg.augusto.dominio.PokerHand

@SuppressWarnings("GroovyPointlessBoolean")
class CombinacaoRoyalStraightFlushSpec extends Specification {

	@Unroll
	def "Deve considerar uma combinação válida toda mão que esteja em sequência e seja do mesmo naipe com a maior carta como ás"() {
		given:
		PokerHand mao = new PokerHand(textoMao)

		expect:
		CombinacaoRoyalStraightFlush.temCombinacao(mao) == temCombinacao

		where:
		textoMao         || temCombinacao
		"AS KS QS JS TS" || true
		"8S KS QS JS 9S" || false
		"AS KC QD JD TH" || false
		"2S 3S KS KS KS" || false
	}

}
