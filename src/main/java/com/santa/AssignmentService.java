package com.santa;

/**
 * Created with IntelliJ IDEA.
 * User: q
 * Date: 10/19/13
 * Time: 2:48 PM
 * To change this template use File | Settings | FilAssignmente Templates.
 */
public interface AssignmentService {

    /**
     * @param participants list of individuals participating in the draw.
     * @return the list of individuals paired with the participants where
     * participants[0] is matched with assignments[0],
     * participants[1] is matched with assignments[1], and so on.
     */
    String[] generateAssignments(final String[] participants);
}
