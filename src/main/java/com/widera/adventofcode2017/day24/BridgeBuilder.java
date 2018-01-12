package com.widera.adventofcode2017.day24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeBuilder {

    private final Component linkComponent;
    private final int portInUse;
    private final List<Component> bucket;

    private List<BridgeBuilder> subBridgeBuilders = new ArrayList<>();

    public BridgeBuilder(final Component linkComponent, final int portInUse, final List<Component> bucket) {
        this.linkComponent = linkComponent;
        this.portInUse = portInUse;
        this.bucket = bucket;
    }

    public void buildBridges() {
        List<Component> components = bucket.stream()
                    .filter(component -> component.hasPortType(linkComponent.otherPort(portInUse)))
                    .collect(Collectors.toList());
        for (Component component : components) {
            List<Component> subBucket = bucket.stream().filter(c -> !c.equals(component)).map(Component::clone).collect(Collectors.toList());
            BridgeBuilder subBridgeBuilder = new BridgeBuilder(component, linkComponent.otherPort(portInUse), subBucket);
            subBridgeBuilders.add(subBridgeBuilder);
            subBridgeBuilder.buildBridges();
        }
    }

    public int strengthOfStrongestBridge() {
        int result = linkComponent.getPortA() + linkComponent.getPortB();
        result += subBridgeBuilders.stream().map(b -> b.strengthOfStrongestBridge()).max(Comparator.naturalOrder()).orElse(0);
        return result;
    }

}
