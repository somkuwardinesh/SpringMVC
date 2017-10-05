package spring.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import spring.model.Student;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class StudentPDFView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment: filename=\"student.pdf\"");
		
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>)model.get("studentList");
		
		Paragraph head = new Paragraph(new Chunk("Generate Pdf USing Spring Mvc",FontFactory.getFont(FontFactory.HELVETICA, 30)));
		Paragraph by = new Paragraph(new Chunk("Author " +"Dinesh" ,FontFactory.getFont(FontFactory.HELVETICA, 20)));
		  
		  document.add(head);
		  document.add(by);

		
		
		Table table = new Table(4);
		table.addCell("ID");
		table.addCell("NAME");
		table.addCell("CITY");
		table.addCell("AGE");
		
		for (Student student : list) {
			
			table.addCell(String.valueOf(student.getId()));
			table.addCell(student.getName());
			table.addCell(student.getCity());
			table.addCell(student.getAge());
			
		}
		
		document.add(table);
	}

}

