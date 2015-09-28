package alertme.services;

import org.openspaces.core.GigaSpace;

public class FeedService {

	private GigaSpace space;

	public FeedService(GigaSpace space) {
		this.space = space;
	}

	public GigaSpace getSpace() {
		return space;
	}

}
