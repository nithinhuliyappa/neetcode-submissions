class TimeMap {

    record TimeValue(int timestamp, String val){};
    Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) { 

        if(!map.containsKey(key)){
            return "";
        } else {
            List<TimeValue> timeValue = map.get(key);
            int left = 0;
            int right = timeValue.size()-1;
            String val = "";

            while(left<=right){
                int mid = left + (right-left)/2;

                if(timeValue.get(mid).timestamp()<=timestamp){
                    val = timeValue.get(mid).val();
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            return val;
        }
        
    }
}
