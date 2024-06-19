package simple;

import simple.House.HouseBuilder;

public class AguBuilderDesign {
	
	public static void main(String[] args) {
		System.out.println("Refer if u forgot "  + AbtInnerClass.class);
		
		HouseBuilder builder = new HouseBuilder(2, 7).setGarage(true).setSwimmingPool(true).setGarden(true);
		House house = builder.build();
		System.out.println(house);
	}
}

class House {
	private int floors;
    private int rooms;
    private boolean hasGarage;
    private boolean hasSwimmingPool;
    private boolean hasGarden;

    private House(HouseBuilder builder) { 
    	// it should be private, if the Builder is inside this class, other class should not access this
    	// it should be default, if Builder is outside the class(not great)
        this.floors = builder.floors;
        this.rooms = builder.rooms;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarden = builder.hasGarden;
    }

    public int getFloors() {
		return floors;
	}
	public int getRooms() {
		return rooms;
	}
	public boolean isHasGarage() {
		return hasGarage;
	}
	public boolean isHasSwimmingPool() {
		return hasSwimmingPool;
	}
	public boolean isHasGarden() {
		return hasGarden;
	}

    @Override
	public String toString() {
		return "House [floors=" + floors + ", rooms=" + rooms + ", hasGarage=" + hasGarage + ", hasSwimmingPool="
				+ hasSwimmingPool + ", hasGarden=" + hasGarden + "]";
	}

	public static class HouseBuilder {
        private int floors;
        private int rooms;
        private boolean hasGarage;
        private boolean hasSwimmingPool;
        private boolean hasGarden;

        public HouseBuilder(int floors, int rooms) { // v can have mandatory fields
            this.floors = floors;
            this.rooms = rooms;
        }

        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
