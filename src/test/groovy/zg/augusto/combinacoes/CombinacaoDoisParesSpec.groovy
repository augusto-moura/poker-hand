package zg.augusto.combinacoes

import spock.lang.Specification
import spock.lang.Unroll
import zg.augusto.dominio.PokerHand

class CombinacaoDoisParesSpec extends Specification {

	@Unroll
	def "Deve considerar uma mao que tenha no minimo 2 pares como uma combinacao válida"() {
		given:
		PokerHand mao = new PokerHand(maoStr)

		expect:
		CombinacaoDoisPares.temCombinacao(mao) == temCombinacao

		where:
		maoStr           || temCombinacao
		"2C 2D 4D JS JH" || true
		"2C 5D 2D QS QH" || true
		"7C 2H 2D QS QH" || true
		"7C 2H JD QS QH" || false
		"7C 2H JD KS JH" || false
		"7C 2H 2D QS 4H" || false
	}

	def "Quando comparado com uma combinacao de dois pares, avaliar pela carta do maior par"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoDoisPares(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoDoisPares(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"5C 5D 3H 3D 7H" | "7S 7D AC AS KD" || -1
		"QC QD 3H 3D 7H" | "7S 7D 3C 3S KD" || 1
		"QC QD 3H 3D 7H" | "KS KD 3C 3S JD" || -1
	}

	def "Quando comparado com uma combinacao de dois pares e com mesma carta no maior par, avaliar pela maior carta menor par"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoDoisPares(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoDoisPares(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"AH AD 5C 5D 7H" | "AC AS 7S 7D KD" || -1
		"AH AD QC QD 7H" | "AC AS 7S 7D KD" || 1
		"AH AD JC JD 7H" | "AC AS QS QD KD" || -1
	}

	def "Quando comparado com uma combinacao de dois pares, com as mesmas cartas nos dois pares avaliar pela carta sobrando(kicker)"() {
		given:
		final PokerHand maoFoo = new PokerHand(strMaoFoo)
		final Combinacao combinacaoFoo = new CombinacaoDoisPares(maoFoo)

		final PokerHand maoBar = new PokerHand(strMaoBar)
		final Combinacao combinacaoBar = new CombinacaoDoisPares(maoBar)

		expect:
		combinacaoFoo.compararCom(combinacaoBar) == result

		where:
		strMaoFoo        | strMaoBar        || result
		"AH AD 5C 5D 7H" | "AC AS 5S 5H KD" || -1
		"AH AD 5C 5D 7H" | "AC AS 5S 5H 3D" || 1
		"AH AD 5C 5D 4H" | "AC AS 5S 5H 6D" || -1
	}
}
