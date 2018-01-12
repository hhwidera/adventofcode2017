package com.widera.adventofcode2017.day23;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OptimizeProgramVersion2 {

	private static ExecutorService executor = Executors.newFixedThreadPool(8);

	public static void run() throws InterruptedException, ExecutionException {
		
		List<Future<Boolean>> incementCallableSet = new ArrayList<>(1100); 
		long a = 0, b = 0, c = 0, g = 0, h = 0;
		a = 1L;
		
		b = 79L; //set b 79
		c = b; // set c b
		if (a != 0) { // jnz a 2
	        b *= 100L; //mul b 100
	        b += 100_000L; // sub b -100000
	        c = b; // set c b
	        c += 17_000L; // sub c -17000
	    }
		do {
			incementCallableSet.add(executor.submit(new IncementRegisterHCallable(b)));
			g = b; // set g b
			g -= c; // sub g c
			if (g != 0L) { // jnz g 2
				b += 17L; // sub b -17
			}
		} while (g != 0L); //jnz 1 -23
		
		for (Future<Boolean> sub : incementCallableSet) {
			if (sub.get()) {
				h++; // sub h -1
			}
		}
		System.out.println("final: " + h);
		executor.shutdown();
	}
	
	public static void main(String[] args) throws Exception {
		new IncementRegisterHCallable(122299).call();
	}
	
	public static class IncementRegisterHCallable implements Callable<Boolean> {
		
		private final long b;
		
		public IncementRegisterHCallable(final long b) {
			this.b = b;
		}

		@Override
		public Boolean call() throws Exception {
			long d = 0, e = 0, f = 0, g = 0;
			f = 1L; // set f 1
			d = 2L; // set d 2
			do {
				e = 2L; // set e 2
				do {
					g = d; // set g d
					g *= e; // mul g e
					g -= b; // sub g b
					if (g == 0L) { // jnz g 2
						f = 0L; // set f 0
						break;
					}
					e++; // sub e -1
					g = e; // set g e
					g -= b; // sub g b
				} while (g != 0L); // jnz g -8
				if (f == 0L) {
					break;
				}
				d++; // sub d -1
				g = d; // set g d
				g -= b; // sub g b
			} while (g != 0L); // jnz g -13
			
			System.out.println(b + ": " + (f == 0L));
			return f == 0L;
		}
	}

}
