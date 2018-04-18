package com.novoda.frankboylan.ncu.nodes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NodeLogicTest {

    private static final String JSON_ZERO_CHILDREN = "{ \"engineering\": { \"metadata\": { }, \"layer\": [{ \"layer-number\":\"0\", \"nodes\": [ {\"node-id\":\"1\", \"node-status\":\"incomplete\", \"pos-x\":\"0\", \"parent\":[{\"node-id\":\"0\"}], \"children\":[]} ]\t} ] } }\n";
    private static final String JSON_ONE_CHILD = "    private static final String JSON_ONE_CHILD = \"{ \\\"engineering\\\": { \\\"metadata\\\": { }, \\\"layer\\\": [{ \\\"layer-number\\\":\\\"0\\\", \\\"nodes\\\": [ {\\\"node-id\\\":\\\"1\\\", \\\"node-status\\\":\\\"incomplete\\\", \\\"pos-x\\\":\\\"0\\\", \\\"parent\\\":[{\\\"node-id\\\":\\\"0\\\"}], \\\"children\\\":[{\\\"node-id\\\":\\\"4\\\"}} ]\\t} ] } }\\n\";\n";
    private static final String JSON_THREE_CHILDREN = "{ \"engineering\": { \"metadata\": { }, \"layer\": [{ \"layer-number\":\"0\", \"nodes\": [ {\"node-id\":\"1\", \"node-status\":\"incomplete\", \"pos-x\":\"0\", \"parent\":[{\"node-id\":\"0\"}], \"children\":[{\"node-id\":\"4\"}, {\"node-id\":\"5\"}, {\"node-id\":\"6\"}]} ]\t} ] } }\n";
    private NodeLogic nodeLogic;

    @Before
    public void setUp() {
        nodeLogic = new NodeLogic();
    }

    @Test
    public void givenNodeHasZeroChildren_whenLogicApplied_thenReturnsTrue() {
        nodeLogic.parseStringToJson(JSON_ZERO_CHILDREN);

        assertTrue(nodeLogic.areChildrenValid());
    }

    @Test
    public void givenNodeHasOneChild_whenLogicApplied_thenReturnsTrue() {
        nodeLogic.parseStringToJson(JSON_ONE_CHILD);

        assertTrue(nodeLogic.areChildrenValid());
    }

    @Test
    public void givenNodeHasThreeChildren_whenLogicApplied_thenReturnsFalse() {
        nodeLogic.parseStringToJson(JSON_THREE_CHILDREN);

        assertTrue(nodeLogic.areChildrenValid());
    }
}
