package prac4;

public class TourGuide {

	private Tour tour;
	
	public TourGuide(Tour tour) {
		this.tour = tour;
	}
	
	public void sightseeing() {
		 tour.sightseeing();
	}

	public void leisure() {
		tour.leisure();		
	}

	

	
	
}
