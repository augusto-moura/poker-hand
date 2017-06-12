package zg.augusto.utils

class Dupla <A, B> {

	private final A valorUm
	private final B valorDois

	Dupla(A valorUm, B valorDois) {
		this.valorUm = valorUm
		this.valorDois = valorDois
	}

	A get1() {
		return valorUm
	}

	B get2() {
		return valorDois
	}
}
