package com.novoda.frankboylan.ncu.nodes;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeMapSanitisationTest {

    // ToDo: Export Json Strings to files, then read from file
    //private static final String JSON_BASE = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" }, { \"node-id\":\"5\" } ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"5\" } ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"6\" } ] } ] }, { \"layer-number\":\"1\", \"nodes\":[ { \"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"1\" } ], \"children\":[ { \"node-id\":\"7\" } ] }, { \"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"1\" }, { \"node-id\":\"2\" } ], \"children\":[ { \"node-id\":\"8\" } ] }, { \"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"3\" } ], \"children\":[ ] } ] }, { \"layer-number\":\"2\", \"nodes\":[ { \"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"4\" } ], \"children\":[ { \"node-id\":\"9\" }, { \"node-id\":\"10\" } ] }, { \"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"5\" } ], \"children\":[ { \"node-id\":\"10\" }, { \"node-id\":\"11\" } ] } ] }, { \"layer-number\":\"3\", \"nodes\":[ { \"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"7\" } ], \"children\":[ ] }, { \"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"7\" }, { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] } ] } ] }\n";
    private static final String JSON_ZERO_CHILDREN = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ ] } ] } ] }\n";
    private static final String JSON_ONE_CHILD = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" } ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"5\" } ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"6\" } ] } ] } ] }\n";
    private static final String JSON_THREE_CHILDREN = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" }, { \"node-id\":\"5\" }, { \"node-id\":\"6\" } ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"5\" } ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"6\" } ] } ] } ] }\n";
    private static final String JSON_LAYER_ZERO_NODES = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[] }, { \"layer-number\":\"1\", \"nodes\":[ { \"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"1\" } ], \"children\":[ { \"node-id\":\"7\" } ] }, { \"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"1\" }, { \"node-id\":\"2\" } ], \"children\":[ { \"node-id\":\"8\" } ] }, { \"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"3\" } ], \"children\":[ ] } ] }, { \"layer-number\":\"2\", \"nodes\":[ { \"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"4\" } ], \"children\":[ { \"node-id\":\"9\" }, { \"node-id\":\"10\" } ] }, { \"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"5\" } ], \"children\":[ { \"node-id\":\"10\" }, { \"node-id\":\"11\" } ] } ] }, { \"layer-number\":\"3\", \"nodes\":[ { \"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"7\" } ], \"children\":[ ] }, { \"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"7\" }, { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] } ] } ] }";
    private static final String JSON_LAYER_ONE_NODE = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" }, { \"node-id\":\"5\" } ] } ] }, { \"layer-number\":\"1\", \"nodes\":[ { \"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"1\" } ], \"children\":[ { \"node-id\":\"7\" } ] }, { \"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"1\" }, { \"node-id\":\"2\" } ], \"children\":[ { \"node-id\":\"8\" } ] }, { \"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"3\" } ], \"children\":[ ] } ] }, { \"layer-number\":\"2\", \"nodes\":[ { \"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"4\" } ], \"children\":[ { \"node-id\":\"9\" }, { \"node-id\":\"10\" } ] }, { \"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"5\" } ], \"children\":[ { \"node-id\":\"10\" }, { \"node-id\":\"11\" } ] } ] }, { \"layer-number\":\"3\", \"nodes\":[ { \"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"7\" } ], \"children\":[ ] }, { \"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"7\" }, { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] } ] } ] }";
    private static final String JSON_LAYER_THREE_NODES = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" }, { \"node-id\":\"5\" } ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"5\" } ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"6\" } ] } ] }, { \"layer-number\":\"1\", \"nodes\":[ { \"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"1\" } ], \"children\":[ { \"node-id\":\"7\" } ] }, { \"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"1\" }, { \"node-id\":\"2\" } ], \"children\":[ { \"node-id\":\"8\" } ] }, { \"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"3\" } ], \"children\":[ ] } ] }, { \"layer-number\":\"2\", \"nodes\":[ { \"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"4\" } ], \"children\":[ { \"node-id\":\"9\" }, { \"node-id\":\"10\" } ] }, { \"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"5\" } ], \"children\":[ { \"node-id\":\"10\" }, { \"node-id\":\"11\" } ] } ] }, { \"layer-number\":\"3\", \"nodes\":[ { \"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"7\" } ], \"children\":[ ] }, { \"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"7\" }, { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] } ] } ] }\n";
    private static final String JSON_LAYER_FOUR_NODES = "{ \"metadata\":{ \"title\":\"engineering\" }, \"layers\":[ { \"layer-number\":\"0\", \"nodes\":[ { \"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"4\" }, { \"node-id\":\"5\" } ] }, { \"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"5\" } ] }, { \"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"0\" } ], \"children\":[ { \"node-id\":\"6\" } ] } ] }, { \"layer-number\":\"1\", \"nodes\":[ { \"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[ { \"node-id\":\"1\" } ], \"children\":[ { \"node-id\":\"7\" } ] }, { \"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[ { \"node-id\":\"1\" }, { \"node-id\":\"2\" } ], \"children\":[ { \"node-id\":\"8\" } ] }, { \"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"3\" } ], \"children\":[ ] } ] }, { \"layer-number\":\"2\", \"nodes\":[ { \"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"4\" } ], \"children\":[ { \"node-id\":\"9\" }, { \"node-id\":\"10\" } ] }, { \"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"5\" } ], \"children\":[ { \"node-id\":\"10\" }, { \"node-id\":\"11\" } ] } ] }, { \"layer-number\":\"3\", \"nodes\":[ { \"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[ { \"node-id\":\"7\" } ], \"children\":[ ] }, { \"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[ { \"node-id\":\"7\" }, { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] }, { \"node-id\":\"12\", \"node-status\":\"LOCKED\", \"pos-x\":\"5\", \"parent\":[ { \"node-id\":\"8\" } ], \"children\":[ ] } ] } ] }";

    private NodeMapSanitisation nodeMapSanitisation;
    private NodeMap nodeMap;

    @Before
    public void setUp() {
        //nodeMapSanitisation = new NodeMapSanitisation();
    }

    @Test
    public void print() {
        Log.e("", JSON_ZERO_CHILDREN + "");
        Log.e("", JSON_ONE_CHILD + "");
        Log.e("", JSON_THREE_CHILDREN + "");
        Log.e("", JSON_LAYER_ONE_NODE + "");
        Log.e("", JSON_LAYER_ZERO_NODES+ "");
        Log.e("", JSON_LAYER_THREE_NODES + "");
        Log.e("", JSON_LAYER_FOUR_NODES+ "");
    }
}
/*
    @Test
    public void givenNodeHasZeroChildren_whenLogicApplied_thenReturnsTrue() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString(JSON_ZERO_CHILDREN);
        assertTrue(nodeMapSanitisation.isChildCountValid(nodeMap));
    }

    @Test
    public void givenNodeHasOneChild_whenLogicApplied_thenReturnsTrue() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString(JSON_ONE_CHILD);
        assertTrue(nodeMapSanitisation.isChildCountValid(nodeMap));
    }

    @Test
    public void givenNodeHasThreeChildren_whenLogicApplied_thenReturnsFalse() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString(JSON_THREE_CHILDREN);
        assertFalse(nodeMapSanitisation.isChildCountValid(nodeMap));
    }

    @Test
    public void givenLayerHasZeroNodes_whenLogicApplied_thenReturnsFalse() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString(JSON_LAYER_ZERO_NODES);
        assertFalse(nodeMapSanitisation.isLayerNodeCountValid(nodeMap));
    }

    @Test
    public void givenLayerHasOneNode_whenLogicApplied_thenReturnsTrue() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString(JSON_LAYER_ONE_NODE);
        assertTrue(nodeMapSanitisation.isLayerNodeCountValid(nodeMap));
    }

    @Test
    public void givenLayerHasThreeNodes_whenLogicApplied_thenReturnsTrue() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString(JSON_LAYER_THREE_NODES);
        assertTrue(nodeMapSanitisation.isLayerNodeCountValid(nodeMap));
    }

    @Test
    public void givenLayerHasFourNodes_whenLogicApplied_thenReturnsFalse() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString(JSON_LAYER_FOUR_NODES);
        assertFalse(nodeMapSanitisation.isLayerNodeCountValid(nodeMap));
    }

    @Test
    public void givenNodeHasZeroParents_whenLogicApplied_thenReturnsFalse() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString();
        assertFalse(nodeMapSanitisation.isParentCountValid(nodeMap));
    }

    @Test
    public void givenNodeHasOneParent_whenLogicApplied_thenReturnsTrue() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString();
        assertFalse(nodeMapSanitisation.isParentCountValid(nodeMap));
    }

    @Test
    public void givenNodeHasTwoParents_whenLogicApplied_thenReturnsTrue() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString();
        assertFalse(nodeMapSanitisation.isParentCountValid(nodeMap));
    }

    @Test
    public void givenNodeHasThreeParents_whenLogicApplied_thenReturnsFalse() {
        nodeMap = nodeMapSanitisation.getNodeMapFromJsonString();
        assertFalse(nodeMapSanitisation.isParentCountValid(nodeMap));
    }

    // TODO: Test the children of each node have layer-no's that are > (by 1-2) than the current layer-no

    // TODO: Test the parent of each node have layer-no's that are < (by 1-2) than the current layer-no

    // TODO: Test the root (id: 0) has 1-3 children

    // TODO: Test that the Parent of a Node's X-column is +/- 2

    // TODO: Node Status testing:
    /* Unlocked:    An unlocked Node must have atleast 1 Parent with a Node Status of Complete

       Locked:

       In Progress:

       Completed:   


     */

