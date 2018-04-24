package com.novoda.frankboylan.ncu.nodes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeLogicTest {

    //private static final String JSON_BASE = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" }, { \"node-id\":\"5\" } ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"5\" } ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"6\" } ] } ] }, { \"layer-number\":\"1\", \"nodes\":[ { \"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"1\" } ], \"children\":[ { \"node-id\":\"7\" } ] }, { \"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"1\" }, { \"node-id\":\"2\" } ], \"children\":[ { \"node-id\":\"8\" } ] }, { \"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"3\" } ], \"children\":[ ] } ] }, { \"layer-number\":\"2\", \"nodes\":[ { \"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"4\" } ], \"children\":[ { \"node-id\":\"9\" }, { \"node-id\":\"10\" } ] }, { \"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"5\" } ], \"children\":[ { \"node-id\":\"10\" }, { \"node-id\":\"11\" } ] } ] }, { \"layer-number\":\"3\", \"nodes\":[ { \"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"7\" } ], \"children\":[ ] }, { \"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"7\" }, { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] } ] } ] }\n";
    private static final String JSON_ZERO_CHILDREN = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ ] } ] } ] }\n";
    private static final String JSON_ONE_CHILD = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" } ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"5\" } ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"6\" } ] } ] } ] }\n";
    private static final String JSON_THREE_CHILDREN = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" }, { \"node-id\":\"5\" }, { \"node-id\":\"6\" } ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"5\" } ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"6\" } ] } ] } ] }\n";
    private static final String JSON_LAYER_ZERO_NODES = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[] }, { \"layer-number\":\"1\", \"nodes\":[ { \"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"1\" } ], \"children\":[ { \"node-id\":\"7\" } ] }, { \"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"1\" }, { \"node-id\":\"2\" } ], \"children\":[ { \"node-id\":\"8\" } ] }, { \"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"3\" } ], \"children\":[ ] } ] }, { \"layer-number\":\"2\", \"nodes\":[ { \"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"4\" } ], \"children\":[ { \"node-id\":\"9\" }, { \"node-id\":\"10\" } ] }, { \"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"5\" } ], \"children\":[ { \"node-id\":\"10\" }, { \"node-id\":\"11\" } ] } ] }, { \"layer-number\":\"3\", \"nodes\":[ { \"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"7\" } ], \"children\":[ ] }, { \"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"7\" }, { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] } ] } ] }";
    private static final String JSON_LAYER_ONE_NODE = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" }, { \"node-id\":\"5\" } ] } ] }, { \"layer-number\":\"1\", \"nodes\":[ { \"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"1\" } ], \"children\":[ { \"node-id\":\"7\" } ] }, { \"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"1\" }, { \"node-id\":\"2\" } ], \"children\":[ { \"node-id\":\"8\" } ] }, { \"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"3\" } ], \"children\":[ ] } ] }, { \"layer-number\":\"2\", \"nodes\":[ { \"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"4\" } ], \"children\":[ { \"node-id\":\"9\" }, { \"node-id\":\"10\" } ] }, { \"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"5\" } ], \"children\":[ { \"node-id\":\"10\" }, { \"node-id\":\"11\" } ] } ] }, { \"layer-number\":\"3\", \"nodes\":[ { \"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"7\" } ], \"children\":[ ] }, { \"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"7\" }, { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] } ] } ] }";
    private static final String JSON_LAYER_THREE_NODES = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" }, { \"node-id\":\"5\" } ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"5\" } ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"6\" } ] } ] }, { \"layer-number\":\"1\", \"nodes\":[ { \"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"1\" } ], \"children\":[ { \"node-id\":\"7\" } ] }, { \"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"1\" }, { \"node-id\":\"2\" } ], \"children\":[ { \"node-id\":\"8\" } ] }, { \"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"3\" } ], \"children\":[ ] } ] }, { \"layer-number\":\"2\", \"nodes\":[ { \"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"4\" } ], \"children\":[ { \"node-id\":\"9\" }, { \"node-id\":\"10\" } ] }, { \"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"5\" } ], \"children\":[ { \"node-id\":\"10\" }, { \"node-id\":\"11\" } ] } ] }, { \"layer-number\":\"3\", \"nodes\":[ { \"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"7\" } ], \"children\":[ ] }, { \"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"7\" }, { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] } ] } ] }\n";
    private static final String JSON_LAYER_FOUR_NODES = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" }, { \"node-id\":\"5\" } ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"5\" } ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"6\" } ] } ] }, { \"layer-number\":\"1\", \"nodes\":[ { \"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"1\" } ], \"children\":[ { \"node-id\":\"7\" } ] }, { \"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"1\" }, { \"node-id\":\"2\" } ], \"children\":[ { \"node-id\":\"8\" } ] }, { \"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"3\" } ], \"children\":[ ] } ] }, { \"layer-number\":\"2\", \"nodes\":[ { \"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"4\" } ], \"children\":[ { \"node-id\":\"9\" }, { \"node-id\":\"10\" } ] }, { \"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"5\" } ], \"children\":[ { \"node-id\":\"10\" }, { \"node-id\":\"11\" } ] } ] }, { \"layer-number\":\"3\", \"nodes\":[ { \"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"7\" } ], \"children\":[ ] }, { \"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"7\" }, { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"12\", \"node-status\":\"LOCKED\", \"pos-x\":\"5\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] } ] } ] }";

    private NodeLogic nodeLogic;
    private NodeMap nodeMap;

    @Before
    public void setUp() {
        nodeLogic = new NodeLogic();
    }

    @Test
    public void givenNodeHasZeroChildren_whenLogicApplied_thenReturnsTrue() {
        nodeMap = nodeLogic.getNodeMapFromJsonString(JSON_ZERO_CHILDREN);
        assertTrue(nodeLogic.isChildCountValid(nodeMap));
    }

    @Test
    public void givenNodeHasOneChild_whenLogicApplied_thenReturnsTrue() {
        nodeMap = nodeLogic.getNodeMapFromJsonString(JSON_ONE_CHILD);
        assertTrue(nodeLogic.isChildCountValid(nodeMap));
    }

    @Test
    public void givenNodeHasThreeChildren_whenLogicApplied_thenReturnsFalse() {
        nodeMap = nodeLogic.getNodeMapFromJsonString(JSON_THREE_CHILDREN);
        assertFalse(nodeLogic.isChildCountValid(nodeMap));
    }

    @Test
    public void givenLayerHasZeroNodes_whenLogicApplied_thenReturnsFalse() {
        nodeMap = nodeLogic.getNodeMapFromJsonString(JSON_LAYER_ZERO_NODES);
        assertFalse(nodeLogic.isLayerNodeCountValid(nodeMap));
    }

    @Test
    public void givenLayerHasOneNode_whenLogicApplied_thenReturnsTrue() {
        nodeMap = nodeLogic.getNodeMapFromJsonString(JSON_LAYER_ONE_NODE);
        assertTrue(nodeLogic.isLayerNodeCountValid(nodeMap));
    }

    @Test
    public void givenLayerHasThreeNodes_whenLogicApplied_thenReturnsTrue() {
        nodeMap = nodeLogic.getNodeMapFromJsonString(JSON_LAYER_THREE_NODES);
        assertTrue(nodeLogic.isLayerNodeCountValid(nodeMap));
    }

    @Test
    public void givenLayerHasFourNodes_whenLogicApplied_thenReturnsFalse() {
        nodeMap = nodeLogic.getNodeMapFromJsonString(JSON_LAYER_FOUR_NODES);
        assertFalse(nodeLogic.isLayerNodeCountValid(nodeMap));
    }
}
