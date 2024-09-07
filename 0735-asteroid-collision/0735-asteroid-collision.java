class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
         Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean isDestroyed = false;

            // Handle collisions with the stack top
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -asteroid) {
                    // Pop the top of the stack if the current asteroid is larger
                    stack.pop();
                } else if (top == -asteroid) {
                    // Both asteroids are equal and destroy each other
                    stack.pop();
                    isDestroyed = true;
                    break;
                } else {
                    // The current asteroid is destroyed
                    isDestroyed = true;
                    break;
                }
            }

            // Push the current asteroid if it's not destroyed
            if (!isDestroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
        
    }
}