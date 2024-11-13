package controller.clients;

import model.AssignmentsModel;
import service.impl.AssignmentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/class_assignments"})
public class ClassAssignmentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AssignmentService assignmentService = new AssignmentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classroomID = Integer.parseInt(request.getParameter("classroomID"));
        ArrayList<AssignmentsModel> notSubmitted = assignmentService.getNotSubmittedAssignmentsOnTime(3, classroomID);
        ArrayList<AssignmentsModel> submitted = assignmentService.getSubmittedAssignments(3, classroomID);
        ArrayList<AssignmentsModel> overdue = assignmentService.getOverdueAssignments(3, classroomID);

        request.setAttribute("notSubmitted", notSubmitted);
        request.setAttribute("submitted", submitted);
        request.setAttribute("overdue", overdue);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clients/pages/class/class_assignments.jsp");
        dispatcher.forward(request, response);
    }
}