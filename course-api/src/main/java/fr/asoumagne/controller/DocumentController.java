
package fr.asoumagne.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.asoumagne.model.Document;
import fr.asoumagne.service.DocumentService;

@RestController
@EnableAutoConfiguration
public class DocumentController {
	
	public static void main (String[] args) {
		SpringApplication.run(DocumentController.class, args);
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	String upload(@RequestBody String b64) throws FileNotFoundException, IOException {
		
		byte [] barr = Base64.getDecoder().decode(b64); 
		
		/*try(FileOutputStream fos = new FileOutputStream("C:\\Users\\Clara\\Documents\\test")) {
			fos.write(barr);
			fos.close();
		}
		*/
		return b64;
	}
	
	/* 
	private DocumentService documentService;
	
	@Autowired(required=true)
	@Qualifier(value="documentService")
	public void setDocumentService(DocumentService ds) {
		this.documentService = ds;
	}
	
	@RequestMapping(value = "/documents", method = RequestMethod.GET)
	public String listDocuments(Model model) {
		model.addAttribute("document", new Document());
		model.addAttribute("listDocuments", this.documentService.listDocuments());
		return "document";
	}
	
	@RequestMapping(value = "/document/add", method = RequestMethod.POST)
	public String addDocument(@ModelAttribute("document") Document document) {
		if(document.getDocid() == 0) {
			// nouveau document
			this.documentService.addDocument(document);
		}else {
			// document existant
			this.documentService.updateDocument(document);
		}
		return "redirect:/documents";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeDocument(@PathVariable("id") int id) {
		this.documentService.removeDocument(id);
		return "redirect:/documents";
	}
	
	@RequestMapping("/edit/{id}")
	public String editDocument(@PathVariable("id") int id, Model model) {
		model.addAttribute("document", this.documentService.getDocumentById(id));
		model.addAttribute("listDocuments", this.documentService.listDocuments());
		return "document";
	} */

}
