package net.emecas.gpluspager.parsing;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
	
//	21:10:12.873 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>kind plus#activity class java.lang.String
//	21:10:12.873 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>etag "jb1Xzanox6i8Zyse4DcYD8sZqy0/Jr8P4fHNrKcxOQEWoBI5Vua4bwg" class java.lang.String
//	21:10:12.874 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>title #ocaml class java.lang.String
//	21:10:12.874 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>published 2018-07-25T22:30:28.761Z class java.lang.String
//	21:10:12.874 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>updated 2018-07-25T22:30:28.761Z class java.lang.String
//	21:10:12.874 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>id z13gzrvghrfqevk1123mxx54clywfjbak04 class java.lang.String
//	21:10:12.874 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>url https://plus.google.com/100964109436697466633/posts/6c27HkBbYCp class java.lang.String
//	21:10:12.874 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>actor {id=100964109436697466633, displayName=Emerson Castaneda, url=https://plus.google.com/100964109436697466633, image={url=https://lh5.googleusercontent.com/-HxRU5p93XKE/AAAAAAAAAAI/AAAAAAAABdw/kncsDAV8nP4/photo.jpg?sz=50}, verification={adHocVerified=UNKNOWN_VERIFICATION_STATUS}} class java.util.LinkedHashMap
//	21:10:12.874 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>verb post class java.lang.String
//	21:10:12.874 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>object {objectType=note, actor={verification={adHocVerified=UNKNOWN_VERIFICATION_STATUS}}, content=<a rel="nofollow" class="ot-hashtag" href="https://plus.google.com/s/%23ocaml/posts">#ocaml</a>, url=https://plus.google.com/100964109436697466633/posts/6c27HkBbYCp, replies={totalItems=0, selfLink=https://content.googleapis.com/plus/v1/activities/z13gzrvghrfqevk1123mxx54clywfjbak04/comments}, plusoners={totalItems=0, selfLink=https://content.googleapis.com/plus/v1/activities/z13gzrvghrfqevk1123mxx54clywfjbak04/people/plusoners}, resharers={totalItems=0, selfLink=https://content.googleapis.com/plus/v1/activities/z13gzrvghrfqevk1123mxx54clywfjbak04/people/resharers}, attachments=[{objectType=article, displayName=MirageOS, content=MirageOS is a library operating system that constructs unikernels for secure, high-performance network applications across a variety of cloud computing and mobile platforms. Code can be developed on a normal OS such as Linux or MacOS X, and then compiled into a fully-standalone, specialised ..., url=https://mirage.io/}]} class java.util.LinkedHashMap
//	21:10:12.874 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>provider {title=Google+} class java.util.LinkedHashMap
//	21:10:12.874 [main] INFO com.example.demo.parsing.PlusDataParserTest - =>access {kind=plus#acl, description=Public, items=[{type=public}]} class java.util.LinkedHashMap

	private String kind;
	private String etag;
	private String title;
	private String published;
	private String id;
	private String verb;
	private String url;
	
//	17:31:58.054 [main] INFO com.example.demo.parsing.PlusDataParserTest - --> actor [id, displayName, url, image, verification] class java.util.LinkedHashMap
//	17:31:58.054 [main] INFO com.example.demo.parsing.PlusDataParserTest - --> object [objectType, actor, content, url, replies, plusoners, resharers, attachments] class java.util.LinkedHashMap
//	17:31:58.054 [main] INFO com.example.demo.parsing.PlusDataParserTest - --> provider [title] class java.util.LinkedHashMap
//	17:31:58.054 [main] INFO com.example.demo.parsing.PlusDataParserTest - --> access [kind, description, items] class java.util.LinkedHashMap
//	
	private Actor actor;
//	private GPObject object;
//	private Provider provider;
//	private Access access;
	private LinkedHashMap<String,?> object;
	private Provider provider;
	private Access access;	
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LinkedHashMap<String,?> getObject() {
		return object;
	}

	public void setObject(LinkedHashMap<String,?> object) {
		this.object = object;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return String.format(
				"Item [kind=%s, etag=%s, title=%s, published=%s, id=%s, actor=%s, verb=%s, url=%s, object=%s, provider=%s, access=%s]",
				kind, etag, title, published, id, actor, verb, url, object, provider, access);
	}
}
