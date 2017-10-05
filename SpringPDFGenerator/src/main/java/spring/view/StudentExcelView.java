package spring.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import spring.model.Student;

public class StudentExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment: filename=\"student.xls\"");
		
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>)model.get("studentList");
		
		Sheet sheet=workbook.createSheet();
		Row header =sheet.createRow(0);
		
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("NAME");
		header.createCell(2).setCellValue("CITY");
		header.createCell(3).setCellValue("AGE");

		int rowNum = 1;
		
		for (Student  student : list) {
		Row row=sheet.createRow(rowNum++);
		
		row.createCell(0).setCellValue(student.getId());
		row.createCell(1).setCellValue(student.getName());
		row.createCell(2).setCellValue(student.getCity());
		row.createCell(3).setCellValue(student.getAge());
			
		}
		
	}
	

}

