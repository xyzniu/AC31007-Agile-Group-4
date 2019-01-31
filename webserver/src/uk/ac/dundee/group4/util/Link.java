package uk.ac.dundee.group4.util;

import uk.ac.dundee.group4.pojo.User;

public class Link {

    public static int getLink(User u) {
        int link_control = -1;
        switch (u.getStaffType()) {
            case Category.INTERNAL_MODERATOR:
                link_control = Category.LINK_INTERNAL_MODERATOR;
                break;
            case Category.EXAM_VETTING_COMMITTEE:
                link_control = Category.LINK_EXAM_VETTING_COMMITTEE;
                break;
            case Category.EXTERNAL_EXAMINER:
                link_control = Category.LINK_EXTERNAL_EXAMINER;
                break;
        }
        return link_control;
    }
}
