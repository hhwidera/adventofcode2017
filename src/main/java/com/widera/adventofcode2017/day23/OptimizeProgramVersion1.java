package com.widera.adventofcode2017.day23;

public class OptimizeProgramVersion1 {

	public static void run() {
		long a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0;
		a = 1;
		
		b = 79; //set b 79
		c = b; // set c b
		if (a != 0) { // jnz a 2
	        b *= 100; //mul b 100
	        b += 100_000; // sub b -100000
	        c = b; // set c b
	        c += 17_000; // sub c -17000
	    }
		do {
			System.out.print(b + ": ");
			f = 1; // set f 1
			d = 2; // set d 2
			do {
				e = 2; // set e 2
				do {
					g = d; // set g d
					g *= e; // mul g e
					g -= b; // sub g b
					if (g == 0) { // jnz g 2
						f = 0; // set f 0
						break;
					}
					e++; // sub e -1
					g = e; // set g e
					g -= b; // sub g b
				} while (g != 0); // jnz g -8
				if (f == 0) {
					break;
				}
				d++; // sub d -1
				g = d; // set g d
				g -= b; // sub g b
			} while (g != 0); // jnz g -13
			if (f == 0) { // jnz f 2
				h++; // sub h -1
				System.out.println(h);
			} else {
				System.out.println();
			}
			g = b; // set g b
			g -= c; // sub g c
			if (g != 0) { // jnz g 2
				b += 17; // sub b -17
			}
		} while (g != 0); //jnz 1 -23
		System.out.println("final: " + h);
	}

}
