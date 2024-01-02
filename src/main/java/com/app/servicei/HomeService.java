package com.app.servicei;

import java.util.List;

import com.app.model.Student;

public interface HomeService {

	public void saveData(Student s);

	public int loginCheck(String un, String ps);
	public List displayAllData();
	public Student editData(Student s);
	public void updateData(Student s);
	public int deleteData(int uid);
}
