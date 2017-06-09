package zg.augusto.dominio

import spock.lang.Specification
import spock.lang.Unroll

class PokerHandSpec extends Specification {

	@Unroll
	def "Deve resultar em vitória ou derrota quando comparada com outra mão"() {
		given: "dada uma mão de poker Foo e uma mão de poker Bar"
		final PokerHand foo = new PokerHand(maoFoo)
		final PokerHand bar = new PokerHand(maoBar)

		expect: "espera-se que a comparação dessas mão dê determinado resultado"
		foo.compareWith(bar) == resultadoEsperado

		where:
		maoFoo           | maoBar           || resultadoEsperado
		"TC TH 5C 5H KH" | "9C 9H 5C 5H AC" || Result.WIN
		"TS TD KC JC 7C" | "JS JC AS KC TD" || Result.LOSS
		"7H 7C QC JS TS" | "7D 7C JS TS 6D" || Result.WIN
		"5S 5D 8C 7S 6H" | "7D 7S 5S 5D JS" || Result.LOSS
		"AS AD KD 7C 3D" | "AD AH KD 7C 4S" || Result.LOSS
		"TS JS QS KS AS" | "AC AH AS AS KS" || Result.WIN
		"TS JS QS KS AS" | "TC JS QC KS AC" || Result.WIN
		"TS JS QS KS AS" | "QH QS QC AS 8H" || Result.WIN
		"AC AH AS AS KS" | "TC JS QC KS AC" || Result.WIN
		"AC AH AS AS KS" | "QH QS QC AS 8H" || Result.WIN
		"TC JS QC KS AC" | "QH QS QC AS 8H" || Result.WIN
		"7H 8H 9H TH JH" | "JH JC JS JD TH" || Result.WIN
		"7H 8H 9H TH JH" | "4H 5H 9H TH JH" || Result.WIN
		"7H 8H 9H TH JH" | "7C 8S 9H TH JH" || Result.WIN
		"7H 8H 9H TH JH" | "TS TH TD JH JD" || Result.WIN
		"7H 8H 9H TH JH" | "JH JD TH TC 4C" || Result.WIN
		"JH JC JS JD TH" | "4H 5H 9H TH JH" || Result.WIN
		"JH JC JS JD TH" | "7C 8S 9H TH JH" || Result.WIN
		"JH JC JS JD TH" | "TS TH TD JH JD" || Result.WIN
		"JH JC JS JD TH" | "JH JD TH TC 4C" || Result.WIN
		"4H 5H 9H TH JH" | "7C 8S 9H TH JH" || Result.WIN
		"4H 5H 9H TH JH" | "TS TH TD JH JD" || Result.LOSS
		"4H 5H 9H TH JH" | "JH JD TH TC 4C" || Result.WIN
		"7C 8S 9H TH JH" | "TS TH TD JH JD" || Result.LOSS
		"7C 8S 9H TH JH" | "JH JD TH TC 4C" || Result.WIN
		"TS TH TD JH JD" | "JH JD TH TC 4C" || Result.WIN
		"TS TH TD TC JD" | "JH JD JS JC 4C" || Result.LOSS
		"TS TH TD QC JD" | "JH JD JS QC 4C" || Result.LOSS
		"TS TH QD QC QS" | "KH KD JS JC JD" || Result.WIN
		"TS TH QD QC QS" | "KH KD QS QC QD" || Result.WIN
		"TS QS AS 2S 5S" | "8C KC 4C 2C JC" || Result.WIN
		"5C 2C AS 2S 5S" | "8C KC 2H 2C 8D" || Result.LOSS
		"AS KS QS JS TS" | "AC KC QC JC TC" || Result.WIN
		"9S KS QS JS TS" | "9C KC QC JC TC" || Result.WIN
		"2S 2C 4S 4D TS" | "3C 3D 4C 4H TC" || Result.LOSS
		"3S 3H 4S 4D TS" | "3C 3D 4C 4H TC" || Result.LOSS
	}
}
