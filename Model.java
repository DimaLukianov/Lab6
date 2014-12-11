package Lab6;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Model {

	private final static String USER = "root";
	private final static String PASS = "root";
	private final static String URL = "jdbc:mysql://localhost/stud";
	private final String TABLE1 = "students";
	private final String TABLE2 = "groups";
	private final String TABLE3 = "specialty";
	private final String TABLE4 = "faculty";
	private final String[] COLUMNS_STUDENTS = { "surname", "name", "fname", "stud_id",
			"group_id" };
	private final String[] COLUMNS_GROUPS = {"group_id","group_name","cpec_id"};
	private final String[] COLUMNS_SPEC = {"spec_id","spec_code","cpec_name","faculty_id"};
	private final String[] COLUMNS_FACULTY = {"faculty_id","facult_name"};
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet result;
	private Connection conn;
	private ArrayList<Students> students;
	private ArrayList<Groups> groups;
	private ArrayList<Specialty> specialty;
	private ArrayList<Faculty> faculty;

	public Model() {
		conn = null;
		this.students = new ArrayList<Students>();
		this.groups = new ArrayList<Groups>();
		this.specialty = new ArrayList<Specialty>();
		this.faculty = new ArrayList<Faculty>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
			System.exit(0);
		}
	}

	public ArrayList<Students> getAllStudents() {
		result = null;
		try {
			result = this.stmt.executeQuery("SELECT	* FROM " + this.TABLE1
					+ " ORDER BY student_id ASC");
			while (result.next()) {
				Students record = new Students(result.getString("surname"),
						result.getString("_name"), result.getString("fname"),
						result.getInt("student_id"), result.getInt("group_id"));
				this.students.add(record);
			}
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
		}
		return this.students;
	} 
	public ArrayList<Groups> getAllGroups() {
		result = null;
		try {
			result = this.stmt.executeQuery("SELECT	* FROM " + this.TABLE2
					+ " ORDER BY group_id ASC");
			while (result.next()) {
				Groups record = new Groups(result.getInt("group_id"),
						result.getString("group_name"), result.getInt("spec_id"));
				this.groups.add(record);
			}
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
		}
		return this.groups;
	}
	
	public ArrayList<Specialty> getAllSpecialty() {
		result = null;
		try {
			result = this.stmt.executeQuery("SELECT	* FROM " + this.TABLE3
					+ " ORDER BY spec_id ASC");
			while (result.next()) {
				Specialty record = new Specialty(result.getInt("spec_id"),
						result.getString("spec_code"), result.getString("spec_name"), 
						result.getInt("faculty_id"));
				this.specialty.add(record);
			}
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
		}
		return this.specialty;
	}
	
	public ArrayList<Faculty> getAllFaculty() {
		result = null;
		try {
			result = this.stmt.executeQuery("SELECT	* FROM " + this.TABLE4
					+ " ORDER BY faculty_id ASC");
			while (result.next()) {
				Faculty record = new Faculty(result.getInt("faculty_id"),
						result.getString("faculty_name"));
				this.faculty.add(record);
			}
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
		}
		return this.faculty;
	}
	public int insertStudent(Students stud){
		
		try {
			ps = conn.prepareStatement("insert into `students` (`surname`, `_name`, `fname`, `group_id`) "
					+"values (?, ?, ?, ?);");
			ps.setString(1, stud.getSurName());
			ps.setString(2, stud.getName());
			ps.setString(3, stud.getFname());
			ps.setInt(4, stud.getGroupId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}//insertGroup...
	
	public int updateStudent(Students stud){
		
		try {
			ps = conn.prepareStatement("UPDATE `stud`.`students`"
					+" SET `surname`=?, `_name`=?, `fname`=?, `group_id`=? "
					+"WHERE `student_id`=?;");
			ps.setString(1, stud.getSurName());
			ps.setString(2, stud.getName());
			ps.setString(3, stud.getFname());
			ps.setInt(4, stud.getGroupId());
			ps.setInt(5, stud.getStudId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}//updateGroup...
	
public int deleteStudent(int studId){
		
		try {
			ps = conn.prepareStatement("DELETE FROM `stud`.`students` WHERE `student_id`=?;");
			
			ps.setInt(1, studId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}//deleteGroup...

	public String[] getColumnsStudents() {
		return this.COLUMNS_STUDENTS;
	}
	public String[] getColumnsGroups() {
		return this.COLUMNS_GROUPS;
	}
	public String[] getColumnsSpecialty() {
		return this.COLUMNS_SPEC;
	}
	public String[] getColumnsFaculty() {
		return this.COLUMNS_FACULTY;
	}
	public void closeAll(){
		try {
			result.close();
			stmt.close();
			ps.close();
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
