package algorithms;

import java.util.Scanner;

/**
 * Created by 220333 on 11/23/2015.
 */
public class Ghost {
    int town;
    int street;
    int house;
    int apartment;

    public Ghost(int town, int street, int house, int apartment) {
        this.town = town;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }
    private int findGCD(int a, int b) {
        if(b == 0) {
            return a;
        }

        return findGCD(b, a % b);
    }




    public boolean townStreetDiffDivisibleByThree(int t, int s) {
        return (Math.abs(t - s) % 3 == 0);
    }

    private boolean houseApartmentGCDIsOne(int h, int a) {
        return (findGCD(h, a) == 1);
    }

    private boolean streetHouseSumDivisibleByFive(int s, int h) {
        return ((s + h) % 5 == 0);
    }

    private boolean townHouseProdDivisibleByFour(int t, int h) {
        return ((t * h) % 4 == 0);
    }

    public long findGhosts(int towns, int streets, int houses, int apartments) {
        long ghosts = 0;
        for(int town = 1; town <= towns; town++) {
            for(int street = 1; street <= streets; street++) {
                if(townStreetDiffDivisibleByThree(town, street)) {
                    for(int house = 1; house <= houses; house++) {
                        if(townHouseProdDivisibleByFour(town, house) && streetHouseSumDivisibleByFive(street, house)) {
                            for(int apartment = 1; apartment <= apartments; apartment++) {
                                if(houseApartmentGCDIsOne(house, apartment)) {
                                    ghosts += 1;
                                }
                            }
                        }

                    }
                }

            }
        }

        return ghosts;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int town = Math.abs(in.nextInt());
        int street = Math.abs(in.nextInt());
        int house = Math.abs(in.nextInt());
        int apartment = Math.abs(in.nextInt());

        Ghost ghost = new Ghost(town, street, house, apartment);

        System.out.println(ghost.findGhosts(town, street, house, apartment));

    }
}
