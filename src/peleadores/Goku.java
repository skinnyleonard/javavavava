package peleadores;

import ataques.*;;

public class Goku extends Peleador{

	public Goku() {
		super("Goku", 5000, 50000, new Ataque[] { new GolpeGoku() });
	}
}
