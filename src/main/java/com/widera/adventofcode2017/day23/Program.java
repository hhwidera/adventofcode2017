package com.widera.adventofcode2017.day23;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Program {

	private final String[] instructions;
	
	private final Map<String, Long> register;
	
	private int sizeOfMulInstructionAreInvoked;
	
	public Program(final String[] instructions) {
		this.instructions = instructions;
		this.register = new HashMap<>();
		this.sizeOfMulInstructionAreInvoked = 0;
	}
	
	public void run() {
		for (int step = 0; step < instructions.length; step++) {
			String instruction = instructions[step];
			System.out.println((step+1) + " " + instruction + "\t" + registerToString());
			if (instruction.startsWith("set")) {
				set(instruction);
			} else if (instruction.startsWith("sub")) {
				sub(instruction);
			} else if (instruction.startsWith("mul")) {
				mul(instruction);
			} else if (instruction.startsWith("jnz")) {
				int offset = jnz(instruction);
				if (offset != 0) {
					step += offset - 1;
				}
			} 
		}
	}

	private String registerToString() {
		String result = "";
		for (Entry<String, Long> r : register.entrySet()) {
			result += r.getKey() + ": " + r.getValue() + " | ";
		}
		return result;
	}

	private void sub(final String instruction) {
		String registerName = split(instruction)[1];
		long value = value(split(instruction)[2]);
		register.put(registerName, register.getOrDefault(registerName, 0L) - value);
	}

	private void set(final String instruction) {
		String registerName = split(instruction)[1];
		long value = value(split(instruction)[2]);
		register.put(registerName, value);
	}
	
	private void mul(final String instruction) {
		String registerName = split(instruction)[1];
		long value = value(split(instruction)[2]);
		register.put(registerName, register.getOrDefault(registerName, 0L) * value);
		sizeOfMulInstructionAreInvoked++;
	}
	
	private int jnz(final String instruction) {
		if (value(split(instruction)[1]) != 0L) {
			int jumpOffset = value(split(instruction)[2]).intValue();
			return jumpOffset;
		}
		return 0;
	}

	private Long value(final String part) {
		if (part.matches("-?\\d+")) {
			return Long.valueOf(part);
		} else {
			if (!register.containsKey(part)) {
				register.put(part, 0L);
			}
			return register.get(part);
		}
	}

	private String[] split(final String instruction) {
		return instruction.split(" ");
	}
	
	public int sizeOfMulInstructionAreInvoked() {
		return sizeOfMulInstructionAreInvoked;
	}
	
	public void setRegister(final String key, final long value) {
		register.put(key, value);
	}
	
	public Long getRegister(final String key) {
		return register.getOrDefault(key, 0L);
	}
	
}
