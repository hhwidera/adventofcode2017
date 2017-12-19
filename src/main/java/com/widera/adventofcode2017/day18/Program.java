package com.widera.adventofcode2017.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

	private final String[] instructions;
	
	private final Map<String, Long> register;
	
	private final List<Long> playedSoundFrequencys;
	
	public Program(final String[] instructions) {
		this.instructions = instructions;
		this.register = new HashMap<>();
		this.playedSoundFrequencys = new ArrayList<>();
	}
	
	public void run() {
		for (int step = 0; step < instructions.length; step++) {
			String instruction = instructions[step];
			if (instruction.startsWith("snd")) {
				snd(instruction);
			} else if (instruction.startsWith("set")) {
				set(instruction);
			} else if (instruction.startsWith("add")) {
				add(instruction);
			} else if (instruction.startsWith("mul")) {
				mul(instruction);
			} else if (instruction.startsWith("mod")) {
				mod(instruction);
			} else if (instruction.startsWith("rcv")) {
				if (rcv(instruction)) {
					return;
				}
			} else if (instruction.startsWith("jgz")) {
				int offset = jgz(instruction);
				if (offset != 0) {
					step += offset - 1;
				}
			} 
		}
	}

	private void set(final String instruction) {
		String registerName = split(instruction)[1];
		long value = value(split(instruction)[2]);
		register.put(registerName, value);
	}
	
	private void add(final String instruction) {
		String registerName = split(instruction)[1];
		long value = value(split(instruction)[2]);
		register.put(registerName, register.getOrDefault(registerName, 0L) + value);
	}
	
	private void mul(final String instruction) {
		String registerName = split(instruction)[1];
		long value = value(split(instruction)[2]);
		register.put(registerName, register.getOrDefault(registerName, 0L) * value);
	}
	
	private void mod(final String instruction) {
		String registerName = split(instruction)[1];
		long value = value(split(instruction)[2]);
		register.put(registerName, register.getOrDefault(registerName, 0L) % value);
	}
	
	private boolean rcv(final String instruction) {
		if (value(split(instruction)[1]) != 0) {
			return true;
		}
		return false;
	}
	
	private int jgz(final String instruction) {
		if (value(split(instruction)[1]) > 0) {
			int jumpOffset = value(split(instruction)[2]).intValue();
			return jumpOffset;
		}
		return 0;
	}

	private void snd(final String instruction) {
		long frequency = value(split(instruction)[1]);
		playedSoundFrequencys.add(frequency);
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
	
	public long lastRecoveredPlayedFrequency() {
		return playedSoundFrequencys.get(playedSoundFrequencys.size()-1);
	}
	
}
