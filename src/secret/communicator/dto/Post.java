package secret.communicator.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
public class Post {
	private Date postDate;

	public Post() {
		super();
		postDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		postDate = new Date();
		System.out.println(dateFormat.format(postDate));
	}
	
	@XmlElement
	public Date getPostDate() {
		return postDate;
	}

}
