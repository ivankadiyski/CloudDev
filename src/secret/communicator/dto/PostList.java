package secret.communicator.dto;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "postlist")
public class PostList {

	private Collection<Post> runtimeComponents;

	@XmlElementWrapper(name = "posts")
	@XmlElement(name = "post")
	public Collection<Post> getRuntimeComponents() {
		return runtimeComponents;
	}

	public void setRuntimeComponents(Collection<Post> runtimeComponents) {
		this.runtimeComponents = runtimeComponents;
	}

}
