class RandomizedSet {

    ArrayList<Integer> list;
    Map<Integer, Integer> map;
    
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean search(int val)
    {
        return map.containsKey(val);
    }
    
    public boolean insert(int val) {
        if(search(val)) return false;
        list.add(val);
        map.put(val, list.size()-1);
        return true;
        
    }
    
    public boolean remove(int val) {
        if(!search(val)) return false;
        int idx = map.get(val);
        list.set(idx, list.get(list.size() - 1));
        map.put(list.get(list.size() - 1), idx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int r = rand.nextInt(list.size());
        return list.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */