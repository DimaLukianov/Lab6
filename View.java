package Lab6;

import java.util.ArrayList;

public class View {
	private Model model = new Model();
	
	public void printAllStudents(){
		// All students
		System.out.print("ALL STUDENTS:");
		ArrayList<Students> records = new ArrayList<Students>();
		records = model.getAllStudents();
		System.out
		.println("\n__________________________________________________________________________");
		for (String colName : model.getColumnsStudents()) {
			System.out.print(colName + "\t\t");
		}
		System.out
				.println("\n__________________________________________________________________________");
		for (Students s : records) {
			System.out.println(s.getSurName() + "\t\t" + s.getName() + "\t\t"
					+ s.getFname() + "\t\t" + s.getStudId() + "\t\t"
					+ s.getGroupId());
		}
	}
	public void printAllGroups(){
		// All groups
		System.out.print("ALL GROUPS:");
		ArrayList<Groups> records = new ArrayList<Groups>();
		records = model.getAllGroups();

		System.out.println("\n_________________________________________");
		for (String colName : model.getColumnsGroups()) {
			System.out.print(colName + "\t");
		}
		System.out.println("\n_________________________________________");
		for (Groups s : records) {
			System.out.println(s.getGroupId() + "\t\t" + s.getGroupName()
					+ "\t\t" + s.getSpecId());
		}
	}
	public void printAllSpecialty(){
		// All spec
		System.out.print("ALL SPECIALTY:");
		ArrayList<Specialty> records = new ArrayList<Specialty>();
		records = model.getAllSpecialty();
			System.out
				.println("\n__________________________________________________________________________");
		for (String colName : model.getColumnsSpecialty()) {
			System.out.print(colName + "\t\t");
		}
		System.out
				.println("\n__________________________________________________________________________");
		for (Specialty s : records) {
			System.out.println(s.getSpecId() + "\t\t" + s.getSpecCode()
					+ "\t\t" + s.getSpecName() + "\t\t" + s.getFacultyId());
		}		
	}
	public void printAllFaculty(){
		// All fuculty
		System.out.print("ALL FACULTY:");
		ArrayList<Faculty> records = new ArrayList<Faculty>();
		records = model.getAllFaculty();

		System.out
				.println("\n___________________________");
		for (String colName : model.getColumnsFaculty()) {
			System.out.print(colName + "\t");
		}
		System.out
				.println("\n___________________________");
		for (Faculty s : records) {
			System.out.println(s.getFacultyId() + "\t\t" + s.getFacultyName());
		}
	}
	public void insertStudent(String surName, String name, String fName, int groupId){
		Students stud = new Students(surName, name, fName, 0,groupId);
		if(model.insertStudent(stud)!=0)System.out.println("Success!!!");
	}
	public void updateStudent(int studId, String surName, String name, String fName, int groupId){
		Students stud = new Students(surName, name, fName, studId, groupId);
		if(model.updateStudent(stud)!=0)System.out.println("Success!!!");
	}
	public void deleteStudent(int studId){
		if(model.deleteStudent(studId)!=0)System.out.println("Success!!!");
	}
	public void closeAll(){
		model.closeAll();
	}

	public static void main(String[] args) {
		View v = new View();
//		v.printAllStudents();
//		v.printAllGroups();
//		v.printAllSpecialty();
//		v.printAllFaculty();
//		v.insertStudent("Пупкін","Іван","Іванович",2);
//		v.updateStudent(5,"Іванов","Василь","Іванович",2);
//		v.deleteStudent(5);
//		v.closeAll();

	}

}
