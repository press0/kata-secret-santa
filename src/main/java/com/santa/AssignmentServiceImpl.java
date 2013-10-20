package com.santa;

import java.util.*;


import static java.text.MessageFormat.format;

/**
 * Created with IntelliJ IDEA.
 * User: q
 * Date: 10/19/13
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class AssignmentServiceImpl implements AssignmentService {

    @Override
    public String[] generateAssignments(String[] participants) {
        List<String> participantList = new ArrayList<>(Arrays.asList(participants));
        List<String> assignmentList = new ArrayList<>();
        List<String> availableList = new ArrayList<>(participantList);
        String lastParticipant = participantList.get(participantList.size()-1);
        Random generator = new Random();

        if ( hasDuplicates(participantList) ) {
            return null;
        }

        for (String giver : participantList) {
            List<String> allowableList = new ArrayList<>(availableList);
            allowableList.remove(giver);

            if (allowableList.size() == 2 && allowableList.contains(lastParticipant)) {
                assignmentList.add(lastParticipant);
                availableList.remove(lastParticipant);
            } else {
                int index = generator.nextInt(allowableList.size());
                String receiver = allowableList.get(index);
                assignmentList.add(receiver);
                availableList.remove(receiver);
            }

        }

        return assignmentList.toArray(new String[0]);
    }

    private boolean hasDuplicates(List<String> list) {
        HashSet hashSet = new HashSet(list);

        if ( list.size() == hashSet.size() ) {
            return false;
        } else {
            return true;
        }

    }
}
