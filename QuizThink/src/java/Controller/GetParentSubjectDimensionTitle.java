/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.SubjectDimensionDAO;
import Model.SubjectDimension;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kimdi
 */
public class GetParentSubjectDimensionTitle {
    protected List<SubjectDimension> getParentSubjectDimensionTitle( int subjectId) {
        SubjectDimensionDAO subjectDimensionDAO = new SubjectDimensionDAO();
        List<SubjectDimension> parentSubjectDimensions = new ArrayList<>();

        SubjectDimension subjectDimension = subjectDimensionDAO.getSubjectDimensionByID(subjectId);
        while (subjectDimension != null) {
            parentSubjectDimensions.add(subjectDimension);
            subjectDimension = subjectDimensionDAO.getParentSubjectDimension(subjectDimension.getParentSDId());
        }

        return parentSubjectDimensions;
    }
}
