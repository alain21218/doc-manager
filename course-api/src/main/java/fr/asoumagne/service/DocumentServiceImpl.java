package fr.asoumagne.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.asoumagne.dao.DocumentDAO;
import fr.asoumagne.model.Document;

@Service
public class DocumentServiceImpl implements DocumentService {

	private DocumentDAO documentDAO;
	
	public void setDocumentDAO(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}
	
	@Override
	@Transactional
	public void addDocument(Document document) {
		this.documentDAO.addDocument(document);
	}

	@Override
	@Transactional
	public void updateDocument(Document document) {
		this.documentDAO.updateDocument(document);
	}

	@Override
	@Transactional
	public List<Document> listDocuments() {
		return this.documentDAO.listDocuments();
	}

	@Override
	@Transactional
	public Document getDocumentById(int id) {
		return this.documentDAO.getDocumentById(id);
	}

	@Override
	public void removeDocument(int id) {
		this.documentDAO.removeDocument(id);
	}
	
	
}
