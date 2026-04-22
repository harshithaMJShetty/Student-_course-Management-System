package models;

public class Enrollments {

	private int eid;
    //private int sid;
    //private int courseid;
    private String grade;
	private int student_id;
	private int course_id;

    public Enrollments(int student_id, int course_id, String grade) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade = grade;
    }

    public Enrollments() {}

    public int geteid() {
        return eid;
    }

    public void seteid(int eid) {
        this.eid = eid;
    }

    public int getstudent_id() {
        return student_id;
    }

    public void setstudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourseid() {
        return course_id;
    }

    public void setCourseid(int course_id) {
        this.course_id = course_id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}


