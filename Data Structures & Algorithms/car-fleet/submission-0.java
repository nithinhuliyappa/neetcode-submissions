class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
        // After pairing and sorting
        // [{0,1}, {3,3}, {5,1}, {8,4}, {10,2}]

        float[] time = new float[target + 1];

        for (int i = 0; i < position.length; i++) {
            float curtime = (float) (target - position[i]) / speed[i];
            time[position[i]] = curtime;
        }

        int fleets = 0;
        float max = time[target];

        for (int i = target - 1; i >= 0; i--) {
            if (time[i] > max) {
                fleets++;
                max = time[i];
            }
        }

        return fleets;
    }
}