package peleadores;

import ataques.*;

public class Freezer extends Peleador{
	public Freezer() {
		super("Freezer", 7000, 40000, new Ataque[] { new GolpeFreezer() });
	}
}
