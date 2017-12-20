package com.widera.adventofcode2017.day18;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class ProgramParallel {

	enum State {
		RUNNING,
		WAITING,
		TERMINATE
	}

	private final String[] instructions;

	private final Map<String, Long> register;

	private final Queue<Long> receiveQueue;

	private Queue<Long> sendingQueue;

	private int sendMessages = 0;

	private int step = 0;

	private State state = State.RUNNING;

	public ProgramParallel(final String[] instructions, final long id) {
		this.instructions = instructions;
		this.register = new HashMap<>();
		this.receiveQueue = new LinkedBlockingQueue<>();
		setRegisterPToProgramId(id);
	}

    private void setRegisterPToProgramId(final long id) {
		this.register.put("p", id);
    }

    public boolean isWaiting() {
	    return State.WAITING.equals(state);
    }

    public boolean isTerminated() {
        return State.TERMINATE.equals(state);
    }

	public Queue<Long> getReceiveQueue() {
		return receiveQueue;
	}

	public void setSendingQueue(Queue<Long> sendingQueue) {
		this.sendingQueue = sendingQueue;
	}
	
	public void runNextInstruction() {
		if (step < 0 || step >= instructions.length) {
			state = State.TERMINATE;
		} else {
			String instruction = instructions[step];
			int stepIncrease  = 1;
            System.out.println(instruction);
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
				if (canReceive()) {
                    rcv(instruction);
                    state = State.RUNNING;
                } else {
                    state = State.WAITING;
                    stepIncrease = 0;
                }
			} else if (instruction.startsWith("jgz")) {
				int offset = jgz(instruction);
				if (offset != 0) {
                    stepIncrease = offset;
				}
			}
			step += stepIncrease;
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

	private boolean canReceive() {
	    return !receiveQueue.isEmpty();
    }
	private void rcv(final String instruction) {
	    String registerName = split(instruction)[1];
		register.put(registerName, receiveQueue.poll());
	}
	
	private int jgz(final String instruction) {
		if (value(split(instruction)[1]) > 0L) {
			int jumpOffset = value(split(instruction)[2]).intValue();
			return jumpOffset;
		}
		return 0;
	}

	private void snd(final String instruction) {
		long frequency = value(split(instruction)[1]);
		sendingQueue.add(frequency);
        sendMessages++;
	}
	
	private Long value(final String part) {
		if (part.matches("-?\\d+")) {
			return Long.valueOf(part);
		} else {
			return register.getOrDefault(part, 0L);
		}
	}

	private String[] split(final String instruction) {
		return instruction.split(" ");
	}
	
	public long sendMessages() {
		return sendMessages;
	}
	
}
