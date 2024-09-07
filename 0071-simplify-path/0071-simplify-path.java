class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                // Skip empty components and current directory
                continue;
            } else if (component.equals("..")) {
                // Pop the stack if ".." is encountered and stack is not empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push the component to the stack
                stack.push(component);
            }
        }

        // Build the simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        while (!stack.isEmpty()) {
            simplifiedPath.insert(0, "/" + stack.pop());
        }

        // Edge case for root path
        return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();
    }
}