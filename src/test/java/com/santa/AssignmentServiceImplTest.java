package com.santa;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: q
 * Date: 10/19/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class AssignmentServiceImplTest {
    AssignmentService service;
    String[] participants = new String[]{"one", "two", "three", "four", "five"};

    @Before
    public void setUp() {
        service = new AssignmentServiceImpl();
    }

    @Test
    public void testEveryParticipantIsAssigned() throws Exception {
        String[] assignments = service.generateAssignments(participants);
        List<String> assignmentList = new ArrayList<>(Arrays.asList(assignments));
        for (int i=0; i<participants.length; i++) {
            assertTrue(assignmentList.contains(participants[i]));
        }
    }

    @Test
    public void testNoSelfAssignment() throws Exception {
        for (int ii=1; ii<=30; ii++ ) {
            String[] assignments = service.generateAssignments(participants);
            for (int i=0; i<participants.length; i++) {
                assertNotSame(assignments[i], participants[i]);
            }
            System.out.println(Arrays.toString(assignments));
        }
    }

    @Test
    public void testSameSize() throws Exception {
        String[] assignments = service.generateAssignments(participants);
        assertEquals(participants.length, assignments.length);
    }

    @Test
    public void testDuplicates() {
        String[] participants = new String[]{"one", "one"};
        String[] assignments = service.generateAssignments(participants);
        assertNull(assignments);
    }
}
