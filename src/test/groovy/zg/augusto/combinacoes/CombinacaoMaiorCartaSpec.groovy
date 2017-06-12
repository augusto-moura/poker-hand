package zg.augusto.combinacoes

import spock.lang.Specification
import zg.augusto.dominio.PokerHand

class CombinacaoMaiorCartaSpec extends Specification {

	def "Toda mão deve ter uma combinação do tipo MaiorCarta"() {
		given:
		PokerHand mao = new PokerHand(textoMao)

		expect:
		CombinacaoMaiorCarta.temCombinacao(mao) == temCombinacao

		where:
		textoMao         || temCombinacao
		"2S 2C 2D KD KH" || true
		"2S 2C 3D KD KH" || true
		"3S 3C 3D JD JH" || true
		"2S 6S QS KS 5S" || true
		"2S 6S QS KS 5C" || true
		"2S 6S QD KS 5C" || true
		"2C 6C QC KC 5C" || true
		"2H 6H QH KH 5H" || true
		"2D 6D QD KD 5D" || true
	}

	def "Quando comparado com outra combinação do tipo MaiorCarta, deve ser avaliada a maior carta das mãos"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoFlush(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoFlush(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"2S 2C 2D KD KH" | "4S 4C 4D KD AH" || -1
		"QS QC QD AD KH" | "4S 4C 4D KD JH" || 1
		"3S 3C 3D TD 2H" | "4S 4C 4D 5D 6H" || 1
	}

}
