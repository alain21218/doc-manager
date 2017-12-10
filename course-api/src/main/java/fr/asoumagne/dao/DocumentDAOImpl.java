package fr.asoumagne.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.asoumagne.model.Document;

@Repository
public class DocumentDAOImpl implements DocumentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DocumentDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFacory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void addDocument(Document document) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(document);
		logger.info("La sauvegarde du document est réussie, Document :" + document);
	}

	@Override
	public void updateDocument(Document document) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(document);
		logger.info("La mise à jour du document est réussie, Document :" + document);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> listDocuments() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Document> documentsList = session.createQuery("from Documents").list();
		for(Document document : documentsList) {
			logger.info("Document List::" + document);
		}
		return documentsList;
	}

	@Override
	public Document getDocumentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Document document = (Document) session.load(Document.class, new Integer(id));
		logger.info("Chargement du document est réussi, Document : " + document);
		return document;
	}

	@Override
	public void removeDocument(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Document document = (Document) session.load(Document.class, new Integer(id));
		if(null != document) {
			session.delete(document);
		}
		logger.info("La suppression du document est réussie, Document : " + document);
	}

}
