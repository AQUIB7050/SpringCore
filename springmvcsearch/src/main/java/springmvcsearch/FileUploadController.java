package springmvcsearch;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping("/uploadFile")
	public String uploadFile() {
		return "uploadFile";
	}

	@RequestMapping(path = "/fileUploaded", method = RequestMethod.POST)
	public String fileUploaded(@RequestParam("uploadedFile") CommonsMultipartFile file, HttpSession s, Model m) {

		// we can do many stufffs with the CommonsMultipartFile, like :-
		// file.getContentType();
		// file.getOriginalFilename();
		// file.getStorageDescription();
		// etc

		// extracting data
		byte data[] = file.getBytes();

		// getting file path using HttpSession, and fileName using CommonsMultipartFile
		String path = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator
				+ "images" + File.separator + file.getOriginalFilename();

		// STORING DATA FROM SERVER
		try {

			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();

			m.addAttribute("msg", "File Uploaded Successfully");
			m.addAttribute("fileName", file.getOriginalFilename());

			System.out.println(file.getOriginalFilename() + " uploaded");

		} catch (Exception e) {
			System.out.println("uploading error");
		}
		return "fileUpload_successful";
	}
}
