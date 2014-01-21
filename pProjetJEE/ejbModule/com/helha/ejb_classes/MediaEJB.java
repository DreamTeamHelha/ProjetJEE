package com.helha.ejb_classes;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.helha.ejb_interfaces.MediaEJBRemote;
import com.helha.entities.File;
import com.helha.entities.Image;
import com.helha.entities.Media;
import com.helha.entities.Video;

@Stateless
public class MediaEJB implements MediaEJBRemote {

	@PersistenceContext(unitName="dbg3")
	private EntityManager em;
	
	@Override
	public void addImage(Image i) {
		em.persist(i);
		
	}

	@Override
	public void addVideo(Video v) {
		em.persist(v);
		
	}

	@Override
	public void addFile(File f) {
		em.persist(f);
	}

	@Override
	public void removeMedia(Media m) {
		em.remove(em.find(Media.class, m.getId()));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getMedias() {
		return em.createNamedQuery("SELECT m FROM Media m").getResultList();
	}

}
