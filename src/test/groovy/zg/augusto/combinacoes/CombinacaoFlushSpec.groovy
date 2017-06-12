package zg.augusto.combinacoes

import spock.lang.Specification
import zg.augusto.dominio.PokerHand

@SuppressWarnings("GroovyPointlessBoolean")
class CombinacaoFlushSpec extends Specification {

	def "Deve considerar cartas que tenham combinacao do tipo flush"() {
		given:
		PokerHand mao = new PokerHand(textoMao)

		expect:
		CombinacaoFlush.temCombinacao(mao) == temCombinacao

		where:
		textoMao         || temCombinacao
		"2S 6S QS KS 5S" || true
		"2S 6S QS KS 5C" || false
		"2S 6S QD KS 5C" || false
		"2C 6C QC KC 5C" || true
		"2H 6H QH KH 5H" || true
		"2D 6D QD KD 5D" || true
	}

	def "Quando comparado com outra combinacao do tipo flush, avaliar pela maior carta não repetida"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoFlush(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoFlush(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 6S QS AS 4S" | "2S 6S QS KS 5S" || 1
		"2S 6S QS 3S 4S" | "2S 6S QS KS 5S" || -1
		"2S 6S QS 3S 4S" | "2S 6S QS JS 5S" || -1
	}

}
