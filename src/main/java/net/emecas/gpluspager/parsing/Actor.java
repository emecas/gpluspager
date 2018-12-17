package net.emecas.gpluspager.parsing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Actor {
	//actor {id=100964109436697466633, displayName=Emerson Castaneda, url=https://plus.google.com/100964109436697466633, image={url=https://lh5.googleusercontent.com/-HxRU5p93XKE/AAAAAAAAAAI/AAAAAAAABdw/kncsDAV8nP4/photo.jpg?sz=50}, verification={adHocVerified=UNKNOWN_VERIFICATION_STATUS}}
	private String id; 
	private String displayName; 
	private String url; 
	private Image image; 
	private Verification verification;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Verification getVerification() {
		return verification;
	}
	public void setVerification(Verification verification) {
		this.verification = verification;
	}
	@Override
	public String toString() {
		return String.format("Actor [id=%s, displayName=%s, url=%s, image=%s, verification=%s]", id, displayName, url,
				image, verification);
	}
			
	

}
