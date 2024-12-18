package generative_patterns.builder;

public class Builder {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar.Builder("Audi")
                .setColor("green")
                .setMaxSpeed(300)
                .build();
        System.out.println(sportCar.getName() + " " + sportCar.getColor() + " " + sportCar.getMaxSpeed());
    }
}

class SportCar {
    private final String name;
    private final String color;
    private final int maxSpeed;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    private SportCar(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
    }

    static class Builder {
        private final String name;
        private String color;
        private int maxSpeed;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public SportCar build() {
            return new SportCar(this);
        }
    }

}

