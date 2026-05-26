class Solution {
    public class Car implements Comparable<Car> {
        int position;
        int speed;

        public Car(int p, int s) {
            position = p;
            speed = s;
        }

        @Override
        public int compareTo(Car c) {
            return Integer.compare(this.position, c.position);
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        
        Collections.sort(cars);
        
        int carFleet = 1;
        float previousCarTime = (float) (target - cars.get(cars.size() - 1).position)/ cars.get(cars.size() - 1).speed;

        for(int i = 1; i < cars.size(); i++) {
            Car currentCar = cars.get(cars.size() - 1 -i);

            if ((target - currentCar.position) > (previousCarTime * currentCar.speed)) {
                carFleet++;
                previousCarTime = (float) (target - currentCar.position)/ currentCar.speed;
                System.out.println(target - currentCar.position);
                System.out.println(currentCar.speed);
                System.out.println(previousCarTime);
            }
        }
        return carFleet;
    }
}
