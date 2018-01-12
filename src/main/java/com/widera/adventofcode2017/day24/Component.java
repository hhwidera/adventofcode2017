package com.widera.adventofcode2017.day24;

public class Component {

    private final int ports[] = new int[2];

    public Component(final String componentAsString) {
        String[] portsAsString = componentAsString.split("/");
        this.ports[0] = Integer.valueOf(portsAsString[0]);
        this.ports[1] = Integer.valueOf(portsAsString[1]);
    }

    public Component(final int portA, final int portB) {
        this.ports[0] = portA;
        this.ports[1] = portB;
    }

    public int getPortA() {
        return ports[0];
    }

    public int getPortB() {
        return ports[1];
    }

    protected Component clone() {
        return new Component(getPortA(), getPortB());
    }

    public boolean hasNullPort() {
        return hasPortType(0);
    }

    public boolean hasPortType(final int linkPort) {
        return getPortA() == linkPort || getPortB() == linkPort;
    }

    public int otherPort(final int filterPort) {
        if (getPortA() == filterPort) {
            return getPortB();
        } else {
            return getPortA();
        }
    }

}
