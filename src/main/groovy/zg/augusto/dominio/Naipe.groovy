package zg.augusto.dominio

enum Naipe {

	ESPADAS('S'),
	COPAS('H'),
	OUROS('D'),
	PAUS('C'),

	final String codigo

	Naipe(String codigo) {
		this.codigo = codigo
	}

	static Naipe encontrarPorCodigo(String codigo) {
		return values().find { Naipe it -> it.codigo == codigo }
	}

}