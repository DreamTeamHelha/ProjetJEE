package com.helha.ejb_interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.helha.entities.File;
import com.helha.entities.Image;
import com.helha.entities.Media;
import com.helha.entities.Video;

@Remote
public interface MediaEJBRemote {

	public void addImage(Image i);
	public void addVideo(Video v);
	public void addFile(File f);
	public void removeMedia(Media m);
	public List<Media> getMedias();
	
	
}
