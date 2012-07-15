package secret.communicator.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messages")
public class Message extends Post {

	private String message;

	public Message() {
		super();
	}

	public Message(String message) {
		super();
		this.setMessage(message);
	}

	@XmlElement
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
