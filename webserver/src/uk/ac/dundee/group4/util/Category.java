package uk.ac.dundee.group4.util;

/**
 * This is a utility class for basic categories.
 */
public class Category {
    public static final int PAPER_EXAM = 0;
    public static final int ONLINE_EXAM = 1;
    public static final int MAIN_EXAM = 0;
    public static final int RECITE_EXAM = 1;
    public static final int UNDERGRADUATE_EXAM = 0;
    public static final int POSTGRADUATE_EXAM = 1;

    public static final String EXAM_SETTER = "ExamSetter";
    public static final String INTERNAL_MODERATOR = "InternalModerator";
    public static final String EXAM_VETTING_COMMITTEE = "ExamVettingCommittee";
    public static final String EXTERNAL_EXAMINER = "ExternalExaminer";
    public static final String LOCAL_EXAMS_OFFICER = "LocalExamsOfficer";
    public static final String SCHOOL_OFFICE = "SchoolOffice";

    public static final int LINK_INTERNAL_MODERATOR = 1;
    public static final int LINK_EXAM_VETTING_COMMITTEE = 2;
    public static final int LINK_EXTERNAL_EXAMINER = 3;

    public static final int TO_SIGN_BY_INTERNAL_MODERATOR = 0;
    public static final int TO_SIGN_BY_EXAM_VETTING_COMMITTEE = 1;
    public static final int TO_SIGN_BY_EXTERNAL_EXAMINER = 2;
    public static final int DONE = 3;

    public static final int NOTSIGN = 0;
    public static final int SIGNED = 1;
}
