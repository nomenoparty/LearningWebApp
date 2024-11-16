package service.impl;

import java.util.ArrayList;

import dao.impl.ClassroomDAO;
import dao.impl.UserDAO;
import model.ClassroomsModel;
import service.I_ClassroomsService;

public class ClassroomsService implements I_ClassroomsService{
	private ClassroomDAO classroomDao = new ClassroomDAO();
	@Override
	public ArrayList<ClassroomsModel> getClassroomsByStudentId(int studentId) {	
		return classroomDao.getClassroomsByStudentId(studentId);
	}
	@Override
	public ClassroomsModel selectById(int id) {
		return classroomDao.selectById(id);
	}

	@Override
	public ArrayList<ClassroomsModel> getClassroomsByTeacherId(int teacherId) {
		return classroomDao.getClassroomsByTeacherId(teacherId);
	}

	@Override
	public int insertClassroom(ClassroomsModel classroomsModel) {
		return classroomDao.insert(classroomsModel);
	}

	public ClassroomsModel selectByIdAndStudentID(int classroomID, int userID) {
		return classroomDao.selectByIdAndStudent(classroomID, userID);
	}

	public ClassroomsModel selectByIdAndTeacherID(int classroomID, int userID) {
		return classroomDao.selectByIdAndTeacher(classroomID, userID);
	}
}
