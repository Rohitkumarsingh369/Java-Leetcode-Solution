/*class RandomizedSet {

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        
    }
    
    public boolean remove(int val) {
        
    }
    
    public int getRandom() {
        
    }
}*/

class RandomizedSet {
	// map contains value with it's index
	Map<Integer, Integer> map;
	// contains values
	List<Integer> allValues;

	public RandomizedSet() {
		map = new HashMap<>();
		allValues = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) return false;

		allValues.add(val);
		// keep track of index in array
		map.put(val, allValues.size() - 1);

		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) return false;

		// set the index of val with last element
		allValues.set(map.get(val), allValues.get(allValues.size() - 1));
		// update index in map
		map.put(allValues.get(allValues.size() - 1), map.get(val));

		map.remove(val);
		// O(1) remove
		allValues.remove(allValues.size() - 1);

		return true;
	}

	public int getRandom() {
		// [0, size - 1]
		return allValues.get((int)(Math.random() * allValues.size()));
	}
}